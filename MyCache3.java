package juguemos;


public class MyCache3 extends java.util.LinkedHashMap < Object, Object >{
	int maxSize;

	public MyCache3 ( int size ){
		super ( size, 1.0f, true );
		this.maxSize = size;
	}

	@Override
	public boolean removeEldestEntry ( java.util.Map.Entry < Object, Object > eldest ){
		return ( this.size () > maxSize );
	}

	public static void main ( String [] args ){
		MyCache3 mc3 = new MyCache3 ( 100 );
		mc3.put ("rr", "ss");
		System.out.println ( mc3.get("rr"));
	}
}
