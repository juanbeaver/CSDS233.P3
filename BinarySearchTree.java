import java.util.List;

public class BinarySearchTree<T extends Comparable<T>, V extends T> {

    private class BinaryNode{

        private final T key;

        private final V value;

        private BinaryNode left = null;

        private BinaryNode right = null;

        public BinaryNode(){
            key = null;
            value = null;
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

    public String preorderPrint(BinaryNode root){
        StringBuilder s2 = new StringBuilder();

        if(root != null){
            BinaryNode parent = this.root;
            s2.append(root.key + " ");
            System.out.print(root.key + " ");

            if(root.left != null){
                preorderPrint(root.left);
            }
            if(root.right != null){
                preorderPrint(root.right);
            }
        }
        return s2.toString();
    }

    public BinarySearchTree(){

    }

    public void insert(T key, V value){

    }

    public V search(T key){
        return null;
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
