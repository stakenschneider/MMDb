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


    public void fillMovie(int num) {
        for(int i = 0; i < num; i++)
            inserts.insertMovie( randString(10),  randomYear(),  randomRating(),  randNumber(300), randString(50));
    }

    public void fillPeople(int num) {
        for(int i = 0; i < num; i++) {
            Random rnd = new Random();
            long ms = -946771200000L + (Math.abs(rnd.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
            inserts.insertPeople(faker.name().firstName() , faker.name().lastName() , new Date(ms));
        }
    }



    public void fillMP(int num){
        List<Movie> movies = select.getMovie();
        List<People> people = select.getPeople();
        List<Profession> professions = select.getProfession();
        List<Awards> awards = select.getAwards();

        long[] movieID = new long[movies.size()];
        long[] peopleID = new long[people.size()];
        long[] professionID = new long[professions.size()];
        long[] awardID = new long[awards.size()];


        for (int i = 0; i < movies.size(); i++)
            movieID[i] = movies.get(i).movieID;

        for (int i = 0; i < people.size(); i++)
            peopleID[i] = people.get(i).ID;

        for (int i = 0; i < professions.size(); i++)
            professionID[i] = professions.get(i).ID;

        for (int i = 0; i < awards.size(); i++)
            awardID[i] = awards.get(i).ID;

        for(int i = 0; i < num; i++)
            inserts.insertMP(this.randNumFromArray(movieID), this.randNumFromArray(peopleID),
                    this.randNumFromArray(professionID), this.randNumFromArray(awardID));

    }

    public void fill_many2many(int number, String str) {
        List<Movie> movies = select.getMovie();
        List<Genres> genres = select.getGenre();
        List<Awards> awards = select.getAwards();

        long[] firstID = new long[movies.size()];
        long[] secondID = new long[0];

        for (int i = 0; i < movies.size(); i++)
            firstID[i] = movies.get(i).movieID;

        if (str.equals("Awards")){
            secondID = new long[awards.size()];
            for (int i = 0; i < awards.size(); i++)
                secondID[i] = awards.get(i).ID;
        }

        if (str.equals("Genres")){
            secondID = new long[genres.size()];
            for (int i = 0; i < genres.size(); i++)
                secondID[i] = genres.get(i).ID;
        }


        for(int i = 0; i < number; i++) {
            inserts.insert_many2many(this.randNumFromArray(firstID), this.randNumFromArray(secondID), str);
        }

    }
}
