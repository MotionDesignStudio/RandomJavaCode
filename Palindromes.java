import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Palindromes {
    
    public static void checkString ( String s){
        
        String firstHalf = "";
        String secondHalf = "";
        String convertedToLowerCase = s.toLowerCase();
        
        if ( s.length() % 2 == 0 ){
            
            firstHalf = convertedToLowerCase.substring(0, convertedToLowerCase.length()/2);

            for (int i =0; i< convertedToLowerCase.length()/2; i++ ){
                secondHalf += convertedToLowerCase.charAt( ( convertedToLowerCase.length()-1 ) - i);
            }
                        
            // Display found even number in length Palindromes words 
            if (( secondHalf.equals ( firstHalf ) ) && convertedToLowerCase.length() >1 ){
                System.out.printf ("%s%n", s );
            }
            
        } else { 
            //System.out.printf ("%s %n", convertedToLowerCase );
            firstHalf = convertedToLowerCase.substring(0, convertedToLowerCase.length()/2);
            for (int i = convertedToLowerCase.length()-1; i> convertedToLowerCase.length()/2; i-- ){
                secondHalf += convertedToLowerCase.charAt( i );
                
            }
           
            // Display found odd number in length Palindromes words 
            if (( secondHalf.equals ( firstHalf ) ) && convertedToLowerCase.length() > 1 ){
                System.out.printf ("%s%n", s );
            }
            
        }
    }
    
   
    public static void main(String[] args) throws IOException {
        //String file_name = "englishWords.txt";
        //String file_name = "uscitites.txt"; 
        String file_name = args[0]; 
                
        // Read text file line by line and pass string for comparison 
        Files.lines(Paths.get ( file_name ) ).forEach (  n -> checkString ( n ) );
        //Files.lines(Paths.get ( file_name ) ).forEach (System.out:: println );
        //Files.lines(Paths.get ( file_name ) ).map(n -> " XX :: " + n ).forEach (System.out:: println );
        //Files.lines(Paths.get ( file_name ) ).forEach ( n -> System.out.println ( "XX : " + n ) );
        
        //Files.lines(Paths.get ( file_name ) ).map(n -> n.toLowerCase() ).forEach (System.out:: println );
        
    }
        

    
}

