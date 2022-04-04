package interviews;

public class basics {
    String firstName = "Damola";
    String middleName = "Olutoba";
    String lastName = "Onikoyi";
    static int a = 24;
    static int b = 49;

    void display(String fname, String mName,String lName) {
        System.out.println(fname + mName + lastName);
    }
    
    int sum () {
        return a + b;
    }

    public static void main(String[] args) {
        basics b = new basics();
        b.display(b.firstName, b.middleName, b.lastName);
    }
}
