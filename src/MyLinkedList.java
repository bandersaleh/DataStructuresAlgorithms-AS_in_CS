public class MyLinkedList {
    private Node head;
    private Node tail;
    private int count;

    // Constructor
    public MyLinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    // Method to add an element to the beginning of the linked list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        count++;
    }

    // Method to display the elements of the linked list
    public void display() {
        Node current = head;
        System.out.print("LinkedList: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // METHOD FOR QUESTION 9
    // Method to remove the element at the given index from the LinkedList
    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (isEmpty()) {
            throw new IllegalStateException("Linked list is empty");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current == head) {
            head = head.next;
        } else if (current == tail) {
            tail = tail.previous;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        count--;
    }

    // Method to check if the linked list is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Node class definition (nested class)
    private class Node {
        int data;
        Node next;
        Node previous;

        // Constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }
}
