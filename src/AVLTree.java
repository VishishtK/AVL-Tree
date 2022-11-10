import java.util.List;

public class AVLTree {

    Node root;

    public AVLTree() {
        this.root = null;
    }

    public AVLTree(int key) {
        this.root = new Node(key);
    }

    public void Insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }
        root = insert(root, new Node(key));
    }

    public void Delete(int key) {
        root = delete(root, key);
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

        if (newNode.value < treeNode.value) {
            // Left Left
            if (newNode.value < treeNode.leftChild.value) {
                return rightRotate(treeNode);
            } else { // Left Right
                treeNode.leftChild = leftRotate(treeNode.leftChild);
                return rightRotate(treeNode);
            }
        } else {
            // Right Right
            if (newNode.value > treeNode.rightChild.value) {
                return leftRotate(treeNode);
            } else { // Right Left
                treeNode.rightChild = rightRotate(treeNode.rightChild);
                return leftRotate(treeNode);
            }
        }
    }

    private Node delete(Node node, int key) {
        // If the key to be deleted is not found
        if (node == null) {
            return null;
        }
        // Travel to the node
        if (node.value < key) {
            node.rightChild = delete(node.rightChild, key);
        } else if (node.value > key) {
            node.leftChild = delete(node.leftChild, key);
        } else { // If the key is same then delete this node

            if (DegreeOfNode(node) == 0)
                return null;
            else if (DegreeOfNode(node) == 1) {
                if (node.leftChild == null)
                    node = node.rightChild;
                else
                    node = node.leftChild;
            }else{
                Node predecessor = inOrderPredecessor(node);
                node.value = predecessor.value;
                node.leftChild = delete(node.leftChild, predecessor.value);
            }
        }

         // Update height of the node
        updateHeightOfNode(node);

        // Check balance of the tree and return if imbalanced
        if (Math.abs(heightOfNode(node.leftChild) - heightOfNode(node.rightChild)) < 2)
            return node;

        if (key < node.value) {
            // Left Left
            if (key < node.leftChild.value) {
                return rightRotate(node);
            } else { // Left Right
                node.leftChild = leftRotate(node.leftChild);
                return rightRotate(node);
            }
        } else {
            // Right Right
            if (key > node.rightChild.value) {
                return leftRotate(node);
            } else { // Right Left
                node.rightChild = rightRotate(node.rightChild);
                return leftRotate(node);
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

    private int DegreeOfNode(Node node) {
        if (node.leftChild == null && node.rightChild == null)
            return 0;
        else if (node.leftChild == null || node.rightChild == null)
            return 1;
        else
            return 2;

    }

    private Node inOrderPredecessor(Node node) {
        if (node == null)
            return node;
        node = node.leftChild;
        while (node.rightChild != null) {
            node = node.rightChild;
        }
        return node;
    }

    public void PrintTree() {
        PreOrderPrint(root);
    }

    private void PreOrderPrint(Node node) {
        if (node == null)
            return;
        System.out.println(node.value);
        PreOrderPrint(node.leftChild);
        PreOrderPrint(node.rightChild);
    }

}
