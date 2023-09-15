// Define a Node class to represent individual nodes in the linked list.
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Define a LinkedList class to represent the linked list.
class LinkedList {
    Node head; // Initialize the head of the linked list.

    // Method to insert a new node at the end of the linked list.
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // If the list is empty, set the new node as the head.
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // Traverse the list to find the last node.
            }
            current.next = newNode; // Insert the new node at the end.
        }
    }

    // Method to delete a node by value.
    public void delete(int value) {
        if (head == null) {
            return; // If the list is empty, there's nothing to delete.
        }

        if (head.data == value) {
            head = head.next; // If the value to delete is in the head node, update the head.
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next; // Delete the node by updating the next reference.
                return;
            }
            current = current.next; // Move to the next node in the list.
        }
    }

    // Method to display the linked list.
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->"); // Print the data of the current node.
            current = current.next; // Move to the next node.
        }
        System.out.println("null"); // Print "null" to indicate the end of the list.
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();

        // Insert some elements into the linked list.
        myList.insert(10);
        myList.insert(20);
        myList.insert(30);

        System.out.println("Initial Linked List:");
        myList.display(); // Display the initial linked list.

        myList.delete(20); // Delete an element (e.g., 20) from the linked list.

        System.out.println("Linked List after deleting 20:");
        myList.display(); // Display the updated linked list.
    }
}
