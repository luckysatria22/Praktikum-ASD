public class AntrianLayanan {
    Mahasiswa[] data;   
    int front;
    int rear;
    int size;
    int max;

    public AntrianLayanan(int n) {
        max   = n;
        data  = new Mahasiswa[max];
        front = -1;
        rear  = -1;
        size  = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void enqueue(Mahasiswa dt) {
        if (isFull()) {
            System.out.println("Antrian penuh! Tidak dapat menambahkan data.");
        } else {
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % max;
            data[rear] = dt;
            size++;
            System.out.println("Mahasiswa " + dt.nama + " berhasil ditambahkan ke antrian.");
        }
    }

    public Mahasiswa dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong! Tidak ada data yang bisa dikeluarkan.");
            return null;
        } else {
            Mahasiswa mhs = data[front];
            data[front] = null;
            front = (front + 1) % max;
            size--;
            if (isEmpty()) {
                front = -1;
                rear  = -1;
            }
            return mhs;
        }
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("=== Antrian Paling Depan ===");
            data[front].tampilkanData();
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("=== Daftar Antrian Layanan ===");
            int i = front;
            for (int k = 0; k < size; k++) {
                System.out.println("--- Antrian ke-" + (k + 1) + " ---");
                data[i].tampilkanData();
                i = (i + 1) % max;
            }
        }
    }

    public void clear() {
        for (int i = 0; i < max; i++) {
            data[i] = null;
        }
        front = -1;
        rear  = -1;
        size  = 0;
        System.out.println("Semua antrian berhasil dihapus.");
    }

    public int getJumlahAntrian() {
        return size;
    }

    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("=== Antrian Paling Belakang ===");
            data[rear].tampilkanData();
        }
    }
}