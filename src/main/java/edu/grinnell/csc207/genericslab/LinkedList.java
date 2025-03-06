package edu.grinnell.csc207.genericslab;

/**
 *
 * @author Nahom & Michael
 */
public class LinkedList<T> {

    public class Node<T> {

        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> first;
    private int size;

    /**
     * Constructs a new, empty linked list.
     */
    public LinkedList() {
        this.first = null;
        this.size = 0;
    }

    /**
     * Adds <code>value</code> to the end of the list
     *
     * @param value the value to add to the end of the list
     */
    public void add(T value) {
        if (first == null) {
            first = new Node(value, null);
        } else {
            Node<T> cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(value, null);
        }
        size++;
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        return this.size;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        int origIndex = index;
        Node<T> cur = first;
        while (index > 0 && cur != null) {
            index -= 1;
            cur = cur.next;
        }
        if (cur == null) {
            throw new IndexOutOfBoundsException(origIndex);
        } else {
            return cur.value;
        }
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public T remove(int index) {
        if (index < 0 || first == null) {
            throw new IndexOutOfBoundsException(index);
        }

        if (index == 0) { // Remove first element
            T ret = first.value;
            first = first.next;
            size--;
            return ret;
        }

        Node<T> cur = first;
        int origIndex = index;

        while (index > 1 && cur.next != null) {
            cur = cur.next;
            index--;
        }

        if (cur.next == null) {
            throw new IndexOutOfBoundsException(origIndex);
        }

        T ret = cur.next.value;
        cur.next = cur.next.next;
        size--;
        return ret;
    }

    public void intersperse(T sep) {
        if (first == null || first.next == null)
            return;

        Node<T> temp = first;
        while (temp != null && temp.next != null) {
            Node<T> newNode = new Node<>(sep, temp.next);
            temp.next = newNode;
            temp = newNode.next;
            size++;
        }
    }

    // public T maximum() {
    // Node<T> max = first;
    // Node<T> temp = first.next;
    // while (temp != null) {
    // if (temp.value.compareTo(max.value)) {
    // max = temp;
    // }
    // temp = temp.next;
    // }
    // return max.value;
    // }

    /**
     * Sorts the linked list using the insertion sort algorithm.
     * This modifies the list in-place.
     */
    // public void insertionSort() {
    // if (first == null || first.next == null) return; // Already sorted
    //
    // Node<T> sorted = null; // Sorted part of the list
    // Node<T> current = first;
    //
    // while (current != null) {
    // Node<T> next = current.next;
    // sorted = sortedInsert(sorted, current);
    // current = next;
    // }
    //
    // first = sorted; // Update head to sorted list
    // }
    // InserstionSort can't be implemented because we can't compare generic types
    /**
     * Inserts a node into the sorted linked list.
     */
    // private Node<T> sortedInsert(Node<T> sorted, Node<T> newNode) {
    // if (sorted == null || newNode.value.compareTo(sorted.value) <= 0) {
    // newNode.next = sorted;
    // return newNode;
    // }
    //
    // Node<T> current = sorted;
    // while (current.next != null && current.next.value.compareTo(newNode.value) <
    // 0) {
    // current = current.next;
    // }
    //
    // newNode.next = current.next;
    // current.next = newNode;
    // return sorted;
    // }
    // sortedInsert can't be implemented because we can't compare generic types

}
