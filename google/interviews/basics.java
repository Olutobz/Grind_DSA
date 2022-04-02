package interviews;

public class basics {
    String firstName = "Damola";
    String middleName = "Olutoba";
    String lastName = "Onikoyi";

    void display(String fname, String mName,String lName) {
        System.out.println(fname + mName + lastName);
    }

    public static void main(String[] args) {
        basics b = new basics();
        b.display(b.firstName, b.middleName, b.lastName);
    }
}
