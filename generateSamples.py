import random

""" Use random numbers to generate input files"""
def generate(lines, filename):
	f = open(filename, 'w') # Clear all existing text in input file
	f.write("")
	f.close()

	inputFile = open(filename, 'a')
	inputFile.write(str(lines))
	inputFile.write("\n")
	for linenum in range(lines):
		lineresult = ""
		for index in range(lines):
			if linenum == index:
				horseVal = random.randint(0, 99)
				lineresult += str(horseVal) + " "
			else:
				edgeVal = random.randint(0, 1)
				lineresult += str(edgeVal) + " "
		inputFile.write(lineresult)
		inputFile.write("\n")

if __name__ == "__main__":
	generate(100, "1.in")
	generate(250, "2.in")
	generate(500, "3.in")