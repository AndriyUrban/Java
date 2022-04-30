import java.util.Scanner;

import static java.lang.Character.isDigit;

public class ExtraTask {
   public static int counter(String line) {
        int count = 0;
        char[] chars = line.toCharArray();
        for (char i : chars) {
            if (isDigit(i)) {
                count +=1;
            }
        }
        return count;

    }
}
