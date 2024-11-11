package com.verbs.testenglish.Controller;

import java.util.Scanner;

public class binarytreetest {
    class Node {
        int value;       // Value stored in the node
        Node left;       // Reference to left child
        Node right;      // Reference to right child

        // Constructor to create a new node
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // BinarySearchTree class: Manages the tree operations
    class BinarySearchTree {
        Node root;      // Root node of the tree

        // Constructor to initialize an empty tree
        public BinarySearchTree() {
            root = null;
        }

        // Public method to insert a value into the tree
        public void insert(int value) {
            root = insertRec(root, value);
        }

        // Recursive helper method to insert a value
        private Node insertRec(Node root, int value) {
            // If tree is empty or we've reached a leaf node
            if (root == null) {
                root = new Node(value);
                return root;
            }

            // Recursively traverse the tree
            if (value < root.value) {
                root.left = insertRec(root.left, value);
            } else if (value > root.value) {
                root.right = insertRec(root.right, value);
            }

            return root;
        }

        // Method to perform an inorder traversal
        public void inorderTraversal() {
            System.out.println("\nInorder Traversal (Left-Root-Right):");
            inorderRec(root);
            System.out.println();
        }

        // Recursive helper method for inorder traversal
        private void inorderRec(Node root) {
            if (root != null) {
                inorderRec(root.left);
                System.out.print(root.value + " ");
                inorderRec(root.right);
            }
        }

        // Method to perform a preorder traversal
        public void preorderTraversal() {
            System.out.println("\nPreorder Traversal (Root-Left-Right):");
            preorderRec(root);
            System.out.println();
        }

        // Recursive helper method for preorder traversal
        private void preorderRec(Node root) {
            if (root != null) {
                System.out.print(root.value + " ");
                preorderRec(root.left);
                preorderRec(root.right);
            }
        }

        // Method to perform a postorder traversal
        public void postorderTraversal() {
            System.out.println("\nPostorder Traversal (Left-Right-Root):");
            postorderRec(root);
            System.out.println();
        }

        // Recursive helper method for postorder traversal
        private void postorderRec(Node root) {
            if (root != null) {
                postorderRec(root.left);
                postorderRec(root.right);
                System.out.print(root.value + " ");
            }
        }

        // Method to search for a value in the tree
        public boolean search(int value) {
            return searchRec(root, value);
        }

        // Recursive helper method for searching
        private boolean searchRec(Node root, int value) {
            // Base cases: root is null or value is at root
            if (root == null || root.value == value) {
                return root != null;
            }

            // Value is greater than root's value
            if (value > root.value) {
                return searchRec(root.right, value);
            }

            // Value is less than root's value
            return searchRec(root.left, value);
        }

        // Method to print the tree structure
        public void printTree() {
            System.out.println("\nTree Structure:");
            printTreeRec(root, "", true);
        }

        // Recursive helper method to print tree structure
        private void printTreeRec(Node root, String prefix, boolean isLeft) {
            if (root != null) {
                System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.value);
                printTreeRec(root.left, prefix + (isLeft ? "│   " : "    "), true);
                printTreeRec(root.right, prefix + (isLeft ? "│   " : "    "), false);
            }
        }

        // Method to find minimum value in the tree
        public int findMin() {
            if (root == null) {
                throw new IllegalStateException("Tree is empty");
            }
            Node current = root;
            while (current.left != null) {
                current = current.left;
            }
            return current.value;
        }

        // Method to find maximum value in the tree
        public int findMax() {
            if (root == null) {
                throw new IllegalStateException("Tree is empty");
            }
            Node current = root;
            while (current.right != null) {
                current = current.right;
            }
            return current.value;
        }
    }
    /*
    // Main class to test the Binary Search Tree
    public class Main {
        public static void main(String[] args) {
            BinarySearchTree bst = new BinarySearchTree();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nBinary Search Tree Operations:");
                System.out.println("1. Insert a value");
                System.out.println("2. Search for a value");
                System.out.println("3. Print tree structure");
                System.out.println("4. Print traversals");
                System.out.println("5. Find min and max values");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter value to insert: ");
                        int value = scanner.nextInt();
                        bst.insert(value);
                        System.out.println("Value inserted successfully!");
                        break;

                    case 2:
                        System.out.print("Enter value to search: ");
                        value = scanner.nextInt();
                        if (bst.search(value)) {
                            System.out.println("Value " + value + " found in the tree!");
                        } else {
                            System.out.println("Value " + value + " not found in the tree.");
                        }
                        break;

                    case 3:
                        bst.printTree();
                        break;

                    case 4:
                        bst.inorderTraversal();
                        bst.preorderTraversal();
                        bst.postorderTraversal();
                        break;

                    case 5:
                        try {
                            System.out.println("Minimum value: " + bst.findMin());
                            System.out.println("Maximum value: " + bst.findMax());
                        } catch (IllegalStateException e) {
                            System.out.println("Tree is empty!");
                        }
                        break;

                    case 6:
                        System.out.println("Exiting program...");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        }
    }*/

}
