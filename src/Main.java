
import modal.Converter;
import modal.Octal;

import java.util.Scanner;



public class Main{
    private static Scanner scn = new Scanner(System.in);
    private static Converter converter = new Converter();
    public static void convertProcess(){
        String options = "1 - Hex To Decimal\n2 - Decimal To Hex\n3 - modal.Octal To Decimal\n4 - Decimal To modal.Octal\n5 - Binary To Decimal\n6 - Decimal To Binary\n";
        System.out.println(options + "\nChoose option: ");
        int x = scn.nextInt();
        boolean inLoop = true;
        switch (x){
            case 1:
                System.out.println("Enter hexadecimal number: ");
                String hex = scn.next();
                System.out.println(converter.HexToDecimal(hex));
                break;
            case 2:
                System.out.println("Enter decimal number: ");
                System.out.println(converter.DecimalToHex(scn.nextInt()));
                break;
            case 3:
                System.out.println("Enter octal number: ");
                String oct = scn.next();
                System.out.println( converter.OctalToDecimal(oct));
                break;
            case 4:
                System.out.println("Enter decimal number: ");
                System.out.println(converter.DecimalToOctal(scn.nextInt()));
                break;
            case 5:
                System.out.println("Enter binary number: ");
                String bin = scn.next();
                System.out.println(converter.BinaryToDecimal(bin));
                break;
            case 6:
                System.out.println("Enter decimal number: ");
                System.out.println(converter.DecimalToBinary(scn.nextInt()));
                break;
            case 0:
                System.out.println("Execution is stopped...");
                inLoop = false;
                break;
        }
        System.out.println();
        if(inLoop){
            convertProcess();
        }
    }
    public static void arithmeticProcess(){
        System.out.println("Input data type: only positive number");
        System.out.println("Input operators: + - * /");
        System.out.println("Example: \n\tInput: 23 + 7 \n\tOutput: 32");
        String[] x = scn.nextLine().trim().split(" ");
        boolean inLoop = true;
        switch (x[1]){
            case "+":
                System.out.println(Octal.add(x[0], x[2]));
                break;
            case "-":
                System.out.println(Octal.subtract(x[0], x[2]));
                break;
            case "*":
                System.out.println(Octal.multiple(x[0], x[2]));
                break;
            case "/":
                System.out.println(Octal.divide(x[0], x[2]));
                break;
        }
        System.out.println();
        if(inLoop){
            arithmeticProcess();
        }
    }

    public static void main(String[] args) {
        arithmeticProcess();
    }
}
