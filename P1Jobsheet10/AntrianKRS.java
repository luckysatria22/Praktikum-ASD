public class AntrianKRS {
    Mahasiswa[] data;
    int front, rear, size, max;
    int totalSudahKRS = 0;

    public AntrianKRS(int n) {
        max = n;
        data = new Mahasiswa[max];
        size = 0;
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == max; }

    public void enqueue(Mahasiswa m) {
        if (!isFull()) {
            rear = (rear + 1) % max;
            data[rear] = m;
            size++;
        } else {
            System.out.println("Antrian sudah penuh!");
        }
    }

    public void panggilKRS() {
        if (size >= 2) {
            System.out.println("Memproses KRS untuk 2 mahasiswa:");
            for (int i = 0; i < 2; i++) {
                Mahasiswa m = data[front];
                System.out.print("Diproses: ");
                m.tampilkanData();
                front = (front + 1) % max;
                size--;
                totalSudahKRS++;
            }
        } else {
            System.out.println("Minimal harus ada 2 mahasiswa untuk memulai proses.");
        }
    }

    public void printSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            int i = front;
            while (i != rear) {
                data[i].tampilkanData();
                i = (i + 1) % max;
            }
            data[i].tampilkanData();
        }
    }

    public void peekDuaTerdepan() {
        if (size >= 2) {
            System.out.println("2 Antrian Terdepan:");
            data[front].tampilkanData();
            data[(front + 1) % max].tampilkanData();
        } else {
            System.out.println("Data tidak cukup untuk menampilkan 2 terdepan.");
        }
    }

    public void peekTerakhir() {
        if (!isEmpty()) {
            System.out.print("Antrian Terakhir: ");
            data[rear].tampilkanData();
        }
    }

    public void cetakStatistik(int kuotaDPA) {
        System.out.println("Jumlah antrian saat ini: " + size);
        System.out.println("Total sudah proses KRS: " + totalSudahKRS);
        System.out.println("Sisa mahasiswa belum ditangani DPA: " + (kuotaDPA - totalSudahKRS));
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }
}