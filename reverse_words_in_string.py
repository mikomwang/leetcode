def reverse_words(string):
	reversed_string = string[::-1]
	result = ""
	start_index = 0
	for i in range(len(string)):
		if reversed_string[i] == " ":
			if start_index == 0:
				result += reversed_string[i-1::-1]
			else:
				result += reversed_string[i-1:start_index:-1]
			result += " "
			start_index = i 
	result += reversed_string[i:start_index:-1]
	return result

print(reverse_words("the sky is blue"))