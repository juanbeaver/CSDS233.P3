import org.junit.Test;

import java.lang.management.BufferPoolMXBean;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

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

        //Test if the root is null
        assertThrows(NoSuchElementException.class, () ->  testTree.search(4));

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
        testTree.insert(6,6);

        assertEquals("5 6 ", testTree.preorderPrint(testTree.root));

        //Test when node has two children
        testTree.insert(2,2);   testTree.insert(1,1);   testTree.insert(4,4);

        testTree.delete(2);

        assertEquals("5 4 1 6 ", testTree.preorderPrint(testTree.root));

    }

    @Test
    public void testInorderRec(){
        

    }

    @Test
    public void testKthSmallest(){

    }

}
