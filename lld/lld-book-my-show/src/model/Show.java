package model;

import java.time.LocalDateTime;

public class Show {
    String showId;
    Theatre theatre;
    Hall hall;

    Movie movie;

    LocalDateTime start, end;

    @Override
    public String toString() {
        return "Show{" +
                "showId='" + showId + '\'' +
                ", theatre=" + theatre.getTheatreId() +
                ", hall=" + hall.getHallId() +
                ", movie=" + movie.getMovieName() +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public Show(String showId, Theatre theatre, Hall hall, Movie movie, LocalDateTime start, LocalDateTime end) {
        this.showId = showId;
        this.theatre = theatre;
        this.hall = hall;
        this.movie = movie;
        this.start = start;
        this.end = end;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
