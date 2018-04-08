# Playfair-Cipher
### Author: Qi Fu

## This a Java application that enables a cipher-text source to be specified (a file or URL) and an output destination file for decrypted plain-text, and decrypt cipher-text with a simulated annealing algorithm that uses a log-probability and n-gram statistics as a heuristic evaluation function.

## Code Files

### Runner
> This class read the input data from text file(it also can read text that users type from keyboard by calling void main method inside of Runner.java file).

### PlayFair 
> The main class is able to execute program, it can encrypt plain text and use key to decrypt text to console.

### HashGram
> Gets the total number of counts with the file.

### Shufflekey
> It makes the text changes to the key with the frequency given.

## This application can decrypt and encrypt text when users type text from keyboard but it has some problems with ShufflKey and HashGram files, the exception shows there is error with method "getLogProbability" and "CiperBreaker" in ShuffleKey, and also has errors in the Runnner and HashGram files.