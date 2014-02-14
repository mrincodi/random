package juguemos;

public class MyHashImplementation {

	private int tableSize = 20;
	private Object [] backingArray;

	public MyHashImplementation (){
		backingArray = new Object [ this.tableSize ];
	}

	public void add ( Object key, Object value ) throws Exception{
		//Get the position in the backing array.
		if ( key == null || value == null){
			throw new java.lang.Exception ("No null value permitted in key or in value!!");	//Otherwise, how to indicate that a value is not in the hash table?
		}
		
		int position = getPositionByHash ( key );

		if ( this.backingArray [ position ] == null ) { // No values for this position of the array yet.
			this.backingArray [ position ] = new java.util.ArrayList < HashTableNode > ();
		}
		
		//Check if that key is already in the array.
		java.util.ArrayList < HashTableNode > list = ( java.util.ArrayList < HashTableNode > ) this.backingArray [ position ];
		
		for ( int i = 0; i < list.size(); i++){
			if ( list.get(i).key == key ){
				//throw new Exception ("Key already in hash!");
				return;
			}
		}
		
		list.add ( new HashTableNode ( key, value ));
	}

	public Object getValue ( Object key ) throws Exception{
		if ( key == null ){
			throw new java.lang.Exception ("No null value permitted in key!!");
		}

		int position = getPositionByHash ( key );
		if ( this.backingArray [ position ] == null ) return null;

		java.util.ArrayList < HashTableNode > list = (java.util.ArrayList < HashTableNode >) this.backingArray [ position ];

		for ( int i = 0; i < list.size (); i++ )	//Syntax! Size?
			if ( list.get ( i ).key.equals (key ) ) return list.get ( i ).value;	//Syntax!
		
		return null;
	}



	private int getPositionByHash ( Object key ) throws Exception{
		if ( key == null ){
			throw new java.lang.Exception ("No null value permitted in key!!");
		}

		return key.hashCode() % this.tableSize;

	}

	
	private class HashTableNode {
		Object key;
		Object value;

		HashTableNode (){
			key = null;
			value = null;
		}

		HashTableNode (Object key, Object value){
			this.key = key;
			this.value = value;
		}

		Object getKey (){
			return this.key;
		}

		Object getVaule (){
			return this.value;
		}
	}
	
	public static void main(String[] args) throws Exception {
		MyHashImplementation hashTable = new MyHashImplementation ();

		for ( int i = 0; i < 100000; i++){
			hashTable.add(i + " ", "Papitas " + i + 1);
		}
//		hashTable.add ( 10, 20 );
//
//		hashTable.add ( 10, 20 );
//		hashTable.add ( 5, 7 );

		System.out.println ( hashTable.getValue ( "79 " ) );
		

	}

}
