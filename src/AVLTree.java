import java.util.List;

public class AVLTree {

    Node root;

    public AVLTree() {
        this.root = new Node();
    }

    public AVLTree(int key) {
        this.root = new Node(key);
    }

    public void Insert(int key) {

    }

    public void Delete(int key) {

    }

    public Node Search(int key) {
        return null;
    }

    public List<Node> Search(int key1, int key2) {
        return null;
    }

    private void insert(Node treeNode, Node newNode) {
        if (newNode.value <= treeNode.value) {
            if (treeNode.leftChild == null)
                treeNode.leftChild = newNode;
            else
                insert(treeNode.leftChild, newNode);
        } else {
            if (treeNode.rightChild == null)
                treeNode.rightChild = newNode;
            else
                insert(treeNode.rightChild, newNode);
        }
    }
}
