import java.util.Scanner;

public class CheckInputBrackets {
    public static boolean check(String input){
        int l = 0;
        int count = 0;
        char[] chars = input.toCharArray();
        while (count>=0 && l<chars.length){
        for (char i : chars) {
            if (i == '(') {
                count += 1;
                l++;
            } else if (i == ')') {
                count -= 1;
                l++;
            }
        }
        }
        if (count==0) {
            System.out.println("T");
            return true;
        }
        System.out.println("F");
        return false;
    }
}

