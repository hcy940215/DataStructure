package com.company;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.Stack;

public class BinarayTree {
    Node<String> root;

    public Node<String> getRoot() {
        return root;
    }

    public BinarayTree(String root) {
        this.root = new Node<String>(null, root, null);
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(" " + root.data);

        preOrder(root.left);
        preOrder(root.right);

    }

    public void minOrder(Node root) {
        if (root == null) {
            return;
        }
        minOrder(root.left);
        System.out.print(" " + root.data);
        minOrder(root.right);

    }

    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(" " + root.data);
    }

    /**
     * 前序遍历  Stack方式
     *
     * @param root *************A
     *             *********B*******C
     *             *****D******E********F
     */
    public void preOrderStack(Node root) {
        if (root == null) {
            return;
        } else {
            Stack<Node<String>> stack = new Stack<>();
            stack.push(root);
            System.out.print("非递归前序遍历方式：");
            while (!stack.isEmpty()) {
                Node<String> currentNode = stack.pop();
                System.out.print(" "+currentNode.data);
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                }
            }
            System.out.println("");
        }

    }


    /**
     * 中序遍历  Stack方式
     *
     * @param root
     *     /**
     **************A
     ***********//***\\
     **********B*******C
     *******//***\\*****\\
     ******D******E*******F
     ******\\****//*******
     *******G***I**********
     ******//***************
     ****H****************
     */
    /**
     * ****H*****
     */

    public void minOrderStack(Node root) {
        if (root == null) {
            return;
        } else {
            Stack<Node<String>> stack = new Stack<>();
            stack.push(root);

            //依次将左孩子入栈
            Node<String> currentNode = root;
            while (currentNode.left != null) {
                stack.push(currentNode.left);
                currentNode = currentNode.left;
            }
            System.out.print("非递归中序遍历方式：");
            while (!stack.isEmpty()) {
                Node<String> nodePop = stack.pop();
                System.out.print(" "+nodePop.data);

                //如果有右孩子  将右孩子视为根节点 将根节点入栈，再依次将左孩子入栈
                if (nodePop.right != null) {
                    currentNode = nodePop.right;
                    stack.push(currentNode);

                    currentNode = currentNode.left;
                    while (currentNode != null) {
                        stack.push(currentNode);
                        currentNode = currentNode.left;
                    }
                }

            }
            System.out.println("");
        }
    }

    public void postOrderStack(Node root) {
        if (root == null) {
            return;
        } else {
            Stack<Node<String>> stack = new Stack<>();
            //逆后序 使用的栈
            Stack<Node<String>> reverse = new Stack<>();

            stack.push(root);
            while (!stack.isEmpty()) {
                Node<String> currentNode = stack.pop();
                reverse.push(currentNode);
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                }
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
            }
            System.out.print("非递归后序遍历方式：");
            while (!reverse.isEmpty()){
                System.out.print(" "+reverse.pop().data);
            }

        }
    }

    /**
     **************A
     ***********//***\\
     **********B*******C
     *******//***\\*****\\
     ******D******E*******F
     ******\\****//*******
     *******G***I**********
     *****//****************
     ****H****************
     */
    /**
     * ***H*****
     */

    public void createTree() {
        Node<String> nodeB = new Node<String>(null, "B", null);
        Node<String> nodeC = new Node<String>(null, "C", null);
        Node<String> nodeD = new Node<String>(null, "D", null);
        Node<String> nodeE = new Node<String>(null, "E", null);
        Node<String> nodeF = new Node<String>(null, "F", null);
        Node<String> nodeG = new Node<String>(null, "G", null);
        Node<String> nodeH = new Node<String>(null, "H", null);
        Node<String> nodeI = new Node<String>(null, "I", null);


        root.left = nodeB;
        root.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeC.right = nodeF;
        nodeD.right = nodeG;
        nodeG.left = nodeH;
        nodeE.left = nodeI;

    }

    public class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(Node<T> left, T data, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
