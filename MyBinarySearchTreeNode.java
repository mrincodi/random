package juguemos;

import java.util.LinkedList;

import javax.swing.tree.TreeNode;

public class MyBinarySearchTreeNode {

	int value;
	MyBinarySearchTreeNode left;
	MyBinarySearchTreeNode right;

	public MyBinarySearchTreeNode ( int root ){
		this.value = root;
		left = null;
		right = null;
	}

	public void insert ( int value ){

		if ( value == this.value ){
			return;	// Value is already there.
		}

		MyBinarySearchTreeNode nextTree = new MyBinarySearchTreeNode ( value );
		
		if ( value < this.value ){
			if ( this.left == null ){
				this.left = nextTree;
			}
			else {
				this.left.insert ( value );
			}
		}
		else {
			if ( this.right == null ){
				this.right = nextTree;
			}
			else {
				this.right.insert ( value );
			}
		}
	}
	
	public MyBinarySearchTreeNode findParentToCurrentNodesPredecessor ( ){
		
		//Go to the left once, then go to the right.
		
		if ( this.left == null ){
			return null;	//There is no predecessor.
		}
		
		MyBinarySearchTreeNode pointer = this.left;
		
		if ( pointer.right == null ){
			return this; // I am the pointer to my predecessor.
			
		}
		else {
			while ( pointer.right.right != null ){
				pointer = pointer.right;
			}
			return pointer;
		}
		
	}
	
	public MyBinarySearchTreeNode findParentToNodeWithValue ( int value ){
		if ( this.value == value ){
			return null;
		}
		else {
			if ( value < this.value ){
				if ( this.left == null ) {
					return null;
				}
				else if ( this.left.value == value ){
					return this;
				}
				else {
					return this.left.findParentToNodeWithValue( value );
				}				
			}
			else {
				if ( this.right == null ) {
					return null;
				}
				else if ( this.right.value == value ){
					return this;
				}
				else {
					return this.right.findParentToNodeWithValue( value );
				}				
			}


		}
	}
	
	//MR: TODO (or To remove
	public void delete ( int value ){
		MyBinarySearchTreeNode mbst = this.getTree(value);
		
		//this = null;
		
	}

	public void inOrder ( ){
		if ( this.left != null ){
			this.left.inOrder ();
		}
		System.out.print ( this.value + " ");
		if ( this.right != null ){
			this.right.inOrder ();
		}
	}
	
	public void preOrder () {
		System.out.print ( this.value + " ");
		if ( this.left != null ){
			this.left.preOrder ();
		}
		if ( this.right != null ){
			this.right.preOrder ();
		}
	}

	public void postOrder () {
		if ( this.left != null ){
			this.left.postOrder ();
		}
		if ( this.right != null ){
			this.right.postOrder ();
		}
		System.out.print ( this.value + " ");

	}
	
	public MyBinarySearchTreeNode getTree ( int value ) {
		//Return a sub-tree whose root has that value, or null if it doesn't exist.
		if ( this.value == value ){
			return this;
		}
		
		if ( value < this.value ){
			if ( this.left == null ){
				return null;
			}
			else {
				return this.left.getTree(value);
			}
		}

		if ( this.right == null ){
			return null;
		}
		else {
			return this.left.getTree(value);
		}
	}
	
	public static boolean isBalanced ( MyBinarySearchTreeNode t ) {
		
		if ( t == null ) return true;

		int diff = Math.abs ( height ( t.left ) - height ( t.right ) );
		
		if ( diff <= 1 )
			return ( isBalanced ( t.left ) && isBalanced ( t.right) );
		else 
			return false;
	}

	public static int height ( MyBinarySearchTreeNode t ){
		
		if ( t == null ) return 0;
		
		else {
			return 1 + Math.max ( height ( t.left ), height ( t.right ) );
		}
	}
	
	
	public static MyBinarySearchTreeNode makeTree ( java.util.ArrayList < Integer > orderedArray ){

		
		if (orderedArray.size() == 0 ) return null;
		
		int size = orderedArray.size();

		int middleValue = orderedArray.get(size/2);

		MyBinarySearchTreeNode newTreeNode = new MyBinarySearchTreeNode ( middleValue );
		
		newTreeNode.left = makeTree ( new java.util.ArrayList < Integer >  ( orderedArray.subList(0, size/2 )));
		
		newTreeNode.right = makeTree ( new java.util.ArrayList < Integer >  ( orderedArray.subList ( size/2 + 1, size ) ) );
		
		return newTreeNode;
	}

	public static java.util.LinkedList < Object > linkedListForDepth ( MyBinarySearchTreeNode t, int depth ){
		if (depth <= 0 ) return null; //Or throw exception.

		java.util.LinkedList < Object> result = new java.util.LinkedList < Object > ();
		
		if ( t == null ) { return result; }

		if (depth == 1 ) {
			result.add ( t.value );
		}
		else {
			result = linkedListForDepth (t.left, depth - 1 );
			result.addAll ( linkedListForDepth (t.right, depth -1 ) );
		}

		return result;		
	}
	
	public static boolean isABinarySearchTree ( MyBinarySearchTreeNode t ){
		
		return isABinarySearchTree ( t, Integer.MIN_VALUE, Integer.MAX_VALUE );

		//Wrong!!
//		if ( t == null ) return true;
//
//		if ( t.left != null && t.value < t.left.value ) return false;
//		if ( t.right != null && t.value > t.right.value ) return false;
//		
//		return ( isABinarySearchTree (t.left ) && isABinarySearchTree (t.right  ));
		

	}
	
	public static boolean isABinarySearchTree ( MyBinarySearchTreeNode t, int min, int max ){
		
		if ( t == null ) return true;

		if ( t.value < min || t.value > max ) return false;

		if ( t.left != null && t.value < t.left.value ) return false;
		if ( t.right != null && t.value > t.right.value ) return false;
		
		return ( isABinarySearchTree (t.left, min, t.value ) && isABinarySearchTree (t.right, t.value, max  ));

	}
	
	public static MyBinarySearchTreeNode commonAncestor ( MyBinarySearchTreeNode n, int a, int b ) {
		System.out.println ("--> " + n.value);
		if ( n == null ) return null;

		if ( isNodeInTree ( n.left, a ) && isNodeInTree (n.right, b) ||
		     isNodeInTree ( n.left, b ) && isNodeInTree (n.right, a))
			return n;
		else {
			MyBinarySearchTreeNode result = commonAncestor ( n.left, a, b );
			if ( result != null ) return result;
			else return commonAncestor ( n.right, a, b );
		}

	}

	public static boolean isNodeInTree ( MyBinarySearchTreeNode n, int a ){
		if ( n == null ) return false;
		if ( n.value == a ) return true;
		return ( isNodeInTree ( n.left, a ) || isNodeInTree ( n.right, a ) );
	}
	
	
	public static void main ( String [] args ){
		MyBinarySearchTreeNode mbst = new MyBinarySearchTreeNode ( 50 );
				
		mbst.insert ( 25 );
		mbst.insert ( 12 );
		mbst.insert ( 45 );
		mbst.insert ( 75 );
		mbst.insert ( 60 );
		mbst.insert ( 100 );
//		mbst.insert ( 125 );
//		mbst.insert ( 150 );
		
		
//		mbst.insert ( 80 );
//		mbst.insert ( 1 );

		mbst.inOrder();
		System.out.println ();
		mbst.preOrder();
		System.out.println ();
		mbst.postOrder();
		System.out.println ();
	
		System.out.println ( isBalanced(mbst) );

		LinkedList<Object> l = linkedListForDepth ( mbst, 1 );
		
		for ( int j = 0; j < l.size (); j++ ){
			System.out.print ( l.get ( j ) + "-");
		}
		System.out.println ();
		
		java.util.ArrayList<Integer> a = new java.util.ArrayList<Integer> ();
		
		a.add (5);
		a.add (15);
		a.add (25);
		a.add (35);
		a.add (45);
		a.add (55);
		a.add (65);
		a.add (75);
		a.add (85);
		a.add (95);
		a.add (105);
		a.add (115);
		
		mbst =  makeTree ( a );
		mbst.inOrder();
		
		System.out.println ( isBalanced(mbst));
		
		l = linkedListForDepth ( mbst, 4 );
		
		for ( int j = 0; j < l.size (); j++ ){
			System.out.print ( l.get ( j ) + " ");
		}
		System.out.println ();
		System.out.println ( isABinarySearchTree(mbst)); 		
		
		mbst.preOrder();
		
		
//		mbst = new MyBinarySearchTreeNode(100);
//		mbst.left = new MyBinarySearchTreeNode(50);
//		mbst.left.right = new MyBinarySearchTreeNode(101);
//		
//		System.out.println ( isABinarySearchTree(mbst)); 
//		
		
		System.out.println ( commonAncestor ( mbst, 25, 25 ).value );
		System.out.println ("qq");
		
	}



	
	


}
