import java.io.IOException;

//import java.util.Arrays;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements; 

public class ScrabbleHelper {
    
    public static void checkString ( String stringFromList, String originalString , String charactersProvided, String positionOfNoasterisks ){
        
        StringBuilder sbstringFromList = new StringBuilder ( stringFromList );
        StringBuilder sboriginalString = new StringBuilder ( originalString );
        StringBuilder sbcharactersProvided = new StringBuilder ( charactersProvided );
               
        String buildString[]=new String [ originalString.length () ];

        if ( stringFromList.length() == originalString.length() ){
            
            
            for ( int i=0; i< sbstringFromList.length(); i++ ) {
                               
                // Check if the current position should be ignored
                if ( positionOfNoasterisks.indexOf ( Integer.toString( i ) ) == -1) {

                    if ( sbcharactersProvided.indexOf ( String.valueOf ( sbstringFromList.charAt( i ) ) ) != -1 ){
                        buildString [ i ] = String.valueOf ( sbstringFromList.charAt( i ) )  ;
                        sbcharactersProvided.deleteCharAt(  sbcharactersProvided.indexOf ( String.valueOf ( sbstringFromList.charAt( i ) ) )  );
                    }
                } else {
                    // If position is ignored insert the character here found at that position in the string 
                    // findMe value.
                    buildString [ i ] = String.valueOf ( sboriginalString.charAt ( i ) )  ;
                }
                
             }
            
            String compareString = "";
            
            // Build a string from array
            for ( int i=0; i< buildString.length; i++ ) {
                compareString += buildString [i];
            }
            
            // Compare array to original string 
            if ( compareString.compareTo( stringFromList ) == 0) {
                System.out.printf ("%s%n" , stringFromList );
            }
        }
        
    }
    
    public static String findPositionOfCharacters ( String s ){
        StringBuilder sbs = new StringBuilder ( s );
        String characterPositions = "";
        for ( int i=0; i< s.length(); i++ ) {
            if ( sbs.charAt (i) != '*'){
                characterPositions += i;               
            }
        }
        return characterPositions;
    }
      
    public static void getDefinition ( String s , String whichSource) throws IOException {

        String theUrl = "";
        if ( whichSource.equals ("d1") ){
            theUrl = "http://www.thefreedictionary.com/" + s;
        
            Document doc = Jsoup.connect ( theUrl ).get();
            
            Element definitionClass = doc.getElementsByClass ( "pseg").first();
            System.out.printf("%nSEARCHING : %s%n%n", theUrl); 
            System.out.printf("%s : %s%n", s,  definitionClass.text()); 
        }
        
        
        if ( whichSource.equals ("d2") ){
            theUrl = "https://www.merriam-webster.com/dictionary/" + s;
        
            Document doc = Jsoup.connect ( theUrl ).get();
            
            Element definitionClass = doc.getElementsByClass ( "card-primary-content").first();
            System.out.printf("%nSEARCHING : %s%n%n", theUrl); 
            System.out.printf("%s : %s%n", s,  definitionClass.text()); 
        }
        
        if ( whichSource.equals ("d3") ){
            theUrl = "http://www.dictionary.com/browse/" + s;
        
            Document doc = Jsoup.connect ( theUrl ).get();
            
            Element definitionClass = doc.getElementsByClass ( "source-data").first();
            System.out.printf("%nSEARCHING : %s%n%n", theUrl); 
            System.out.printf("%s : %s%n", s,  definitionClass.text()); 
        }
                
    }
   
    public static void main(String[] args) throws IOException {
        String file_name = "englishWords.txt";
        //String file_name = "uscitites.txt"; 
        //String file_name = "test.txt";
        //String file_name = args[0]; 
        //String lettersIhave = "loveone";
        //String findMe = "**e*";
        
        //String file_name = args[2];
        String lettersIhave = args[0];
        String findMe = args[1];
             
        // If d1, d2 or d3 search for the definition of the string at one of 3 sources
        if ( findMe.matches ("d[1-3]") ){
            getDefinition ( lettersIhave , findMe );
        } else {
            Files.lines(Paths.get ( file_name ) ).forEach (  n -> checkString ( n.toLowerCase() , findMe.toLowerCase(), lettersIhave, findPositionOfCharacters ( findMe ) ) );
        }
        
                        
        // Read text file line by line and pass string for comparison 
        //Files.lines(Paths.get ( file_name ) ).forEach (  n -> checkString ( n.toLowerCase() , findMe.toLowerCase(), lettersIhave, findPositionOfCharacters ( findMe ) ) );
        //Files.lines(Paths.get ( file_name ) ).forEach (System.out:: println );
        //Files.lines(Paths.get ( file_name ) ).map(n -> " XX :: " + n ).forEach (System.out:: println );
        //Files.lines(Paths.get ( file_name ) ).forEach ( n -> System.out.println ( "XX : " + n ) );
        
        //Files.lines(Paths.get ( file_name ) ).map(n -> n.toLowerCase() ).forEach (System.out:: println );
        
    }
        

    
}

