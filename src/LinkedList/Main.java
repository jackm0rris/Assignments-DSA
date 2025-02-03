package LinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLL singleLinkedList = new SingleLL();

        // inserting nodes into linked list
        singleLinkedList.insertInLinkedList(1, 0);
        singleLinkedList.insertInLinkedList(2, 1);
        singleLinkedList.insertInLinkedList(3, 2);
        singleLinkedList.insertInLinkedList(4, 3);
        singleLinkedList.insertInLinkedList(5, 1);

        System.out.println("Initial Linked List:");
        singleLinkedList.traverseLinkedList();

        // searching for a node
        singleLinkedList.searchNode(4);

        // deleting a node specific position
        System.out.println("Deleting a node at position 3:");
        singleLinkedList.deleteNode(3);
        singleLinkedList.traverseLinkedList();

        // deleting first node
        System.out.println("Deleting the first node:");
        singleLinkedList.deleteNode(0);
        singleLinkedList.traverseLinkedList();

        // deleting last node
        System.out.println("Deleting the last node:");
        singleLinkedList.deleteNode(singleLinkedList.size - 1);
        singleLinkedList.traverseLinkedList();
    }
}
