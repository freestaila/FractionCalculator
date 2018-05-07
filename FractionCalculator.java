import java.util.Scanner;

public class FractionCalculator {

    public static final Scanner input = new Scanner(System.in);

    public static void main(String args[]) {
        System.out.println("***Welcome in FractionCalculator***");
        String oper = oper = getOperation(input);;
// popraw to prosze
        Fraction frac1, frac2;

        do {
            frac1 = getFraction(input);
            frac2 = getFraction(input);

            System.out.print(frac1.toString() + " " + oper + " " + frac2 );
            if (oper.equals("+")) {
                System.out.print(" = " + frac1.add(frac2).toString());
            } else if (oper.equals("-")) {
                System.out.print(" = " + frac1.subtract(frac2).toString());
            } else if (oper.equals("*")) {
                System.out.print(" = " + frac1.multiply(frac2).toString());
            } else if (oper.equals("/")) {
                System.out.print(" = " + frac1.divide(frac2).toString());
            } else if (oper.equals("=")) {
                System.out.print(" is " + frac1.equals(frac2));
            }
            System.out.println("\n------------------------------------------------------------------------------");
            oper = getOperation(input);
        } while (true);


    }
    public static String getOperation(Scanner input) {
        System.out.println("Please choose the operation (+, -, *, /, = or Q to quit):");
        String in= input.next();
      while(!in.matches("[+-/*=Qq]"))
        {
            System.out.println("Invalid input. You can in only (+,-,/,*,= or Q to Quit");
            in= input.next();
        }
        if(in.equals("Q") || in.equals("q")) {
          System.exit(0);
        }
        return in;

    }
    public static boolean validFraction(String input) {
        if(input.contains("/")) { // sprawdzam czy wprowaszone dane zaweiraja /
            String[] inputParts = input.split("/"); // dziele stringa
            if(inputParts[0].matches("-?\\d+") && inputParts[1].matches("-?\\d+")) { //sprawdzenie czy to cyfryd
                int checked = Integer.parseInt(inputParts[1]); // parsowanie stringa na int
                if(checked> 0){ // jak wiekszy zero to true
                    return true;
                }else { // jak minus lub 0
                    return false;
                }
            }
        } else if(input.matches("-?\\d+")){ // sprawdzenie czy digit
            return true;
        }else {
            return false;
        }
        return true;
    }
    public static Fraction getFraction(Scanner input)
    {
        System.out.println("Please enter a fraction (a/b) or integer (a):");
        String in= input.next();
        while(validFraction(in)==false) {
            System.out.println("Invalid fraction. Please enter (a/b) or (a):");
           in = input.next();
        }
        if(in.equals("/")){
            String[] inputParts = in.split("/");
            if(inputParts.length > 1) {
                int numerator = Integer.parseInt(inputParts[0]);
                int denominator = Integer.parseInt(inputParts[1]);
                return new Fraction(numerator, denominator);
            }else{
                return new Fraction(Integer.parseInt(inputParts[0]));
            }
        }
        return new Fraction();
    }

    }

