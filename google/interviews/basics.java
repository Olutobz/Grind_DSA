package interviews;

import java.util.HashMap;

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

    int subtraction() {
        return a - b;
    }
    
    int multiply() {
        return a * b;
    }

    String joinWords(String [] words) {
        String sentence = "";
        for (String w : words) {
            sentence = sentence + w;
        }
        return sentence;
    }
  
    public static void main(String[] args) {
        basics b = new basics();
        b.display(b.firstName, b.middleName, b.lastName);

        for(int i=0; i < 10; i++) {
        System.out.print(i + "");
    }

    HashMap<String, Integer> dict = new HashMap<>();
    dict.put("toba", 1);
    dict.put("damola", 2);
    dict.put("onikoyi", 3);
    dict.put("SWE Intern", 4);

    }
}
