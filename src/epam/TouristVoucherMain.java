package epam;

import epam.controller.Controller;
import epam.view.View;

/**
 * Created by Сергей on 05.07.2016.
 */
public class TouristVoucherMain {

    public static void main(String[] args) {
        Controller controller = new Controller(new View());
        controller.processXML();
    }
}
