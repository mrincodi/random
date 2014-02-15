package juguemos2;

public class Basic {

	
	
	public static void main ( String [] args ){
//		Integer [] a = {5,6,7,8};
//
//		java.util.ArrayList <Integer> aL = new java.util.ArrayList <Integer> (java.util.Arrays.asList ( a ) );
//
//		aL.add ( 8 );
//
//		a = aL.toArray ( new Integer [ 0 ] );
//
//		System.out.println ( a.length );
//
//		
//		

		
		int [] a = { 7,5,6,4,3,8,2,1,9 };
//		int [] a = { 10,20,30,40};
		
//		java.util.Arrays.sort(a);
//		
//		java.util.ArrayList <Integer> aL = new java.util.ArrayList<Integer> ( java.util.Arrays.asList ( a) );
		
		myQuickSort(a);
		
		for ( int i = 0; i < a.length; i++ ){
			System.out.println ( a [ i ] + " " );
		}

	}
	
	
	
	public static void mergeSort ( int [] a ){

		mergeSort ( a, 0, a.length - 1 );

	}

	/**
	 * Will take an array and 2 indexes of it.
	 */
	public static void mergeSort ( int [] a, int start, int end ){

		if ( a == null ) return;	// Or throw an exception.

		if ( start < 0 || end < 0 || start > end || end >= a.length ) return; //Or throw an exception.

		if ( end == start ) return;	// No change needed.

		//Divide in 2 and then sort.
		
		int middle = start + ( end - start ) / 2;	// ¡OJO!

		mergeSort ( a, start, middle );

		mergeSort ( a, middle + 1, end );

		mergeSorted ( a, start, middle, end );

	}

	public static void mergeSorted ( int [] a, int start, int middle, int end ){

		if ( a == null ) return; 			// Or throw an exception.

		if ( start < 0 || end < 0 || start > middle || middle > end || end >= a.length ) return; //Or throw an exception.

		int [] b = new int [ end - start + 1 ];

		int i = start, j = middle + 1, k = 0;

		while ( i <= middle && j <= end ){

			if ( a [ i ] < a [ j ] ) {
				b [ k ] = a [ i ];
				i++;
			}
			else {
				b [ k ] = a [ j ];
				j++;
			}
			k++;
		}

		if ( i <= middle ){
			while( i <= middle ){
				b [ k ] = a [ i ];
				i++;
				k++;
			}
		}
		else {
			while( j <= end ){
				b [ k ] = a [ j ];
				j++;
				k++;
			}
		}

		//Finally, put again in main array.
		k = 0;
		while ( k < b.length ){
			a [ start + k ] = b [ k ];
			k++;
		}
	}	


public static void quickSort ( int [] a ) {

	quickSort ( a, 0, a.length - 1);

}

public static void quickSort ( int [] a, int start, int end ) {

	if ( a == null ) return;	//Or throw exception if null.

	if ( end == start ) return ;

	if ( start < 0 || start > end || end >= a.length ) return;

	int pivot = a [ start ];

	java.util.ArrayList <Integer> lessThan = new java.util.ArrayList <Integer> ();
	java.util.ArrayList <Integer> moreThan = new java.util.ArrayList <Integer> ();

	for ( int i = start + 1; i <= end; i ++ ){
		if ( a [ i ] < pivot ) lessThan.add ( a [ i ] );
		else moreThan.add ( a [ i ] );
	}

	//Now move to the array again.

	for ( int i = 0; i < lessThan.size(); i++ ){
		a [ start + i ] = lessThan.get ( i );
	}

	int newMiddle = start + lessThan.size();
	a [ newMiddle  ] = pivot;

	
	for ( int j = 0; j < moreThan.size(); j++ ){
		a [ start + lessThan.size() + 1 + j ] = moreThan.get ( j );
	}

	quickSort ( a, start, newMiddle - 1 );
	quickSort ( a, newMiddle + 1, end);

}


	

public static void myQuickSort ( int [] a ){
	myQuickSort ( a, 0, a.length - 1 );
}

public static void myQuickSort ( int [] array, int start, int end ){
	if ( array == null ) return; // or throw exception.

	if ( start < 0 || end < start || end >= array.length ) return;
	
	if ( start == end ) return;

	int pivot = array [ start ];

	int i = start, j = end;

	while ( i < j ){
		while ( array [ i ] <= pivot && i < j ) i++;
		while ( array [ j ] > pivot ) j--;	//OJO.
		if ( i < j ){
			//Swap i and j.
			int aux = array [ i ];
			array [ i ] = array [ j ];
			array [ j ] = aux;
		}
	}
		
	array [ start ] = array [ j ];
	array [ j ] = pivot;

	myQuickSort (array, start, j - 1);
	myQuickSort (array, j + 1, end);
}

	
	
	
	
	
	
	
	
	
	
	
	
	


}
