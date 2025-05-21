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
            System.out.println("List kosong, tidak bisa dihapus");
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
            System.out.println("List kosong, tidak bisa dihapus");
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
    if (isEmpty()) {
        System.out.println("Linked list masih kosong.");
        return;
    }
    Node08 current = head;
    while (current != null) {
        current.data.tampil();
        current = current.next;
        }
    }

    public void add(int index, Mahasiswa08 data) {
        if (index < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node08 current = head;
        int count = 0;
        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Indeks melebihi panjang list.");
            return;
        }
        if (current == tail) {
            addLast(data);
            return;
        }
        Node08 newNode = new Node08(data, current.next, current);
        current.next.prev = newNode;
        current.next = newNode;
    }

    public void removeAfter(String keyNim) {
        Node08 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }
        if (current.next == null) {
            System.out.println("Tidak ada node setelah NIM " + keyNim + " yang bisa dihapus.");
            return;
        }
        Node08 nodeToRemove = current.next;
        if (nodeToRemove == tail) {
            tail = current;
            current.next = null;
        } else {
            current.next = nodeToRemove.next;
            nodeToRemove.next.prev = current;
        }
        System.out.println("Node setelah NIM " + keyNim + " berhasil dihapus.");
    }


    public void remove(int index) {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus");
            return;
        }
        if (index < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        Node08 current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Indeks melebihi panjang list.");
            return;
        }
        if (current == tail) {
            removeLast();
            return;
        }
        // Hapus node di tengah
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }
    
    public void remove(String nim) {
        Node08 current = head;
        while (current != null && !current.data.nim.equals(nim)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Node dengan NIM " + nim + " tidak ditemukan.");
            return;
        }
        if (current == head) {
            removeFirst();
        } else if (current == tail) {
            removeLast();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    public void getFirst() {
        if (isEmpty()) {
            System.out.println("List kosong.");
        } else {
            System.out.print("Data pada node head: ");
            head.data.tampil();
        }
    }  

    public void getLast() {
        if (isEmpty()) {
            System.out.println("List kosong.");
        } else {
            System.out.print("Data pada node tail: ");
            tail.data.tampil();
        }  
    }

    public void getIndex(int index) {
        if (isEmpty()) {
            System.out.println("List kosong.");
            return;
        }
        if (index < 0) {
            System.out.println("Indeks tidak valid.");
            return;
            }
        Node08 current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Indeks melebihi panjang list.");
        } else {
            System.out.print("Data pada indeks ke-" + index + ": ");
            current.data.tampil();
        }
    }

    int size() {
    int count = 0;
    Node08 current = head;
    while (current != null) {
        count++;
        current = current.next;
    }
    return count;
    }

}

