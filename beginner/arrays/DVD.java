package arrays;

public class DVD {
    private String name;
    private String director;
    private int releaseYear;

    public DVD(String name, String director, int releaseYear) {
        this.name = name;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return this.name + ", directed by " + this.director + ", released in " + this.releaseYear;
    }

    public static void main(String[] args) {
        DVD[] dvds = new DVD[15];
        dvds[0] = new DVD("Spider-Man", "Marvel", 2008);
        dvds[1] = new DVD("Super-Man", "DC Comics", 1999);
        dvds[2] = new DVD("Avengers", "Marvel", 2018);
        System.out.println(dvds[0]);
        System.out.println(dvds[1]);
        System.out.println(dvds[2]);
    }
}
