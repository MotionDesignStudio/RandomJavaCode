import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

public class anagrams {
    
    public static void checkString ( String stringFromList, String originalString , String originalStringFromList ){
        
        StringBuilder sbstringFromList = new StringBuilder ( stringFromList );
        StringBuilder sboriginalString = new StringBuilder ( originalString );
        
        // This variable terminates the loop
        // If the set to true it means there is a matched character and there might be more
        // If it remain false it means the first character in the originalString has no match in the stringFromList
        // move on to the next word.
        
        boolean searched = false;
        
        
        if ( ( stringFromList.length() == originalString.length() ) &&  ( sbstringFromList.length() !=0 ) ){
            
            for ( int i=0; i< sbstringFromList.length(); i++ ) {
                if ( sboriginalString.charAt(0) == sbstringFromList.charAt (i)  ){
                    searched = true;
                    sboriginalString.deleteCharAt (0);
                    sbstringFromList.deleteCharAt ( i );
                    
                    if ( sbstringFromList.length() == 0 ) {
                        System.out.printf ("%s%n", originalStringFromList );
                    }
                    
                    break;
                }
            }
                        
        }
        
        if ( searched ) {
            checkString ( sbstringFromList.toString() , sboriginalString.toString() , originalStringFromList ); 
        }


    }
    
   
    public static void main(String[] args) throws IOException {
        //String file_name = "englishWords.txt";
        //String file_name = "uscitites.txt"; 
        //String file_name = "test.txt";
        String file_name = args[0]; 
        
        //String findAnagramsOfMe ="xle";
        
        String findAnagramsOfMe = args[1]; 
                
        // Read text file line by line and pass string for comparison 
        Files.lines(Paths.get ( file_name ) ).forEach (  n -> checkString ( n.toLowerCase() , findAnagramsOfMe.toLowerCase(), n ) );
        //Files.lines(Paths.get ( file_name ) ).forEach (System.out:: println );
        //Files.lines(Paths.get ( file_name ) ).map(n -> " XX :: " + n ).forEach (System.out:: println );
        //Files.lines(Paths.get ( file_name ) ).forEach ( n -> System.out.println ( "XX : " + n ) );
        
        //Files.lines(Paths.get ( file_name ) ).map(n -> n.toLowerCase() ).forEach (System.out:: println );
        
    }
        

    
}

