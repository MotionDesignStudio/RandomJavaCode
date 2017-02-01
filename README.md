# RandomJavaCode
RandomJavaCode

This is a collection of Java code to solve various tasks.


////////////////// Abecedarian  //////////////////

Description:

abecedarian ( noun )
1. a person who is learning the letters of the alphabet.
2. a beginner in any field of learning.
( adjective )
3. of or relating to the alphabet.
4. arranged in alphabetical order.
5. rudimentary; elementary; primary.

http://www.dictionary.com/browse/abecedarian

Example: 
	Execute
		java Abecedarian englishWords.txt

	Compile
		javac Abecedarian.class

	Output 
		...
		borty 
		cestuy
		forty
		ghosty
		horsy
		NPR

////////////////// Doubloon  //////////////////

Description:

"A word is said to be a “doubloon” if every letter that appears in the word appears
exactly twice." ~ Allen B. Downey and Chris Mayfield, Think Java - How to Think Like a Computer Scientist, O'Reilly Media, June 2, 2016 

Example: 
	Execute
		java Doubloon englishWords.txt

	Compile
		javac Doubloon.class

	Output 
		...
		Anna
		appall
		appearer
		appeases
		arar
		arraigning


////////////////// Palindromes  //////////////////

Description:

palindrome - "a word, line, verse, number, sentence, etc., reading the same backward as forward, as Madam, I'm Adam or Poor Dan is in a droop." ~ http://www.dictionary.com/browse/palindrome

Example: 
	Execute
		java Palindromes englishWords.txt

	Compile
		javac Palindromes.class

	Output 
		...
		ADA
		adda
		Adda
		addda
		Adinida
		AEA
		Aeaea
		...


////////////////// Alphabet Histogram  //////////////////

Example: 
	Execute
		java ahistogram LEX

	Compile
		javac ahistogram.class

	Output 
		e : 1 | l : 1 | x : 1 |

////////////////// Beers On Wall //////////////////

Displays how many beers on the wall counting down from 99?

Example: 
	Execute
		java BeersOnWall

	Compile
		javac BeersOnWall.class

	Output 
		1 bottles of beer on the wall,
		1 bottles of beer,
		ya’ take one down, ya’ pass it around,
		0 bottles of beer on the wall. 
		
		No bottles of beer on the wall,
		no bottles of beer,
		ya’ can’t take one down, ya’ can’t pass it around,
		cause there are no more bottles of beer on the wall!

////////////////// Guessing Game //////////////////

Guessing version 1.0
The use must try to guess a number between 0 - 100.

Example: 
	Execute
		java guessingGame

	Compile
		javac guessingGame.class

	Output 
		I'm thinking of a number between 0 and 100.  Can you guess what it is?


////////////////// Sieve of Eratosthenes //////////////////

In 250s BCE the sieve of Eratosthenes was discovered to find prime numbers.  I implemented two versions of this sieve algorithm.  The first uses two procedures/method/subroutines to find all the prime numbers in a range starting from 2 – given number.  In this example I use 2 – 2017.

The two method approach reflects how a humyn thinks and would approach solving the problem.  The single method approach is a more streamlined approach. 

Example: 
	Execute
		java SieveofEratosthenes2

	Compile
		javac SieveofEratosthenes2.java

	Output of 2 – 10,000
		http://mo-de.net/d/primeNumbers.txt

More info here:  https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes


//////////////////


