import com.github.javafaker.Faker;
import java.util.List;

public class Generator {

    Inserts inserts;
    Select select;
    Faker faker = new Faker();

    public Generator(Inserts inserts) {
        this.inserts = inserts;
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

    private double randomRating(){ return Math.random()*10-1; }

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

    public void fillMovieGenres(int number) {
        //TODO: NullPointerException :)
        List<Movie> movies = select.getMovie(); //bel
        List<Genres> genres = select.getGenre(); //dish

        long[] movieID = new long[movies.size()];
        for (int i = 0; i < movies.size(); i++) {
            movieID[i] = movies.get(i).movieID;
        }

        long[] genresID = new long[genres.size()];
        for (int i = 0; i < genres.size(); i++) {
            genresID[i] = genres.get(i).genresID;
        }

        for(int i = 0; i < number; i++) {
            inserts.insertMovieGenres(this.randNumFromArray(genresID), this.randNumFromArray(movieID));
        }
    }

}
