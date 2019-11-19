package com.datastructure.tree;

//Given a binary tree, find its maximum depth
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
	 
	 public boolean isEmpty() {
		 return this.size() == 0 ;
	 }
	 
	 public int size() {
		 return this.nodeCount;
	 }
	 
	 public boolean add(T elem) {
		 if(contains(elem)) {
			 return false;
		 }else {
			 root = add(root, elem);
			 nodeCount++;
			 return true;
		 }
	 }
	 
	 public Node add(Node node,T elem) {
		 if(node == null) {
			 node = new Node(null, null, elem);
		 }else {
			 if(elem.compareTo(node.data) < 0)
				 node.left = add(node.left,elem);	
			 else 
				 node.right = add(node.right,elem);
		 }
		 return node;
	 }
	 
	// returns true is the element exists in the tree
	  public boolean contains(T elem) {
	    return contains(root, elem);
	  }

	  // private recursive method to find an element in the tree
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

	public int maxDepth() {
		return maxDepth(root);
	}
	  
	public int maxDepth(Node node) {
		 if(node == null) {
			 return 0;
		 }else {
			 int leftDepth = maxDepth(node.left);
			 int rightDepth = maxDepth(node.right);
			 if(leftDepth > rightDepth){
	               return (leftDepth+1);
	           }else{
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

