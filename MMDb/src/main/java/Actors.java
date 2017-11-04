import java.util.Date;

public class Actors {
    long actorsID;
    String firstName;
    String lastName;
    Date birth;

    public Actors(long actorsID, String firstName, String lastName, Date birth) {
        this.actorsID = actorsID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return String.valueOf(actorsID);
    }
}
