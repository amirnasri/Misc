'''
Binary Tree to Binary Search Tree Conversion
http://www.geeksforgeeks.org/binary-tree-to-binary-search-tree-conversion/

Given a Binary Tree, convert it to a Binary Search Tree. The conversion must be done in such a way that keeps the original structure of Binary Tree.
'''
class Node:
	def __init__(self, data):
		self.data = data
		self.left = None
		self.right = None

def f1(n):
	inorder_traversal.res.append(n.data)

def f2(n):
	n.data = inorder_traversal.res.popleft()

def inorder_traversal(root):
	if not root:
		return
	inorder_traversal(root.left)
	inorder_traversal.f(root)
	inorder_traversal(root.right)

from collections import deque	
def convert_tree_to_BST(root):
	if not root:
		return
	inorder_traversal.f = lambda x: print("%d  " % x.data, end="")
	inorder_traversal(root)
	print()

	inorder_traversal.res = []
	inorder_traversal.f = f1
	inorder_traversal(root)
	
	inorder_traversal.res = deque(sorted(inorder_traversal.res))
	inorder_traversal.f = f2
	inorder_traversal(root)

	inorder_traversal.f = lambda x: print("%d  " % x.data, end="")
	inorder_traversal(root)
	print()
	

# Let us construct the BST shown in the figure
root = Node(1)
root.left = Node(4)
root.right = Node(10)
root.left.left = Node(8)
root.left.right = Node(22)
root.left.right.left = Node(11)
root.left.right.right = Node(2)

convert_tree_to_BST(root)
