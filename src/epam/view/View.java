package epam.view;

/**
 * Created by Сергей on 09.07.2016.
 */
public class View {
    public static final String VALIDATION = "Validation: ";
    public static final String ASK_TO_PARSE = "Do you want to parse XML file?(y/n)";
    public static final String ENTER_PARSER = "Enter parser type (sax, stax, dom): ";
    public static final String WRONG_PARSER = "This type of parser is not served: ";
    public static final String WRONG_INPUT_DATA = "Wrong input! Repeat please! ";
    public static final String END_WORK = "Goodbye!";
    public static final String XML_VALID = " xml is valid.";
    public static final String XML_INVALID = " xml is invalid, because ";
    public static final String SAX_PARSER = "SAX Parser";
    public static final String STAX_PARSER = "StAX Parser";
    public static final String DOM_PARSER = "DOM Parser";

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
