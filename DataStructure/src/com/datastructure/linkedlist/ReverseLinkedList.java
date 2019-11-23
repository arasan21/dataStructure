package com.datastructure.linkedlist;

import java.util.Iterator;

/**
 * Singly-linked list 
 *
 * @param <T>
 */
public class ReverseLinkedList <T> implements Iterable<T>{
	
	  private int size = 0;
	  private Node<T> head = null;
	
	 // Definition for singly-linked list.
	  private static class Node<T> {
	      private T data;
	      private Node next;
	      public Node(Node next,T data) {
	    	  this.next = next;
	    	  this.data = data; 
	      }
	      
	      @Override
		   public String toString() {
			   return data.toString();
		   }
	  }
	  

	 /**
	 * Method to add elements to the linked list
	 * @param data
	 */
	public void add(T data) {
		  add(head, data);
	  }
	  
	 /**
	 * This Method is called internally  to add elements to the linked list
	 * @param node
	 * @param data
	 */
	private void add(Node node, T data) {
		  // if the head is null, then adding the data to head
		  if (head == null) {
			  head =  new Node(null, data);
		  }else {
			  Node lastNode = head;
			  //looping through the elements to find the last node
			  while(lastNode.next != null) {
				  lastNode =  lastNode.next;
			  }
			  //once the last node is found adding the data to the node
			  lastNode.next = new Node(null,data);
		  }
	  }
	
	/**
	 * This method is used to reverse the linked list
	 */
	public void reverseList() {
		Node prev = null;
		// assigning current node to head
		Node curr = head;
		//checking if current node is not null
        while (curr != null){
        	// fetching node next to current node 
            Node nextTmp = curr.next;
            //making current to point to previous node
            curr.next = prev;
            // assigning prev node to current node
            prev = curr;
            // moving the current node pointer to its next node
            curr = nextTmp;
        }
        //assigning the last to head
        head= prev;
	}
	
	/**
	 *To print the linked list
	 */
	@Override
	public String toString() {
		StringBuffer strBf = new StringBuffer();
		Node curr= this.head;
		while(curr != null) {
			strBf.append(curr.data+" , ");
			curr = curr.next;
		}
		return strBf.toString();
	}
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList intLinkedList = new ReverseLinkedList();
		intLinkedList.add(1);
		intLinkedList.add(2);
		intLinkedList.add(3);
		intLinkedList.add(8);
		System.out.println("Before reverse: "+intLinkedList.toString());
		intLinkedList.reverseList();
		System.out.println("After reverse: "+intLinkedList.toString());
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
