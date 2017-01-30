import java.util.Scanner;
import java.text.AttributedString;

public class BeersOnWall {
    
   
    public static void addShit (int a, int b){
        int tmp = a+b;
         System.out.printf("The sum of %d + %d = %d \n", a,b,tmp);
    }
    
    
    public static void countDownBottles ( int startNum ) {
                
        if (startNum > 0){
            System.out.printf("%d bottles of beer on the wall,\n%d bottles of beer,\nya’ take one down, ya’ pass it around,\n%d bottles of beer on the wall. \n\n", startNum, startNum, startNum-1);
        } else if ( startNum == 0 ) {
            System.out.printf ("%s", "No bottles of beer on the wall,\nno bottles of beer,\nya’ can’t take one down, ya’ can’t pass it around,\ncause there are no more bottles of beer on the wall!\n\n");
            return;
        }
        countDownBottles ( startNum-1);
    }
    
    public static void main(String[] args){
      
      countDownBottles (99);

    }
    
    
}