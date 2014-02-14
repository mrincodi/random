package juguemos;

public class MiniQuickSort {

	
	
	
	
	public static void myQuickSort ( int [] array ){
		myQuickSort ( array, 0, array.length - 1 );
	}

	public static void myQuickSort ( int [] array, int start, int end ){
		if ( start >= end ) return;

		int value = array [ start ];

		int i = start, j = end;

		while ( i < j ){

			while ( array [ i ] <= value && i < j ) i++;
			while ( array [ j ] > value ) j--;

			if ( i < j ){
				int aux = array [ i ];
				array [ i ] = array [ j ];
				array [ j ] = aux;
			}
		}

		array [ start ] = array [ j ];
		array [ j ] = value;

		myQuickSort ( array, start, j - 1 );

		myQuickSort ( array, j + 1, end );

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] array = { 7,4,5,3,8,9,1,2,6,10 };
		myQuickSort(array);
		for ( int i = 0; i < array.length; i++ ){
			System.out.println ( array [ i ] + " " );
		}
	}

}


