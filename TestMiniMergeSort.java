package juguemos;

import static org.junit.Assert.*;

import org.junit.Test;

import etc.Auxy;

public class TestMiniMergeSort {

	@Test
	public void testSort () {
		
		final int MAX = 200;
		int [] A = new int [ MAX ];
		int [] sortedA = new int [ MAX ];
			
		for ( int i = MAX-1; i >= 0; i--){
			A [ MAX - i - 1 ] = i;
			sortedA [ i ] = i;
		}
		
		System.out.println ("qq");
		MiniMergeSort.mergeSort(A);
		
		String originalArrayString = Auxy.intArrayToString(A);
		String sortedArrayString   = Auxy.intArrayToString(sortedA);
		
		System.out.println (originalArrayString);
		System.out.println (sortedArrayString);
		
		System.out.println ("qq");
		
		assertEquals ("Los dos arreglos deben ser iguales", originalArrayString, sortedArrayString);
		
	}
	
	
	@Test
	public void testSort1 () {
		
		final int MAX = 200;
		int [] A = new int [ MAX ];
		int [] sortedA = new int [ MAX ];
			
		for ( int i = MAX-1; i >= 0; i--){
			A [ MAX - i - 1 ] = i;
			sortedA [ i ] = i;
		}
		
		System.out.println ("qq");
		MiniMergeSort.mergeSort(A);
		
		String originalArrayString = Auxy.intArrayToString(A);
		String sortedArrayString   = Auxy.intArrayToString(sortedA);
		
		System.out.println (originalArrayString);
		System.out.println (sortedArrayString);
		
		System.out.println ("qq");
		
		assertEquals ("Los dos arreglos deben ser iguales", originalArrayString, sortedArrayString);
		
	}
	
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

}
