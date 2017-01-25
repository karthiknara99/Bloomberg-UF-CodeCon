//Problem        : Internal Fragmentation
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;
import java.math.*;

public class InternalFragmentation
{
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int f[] = new int[n];
        for( int i = 0; i < n; i++ )
            f[i] = stdin.nextInt();
        int c = stdin.nextInt();
        
        BigInteger count = new BigInteger("0");
        for( int i = 0; i < n; i++ )
        {
            BigInteger temp1 = new BigInteger( f[i] + "" );
            BigInteger temp2 = new BigInteger( c + "" );
            count = count.add( temp1.divide(temp2) );
            if( f[i] % c != 0 )
                count = count.add( new BigInteger("1") );
        }
        BigInteger b = new BigInteger( "" + c );
        count = count.multiply(b);
        
        System.out.println(count);
        stdin.close();
    }

}