import java.util.Scanner;

public class Calc {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        Calculator calculator1 = new Calculator();
        System.out.println("input:");
        String input=scn.nextLine();
        calculator1.setInput(input);
        String[] inputArr =calculator1.getInput();
        calculator1.setAction(input);
        calculator1.setNum1(inputArr[0]);
        calculator1.setNum2(inputArr[1]);
        calculator1.checkNum();
        calculator1.setResult();
    }
}
class Calculator {
    private String[] input;
    final String[] romeArr = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
    private int num1;
    private int num2;
    private boolean romArab1;
    private boolean romArab2;

    private char action;
    private int result;
    private String resultToString;

    void setInput(String input) throws Exception {
        this.input = input.split("[+\\-/*]");
        if (this.input.length != 2) throw new Exception("input- только римские или арабские числа от 1 до 10 и знак действия+-/*");
    }

    String[] getInput() {
        return input;
    }

    void setAction(String input) throws Exception {
        if (input.contains("+")) action = '+';
        else if (input.contains("-")) action = '-';
        else if (input.contains("/")) action = '/';
        else if (input.contains("*")) action = '*';
        else throw new Exception("недопустимый ввод");
    }
    void setNum1(String input) throws Exception {
        for (int i = 1; i < 11; i++) {
            if (input.equals(romeArr[i])) {
                num1 = i;
                romArab1 = true;
                return;
            }
        }
        num1 = switch (input) {
            case "1" -> 1;
            case "2" -> 2;
            case "3" -> 3;
            case "4" -> 4;
            case "5" -> 5;
            case "6" -> 6;
            case "7" -> 7;
            case "8" -> 8;
            case "9" -> 9;
            case "10" -> 10;
            default -> throw new Exception("input- только римские или арабские числа от 1 до 10 без пробелов  ");
        };
    }

    void setNum2(String input) throws Exception {
        for (int i = 1; i < 11; i++) {
            if (input.equals(romeArr[i])) {
                num2 = i;
                romArab2 = true;
                return;
            }
        }
        num2 = switch (input) {
            case "1" -> 1;
            case "2" -> 2;
            case "3" -> 3;
            case "4" -> 4;
            case "5" -> 5;
            case "6" -> 6;
            case "7" -> 7;
            case "8" -> 8;
            case "9" -> 9;
            case "10" -> 10;
            default -> throw new Exception("только целые римские или арабские числа от 1 до 10 без пробелов");
        };
    }
    void checkNum() throws Exception {
        if (romArab2 != romArab1) throw new Exception("вводимые значения должны быть одного типа");
    }
    void setResult()throws Exception{
        switch (action){
            case '+' : result=num1+num2; break;
            case '-' : result=num1-num2;break;
            case '*' : result=num1*num2;break;
            case '/' : result=num1/num2;break; }
        if ((romArab1)&&(result < 0)) {
            throw new Exception("Римские цифры всегда больше 0");
        }System.out.println("output:");
        if (romArab1){
            resultToString= romeArr[result];
        }else resultToString=Integer.toString(result); 
        System.out.println(resultToString);
    }
    }



