import java.util.List;

public class AVLTree<T extends Comparable<T>, V extends T>{
    private class BinaryNode{

        public T key;

        public V value;

        public BinaryNode left = null;

        public BinaryNode right = null;

        public BinaryNode parent = null;

        private int balance;

        public BinaryNode(T key, V value){
            this.key = key;
            this.value = value;
        }

        public void rightRotation(BinaryNode node){

        }

        public void leftRotation(BinaryNode node){


        }

        public int balanceAtNode(BinaryNode node){
            return -1;
        }
    }

    public BinaryNode root = null;

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
