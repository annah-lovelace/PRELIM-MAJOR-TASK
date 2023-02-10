/**
 * The Fraction class
 * A template for a fraction that has the form numerator/denominator
 */

package prog2.prelimgroup;

public class Fraction {
    // object fields
    private int numerator; // holds the numerator for this fraction
    private int denominator; // holds the denominator for this fraction

    /**
     * Constructs a fraction with numerator = 0 and denominator =1.
     * This constructor allows a Fraction with an equivalent numeric value of zero.
     * This becomes the default constructor
     */

     public Fraction(int wholeNumVal) {
         this(wholeNumVal, 1);
     }

    /**
     * Constructs a Fraction using a given numerator and denominator
     * Example: Fraction f = new Fraction( 3, 8);
     * @param numerator value of the numerator
     * @param denominator value of the denominator
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

    }

    /**
     * Mutator/Setter Method
     * Sets the value of the numerator of this fraction to n
     * @param n The numerator to assign
     */
    public void setNumerator(int n) {
        numerator = n;
    }

    /**
     * Accessor/Getter Method
     * @return The value of the numerator of this fraction
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Mutator/Setter Method
     * Sets the value of the denominator of this fraction to d
     * @param d The denominator to assign
     */
    public void setDenominator(int d) {
        denominator=d;
    }

    /**
     * Accessor/Getter Method
     * @return The value of the denominator of this fraction
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Stringifies a fraction
     * @return A string form of the fraction following the numerator/denominator format
     */
    public String toString() { // this is an overridden method from the Object class
        String r = "";
        if ( numerator == 0 )
            r = "0";
        else
            if (denominator==1)
                r= numerator +"";
            else
                r= (numerator + "/" + denominator );
        return r;
    }

    /**
     * Converts the fraction to a decimal form
     * @return A decimal equivalent of this fraction. (e.g. if this fraction 1/4, 0.25 is returned)
     */
    public double toDouble() {

        return (double) numerator/denominator;
    }
    /**
     * Reduces the fraction to its simplest form
     * @return The reduced (simplest) form of this fraction
     */
    public Fraction reduce(int wholeNumVal) {
        Fraction r = new Fraction(wholeNumVal); // constructs a fraction
        int gCF = computeGCF(); // determine the greatest common factor of numerator and denominator
        int newN= numerator/gCF;   //compute newN, the numerator's simplest form
        int newD = denominator/gCF; //compute newD, denominator's simplest form
        r.setNumerator(newN); // sets the new value of the numerator in its simplest form
        r.setDenominator(newD);// sets the new value of the denominator in its simplest form newD
        return r; // returns the simplest form of this fraction
    }
    /**
     * Computes the greatest common factor of the numerator and denominator
     * @return The greatest common factor
     */
    private  int computeGCF(){
        int gCF = 1;
        int lesser = 1;
        boolean value = false;
        lesser = computeLesser( numerator, denominator);
        for (int index= lesser; (index >=1 && !value); index--){
            if (numerator % index == 0 && denominator % index == 0) {
                value = true;
                gCF = index;
            }
        }
        return gCF;
    }

    /**
     * Returns the lesser number of the two parameters
     * @param n1 The first number to compare
     * @param n2 The second number to compare
     * @return The lesser value of integer between n1 and n2
     */
    private int computeLesser (int n1, int n2) {
        int lesser = n1;
        if (n1 < n2)
            lesser = n1;
        else
            lesser = n2;
        return lesser;
    }
    /**
     * Adds the two fractions
     *
     * @param addend      An addend fraction
     * @param wholeNumVal whole number fraction
     * @return The sum of this fraction and another fraction g
     */
    public Fraction add(Fraction addend, int wholeNumVal) {
        Fraction sum = new Fraction(wholeNumVal);
        int den = denominator * addend.getDenominator();
        int num = den/denominator*numerator + den/addend.getDenominator()*addend.getNumerator();
        sum.setNumerator(num);
        sum.setDenominator(den);
        return sum.reduce(wholeNumVal);
    }
    /**
     * Subtracts the two fractions
     *
     * @param subtrahend  The subtrahend fraction
     * @param wholeNumVal
     * @return The difference of this fraction and another fraction
     */
    public Fraction subtract(Fraction subtrahend, int wholeNumVal) {
        Fraction difference = new Fraction(wholeNumVal);
        int num = numerator * subtrahend.getDenominator() - subtrahend.getNumerator() * denominator;
        int den = denominator * subtrahend.getDenominator();
        difference.setNumerator(num);
        difference.setDenominator(den);
        return difference.reduce(wholeNumVal);
    }
    /**
     * Multiplies the two fractions
     *
     * @param multiplier  The multiplier fraction
     * @param i
     * @param wholeNumVal
     * @return The product of this fraction and another fraction
     */
    public Fraction multiplyBy(Fraction multiplier, int i, int wholeNumVal) {
        Fraction product = new Fraction(wholeNumVal);
        int num = numerator * multiplier.getNumerator();
        int den = denominator * multiplier.getDenominator();
        product.setNumerator(num);
        product.setDenominator(den);
        return product.reduce(wholeNumVal);
    }

    /**
     * Divides the two fractions
     * @param divisor The divisor fraction
     * @param wholeNumVal
     * @return The quotient of this fraction and another fraction
     **/
    public Fraction divideBy(Fraction divisor, int wholeNumVal) {
        Fraction quotient = new Fraction(wholeNumVal);
        int num = numerator * divisor.getDenominator();
        int den = denominator * divisor.getNumerator();
        quotient.setNumerator(num);
        quotient.setDenominator(den);
        return quotient.reduce(wholeNumVal);
    }

    /**
     * This part was made by ROXAS, Johan Rickardo on 7 February 2023.
     * Calculates the greatest common divisor of two numbers, without listing the divisor of either number.
     * This method uses Euclid's Algorithm.
     */
    private void computeGCD() {
        int remainder = 0;
        remainder = numerator % denominator;
        if (remainder == 0)
            System.out.println("Greatest common divisor: " + denominator);
        else {
            numerator = denominator;
            denominator = remainder;
            computeGCD();
        } // end of else
    } // end of computeGCD method
} // end of Fraction class

