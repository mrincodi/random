package juguemos2;

public class FirstChar {

	


public static void firstNonRepeated ( String s){
	
	java.util.HashMap < Character, Boolean > h = new java.util.HashMap < Character, Boolean > ();
	for ( int i = 0; i < s.length(); i++ ){
		if ( h.keySet().contains ( s.charAt ( i ) ) )
			h.put (s.charAt ( i ), false );
		else
			h.put (s.charAt ( i ), true);
	}

	for ( int i = 0; i < s.length(); i++ )
		if ( h.keySet().contains ( s.charAt ( i ) ) && h.get ( s.charAt ( i ) ) == true){
			System.out.println ( s.charAt ( i ) );
			return;
		}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		firstNonRepeated ( "ampanadilla");
		
	}

}
