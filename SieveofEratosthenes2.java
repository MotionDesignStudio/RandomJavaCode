/*
 * In 250s BCE the sieve of Eratosthenes was discovered to find prime numbers.  
 * I implemented two versions of this sieve algorithm.  The first uses two 
 * procedures/method/subroutines to find all the prime numbers in a range starting 
 * from 2 – given number.  In this example I use 2 – 2017.

The two method approach reflects how a humyn thinks and would approach solving the problem.
The single method approach is a more streamlined approach. 

Example: 
 Execute
  java SieveofEratosthenes2

 Compile
  javac SieveofEratosthenes2.java

More info here:  https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes

Output 2 - 10,000
http://mo-de.net/d/primeNumbers.txt

 */



import java.util.Arrays;

public class SieveofEratosthenes2 {
    
  // This method is no longer in use
    public static int searchArrayForThisNumPos (int [] a, int target){
        
        for (int i = 0; i< a.length; i++){
            if (a[i] == target)  {
                return i;
            }
        }
        return -1;
    }
    
    
    // This returns an array starting from 2 - size
   public static int[] rangeArray (int size){
        int[] a = new int[size-1];
        for (int i = 0; i< a.length; i++){
            a[i]=i+2;
        }
        return a;
    }
       
    
    public static void searchForNextFalse ( int startingPosition, boolean[] myBooleanArray, int[] myIntArray ){
        
        for (int c1 = startingPosition; c1 < myBooleanArray.length *.5; c1++ ){
           // Checking only up to 1/2 the interger value is needed since you can 
            // not add more than 1/2 it would exceed the largest number

              if ( myBooleanArray[c1] == false ){
                // Send the next number to be checked
                searchForPrime ( myIntArray[c1] , myBooleanArray, myIntArray );
                // I must break here when I encounter the first false or it will send multiple 
                // times to the search for prime numbers method.
                break;

            }
        }
        
    }
    

    public static void searchForPrime ( int starting, boolean[] myBooleanArray, int[] myIntArray ) {        
        int shouldITerminate = 1;       

        // counter is set to start from the next position of the number sent in parameter starting

        for (int counter = starting-2; counter < myBooleanArray.length; counter+=starting ){

            if ( ( starting != myIntArray [ counter ] ) && ( myBooleanArray [ counter ] == false )  ){
                myBooleanArray [ counter ] = true;
                shouldITerminate = 2;
            }
        }
        
        if ( shouldITerminate == 2 ){ 
            searchForNextFalse (starting - 1, myBooleanArray, myIntArray);
       }else if ( shouldITerminate == 1 ){ 
            formatOutput ( myBooleanArray, myIntArray);
        }
    }
      
 
   public static int formatOutput ( boolean[] myBooleanArray, int[] myIntArray  ){
// Display all the found prime numbers
       System.out.printf ("%n%n%s%n%n", "BEGIN Double Array Version");
       
      String lengthOfLargestNumber = Integer.toString(myIntArray [myIntArray.length-1] );
       
       int paddingForDisplay = lengthOfLargestNumber.length()+2;
       String formatOutPaddingString = "%"+Integer.toString( paddingForDisplay )+"d";
       
       int numColumns= 10;
       int counter = 0;
   
        for (int c2 = 0; c2 < myBooleanArray.length; c2++ ){
            if (myBooleanArray [c2] == false){
                System.out.printf (formatOutPaddingString, myIntArray[c2]);
                counter++;
            }
            
            
            if ( counter == numColumns ) {
                System.out.printf ("%n");
                counter =0;
            }
         }
        System.out.printf ("%n%n%s%n%n", "FINISH");
        return -1;
        
    }
    
   ///////////////////////
   ////////////////////// The single array approach
   
       public static void searchForNextZero ( int startingPosition, int[] myIntArray ){
        
        for (int c1 = startingPosition; c1 < myIntArray.length *.5; c1++ ){
           // Checking only up to 1/2 the interger value is needed since you can 
            // not add more than 1/2 it would exceed the largest number

              if ( myIntArray[c1] != 0 ){
                // Send the next number to be checked
                //searchForPrime ( myIntArray[c1] , myBooleanArray, myIntArray );
                // I must break here when I encounter the first false or it will send multiple 
                // times to the search for prime numbers method.
                //System.out.printf ("searchForNextZero :: Sending : %d at position : %d", myIntArray[c1], c1 );
                searchForPrime2 ( myIntArray[c1], myIntArray);
                break;

            }
        }
        
    }
       
  public static void searchForPrime2 ( int starting, int[] myIntArray ) {        
        int shouldITerminate = 1;       

        // counter is set to start from the next position of the number sent in parameter starting

        for (int counter = starting-2; counter < myIntArray.length; counter+=starting ){

            if ( ( myIntArray [ counter ] != 0 ) && ( myIntArray [ counter ] != starting ) ){
                myIntArray [ counter ] = 0;
                shouldITerminate = 2;
            }
        }
        
        if ( shouldITerminate == 2 ){ 
            searchForNextZero ( starting -1 , myIntArray);
       }else if ( shouldITerminate == 1 ){ 
            formatOutput2 ( myIntArray);
        }
    }
  
  
     public static int formatOutput2 ( int[] myIntArray  ){
// Display all the found prime numbers
      System.out.printf ("%n%n%s%n%n", "BEGIN Single Array Version");
       
      String lengthOfLargestNumber = Integer.toString(myIntArray [myIntArray.length-1] );
       
       int paddingForDisplay = lengthOfLargestNumber.length()+6;
       String formatOutPaddingString = "%"+Integer.toString( paddingForDisplay )+"d";
       
       int numColumns= 10;
       int counter = 0;
   
        for (int c2 = 0; c2 < myIntArray.length; c2++ ){
            if (myIntArray [c2] != 0){
                System.out.printf (formatOutPaddingString, myIntArray[c2]);
                counter++;
            }
            
            // Indent the next column
            if ( counter == numColumns ) {
                System.out.printf ("%n");
                counter =0;
            }
         }
        System.out.printf ("%n%n%s%n%n", "FINISH");
        return -1;
        
    }
   
   
    public static void main(String[] args){
      
      int[] checkMeForPrimeNumbers = rangeArray (10000);
      
      boolean [] booleanArray = new boolean [ checkMeForPrimeNumbers.length ];
      Arrays.fill(booleanArray, Boolean.FALSE);
      
      searchForNextFalse (0, booleanArray, checkMeForPrimeNumbers);
      
      searchForNextZero (0,checkMeForPrimeNumbers );            

}
    
}