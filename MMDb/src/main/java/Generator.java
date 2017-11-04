import com.github.javafaker.Faker;
import java.util.List;
import static java.lang.Math.abs;

public class Generator {

    Inserts inserts;
    Select select;
    Faker faker = new Faker();

    public Generator(Inserts inserts) {
        this.inserts = inserts;
        try {
            select = new Select("jdbc:postgresql://localhost:5432/postgres");
        } catch (Exception ex) {
            System.out.print("");
        }
    }

    private String randString(int number) {
        StringBuilder str = new StringBuilder();
        String alphabet = "abcdefghigklmnopqrstuvwxyz";
        for(int i = 0; i < number; i++) {
            str.append(alphabet.charAt((int)(Math.random() * 26 - 1)));
        }
        return str.toString();
    }

    private int randNumber(int num) {
        return ((int)(Math.random() * num - 1));
    }

    private int randomYear(){
        return ((int)(2017 - Math.random() * 100));
    }

    private double randomRating(){ return abs(Math.random()*10-1); }

    private long randNumFromArray(long [] array) {
        return array[randNumber(array.length)];
    }

    public void fillMovie(int num) {
        for(int i = 0; i < num; i++) {
            inserts.insertMovie( randString(10),  randomYear(),  randomRating(),  randNumber(300),  randString(200),  randString(100));
        }
    }

    public void fillActors(int num) {
        for(int i = 0; i < num; i++) {
            inserts.insertActors(faker.name().firstName() , faker.name().lastName());
        }
    }

    public void fillDirectors(int num) {
        for(int i = 0; i < num; i++) {
            inserts.insertDirectors(faker.name().firstName() , faker.name().lastName());
        }
    }

    public void fillMovieGenres(int number) {
        List<Movie> movies = select.getMovie();
        List<Genres> genres = select.getGenre();

        long[] movieID = new long[movies.size()];
        for (int i = 0; i < movies.size(); i++) {
            movieID[i] = movies.get(i).movieID;
        }

        long[] genresID = new long[genres.size()];
        for (int i = 0; i < genres.size(); i++) {
            genresID[i] = genres.get(i).genresID;
        }

        for(int i = 0; i < number; i++) {
            inserts.insertMovieGenres(this.randNumFromArray(movieID), this.randNumFromArray(genresID));
        }
    }

    public void fillMovieActors(int number) {
        List<Movie> movies = select.getMovie();
        List<Actors> actors = select.getActor();

        long[] movieID = new long[movies.size()];
        for (int i = 0; i < movies.size(); i++) {
            movieID[i] = movies.get(i).movieID;
        }

        long[] actorID = new long[actors.size()];
        for (int i = 0; i < actors.size(); i++) {
            actorID[i] = actors.get(i).actorsID;
        }

        for(int i = 0; i < number; i++) {
            inserts.insertMovieActors(this.randNumFromArray(movieID), this.randNumFromArray(actorID));
        }
    }

    public void fillMovieDirectors(int number) {
        List<Movie> movies = select.getMovie();
        List<Directors> directors = select.getDirectors();

        long[] movieID = new long[movies.size()];
        for (int i = 0; i < movies.size(); i++) {
            movieID[i] = movies.get(i).movieID;
        }

        long[] directorID = new long[directors.size()];
        for (int i = 0; i < directors.size(); i++) {
            directorID[i] = directors.get(i).directorID;
        }

        for(int i = 0; i < number; i++) {
            inserts.insertMovieDirectors(this.randNumFromArray(movieID), this.randNumFromArray(directorID));
        }
    }
}
