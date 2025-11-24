package com.infy.unfinished.circulardeque;

class MyCircularDeque {
    private class Node {
        private int val;
        private Node next;
        private Node last;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getLast() {
            return last;
        }

        public void setLast(Node last) {
            this.last = last;
        }

        @Override
        public String toString() {

            String nextString = next == null ? "null" : String.valueOf(next.val);
            String lastString = last == null ? "null" : String.valueOf(last.val);

            return "Node{" +
                    "val=" + val +
                    ", next=" + nextString +
                    ", last=" + lastString +
                    '}';
        }
    }

    private int maxSize;
    private int size;
    private Node head;
    private Node tail;

    public MyCircularDeque(int k) {
        maxSize = k;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (maxSize == size)
            return false;

        Node newNode = new Node(value);

        if (head == null) {
            newNode.setLast(newNode);
            newNode.setNext(newNode);

            head = newNode;
            tail = newNode;
        } else {
            newNode.setLast(head.last);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (maxSize == size)
            return false;

        Node newNode = new Node(value);

        if (head == null) {
            newNode.setLast(newNode);
            newNode.setNext(newNode);

            head = newNode;
            tail = newNode;
        } else {
            newNode.setLast(tail);
            newNode.setNext(tail.getNext());
            tail = newNode;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0)
            return false;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node newHead = head.getNext();
            newHead.setLast(tail);
            tail.setNext(newHead);
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0)
            return false;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node newTail = tail.getLast();
            newTail.setNext(head);
            head.setLast(newTail);
        }
        size--;
        return true;
    }

    public int getFront() {
        if (size == 0)
            return -1;

        return head.getVal();
    }

    public int getRear() {
        if (size == 0)
            return -1;

        return tail.getVal();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(head.getVal());
        sb.append(", ");
        Node tracker = head.getNext();
        while (tracker != head) {
            sb.append(tracker.val);
            sb.append(", ");
            tracker = tracker.getNext();
        }

        sb.delete(sb.lastIndexOf(","), sb.length());
        sb.append("}");
        return sb.toString();
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
