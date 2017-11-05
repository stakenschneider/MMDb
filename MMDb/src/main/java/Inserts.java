import java.sql.*;
import java.sql.Date;


public class Inserts {

    private final Connection connection;

    private final String insertMovie = "INSERT INTO movie (name, releaseyear, rating, movielength, description) VALUES (?, ?, ?, ?, ?)";
    private final String insertDirectors = "INSERT INTO directors (firstname, lastname, birth) VALUES (?, ?, ?)";
    private final String insertActors = "INSERT INTO actors (firstname, lastname, birth) VALUES (?, ?, ?)";
    private final String insertMovieDirectors = "INSERT INTO moviedirectors (movieid, directorid) VALUES (?, ?)";
    private final String insertMovieGenres = "INSERT INTO moviegenres (movieid, genreid) VALUES (?, ?)";
    private final String insertMovieActors = "INSERT INTO movieactors (movieid, actorid) VALUES (?, ?)";

    private  PreparedStatement preparedStatement;
    private final PreparedStatement insertMovieStat;
    private final PreparedStatement insertActorsStat;
    private final PreparedStatement insertDirectorsStat;
    private final PreparedStatement insertMovieGenresStat;
    private final PreparedStatement insertMovieActorsStat;
    private final PreparedStatement insertMovieDirectorsStat;


    public Inserts (String url) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url ,"postgres", "754yrz2n");

        insertMovieStat = connection.prepareStatement(insertMovie);
        insertActorsStat = connection.prepareStatement(insertActors);
        insertDirectorsStat = connection.prepareStatement(insertDirectors);
        insertMovieGenresStat = connection.prepareStatement(insertMovieGenres);
        insertMovieActorsStat = connection.prepareStatement(insertMovieActors);
        insertMovieDirectorsStat = connection.prepareStatement(insertMovieDirectors);
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


    public boolean insertPeople(String firstName, String lastName, Date birth, String str) {
        if (str.equals("Actors"))
            preparedStatement = insertActorsStat;
        else preparedStatement = insertDirectorsStat;

        try {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setDate(3, birth);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insert_many2many(long movieID, long secondID, String str){

        if (str.equals("Actors"))
            preparedStatement = insertMovieActorsStat;

        if (str.equals("Directors"))
            preparedStatement = insertMovieDirectorsStat;

        if (str.equals("Genres"))
            preparedStatement = insertMovieGenresStat;

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
