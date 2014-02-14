package juguemos;

import java.util.Arrays;

interface iReverseString { 
	public String reverseString ( String s );
}

class ReverseString1 implements iReverseString {

	public  String reverseString ( String s ){

		StringBuffer sb = new StringBuffer();

		int i = s.length() - 1;

		while ( i >= 0 ){
			sb.append(s.charAt(i--));
		}

		return sb.toString();

	}
	
}

class ReverseString2 implements iReverseString {

	public String reverseString ( String s ) {
		return new StringBuffer ( s ).reverse().toString();
	}
	
}

class ReverseString3 implements iReverseString {

	public String reverseString ( String s ){

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
	
}

public class ReverseStringBenchmarking2 {
	
	public static long benchmarkReverseStringMethod ( iReverseString reverseStringObject, String s, int numTimes, boolean silent ){
		
		if  (!silent){
			System.out.println ( "Testing " + reverseStringObject.getClass().getName());
		}
			
		long startTime, endTime, duration = 0, totalDuration = 0, average;
		String rr = null;
		for ( int i = 0; i < numTimes; i++ ){
		
			startTime = System.nanoTime();
					
			rr = reverseStringObject.reverseString(s);
	
			endTime = System.nanoTime();
	
			duration = endTime - startTime;
			
			totalDuration+=duration;
		}
	
		average = totalDuration / numTimes;
		
		if  (!silent){
			System.out.println ( "Results:");
			System.out.println ( "Reversed string:" + rr);
			System.out.println ( "Average time:" + average);
		}
		
		return average;
	}
	
	
	public static void main ( String [] args) {
		String qq = "Come into my World. ";
		
		StringBuilder sb = new StringBuilder ( qq );
		
		for (int i = 0; i < 1000; i++){
			sb.append(qq);
		}
		
		qq = sb.toString();
		
		System.out.println ( "Lenght of string: " + qq.length() );

		int numTimes = 100000;

		long time1 = benchmarkReverseStringMethod (new ReverseString1 (), qq, numTimes, false);
		long time2 = benchmarkReverseStringMethod (new ReverseString2 (), qq, numTimes, false);
		long time3 = benchmarkReverseStringMethod (new ReverseString3 (), qq, numTimes, false);
		
//		String rr = new ReverseString1().reverseString ( qq );
//		
//		System.out.println ( rr );
		System.out.println ( time1 );
		System.out.println ( time2 );
		System.out.println ( time3 );
	}
	
}
