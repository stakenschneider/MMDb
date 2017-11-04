import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:5432/postgres";

        Inserts inserts = new Inserts(url);
        Generator generator = new Generator(inserts);

        generator.fillMovie(50);
        generator.fillActors(83);
        generator.fillDirectors(50);

        generator.fillMovieGenres(10);
        generator.fillMovieActors(90);
        generator.fillMovieDirectors(20);
    }
}

