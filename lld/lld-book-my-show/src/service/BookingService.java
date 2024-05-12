package service;

import model.Show;
import model.Theatre;
import repository.Inventory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingService {

    public Map<Theatre, List<Show>> searchMoviesPlayingInCity(String city, String movie, LocalDateTime start, LocalDateTime end) {
        Map<String, List<Show>> theatresShowMap = Inventory.getMovieShowsInCity(city);
        Map<Theatre, List<Show>> filteredTheatresShowMap = new HashMap<>();
        for(String theatreId: theatresShowMap.keySet()) {
            Theatre theatre = Inventory.getTheatreById(theatreId);
            filteredTheatresShowMap.putIfAbsent(theatre, new ArrayList<>());
            for(Show show: theatresShowMap.get(theatreId)) {
                if(show.getMovie().getMovieName().equals(movie) && show.getStart().isAfter(start) && show.getEnd().isBefore(end)) {
                    filteredTheatresShowMap.get(theatre).add(show);
                }
            }
        }
        return filteredTheatresShowMap;
    }

    public List<String> getAvailableSeats(String showId) {
        return Inventory.getAvailableSeats(showId);
    }

    public String book(String showId, String seatId) {
        return Inventory.bookShow(showId, seatId);
    }

}
