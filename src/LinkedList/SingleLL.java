package LinkedList;

public class SingleLL {
    public Node head;
    public Node tail;
    public int size;

    // create a linked list
    public void createLinkedList(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.data = nodeValue;
        node.next = null;
        head = node;
        tail = node;
        size = 1;
    }

    // insert into linked list
    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.data = nodeValue;
        if (head == null) {
            createLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            tail.next = node;
            node.next = null;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            node.next = tempNode.next;
            tempNode.next = node;
        }
        size++;
    }

    // traverse linked list
    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.data);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("\n");
    }

    // search for node
    public void searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.data == nodeValue) {
                    System.out.println("Found the node: " + tempNode.data + " at location: " + i + "\n");
                    return;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
    }

    // deleting a node from a single linked list
    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("SLL does not exist");
        } else if (location == 0) { // delete at the beginning
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        } else if (location >= size - 1) { // delete at the end
            Node tempNode = head;
            for (int i = 0; i < size - 2; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) { //only one node was in the list
                head = tail = null;
            } else {
                tempNode.next = null;
                tail = tempNode;
            }
            size--;
        } else {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }
}