package modal;

import static java.lang.String.*;

public class Octal{
    public static String add(String augend, String addend){
        String result = "";
        int i = augend.length() - 1;
        int j = addend.length() - 1;

        int next_bit = 0;
        for (;i >= 0 || j >= 0; i--, j--) {
            int x =0, y = 0;
            if (i >= 0) {
                x = Integer.parseInt(valueOf(augend.charAt(i)));
            }
            if(j >= 0){
                y = Integer.parseInt(valueOf(addend.charAt(j)));
            }
            int sum = x + y + next_bit;
            next_bit = sum / 8;
            int curr_bit = sum - next_bit * 8;
            result = curr_bit + result;
        }
        if(next_bit > 0){
            result = next_bit + result;
        }
        return result;
    }
    public static String subtract(String minuend, String subtrahend ){
        String result = "";
        int i = minuend.length() - 1;
        int j = subtrahend.length() - 1;

        if (Integer.parseInt(minuend) < Integer.parseInt(subtrahend)){
            return "Don't support negative result";
        }

        int next_bit = 0;
        for (;i >= 0 || j >= 0; i--, j--) {
            int x =0, y = 0;
            if (i >= 0) {
                x = Integer.parseInt(valueOf(minuend.charAt(i)));
            }
            if(j >= 0){
                y = Integer.parseInt(valueOf(subtrahend.charAt(j)));
            }
            int sum = x - y + next_bit;
            if(sum < 0){
                next_bit = -1;
                sum += 8;
            }
            result = sum + result;
        }
        return valueOf(Integer.parseInt(result)); // for delete zeros before number;
    }
    public static String multiple(String multiplicand, String multiplier){
        String maxOperand = valueOf(Math.max(Integer.parseInt(multiplicand), Integer.parseInt(multiplier)));
        int minOperand = (Math.min(Integer.parseInt(multiplicand), Integer.parseInt(multiplier)));

        String product = "0";
        for (int i = 0; i < minOperand; i++) {
            product = add(product, maxOperand);
        }
        return product;
    }
    public static String divide(String dividend, String divisor){
        for (int i = 0; i < Integer.parseInt(divisor); i++) {

        }
        return "";
    }
}

