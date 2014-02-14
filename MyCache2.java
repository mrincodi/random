package juguemos;

import java.util.Map;

public class MyCache2 extends java.util.LinkedHashMap <Object, Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int maxSize;
	
	public MyCache2 ( int maxSize ){
		super ( maxSize, 1.0f, true);
		this.maxSize = maxSize;
	}

	@Override
	public boolean removeEldestEntry (Map.Entry<Object, Object> eldest){
		return ( super.size() > maxSize );
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyCache2 mc2 = new MyCache2 (100);
		
		mc2.put(7, "mpa");
		
		System.out.println ( mc2.get ( 7 ) ); 
		
		
		
	}

}
