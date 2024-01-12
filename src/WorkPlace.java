import java.io.*;


public class WorkPlace {

    public static void main(String[] args) {
        Encryption encryption = new Encryption();
        Decryption decryption = new Decryption();
        BruteForce bruteForce = new BruteForce();
        System.out.println("Выберите действие\n" +
                "1. Шифрование текста\n" +
                "2. Дешифровка текста\n" +
                "3. Подбор ключа (BruteForce)");
        int numberOfAction = Integer.parseInt(Data.scanner.nextLine());
        System.out.println("Выберите иходный файл");
        Data.fileReadPath = Data.scanner.nextLine();
        System.out.println("Выберите путь для сохранения файла");
        Data.fileWritePath = Data.scanner.nextLine();
        System.out.println("Выберите ключ");
        Data.temp = Integer.parseInt(Data.scanner.nextLine());
        switch (numberOfAction) {
            case 1 -> encryption.doEncrypt(Data.success + Data.encrypt);
            case 2 -> decryption.doDecrypt(Data.success + Data.decrypt);
            case 3 -> bruteForce.doBruteForce(Data.success);

        }

    }
}











