package Pertemuan12;

public class SLLMain09 {
    public static void main(String[] args) {
        SingleLinkedList09 sll = new SingleLinkedList09();

        Mahasiswa09 mhs1 = new Mahasiswa09("24212200", "Alvaro", "1A", 4.0);
        Mahasiswa09 mhs2 = new Mahasiswa09("22212202", "Cintia", "3C", 3.5);
        Mahasiswa09 mhs3 = new Mahasiswa09("23212201", "Bimon",  "2B", 3.8);
        Mahasiswa09 mhs4 = new Mahasiswa09("21212203", "Dirga",  "4D", 3.6);

        sll.print();                         // kosong
        sll.addFirst(mhs4);
        sll.print();                         // Dirga
        sll.addLast(mhs1);
        sll.print();                         // Dirga, Alvaro
        sll.insertAfter("Dirga", mhs3);
        sll.insertAt(2, mhs2);
        sll.print();                         // Dirga, Cintia, Bimon, Alvaro
    }
}