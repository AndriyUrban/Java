import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String example = "122 - 122 + (4*4) - 16";
        System.out.println("Write string here: \n"+"Example: "+example);
        String input = scanner.nextLine();
        List<Element> elements = ElementBuffet.checking(input);
        ElementBuffet elementBuffet = new ElementBuffet(elements);
        int number = ElementBuffet.expr(elementBuffet);
        boolean check = CheckInputBrackets.check(input);
        if(check){
            System.out.println(number);
        }
        else{
            throw new RuntimeException("Wrong input");
        }



    }
}
