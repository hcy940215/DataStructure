package com.company;

public class BinarySortingTree {
    public TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void minOrder(BinarySortingTree.TreeNode root) {
        if (root == null) {
            return;
        }
        minOrder(root.leftChild);
        System.out.print(" " + root.data);
        minOrder(root.rightChild);

    }

    /**
     * 插入到排排序二叉树中
     *
     * @param data
     * @return
     */
    public TreeNode put(int data) {
        if (root == null) {
            TreeNode node = new TreeNode(data);
            root = node;
            return node;
        }
        //要插入节点的父节点
        TreeNode parent = null;
        //将待插入节点的数据和 当前节点的数据进行对比
        TreeNode currentNode = this.root;
        while (currentNode != null) {
            parent = currentNode;
            if (data < currentNode.data) {
                currentNode = currentNode.leftChild;
            } else if (data > currentNode.data) {
                currentNode = currentNode.rightChild;
            } else {
                return currentNode;
            }

        }//已经找到带插入节点的父节点

        //创建新节点
        TreeNode newNode = new TreeNode(data);
        newNode.parent = parent;

        if (parent.data > data) {
            parent.leftChild = newNode;
        } else if (parent.data < data) {
            parent.rightChild = newNode;
        }

        return newNode;
    }

    /**
     *查找
     *
     * @param data
     * @return
     */
    public TreeNode get(int data) {
        TreeNode currentNode = this.root;
        while (currentNode != null) {
            if (data < currentNode.data) {
                currentNode = currentNode.leftChild;
            } else if (data > currentNode.data) {
                currentNode = currentNode.rightChild;
            } else {
                return currentNode;
            }
        }
        return null;
    }

    /**
     * 删除一个节点
     */
    public void delect(TreeNode node) {
        if (node == null) {
            throw new NullPointerException("not found node");
        } else {
            TreeNode parent = node.parent;
            //1.没有孩子
            if (node.leftChild == null && node.rightChild == null) {
                //如果父节点==null 说明是树根
                if (parent == null) {
                    root = null;
                } else if (parent.leftChild == node) {
                    parent.leftChild = null;
                } else {
                    parent.rightChild = null;
                }
            } else if (node.leftChild != null && node.rightChild == null) {//只有左孩子
                if (parent == null) {
                    root = node.leftChild;
                } else {
                    if (parent.leftChild == node) {
                        parent.leftChild = node.leftChild;
                    } else {
                        parent.rightChild = node.leftChild;
                    }
                }

            } else if (node.leftChild == null && node.rightChild != null) {//只有右孩子
                if (parent == null) {
                    root = node.rightChild;
                } else {
                    if (parent.leftChild == node) {
                        parent.leftChild = node.rightChild;
                    } else {
                        parent.rightChild = node.rightChild;
                    }
                }

            } else {//有左右孩子
                //1.待删除节点右孩子的左孩子为null,就将待删除节点右孩子替换到 该待删除节点的位置
                if (node.rightChild.leftChild == null) {
                    node.rightChild.leftChild = node.leftChild;
                    if (parent==null){
                       root= node.rightChild;
                    }else {
                        if (node == parent.leftChild) {
                            parent.leftChild = node.rightChild;
                        } else {
                            parent.rightChild = node.rightChild;
                        }
                    }

                } else {
                    //2.待删除节点右孩子的左孩子不为null,就要找到待删除节点右孩子的最左孩子替换到
                    // 该待删除节点的位置，

                    //Leftmost删除节点右孩子的最左孩子
                    TreeNode leftMostNode = node.rightChild;
                    while (leftMostNode.leftChild != null) {
                        leftMostNode = leftMostNode.leftChild;
                    }

                    leftMostNode.leftChild=node.leftChild;
                    //如果找到的最左子树 有右孩子 就要将最左子树的父节点指向 最左子树的右孩子
                    if (leftMostNode.rightChild!=null){
                        leftMostNode.parent.leftChild = leftMostNode.rightChild;
                    }
                    //让最左孩子的右孩子 指向 删除节点的右孩子
                    leftMostNode.rightChild=node.rightChild;


                    //最后将待删除节点父节点的左孩子 指向这个最左孩子
                    if (parent==null){
                        root = leftMostNode;
                    }else {
                        if (parent.leftChild==node){
                            parent.leftChild=leftMostNode;
                        }else {
                            parent.rightChild=leftMostNode;
                        }
                    }

                }
            }
        }

    }

    public class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode parent;

        public TreeNode(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
            this.parent = null;
        }
    }
}
