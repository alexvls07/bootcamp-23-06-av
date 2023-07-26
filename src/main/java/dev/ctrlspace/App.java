package dev.ctrlspace;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );


        String password = "H3ll0!!!";
        int countNumber = 0;
        int countUpper = 0;
        int countLower = 0;

        for (int i = 0 ; i < password.length() ; i++) {
            char c = password.charAt(i);
            if(c >= '0' && c <= '9') {
                countNumber++;
            }
            if(c >= 'A' && c <= 'Z') {
                countUpper++;
            }
            if(c >= 'a' && c <= 'z') {
                countLower++;
            }



        }
        System.out.println("There are " + countNumber + " digits in the password");
        System.out.println("There are " + countUpper + " uppercase letters in the password");
        System.out.println("There are " + countLower + " lowercase letters in the password");


        for (int i = 0; i < 256; i++) {
            System.out.println((char)i + " -> " + i);
        }

        ///////////////////////////////////////////////////////



        int[] x = new int[5];

        x[0] = 7;
        x[1] = 5;
        x[2] = 6;
        x[3] = 9;


        printMatrix(x);

        // increase table size;
        int[] temp = new int[5];
        for (int i = 0; i < x.length; i++) {
            temp[i] = x[i];
        }
        temp[4] = 7;

        x = temp;

        List<Integer> l = new LinkedList<>();
//        List<Integer> l2 = new LinkedList<>();

        l.add(7);
        l.add(5);
        l.add(6);
        l.add(9);
        l.add(7);
        l.add(8);
        l.add(9);

        System.out.println(l);

        Set<String> s = new HashSet<>();

        s.add("Chris, Sekas, csekas@ctrlspace.dev");
        s.add("John, Doe, test@text.com");

        System.out.println(s);

//        {
//            1 -> "Chris, Sekas, csekas@ctrlspace.dev",
//            2 -> "John, Doe, test@text.com"
//        }

        Map<Integer, Person> m = new HashMap<>();



        Person chris = new Person("Chris", "Sekas", 31);
        Person john = new Person();
        john.setName("John");
        john.setSurname("Doe");
        john.setAge(30);

        m.put(532, chris);
        m.put(645, john);

        m.get(532);

        System.out.println(m);





    }

    public static void printMatrix(int[] m) {
        System.out.print("[");
        for (int i = 0; i < m.length - 1; i++) {
            System.out.print(m[i] + ", ");

        }
        System.out.println(m[m.length - 1]  + "]");
    }
}