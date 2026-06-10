package Jobsheet14;

public class BinaryTreeArrayMain09 {
    public static void main(String[] args) {
        BinaryTreeArray09 treeArray = new BinaryTreeArray09(20);
        int[] inputData = {50, 30, 70, 20, 40, 60, 80};
        treeArray.populateData(inputData);
        int idxLast = 6;

        System.out.println("====== In-Order ======");
        treeArray.traverseInOrder(0);

        System.out.println("\n====== Pre-Order (Tugas) ======");
        treeArray.traversePreOrder(0);
    }
}
