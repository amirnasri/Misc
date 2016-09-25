'''
Next Greater Element
http://www.geeksforgeeks.org/next-greater-element/

Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.

Examples:
a) For any array, rightmost element always has next greater element as -1.
b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.

Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.

  Element        NGE
   13      -->    -1
   7       -->     12
   6       -->     12
   12     -->     -1
'''



def next_greater_element(a):
	if not a:
		return
	s = []
	for value in a:
		while s and (s[-1] < value):
			'''
			if not s:
				break
			if s[-1] > a[i]:
				break
			'''
			print("%d -->  %d" % (s.pop(), value))
		s.append(value)

	for value in s:
		print("%d -->  %d" % (value, -1))
		




next_greater_element([4, 4, 5, 2, 25])
