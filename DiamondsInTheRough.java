//Problem        : Diamonds in the Rough
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.max;
import static java.lang.Math.min;
import java.util.Scanner;

public class DiamondsInTheRough
{
    public static boolean collinear( float x1, float y1, float x2, float y2, float x3, float y3 )
    {
        return (y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2);
    }
    public static boolean pntInTriangle( double px, double py, double x1, double y1, double x2, double y2, double x3, double y3 )
    {
        double o1 = getOrientationResult(x1, y1, x2, y2, px, py);
        double o2 = getOrientationResult(x2, y2, x3, y3, px, py);
        double o3 = getOrientationResult(x3, y3, x1, y1, px, py);

        return (o1 == o2) && (o2 == o3);
    }

    private static int getOrientationResult( double x1, double y1, double x2, double y2, double px, double py )
    {
        double orientation = ( (x2 - x1) * (py - y1) ) - ( (px - x1) * (y2 - y1) );
        if (orientation > 0)
            return 1;
        else if (orientation < 0)
            return -1;
        else
            return 0;
    }
   
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        float x1 = stdin.nextFloat();
        float y1 = stdin.nextFloat();
        float x2 = stdin.nextFloat();
        float y2 = stdin.nextFloat();
        float x3 = stdin.nextFloat();
        float y3 = stdin.nextFloat();
        
        float xmin = min( x1, min( x2, x3 ) );
        float xmax = max( x1, max(x2, x3 ) );
        float ymin = min( y1, min(y2, y3 ) );
        float ymax = max( y1, max( y2, y3 ) );
        
        int minx = (int)floor( xmin );
        int maxx = (int)ceil( xmax );
        int miny = (int)floor( ymin );
        int maxy = (int)ceil( ymax );

        int points = 0;
        
        for( int i = minx; i <= maxx; i++ )
            for( int j = miny; j <= maxy; j++ )
                if( i >= xmin && i <= xmax && j >= ymin && j <= ymax )
                    if( pntInTriangle( i, j, x1, y1, x2, y2, x3, y3 ) == true || collinear(x1, y1, i, j, x2, y2) == true || collinear(x1, y1, i, j, x3, y3) == true || collinear(x3, y3, i, j, x2, y2) == true )
                        points++;
        
        System.out.println(points);
        stdin.close();
    }

}