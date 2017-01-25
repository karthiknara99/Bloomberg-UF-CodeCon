//Problem        : Chocolate Fix
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;

public class ChocolateFix
{
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        int cost, wrappers, noF;
        cost = Integer.parseInt(stdin.nextLine());
        wrappers = Integer.parseInt(stdin.nextLine());
        noF = Integer.parseInt(stdin.nextLine());
        
        for (int i = 0; i < noF; i++)
        {    
            int noc = Integer.parseInt(stdin.nextLine());
            noc /= cost;
            int wrap_left = noc;
            
            while( wrap_left >= wrappers )
            {
                int temp = wrap_left % wrappers;
                wrap_left /= wrappers;
                noc += wrap_left;
                wrap_left += temp;
            }
            
            System.out.println(noc);
        }
        
        stdin.close();
    }

}