import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Doubloon {
    
    public static void checkString ( String s, String originalString , String previouslySearchedString){
        
        String convertedToLowerCase = s.toLowerCase();
        
        StringBuilder sb = new StringBuilder ( convertedToLowerCase );
       
       int numberOfOccurrence = 0;
       int deleteCharacter = 0;
       boolean searched = false;
       
       //Check if the first character was previously searched for
        for ( int i=0; i< previouslySearchedString.length(); i++ ) {
                            
                if ( sb.charAt(0) == previouslySearchedString.charAt (i)  ){
                    searched = true;
                }
        }
       
       for ( int i=0; i< sb.length(); i++ ) {
           if ( sb.charAt (0) ==  sb.charAt (i) ){
               numberOfOccurrence++;
               deleteCharacter = i;
           }
           
           // If the string has more than two of the same letters move on to the next string
           if ( numberOfOccurrence >  2 ){
               break;               
           }                       
            
        }
       
           // Delete the first letter in the string and its occurance
            if ( numberOfOccurrence ==  2 ){
                previouslySearchedString += sb.charAt ( 0 );
                
                sb.deleteCharAt ( deleteCharacter );
                sb.deleteCharAt (0);
                                
                // End recursive call if the string length is equal to 0
                if ( sb.length() !=0 ) {
                    checkString (sb.toString(), originalString, previouslySearchedString );
                }
                
            }
                   
       // Output test positive if the string is zero in length
          if ( sb.length() == 0 ){
              System.out.printf ("%s%n", originalString );
           }

    }
    
   
    public static void main(String[] args) throws IOException {
        //String file_name = "englishWords.txt";
        //String file_name = "uscitites.txt"; 
        //String file_name = "test.txt";
        String file_name = args[0]; 
        
        String previouslySearched ="";
                
        // Read text file line by line and pass string for comparison 
        Files.lines(Paths.get ( file_name ) ).forEach (  n -> checkString ( n, n, previouslySearched ) );
        //Files.lines(Paths.get ( file_name ) ).forEach (System.out:: println );
        //Files.lines(Paths.get ( file_name ) ).map(n -> " XX :: " + n ).forEach (System.out:: println );
        //Files.lines(Paths.get ( file_name ) ).forEach ( n -> System.out.println ( "XX : " + n ) );
        
        //Files.lines(Paths.get ( file_name ) ).map(n -> n.toLowerCase() ).forEach (System.out:: println );
        
    }
        

    
}

