import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>, V extends T> {

    private class BinaryNode{

        public T key;

        public V value;

        public BinaryNode left = null;

        public BinaryNode right = null;

        public BinaryNode(T key, V value){
            this.key = key;
            this.value = value;
        }

    }

    public BinaryNode root = null;


    public static void main(String[] args){
        BinarySearchTree<Integer, Integer> test = new BinarySearchTree<>();

        test.insert(2, 2);
        test.insert(1, 1);
        test.insert(4, 4);
        test.insert(5, 5);
        test.insert(9, 9);
        test.insert(3, 3);
        test.insert(6, 6);
        test.insert(7, 7);
        test.insert(10, 10);
        test.insert(12, 12);
        test.insert(11, 11);

        test.delete(4);
        test.delete(9);

        System.out.println(test.preorderPrint(test.root));

        System.out.println("The value at key 12 is " + test.search(12) );
        System.out.println("The value at key 4 is " + test.search(4) );

        System.out.println("The third smallest value is " + test.kthSmallest(3) );

        BinarySearchTree<Double, Double> doubleTestTree = new BinarySearchTree<>();
        doubleTestTree.insert(2.0, 2.0);    doubleTestTree.insert(5.0, 5.0);
        doubleTestTree.insert(12.0, 12.0);  doubleTestTree.insert(7.0, 7.0);

        System.out.println("The double value binary search tree: " + doubleTestTree.inorderRec());

        BinarySearchTree<String, String> stringTestTree = new BinarySearchTree<>();
        stringTestTree.insert("2.0", "two");    stringTestTree.insert("5.0", "five");
        stringTestTree.insert("12.0", "twelve");  stringTestTree.insert("7.0", "seven");

        System.out.println("The string value binary search tree: " + stringTestTree.inorderRec());

    }

    public BinarySearchTree(){

    }

    public String preorderPrint(BinaryNode root, StringBuilder sb) {
        if (root != null) {
            sb.append(root.key).append(" ");
            if (root.left != null) {
                preorderPrint(root.left, sb);
            }
            if (root.right != null) {
                preorderPrint(root.right, sb);
            }
        }
        return sb.toString();
    }

    public String preorderPrint(BinaryNode root){
        return preorderPrint(root, new StringBuilder());
    }

    public void insert(T key, V value){
        BinaryNode currRoot = this.root;
        BinaryNode parent = null;

        if(currRoot == null){
            this.root = new BinaryNode(key, value);
            return;
        }

        while(currRoot != null) {
            if (currRoot.key.compareTo(key) > 0) { //key is to the left
                parent = currRoot;
                currRoot = currRoot.left;
            }
            else if(currRoot.key.compareTo(key) <= 0){ //key is to the right
                parent = currRoot;
                currRoot = currRoot.right;
            }
        }

        if(key.compareTo(parent.key) > 0){
            parent.right = new BinaryNode(key, value);
        }
        else{
            parent.left = new BinaryNode(key, value);
        }
    }

    public V search(T key){
        BinaryNode currRoot = root;
        while(currRoot != null) {
            if (key.compareTo(currRoot.key) == 0) {
                return currRoot.value;
            } else if (key.compareTo(currRoot.key) > 0) {
                currRoot = currRoot.right;
            } else if (key.compareTo(currRoot.key) < 0) {
                currRoot = currRoot.left;
            }
        }
        return null;
    }

    public void deleteNode(BinaryNode currRoot, BinaryNode parent){

        //Case 1 & 2 node to be deleted has 1 or 0 children
        if(currRoot.left == null || currRoot.right == null){
            BinaryNode deletedNodeChild;
            if(currRoot.left != null){
                deletedNodeChild = currRoot.left;
            }
            else{
                deletedNodeChild = currRoot.right;
            }

            if(currRoot == root){
                root = deletedNodeChild;
            }
            else if(currRoot.key.compareTo(parent.key) >= 0){
                parent.right = deletedNodeChild;
            }
            else{
                parent.left = deletedNodeChild;
            }
        }

        //Case 3 node to be deleted has 2 children
        else{
            //Find the smallest node of the right subtree of the node to be deleted.
            BinaryNode repParent = currRoot;
            BinaryNode rep = currRoot.right;

            while(rep.left != null){
                repParent = rep;
                rep = rep.left;
            }
            //Set node to be deleted to smallest in right tree
            currRoot.key = rep.key;
            currRoot.value = rep.value;


            //Delete the copied node
            deleteNode(rep, repParent);
        }

    }
    public void delete(T key){
        //Traverse to the node to be deleted, keep parent node saved
        BinaryNode currRoot = root;
        BinaryNode parent = currRoot;

        while(currRoot != null){
            if(key.compareTo(currRoot.key) == 0){
                break;
            }
            else if(key.compareTo(currRoot.key) > 0){
                parent = currRoot;
                currRoot = currRoot.right;
            }
            else{
                parent = currRoot;
                currRoot = currRoot.left;
            }
        }
        if(currRoot != null){
            deleteNode(currRoot, parent);
        }
    }

    public List<V> inorderRec(){
        return inorderRec(root, new LinkedList<>());
    }

    public List<V> inorderRec(BinaryNode root, List<V> list){
        // Left Root Right
        if (root != null) {
            inorderRec(root.left, list);
            list.add(root.value);
            inorderRec(root.right, list);
        }
        return list;

    }

    public V kthSmallest(int k){
        try {
            return kthSmallest(root, new LinkedList<>()).get(k-1);
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public List<V> kthSmallest(BinaryNode currRoot, List<V> list){
        // Left Root Right
            if (currRoot != null) {
                kthSmallest(currRoot.left, list);
                list.add(currRoot.value);
                kthSmallest(currRoot.right, list);
            }
            return list;
    }
}
