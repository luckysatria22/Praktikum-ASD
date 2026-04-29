package P1Jobsheet10;

public class Queue {
    int[] data;
    int front;
    int rear;
    int size;
    int max;
    
    public Queue(int n) {
        max = n;
        data = new int[max];
        size = 0;
        front = rear = -1;
    }

    public boolean IsEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
}