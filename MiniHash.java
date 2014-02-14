package juguemos;

public class MiniHash {

	int arraySize  = 100;
	int size = 0;
	java.util.ArrayList <java.util.ArrayList<Object []>> arrays;

	public MiniHash ( int arraySize ){
		this.arraySize = arraySize;
		arrays = new java.util.ArrayList < java.util.ArrayList < Object [] > > ( arraySize  );
		
		for ( int i = 0; i < arraySize; i ++ ){
			arrays.add( null );
		}
	}

	public void add ( Object key, Object value ) {

		if ( key == null || value == null ) throw new java.lang.NullPointerException ( "No null values!");

		Object [] keyAndValue = new Object [ 2 ];

		keyAndValue [ 0 ] = key;
		keyAndValue [ 1 ] = value;

		//First let,s run the hashing method.

		int index = key.hashCode () % arraySize;

		//Now let's add it.

		if ( arrays.get ( index ) == null ){

			arrays.set ( index, new java.util.ArrayList < Object [] > () );

		}

		arrays.get ( index).add ( keyAndValue );
	}


	public Object get ( Object key ) {

		if ( key == null ) return null;

		int index = key.hashCode () % arraySize;

		if ( arrays.get ( index ) == null ) return null;

		
		java.util.ArrayList < Object [] > keyValueArray = arrays.get (index ); 

		for ( int i = 0; i < keyValueArray.size(); i++ ){
			if ( keyValueArray.get ( i ) [ 0 ].equals ( key ) ) return keyValueArray.get ( i ) [ 1 ];
		}

		return null;

	}

	public static void main ( String [] args ){
		MiniHash mh = new MiniHash ( 100 );

		mh.add ( 15, "pp");
		mh.add ( 30, "qq");

		System.out.println ( mh.get ( 30 ) );
	}

}


		

