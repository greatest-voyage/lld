package model;

import java.util.List;
import java.util.stream.Collectors;

public class Theatre {
    String theatreId;
    String city;
    List<Hall> hallsList;

    public Theatre(String theatreId, String city) {
        this.theatreId = theatreId;
        this.city = city;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Hall> getHallsList() {
        return hallsList;
    }

    public void setHallsList(List<Hall> hallsList) {
        this.hallsList = hallsList;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theatreId='" + theatreId + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
