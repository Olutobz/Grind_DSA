// Leetcode Arrays Explore Card

public class DVD {
    private final String name;
    private final String director;
    private final int releaseYear;

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
        dvds[3] = new DVD("Stranger Things 4", "Netflix", 2020);
        dvds[4] = new DVD("Manifest", "HBO", 2020);
        dvds[5] = new DVD("All American", "HBO", 2020);
        dvds[6] = new DVD("Silicon Valley", "HBO", 2017);

        System.out.println(dvds[0]);
        System.out.println(dvds[1]);
        System.out.println(dvds[2]);
        System.out.println(dvds[3]);
        System.out.println(dvds[4]);
        System.out.println(dvds[5]);
        System.out.println(dvds[6]);

    }
}
