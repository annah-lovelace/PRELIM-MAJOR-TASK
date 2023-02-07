package prog2.pregroup;

public class NoDenominatorException extends RuntimeException {
    public NoDenominatorException () {
        System.out.println("NoDenominatorException occurred. Default fraction value 0/1 will be used");
        System.out.println("You may still change it using the main menu");

    }
}
