//Steven Wang

public class BinaryTree {
	private BinaryTree left;
	private int value;
	private BinaryTree right;

	public BinaryTree(BinaryTree left, int value, BinaryTree right) {
		this.left = left;
		this.value = value;
		this.right = right;
	}

	public BinaryTree getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	public int getValue() {
		return value;
	}


	public BinaryTree getRight() {
		return right;
	}

	public void setRight(BinaryTree right) {
		this.right = right;
	}

	public static BinaryTree binarySearch(BinaryTree root, int target) {
		if (root == null) {
			return null;}
		else {
			if (target < root.getValue()){
				return binarySearch(root.getLeft(), target);
			} else if (target > root.getValue()){
				return binarySearch(root.getRight(), target);
			} else {
				return root;  // target == root.getValue()
			}
		}
	}

	public static BinaryTree insert(BinaryTree root, int value) {
		if (root == null) {
			return new BinaryTree(null, value, null);
		} else {
			if (root.getValue() <= value){
				root.setRight(insert(root.getRight(), value));
			} else if (root.getValue() > value) {
				root.setLeft(insert(root.getLeft(), value));
			}
		}
		return root;
	}

	public static void printInOrder(BinaryTree tree) {
		if (tree.left == null) {
			System.out.print(tree.value);
			if (tree.right != null) {
				System.out.print(", ");
				printInOrder(tree.right);
			}
		} else {
			printInOrder(tree.left);
			System.out.print(", ");
			System.out.print(tree.value);
			if (tree.right != null) {
				System.out.print(", ");
				printInOrder(tree.right);
			} 
		}   	
	}

	public static void printPreOrder(BinaryTree tree) {
		if (tree == null) {
			return;
		} else {
			System.out.print(tree.value);
			if (tree.left != null) {
				System.out.print(", ");
				printPreOrder(tree.left);
			}
			if (tree.right != null) {
				System.out.print(", ");
				printPreOrder(tree.right);
			}
		}
	}

	public static void printPostOrder(BinaryTree tree) {
		if (tree == null) {
			return;
		} else {
			printPostOrder(tree.left);
			printPostOrder(tree.right);
			System.out.print(tree.getValue() + " ");
		}
	}

	public static int findMinNode(BinaryTree tree) {
		if (tree == null) {
			return 10000;
		} else {
			return Math.min(tree.getValue(), (Math.min(findMinNode(tree.left), findMinNode(tree.right) ) ) );
		}
	}

	public static void removeNode(BinaryTree tree, int value) {
		if (tree == null || tree.left == null || tree.right == null) {
			return;
		} else {
			if (tree.left.getValue() == value) {
				if (tree.left.left == null && tree.left.right == null) {
					tree.setLeft(null);
				} else if (tree.left.left == null) {
					tree.left.value = tree.left.right.getValue();
					tree.left.setRight(null);
				} else if (tree.left.right == null) {
					tree.left.value = tree.left.left.getValue();
					tree.left.setLeft(null);
				} else {
					tree.left.value = findMinNode(tree.left.right);
					removeNode(tree.left.right, tree.left.getValue());
				} 
			} else if (tree.right.getValue() == value) {
				if (tree.right.left == null && tree.right.right == null) {
					tree.setLeft(null);
				} else if (tree.right.left == null) {
					tree.right.value = tree.right.right.getValue();
					tree.right.setRight(null);
				} else if (tree.right.right == null) {
					tree.right.value = tree.right.left.getValue();
					tree.right.setLeft(null);
				} else {
					tree.right.value = findMinNode(tree.right.right);
					removeNode(tree.right, tree.right.getValue());
				} 
			} else if (tree.getValue() == value) {
				tree.value = findMinNode(tree.right);
				removeNode(tree, tree.getValue());
			} else {
				removeNode(tree.left, value);
				removeNode(tree.right, value);
			}
		}
	}

	public static void main(String[] args) {
		BinaryTree root = null;
		root = insert(root, 25);
		insert(root, 15);
		insert(root, 10);
		insert(root, 20);
		insert(root, 30);
		insert(root, 35);

		System.out.println("In-order:");
		printInOrder(root);
		System.out.println("\nPre-order:");
		printPreOrder(root);
		System.out.println("\nPost-order: ");
		printPostOrder(root);
		removeNode(root, 30);
		System.out.println("\nBinary Search Tree after removing node with value 30:");
		printInOrder(root);
		removeNode(root, 10);
		System.out.println("\nBinary Search Tree after removing node with value 10:");
		printInOrder(root);

	}
}