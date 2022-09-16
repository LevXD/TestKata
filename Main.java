import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static String[] romans = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение:");
        String expression = scanner.nextLine();
        System.out.println(calc(expression));
    }
    public static String calc(String input) {
        int num1, num2, result;
        result = -1;
        char operation = '`';
        input = input.replaceAll(" ", "");
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '+':
                case '-':
                case '/':
                case '*':
                    operation = input.charAt(i);
                break;
            }
        }
        if (operation == '`') {
            throw new InputMismatchException("Неверный формат выражения");
        }
        String[] numbers = input.split("[+*/-]");
        if (isRoman(numbers[0]) | isRoman(numbers[1])) {
            if (operation == '-') {
                throw new InputMismatchException("Неверный формат выражения");
            }   else if (isRoman(numbers[0]) && isRoman(numbers[1])) {
                numbers[0] = romanToNum(numbers[0]);
                numbers[1] = romanToNum((numbers[1]));
            }   else throw new InputMismatchException("Неверный формат выражения");
        }

        num1 = Integer.parseInt(numbers[0]);
        num2 = Integer.parseInt(numbers[1]);
        if (num1 <= 0 | num1 >10 | num2 > 10) {
            throw new InputMismatchException("Неверный формат выражения");
        }
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }
        String[] checkNumbers = input.split("[+*/-]");
        String output;
        if(isRoman(checkNumbers[0]) | isRoman(checkNumbers[1])) {
            output = romans[result];
        }   else output = Integer.toString(result);
        return output;
    }
    static boolean isRoman (String number) {
        for (int i = 0; i < romans.length; i++) {
            if (number.contains(romans[i])) {
                return true;
            }
        }
        return false;
    }
    static String romanToNum (String roman) {
        switch (roman) {
            case "I":
                return "1";
            case "II":
                return "2";
            case "III":
                return "3";
            case "IV":
                return "4";
            case "V":
                return "5";
            case "VI":
                return "6";
            case "VII":
                return "7";
            case "VIII":
                return "8";
            case "IX":
                return "9";
            case "X":
                return "10";
        }
        return null;
    }
}
