package com.datastructure.tree;

/**
 * Given a binary tree, find its maximum depth
 *
 * @param <T>
 */
public class BinarySearchTree <T extends Comparable<T>> {
	
	// Tracks the number of nodes in this BST
	  private int nodeCount = 0;

	  // This BST is a rooted tree so we maintain a handle on the root node
	  private Node root = null;

	/* Class containing left and right child of current 
	   node and key value*/
	class Node 
	{ 
	    T data; 
	    Node left, right; 
	    public Node(Node left, Node right, T elem) 
	    { 
	        this.data = elem; 
	        this.left =left;
	        this.right =right; 
	    } 
	} 
	
	 public BinarySearchTree() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 /**
	 * method returns false if size is 0
	 */
	public boolean isEmpty() {
		 return this.size() == 0 ;
	 }
	 
	 /**
	 * method returns the size of the tree
	 */
	public int size() {
		 return this.nodeCount;
	 }
	 
	 /**
	 * This method adds the element to the tree
	 * @param elem
	 * @return boolean
	 */
	public boolean add(T elem) {
		 if(contains(elem)) {
			 return false;
		 }else {
			 root = add(root, elem);
			 nodeCount++;
			 return true;
		 }
	 }
	 
	 /**
	 * This method is called internally to add the element to the tree
	 * @param node
	 * @param elem
	 * @return
	 */
	private Node add(Node node,T elem) {
		//if current node is null
		 if(node == null) {
			 //adding the data to current node
			 node = new Node(null, null, elem);
		 }else {
			 //if current element is less than data
			 if(elem.compareTo(node.data) < 0)
				 //recursive call with the node left tree
				 node.left = add(node.left,elem);	
			 else 
				 //recursive call with the node right tree
				 node.right = add(node.right,elem);
		 }
		 return node;
	 }
	 
	
	 /**
	 * Method checks if the element is in the tree or not
	 * @param elem
	 * @return
	 */
	public boolean contains(T elem) {
		// returns true is the element exists in the tree
	    return contains(root, elem);
	  }

	  
	 /**
	 * Method is called internally to check if element present in the tree
	 * @param node
	 * @param elem
	 * @return
	 */
	private boolean contains(Node node, T elem) {

	    // Base case: reached bottom, value not found
	    if (node == null) return false;

	    int cmp = elem.compareTo(node.data);

	    // Dig into the left subtree because the value we're
	    // looking for is smaller than the current value
	    if (cmp < 0) return contains(node.left, elem);

	    // Dig into the right subtree because the value we're
	    // looking for is greater than the current value
	    else if (cmp > 0) return contains(node.right, elem);

	    // We found the value we were looking for
	    else return true;
	  }

	/**
	 * Method to get the maximum depth of the tree
	 * @return
	 */
	public int maxDepth() {
		return maxDepth(root);
	}
	  
	/**
	 * Method called internally to get the maximum depth of the tree
	 * @param node
	 * @return
	 */
	private int maxDepth(Node node) {
		//if current node is null then return 0
		 if(node == null) {
			 return 0;
		 }else {
			//recursive call on the left node of current  node
			 int leftDepth = maxDepth(node.left);
			//recursive call on the right node of current  node
			 int rightDepth = maxDepth(node.right);
			 //if left tree depth is greater than right then return leftDepth+1
			 if(leftDepth > rightDepth){
	               return (leftDepth+1);
	           }else{
	        	   //if right tree depth is greater than left then return rightDepth+1
	               return (rightDepth+1);
	           }
		 }
    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(5);
		bst.add(2);
		bst.add(10);
		bst.add(4);
		bst.add(11);
		System.out.println("The depth of tree is "+bst.maxDepth());
	}

	
}

