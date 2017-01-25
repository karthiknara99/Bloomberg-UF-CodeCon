//Problem        : Amazonian Languages
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;

public class AmazonianLanguages
{
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        int prefixLength, noOfMatches, noBase, noComp, i, j;
        int count = 0;
        prefixLength = Integer.parseInt(stdin.nextLine());
        noOfMatches = Integer.parseInt(stdin.nextLine());
        noBase = Integer.parseInt(stdin.nextLine());
        noComp = Integer.parseInt(stdin.nextLine());
        String[] base = new String[noBase];
        String[] comp = new String[noComp];
        for( i = 0; i < noBase; i++ )
            base[i] = stdin.nextLine();
        for( i = 0; i < noComp; i++ )
            comp[i] = stdin.nextLine();
        
        for( i = 0; i < noComp; i++ )
        {
            float le = (float)comp[i].length() / 100 * prefixLength;
            int len = (int)Math.ceil(le);
            String toMatch = comp[i].substring(0, len);
                        
            for( j = 0; j < noBase; j++ )
            {
                if( base[j].startsWith(toMatch) )
                {
                    count++;
                    break;
                }
            }
        }
        
        float re = (float)count / noComp * 100;
        int res = (int)re;
        if ( res < noOfMatches )
            System.out.println("0");
        else
            System.out.println(res);
        
        stdin.close();
    }

}
