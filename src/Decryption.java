

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Decryption {
    public String doDecrypt(String message) {
        try (Reader reader = new FileReader(Data.fileReadPath);
             Writer writer = new FileWriter(Data.fileWritePath)) {
           Data.key = Data.temp <= Data.ALPHABET_LENGHT ? Data.temp : Data.temp - (Data.ALPHABET_LENGHT * (Data.temp / Data.ALPHABET_LENGHT));
            while (reader.ready()) {
                int realLenght = reader.read(Data.buffer);
                for (int i = realLenght; i >= 0; i--) {
                    Data.next = Data.ALPHABET_LENGHT - 1;
                    while (Data.buffer[i] != Data.ALPHABET[Data.next]) {
                        if (Data.next - Data.key <= 0) {
                            Data.next = Data.ALPHABET_LENGHT + Data.next - Data.key;
                            break;
                        }
                        Data.next--;
                    }
                    switch (Data.buffer[i]) {
                        case 13 -> reader.skip(1);
                        case 10 -> writer.write(10);
                        default -> Data.buffer[i] = Data.ALPHABET[Data.next - Data.key];
                    }
                }
                writer.write(Data.buffer, 0, realLenght);
            }

        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        System.out.println(message);
        return message;
    }
    //    public static void main(String[] args) {
//        Decryption decryption = new Decryption();
//        decryption.doDecrypt("se");
//    }
}

