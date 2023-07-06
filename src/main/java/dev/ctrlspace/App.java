package dev.ctrlspace;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )

    {
        System.out.println( "Hello World!" );

        String password = "H8ello4";
        int countnumber = 0;
        int countupper = 0;
        int countlower = 0;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (c >= '0' && c>='9'){
                countnumber++;
            }
            if (c >='A' && c<='Z') {
                countupper++;
            }
            if (c >='a' && c<='z') {
                countlower++;
            }

        }
        System.out.println( "There are " +countnumber+ " numbers in password" );
        System.out.println( "There are "+countupper+" upper in password" );
        System.out.println( "There are " +countlower+ " lower in password" );

        ///////////////////////////



        int[] x = new int[4];

        x[0]=7;
        x[1]=2;
        x[2]=7;
        x[3]=6;
        x[4]=9;


        System.out.println(x);
        System.out.printl("[");
        for (int i = 0; i < x.length - 1 ; i++) {


        }


    }
}
