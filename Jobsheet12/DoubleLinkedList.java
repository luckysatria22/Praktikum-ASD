package Jobsheet12;

public class DoubleLinkedList {
    Node head, tail;
    int size;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Mahasiswa data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Mahasiswa data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, Mahasiswa data) {
        if (index < 0 || index > size) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            size++;
        }
    }

    public void insertAfter(String nim, Mahasiswa data) {
        Node current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                if (current == tail) {
                    addLast(data);
                } else {
                    Node newNode = new Node(data);
                    newNode.next = current.next;
                    newNode.prev = current;
                    if (current.next != null) {
                        current.next.prev = newNode;
                    }
                    current.next = newNode;
                    size++;
                }
                return;
            }
            current = current.next;
        }
        System.out.println("NIM " + nim + " tidak ditemukan.");
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked list kosong.");
            return;
        }
        System.out.println("Data yang dihapus:");
        head.data.tampil();
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked list kosong.");
            return;
        }
        System.out.println("Data yang dihapus:");
        tail.data.tampil();
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public void removeAfter(String nim) {
        Node current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                if (current.next == null) {
                    System.out.println("Tidak ada node setelah NIM " + nim);
                    return;
                }
                Node toDelete = current.next;
                System.out.println("Data yang dihapus:");
                toDelete.data.tampil();
                if (toDelete == tail) {
                    tail = current;
                    current.next = null;
                } else {
                    current.next = toDelete.next;
                    toDelete.next.prev = current;
                }
                size--;
                return;
            }
            current = current.next;
        }
        System.out.println("NIM " + nim + " tidak ditemukan.");
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            System.out.println("Data yang dihapus:");
            current.data.tampil();
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }

    public Node search(String nim) {
        Node current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Mahasiswa getFirst() {
        if (isEmpty()) {
            System.out.println("Linked list kosong.");
            return null;
        }
        return head.data;
    }

    public Mahasiswa getLast() {
        if (isEmpty()) {
            System.out.println("Linked list kosong.");
            return null;
        }
        return tail.data;
    }

    public Mahasiswa getIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indeks tidak valid.");
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        }
        Node current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }

    public void printReverse() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        }
        Node current = tail;
        while (current != null) {
            current.data.tampil();
            current = current.prev;
        }
    }
}