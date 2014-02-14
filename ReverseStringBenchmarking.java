package juguemos;

import java.util.Arrays;

public class ReverseStringBenchmarking {

	public static String reverseString ( String s ){
		
		StringBuffer sb = new StringBuffer();
		
		int i = s.length() - 1;
		
		while ( i >= 0 ){
			sb.append(s.charAt(i--));
		}
		
		return sb.toString();

	}
	
	public static String reverseString2 ( String s ) {
		return new StringBuffer ( s ).reverse().toString();
	}
	
	public static String reverseString3 ( String s ){
		
		if ( s == null ) return null;
		
		StringBuffer sb = new StringBuffer(s);
		
		int middle = sb.length() / 2;
		
		if ( sb.length() % 2 == 0) middle--;
		
		for ( int i = middle; i >= 0; i--){
			char temp = sb.charAt(i);
			
			sb.setCharAt( i, sb.charAt(sb.length() - 1 - i ));
			sb.setCharAt( sb.length() - 1 - i, temp);
			
		}
		
		return sb.toString();

	}
	
//	public static String reverseString4 (String s ) {
	
	
	public static void main ( String [] args) {
		String qq = "Empanada";
		
		StringBuilder sb = new StringBuilder ( qq );
		
		for (int i = 0; i < 100; i++){
			sb.append(qq);
		}
		
		System.out.println (sb.length());
		qq = sb.toString();
		
		qq = qq + qq + qq + qq  ;
		
		System.out.println ( qq );

		long startTime, endTime, duration = 0, totalDuration = 0, average;
		int numTimes = 10000;
		String rr = null;
		for ( int i = 0; i < numTimes; i++ ){
		
			startTime = System.nanoTime();
					
			rr = ReverseStringBenchmarking.reverseString3(qq);
	
			endTime = System.nanoTime();
	
			duration = endTime - startTime;
			
			totalDuration+=duration;
		}
	
		average = totalDuration / numTimes;
		System.out.println ( rr );
		System.out.println ( duration );
	}
	
	
}
