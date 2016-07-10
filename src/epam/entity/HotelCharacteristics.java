package epam.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 09.07.2016.
 */
public class HotelCharacteristics {
    private int hotelStars;
    private NutritionType nutrition;
    private int roomsNumber;
    private List<String> additionalDevice;

    //default constructor
    public HotelCharacteristics() {
    }

    public HotelCharacteristics(int hotelStars, NutritionType nutrition, int roomsNumber, List<String> additionalDevice) {
        this.hotelStars = hotelStars;
        this.nutrition = nutrition;
        this.roomsNumber = roomsNumber;
        this.additionalDevice = additionalDevice;
    }

    //getters and setters
    public NutritionType getNutrition() {
        return nutrition;
    }

    public void setNutrition(NutritionType value) {
        this.nutrition = value;
    }

    public int getRoomsNumber() {
        return roomsNumber;
    }

    public void setRoomsNumber(int value) {
        this.roomsNumber = value;
    }

    public List<String> getAdditionalDevice() {
        if (additionalDevice == null) {
            additionalDevice = new ArrayList<String>();
        }
        return this.additionalDevice;
    }

    public void setAdditionalDevice(List<String> additionalDevices) {
        this.additionalDevice = additionalDevices;
    }

    public void setAdditionalDevice(String additionalDevice) {
        addAdditionalDevice(additionalDevice);
    }

    public void addAdditionalDevice(String additionalDevice) {
        if (this.additionalDevice == null) {
            this.additionalDevice = new ArrayList<>();
        }
        this.additionalDevice.add(additionalDevice);
    }

    public int getHotelStars() {
        return hotelStars;
    }

    public void setHotelStars(int value) {
        this.hotelStars = value;
    }

    @Override
    public String toString() {
        return "HotelCharacteristicsType{" +
                "hotelStars=" + hotelStars +
                ", nutrition=" + nutrition +
                ", roomsNumber=" + roomsNumber +
                ", additionalDevice=" + additionalDevice +
                '}';
    }
}
