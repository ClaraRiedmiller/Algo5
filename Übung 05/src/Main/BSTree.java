package Main;

public class BSTree {
	private TreeNode root;

	/**
	 * Constructor for an empty binary search tree.
	 */
	public BSTree(){}

	/**
	 * Constructor for a binary search tree that contains the given element.
	 * @param value the value to be inserted.
	 */
	public BSTree(int value)
	{
		this.root = new BSTreeNode(value); //rooooooot
	}

	/**
	 * Inserts a given value in the binary search tree.
	 * (3 Punkte)
	 * @param value the value to be inserted.
	 */
	public void insert(int value)
	{
		this.root = insertHelper(value, this.root);

	}


	private TreeNode insertHelper(int value, TreeNode root2) {

		if (root2 == null) {
			root2 = new BSTreeNode(value);
		} else if (value < root2.getValue()) {
			root2.setLeftChild(insertHelper(value, root2.getLeftChild()));
		} else if (value > root2.getValue()) {
			root2.setRightChild(insertHelper(value, root2.getRightChild()));
		} 

		return root2;

		// can you see me???


	}

	/**
	 * Determines whether or not a given value is within the binary search tree.
	 * (2 Punkte)
	 * @param value the value to search.
	 * @return the tree node containing the search value, if any, or null otherwise.
	 */
	public TreeNode search(int value)
	{
		return searchHelper(this.root, value);
	}
	
	

	private TreeNode searchHelper(TreeNode root2, int value) {

		if (root2 == null) {
			return null;
		} else if (value == root2.getValue()) {
			return root2;
		} else if (value < root2.getValue()) {
			return searchHelper(root2.getLeftChild(), value);
		} else if (value > root2.getValue()) {
			return searchHelper(root2.getRightChild(), value);
		}
		
		return null;
	}

	/**
	 * Returns the tree node containing the maximum element, or null if this tree is empty.
	 * (1 Punkt)
	 * @return the tree node containing the maximum
	 */
	public TreeNode maximum()
	{
		if(root == null) 
			return null;
		else
			return maxHelper(this.root);

	}

	public TreeNode maxHelper(TreeNode root) {	
		if(root.getRightChild() == null)
			return root;
		else 
			return maxHelper(root.getRightChild());
	}



	/**
	 * Returns the tree node containing the minimum element, or null if this tree is empty.
	 * (1 Punkt)
	 * @return the tree node containing the minimum
	 */
	public TreeNode minimum()
	{
		if(root == null) 
			return null;
		else
			return minHelper(this.root);

	}

	public TreeNode minHelper(TreeNode root) {	
		if(root.getLeftChild() == null)
			return root;
		else 
			return minHelper(root.getLeftChild());
	}




	/**
	 * Deletes and returns a values from the binary search tree.
	 * (5 Punkte)
	 * @return the value to be returned.
	 */
	public TreeNode delete(int value)
	{

		return delHelper(value, this.root);
	}

	private TreeNode delHelper(int value, TreeNode root2) {

		if (root2 == null) {
			return null;
		} else if (value < root2.getValue()) {
			root2.setLeftChild(delHelper(value, root2.getLeftChild()));
			return root2;
		} else if (value > root2.getValue()) {
			root2.setRightChild(delHelper(value, root2.getRightChild()));
			return root2;
		} else if (value == root2.getValue() && root2.getRightChild() == null) {
			return root2.getLeftChild();
		} else if (value == root2.getValue() && root2.getLeftChild() == null) {
			return root2.getRightChild();
		} else if (value == root2.getValue()) {
			root2.setValue(((BSTree) root2.getRightChild()).minimum().getValue());
			root2.setRightChild(delHelper(root2.getValue(), root2.getRightChild()));
			return root2;
		}
		
		return root2;
	}





	/**
	 * Prints the elements of this binary search tree in an inorder traversal.
	 */
	public void inorderTreeTraversal()
	{
		this.inorderTreeTraversal(this.root);
		System.out.println();
	}

	private void inorderTreeTraversal(TreeNode x)
	{
		if (x != null)
		{
			this.inorderTreeTraversal(x.getLeftChild());
			System.out.print(x.getValue()+" ");
			this.inorderTreeTraversal(x.getRightChild());
		}
	}
}