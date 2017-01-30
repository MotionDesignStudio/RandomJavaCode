import java.util.Scanner;
import java.util.Random;

public class guessingGame {
    public static void main(String[] args){
      
       Scanner in = new Scanner(System.in);
       
       Random random =  new Random();
       final int MAXNUMBER = 100;
       int randomNumber = random.nextInt(MAXNUMBER)+1;
       int countNumberOfGuess = 0;
       
       int guessedNumber;
      
       System.out.printf ("I'm thinking of a number between 0 and %d.  Can you guess what it is?\n", MAXNUMBER);
       
       do {
           countNumberOfGuess+=1;
           System.out.printf ("Guess a number between 0 - %d : ", MAXNUMBER);
           guessedNumber = in.nextInt();
           
           // Help the user know if they are guessing in the correct order
           if ( guessedNumber < randomNumber ) {
                System.out.printf ("You guessed %d, try guessing higher\n", guessedNumber);
           } else if ( guessedNumber > randomNumber ) {
               System.out.printf ( "You guessed %d, try guessing lower\n", guessedNumber );
           } else if ( guessedNumber == randomNumber ) {
                System.out.printf ("You guessed %d.  You are corect using %d guesses!%n", guessedNumber, countNumberOfGuess);
           }
           

       } while ( guessedNumber != randomNumber );

}
}