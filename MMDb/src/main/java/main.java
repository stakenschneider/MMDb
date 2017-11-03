import java.sql.SQLException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:5432/postgres";

        Inserts inserts = new Inserts(url);
        Generator generator = new Generator(inserts);

//        generator.fillMovie(4);
//        generator.fillActors(7);
        generator.fillMovieGenres(3);


    }
}

