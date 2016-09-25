# Solution is not correct! The complexity is exponential it seems! Revisit and solve with gfg solution.

'''
Smallest subarray with sum greater than a given value
http://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/

Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.

Examples:
arr[] = {1, 4, 45, 6, 0, 19}
   x  =  51
Output: 3
Minimum length subarray is {4, 45, 6}

arr[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Minimum length subarray is {10}

arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
    x = 280
Output: 4
Minimum length subarray is {100, 1, 0, 200}

'''

def find_subarray_(a, l, h, sum_, s):
	if sum_ <= s or h <= l:
		return None
	res = [(l, h, h - l, sum_)]
	r_ = find_subarray_(a, l + 1, h, sum_ - a[l], s)
	if r_:
		res.append(r_)
	#r_ = find_subarray_(a, l, h - 1, sum_ - a[h - 1], s)
	#if r_:
	#	res.append(r_)
	return sorted(res, key = lambda x:x[2])[0]
	
	
		 

def find_subarray(a, s):
	return find_subarray_(a, 0, len(a), sum(a), s)


print(find_subarray([1, 4, 3], 4))
