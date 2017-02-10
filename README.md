# RandomJavaCode
RandomJavaCode

This is a collection of Java code to solve various tasks.


////////////////// Commandline Words and Topics Research Tool  //////////////////

Description:

This is a comandline utility to assist with rapid research. If you are a word smith, enjoy researching topics, definitions, etymology, synonyms, antonyms, acronyms, medical terms, legal terms, text and chat acronyms, and newer words in Urban Dictionary. This application searches 15 different source.

This is a comandline utility to assist with rapid research. If you are a word smith, enjoy researching topics, definitions, etymology, synonyms, antonyms, acronyms, medical terms, legal terms, text and chat acronyms, and newer words in Urban Dictionary. This application searches 15 different source.

Example: 
	Execute
		Searching Example
		java -cp .:./jsoup-1.10.2.jar DownloadDefinitions “d1” “love”
		Help
		java -cp .:./jsoup-1.10.2.jar DownloadDefinitions “help”	

	Compile
		javac -cp jsoup-1.10.2.jar DownloadDefinitions.java

	Output 
		SEARCHING : https://en.wikipedia.org/wiki/love

		Love is a variety of different feelings, states, and attitudes that ranges from interpersonal affection (“I love my mother”) to pleasure (“I loved that meal”). It can refer to an emotion of a strong attraction and personal attachment.[1] It can also be a virtue representing human kindness, compassion, and affection—”the unselfish loyal and benevolent concern for the good of another”.[2] It may also describe compassionate and affectionate actions towards other humans, one’s self or animals.[3]


////////////////// Anagram  //////////////////

Description:

anagram ( noun )
1. a word, phrase, or sentence formed from another by rearranging its letters: “Angel” is an anagram of “glean.”.

http://www.dictionary.com/browse/anagram

Example: 
	Execute
		java anagrams englishWords.txt love

	Compile
		javac anagrams.class

	Output 
		levo
		love
		Love
		velo
		vole


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


