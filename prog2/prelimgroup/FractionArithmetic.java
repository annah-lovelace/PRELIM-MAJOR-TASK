package prog2.prelimgroup;

import java.util.Scanner;
import java.lang.*;

public class FractionArithmetic {
    static Scanner keyboard = new Scanner(System.in); // static scanner object to reduce lines of code

    /**
     * Main entry point of the program
     * @param args - command line arguments
     * @param wholeNumVal - whole number evaluation
     */
    public static void main(String[] args, int wholeNumVal) {
        Fraction fraction = new Fraction(wholeNumVal); //to access the operational methods of Fraction class
        Fraction toDouble = new Fraction(wholeNumVal); //to access toDouble method of Fraction class
        Fraction fraction1 = null;  //declares fraction1 and initializes it to value null
        Fraction fraction2 = null; //declares fraction2 and initializes it to value null
        int choice = 0;

        showIntro();
        keyboard.nextLine();

        do {
            showMenu();
            choice = enterChoice(1, 8);
            switch (choice) {
                case 1:
                    fraction1 = fraction1(wholeNumVal);
                    System.out.println("Press enter to continue...");
                    keyboard.nextLine();
                    keyboard.nextLine();
                    break;
                case 2:
                    fraction2 = fraction2();
                    System.out.println("Press enter to continue...");
                    keyboard.nextLine();
                    keyboard.nextLine();
                    break;
                case 3:
                    // outputs the sum of the two fractions
                    System.out.println("The sum of the two fractions are " + fraction1.add(fraction2,
                            wholeNumVal) + " or " + fraction1.add(fraction2, wholeNumVal).toDouble());
                    break;
                case 4:
                    // outputs the difference of the two fractions
                    System.out.println("The difference of the two fractions are " + "" + fraction1.subtract(fraction2,
                            wholeNumVal) + " or " + fraction1.subtract(fraction2, wholeNumVal).toDouble());
                    break;
                case 5:
                    // outputs the product of the two fractions
                    System.out.println("The product of the two fractions are " + fraction1.multiplyBy(fraction2, -1,
                            wholeNumVal) + " or " + fraction1.multiplyBy(fraction2, -1, wholeNumVal).toDouble());
                    break;
                case 6:
                    // outputs the quotient of the two fractions
                    System.out.println("The quotient of the two fractions are " + fraction1.divideBy(fraction2,
                            wholeNumVal) + " or " + fraction1.divideBy(fraction2, wholeNumVal).toDouble());
                    break;
                case 7:
                    //calls the method reduce() to reduce fraction1
                    fraction1.reduce(wholeNumVal);
                    System.out.println("The reduced form of Fraction 1 is " + fraction1 + " or " + fraction1.toDouble());
                    //calls method reduce() to reduce fraction2
                    fraction2.reduce(wholeNumVal);
                    System.out.println("The reduced form of Fraction 2 is " + fraction2 + " or " + fraction2.toDouble());
                    break;
                case 8:
                    System.out.println("Thank you for using the Fraction Calculator!");
                    System.exit(0);
            }
        } while (choice < 8);
    }

    /**
     * T
     * Reads and validates user input of choice.
     * @param min minimum value for user choice
     * @param max maximum value for user choice
     * @return user input of choice
     */
    public static int enterChoice(int min, int max) {
        int choice = 0;
        do {
            System.out.print("Input the number corresponding to your choice: ");
            choice = keyboard.nextInt();
            if (choice < min || choice > max)
                System.out.println("Invalid choice. Please ensure that you enter a number from " + min + " to " + max + ".");
        } while (choice < min || choice > max);
        return (choice);
    }

    public static void showIntro() {
        System.out.println("+-------------------------------------------------- +");
        System.out.println("|                Welcome to our                     |");
        System.out.println("|              Fraction Calculator                  |");
        System.out.println("+-------------------------------------------------- +");
        System.out.println("             Press enter to continue...              ");
    }

    public static void showMenu() {
        System.out.println("+-------------------------------------------------- +");
        System.out.println("| What do you want to do?                           |");
        System.out.println("|        1. Enter the value of fraction 1           |");
        System.out.println("|        2. Enter the value of fraction 2           |");
        System.out.println("|        3. Add fractions                           |");
        System.out.println("|        4. Subtract fractions                      |");
        System.out.println("|        5. Multiply fractions                      |");
        System.out.println("|        6. Divide fractions                        |");
        System.out.println("|        7. Reduce fractions                        |");
        System.out.println("|        0. Quit                                    |");
        System.out.println("+-------------------------------------------------- +");
    }

    public static Fraction fraction1(int wholeNumVal) {
        Fraction operand1;
        operand1 = enterFraction("fraction 1", wholeNumVal);
        // operand1.reduce();
        System.out.println("Fraction 1: " + operand1);
        return operand1;
    }

    public static Fraction fraction2() {
        Fraction operand2;
        int wholeNumVal = 0;
        operand2 = enterFraction("fraction 2", wholeNumVal);
        // operand2.reduce();
        System.out.println("Fraction 2: " + operand2);
        return operand2;
    }

    /**
     * Validates and accepts user input for the numerator and fraction.
     * @param operand operand of the fraction
     * @param wholeNumVal whole number fraction
     * @return
     */
    private static Fraction enterFraction(String operand, int wholeNumVal) {
        Fraction fraction = null;
        int numerator = 0, denominator;
        try {
            numerator = enterFractionData("numerator", operand);
            denominator = enterFractionData("denominator", operand);
            fraction = new Fraction(numerator, denominator);
        } catch (NoNumeratorException noNumerator) {
            fraction = new Fraction(wholeNumVal);
        } catch (NoDenominatorException noDenominator) {
            fraction = new Fraction(wholeNumVal);
        } finally {
            return fraction;
        } // end of try-catch
    } // end of enterFraction method

    /**
     *
     * @param part
     * @param fractionInfo
     * @return
     */
    private static int enterFractionData(String part, String fractionInfo) {
        int input;
        //changed as a method that uses a loop instead of recursion.
        do {
            try {
                System.out.print("Enter " + part + " of " + fractionInfo + ": ");
                input = Integer.parseInt(keyboard.nextLine());

                /* If zero is the denominator entered, the user needs to change it. */

                if (part.equalsIgnoreCase("denominator") && input == 0)
                    System.out.println("Entered denominator is zero. Operations will be undefined. Enter a new one.");
            } catch (Exception exc) {
                if (part.equalsIgnoreCase("numerator")) {
                    throw new NoNumeratorException();
                }
                else {
                    try {
                        throw new NoDenominatorException();
                    }
                    catch (NoDenominatorException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } while (part.equalsIgnoreCase("denominator") && input == 0);//loop will continue until denominator becomes zero
        return input;
    }
} // end of class FractionArithmetic