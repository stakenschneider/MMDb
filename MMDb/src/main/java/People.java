import java.util.Date;

public class People {
    long ID;
    String firstName;
    String lastName;
    Date birth;

    public People(long ID, String firstName, String lastName, Date birth) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return String.valueOf(ID);
    }
}