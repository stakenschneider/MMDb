public class Genres {
    long ID;
    String name;

    public Genres(long ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.valueOf(ID);
    }

}
