'''
input: This is a game
output: game a is This
'''


def partial_reverse(l, start, end):
	if end <= start + 1:
		return
	end -= 1
	while start < end:
		temp = l[start]
		l[start] = l[end]
		l[end] = temp
		start += 1
		end -= 1


def reverse(s):
	l = list(s)
	last_space = -1
	i = 0
	while i < len(s):
		if l[i] == ' ':
			partial_reverse(l, last_space + 1, i)
			last_space = i
		i += 1
	
	partial_reverse(l, last_space + 1, len(s))
	partial_reverse(l, 0, len(s))
	print("".join(l))


reverse('| 	This  is a game $')
	
