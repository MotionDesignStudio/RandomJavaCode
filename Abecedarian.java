import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Abecedarian {
    
    public static void checkString ( String s){
        
        String convertedToLowerCase = s.toLowerCase();
        int ascii = 0;
        boolean isThisLess = true;
        
        for ( char c : convertedToLowerCase.toCharArray () ) {
            if ( ( ascii < ( int ) c ) && ( ( int ) c > 97 )  &&  ( ( int ) c <= 122 ) ){
                isThisLess = true;
            } else    {
                isThisLess = false;
                break;
            }
            ascii = ( int ) c;
            
        }
        
        if ( ( isThisLess ) && ( s.length () > 1 )  ) {
            System.out.printf ("%s %n", s);
        }

    }
    
   
    public static void main(String[] args) throws IOException {
        //String file_name = "englishWords.txt";
        //String file_name = "uscitites.txt"; 
        //String file_name = "test.txt";
        String file_name = args[0]; 
                
        // Read text file line by line and pass string for comparison 
        Files.lines(Paths.get ( file_name ) ).forEach (  n -> checkString ( n ) );
        //Files.lines(Paths.get ( file_name ) ).forEach (System.out:: println );
        //Files.lines(Paths.get ( file_name ) ).map(n -> " XX :: " + n ).forEach (System.out:: println );
        //Files.lines(Paths.get ( file_name ) ).forEach ( n -> System.out.println ( "XX : " + n ) );
        
        //Files.lines(Paths.get ( file_name ) ).map(n -> n.toLowerCase() ).forEach (System.out:: println );
        
    }
        

    
}

