import java.sql.*;

public class Inserts {

    private final Connection connection;

    private final String insertMovie = "INSERT INTO movie (name, releaseyear, rating, movielength, description, tagline) VALUES (?, ?, ?, ?, ?, ?)";
    private final String insertDirectors = "INSERT INTO directors (firstname, lastname, birth) VALUES (?, ?, ?)";
    private final String insertActors = "INSERT INTO actors (firstname, lastname, birth) VALUES (?, ?, ?)";
    private final String insertMovieDirectors = "INSERT INTO moviedirectors (movieid, directorid) VALUES (?, ?)";
    private final String insertMovieGenres = "INSERT INTO moviegenres (movieid, genreid) VALUES (?, ?)";
    private final String insertMovieActors = "INSERT INTO movieactors (movieid, actorid) VALUES (?, ?)";

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

    public boolean insertDirectors(String firstName, String lastName) {
        try {

            insertDirectorsStat.setString(1, firstName);
            insertDirectorsStat.setString(2, lastName);
            insertDirectorsStat.setDate(3, new java.sql.Date((long) 12312));
            insertDirectorsStat.execute();
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

    public boolean insertMovieActors(long movieID, long actorID){
        try {
            insertMovieActorsStat.setLong(1, movieID);
            insertMovieActorsStat.setLong(2, actorID);
            insertMovieActorsStat.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertMovieDirectors(long movieID, long directorID){
        try {
            insertMovieDirectorsStat.setLong(1, movieID);
            insertMovieDirectorsStat.setLong(2, directorID);
            insertMovieDirectorsStat.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }



}
