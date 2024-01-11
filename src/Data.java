
import java.io.*;
import java.util.Scanner;

public class Data {
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '-', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', 'А',
            'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р',
            'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};

    public static final int ALPHABET_LENGHT = ALPHABET.length;
    public static Scanner scanner = new Scanner(System.in);
    public static int next;
    public static int key;
    public static char[] buffer = new char[100000];
    public static String fileReadPath ;
    public static String fileWritePath;
    public static String success = "Файл успешно";
    public static String encrypt = " зашифрован";
    public static String decrypt = " дешифрован";
    public static int temp;

}




