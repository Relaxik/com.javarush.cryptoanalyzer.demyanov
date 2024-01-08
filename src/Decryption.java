package src;

import java.io.*;
import java.util.Scanner;

public class Decryption {

    private static final char[] ALPHABET = {'à', 'á', 'â', 'ã', 'ä', 'å', '¸', 'æ', 'ç',
            'è', 'é', 'ê', 'ë', 'ì', 'í', 'î', 'ï', 'ð', 'ñ', 'ò', 'ó', 'ô', 'õ', 'ö', '÷', 'ø', 'ù',
            'ú', 'û', 'ü', 'ý', 'þ', 'ÿ', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', 'À',
            'Á', 'Â', 'Ã', 'Ä', 'Å', '¨', 'Æ', 'Ç', 'È', 'É', 'Ê', 'Ë', 'Ì', 'Í', 'Î', 'Ï', 'Ð',
            'Ñ', 'Ò', 'Ó', 'Ô', 'Õ', 'Ö', '×', 'Ø', 'Ù', 'Ú', 'Û', 'Ü', 'Ý', 'Þ', 'ß'};


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (Reader reader = new FileReader(scanner.nextLine());
             Writer writer = new FileWriter(scanner.nextLine())) {
            int key = scanner.nextInt();
            int next = 0;
            char[] buffer = new char[100000];
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
                    buffer[i] = ALPHABET[next - key];
                }
                writer.write(buffer, 0, realLenght);
            }
        }
    }
}


