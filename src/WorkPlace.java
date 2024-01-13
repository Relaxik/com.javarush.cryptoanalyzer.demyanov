import java.util.spi.AbstractResourceBundleProvider;

public class WorkPlace {

    public static void main(String[] args) {
        Encryption encryption = new Encryption();
        Decryption decryption = new Decryption();
        BruteForce bruteForce = new BruteForce();
        System.out.println("Выберите действие\n" +
                "1. Шифрование текста\n" +
                "2. Дешифровка текста\n" +
                "3. Подбор ключа (BruteForce)\n" +
                "0. Выход");
        int numberOfAction = Integer.parseInt(Data.scanner.nextLine());
        switch (numberOfAction) {
            case 1 -> {
                System.out.println(Data.chooseFile);
                Data.fileReadPath = Data.scanner.nextLine();
                System.out.println(Data.fileDeploy);
                Data.fileWritePath = Data.scanner.nextLine();
                System.out.println(Data.keySelect);
                Data.temp = Integer.parseInt(Data.scanner.nextLine());
                encryption.doEncrypt(Data.success + Data.encrypt);
            }
            case 2 -> {
                System.out.println(Data.chooseFile);
                Data.fileReadPath = Data.scanner.nextLine();
                System.out.println(Data.fileDeploy);
                Data.fileWritePath = Data.scanner.nextLine();
                System.out.println(Data.keySelect);
                Data.temp = Integer.parseInt(Data.scanner.nextLine());
                decryption.doDecrypt(Data.success + Data.decrypt);
            }
            case 3 -> {
                System.out.println(Data.chooseFile);
                Data.fileReadPath = Data.scanner.nextLine();
                bruteForce.doBruteForce(Data.bruteForce);
            }default -> System.out.println("До свидания");
        }
    }
}














