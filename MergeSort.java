class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void mergeAndSort(LinkedList list1, LinkedList list2) {
        merge(list1.head, list2.head);
        sort();
    }

    private void merge(Node l1, Node l2) {
        Node mergedList = new Node(0);
        Node current = mergedList;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

    
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }

        
        head = mergedList.next;
    }

    private void sort() {
        Node current = head;
        Node index = null;
        int temp;

        while (current != null) {
            index = current.next;

            while (index != null) {
                if (current.data > index.data) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }

                index = index.next;
            }

            current = current.next;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        
    }
}

public class MergeSort {
    public static void main(String[] args) {
        LinkedList obj = new LinkedList();
        obj.addNode(25);
        obj.addNode(35);
        obj.addNode(12);
        obj.addNode(4);
        obj.addNode(36);
        obj.addNode(48);

        LinkedList obj2 = new LinkedList();
        obj2.addNode(8);
        obj2.addNode(32);
        obj2.addNode(22);
        obj2.addNode(45);
        obj2.addNode(63);
        obj2.addNode(49);

        LinkedList mergedAndSortedList = new LinkedList();
        mergedAndSortedList.mergeAndSort(obj, obj2);

        System.out.println("Merged and Sorted Linked List:");
        mergedAndSortedList.display();
        System.out.println(" ");
    }
}
