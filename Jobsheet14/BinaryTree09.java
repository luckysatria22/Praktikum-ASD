package Jobsheet14;

public class BinaryTree09 {
    Node09 root;

    public BinaryTree09() { root = null; }

    public boolean isEmpty() { return root == null; }

    // ---- ADD (iteratif) ----
    public void add(Mahasiswa09 mahasiswa) {
        Node09 newNode = new Node09(null, mahasiswa, null);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node09 current = root;
            Node09 parent;
            while (true) {
                parent = current;
                if (mahasiswa.ipk < current.mahasiswa.ipk) {
                    current = current.left;
                    if (current == null) { parent.left = newNode; return; }
                } else {
                    current = current.right;
                    if (current == null) { parent.right = newNode; return; }
                }
            }
        }
    }

    public boolean find(double ipk) {
        Node09 current = root;
        while (current != null) {
            if (ipk == current.mahasiswa.ipk) return true;
            else if (ipk < current.mahasiswa.ipk) current = current.left;
            else current = current.right;
        }
        return false;
    }

    public void traversePreOrder(Node09 node) {
        if (node != null) {
            node.mahasiswa.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traverseInOrder(Node09 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    public void traversePostOrder(Node09 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa.tampilInformasi();
        }
    }

    public Node09 getSuccessor(Node09 del) {
        Node09 successorParent = del;
        Node09 successor       = del;
        Node09 current         = del.right;
        while (current != null) {
            successorParent = successor;
            successor       = current;
            current         = current.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right      = del.right;
        }
        return successor;
    }

    public void delete(double ipk) {
        if (isEmpty()) { System.out.println("Tree kosong."); return; }
        Node09 current     = root;
        Node09 parent      = root;
        boolean isLeftChild = false;
        while (current.mahasiswa.ipk != ipk) {
            parent = current;
            if (ipk < current.mahasiswa.ipk) { isLeftChild = true;  current = current.left; }
            else                             { isLeftChild = false; current = current.right; }
            if (current == null) { System.out.println("Data tidak ditemukan."); return; }
        }
        
        if (current.left == null && current.right == null) {
            if (current == root) root = null;
            else if (isLeftChild) parent.left  = null;
            else                  parent.right = null;
        }
        
        else if (current.left == null) {
            if (current == root) root = current.right;
            else if (isLeftChild) parent.left  = current.right;
            else                  parent.right = current.right;
        }
        
        else if (current.right == null) {
            if (current == root) root = current.left;
            else if (isLeftChild) parent.left  = current.left;
            else                  parent.right = current.left;
        }
        
        else {
            Node09 successor = getSuccessor(current);
            if (current == root) root = successor;
            else if (isLeftChild) parent.left  = successor;
            else                  parent.right = successor;
            successor.left = current.left;
        }
    }

    // Dipanggil dari luar
    public void addRekursif(Mahasiswa09 mahasiswa) {
        root = addRekursifHelper(root, mahasiswa);
    }

    // Helper rekursif private
    private Node09 addRekursifHelper(Node09 current, Mahasiswa09 mahasiswa) {
        if (current == null) {
            // Posisi kosong ditemukan, buat node baru
            return new Node09(null, mahasiswa, null);
        }
        if (mahasiswa.ipk < current.mahasiswa.ipk) {
            // Rekursif ke kiri
            current.left = addRekursifHelper(current.left, mahasiswa);
        } else {
            // Rekursif ke kanan
            current.right = addRekursifHelper(current.right, mahasiswa);
        }
        return current;
    }

    public void cariMinIPK() {
    if (isEmpty()) { System.out.println("Tree kosong."); return; }
    // Pada BST, node terkecil selalu berada paling kiri
    Node09 current = root;
    while (current.left != null) {
        current = current.left;
    }
    System.out.println("=== Mahasiswa IPK Terkecil ===");
    current.mahasiswa.tampilInformasi();
    }

    public void cariMaxIPK() {
        if (isEmpty()) { System.out.println("Tree kosong."); return; }
        // Pada BST, node terbesar selalu berada paling kanan
        Node09 current = root;
        while (current.right != null) {
            current = current.right;
        }
        System.out.println("=== Mahasiswa IPK Terbesar ===");
        current.mahasiswa.tampilInformasi();
    }

    public void tampilMahasiswaIPKdiAtas(double ipkBatas) {
    System.out.println("=== Mahasiswa dengan IPK di atas " + ipkBatas + " ===");
    tampilIPKdiAtasHelper(root, ipkBatas);
    }

    private void tampilIPKdiAtasHelper(Node09 node, double ipkBatas) {
        if (node == null) return;
        if (node.mahasiswa.ipk > ipkBatas) {
            // Node ini memenuhi syarat; periksa subtree kiri dan kanan
            tampilIPKdiAtasHelper(node.left, ipkBatas);
            node.mahasiswa.tampilInformasi();
            tampilIPKdiAtasHelper(node.right, ipkBatas);
        } else {
            // IPK node <= batas; hanya subtree kanan yang mungkin memenuhi syarat (BST)
            tampilIPKdiAtasHelper(node.right, ipkBatas);
        }
    }
}