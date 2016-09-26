
st = []
total = []
def print_interleavings(s1, s2):
	if not s1 and not s2:
		print("".join(st))
		total.append("".join(st))
		return
	if s1:
		st.append(s1[0])
		print_interleavings(s1[1:], s2)
		st.pop()
	if s2:
		st.append(s2[0])
		print_interleavings(s1, s2[1:])
		st.pop()
	return


print_interleavings("ABC", "FG")

print(total)
