OpenTable Coding Interview 2016: Answers to Questions 

1. What is the running time of your program?

====== SUMMARY ======
Initial approach:
Offline: O(N) with N respect to the number of dictionary entries
Online: O(N) with N respect to the number of dictionary entries

Refactored solution:
Offline: O(MN log N) with M respect to the number of dictionary entries and N the length of the dictionary entry itself.
Online: O(1)

====== EXPLANATION =====
My initial approach for the offline step was to just iterate and retrieve all the words in the dictionary text file and place them into a list. This approach took O(N) time in terms of the number of entries in the dictionary. The online step, as a result, had to iterate through the list of all dictionary words, and compare each word to the user input word. This implementation was done using a dctionary and counting character frequencies, which can be seen in a commented out section in the anagrams.py script. This took O(N) time with respect to the number of entries in the dictionary.

After refactoring the code, I did some extra processing in the offline step to improve the runtime in the online step. Instead of simply putting each dictionary element into a list, I instead used a dictionary to map the sorted anagram to a list of all of the same anagrams in the dictionary. The online step was then a check to see if the sorted version of the word was a key in the dictionary, and then just pull the list of values that it mapped to. The sorting aspect of each string using the python sorting function in the offline step was O(MN log N), because we have to iterate through each dictionary entry and sort it. However, in the online step, the lookup was effectively just O(1), as looking up values in a dictionary is a constant time procedure.


2. How much memory does your program consume, in terms of asymptotic complexity?

Initial approach:
Offline: O(N) with N respect to the number of dictionary entries
Online: O(M) with M respect to the number of characters in a user input.

Refactored solution:
Offline: O(N) with N respect to the number of dictionary entries. 
Online: O(N) with N respect to the number of dictionary entries.


3. Extra Credit 

