package juguemos2;

public class TestGoogle2 {

	public static Integer [] removeDuplicates ( Integer [] array ){
		if ( array == null ) return null; // Or throw exception.	// MR: Olvidé null

		if ( array.length == 0 ) return new Integer [ 0 ];

		//By ordering the array and then removing what's duplicate:
		java.util.Arrays.sort ( array );
		java.util.ArrayList <Integer> aux = new java.util.ArrayList < Integer > ();
		
		int j = 0;
		aux.add ( array [ 0 ]);
		for ( int i = 0; i < array.length; i++ ){
			if ( array [ i ] != aux.get ( j ) ){	//MR: Olvidé abrir la llave.
				aux.add ( array [ i ] );
				j++;
			}
		}

		Integer [] result = aux.toArray ( new Integer [ 0 ] );	//MR: Olvidé new
		return result;
	}
	

	public static Integer [] removeDuplicates2 ( Integer [] a ){
		if ( a == null ) return null; //MR: Forgot parenthesis!!
		java.util.LinkedHashMap <Integer, Boolean> h = new java.util.LinkedHashMap <Integer, Boolean> (4,1f, true){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean removeEldestEntry (java.util.Map.Entry m) {
				return ( this.size() > 4 );
			}
		};
		
		for ( int i =0; i < a.length; i++ )
			h.put ( a [ i ], true );

		java.util.Set <Integer> s = h.keySet(); //It's keySet, not getKeys!!

		java.util.ArrayList <Integer> aL = new java.util.ArrayList <Integer> (); //MR: I forgot the type of the arraylist.

		aL.addAll ( s );

		Integer [] result = aL.toArray ( new Integer [ 0 ] ); //Syntax problem with new clause (at the left side), and also aL variable name wrong (lowercase)

		return result;
	}

	public static void main ( String [] args ){
		Integer [] a = { 5,6,7,3,4,5,6,7,1,2,3,9,8,7,4,5,6,3,2,0,1,-1,1,2,1,100,0};

		Integer [] b = removeDuplicates2 ( a );

		for ( int i = 0; i < b.length; i++ )	//MR: Error. It's b.length 
			System.out.print ( b [ i ] + " " );
		 
	}

}
