import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Select {

        private final Connection connection;

        private final String getMovie = "SELECT * from movie";
        private final String getGenres = "SELECT * from genres";
        private final String getPeople = "SELECT * from people";
        private final String getProfession = "SELECT * from profession";
        private final String getAwards = "SELECT * from awards";


        private final PreparedStatement getMovieStat;
        private final PreparedStatement getGenresStat;
        private final PreparedStatement getPeopleStat;
        private final PreparedStatement getAwardsStat;
        private final PreparedStatement getProfessionStat;


        public Select (String url) throws ClassNotFoundException, SQLException {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url ,"postgres", "754yrz2n");

            getMovieStat = connection.prepareStatement(getMovie);
            getGenresStat = connection.prepareStatement(getGenres);
            getPeopleStat = connection.prepareStatement(getPeople);
            getAwardsStat = connection.prepareStatement(getAwards);
            getProfessionStat = connection.prepareStatement(getProfession);
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
                            resultSet.getString("description")
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

    public List<People> getPeople(){
        try {
            ResultSet resultSet = getPeopleStat.executeQuery();
            List<People> peoples = new ArrayList();

            while(resultSet.next()) {
                People people = new People(
                        resultSet.getLong("peopleID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getDate("birth")
                );
                peoples.add(people);
            }
            return peoples;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<Awards> getAwards(){
        try {
            ResultSet resultSet = getAwardsStat.executeQuery();
            List<Awards> awards = new ArrayList();

            while(resultSet.next()) {
                Awards award = new Awards(
                        resultSet.getLong("awardsID"),
                        resultSet.getString("name")
                );
                awards.add(award);
            }
            return awards;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public List<Profession> getProfession(){
        try {
            ResultSet resultSet = getProfessionStat.executeQuery();
            List<Profession> professions = new ArrayList();

            while(resultSet.next()) {
                Profession profession = new Profession(
                        resultSet.getLong("professionID"),
                        resultSet.getString("name")
                );
                professions.add(profession);
            }
            return professions;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }



    }
