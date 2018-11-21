package Lab7;

import java.util.NoSuchElementException;

public class DoublyLinkedList <T> implements ListInterface <T>{
	
	//creates Node class
	private class Node{
		private T data;
		private Node next;
		private Node prev;
		public Node(T data) {
			this.data = data;
			next = null;
			prev = null;
		}
		
		public Node() {
			data = null;
			next = null;
			prev = null;
		}
		
		public T getData() {
			return data;
		}
		
		public void setData(T data) {
			this.data=data;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node n) {
			next=n;
		}
		
		public Node getPrev() {
			return prev;
		}
		
		public void setPrev(Node n) {
			prev=n;
		}
	}
	
	private Node head;
	private Node tail;
	
	public Node getHead() {
		return head;
	}
	
	public T getHeadData() {
		return head.getData();
	}
	
	public T getTailData() {
		return tail.getData();  
	}
	
	public Node getTail() {
		return tail;
	}
	
	public DoublyLinkedList () {
	}
	
	public T getEntry(int i) {
		Node newN = getNodeAt(i);
		return newN.getData();
		
	}
	
	private Node getNodeAt(int givenPosition) {
		   assert (givenPosition >= 0 && givenPosition < getLength());
		 
		   Node currentNode = head;
		   if(givenPosition == 0) {
			   return head;
		   }
		   for (int idx = 0; idx < givenPosition; idx ++) {
		       currentNode = currentNode.getNext();
		   }
		   return currentNode;
		 }

	
	@Override
	public void add(T newEntry) {
	    Node newNode = new Node(newEntry);
        
	    if (head == null)
	        head = newNode;
	    else {
	        boolean end = false;
	        Node nextNode = head.getNext();
	        Node curr = head;
	            
	        while (!end) {
	            end = (nextNode == null);
	            if (!end){
	            	curr = nextNode;
	            	assert (nextNode != null);
	            	nextNode = nextNode.getNext();
	            }
	        }
	     assert (curr != null);
	     curr.setNext(newNode);
	     newNode.setPrev(curr);
	     tail = newNode;
	   }   

		
	}

	@Override
	public void add(int newPosition, T newEntry) {
		// TODO Auto-generated method stub
		if (newPosition < 0 || newPosition > getLength())
		      throw new IndexOutOfBoundsException();
		        
		   Node newNode = new Node(newEntry);
		        
		   if (newPosition == 0) {// the only value for the empty list
			  head.setPrev(newNode);
		      newNode.setNext(head);  
		      head = newNode;
		   }
		   if (newPosition == getLength()) {// the only value for the empty list
				  tail.setNext(newNode);
			      newNode.setPrev(tail);  
			      tail = newNode;
			   }
		   else { // traverse the chain
		      int idx = 0; boolean found = false;
		      Node after = head, before = null;
		      do {
		        if (idx == newPosition) {
		          found = true;
		          assert (before != null);
		          before.setNext(newNode);
		          newNode.setPrev(before);
		          newNode.setNext(after);
		         }

		        else {
		          before = after;
		          after = after.getNext();
		          idx ++;
		         }
		       } while (!found);
		    }

	}
	
	public int getLength(){
	    int numEntries = 0;
	    Node curr;
	    for (curr = head; curr != null;
	                               curr = curr.getNext())
	       numEntries ++;  
	    return numEntries;
	}

	
	public T remove (int givenPosition){
	    if (isEmpty())
	       throw new NullPointerException();
	    if (givenPosition < 0 || givenPosition >= getLength())
	       throw new IndexOutOfBoundsException();
	    T dataItem = head.getData();
	            
	    if (givenPosition == 0)
	       head = head.getNext();
	    else {
	       int idx = 0;
	       Node nextNode = head;
	       for (Node curr = head; nextNode != null; 
	                                     curr = nextNode) {
	          idx ++;
	          nextNode = curr.getNext();
	          if (idx == givenPosition ){ // nextNode is to be removed 
	             assert (nextNode != null);
	             dataItem = nextNode.getData();
	             curr.setNext(nextNode.getNext());
	             (nextNode).setPrev(curr);
	             break;
	            } 
	         }
	     }
	    return dataItem;
	}
	
	public boolean isEmpty() {
		if(head==null) {
			return true;
		}
		return false;
	}
	
	public void reverse() {
		Node temp = null;
		Node curr = head;
		
		while(curr != null) {
			temp = curr.getPrev();
			curr.setPrev(curr.getNext());
			curr.setNext(temp);
			curr = curr.getPrev();
		}
		temp = head;
		head = tail;
		tail = temp;
	}
	
	public void print() {
		Node curr = head;
		for(int i = 0; i < getLength(); i++) {
			System.out.print(curr.getData() + " ");
			curr = curr.getNext();
		}
		System.out.print("\n");
	}


	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		int i=0;
		
	    Node nextNode = head;
	    for (Node curr = head; nextNode != null; 
	                                     curr = nextNode) {
	          if(curr.data.equals(anEntry)) {
	        	  remove(i);
	        	  return true;
	          }
	          
	          nextNode = curr.getNext();
	          i++; 
	     }
	     
		return false;
	}

	@Override
	public void clear() {
		
		while(!isEmpty()) {
			@SuppressWarnings("unused")
			Node curr = head;
			head=head.next;
			curr = null;
		}
		
	}
	
	public T replace (int givenPosition, T newEntry) {
		
		T curr = remove(givenPosition);
		add(givenPosition, newEntry);
		return curr;
	}

	@Override
	public boolean contains(T anEntry) {
		Node curr;
		
		for (curr = head; curr != null;
                curr = curr.getNext())
			if((curr.getData()).equals(anEntry)) 
				return true;
		return false;
	}
	@SuppressWarnings("unused")
	private class IteratorForDoublyLinkedList implements Iterable<T>{
		private Node nextNode;
		  private Node currNode;
	       private Node prevNode;
		  private boolean nextWasCalled = false;
		  
		  public IteratorForDoublyLinkedList() {
			  nextNode = getHead();
	             currNode = null;
	             prevNode = null;
			  if (nextNode == null) {
				  throw new IllegalStateException 
	                        ("Cannot iterate on empty list");
			  }
		  }
		  
		  public boolean hasNext() {
			  return (nextNode != null);
		  }
		  
		  public T next() {
	             if (hasNext()) {
	            	 T result = (T) nextNode.getData();
	            	 prevNode = currNode;
	            	 currNode = nextNode;
	            	 nextNode = nextNode.getNext();
	            	 nextWasCalled = true;
	            	 return result;
	             }
	             else
	               throw new NoSuchElementException ("Illegal call: iterator after the end of the list");
		  }
		  public void remove() {
				//  throw new UnsupportedOperationException
	              // ("remove is not supported by this iterator");
	           if (!nextWasCalled)
	                throw new IllegalStateException("call to remove without call to next");
	           prevNode.setNext(nextNode);
			currNode = prevNode;
			nextWasCalled = false;
		  }
		  
	  }

	}
		

