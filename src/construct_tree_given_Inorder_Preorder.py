'''
Construct Tree from given Inorder and Preorder traversals
http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/

Note: This is not the most efficient solution. The gfg solution does not break the preorder array and uses
a global index to simply go through the array one-by-one. Not sure how the algorithm works.
'''
import sys

class Node:
	def __init__(self, data):
		self.data = data
		self.left = None
		self.right = None


def inorder_traverse(root):
	if not root:
		return
	inorder_traverse(root.left)
	sys.stdout.write("%s  " % root.data)
	sys.stdout.flush()
	inorder_traverse(root.right)

def preorder_traverse(root):
	if not root:
		return
	sys.stdout.write("%s  " % root.data)
	sys.stdout.flush()
	preorder_traverse(root.left)
	preorder_traverse(root.right)


def build_tree(inorder, preorder):
	if not preorder:
		return None
	root = preorder[0]
	left_tree_elements = set()
	i = 0
	pivot = 0
	while i < len(inorder):
		v = inorder[i]
		if v == root:
			pivot = i
			break
		left_tree_elements.add(v)
		i += 1

	left_preorder = []
	right_preorder = []
	i = 1
	while i < len(preorder):
		v = preorder[i]
		if v in left_tree_elements:
			left_preorder.append(v)
		else:
			right_preorder.append(v)
		i += 1

	root = Node(root)
	root.left = build_tree(inorder[:pivot], left_preorder)
	root.right = build_tree(inorder[pivot + 1:], right_preorder)

	return root



inOrder = ['D', 'B', 'E', 'A', 'F', 'C']
preOrder = ['A', 'B', 'D', 'E', 'C', 'F']

root = build_tree(inOrder, preOrder)
inorder_traverse(root)
print
preorder_traverse(root)
print
