package model;

public class Movie {
    String movieName;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Movie(String movieName) {
        this.movieName = movieName;
    }
}
