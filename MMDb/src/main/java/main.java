import java.sql.SQLException;

public class main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:5432/postgres";

        Inserts inserts = new Inserts(url);
        Generator generator = new Generator(inserts);


        generator.fillMP(300);
//        generator.fillMP(100);

    }
}

