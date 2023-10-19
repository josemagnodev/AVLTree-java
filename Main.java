import avltree.*;

public class Main {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
        tree.root = tree.insert(tree.root, 66);
        tree.root = tree.insert(tree.root, 99);
        tree.root = tree.insert(tree.root, 129);

        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.inOrder(tree.root);
    }
}