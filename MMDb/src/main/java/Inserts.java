import java.sql.*;

public class Inserts {

    private final Connection connection;

    private final String insertMovie = "INSERT INTO movie (name, releaseyear, rating, movielength, description, tagline) VALUES (?, ?, ?, ?, ?, ?)";

    private final String insertActors = "INSERT INTO actors (firstname, lastname, birth) VALUES (?, ?, ?)";

    private final String insertMovieGenres = "INSERT INTO moviegenres (movieid, genreid) VALUES (?, ?)";


    private final PreparedStatement insertMovieStat;
    private final PreparedStatement insertActorsStat;
    private final PreparedStatement insertMovieGenresStat;




    public Inserts (String url) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url ,"postgres", "754yrz2n");

        insertMovieStat = connection.prepareStatement(insertMovie);
        insertActorsStat= connection.prepareStatement(insertActors);
        insertMovieGenresStat = connection.prepareStatement(insertMovieGenres);
    }

    public boolean insertMovie(String name, int year, double rating, int length, String description, String tag) {
        try {
            insertMovieStat.setString(1, name);
            insertMovieStat.setInt(2, year);
            insertMovieStat.setDouble(3, rating);
            insertMovieStat.setInt(4, length);
            insertMovieStat.setString(5, description);
            insertMovieStat.setString(6, tag);
            insertMovieStat.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertActors(String firstName, String lastName) {
        try {

            insertActorsStat.setString(1, firstName);
            insertActorsStat.setString(2, lastName);
            insertActorsStat.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
            insertActorsStat.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertMovieGenres(long movieID, long genreID) {
        try {
            insertMovieGenresStat.setLong(1, movieID);
            insertMovieGenresStat.setLong(2, genreID);
            insertMovieGenresStat.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }



}
