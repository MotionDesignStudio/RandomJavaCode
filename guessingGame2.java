// import java.util.Scanner;
// import java.util.Random;
import java.util.*;

public class guessingGame2 {
    
    private String playerName;
    private int numberOfTries;
    private int numberOfWins;
    private int numberOfGamesPlayed;
    private int totalSumeOfGuesses;
    private int numberOfLosses;
    private boolean activeStatus;
    
    // Set Default Values
    public guessingGame2 () {
        this.playerName = "Jane Doe";
        this.numberOfTries = 0;
        this.numberOfWins = 0;
        this.numberOfGamesPlayed = 0;
        this.totalSumeOfGuesses = 0;
        this.numberOfLosses = 0;
        this.activeStatus = true;
    }
    
    public guessingGame2 ( String playerName ) {
        this.playerName = playerName;
    }
    
    //  *** GET VALUES ** //
    
    public String getName  (){
        return this.playerName;
    }
    
    public int getNumberOfTries  (){
        return this.numberOfTries;
    }
    
    public int getNumberOfLosses  (){
        return this.numberOfLosses;
    }
    
    public int getNumberOfWins  (){
        return this.numberOfWins;
    }
    
    public int getAttemptStats  (){
        
        if ( ( this.totalSumeOfGuesses == 0) || ( this.numberOfGamesPlayed == 0) ) {
            return 0;
        }else {
            return this.totalSumeOfGuesses/this.numberOfGamesPlayed;
        }
        
    }
    
    //  *** SET VALUES ** //
    
    public void setName ( String setPlayerName ){
        this.playerName = setPlayerName;   
    }
    
    //public void setNumberOfTries ( int setNumberOfTries ){
    public void setNumberOfTries ( ){
        this.numberOfTries += 1;
    }
    
    //public void setNumberOfWins ( int setNumberOfWins ){
    public void setNumberOfWins ( ){
        this.numberOfWins += 1;
    }
    
    //public void setNumberOfGamesPlayed ( int setNumberOfGamesPlayed ){
    public void setNumberOfGamesPlayed ( ){
        this.numberOfGamesPlayed += 1;
    }    
    
    // Set total number of tries
    public void setTotalSumeOfGuesses ( ){
        this.totalSumeOfGuesses += this.numberOfTries;
    }
    
    // Set total number of losses
    public void setNumberOfLosses ( ){
        this.numberOfLosses += 1;
    }  
    
    public void resetStatus ( ){
        this.numberOfTries = 0;
        this.numberOfWins = 0;
        this.activeStatus = true;
    }
    
    public void resetNumberOfTries ( ){
        this.numberOfTries = 0;
    }
    
    public static void printStatus ( guessingGame2 t ){
        System.out.printf ("Name: %s # Tries: %d%n", t.playerName, t.numberOfTries );
    }
    
    // Begin Game Logic
    
    // Add Player
    
    public static void addPlayer ( String newPlayerName , List <guessingGame2> listOfPlayers ){          
        
        listOfPlayers.add ( new guessingGame2 ( newPlayerName )  );
        
    }
    
    public static void gameGreeting ( String whatShouldIdisplay ){      
        
        switch ( whatShouldIdisplay ){
            case "1" : 
                System.out.printf ("%s%n", "This is a commandline guessing game." );
                break;
            case "2" : 
                System.out.printf ("%s%n", "Choose a random number between 1 - X" );
                break;
        }
    }
    
    
    public static int initGame ( ){ 
        Scanner in = new Scanner(System.in);
        int upperLimitNumber = 0;
        String input = "";
                
        while ( true ) {
            System.out.printf ("%s%n", "Choose a number for the upper limits of guessing." );
            input = in.next();
            
            try {
                upperLimitNumber = Integer.parseInt ( input );
                break;
            } catch ( NumberFormatException ne) {
                System.out.printf ( "%s%n", "\""+ input + "\", is not a number try again." );
            }
            
        }
        
        return upperLimitNumber;
    }
    
    public static String initGameGetFirstPlayerName ( ){ 
       Scanner in = new Scanner(System.in);

       System.out.printf ("%s%n", "Type a new player name." );
       String input = in.next();
       System.out.printf ("%s%n", "Your new player's name is \"" + input + "\"." );
       return input;
    }
    
    // Delete player
    public static void deletePlayer ( List <guessingGame2> listOfPlayers ){ 
        
        Scanner in = new Scanner(System.in);
        
        boolean shouldIloop = true;
        
        System.out.printf ("%s%n", "Type the name of the player you would like to delete.  \nThis is case sensative."  );
        for ( int i = 0; i < listOfPlayers.size (); i++ ) {
            System.out.printf ("Player : %s%n", listOfPlayers.get( i ).getName()  );
        }
        
        while ( shouldIloop ) {
            
            String input = in.next();

            for ( int i = 0; i < listOfPlayers.size (); i++ ) {

                    if ( input.equals ( listOfPlayers.get( i ).getName() ) ){
                        System.out.printf ("%n%nRemoving Player : %s%n%n", listOfPlayers.get( i ).getName() );
                        listOfPlayers.remove ( i );
                        
                        // Display how many player(s) left
                        for ( int ii = 0; ii < listOfPlayers.size (); ii++ ) {
                            System.out.printf ("Remaining Player(s) : %s%n%n", listOfPlayers.get( ii ).getName()  );
                        }
                        
                        shouldIloop = false;
                    } else if ( (shouldIloop == true) && (i == listOfPlayers.size ()-1) ) {
                        System.out.printf ("%s%n", "Player " + input+ " does not exist." );
                        System.out.printf ("%s%n", "Type the name of the player you would like to delete?"  );
                        for ( int ii = 0; ii < listOfPlayers.size (); ii++ ) {
                            System.out.printf ("Player : %s%n", listOfPlayers.get( ii ).getName()  );
                        }
                    }
            }
            
        }
        
    }
    
    public static void displayStats ( List <guessingGame2> listOfPlayers ){ 
        System.out.printf ("%n");
            for ( int i = 0; i < listOfPlayers.size (); i++ ) {
                System.out.printf ("%10s %5s %s %3d %s %3d %s %3d%n", "Player :: ", listOfPlayers.get( i ).getName(), " Number Of Wins :", listOfPlayers.get( i ).getNumberOfWins(), " Average Guesses :", listOfPlayers.get( i ).getAttemptStats(), "  Number Of Looses :", listOfPlayers.get( i ).getNumberOfLosses() );
            }
        System.out.printf ("%n");
    }
    
    public static void incrementAllPlayersNumberOfGamesPlayed ( List <guessingGame2> listOfPlayers ){ 
        
            for ( int i = 0; i < listOfPlayers.size (); i++ ) {
               listOfPlayers.get( i ).setNumberOfGamesPlayed();
            }
    }
    
    public static void incrementAllPlayersTotalSumeOfGuesses ( List <guessingGame2> listOfPlayers ){ 
        
            for ( int i = 0; i < listOfPlayers.size (); i++ ) {
                    listOfPlayers.get( i ).setTotalSumeOfGuesses();
            }
    }
    
    public static void incrementAllPlayersNumberOfNumberOfLosses ( List <guessingGame2> listOfPlayers, int gameWinner ){ 
        
            for ( int i = 0; i < listOfPlayers.size (); i++ ) {
                if ( i != gameWinner) {
                    listOfPlayers.get( i ).setNumberOfLosses();
                }
            }
    }
    
    
    public static void resetNumberOfTriesForAllPlayers ( List <guessingGame2> listOfPlayers ){ 
        
            for ( int i = 0; i < listOfPlayers.size (); i++ ) {
               listOfPlayers.get( i ).resetNumberOfTries();
            }
    }
    
    public static void startPlaying ( List <guessingGame2> listOfPlayers ){
        
        Random random =  new Random();
        
        // Set number for random shuffle
        int numberToRandomize = initGame ( );
        
        // Randomize the starting number
        int randomNumber = random.nextInt( numberToRandomize )+1;
        
        // Set default user
        addPlayer ( initGameGetFirstPlayerName () ,  listOfPlayers);
        
        int whoseTurnIsIt = -1;
        // System.out.printf (" randomNumber :: %d%n%n", randomNumber );
        
        Scanner in = new Scanner(System.in);
        boolean shouldIloop = true;
        while ( shouldIloop ) {
            
            // Choose the next player
            if ( whoseTurnIsIt < listOfPlayers.size ()-1 ){
                whoseTurnIsIt +=1;
            } else{
                whoseTurnIsIt = 0;
            }
            System.out.printf ("%s%n","[q]uit | [a]dd player | [d]elete player | [c]change number range | [g]et stats");
            System.out.printf ("%n\"%s\", I am thinking of a number between 0 and %d.  Can you guess what it is?\n%n", listOfPlayers.get( whoseTurnIsIt ).getName() , numberToRandomize);
            
            String input = in.next();
            
            // System.out.printf ("%s%n","[\033[1m q \033[0m]uit | [\033[1m a \033[0m]dd | [\033[1m d \033[0m]elete | [\033[1m g \033[0m] et stats");
                        
            try {
                Integer.parseInt ( input );
                
               // Help the user know if they are guessing in the correct order
               if ( Integer.valueOf (input) < randomNumber ) {
                   // Add to the number of guesses
                   listOfPlayers.get( whoseTurnIsIt ).setNumberOfTries();
                   
                   System.out.printf ("%nYou guessed %d, try guessing higher ↑%n%n", Integer.valueOf (input));
               } else if ( Integer.valueOf (input) > randomNumber ) {
                   // Add to the number of guesses
                   listOfPlayers.get( whoseTurnIsIt ).setNumberOfTries();                
                   System.out.printf ( "%nYou guessed %d, try guessing lower ↓%n%n", Integer.valueOf (input) );
               } else if ( Integer.valueOf (input) == randomNumber ) {
                   
                   // Add to the number of guesses
                   listOfPlayers.get( whoseTurnIsIt ).setNumberOfTries();
                   
                   // If equal add a win to the users stats
                   listOfPlayers.get( whoseTurnIsIt ).setNumberOfWins();
                   
                   // Increment the number of games played for each player
                   incrementAllPlayersNumberOfGamesPlayed ( listOfPlayers );
                   
                   // Increment the number of losses for none winning player(s)
                   incrementAllPlayersNumberOfNumberOfLosses( listOfPlayers, whoseTurnIsIt );
                   
                   // Add sum of total tries
                   incrementAllPlayersTotalSumeOfGuesses ( listOfPlayers );
                       
                   System.out.printf ("%n\"%s\", you guessed %d, using %d guesses! You have %d wins.%n%n", listOfPlayers.get( whoseTurnIsIt ).getName(), Integer.valueOf (input), listOfPlayers.get( whoseTurnIsIt ).getNumberOfTries (), listOfPlayers.get( whoseTurnIsIt ).getNumberOfWins () );
                   
                   //Change the random number
                   randomNumber = random.nextInt( numberToRandomize )+1;

                   // Reset number of tries
                   resetNumberOfTriesForAllPlayers ( listOfPlayers );
               }
                
            } catch ( NumberFormatException ne) {
 
                if ( input.equals("q")){
                    shouldIloop = false;
                }else if ( input.equals("a") ) {
                    addPlayer ( initGameGetFirstPlayerName () ,  listOfPlayers);
                }else if ( input.equals("d") ) {
                    // Check if there is less than 1 player.  If yes you can not have zero sum players
                    if ( listOfPlayers.size() <2 ){
                        System.out.printf ("%n%s%n%n", "You can not delete the only player." );
                    }else{
                        deletePlayer ( listOfPlayers );
                    }
                 }else if ( input.equals("c") ) { // Change the random number range
                     numberToRandomize = initGame ( );
                     randomNumber = random.nextInt( numberToRandomize )+1;
                 }else if ( input.equals("g") ) {
                     displayStats ( listOfPlayers );
                }
            }
                        
        }
    }

    // End Game Logic
    
    public static void main(String[] args){
        
           List<guessingGame2> listOfPlayers = new ArrayList<guessingGame2>();
           
           startPlaying ( listOfPlayers );        
    }
    

    
}
