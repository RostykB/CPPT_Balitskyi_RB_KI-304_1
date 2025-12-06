package KI304.Balitskyi.Lab6;

public class SingleLinkedList {
    private class Node {
        Object data;
        Node next;
        Node(Object data) { this.data = data; }
    }

    private Node head;

    public void add(Object value) {
        Node newNode = new Node(value);
        if (head == null) head = newNode;
        else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
    }

    public void remove(Object value) {
        if (head == null) return;
        if (head.data.equals(value)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(value)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public Object findMin() {
        if (head == null) throw new IllegalStateException("The list is empty");

        Object min = head.data;
        Node current = head.next;
        while (current != null) {
            if (((Comparable<Object>)current.data).compareTo(min) < 0) {
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}