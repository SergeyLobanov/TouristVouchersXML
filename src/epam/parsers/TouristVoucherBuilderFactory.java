package epam.parsers;

/**
 * Created by Сергей on 10.07.2016.
 */
public class TouristVoucherBuilderFactory {

    private enum ParserType {
        SAX, STAX, DOM
    }

    public AbstractTouristVouchersBuilder createTouristVoucherBuilder(String parserType) {
        ParserType type = ParserType.valueOf(parserType.toUpperCase());

        switch (type) {
            case SAX:
                return new SaxBuilder();
            case STAX:
                return new StAXBuilder();
            case DOM:
                return new DOMBuilder();
            default:
                throw new EnumConstantNotPresentException(
                        type.getDeclaringClass(), type.name());
        }
    }

}
