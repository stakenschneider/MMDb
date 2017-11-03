import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Select {

        private final Connection connection;

        private final String getMovieGenres = "SELECT * from moviegenres WHERE movieid = (?)";
        private final String getMovie = "SELECT * from movie";
        private final String getGenres = "SELECT * from genres";

        private final PreparedStatement getMovieGenresStat;
        private final PreparedStatement getMovieStat;
        private final PreparedStatement getGenresStat;

        public Select (String url) throws ClassNotFoundException, SQLException {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url ,"postgres", "754yrz2n");


            getMovieGenresStat = connection.prepareStatement(getMovieGenres);
            getMovieStat = connection.prepareStatement(getMovie);
            getGenresStat = connection.prepareStatement(getGenres);

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
                            resultSet.getLong("genresID"),
                            resultSet.getString("name")
                    );
                    genres.add(genre);
                }
                return genres;
            } catch (SQLException e) {
                e.printStackTrace();
                return new ArrayList();
            }

        }

        public List<MovieGenres> getMovieGenres(long movieID) {
            try {
                getMovieGenresStat.setLong(1, movieID);
                ResultSet resultSet = getMovieGenresStat.executeQuery();
                List<MovieGenres> movieGenres = new ArrayList();
                while(resultSet.next()) {
                    MovieGenres movieGenre = new MovieGenres(
                            resultSet.getLong("movieGenresID"),
                            resultSet.getLong("movieID"),
                            resultSet.getLong("genreID")
                    );
                    movieGenres.add(movieGenre);
                }
                return movieGenres;
            } catch (SQLException e) {
                e.printStackTrace();
                return new ArrayList();
            }
        }

    }
