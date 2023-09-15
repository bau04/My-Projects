// Define a Node class to represent individual nodes in the doubly linked list.
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

// Define a DoublyLinkedList class to represent the doubly linked list.
class DoublyLinkedList {
    Node head; // Initialize the head of the doubly linked list.

    // Method to insert a new node at the end of the doubly linked list.
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
            newNode.prev = current; // Update the previous reference of the new node.
        }
    }

    // Method to delete a node by value.
    public void delete(int value) {
        if (head == null) {
            return; // If the list is empty, there's nothing to delete.
        }
        if (head.data == value) {
            head = head.next; // If the value to delete is in the head node, update the head.
            if (head != null) {
                head.prev = null; // Remove the previous reference of the new head.
            }
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                current.prev.next = current.next; // Delete the node by updating next reference of previous node.
                if (current.next != null) {
                    current.next.prev = current.prev; // Update the previous reference of the next node.
                }
                return;
            }
            current = current.next; // Move to the next node in the list.
        }
    }

    // Method to display the doubly linked list from head to tail.
    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "<->"); // Print the data of the current node.
            current = current.next; // Move to the next node.
        }
        System.out.println("null"); // Print "null" to indicate the end of the list.
    }

    // Method to display the doubly linked list from tail to head.
    public void displayBackward() {
        Node current = head;
        while (current != null && current.next != null) {
            current = current.next; // Traverse to the last node.
        }
        while (current != null) {
            System.out.print(current.data + "<->"); // Print the data of the current node.
            current = current.prev; // Move to the previous node.
        }
        System.out.println("null"); // Print "null" to indicate the end of the list.
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();

        // Insert some elements into the doubly linked list.
        myList.insert(10);
        myList.insert(20);
        myList.insert(30);

        System.out.println("Doubly Linked List (Forward):");
        myList.displayForward(); // Display the list from head to tail.
        System.out.println("Doubly Linked List (Backward):");
        myList.displayBackward(); // Display the list from tail to head.

        myList.delete(20); // Delete an element (e.g., 20) from the list.

        System.out.println("Doubly Linked List after deleting 20:");
        myList.displayForward(); // Display the updated list from head to tail.
    }
}
