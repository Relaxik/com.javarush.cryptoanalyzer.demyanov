import java.io.*;

public class Encryption {

    public String doEncrypt(String message) {
        try (Reader reader = new FileReader(Data.fileReadPath);
             Writer writer = new FileWriter(Data.fileWritePath)) {
            Data.key = Data.temp <= Data.ALPHABET_LENGHT ? Data.temp : Data.temp - (Data.ALPHABET_LENGHT * (Data.temp / Data.ALPHABET_LENGHT));
            while (reader.ready()) {
                int realLenght = reader.read(Data.buffer);
                for (int i = 0; i < realLenght; i++) {
                    Data.index = 0;
                    while (Data.buffer[i] != Data.ALPHABET[Data.index]) {
                        if (Data.index + Data.key >= Data.ALPHABET_LENGHT-1) {
                            Data.index = Data.index + Data.key - Data.ALPHABET_LENGHT;
                            break;
                        }
                        Data.index++;
                    }
                    switch (Data.buffer[i]) {
                        case 13 -> reader.skip(1);
                        case 10 -> writer.write(10);
                        default -> Data.buffer[i] = Data.ALPHABET[Data.index + Data.key];
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









