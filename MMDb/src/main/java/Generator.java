import com.github.javafaker.Faker;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.random;

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

    private double randomRating(){ return abs(Math.random()*10-2); }

    private long randNumFromArray(long [] array) {
        return array[randNumber(array.length)];
    }

    private String randomSentence(){
        String preposition[]={" war"," love"," stars"," cars", " people", " study", " football", " Russia", " church", " beach house", " sleuth", " monsters", " dinosaurs", " nothing", " inexistence", " botheration", " food", " masha", " boy", " dream"};
        String world = preposition[(int)(random() * preposition.length - 1)];
        return "that film about" + world;
    }



    public void fillMovie(int num) {

        for(int i = 0; i < num; i++) {
            inserts.insertMovie( randString(10),  randomYear(),  randomRating(),  randNumber(300),  randomSentence());
        }
    }

    public void fillPeople(int num, String str) {
        for(int i = 0; i < num; i++) {
            Random rnd = new Random();
            long ms = -946771200000L + (Math.abs(rnd.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
            inserts.insertPeople(faker.name().firstName() , faker.name().lastName() , new Date(ms), str);
        }
    }


    public void fill_many2many(int number, String str) {
        List<Actors> actors = select.getActor();
        List<Directors> directors = select.getDirectors();
        List<Genres> genres = select.getGenre();
        List<Movie> movies = select.getMovie();
        long[] secondID = new long[0];

        long[] movieID = new long[movies.size()];
        for (int i = 0; i < movies.size(); i++) {
            movieID[i] = movies.get(i).movieID;
        }

        if (str.equals("Actors"))
        {
            secondID = new long[actors.size()];
            for (int i = 0; i < actors.size(); i++) {
                secondID[i] = actors.get(i).ID;
            }
        }

        if (str.equals("Directors")){
            secondID = new long[directors.size()];
            for (int i = 0; i < directors.size(); i++) {
                secondID[i] = directors.get(i).ID;
            }
        }

        if (str.equals("Genres")){
            secondID = new long[genres.size()];
            for (int i = 0; i < genres.size(); i++) {
                secondID[i] = genres.get(i).ID;
            }
        }

        for(int i = 0; i < number; i++) {
            inserts.insert_many2many(this.randNumFromArray(movieID), this.randNumFromArray(secondID), str);
        }

    }
}
