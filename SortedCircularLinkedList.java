package juguemos;

public class SortedCircularLinkedList {

	public Node firstNode;

	public SortedCircularLinkedList ( int value ){
		this.firstNode = new Node ( value );
		this.firstNode.next = this.firstNode;
	}
	
	public void insertNode ( int value ){
		Node newNode = new Node ( value );

		Node firstNode = this.firstNode;

		if ( firstNode == null ){		//No elements
			newNode.next = newNode;
			this.firstNode = newNode;	
		}
		else {			// several elements
			boolean inserted = false;
			Node nodePointer = firstNode;

			do {
				if ( nodePointer.value >= value ) {

					insertNode ( nodePointer, value );

					inserted = true;
				}
				else {
					nodePointer = nodePointer.next;
				}
			}
			while ( nodePointer != firstNode && !inserted );

			if ( !inserted ){
				//It’s the last element

				insertNode ( nodePointer, value );
				
				this.firstNode = firstNode.next;
			}
		}
	}
	
	private void insertNode ( Node nodePointer, int value ){
		Node newNode = new Node ( value );
		
		newNode.next = nodePointer.next;
		newNode.value = nodePointer.value;
		nodePointer.next = newNode;
		nodePointer.value = value;
	}
	
	public void printList ( ) {
		if ( this.firstNode != null ){
			Node nodePointer = this.firstNode;

			do {
				System.out.print(nodePointer.value + " ");
				nodePointer = nodePointer.next;
			}
			while ( nodePointer != this.firstNode ); 
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SortedCircularLinkedList slll = new SortedCircularLinkedList(4);
		slll.insertNode(5);
		slll.insertNode(7);
		slll.insertNode(9);
		slll.insertNode(-6);
		slll.insertNode(3);
		slll.insertNode(-1);
		
		slll.printList();
		
	}
		

}
