class Node:
	def __init__(self, data):
		self.data = data
		self.left = None
		self.right = None


def lca1(root, n1, n2):
	if not root:
		return
	if n1 < root.data and n2 < root.data:
		return lca(root.left, n1, n2)
	if n1 > root.data and n2 > root.data:
		return lca(root.right, n1, n2)
	return root

def lca(root, n1, n2):
	while root:
		if n1 < root.data and n2 < root.data:
			root = root.left
		elif n1 > root.data and n2 > root.data:
			root = root.right
		else:
			break
	return root


# Driver program to test above function
 
# Let us construct the BST shown in the figure
root = Node(20)
root.left = Node(8)
root.right = Node(22)
root.left.left = Node(4)
root.left.right = Node(12)
root.left.right.left = Node(10)
root.left.right.right = Node(14)

import sys

while True:
	line = sys.stdin.readline()
	if not line:
		break
	params = [int(i) for i in line.split()]
	t = lca(root, *params)
	print "LCA of %d and %d is %d" %(params[0], params[1], t.data)
	 
n1 = 12 ; n2 = 8
t = lca(root, n1, n2)
print "LCA of %d and %d is %d" %(n1, n2, t.data)
 
n1 = 14 ; n2 = 8
t = lca(root, n1, n2)
print "LCA of %d and %d is %d" %(n1, n2 , t.data)
 
n1 = 10 ; n2 = 22
t = lca(root, n1, n2)
print "LCA of %d and %d is %d" %(n1, n2, t.data)
 
