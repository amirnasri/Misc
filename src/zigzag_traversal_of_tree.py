'''
Level order traversal in spiral form
http://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/

Write a function to print spiral order traversal of a tree. For below tree, function should print 1, 2, 3, 4, 5, 6, 7.
'''

class Node:
	def __init__(self, data):
		self.data = data
		self.left = None
		self.right = None

from collections import deque
def zigzag_order_traversal(root):
	if not root:
		return
	
	q = deque()
	root.level = 1
	q.append(root)
	curr_level = 1
	direction = True
	l = []
	while q:
		n = q.popleft()
		#print(n.data, n.level)
		if n.level == curr_level:
			l.append(n.data)
		else:
			if direction:
				print(curr_level, l)
			else:
				l.reverse()
				print(curr_level, l)
			direction = not direction
			l = [n.data]
			curr_level += 1

		if n.left:
			n.left.level = n.level + 1
			q.append(n.left)
	
		if n.right:
			n.right.level = n.level + 1
			q.append(n.right)
	
	if direction:
		print(curr_level, l)
	else:
		l.reverse()
		print(curr_level, l)
	

# Let us construct the BST shown in the figure
root = Node(20)
root.left = Node(8)
root.right = Node(22)
root.right.right = Node(5)
root.left.left = Node(4)
root.left.right = Node(12)
root.left.right.left = Node(10)
root.left.right.right = Node(14)
root.left.right.right.right = Node(3)


zigzag_order_traversal(root)
