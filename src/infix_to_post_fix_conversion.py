def build_hashtable(operators, priorities):
	d = {}
	for i in zip(operators, priorities):
		d[i[0]] = int(i[1])
	return d

def infix_to_postfix(a):
	d = build_hashtable(operators, priorities)
	s = []
	for i in a.split():
		if i in operators:
			p = d[i]
			while (s and p < d[s[-1]]):
				print(s.pop(), end = "")
			s.append(i)
		elif i == "(":
			s.append(i)
		elif i == ")":
			while s:
				r = s.pop()
				if r == "(":
					break
				print(s.pop, end = "")
		else:
			print(i, end = "")

	while s:
		print(s.pop(), end = "")
	print()
operators = "+-*/^"
priorities = "11223"

a = "a + b + c"
infix_to_postfix(a)
