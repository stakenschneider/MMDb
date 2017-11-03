public class Movie {
    long movieID;
    String name;
    int year;
    double rating;
    int length;
    String description;
    String tag;

    public Movie(long movieID, String name, int year, double rating, int length, String description, String tag) {
        this.movieID = movieID;
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.length = length;
        this.description = description;
        this.tag = tag;

    }

    @Override
    public String toString() {
        return name;
    }
}
