public class StackSurat {
    private Surat[] stack;
    private int size;
    private int top;

    // Konstruktor berparameter
    public StackSurat(int size) {
        this.size = size;
        this.stack = new Surat[size];
        this.top = -1; // Stack kosong, top di -1
    }

    // Mengecek apakah Stack penuh
    public boolean isFull() {
        return top == size - 1;
    }

    // Mengecek apakah Stack kosong
    public boolean isEmpty() {
        return top == -1;
    }

    // Memasukkan surat ke dalam Stack (Terima Surat)
    public void push(Surat surat) {
        if (!isFull()) {
            top++;
            stack[top] = surat;
            System.out.println("Surat dari " + surat.getNamaMahasiswa() + " berhasil diterima.");
        } else {
            System.out.println("Stack penuh! Surat tidak dapat diterima.");
        }
    }

    // Mengeluarkan surat teratas dari Stack (Proses Surat)
    public Surat pop() {
        if (!isEmpty()) {
            Surat suratDiproses = stack[top];
            stack[top] = null;
            top--;
            return suratDiproses;
        } else {
            System.out.println("Stack kosong! Tidak ada surat yang dapat diproses.");
            return null;
        }
    }

    // Melihat surat teratas tanpa mengeluarkan (Lihat Surat Terakhir)
    public Surat peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong! Tidak ada surat.");
            return null;
        }
    }

    // Mencari surat berdasarkan nama mahasiswa
    public boolean cariSurat(String namaMahasiswa) {
        if (isEmpty()) {
            System.out.println("Stack kosong! Tidak ada surat untuk dicari.");
            return false;
        }
        boolean ditemukan = false;
        System.out.println("\n--- Hasil Pencarian untuk: " + namaMahasiswa + " ---");
        for (int i = top; i >= 0; i--) {
            if (stack[i].getNamaMahasiswa().equalsIgnoreCase(namaMahasiswa)) {
                System.out.println("\nSurat ditemukan:");
                System.out.println(stack[i]);
                System.out.println("-----------------------------");
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Surat atas nama \"" + namaMahasiswa + "\" tidak ditemukan.");
        }
        return ditemukan;
    }

    // Menampilkan semua surat dalam Stack
    public void print() {
        if (isEmpty()) {
            System.out.println("Stack kosong! Tidak ada surat.");
        } else {
            System.out.println("\n===== DAFTAR SURAT DALAM STACK =====");
            for (int i = top; i >= 0; i--) {
                System.out.println("[Posisi " + (top - i + 1) + " dari atas]");
                System.out.println(stack[i]);
                System.out.println("------------------------------------");
            }
        }
    }

    // Menghitung jumlah surat dalam Stack
    public int jumlahSurat() {
        return top + 1;
    }
}