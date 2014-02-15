package juguemos2;

public class TestGoogle {
//	public static MyLinkedListNode reverseList ( MyLinkedListNode l ){
//		if ( l == null ) return null;
//		
//		MyLinkedListNode newList = reverseList ( l.next );
//
//		if ( newList == null ) return new MyLinkedListNode (l.value );
//		
//		//We add a node with the first value at the end of the list.
//
//		MyLinkedListNode pointer = newList;
//		while ( pointer.next != null )
//			pointer = pointer.next;
//		pointer.next = new MyLinkedListNode (l.value );
//
//		return newList;
//	}
	
	public static MyLinkedListNode reverseList2 ( MyLinkedListNode l ){

		if ( l == null ) return null;

		if ( l.next == null ) return l;

		MyLinkedListNode secondElement = l.next;

		l.next = null;

		MyLinkedListNode rList = reverseList2 ( secondElement );

		secondElement.next = l;

		return rList;
		
	}

	public static void main ( String [] args ){
		MyLinkedListNode a = new MyLinkedListNode ( 5 );
		a.next = new MyLinkedListNode ( 7 );
		a.next.next = new MyLinkedListNode ( 9 );
		a.next.next.next = new MyLinkedListNode ( 11 );

		MyLinkedListNode pointer = a;
		while ( pointer != null ){
			System.out.print( pointer.value + " ");
			pointer = pointer.next;
		}

		System.out.println ( );

		MyLinkedListNode reverseA = reverseList2 ( a );

		pointer = reverseA;

		while ( pointer != null ){
			System.out.print ( pointer.value + " " );
			pointer = pointer.next;
		}
	}
	
	
	@org.testng.annotations.Test
	public void testNull ( ){
		org.testng.Assert.assertEquals(null, reverseList2 ( null ));
	}
	

	@org.testng.annotations.Test
	public void testOneElement (){
		MyLinkedListNode l = new MyLinkedListNode (5 );
		org.testng.Assert.assertEquals ( reverseList2 ( l ), l );
	}

	@org.testng.annotations.Test
	public void testLongListReversed (){
		MyLinkedListNode l = new MyLinkedListNode ( 0 );
		MyLinkedListNode p = l;
		for ( int i = 1; i <= 1000; i ++ ){
			p.next = new MyLinkedListNode ( i );
			p = p.next;
		}

		l = reverseList2 ( l );
		
		System.out.println ( l.value );
		
		org.testng.Assert.assertEquals ( l, p );
		org.testng.Assert.assertEquals ( l.next.value, 999 );

	}
	
}


class MyLinkedListNode  {
	int value;
	MyLinkedListNode  next;

	public MyLinkedListNode ( int value ){
		this.value = value;
		this.next = null;
	}
	
	
	
	
	
	
	
	
	
	
}