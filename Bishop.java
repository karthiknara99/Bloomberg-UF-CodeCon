//Problem        : Bishop
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;

public class Bishop
{
    public static void main(String[] args)
    {

        Scanner stdin = new Scanner(System.in);
        int sB = stdin.nextInt();
        int eB = stdin.nextInt();
        int moves = 0;
        int sX, sY, eX, eY;
        
        sX = ( sB - 1 ) / 8;
        eX = ( eB - 1 ) / 8;
        sY = ( sB - 1 ) % 8;
        eY = ( eB - 1 ) % 8;
        
        if( sB == eB )
            moves = 0;
        else if ( ( ( ( sX + sY ) % 2 == 0 ) && ( ( eX + eY ) % 2 != 0 ) ) || ( ( ( sX + sY ) % 2 != 0 ) && ( ( eX + eY ) % 2 == 0 ) ) )
            moves = -1;
        else if ( ( sX + sY == eX + eY ) || ( sX - sY == eX - eY ) )
            moves = 1;
        else
            moves = 2;

        System.out.println(moves);
        stdin.close();
    }

}
