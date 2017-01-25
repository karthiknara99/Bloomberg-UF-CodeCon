//Problem        : Binary Ouroboros
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;

public class BinaryOuroboros
{
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int k = stdin.nextInt();
        int iter = (int)Math.pow(2,n);
        
        if( k > iter )
            System.out.println("-1");
        else
        {
            String s = "01";
            while( s.length() <= k )
                s = s + s.replace('0', '_').replace('1', '0').replace('_', '1');
            System.out.println( s.charAt(k-1) );
        }
        
        stdin.close();
    }
    
}