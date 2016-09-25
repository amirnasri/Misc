# Solution is not correct! The complexity is exponential it seems! Revisit and solve with gfg solution.
'''
Find subarray with given sum | Set 1 (Nonnegative Numbers)
http://www.geeksforgeeks.org/find-subarray-with-given-sum/

Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.

Examples:

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Ouptut: Sum found between indexes 1 and 4

Input: arr[] = {1, 4}, sum = 0
Output: No subarray found

'''
'''
def find_subarray_(a, l, h, sum_, s):
	if sum_ < s or l >= h:
		return None
	if s == sum_:
		return (l, h)
	r = find_subarray_(a, l + 1, h, sum_ - a[l], s)
	if r:
		return r
	 
	r = find_subarray_(a, l, h - 1, sum_ - a[h - 1], s)
	if r:
		return r
	return None

def find_subarray(a, s):
	return find_subarray_(a, 0, len(a), sum(a), s)
'''
def find_subarray(a, s):
	'''
	i = 0
	j = 1
	sum_ = a[0]
	while True:
		if s == sum_:
			return (i, j)
		if (sum_ > s):
			i += 1
			if i == j:
				continue
			sum_ -= a[i - 1]
		else:
			if (j == len(a)):
				break
			j += 1
			sum_ += a[j - 1]
			
	return None
	'''
	i = 0
	j = 1
	sum_ = a[0]
	while True:
		# Invariant it true here:
		# 0 =< i < j, j <= len(a), sum_ is sum(a[i:j])  
		if sum_ == s:
			return (i, j)
		# if sum_ is not equal to s, we have to change the invariant 
		# but make sure to go back to invariant at the begining of the loop
		if sum_ > s and i < j - 1:
			sum_ -= a[i]
			i += 1
		else:		 
			j += 1
			if j > len(a):
				break
			sum_ += a[j - 1]

	return None

import sys
while True:
	s = sys.stdin.readline().strip()
	if not s:
		break
	print(find_subarray([1, 4, 20, 3, 0, 5], int(s)))
