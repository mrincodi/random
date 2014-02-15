package juguemos2;

public class RemoveChars {

	public static String removeChars ( String s, String chars ){
		if ( s==null || chars == null) return s;

		//Move the chars to a hashSet.

		java.util.HashSet <Character> hs = new java.util.HashSet <Character> ();

		char [] cA = chars.toCharArray ();
		for ( int i = 0; i < chars.length(); i++ ){
			hs.add ( cA [ i ] );
		}

		StringBuffer sb = new StringBuffer ();
		for ( int i = 0; i < s.length(); i++ ){
			char c = s.charAt ( i );
			if ( !hs.contains ( c ))
				sb.append(c);
		}

		return sb.toString();
	}

			
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println ( removeChars ( "Empanadilla", "mpna"));
	}

}
