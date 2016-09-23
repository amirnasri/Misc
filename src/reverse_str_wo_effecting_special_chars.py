def is_alpha(c):
	c = c.lower()
	return c >= "a" and c <= "z"

def reverse(s):
	i = 0
	j = len(s) - 1
	l = list(s)
	while i < j:
		if not is_alpha(l[i]):
			i += 1
			continue
		if not is_alpha(l[j]):
			j -= 1
			continue
		t = l[i]
		l[i] = l[j]
		l[j] = t
		i += 1
		j -= 1
	return "".join(l)

print(reverse("Ab,c,de!$"))

