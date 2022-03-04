import java.util.List;
import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<T>, V extends T> {

    private class BinaryNode{

        public final T key;

        public final V value;

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

        test.preorderPrint(test.root);;

    }

    public BinarySearchTree(){

    }

    public String preorderPrint(BinaryNode root, StringBuilder sb) {
        if (root != null) {
            BinaryNode parent = this.root;
            sb.append(root.key + " ");
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
        while(root != null) {
            if (key.compareTo(root.key) == 0) {
                return root.value;
            } else if (key.compareTo(root.key) > 0) {
                root = root.right;
            } else if (key.compareTo(root.key) < 0) {
                root = root.left;
            }
        }
        throw new NoSuchElementException();
    }

    public void delete(T key){

    }

    public List<V> inorderRec(){
        return null;
    }

    public V kthSmallest(int k){
        return null;
    }

}
