package epam.view;

/**
 * Created by Сергей on 09.07.2016.
 */
public class View {
    public static final String VALIDATION = "Validation: ";
    public static final String ENTER_PARSER = "Enter parser type (sax, stax, dom): ";
    public static final String WRONG_PARSER = "This type of parser is not served";
    public static final String WRONG_INPUT_DATA = "Enter correct value";
    public static final String END_WORK = "Goodbye!";
    public static final String XML_VALID = " xml is valid.";
    public static final String XML_INVALID = " xml is invalid, because ";

    public void printMessage(String message) {
        System.out.println(message);
    }
}
