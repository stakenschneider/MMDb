import java.util.Date;

public class Directors {
    long directorID;
    String firstName;
    String lastName;
    Date birth;

    public Directors(long directorID, String firstName, String lastName, Date birth) {
        this.directorID = directorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return String.valueOf(directorID);
    }
}
