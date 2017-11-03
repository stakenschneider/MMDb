public class MovieGenres {
    long movieGenresID, movieID, genreID;

    public MovieGenres(long movieGenresID, long movieID, long genreID) {
        this.movieGenresID = movieGenresID;
        this.movieID = movieID;
        this.genreID = genreID;
    }

    @Override
    public String toString() {
        return String.valueOf(movieGenresID);
    }

}
