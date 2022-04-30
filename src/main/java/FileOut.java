import java.io.FileReader;
import java.io.IOException;

public class FileOut {
    public static void fileIn(int number) {
        try (FileReader reader = new FileReader("notes3.txt")) {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {

                System.out.print((char) c);
            }
        } catch (IOException e) {
        }
    }
}
