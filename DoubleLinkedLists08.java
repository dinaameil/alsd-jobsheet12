import java.lang.classfile.components.ClassPrinter.Node;

public class DoubleLinkedLists08 {
    Node08 head;
    Node08 tail;

    public DoubleLinkedLists08() {
        head = null;
        tail = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void addLast (Mahasiswa08 data) {
        Node08 newNode = new Node08(data, null, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addFirst (Mahasiswa08 data) {
        Node08 newNode = new Node08(data, null, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public Node08 search(String nim) {
        Node08 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


    public void insertAfter(String keyNim, Mahasiswa08 data) {
    Node08 current = head;

        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with key " + keyNim + " not found.");
            return;
        }

        Node08 newNode = new Node08(data, current.next, current);

        if (current == tail) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
            tail= newNode;
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        System.out.println("Node berhasil disisipkan setelah " + keyNim);
    }

    public void print() {
        Node08 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }

}
