// Define a Node class to represent individual nodes in the circular linked list.
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Define a CircularLinkedList class to represent the circular linked list.
class CircularLinkedList {
    private Node head; // Points to the head (start) of the circular linked list.
    private Node tail; // Points to the tail (end) of the circular linked list.

    // Method to insert a new node at the end of the circular linked list.
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Make it circular by connecting the new node to itself.
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Update the circular reference by connecting the tail to the head.
        }
    }

    // Method to delete a node by value.
    public void delete(int value) {
        if (head == null) {
            return; // If the list is empty, there's nothing to delete.
        }
        if (head.data == value) {
            if (head == tail) {
                head = null;
                tail = null; // If there's only one node, set both head and tail to null.
            } else {
                head = head.next; // Move the head to the next node.
                tail.next = head; // Update the circular reference by connecting the tail to the new head.
            }
            return;
        }
        Node current = head;
        Node prev = null;
        do {
            if (current.data == value) {
                prev.next = current.next; // Delete the node by updating the next reference of the previous node.
                if (current == tail) {
                    tail = prev; // Update the tail if the last node was removed.
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head); // Continue until we've traversed the entire circular list.
    }

    // Method to display the circular linked list.
    public void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + "->"); // Print the data of the current node.
            current = current.next;
        } while (current != head); // Continue until we've traversed the entire circular list.
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList myList = new CircularLinkedList();

        // Insert some elements into the circular linked list.
        myList.insert(10);
        myList.insert(20);
        myList.insert(30);

        System.out.println("Circular Linked List:");
        myList.display(); // Display the circular linked list.

        // Delete an element (e.g., 20) from the circular linked list.
        myList.delete(20);
        System.out.println("Circular Linked List after deleting 20:");
        myList.display(); // Display the updated circular linked list.
    }
}
