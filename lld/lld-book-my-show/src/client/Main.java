package client;

import model.Hall;
import model.Movie;
import model.Show;
import model.Theatre;
import service.BookingService;
import repository.Inventory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Main {

    BookingService bookingService;

    public Main() {
        bookingService = new BookingService();
        initialize();
        testSearch();
        testBooking();
        testSearchSeats();
    }

    public void initialize() {
        Theatre theatre = new Theatre("Theatre 1", "Mumbai");
        Hall hall1 = new Hall("hall1", List.of("1", "2","3"), theatre);
        Hall hall2 = new Hall("hall2", List.of("1", "2","3"), theatre);
        theatre.setHallsList(List.of(hall1, hall2));

        Movie movie1 = new Movie("Interstellar");
        Movie movie2 = new Movie("Gangs of Wasseypur");

        Show show1 = new Show("show1", theatre, hall1, movie1, LocalDateTime.now().minusHours(3), LocalDateTime.now().plusDays(1));
        Show show2 = new Show("show2", theatre, hall2, movie2, LocalDateTime.now().minusHours(2), LocalDateTime.now());

        Inventory.addShow(show1);
        Inventory.addShow(show2);
    }

    public void testSearch() {
        Map<Theatre, List<Show>> theatreShowsMap= bookingService.searchMoviesPlayingInCity("Mumbai", "Gangs of Wasseypur", LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
        for(Theatre theater: theatreShowsMap.keySet()) {
            System.out.println(theater);
            for(Show show: theatreShowsMap.get(theater)) {
                System.out.println(show);
            }
        }
    }
    public void testBooking() {
        System.out.println(bookingService.book("show1", "1"));
        System.out.println(bookingService.book("show1", "1"));
    }

    public void testSearchSeats() {
        System.out.println(bookingService.getAvailableSeats("show1"));
    }


    public static void main(String[] args) {
        new Main();
    }
}