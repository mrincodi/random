package juguemos;

public class Sera {



	public static void print2Largest ( int [] array ){
		if ( array == null ) { System.out.println ( "Null!" ); return ; } 
		if ( array.length == 0 ) { System.out.println ( "Empty!"); return ; }
		if ( array.length == 1 ) { System.out.println ( "Only element: " + array [ 0 ]); return; }

		int largest = array [ 0 ];
		int secondLargest = array [ 1 ];

		if ( array [ 0 ] < array [ 1 ] ) {
			largest = array [ 1 ];
			secondLargest = array [ 0 ];
		}


		for ( int i = 2; i < array.length; i++ ){
			if ( array [ i ] > largest ){
				secondLargest = largest;
				largest = array [ i ];
			}
			else if ( array [ i ] > secondLargest ){
				secondLargest = array [ i ];
			}
		}

		System.out.println ( "Largest = " + largest);
		System.out.println ( "Second largest = " + secondLargest);
	}

	public static int [] removeDuplicates ( int [] array ){

		if ( array == null ) return null;

		int newArray [] = new int [ array.length ];

		if ( array.length == 0 ) return newArray;

		newArray [ 0 ] = array [ 0 ];

		if ( array.length == 1 ) { return newArray; }

		int  j = 0;

		for ( int i = 1; i < array.length; i++ ){

			if ( array [ i ] != newArray [ j ] ){
				j++;
				newArray [ j ] = array [ i ];
			}
		}

		int [ ] newArray2 = new int [ j + 1 ];

		for ( int i = 0; i < j + 1; i++ ){ 
			newArray2 [ i ] = newArray [ i ];
		}


		return newArray2;

	}





	static class MyLinkedList {
		public int value;
		public MyLinkedList next;
		
		
	}


	public static MyLinkedList mergeLinkedList (MyLinkedList listA, MyLinkedList listB ){

		MyLinkedList listC = new MyLinkedList ();

		if ( listA == null && listB == null ) return null;

		if ( listA == null ) {
			listC = copyOf ( listB );	//TODO: Code.
			return listC;
		}
		if ( listB == null ){
			listC = copyOf ( listA );	//TODO: Code.
			return listC;
		}

		int i = 0, j = 0;

		boolean reachedEndA = false, reachedEndB = false;

		while ( listA != null && listB != null ){
			if ( listA.value < listB.value ) {
				listC.value = listA.value;
				listC.next = new MyLinkedList ();
				listA = listA.next;
			}
			else {
				listC.value = listB.value;
				listC.next = new MyLinkedList ();
				listB = listA.next;
			}
			listC = listC.next;
		}

		if ( listA != null ) {
			while ( listA != null ) {
				listC.value = listA.value;
				listC.next = new MyLinkedList ();
				listA = listA.next;
			}
		}

		else {
			while ( listA != null ) {
				listC.value = listA.value;
				listC.next = new MyLinkedList ();
				listB = listB.next;
			}
		}
		return listC;
	}

	public static  MyLinkedList copyOf (MyLinkedList list ){
		MyLinkedList list2 = new MyLinkedList ();

		while ( list != null ) {
			list2.value = list.value;
			list2.next = new MyLinkedList ();
			list = list.next;
		}

		return list2;
		
		
	}	
	
	@org.testng.annotations.Test
	@org.testng.annotations.Parameters ({ "amount", "expected"})
	public static void seraMethod (){
		java.util.HashMap <Object, Object > h = new java.util.HashMap<Object, Object>();
		
		h.put( 5,  "empa");
		org.testng.Assert.assertEquals ( "The strings are different!", "h", "h");
		
	}





	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] a = { 5,4,6,5,7,8,9,0,1,-5,4,2,7,8,6,5,1,4,5,9 };
		
		print2Largest ( a );
		
		int [] b = { 2, 2, 2, 3, 3, 4, 4 };
		
		int [] c = removeDuplicates ( b );
		
		for ( int i = 0; i < c.length; i++ ){ System.out.print( c [ i ] + " "); }
		
	}

}
