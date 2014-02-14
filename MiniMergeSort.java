package juguemos;

//import java.util.Arrays;




/**
* MR: Poner documentaci—n.
*/
public class MiniMergeSort {

        public static void main ( String [] args ){
        	int [] A = { 7,6,5,4,3,2 };
        	mergeSort ( A );
        	for ( int i = 0; i < A.length; i++)
        		System.out.print (A [ i ]  + " " );
        }

        public static void mergeSort ( int [] A ){
                mergeSort (A, 0, A.length - 1);
        	}

        public static void mergeSort ( int []A, int start, int end ){

                if ( start < end
                        && start >= 0 && end <= A.length - 1 ){
                        int middle = ( start + end ) / 2;	// MR: Ac‡ hab’a un error.
                        mergeSort ( A, start, middle );
                        mergeSort ( A, middle + 1, end );
                        merge ( A, start, middle, end );
                }
        }

        /**
         * Merges two contiguous ordered arrays.<p>
         * 
         * The arguments 'start', 'middle' and 'end' indicate the limits of these arrays
         * in the following way:<p>
         * 
         * <code>
         * [ ... [ start ... middle ] [ middle + 1 ... end ] ...]
         * </code>
         * 
         * <p> Mandatory preconditions:
         * <ul>
         * <li> The value of each int argument is between 0 and A.length. </li>
         * <li> The value of 'start' is less or equal than 'middle'. </li>
         * <li> The value of 'middle' is less than 'end'. </li>
         * </ul>
         * 
         * 
         * Preconditions: <br>
         * <ul>
         * <li> The arrays  [ start ... middle ] and [ middle + 1 ... end ] are both sorted. </li>
         * </ul>
         * 
         * @param A The integer array.
         * @param start The starting position of the first array.
         * @param middle The ending position of the first array.
         * @param end The ending position of the second array.
         */
        private static void merge ( int [] A, int start, int middle, int end ){

                int [] B = new int [ end - start + 1 ];
                int i = start, j = middle + 1, k = 0;
                
                while ( i <= middle && j <= end ){
                        if ( A [ i ] < A [ j ] )
                                B[ k++ ] = A [ i++ ];
                        else
                                B[ k++ ] = A [ j++ ];
                }
                
                if ( i == middle + 1 )
                	System.arraycopy(A, j, B, k, end - j + 1);
                else 
                	System.arraycopy(A, i, B, k, middle - i + 1);

                System.arraycopy(B, 0, A, start, B.length);
        }
}

//Te amo. Chao. <3


