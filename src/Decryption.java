
import java.io.*;

public class Decryption {
    public String doDecrypt(String message) {
        try (Reader reader = new FileReader(Data.fileReadPath);
             Writer writer = new FileWriter(Data.fileWritePath)) {
           Data.key = Data.temp <= Data.ALPHABET_LENGHT ? Data.temp : Data.temp - (Data.ALPHABET_LENGHT * (Data.temp / Data.ALPHABET_LENGHT));
            while (reader.ready()) {
                int realLenght = reader.read(Data.buffer);
                for (int i = realLenght; i >= 0; i--) {
                    Data.index = Data.ALPHABET_LENGHT -1;
                    while (Data.buffer[i] != Data.ALPHABET[Data.index]) {
                        if (Data.index == 0) {
                            break;
                        }
                        Data.index--;
                    } if (Data.index - Data.key < 0) {
                       Data.index = Data.ALPHABET_LENGHT + Data.index;
                    }
                    switch (Data.buffer[i]) {
                        case 13 -> reader.skip(1);
                        case 10 -> writer.write(10);
                        default -> Data.buffer[i] = Data.ALPHABET[Data.index - Data.key];
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
}

