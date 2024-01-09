

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Decryption {
    static int lenght = Data.ALPHABET_LENGHT;
    static char[] alphabet = Data.ALPHABET;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int next = 0;
        char[] buffer = new char[100000];
        try (Reader reader = new FileReader(scanner.nextLine());
             Writer writer = new FileWriter(scanner.nextLine())) {
            int temp = scanner.nextInt();
            int key = temp <= lenght ? temp : temp - (lenght * (temp / lenght));
            if (key <= 0) System.out.println("Ключ должен быть больше нуля");
            while (reader.ready()) {
                int realLenght = reader.read(buffer);
                for (int i = realLenght; i >= 0; i--) {
                    next = lenght-1;

                    while (buffer[i] != alphabet[next]) {
                        if (next - key <= 0) {
                            next = lenght + next - key;
                            break;
                        }
                        next--;
                    }
                    switch (buffer[i]) {
                        case 13 -> reader.skip(1);
                        case 10 -> writer.write(10);
                        default -> buffer[i] = alphabet[next - key];
                    }
                }
                writer.write(buffer, 0, realLenght);
            }
        }
    }
}


