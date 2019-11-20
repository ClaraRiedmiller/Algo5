package Main;


public class BSTreeNode implements TreeNode {

	// TODO: put class variables here
	int value;
	TreeNode left, right, parent;
	
	
	public BSTreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	@Override
	public int getValue() {
		
		return this.value;
	}

	@Override
	public TreeNode getLeftChild() {
		
		return this.left;
	}

	@Override
	public TreeNode getRightChild() {
		
		return this.right;
	}

	@Override
	public TreeNode getParent() {
		
		return this.parent;
	}

	@Override
	public void setValue(int value) {
		this.value = value;
		
	}

	@Override
	public void setLeftChild(TreeNode v) {
		this.left = v;
		
	}

	@Override
	public void setRightChild(TreeNode v) {
		this.right = v;
		
	}

	@Override
	public void setParentNode(TreeNode v) {
		
		this.parent = v;
	}
	
	
}