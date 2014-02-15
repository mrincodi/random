package juguemos2;

public class MyHeapSort {

	public static void heapSort ( Integer [] a ){
		if ( a == null ) return;	//Or throw exception.

		heapify ( a );

		for ( int i = a.length - 1; i > 0; i-- ){
			swap ( a, 0, i );
			maxHeap ( a, 0, i-1);
		}
	}

	public static void heapify ( Integer [] a ){
		if ( a == null ) return;	//Or throw exception.

		if ( a.length <= 1 ) return;

		for (int i = a.length / 2 - 1; i >=0; i-- ){
			maxHeap ( a, i, a.length - 1 );
		}
	}

	public static void maxHeap ( Integer [] a, int rootPos, int finalPos ) {
		int posLeft =  (rootPos + 1 ) * 2 - 1;
		int posRight = (rootPos + 1 ) * 2;

		int posToCompare = 0;

		if ( posLeft > finalPos ) return;	//No children.
		else if ( posLeft == finalPos )	//One children/
			posToCompare = posLeft;
		else {					//Two children.
			if ( a [ posLeft ] > a [ posRight ] )
				posToCompare = posLeft;
			else
				posToCompare = posRight;
		}

		if ( a [ rootPos ] > a [ posToCompare ] ) return;
		else {
			swap ( a, posToCompare, rootPos );
			maxHeap (a, posToCompare, finalPos);
		}
	}

	public static void swap ( Integer [] a, int posX, int posY ){
		int aux = a [ posX ];
		a [ posX ] = a [ posY ];
		a [ posY ] = aux;
	}

	
	public static void main ( String [] args ){
		Integer [] a = { 5,7,6,8,4,3,2,1,9 };
		heapSort ( a );
		for ( int i = 0; i < a.length; i++ ) System.out.print ( a [ i ] + " " );
		
	}



}
