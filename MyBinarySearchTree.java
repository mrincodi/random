package juguemos;

public class MyBinarySearchTree {

	MyBinarySearchTreeNode root;
	
	public MyBinarySearchTree ( int value ){
	root = new MyBinarySearchTreeNode(value);
	}
	
	public MyBinarySearchTree ( MyBinarySearchTreeNode root ){
		this.root = root;
	}
	
	public void insert ( int value ){
		this.root.insert(value);
	}
	
	public void breadthFirstSearchPrint ( ){

		if ( root == null ){
			return ;
		}
		
		java.util.Queue<MyBinarySearchTreeNode> q = new java.util.LinkedList < MyBinarySearchTreeNode > ();
		
		q.clear();
		q.add(root);
		
		while ( !q.isEmpty() ){
			MyBinarySearchTreeNode node = q.remove();
			System.out.print ( node.value + " ");
			if ( node.left  != null ) q.add ( node.left  );
			if ( node.right != null ) q.add ( node.right );
			
		}
		
	}
	
	
	public void depthFirstSearchPrint ( ){

		if ( root == null ){
			return ;
		}
		
		java.util.Stack<MyBinarySearchTreeNode> s = new java.util.Stack < MyBinarySearchTreeNode > ();
		
		s.push(root);
		
		while ( !s.isEmpty() ){
			
			MyBinarySearchTreeNode node = s.pop();
			System.out.print (node.value + " ");
			
			if (node.right != null) s.push(node.right);
			if (node.left != null) s.push(node.left);
			
		}		
	}
	
	public static void main(String[] args) {
		MyBinarySearchTree mbst = new MyBinarySearchTree ( 56 );
		
		mbst.insert ( 40 );
		mbst.insert ( 4 );
		mbst.insert ( 17 );
		mbst.insert ( 170);
		mbst.insert ( 701 );
		mbst.insert ( 50 );
		mbst.insert ( 41 );
		mbst.insert ( 43 );
		mbst.insert ( 42 );
				
		mbst.depthFirstSearchPrint();
		System.out.println ();
		mbst.breadthFirstSearchPrint();
		
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Still pretty much TODO. Dismiss this!!
	 * 
	 * @param value
	 */
	public void delete ( int value ){

			/*
			 * This is very difficult!!
			 * There must be an easier way to make it.
			 */
		
		//Let's start by finding out if the root is that value 
		if ( root.value == value ){
			
			if ( root.left == null && root.right == null ){
				this.root = null;
			}
			else if ( root.left != null && root.right == null ){
				this.root = this.root.left;
			}
			else if ( root.left == null && root.right != null ){
				this.root = this.root.right;
			}
			else {
				//Find parent to immediate predecessor of the value.
				MyBinarySearchTreeNode pointer = this.root.findParentToCurrentNodesPredecessor ();
				
				if ( pointer == this.root ){
					//This means that the node at the left is the predecessor. Hence, it will not have a pointer to the right.
					this.root.value = this.root.left.value;
					this.root.left = this.root.left.left;
				}
				else {
					//We do have a pointer to the parent of the predecessor.
					MyBinarySearchTreeNode predecessor = pointer.right;
					this.root.value = predecessor.value;
					if (predecessor.left == null ){
						pointer.right = null;	//Remove predecessor.
					}
					else if ( predecessor.left != null ){
						pointer.right = predecessor.left;
					}
				}
			}
		}
		else {
			boolean fixed = true;
			MyBinarySearchTreeNode parentToNode = this.root.findParentToNodeWithValue ( value );
			MyBinarySearchTreeNode node;

			if ( value < parentToNode.value ){
				node = parentToNode.left;
				if ( node.left == null && node.right == null ){
					parentToNode.left = null;
				}
				else if ( node.left != null && node.right == null ){
					parentToNode.left = parentToNode.left.left;
				}
				else if ( node.left == null && node.right != null ){
					parentToNode.left = parentToNode.left.right;
				}
				else {
					fixed = false;
				}
			}
			else {
				node = parentToNode.right;
				if ( node.left == null && node.right == null ){
					parentToNode.right = null;
				}
				else if ( node.left != null && node.right == null ){
					parentToNode.right = parentToNode.right.left;
				}
				else if ( node.left == null && node.right != null ){
					parentToNode.right = parentToNode.right.right;
				}
				else {
					fixed = false;
				}

			}
			
			
			if ( node.left == null && node.right == null ){
				this.root = null;
			}
			else if ( root.left != null && root.right == null ){
				this.root = this.root.left;
			}
			else if ( root.left == null && root.right != null ){
				this.root = this.root.right;
			}
			
			
		
			MyBinarySearchTreeNode pointer = node.findParentToCurrentNodesPredecessor ();
		
			if ( pointer == node ){
				//This means that the node at the left is the predecessor. Hence, it will not have a pointer to the right.
				node.value = node.left.value;
				node.left = node.left.left;
			}
			else {
				//We do have a pointer to the parent of the predecessor.
				MyBinarySearchTreeNode predecessor = pointer.right;
				node.value = predecessor.value;
				if (predecessor.left == null ){
					pointer.right = null;	//Remove predecessor.
				}
				else if ( predecessor.left != null ){
					pointer.right = predecessor.left;
				}
			}
		}

	
	}
	


}
