package Jobsheet14;

public class BinaryTreeArray09 {
    int[] data;
    int   idxLast;

    public BinaryTreeArray09(int capacity) {
        data    = new int[capacity];
        idxLast = -1;
    }

    // Mengisi data sekaligus dari array input
    public void populateData(int[] inputData) {
        for (int i = 0; i < inputData.length; i++) {
            data[i] = inputData[i];
        }
        idxLast = inputData.length - 1;
    }

    public void traverseInOrder(int idxStart) {
        if (idxStart > idxLast) return;
        traverseInOrder(2 * idxStart + 1);       
        System.out.print(data[idxStart] + " ");  
        traverseInOrder(2 * idxStart + 2);       
    }

    public void add(int value) {
        idxLast++;
        if (idxLast >= data.length) {
            System.out.println("Array penuh!"); idxLast--; return;
        }
        data[idxLast] = value;
    }

    public void traversePreOrder(int idxStart) {
        if (idxStart > idxLast) return;
        System.out.print(data[idxStart] + " ");  
        traversePreOrder(2 * idxStart + 1);       
        traversePreOrder(2 * idxStart + 2);   
    }
}
