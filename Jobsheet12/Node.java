package Jobsheet12;

public class Node {
    Mahasiswa data;
    Node prev, next;

    public Node(Mahasiswa data) {
        this.prev = null;
        this.data = data;
        this.next = null;
    }
}