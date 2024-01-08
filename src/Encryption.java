package src;


import java.io.*;
import java.util.Scanner;

public class Encryption {
    static char newLine = 10;
    static char newReturn = 13;
    private static final char[] ALPHABET = {'�', '�', '�', '�', '�', '�', '�', '�', '�',
            '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�',
            '�', '�', '�', '�', '�', '�', '-', '.', ',', '�', '�', '"', '\'', ':', '!', '?', ' ', '�',
            '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�',
            '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�'};

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int next = 0;
        char[] buffer = new char[100000];
        try (Reader reader = new FileReader(scanner.nextLine());
             Writer writer = new FileWriter(scanner.nextLine())) {
            int temp = scanner.nextInt();
            int key = temp <= ALPHABET.length ? temp : temp - (ALPHABET.length * (temp / ALPHABET.length));
            if (key <= 0) System.out.println("���� ������ ���� ������ ����");
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
                    buffer[i] = ALPHABET[next + key];
                }
                writer.write(buffer, 0, realLenght);
            }
        }
    }
}







