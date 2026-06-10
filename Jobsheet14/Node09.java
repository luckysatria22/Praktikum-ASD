package Jobsheet14;

public class Node09 {
    Mahasiswa09 mahasiswa;
    Node09 left;
    Node09 right;

    public Node09(Node09 left, Mahasiswa09 mahasiswa, Node09 right) {
        this.left      = left;
        this.mahasiswa = mahasiswa;
        this.right     = right;
    }
}
