package model;

import java.util.List;

public class Hall {
    String hallId;
    List<String> seats;

    Theatre theatre;

    @Override
    public String toString() {
        return "Hall{" +
                "hallId='" + hallId + '\'' +
                ", seats=" + seats +
                ", theatre=" + theatre.getTheatreId() +
                '}';
    }

    public Hall(String hallId, List<String> seats, Theatre theatre) {
        this.hallId = hallId;
        this.seats = seats;
        this.theatre = theatre;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}
