public class Profession {
    long ID;
    String name;

    public Profession(long ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.valueOf(ID);
    }

}
