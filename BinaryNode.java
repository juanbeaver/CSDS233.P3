public class BinaryNode<T extends Comparable<T>, V extends T> {

    private final T key;

    private final V value;

    private BinaryNode<T, V> left;

    private BinaryNode<T, V> right;

    private BinaryNode<T,V> root;

    public BinaryNode(BinaryNode<T, V> root, T key, V value){
        this.key = key;
        this.value = value;
        this.root = root;
    }

    public BinaryNode getLeftChild(){
        return left;
    }

    public BinaryNode getRightChild(){
        return left;
    }

    public BinaryNode getParent(){
        return root;
    }

    public void setLeftChild(BinaryNode<T, V> left){
        this.left = left;
    }

    public void setRightChild(BinaryNode<T, V> right){
        this.right = right;
    }

    public T getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }

}
