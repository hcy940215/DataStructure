package com.company;

public class LinkedList<E> {
    Node<E> first;
    Node<E> last;
    int size;


    public LinkedList() {
    }

    /**
     * 增
     * 没有指定index，就是在链表尾部插入
     *
     * @param e
     */
    public void add(E e) {
        linkedLast(e);
    }

    private void linkedLast(E e) {
        //创建节点
        Node<E> node = new Node<E>(last, e, null);
        Node<E> l = this.last;
        last = node;
        //两种情况1.链表为空时,也就是 l=null
        if (l == null) {
            first = node;
        } else {
            l.next = node;
        }
        size++;
    }

    /**
     * 指定位置的添加
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        //三种情况 1.在头部添加 2.在中间添加 3.在尾部添加

        //1.在头部添加
        if (index == 0 || first == null) {
            //创建节点
            Node<E> node = new Node<>(null, e, first);
            first = node;
            size++;
        } else if (index == size) {
            //3.在尾部添加
            linkedLast(e);
        } else {
            //2.在中间添加
            Node<E> target = getNode(index);
            Node<E> pre = target.pre;
            Node<E> newNode = new Node<>(pre, e, target);
            pre.next = newNode;
            //pre = newNode;
            target.pre = newNode;
            size++;
        }
    }

    /**
     * 删除
     *
     * @param index
     */
    public void remove(int index) {
        Node<E> removeNode = getNode(index);
        Node<E> preNode = removeNode.pre;
        Node<E> nextNode = removeNode.next;
        //三种情况 1.在头部删除 2.在中间删除 3.在尾部删除

        if (preNode == null) {
            //1.在头部删除
            first = removeNode.next;
            nextNode.pre = null;
        } else if (nextNode == null) {
            //3.在尾部删除
            last = removeNode.pre;
            preNode.next = null;
        }else {
            //2.在中间删除
            preNode.next = removeNode.next;
            nextNode.pre = removeNode.pre;
        }

        size--;
    }

    /**
     * 查
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return getNode(index).item;
    }

    private Node<E> getNode(int index) {
        //通过遍历找到相应位置的节点
        //可以从前遍历 也可以从后遍历
        if (index < size / 2) {
            //从第一个节点遍历
            Node<E> node = this.first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            //从最后一个遍历
            Node<E> node = this.last;
            for (int i = size - 1; i > index; i--) {
                node = node.pre;
            }
            return node;
        }
    }

    private static class Node<E> {
        E item;
        Node<E> pre;
        Node<E> next;

        public Node(Node<E> pre, E item, Node<E> next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

}
