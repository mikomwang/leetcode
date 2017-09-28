import math
def factors(value):
	results = []
	counter = 2 
	temp = []
	while counter < math.sqrt(value):
		if value % counter == 0:
			temp = [counter, value/counter]
			results.append(temp)
			next_part = factors(value/counter)
			if next_part != []:
				for next_list in next_part:
					temp = [counter]
					temp.extend(next_list)
					results.append(temp)
		counter += 1

	return results