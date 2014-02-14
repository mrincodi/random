package juguemos;

public class MiniMergeSort2 {
	
	public static void myMergeSort ( int [] array ){
		myMergeSort (array, 0, array.length - 1 );
	}

	public static void myMergeSort ( int [] array, int start, int end ){
		if ( start >=  end ) return;

		int middle = ( end - start ) / 2 + start;

		myMergeSort ( array, start, middle );
		myMergeSort ( array, middle + 1, end );

		merge ( array, start, middle, end );
	}

	public static void merge ( int [] array, int start, int middle, int end ){

		if ( end <= start ) return;
		
		int [] aux = new int [ end - start + 1 ];

		for ( int i = 0; i <= end - start; i++ ){
			aux [ i ] = array [ i + start ];
		}

		int auxMiddle = middle - start;

		int i = 0, j = auxMiddle + 1, k = start;

		while ( i <= auxMiddle && j < aux.length ){
			if ( aux [ i ] <= aux [ j ] ){
				array [ k ] = aux [ i ];
				i++;
			}
			else {
				array [ k ] = aux [ j ];
				j++;
			}
			k++;				
		}

		while ( i <= auxMiddle ){
			array [ k ] = aux [ i ];
			i++;
		}
	}

	public static void main ( String [] args ){
		int [] array = { 7,5,8,6,9,1,2,0,4,3 };
		myMergeSort ( array );
		for ( int i = 0; i < array.length; i++ ){
			System.out.println ( i );
		}
	}
}
	
	

		