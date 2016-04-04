/************************************************************************
CS3410 Data Structures
Assignment 4

Zac Hollingsworth
February 22, 2013

In this programmin assignment you are required to implement a queue data 
structure using a singly linked list. Write a Java program to implement
the queue using a linked list instead of a fixed size array. You can
assume the items to be stored in the queue are positive integers. You
do not need to incorporate any ordering. However, the queue must have a
front and rear. Any item inserted to the queue will be inserted at rear
and items must be deleted from front.

Your main() method should be interactive and should give the options
listed in class to the user.
*************************************************************************/
import java.util.*;

//******************************************************
//Class to create nodes
//******************************************************
class Node<Integer>{
	Node<Integer> next;
	private int value;
	//Constructor
	public Node(int value){
		this.value = value;
	}
	//To determine node value
	public String toString(){
		String result = ""; 
		result += value + " ";
		return result;
	}
	//Returns value of node
	public int getValue(){
		return value;
	}
}

//******************************************************
//Class to implement linked list
//******************************************************
class LinkList{
	static Scanner input = new Scanner(System.in);
	static int numInts = 0;
	
	Node<Integer> head = null;
	Node<Integer> tail = null;
		
	public LinkList(){
		head = null;
		tail = null;
	}
	//******************************************************
	//Method to add node to the end of the queue
	//******************************************************
	public void enqueue(int value){
		Node<Integer> newNode = new Node<Integer>(value);
		if(tail == null)
			head = tail = newNode;
		else{
			tail.next = newNode;
			tail = tail.next;
		}
		numInts++;
	}

	//******************************************************
	//Method to delete node from the front of the queue
	//******************************************************
	public int dequeue(){
		int j = 0;
		if(numInts == 0)
			System.out.println("Nothing stored in Queue.");
		else if(head.next == null){
			j = head.getValue();
			head = tail = null;
			numInts --;
		}else{
			j = head.getValue();
			head = head.next;
			numInts --;
		}
		return j;
	}
	
	//******************************************************
	//Method to assist case 1 in enqueue
	//******************************************************
	public void addNode(){
		System.out.print("Enter a positive Integer: ");
		enqueue(input.nextInt());
	}
		
	//******************************************************
	//Method to display first item in queue
	//******************************************************
	public void displayFirst(){
		System.out.println("Item at Front: "+head);
	}
	
	//******************************************************
	// Method to display last item in queue
	//******************************************************
	public void displayLast(){
		System.out.println("Item at Rear: "+tail);
	}
		
	//******************************************************
	// Method to display number of items in queue
	//******************************************************
	public void disNumItems(){
		System.out.println("Number of items in queue: "+numInts);
	}
	
	//******************************************************
	// Method to display items in queue
	//******************************************************
	public void displayQueue(){
		if(numInts != 0){
			Node<Integer> current = head;
			System.out.print("Items in Queue: ");
			while(current != null){
				System.out.print(current);
				current = current.next;
				System.out.print(" ");
			}//end of while
		}//end of if
		else
			System.out.print("No items in Queue");
		System.out.println();
	}
}
	
//******************************************************
//Main method 
//******************************************************
public class Single_Linked_List{	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int menuOp = 0;
		LinkList queue = new LinkList();
		
		String menuStr = "****************************************************************"+
		"\n1) Insert an item to the queue"+
		"\n2) Delete an item from the queue"+
		"\n3) Display the item at front"+
		"\n4) Display the item at rear"+
		"\n5) Display total number of items currently present in the queue"+
		"\n6) Display the items currently present in the queue"+
		"\n7) Quit\n****************************************************************"+
		"\nPlease choose an option from the menu: ";
		
		System.out.print(menuStr);
		menuOp = scan.nextInt();
	
		while (menuOp != 7) {
					    			
			switch (menuOp) {
			
				case 1:  
				 	queue.addNode();
					break;
							
				case 2: 
					queue.dequeue();
			  		break;
					
				case 3:	
					queue.displayFirst();
					break;
				
				case 4: 	
					queue.displayLast();
					break;
					
				case 5: 
					 queue.disNumItems();
					break;
									
				case 6:  
					queue.displayQueue();
					break;
					
				default: String outMessage= "Invalid Selection";
			  		System.out.println(outMessage);
			  		break;
			}// end of switch
			System.out.println(menuStr);
			menuOp = scan.nextInt();
		}// end of while
	}
}
