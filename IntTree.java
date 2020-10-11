// Simple binary tree class that includes methods to construct a
// tree of ints, to print the structure, and to print the data
// using a preorder, inorder or postorder traversal.  The trees
// built have nodes numbered starting with 1 and numbered
// sequentially level by level with no gaps in the tree.  The
// documentation refers to these as "sequential trees."


import java.util.*;

public class IntTree {
    private IntTreeNode overallRoot;

    // pre : max > 0
    // post: constructs a sequential tree with given number of
    //       nodes
    public IntTree(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }

    public IntTree(IntTreeNode node) 
    {
    	this.overallRoot = node;
    }
    
    // post: returns a sequential tree with n as its root unless
    //       n is greater than max, in which case it returns an
    //       empty tree
    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max),
                                   buildTree(2 * n + 1, max));
        }
    }

    // post: prints the tree contents using a preorder traversal
    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }

    // post: prints the tree contents using a preorder traversal
    // post: prints in preorder the tree with given root
    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // post: prints the tree contents using a inorder traversal
    public void printInorder() {
        System.out.print("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(" " + root.data);
            printInorder(root.right);
        }
    }

    // post: prints the tree contents using a postorder traversal
    public void printPostorder() {
        System.out.print("postorder:");
        printPostorder(overallRoot);
        System.out.println();
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(IntTreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }
    
    public int matches(IntTree other) {
        return matches(overallRoot, other.overallRoot);
    }
    
    private int matches(IntTreeNode myRoot, IntTreeNode otherRoot) {
        if (myRoot == null || otherRoot == null) {
            return 0;
        } else if (myRoot.data == otherRoot.data) {
            return 1 + matches(myRoot.left, otherRoot.left)
                     + matches(myRoot.right, otherRoot.right);
        } else {
            return matches(myRoot.left, otherRoot.left)
                 + matches(myRoot.right, otherRoot.right);
        }
    }
    
    public void printValsAtLevels(IntTreeNode root, int level) 
    {
    	if(null == root) 
    	{
    		return;
    	}
    	System.out.println(String.format("Val : %d, Level : %d", root.data, level));
    	printValsAtLevels(root.left, level+1); 
    	printValsAtLevels(root.right, level+1);
    }
    
    public void printValsAtLevels() 
    {
    	printValsAtLevels(this.overallRoot, 1);
    }
    
    /**
     * @author Ice Lin
     * @param root Root node of the tree to operate on 
     * @return the number of left children in the tree
     */
    public static int countLeftNodes(IntTreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	int count = 0;
    	if(root.left != null) {
    		count = 1;
    	}
    	return count + countLeftNodes(root.left) + countLeftNodes(root.right);
    }
    
    /**
     * @author Ice Lin
     * @return the number of left children in the tree
     */
    public int testCountLeftNodes() {
    	return countLeftNodes(this.overallRoot);
    }
    
    /**
     * @author Ice Lin
     * @param root Root node of the tree 
     * @return true is tree is empty, false if it is not empty
     */
    public boolean isEmpty() {
    	if(overallRoot == null) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    /**
     * @author Ice Lin
     * @param root Root node of the tree to operate on 
     * @return the number of empty branches in the tree
     */
    public static int countEmpty(IntTreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	if(root.isLeaf()) {
    		return 2;
    	}
    	else {
    		if(root.left == null || root.right == null) {
    			return 1 + countEmpty(root.left) + countEmpty(root.right);
    		}
    		else {
    			return countEmpty(root.left) + countEmpty(root.right);
    		}
    	}
    }
    
    /**
     * @author Ice Lin
     * @return the number of empty branches in the tree
     */
    public int testCountEmpty() {
    	if (this.isEmpty() == true) {
    		return 1;
    	}
    	else {
    		return countEmpty(this.overallRoot);
    	}
    }

    /**
     * @author Brendan Morgenstern
     * @param root Root node of the tree to operate on 
     * @param depth The current depth of the tree in the call
     * @return Returns the sum of the data at each node multiplied by the depth
     */
    public int depthSum(IntTreeNode root, int depth) 
    {
    	if(null == root) 
    	{
    		return 0;
    	}
    	int sum = root.data * depth;
    	
    	sum += depthSum(root.left, depth+1); 
    	sum += depthSum(root.right, depth+1);
    	
    	return sum;
    }
    
    
    /**
     * @author Brendan Morgenstern
     * @return Returns the sum of the data at every node in the tree multiplied by the depth
     */
    public int depthSum() 
    {
    	return depthSum(this.overallRoot, 1);
    }
    
    /**
     * @author Brendan Morgenstern
     * @param root Root node of the tree to operate on 
     * @param counter The current counted number of branches in the call
     * @return Returns the number of non-leaf nodes that have even data
     */
    public int countEvenBranches(IntTreeNode root, int counter) 
    {
    	if (null == root) 
    	{
    		return counter;
    	}
    	if( ( !root.isLeaf() ) && ( root.data % 2 == 0) ) 
    	{
    		counter++;
    	}
    	counter = countEvenBranches(root.left,  counter);
    	counter = countEvenBranches(root.right,  counter);
    	
    	return counter;
    }
    
    /**
     * @author Brendan Morgenstern
     * @return Returns the number of non-leaf nodes in the tree that have even data
     */
    public int countEvenBranches() 
    {
    	return countEvenBranches(this.overallRoot, 0);
    }
    
    
}
