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
        treeNode.height = 1 + Math.max(heightOfTree(treeNode.leftChild), heightOfTree(treeNode.rightChild));

        // Check balance of the tree and return if imbalanced
        if (Math.abs(heightOfTree(treeNode.leftChild) - heightOfTree(treeNode.rightChild)) < 2)
            return treeNode;

        if (heightOfTree(treeNode.leftChild) > heightOfTree(treeNode.rightChild)) {
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

    private int heightOfTree(Node node) {
        if (node == null)
            return 0;
        else
            return node.height;
    }

    private Node leftRotate(Node node) {
        return node;
    }

    private Node rightRotate(Node node) {
        return node;
    }

}
