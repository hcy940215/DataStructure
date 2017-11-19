package com.company;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(4);
//        list.add(2);
//        list.add(3,10);
//
//        list.remove(2);
//        for (int i = 0; i < list.size; i++) {
//            System.out.println(String.format(Locale.CHINA,"%d : %d",i,list.get(i)));
//        }
//
//
//        SingleLink<Integer> singleLink = new SingleLink<>();
//        singleLink.add(1);
//        singleLink.add(4);
//        singleLink.add(2);
//        singleLink.add(6);
//        singleLink.add(1,10);
//        for (int i = 0; i < singleLink.size; i++) {
//            System.out.println(String.format(Locale.CHINA,"%d : %d",i,singleLink.get(i)));
//        }
//        singleLink.remove(4);
//        singleLink.set(3,15);
//        for (int i = 0; i < singleLink.size; i++) {
//            System.out.println(String.format(Locale.CHINA,"%d : %d",i,singleLink.get(i)));
//        }

        BinarayTree tree = new BinarayTree("A");
        tree.createTree();
        System.out.print("----->递归前序方式：");
        tree.preOrder(tree.getRoot());
        System.out.println("");
        tree.preOrderStack(tree.getRoot());


        System.out.print("----->递归中序方式：");
        tree.minOrder(tree.getRoot());
        System.out.println("");
        tree.minOrderStack(tree.getRoot());


        System.out.print("----->递归后序方式：");
        tree.postOrder(tree.getRoot());
        System.out.println("");
        tree.postOrderStack(tree.getRoot());


        /*************二叉排序树******************/
        BinarySortingTree sortingTree = new BinarySortingTree();
        int arr[] = {45, 12, 8, 20, 1, 15, 0, 6,50,20,18,21,70,60};
        for (int i = 0; i < arr.length; i++) {
            sortingTree.put(arr[i]);
        }


        System.out.println("");
        System.out.print("----->递归中序方式：");
        sortingTree.minOrder(sortingTree.getRoot());

        System.out.println("");
        BinarySortingTree.TreeNode searchNode = sortingTree.get(70);
        System.out.print("要查找的元素:"+(searchNode == null ? null : searchNode.data));

        sortingTree.delect(searchNode);
        System.out.println("");
        System.out.print("----->递归中序方式：");
        sortingTree.minOrder(sortingTree.getRoot());
    }
}
