
def is_poli(a, l, h):
	h -= 1
	while l < h:
		if a[l] != a[h]:
			return False
		l += 1
		h -= 1
	return True

def find_partitions(a):
	len_ = len(a)
	t = []
	for _ in range(len_+ 1):
		t.append(list())
	t[0] = [[]]
	j = 1
	while j <= len_:
		i = 0
		#print(t)
		while i < j:
			if is_poli(a, i, j):
				for p in t[i]:
					p1 = list(p)
					p1.append(a[i:j])
					t[j].append(p1)
				
			i += 1
		j += 1

	return t[len_]

a = "nitin"
print(find_partitions(a))
	
