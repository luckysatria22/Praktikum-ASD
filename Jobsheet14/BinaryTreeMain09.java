package Jobsheet14;

public class BinaryTreeMain09 {
    public static void main(String[] args) {
        BinaryTree09 tree = new BinaryTree09();
        tree.add(new Mahasiswa09("2301","Budi Santoso",  "TI-1A", 3.50));
        tree.add(new Mahasiswa09("2302","Ani Rahayu",    "TI-1A", 3.75));
        tree.add(new Mahasiswa09("2303","Candra Wijaya", "TI-1B", 3.20));
        tree.add(new Mahasiswa09("2304","Dewi Lestari",  "TI-1B", 3.90));
        tree.add(new Mahasiswa09("2305","Eko Prasetyo",  "TI-1C", 2.85));
        tree.add(new Mahasiswa09("2306","Fitri Handayani","TI-1C",3.60));
        tree.add(new Mahasiswa09("2307","Gilang Ramadhan","TI-1A",2.50));

        System.out.println("\n====== Pre-Order =======");
        tree.traversePreOrder(tree.root);
        System.out.println("\n====== In-Order =======");
        tree.traverseInOrder(tree.root);
        System.out.println("\n====== Post-Order =====");
        tree.traversePostOrder(tree.root);
        System.out.println("\nFind 3.75: " + tree.find(3.75));
        System.out.println("Find 4.00: " + tree.find(4.00));
        tree.delete(3.20);
    }
}
