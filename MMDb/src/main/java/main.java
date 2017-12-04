import java.sql.SQLException;

public class main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:5432/postgres";

        Inserts inserts = new Inserts(url);
        Generator generator = new Generator(inserts);

//        generator.fillMovie(100);
//
//        generator.fillPeople(100, "Actors");
//        generator.fillPeople(100, "Directors");
//
//        generator.fill_many2many(200, "Genres");
        generator.fill_many2many(20, "Actors");
//        generator.fill_many2many(150, "Directors");
    }
}

