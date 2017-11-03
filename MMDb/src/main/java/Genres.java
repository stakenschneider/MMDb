public class Genres {
    long genresID;
    String name;

    public Genres(long genresID, String name) {
        this.genresID = genresID;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.valueOf(genresID);
    }

}
