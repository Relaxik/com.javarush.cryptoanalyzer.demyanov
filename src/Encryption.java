package src;


import java.io.*;
import java.util.Scanner;

public class Encryption {
    static char newLine = '\n';
    static char newReturn = '\r';
    private static final char[] ALPHABET = {'�', '�', '�', '�', '�', '�', '�', '�', '�',
            '�','�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�',
            '�', '�', '�', '�', '�', '�', '.', ',', '�', '�', '"', '\'', ':', '!', '?', ' ', '�',
            '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�',
            '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�'};


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        try (Reader reader = new FileReader(scanner.nextLine());
             Writer writer = new FileWriter(scanner.nextLine())) {
            int key = scanner.nextInt();
            int next = 0;
            char[] buffer = new char[100000];
            char[] codedBuffer = new char[buffer.length];
            while (reader.ready()) {
                int realLenght = reader.read(buffer);
                for (int i = 0; i < realLenght; i++) {
                    next = 0;
                    while (buffer[i] != ALPHABET[next]) {

                        if (next + key >= ALPHABET.length) {
                            next = next + key - ALPHABET.length;
                            break;
                        }
                        next++;
                    }
                    codedBuffer[i] = ALPHABET[next+key];
                }
                writer.write(codedBuffer, 0, realLenght);
            }
        }
    }
}







