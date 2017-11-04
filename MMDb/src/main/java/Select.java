import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Select {

        private final Connection connection;

        private final String getMovieGenres = "SELECT * from moviegenres WHERE movieid = (?)";
        private final String getMovie = "SELECT * from movie";
        private final String getGenres = "SELECT * from genres";
        private final String getActors = "SELECT * from actors";
        private final String getDirectots = "SELECT * from directors";

        private final PreparedStatement getMovieGenresStat;
        private final PreparedStatement getMovieStat;
        private final PreparedStatement getGenresStat;
        private final PreparedStatement getActorsStat;
        private final PreparedStatement getDirectorsStat;

        public Select (String url) throws ClassNotFoundException, SQLException {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url ,"postgres", "754yrz2n");


            getMovieGenresStat = connection.prepareStatement(getMovieGenres);
            getMovieStat = connection.prepareStatement(getMovie);
            getGenresStat = connection.prepareStatement(getGenres);
            getActorsStat = connection.prepareStatement(getActors);
            getDirectorsStat = connection.prepareStatement(getDirectots);
        }

        public List<Movie> getMovie(){
            try {
                ResultSet resultSet = getMovieStat.executeQuery();
                List<Movie> movies = new ArrayList();

                while(resultSet.next()) {
                    Movie movie = new Movie(
                            resultSet.getLong("movieID"),
                            resultSet.getString("name"),
                            resultSet.getInt("releaseYear"),
                            resultSet.getDouble("rating"),
                            resultSet.getInt("movieLength"),
                            resultSet.getString("description"),
                            resultSet.getString("tagLine")
                    );
                    movies.add(movie);
                }
                return movies;
            } catch (SQLException e) {
                e.printStackTrace();
                return new ArrayList();
            }


        }

        public List<Genres> getGenre(){
            try {
                ResultSet resultSet = getGenresStat.executeQuery();
                List<Genres> genres = new ArrayList();

                while(resultSet.next()) {
                    Genres genre = new Genres(
                            resultSet.getLong("genreID"),
                            resultSet.getString("genrename")
                    );
                    genres.add(genre);
                }
                return genres;
            } catch (SQLException e) {
                e.printStackTrace();
                return new ArrayList();
            }

        }

    public List<Actors> getActor(){
        try {
            ResultSet resultSet = getActorsStat.executeQuery();
            List<Actors> actors = new ArrayList();

            while(resultSet.next()) {
                Actors actor = new Actors(
                        resultSet.getLong("actorID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getDate("birth")
                );
                actors.add(actor);
            }
            return actors;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<Directors> getDirectors(){
        try {
            ResultSet resultSet = getDirectorsStat.executeQuery();
            List<Directors> directors = new ArrayList();

            while(resultSet.next()) {
                Directors director = new Directors(
                        resultSet.getLong("directorsID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getDate("birth")
                );
                directors.add(director);
            }
            return directors;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
    }
