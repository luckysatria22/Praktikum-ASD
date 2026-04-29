public class StackTugasMahasiswa09 {
    Mahasiswa09[] stack;
    int top;
    int size;

    public StackTugasMahasiswa09(int size) { // Constructor untuk inisialisasi stack
        this.size = size;
        stack = new Mahasiswa09[size];
        top = -1;
    }

    public boolean isFull() { // Cek apakah stack penuh
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() { // Cek apakah stack kosong
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(Mahasiswa09 mhs) { // Menambahkan elemen ke stack
        if (!isFull()) {
            top++;
            stack[top] = mhs;
        } else {
            System.out.println("Stack sudah penuh!");
        }
    }

    public Mahasiswa09 pop() {
        if (!isEmpty()) {
            Mahasiswa09 mhs = stack[top];
            top--;
            return mhs;
        } else {
            System.out.println("Stack kosong!");
            return null;
        }
    }

    public Mahasiswa09 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong!");
            return null;
        }
    }

    public void print() {
        for (int i = top; i >= 0; i--) {
            System.out.println("Nama: " + stack[i].nama);
            System.out.print("\tNIM: " + stack[i].nim);
            System.out.print("\tKelas: " + stack[i].kelas);
            System.out.print("\tNilai: " + stack[i].nilai);
            System.out.println();
        }
    }
}
