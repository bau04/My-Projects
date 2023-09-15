// Define a Node class to represent individual nodes in the double-ended linked list.
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// Define a DoubleEndedLinkedList class to represent the double-ended linked list.
class DoubleEndedLinkedList {
    private Node front; // Points to the front (head) of the deque.
    private Node rear;  // Points to the rear (tail) of the deque.

    // Constructor to initialize an empty double-ended linked list (deque).
    public DoubleEndedLinkedList() {
        front = null;
        rear = null;
    }

    // Method to check if the deque is empty.
    public boolean isEmpty() {
        return front == null;
    }

    // Method to insert an element at the front of the deque.
    public void insertFront(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
    }

    // Method to insert an element at the rear of the deque.
    public void insertRear(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Method to remove an element from the front of the deque.
    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from front.");
        } else {
            front = front.next;
            if (front != null) {
                front.prev = null;
            } else {
                rear = null; // If the last element was removed, update rear as well.
            }
        }
    }

    // Method to remove an element from the rear of the deque.
    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from rear.");
        } else {
            rear = rear.prev;
            if (rear != null) {
                rear.next = null;
            } else {
                front = null; // If the last element was removed, update front as well.
            }
        }
    }

    // Method to display the elements of the deque.
    public void display() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        DoubleEndedLinkedList deque = new DoubleEndedLinkedList();

        // Insert some elements at the front and rear of the deque.
        deque.insertFront(10);
        deque.insertRear(20);
        deque.insertFront(5);

        System.out.println("Deque elements:");
        deque.display(); // Display the elements in the deque.

        // Delete elements from the front and rear of the deque.
        deque.deleteFront();  // deletes the front element of the deque
        deque.deleteRear();  // deletes the rear element of the deque

        System.out.println("Deque elements after deletion:");
        deque.display(); // Display the updated elements in the deque.
    }
}
