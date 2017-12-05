import java.sql.*;
import java.sql.Date;


    public class Inserts {


        private final Connection connection;

        private final String insertMovie = "INSERT INTO movie (name, releaseyear, rating, movielength, description) VALUES (?, ?, ?, ?, ?)";
        private final String insertPeople = "INSERT INTO people (firstname, lastname, birth) VALUES (?, ?, ?)";

        private final String insertMovieGenres = "INSERT INTO moviegenres (movieid, genreid) VALUES (?, ?)";
        private final String insertMoviePeople = "INSERT INTO moviepeople (movieid, peopleid) VALUES (?, ?)";
        private final String insertMovieAwards = "INSERT INTO movieawards (movieid, awardid) VALUES (?, ?)";
        private final String insertPeopleProfession = "INSERT INTO peopleprofession (peopleid, professionid) VALUES (?, ?)";
        private final String insertPeopleAwards = "INSERT INTO peopleawards (peopleid, awardsid) VALUES (?, ?)";

        private  PreparedStatement preparedStatement;
        private final PreparedStatement insertMovieStat;
        private final PreparedStatement insertPeopleStat;
        private final PreparedStatement insertMovieGenresStat;
        private final PreparedStatement insertMoviePeopleStat;
        private final PreparedStatement insertMovieAwardsStat;
        private final PreparedStatement insertPeopleProfessionStat;
        private final PreparedStatement insertPeopleAwardsStat;

        public Inserts (String url) throws ClassNotFoundException, SQLException {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url ,"postgres", "754yrz2n");

            insertMovieStat = connection.prepareStatement(insertMovie);
            insertPeopleStat = connection.prepareStatement(insertPeople);

            insertMovieGenresStat = connection.prepareStatement(insertMovieGenres);
            insertMoviePeopleStat = connection.prepareStatement(insertMoviePeople);
            insertMovieAwardsStat = connection.prepareStatement(insertMovieAwards);
            insertPeopleProfessionStat = connection.prepareStatement(insertPeopleProfession);
            insertPeopleAwardsStat = connection.prepareStatement(insertPeopleAwards);

        }
    public boolean insertMovie(String name, int year, double rating, int length, String description) {
        try {
            insertMovieStat.setString(1, name);
            insertMovieStat.setInt(2, year);
            insertMovieStat.setDouble(3, rating);
            insertMovieStat.setInt(4, length);
            insertMovieStat.setString(5, description);
            insertMovieStat.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean insertPeople(String firstName, String lastName, Date birth) {
        try {
            insertPeopleStat.setString(1, firstName);
            insertPeopleStat.setString(2, lastName);
            insertPeopleStat.setDate(3, birth);
            insertPeopleStat.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insert_many2many(long movieID, long secondID, String str){

        if (str.equals("People"))
            preparedStatement = insertMoviePeopleStat;

        if (str.equals("Awards"))
            preparedStatement = insertMovieAwardsStat;

        if (str.equals("Profession"))
            preparedStatement = insertPeopleProfessionStat;

        if (str.equals("Genres"))
            preparedStatement = insertMovieGenresStat;

        if (str.equals("PA"))
            preparedStatement = insertPeopleAwardsStat;


        try {
            preparedStatement.setLong(1, movieID);
            preparedStatement.setLong(2, secondID);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}