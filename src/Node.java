public class Node{
    int value;
    Node leftChild;
    Node rightChild;

    public Node(){

    }

    public Node(int value){
        this.value = value;
    }

    public Node(int value, Node left, Node right){
        this.value = value;
        this.leftChild = left;
        this.rightChild = right;
    }
}