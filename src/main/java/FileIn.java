import java.io.FileWriter;
import java.io.IOException;

public class FileIn {
    public static void fileInput(int number){

    try(FileWriter writer = new FileWriter("notes3.txt", false))
    {
        writer.write(number);


        writer.flush();
    }
    catch(IOException e){
        System.out.println(e.getMessage());
    }

    }
}
