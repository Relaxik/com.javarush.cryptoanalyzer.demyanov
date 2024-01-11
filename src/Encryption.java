import java.io.*;

public class Encryption {


    public String doEncrypt(String message) {
        try (Reader reader = new FileReader(Data.fileReadPath);
             Writer writer = new FileWriter(Data.fileWritePath)) {
            Data.key = Data.temp <= Data.ALPHABET_LENGHT ? Data.temp : Data.temp - (Data.ALPHABET_LENGHT * (Data.temp / Data.ALPHABET_LENGHT));
            while (reader.ready()) {
                int realLenght = reader.read(Data.buffer);
                for (int i = 0; i < realLenght; i++) {
                    Data.next = 0;
                    while (Data.buffer[i] != Data.ALPHABET[Data.next]) {
                        if (Data.next + Data.key >= Data.ALPHABET_LENGHT) {
                            Data.next = Data.next + Data.key - Data.ALPHABET_LENGHT;
                            break;
                        }
                        Data.next++;
                    }
                    switch (Data.buffer[i]) {
                        case 13 -> reader.skip(1);
                        case 10 -> writer.write(10);
                        default -> Data.buffer[i] = Data.ALPHABET[Data.next + Data.key];
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
//        Encryption encryption = new Encryption();
//        encryption.doEncrypt("1");
//    }
}









