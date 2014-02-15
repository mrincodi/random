package juguemos2;

public class PruebaGoogle {
	
	static java.util.ArrayList <String> longest = new java.util.ArrayList <String> ();

	public static String [] words ( String [] dictionary, char [] chars ){
		
		java.util.ArrayList < String > wordList = new java.util.ArrayList <String> ();

		java.util.HashMap <Character, Integer> h = new java.util.HashMap <Character, Integer> ();
		java.util.HashMap <Character, Integer> hAux = new java.util.HashMap <Character, Integer> ();
		
		//Let's make the hashMap
		for ( int i = 0; i < chars.length; i++){
			if ( h.containsKey(chars [ i ])){
				h.put(chars [ i ],h.get(chars [ i ]) + 1);
				hAux.put(chars [ i ],h.get(chars [ i ]) + 1);

			}
			else{
				h.put(chars [ i ], 1);
				hAux.put(chars [ i ], 1);

			}
		}
		

		//Let's go over all the words in the dictionary.
		for ( int i = 0; i < dictionary.length; i++){
			String s = dictionary [ i ];
			
			boolean passes = true;
			for (int j = 0; passes && j < s.length(); j++){
				char c = s.charAt(j);
				if ( h.containsKey(c) && h.get(c)>0){
					h.put(c,h.get(c)-1);
				}
				else {
					passes = false;
				}
			}
			
			if ( passes ){
				wordList.add(s);
				
				if ( longest.size () == 0 || longest.get(0).length() == s.length()){
					longest.add ( s );
				}
				else if ( longest.get(0).length() < s.length()){
					longest = new java.util.ArrayList <String> ();
					longest.add ( s );
				}
			}
			
			//Update the HashMap.
			for ( char c : hAux.keySet()){
				h.put(c, hAux.get(c));
			}
		}
		
		return wordList.toArray ( new String [ 0 ] );
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char [] chars = { 't', 'n', 'i', 'm', 'l' };
		
		String [] dictionary = { "timeline",
				"limit", 
				"elite", 
				"inlet", 
				"tile", 
				"lien", 
				"lite", 
				"emit", 
				"teen", 
				"teem", 
				"tine", 
				"item", 
				"lime", 
				"time", 
				"lint", 
				"line", 
				"mite", 
				"mint", 
				"mini", 
				"mine", 
				"milt", 
				"mile", 
				"lent", 
				"mien", 
				"meet", 
				"mete", 
				"nite", 
				"limn", 
				"melt", 
				"lee", 
				"men", 
				"lie", 
				"lit", 
				"net", 
				"nee", 
				"eel", 
				"met", 
				"nit", 
				"tie", 
				"tee", 
				"let", 
				"mil", 
				"lei", 
				"ten", 
				"tin", 
				"elm", 
				"nil", 
				"in", 
				"me", 
				"en", 
				"mi", 
				"em", 
				"it", 
				"ti", 
				"el", 
				"i"}; 

		String [] words = words (dictionary, chars );
		
		for ( int i = 0; i < words.length; i++){
			System.out.println ( words [ i ] );
		}
		
		System.out.println ( "Longest words: ");
		for ( int i = 0; i < longest.size(); i++){
			System.out.println ( longest.get(i) );
		}
		
		
	}

}
