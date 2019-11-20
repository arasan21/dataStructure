package com.datastructure.linkedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

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
	  

	  public void add(T data) {
		  add(head, data);
	  }
	  
	  private void add(Node node, T data) {
		  
		  if (head == null) {
			  head =  new Node(null, data);
		  }else {
			  Node lastNode = head;
			  while(lastNode.next != null) {
				  lastNode =  lastNode.next;
			  }
			  lastNode.next = new Node(null,data);
		  }
	  }
	
	public void reverseList() {
		Node prev = null;
		Node curr = head;
        while (curr != null){
            Node nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        head= prev;
	}
	
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
