package juguemos;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyCache {

	//Let's not reinvent the wheel and let's use the existing LinkedHashMap class in java
	
	private int cacheSize = 0;
	private java.util.LinkedHashMap <Object, Object> cache;

	public MyCache ( final int cacheSize ){	//MR: Variable must be final.
		this.cacheSize = cacheSize;
		cache = new LinkedHashMap <Object, Object> () {
			@Override
			protected boolean removeEldestEntry (Map.Entry<Object, Object> Entry ){
				return size() > cacheSize;
			}
		};
	}

	public void add ( Object k, Object v){
		cache.put (k, v);
	}

	public Object get ( Object k){
		return ( cache.get (k) );	//MR: Syntax! //MR: I had forgotten the return keyword.
	}
	


	public static void main ( String [] args ){
		MyCache marioCache = new MyCache ( 50 );	//MR: Error: Wrongly written.
		marioCache.add (5, "Ele");
		marioCache.add ( "Hola", "Mundo");
		System.out.println ( marioCache.get ( "Hola" ) );
	}
}
