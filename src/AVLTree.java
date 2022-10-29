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
        insert(root, new Node(key));

    }

    public void Delete(int key) {

    }

    public Node Search(int key) {
        return null;
    }

    public List<Node> Search(int key1, int key2) {
        return null;
    }

    // Inserts the new Node and returns a node with an imbalance if any
    private Node insert(Node treeNode, Node newNode) {
        // Recursively go down the tree to the leaf and add the node
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

        // Update height of the node
        if (treeNode.leftChild == null && treeNode.rightChild == null)
            treeNode.height = 1;
        else if (treeNode.leftChild == null)
            treeNode.height = 1 + treeNode.rightChild.height;
        else if (treeNode.rightChild == null)
            treeNode.height = 1 + treeNode.leftChild.height;
        else
            treeNode.height = 1 + Math.max(treeNode.leftChild.height, treeNode.rightChild.height);
    }

    private void leftRotate(Node node){

    }

    private void rightRotate(Node node){

    }

}
