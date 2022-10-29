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
                treeNode.leftChild = insert(treeNode.leftChild, newNode);
        } else {
            if (treeNode.rightChild == null)
                treeNode.rightChild = newNode;
            else
                treeNode.rightChild = insert(treeNode.rightChild, newNode);
        }

        // Update height of the node
        updateHeightOfNode(treeNode);

        // Check balance of the tree and return if imbalanced
        if (Math.abs(heightOfNode(treeNode.leftChild) - heightOfNode(treeNode.rightChild)) < 2)
            return treeNode;

        if (heightOfNode(treeNode.leftChild) > heightOfNode(treeNode.rightChild)) {
            // Left Left
            if (newNode.value < treeNode.leftChild.value) {
                return rightRotate(treeNode);
            } else { // Left Right
                treeNode.leftChild = leftRotate(treeNode.leftChild);
                return rightRotate(treeNode);
            }
        } else {
            // Right Left
            if (newNode.value < treeNode.rightChild.value) {
                treeNode.rightChild = rightRotate(treeNode.rightChild);
                return leftRotate(treeNode);
            } else { // Right Right
                return leftRotate(treeNode);
            }
        }
    }

    private int heightOfNode(Node node) {
        if (node == null)
            return 0;
        else
            return node.height;
    }

    private void updateHeightOfNode(Node node) {
        node.height = 1 + Math.max(heightOfNode(node.leftChild), heightOfNode(node.rightChild));
    }

    private Node leftRotate(Node node) {
        Node x = node;
        Node y = node.rightChild;

        // Rotate
        x.rightChild = y.leftChild;
        y.leftChild = x;

        // Adjust Height
        updateHeightOfNode(x);
        updateHeightOfNode(y);

        return y;
    }

    private Node rightRotate(Node node) {
        Node x = node;
        Node y = node.leftChild;

        // Rotate
        x.leftChild = y.rightChild;
        y.rightChild = x;

        // Adjust Height
        updateHeightOfNode(x);
        updateHeightOfNode(y);

        return y;
    }

}
