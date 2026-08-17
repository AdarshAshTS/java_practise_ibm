class BST {

    public static void main(String[] args) {
        BinarySearchTreeNode tree = new BinarySearchTreeNode();

        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);

        System.out.println("Display:");
        tree.display(tree.root);

        int key = 60;

        if (tree.search(tree.root, key)) {
            System.out.println("\n" + key + " found");
        } else {
            System.out.println("\n" + key + " not found");
        }
    }
}

class Node {

    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinarySearchTreeNode {

    Node root;

    Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.print(root.data + " ");
            display(root.right);
        }
    }

    boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }
        if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }
}
