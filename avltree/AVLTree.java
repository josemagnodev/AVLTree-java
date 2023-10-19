package avltree;

public class AVLTree {

        public Node root;

        // A utility function to get the height of the tree
        int height(Node N) {
            if (N == null)
                return 0;

            return N.height;
        }

        // A utility function to get maximum of two integers
        public int max(int a, int b) {
            return (a > b) ? a : b;
        }

        // A utility function to nodeRight rotate subtree rooted with y
        // See the diagram given above.
        public Node rightRotate(Node y) {
            Node x = y.nodeLeft;
            Node T2 = x.nodeRight;

            // Perform rotation
            x.nodeRight = y;
            y.nodeLeft = T2;

            // Update heights
            y.height = max(height(y.nodeLeft), height(y.nodeRight)) + 1;
            x.height = max(height(x.nodeLeft), height(x.nodeRight)) + 1;

            // Return new root
            return x;
        }

        // A utility function to nodeLeft rotate subtree rooted with x
        // See the diagram given above.
        public Node leftRotate(Node x) {
            Node y = x.nodeRight;
            Node T2 = y.nodeLeft;

            // Perform rotation
            y.nodeLeft = x;
            x.nodeRight = T2;

            // Update heights
            x.height = max(height(x.nodeLeft), height(x.nodeRight)) + 1;
            y.height = max(height(y.nodeLeft), height(y.nodeRight)) + 1;

            // Return new root
            return y;
        }

        // Get Balance factor of node N
        public int getBalance(Node N) {
            if (N == null)
                return 0;

            return height(N.nodeLeft) - height(N.nodeRight);
        }

        public Node insert(Node node, int value) {

            /* 1. Perform the normal BST insertion */
            if (node == null)
                return (new Node(value));

            if (value < node.value)
                node.nodeLeft = insert(node.nodeLeft, value);
            else if (value > node.value)
                node.nodeRight = insert(node.nodeRight, value);
            else // Duplicate keys not allowed
                return node;

            /* 2. Update height of this ancestor node */
            node.height = 1 + max(height(node.nodeLeft),
                    height(node.nodeRight));

            /*
             * 3. Get the balance factor of this ancestor
             * node to check whether this node became
             * unbalanced
             */
            int balance = getBalance(node);

            // If this node becomes unbalanced, then there
            // are 4 cases Left Left Case
            if (balance > 1 && value < node.nodeLeft.value)
                return rightRotate(node);

            // Right Right Case
            if (balance < -1 && value > node.nodeRight.value)
                return leftRotate(node);

            // Left Right Case
            if (balance > 1 && value > node.nodeLeft.value) {
                node.nodeLeft = leftRotate(node.nodeLeft);
                return rightRotate(node);
            }

            // Right Left Case
            if (balance < -1 && value < node.nodeRight.value) {
                node.nodeRight = rightRotate(node.nodeRight);
                return leftRotate(node);
            }

            /* return the (unchanged) node pointer */
            return node;
        }

        // A utility function to print preorder traversal
        // of the tree.
        // The function also prints height of every node
        public void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.value + " ");
                preOrder(node.nodeLeft);
                preOrder(node.nodeRight);
            }
        }
        public void inOrder(Node node){
            if (node != null) {
                preOrder(node.nodeLeft);
                System.out.print(node.value + " ");
                preOrder(node.nodeRight);
            } 
        }

    }