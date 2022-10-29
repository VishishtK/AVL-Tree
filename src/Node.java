public class Node {
    int value;
    int height;
    Node leftChild;
    Node rightChild;

    public Node() {

    }

    public Node(int value) {
        this.value = value;
        this.height = 0;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.leftChild = left;
        this.rightChild = right;
    }
}