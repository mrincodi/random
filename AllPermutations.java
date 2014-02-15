package juguemos2;

public class AllPermutations {

	
	public static java.util.HashSet <String> allPermutations ( String s ) {

		java.util.HashSet <String> result = new java.util.HashSet <String> ();

		if ( s == null || s.length () == 0 ) return result;

		if ( s.length () == 0 ) return result;

		if ( s.length () == 1 ){

			result.add ( s );
			return result;
		}

		for ( int i = 0; i < s.length (); i++ ){

			if ( s.length () == 11 ) System.out.print (".");
					
			//Make a string without the character charAt ( i );
			StringBuffer choppedStringBuffer = new StringBuffer ();

			String beforeString = new String ();
			String afterString = new String ();

			if ( i != 0 ) beforeString = s.substring ( 0, i );
			if ( i != s.length () - 1 ) afterString = s.substring ( i + 1, s.length() );

			choppedStringBuffer.append ( beforeString + afterString );

			String choppedString = choppedStringBuffer.toString ();

			System.out.println (choppedString);
			//Get all the strings possible without the character s.charAt ( i ).
			java.util.HashSet <String> partial = allPermutations ( choppedString );

			//Add the character previously taken out to the beginning of all the elements in the set.

			for ( String s1 : partial ){;
				result.add ( s.charAt ( i ) + s1 );
			}
		}

		return result;
	}

	
	public static String [] allPermutations2 ( String s ) {

		java.util.ArrayList <String> result = new java.util.ArrayList <String>  ();

		if ( s == null ) return null;

		if ( s.length () == 0 ) return new String [ 0 ];

		if ( s.length () == 1 ){

			result.add ( s );
			return result.toArray ( new String [ 0 ] );
		}

		for ( int i = 0; i < s.length(); i++ ){

			//Make a string without the character charAt ( i );
			StringBuffer choppedStringBuffer = new StringBuffer ();

			String beforeString = new String ();
			String afterString = new String ();

			if ( i != 0 ) beforeString = s.substring ( 0, i );
			if ( i != s.length () - 1 ) afterString = s.substring ( i + 1, s.length() );

			choppedStringBuffer.append ( beforeString + afterString );

			String choppedString = choppedStringBuffer.toString ();

			//Get all the strings possible without the character s.charAt ( i ).
			String [] partial = allPermutations2 ( choppedString );

			//Add the character previously taken out to the beginning of all the elements in the set.

			for ( String s1 : partial ){
				result.add ( s.charAt ( i ) + s1 );
			}
		}

		return result.toArray ( new String [ 0 ] );
	}

	
	public static void main(String[] args) {
		
		long beforeTime = System.nanoTime();
		
		//java.util.HashSet < String >  ap = allPermutations ( "");

		String []  ap = allPermutations2 ( "eee");
		
		long afterTime = System.nanoTime();

		for ( String s : ap ){
			System.out.println ( s );
		}
		
		double diffTime = (afterTime - beforeTime) / Math.pow(10,  9);
		
		//System.out.println ( "\n"+ diffTime + " seconds; " + ap.size() + " words.");
		

	}

}
