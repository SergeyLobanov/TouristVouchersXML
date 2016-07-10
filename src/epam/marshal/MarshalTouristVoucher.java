package epam.marshal;

import epam.generated.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigInteger;

/**
 * Created by Сергей on 07.07.2016.
 */
public class MarshalTouristVoucher {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(TouristVouchersType.class);
            Marshaller m = context.createMarshaller();
            TouristVouchersType tvs = new TouristVouchersType();
            HotelCharacteristicsType hotel = new HotelCharacteristicsType(NutritionType.ALL_INCLUSIVE,
                    3, null, 5);
            TouristVoucherType touristVoucher1 = new TouristVoucherType(VoucherKindType.RECREATION,
                    "Spain", BigInteger.valueOf(20), TransportType.CAR, hotel, BigInteger.valueOf(3000), "TV-0007");
            tvs.addTouristVoucher(touristVoucher1);
            m.marshal(tvs, new FileOutputStream("src/epam/xml/marshaled.xml"));
            m.marshal(tvs, System.out);
            System.out.println("OK");
        } catch (FileNotFoundException e) {
            System.out.println("XML creating error" + e);
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("JAXB error context " + e);
        }
    }

}
