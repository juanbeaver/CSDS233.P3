import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BinarySearchTreeTester {

    @Test
    public void testInsert(){
        BinarySearchTree<Integer, Integer> testTree = new BinarySearchTree<>();

        //Test if tree is empty
        testTree.insert(4, 4);

        assertEquals("4 ", testTree.preorderPrint(testTree.root));

        //Test inserting when parent node has no children
        testTree.insert(5, 5);

        assertEquals("4 5 ", testTree.preorderPrint(testTree.root));

        //Test inserting when parent node has one child
        testTree.insert(3,3);

        assertEquals("4 3 5 ", testTree.preorderPrint(testTree.root));
    }

    @Test
    public void testSearch(){
        BinarySearchTree<Integer, Integer> testTree = new BinarySearchTree<>();

        //Test when the node to be found is the root node
        testTree.insert(5,5);
        assertEquals((Integer) 5, testTree.search(5));

        //Test proper tree traversal for all other nodes in the tree
        testTree.insert(12, 12);    testTree.insert(6,6);   testTree.insert(9,9);
        testTree.insert(20,20);

        assertEquals((Integer) 20, testTree.search(20));
    }

    @Test
    public void testDelete(){
        BinarySearchTree<Integer, Integer> testTree = new BinarySearchTree<>();

        //Test when node is the only node in the tree
        testTree.insert(2,2);

        testTree.delete(2);

        assertEquals("", testTree.preorderPrint(testTree.root));

        //Test when node is not found
        testTree.insert(5,5);   testTree.insert(2,2);   testTree.insert(8,8);

        testTree.delete(16);

        assertEquals("5 2 8 ", testTree.preorderPrint(testTree.root));

        //Test when node has no children
        testTree.delete(2);

        assertEquals("5 8 ", testTree.preorderPrint(testTree.root));

        //Test when node has only one child
        testTree.delete(5);

        assertEquals("8 ", testTree.preorderPrint(testTree.root));

        //Test when node has two children
        testTree.insert(2,2);   testTree.insert(1,1);   testTree.insert(4,4);

        testTree.delete(2);

        assertEquals("8 4 1 ", testTree.preorderPrint(testTree.root));

    }

    @Test
    public void testInorderRec(){
        BinarySearchTree<Integer, Integer> testTree = new BinarySearchTree<>();

        //Test when root node is null
        assertEquals("[]", testTree.inorderRec().toString());

        //Test when only one root exists
        testTree.insert(13, 13);

        assertEquals("[13]", testTree.inorderRec().toString());

        //Test many nodes
        testTree.delete(13);

        testTree.insert(6,6); testTree.insert(9,9); testTree.insert(11,11); testTree.insert(2,2);
        testTree.insert(1,1); testTree.insert(5,5); testTree.insert(3,3);   testTree.insert(8,8);

        LinkedList<Integer> list = (LinkedList<Integer>) testTree.inorderRec();

        assertEquals("[1, 2, 3, 5, 6, 8, 9, 11]", list.toString());

    }

    @Test
    public void testKthSmallest(){
        BinarySearchTree<Integer, Integer> testTree = new BinarySearchTree<>();

        //Test when k is bigger than the BST size
        testTree.insert(6,6); testTree.insert(9,9); testTree.insert(11,11); testTree.insert(2,2);
        testTree.insert(1,1); testTree.insert(5,5); testTree.insert(3,3);   testTree.insert(8,8);

        assertNull(testTree.kthSmallest(9));

        //Test when the kth smallest is at an edge
        assertEquals((Integer) 11, testTree.kthSmallest(8));

        //Test when kth smallest in the inside of the tree
        assertEquals((Integer) 3, testTree.kthSmallest(3));
    }

}
