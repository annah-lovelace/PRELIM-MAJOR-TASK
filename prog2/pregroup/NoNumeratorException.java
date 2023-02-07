package prog2.pregroup;

public class NoNumeratorException extends RuntimeException {
    public NoNumeratorException () {
        System.out.println("NoNumeratorException occurred. Default fraction value 0/1 will be used");
        System.out.println("You may still change it using the main menu");

    }
}
