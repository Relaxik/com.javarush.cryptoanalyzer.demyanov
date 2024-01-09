

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Encryption {
    static int lenght = Data.ALPHABET_LENGHT;
    static char[] alphabet = Data.ALPHABET;
    static int next;
    static Scanner scanner = new Scanner(System.in);
    static char[] buffer = new char[100000];
    public static void main(String[] args) throws IOException {

        try (Reader reader = new FileReader(scanner.nextLine());
             Writer writer = new FileWriter(scanner.nextLine())) {
            int temp = scanner.nextInt();
            int key = temp <= lenght ? temp : temp - (lenght * (temp / lenght));
            while (reader.ready()) {
                int realLenght = reader.read(buffer);
                for (int i = 0; i < realLenght; i++) {
                    next = 0;
                    while (buffer[i] != alphabet[next]) {
                        if (next + key >= lenght) {
                            next = next + key - lenght;
                            break;
                        }
                        next++;
                    }
                    switch (buffer[i]) {
                        case 13 -> reader.skip(1);
                        case 10 -> writer.write(10);
                        default -> buffer[i] = alphabet[next + key];
                    }
                }
                writer.write(buffer, 0, realLenght);
            }
        }
    }
}







