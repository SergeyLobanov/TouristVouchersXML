package epam.parsers;

import epam.entity.TouristVoucher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Сергей on 10.07.2016.
 */
public abstract class AbstractTouristVouchersBuilder {
    protected List<TouristVoucher> touristVouchers;

    public AbstractTouristVouchersBuilder() {
        touristVouchers = new ArrayList<>();
    }

    /**
     *
     * @return list of tourist vouchers sorted by voucher id
     */
    public List<TouristVoucher> getSortedTouristVouchers() {
        List<TouristVoucher> vouchersList = getTouristVouchers();
        Collections.sort(vouchersList, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                TouristVoucher touristVoucher1 = (TouristVoucher) o1;
                TouristVoucher touristVoucher2 = (TouristVoucher) o2;
                return touristVoucher1.getId().compareTo(touristVoucher2.getId());
            }
        });
        return vouchersList;
    }

    public List<TouristVoucher> getTouristVouchers() {
        return touristVouchers;
    }

    abstract public void buildListOfTouristVouchers(String fileName);

}
