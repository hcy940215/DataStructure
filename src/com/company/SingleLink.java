package com.company;

public class SingleLink<E> {
    private Node<E> first;
    private Node<E> last;
    int size;

    public void add(E e){
        lastAdd(e);
    }
    public void add(int index,E e){
        if (index==0){
            Node<E> eNode = new Node<>(e, first);
            first = eNode;
            size++;
        }else if (index==size){
            lastAdd(e);
        }else {
            Node<E> node = getNode(index);

            Node<E> eNode = new Node<E>(e,node);
            Node<E> preNode = getNode(index - 1);
            preNode.next = eNode;
            size++;
        }
    }
    private void lastAdd(E e) {
        Node<E> node = new Node<>(e, null);
        Node<E> l = this.last;
        last = node;

        if (l == null) {
            first = node;
        } else {
            l.next = node;
        }
        size++;
    }

    public E get(int index){
        if (index < 0 || index > size) {
            return null;
        }
        return getNode(index).item;
    }

    private Node<E> getNode(int index) {
        Node<E> node = this.first;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public void remove(int index){
        //三种情况 1.在头部删除 2.在中间删除 3.在尾部删除
        if (index==0){
            first = getNode(index).next;
        }else if(index==size){
            Node<E> node = getNode(index - 1);
            last = node;
            node.next=null;
        }else {
            Node<E> node = getNode(index - 1);
            node.next = getNode(index).next;
        }
        size--;
    }

    public void set(int index,E e){
        getNode(index).item = e;
    }
    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
