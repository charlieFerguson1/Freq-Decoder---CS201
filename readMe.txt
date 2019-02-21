I used an alternate method to solve this cipher. By creating a class called letter I was able to store three values, an encoded char, its corresponding decoded char, determined by an int
called freq which is just the number of times a certain encoded char appears in an encoded message. 

Because I used an array of these Letter objects, I implemented the comparable interface to be able to sort that array. Because other people were able to use the built in java sort method I
used a quicksort method from http://www.learntosolveit.com/java/GenericQuicksortComparable.html which enabled me to sort the array of Letter objects.

To implement the comparable interface I created a compareTo method that used the int freq to compare letter objects.

My choice to use an object made it easier for me to think about the decoding process. I also thought it was easier to follow because I used fewer arrays and had all the important values in a 
single location.

In the extra credit I made an array that is twice the size of the alphabet, each time a letter is decoded the letter in the key is moved to the end of the bloc of letters which is held by a int var "end"
this limits the amount of times that a shift is done thus limiting the run time.
