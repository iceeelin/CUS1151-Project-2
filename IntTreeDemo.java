// Short program that demonstrates the use of the IntTree class.
public class IntTreeDemo {
    public static void main(String[] args) {
        IntTree t = new IntTree(12);
        System.out.println("Tree structure:"); 
        t.printSideways(); 
        System.out.println(); 
        t.printPreorder();
        t.printInorder(); 
        t.printPostorder();
        
        System.out.println();  System.out.println();  System.out.println();
        
        t.printValsAtLevels();
        
        System.out.println();  System.out.println();
        
        /*Test Depth Sum*/
        testDepthSum();
        /*Test Count Branches*/
        testCountBranches();
        /*Test Count Odd Children*/
        testOddChildren();

    }
    /**
     * Tests the depthSum method using a reference tree 
     * with a known correct solution
     */
    public static void testDepthSum() 
    {
    	IntTreeNode oneNode = new IntTreeNode(1);
        IntTreeNode twoNode = new IntTreeNode(2);
        IntTreeNode threeNode = new IntTreeNode(3);
        IntTreeNode fourNode = new IntTreeNode(4);
        IntTreeNode fiveNode = new IntTreeNode(5);
        IntTreeNode sixNode = new IntTreeNode(6);
        
        
        
        fiveNode.left = oneNode;
        threeNode.left = fiveNode;
        threeNode.right = twoNode;
        twoNode.left = fourNode;
        twoNode.right = sixNode;
        
        IntTree t = new IntTree(threeNode);
        
        System.out.println("Depth Sum of Reference Tree 1: " + t.depthSum());
    }
    
    /**
     * Tests the countBranches method using a reference tree 
     * with a known correct solution
     */
    public static void testCountBranches() 
    {

        
        IntTreeNode n2 = new IntTreeNode(2);
        IntTreeNode n8 = new IntTreeNode(8);
        IntTreeNode n1 = new IntTreeNode(1);
        IntTreeNode n0 = new IntTreeNode(0);
        IntTreeNode n7 = new IntTreeNode(7);
        IntTreeNode n6 = new IntTreeNode(6);
        IntTreeNode n4 = new IntTreeNode(4);
        IntTreeNode n9 = new IntTreeNode(9);
        
        
        n6.right = n9;
        n7.left = n4;
        n1.left = n7; n1.right = n6;
        n8.left = n0;
        n2.left = n8; n2.right = n1;
        
        IntTree t = new IntTree(n2);
        System.out.println("Count Even Branches of Reference Tree 2: " + t.countEvenBranches());
    }
    
    public static void testOddChildren() 
    {

        
        IntTreeNode n2 = new IntTreeNode(2);
        IntTreeNode n8 = new IntTreeNode(8);
        IntTreeNode n1 = new IntTreeNode(1);
        IntTreeNode n0 = new IntTreeNode(0);
        IntTreeNode n7 = new IntTreeNode(7);
        IntTreeNode n6 = new IntTreeNode(6);
        IntTreeNode n4 = new IntTreeNode(4);
        IntTreeNode n9 = new IntTreeNode(9);
        
        
        n6.right = n9;
        n7.left = n4;
        n1.left = n7; n1.right = n6;
        n8.left = n0;
        n2.left = n8; n2.right = n1;
        
        
        IntTreeNode oneNode = new IntTreeNode(1);
        IntTreeNode twoNode = new IntTreeNode(2);
        IntTreeNode threeNode = new IntTreeNode(3);
        IntTreeNode fourNode = new IntTreeNode(4);
        IntTreeNode fiveNode = new IntTreeNode(5);
        IntTreeNode sixNode = new IntTreeNode(6);
        
        
        
        fiveNode.left = oneNode;
        threeNode.left = fiveNode;
        threeNode.right = twoNode;
        twoNode.left = fourNode;
        twoNode.right = sixNode;
        
        IntTree t1 = new IntTree(threeNode);
        
        IntTree t2 = new IntTree(n2);
        System.out.println("Count Odd Children of Reference Tree 1: " + t1.countOddChildren());
        System.out.println("Count Odd Children of Reference Tree 2: " + t2.countOddChildren());
    }
}