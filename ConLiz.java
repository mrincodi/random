package juguemos;

class TreeNode {
	int value;
		TreeNode left;
		TreeNode right;

		public TreeNode ( int value ){
			this.value = value;
			this.left = null;
			this.right = null;
		}
}

public class ConLiz {

	
	


public static boolean isBinarySearchTree ( TreeNode t ){

	int [] qq = null;
	
	
	if ( t == null ) return true;

	int value = t.value;

	if ( !allElementsSmallerThan ( t.value, t.left ) || !allElementsGreaterThan ( t.value, t.right ) ) return false;

	return isBinarySearchTree ( t.left ) && isBinarySearchTree (t.right);


}

public static boolean allElementsSmallerThan ( int value, TreeNode t ){
	if ( t == null ) return true;
	if ( t.value >= value ) return false;
	return allElementsSmallerThan  ( value, t.left ) && allElementsSmallerThan  ( value, t.right);
}

public static boolean allElementsGreaterThan ( int value, TreeNode t ){
	if ( t == null ) return true;
	if ( t.value <= value ) return false;
	return allElementsGreaterThan  ( value, t.left ) && allElementsGreaterThan  ( value, t.right);
}



@org.testng.annotations.Test
public void testEmpty ( ){
	org.testng.Assert.assertTrue ( isBinarySearchTree  ( null ) );
	
}

@org.testng.annotations.Test
public void testSingleNode ( ){
	TreeNode t = new TreeNode ( 0 );
	org.testng.Assert.assertTrue ( isBinarySearchTree  ( t) );
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t = new TreeNode (5);
		t.left =  new TreeNode (2);
		t.left.left= new TreeNode (1);
		t.left.right= new TreeNode (6);
		
		System.out.println ( isBinarySearchTree ( t ));
	}

}
