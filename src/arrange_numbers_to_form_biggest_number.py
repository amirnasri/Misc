'''
Arrange given numbers to form the biggest number
http://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/

Given an array of numbers, arrange them in a way that yields the largest value. For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value. And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
'''

def comp(x, y):
	return int(str(x) + str(y)) - int(str(y) + str(x))

def arrange_numbers(a):
	if not a:
		return None
	return "".join(map(str, sorted(a, cmp = comp, reverse = True)))


print(arrange_numbers([1, 34, 3, 98, 9, 76, 45, 4]))
