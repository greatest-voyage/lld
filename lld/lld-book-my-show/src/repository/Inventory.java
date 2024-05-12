package repository;

import model.Show;
import model.Theatre;

import java.util.*;

public class Inventory {
    static Map<String, Show> showsMap;
    static Map<String, Theatre> theatresMap;
    static Map<String, Map<String, List<Show>>> cityToTheatresShowMap;

    static Map<String, Map<String, String>> showSeatsMap;

    static {
        showsMap = new HashMap<>();
        theatresMap = new HashMap<>();
        cityToTheatresShowMap = new HashMap<>();
        showSeatsMap = new HashMap<>();
    }

    public static void addShow(Show show) {
        showsMap.put(show.getShowId(), show);

        Theatre theatre = show.getTheatre();
        theatresMap.put(theatre.getTheatreId(), theatre);

        cityToTheatresShowMap.putIfAbsent(theatre.getCity(), new HashMap<>());
        cityToTheatresShowMap.get(theatre.getCity()).putIfAbsent(theatre.getTheatreId(), new ArrayList<>());
        cityToTheatresShowMap.get(theatre.getCity()).get(theatre.getTheatreId()).add(show);

        showSeatsMap.put(show.getShowId(), new HashMap<>());
        for(String seatId: show.getHall().getSeats()) {
            showSeatsMap.get(show.getShowId()).put(seatId, "NOT BOOKED");
        }
    }

    public static void addTheatre(Theatre theatre) {
        theatresMap.put(theatre.getTheatreId(), theatre);
    }

    public static Map<String, List<Show>> getMovieShowsInCity(String city) {
        return cityToTheatresShowMap.getOrDefault(city, new HashMap<>());
    }

    public static Theatre getTheatreById(String theatreId) {
        return theatresMap.getOrDefault(theatreId, null);
    }

    public static String bookShow(String showId, String seatId) {
        Show show = showsMap.get(showId);
        if(show== null) {
            throw new IllegalArgumentException("Show id doesn't exist");
        }

        Map<String, String> seats = showSeatsMap.get(showId);
        if(!seats.containsKey(seatId) || !seats.get(seatId).equals("NOT BOOKED"))  {
            return "Seat has already been booked";
        } else {
            seats.put(seatId, "BOOKED");
        }

        return "Seat booked successfully";
    }

    public static List<String> getAvailableSeats(String showId) {
        if(!showSeatsMap.containsKey(showId)) {
            throw new IllegalStateException("Show id doesn't exist");
        }

        List<String> availableSeatsList = new ArrayList<>();
        for(Map.Entry<String, String> entry: showSeatsMap.get(showId).entrySet()) {
            String seatId = (String) entry.getKey();
            String booked = (String) entry.getValue();
            if("NOT BOOKED".equals(booked)) {
                availableSeatsList.add(seatId);
            }
        }

        return availableSeatsList;
    }
}
