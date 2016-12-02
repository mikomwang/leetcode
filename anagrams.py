# Opentable Coding Interview Question. Made with Python3.
# Author: Michael Wang
import sys

def anagrams(dictionary):
	""" Main function which handles and processes user input.
	INPUT: path to a dictionary.
	OUTPUT: No return value.
	"""
	wordDict = processDictionary(dictionary) # Returns a dictionary mapping each lower case and sorted version of an anagram to all of its corresponding anagrams.
	while True:
		word = input("> ")
		if word == "": # Exit if user inputs no word.
			exit()
		word = word.lower()
		sortedWord = ''.join(sorted(word))
		validAnagrams = wordDict.get(sortedWord, None) # Look for the lower case and sorted version of the user input in the dictionary.
		if validAnagrams == None:
			print("-")
		else:
			prettyPrint(validAnagrams) # Print all corresponding anagrams if they are found.

def prettyPrint(anagramList):
	""" Prints all anagrams in sorted order.
	INPUT: a list of anagrams.
	OUTPUT: No return value, but prints all anagras that correspond with user input.
	"""
	sorted_list = sorted(anagramList, key=lambda s: s.lower()) # Case-insensitive list sorting, without lowercasing the result.
	printString = ""
	for anagram in sorted_list:
		printString += anagram + " "
	print(printString)

def processDictionary(dictionary):
	""" Processes dictionary and maps each sorted version of a dictionary entry to a list of all the same anagrams in the dictionary.
	INPUT: path to a dictionary. 
	OUTPUT: A dictionary mapping from sorted anagram -> All anagrams that correspond to the sorted anagram.
	"""
	allWords = []
	with open(dictionary, "r") as currentDictionary:
		for word in currentDictionary:
			strippedWord = word.rstrip('\n') # Take off the newline character at the end of each word.
			allWords.append(strippedWord)

	anagramMappings = {}
	for word in allWords:
		lowerword = word.lower()
		sortedWord = ''.join(sorted(lowerword))
		if sortedWord not in anagramMappings:
			anagramMappings[sortedWord] = []
		anagramMappings[sortedWord].append(word)
	return anagramMappings

if __name__ == "__main__":
	dictionary = sys.argv[1] # Allow user to input path to a dictionary.
	anagrams(dictionary)








"""
Initial implementation of how I approached this problem. Kept around for the curious.

def findAnagrams(word, validWords):
	=== 
	HELPER FUNCTION USED IN INITIAL NAIVE IMPLEMENTATION
	===
	allAnagrams = []
	for item in validWords:
		if isAnagram(word, item):
			allAnagrams.append(item)
	return allAnagrams
"""

"""
def isAnagram(word, item):
	===
	INITIAL NAIVE IMPLEMENTATION

	Returns True or False depending on whether or not the two string inputs are anagrams. 
	Uses a dictionary implementation to map each character to a frequency, and checks that 
	the both strings have the same frequency of the same characters.
	Inputs: Word - string
			Item - string
	Output: Boolean
	===
	charDict = {}
	if len(word) != len(item):
		return False
	for letter in word:
		if letter != "'":
			lowerLetter = letter.lower()
		else:
			lowerLetter = "'"
		if lowerLetter not in charDict:
			charDict[lowerLetter] = 1
		else:
			charDict[lowerLetter] += 1

	for letter in item:
		if letter != "'":
			lowerLetter = letter.lower()
		else:
			lowerLetter = "'"
		if lowerLetter in charDict:
			charDict[lowerLetter] -= 1
			if charDict[lowerLetter] == 0:
				charDict.pop(lowerLetter)
		else:
			return False

	if charDict == {}:
		return True
	else:
		return False
"""
