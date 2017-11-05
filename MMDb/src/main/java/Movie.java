public class Movie {
    long movieID;
    String name;
    int year;
    double rating;
    int length;
    String description;

    public Movie(long movieID, String name, int year, double rating, int length, String description) {
        this.movieID = movieID;
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.length = length;
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }
}
