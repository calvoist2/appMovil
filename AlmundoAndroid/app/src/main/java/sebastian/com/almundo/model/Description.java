package sebastian.com.almundo.model;

/**
 * Created by Sebas on 8/01/2018.
 */

public class Description {

    public int Hotel_idHotel;
    public int idDescription;
    public String hotelName;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    String googleMapURL;
    String address;
    int freeInternet;
    int breakfastIncluded;
    int swimmingPool;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public int getHotel_idHotel() {
        return Hotel_idHotel;
    }

    public void setHotel_idHotel(int hotel_idHotel) {
        Hotel_idHotel = hotel_idHotel;
    }

    public int getIdDescription() {
        return idDescription;
    }

    public void setIdDescription(int idDescription) {
        this.idDescription = idDescription;
    }

    public String getGoogleMapURL() {
        return googleMapURL;
    }

    public void setGoogleMapURL(String googleMapURL) {
        this.googleMapURL = googleMapURL;
    }

    public int isFreeInternet() {
        return freeInternet;
    }

    public void setFreeInternet(int freeInternet) {
        this.freeInternet = freeInternet;
    }

    public int isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public void setBreakfastIncluded(int breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public int isSwimmingPool() {
        return swimmingPool;
    }

    public void setSwimmingPool(int swimmingPool) {
        this.swimmingPool = swimmingPool;
    }
}
