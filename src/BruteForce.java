import java.io.*;

public class BruteForce {
    public String doBruteForce(String message) {
        int j;
        try (Reader reader = new FileReader(Data.fileReadPath)){
//             Writer writer = new FileWriter(Data.fileWritePath)) {
//            Data.key = Data.temp <= Data.ALPHABET_LENGHT ? Data.temp : Data.temp - (Data.ALPHABET_LENGHT * (Data.temp / Data.ALPHABET_LENGHT));
            for (j = 0; j < Data.ALPHABET_LENGHT; j++) {
                Writer writer = new FileWriter(Data.fileReadPath+j+".txt");
                while (reader.ready()) {
                    int realLenght = reader.read(Data.buffer);
                    for (int i = 0; i < realLenght; i++) {
                        Data.index = 0;
                        while (Data.buffer[i] != Data.ALPHABET[Data.index]) {
                            if (Data.index == Data.ALPHABET_LENGHT -1 ) {
                                Data.index = 0;
                                break;
                            }
                            Data.index++;
                        }
                        switch (Data.buffer[i]) {
                            case 13 -> reader.skip(1);
                            case 10 -> writer.write(10);
                            default -> Data.buffer[i] = Data.ALPHABET[Data.index];
                        }
                    }
                    writer.write(Data.buffer, 0, realLenght);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        System.out.println(message);
        return message;
    }
}