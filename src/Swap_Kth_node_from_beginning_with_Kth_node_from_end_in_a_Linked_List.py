'''
Swap Kth node from beginning with Kth node from end in a Linked List
http://www.geeksforgeeks.org/swap-kth-node-from-beginning-with-kth-node-from-end-in-a-linked-list/

Given a singly linked list, swap kth node from beginning with kth node from end. Swapping of data is not allowed, only pointers should be changed. This requirement may be logical in many situations where the linked list data part is huge (For example student details line Name, RollNo, Address, ..etc). The pointers are always fixed (4 bytes for most of the compilers).
'''

class Node:
	def __init__(self, data = None):
		self.data = data
		self.next = None

def swap_kth(root, k):
	curr = root.next
	len_ = 0
	while curr:
		curr = curr.next
		len_ += 1
	if k > len_/2:
		k = len_ + 1 - k

	runner = root.next
	prev = root
	i = 0
	while i < k - 1:
		if not runner:
			return
		prev = runner
		runner = runner.next
		i += 1

	p1 = prev
	c1 = runner
	curr = root.next
	while runner.next:
		runner = runner.next
		prev = curr
		curr = curr.next

	p2 = prev
	c2 = curr
	
	if c1 == c2:
		return
	if c1 == p2:  # p1 c1-p2 c2
		# swap c1 and c2
		temp = c2.next
		c2.next = c1
		p1.next = c2
		c1.next = temp
		return
	#del c1
	p1.next = c1.next
	#del c2
	p2.next = c2.next
	#insert c2 after p1
	c2.next = p1.next
	p1.next = c2
	#insert c1 after p2
	c1.next = p2.next
	p2.next = c1

def print_list(root):
	root = root.next
	while root:
		print("%d  " % root.data, end="")
		root = root.next
	print()


root = Node()
l = 40
for i in range(l, 0, -1):
	n = Node(i)
	n.next = root.next
	root.next = n 
print_list(root)


for i in range(1, l + 1):
	swap_kth(root, i)
	print_list(root)

