package Jobsheet12;

import java.util.Scanner;

public class DoubleLinkedListMain {
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n===== MENU DOUBLE LINKED LIST =====");
            System.out.println("1.  Tambah Data di Awal");
            System.out.println("2.  Tambah Data di Akhir");
            System.out.println("3.  Tambah Data di Indeks Tertentu");
            System.out.println("4.  Sisipkan Setelah NIM Tertentu");
            System.out.println("5.  Hapus Data Pertama");
            System.out.println("6.  Hapus Data Terakhir");
            System.out.println("7.  Hapus Setelah NIM Tertentu");
            System.out.println("8.  Hapus di Indeks Tertentu");
            System.out.println("9.  Cari Data Berdasarkan NIM");
            System.out.println("10. Tampilkan Data Pertama");
            System.out.println("11. Tampilkan Data Terakhir");
            System.out.println("12. Tampilkan Data pada Indeks Tertentu");
            System.out.println("13. Tampilkan Semua Data");
            System.out.println("14. Tampilkan Data Terbalik");
            System.out.println("15. Tampilkan Ukuran List");
            System.out.println("0.  Keluar");
            System.out.print("Pilihan: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1: {
                    Mahasiswa m = inputMahasiswa(sc);
                    dll.addFirst(m);
                    System.out.println("Data berhasil ditambahkan di awal.");
                    break;
                }
                case 2: {
                    Mahasiswa m = inputMahasiswa(sc);
                    dll.addLast(m);
                    System.out.println("Data berhasil ditambahkan di akhir.");
                    break;
                }
                case 3: {
                    System.out.print("Masukkan indeks: ");
                    int idx = sc.nextInt();
                    sc.nextLine();
                    Mahasiswa m = inputMahasiswa(sc);
                    dll.add(idx, m);
                    System.out.println("Data berhasil ditambahkan di indeks " + idx + ".");
                    break;
                }
                case 4: {
                    System.out.print("Masukkan NIM acuan: ");
                    String nim = sc.nextLine();
                    Mahasiswa m = inputMahasiswa(sc);
                    dll.insertAfter(nim, m);
                    break;
                }
                case 5: {
                    dll.removeFirst();
                    break;
                }
                case 6: {
                    dll.removeLast();
                    break;
                }
                case 7: {
                    System.out.print("Masukkan NIM acuan: ");
                    String nim = sc.nextLine();
                    dll.removeAfter(nim);
                    break;
                }
                case 8: {
                    System.out.print("Masukkan indeks yang ingin dihapus: ");
                    int idx = sc.nextInt();
                    sc.nextLine();
                    dll.remove(idx);
                    break;
                }
                case 9: {
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nim = sc.nextLine();
                    Node hasil = dll.search(nim);
                    if (hasil != null) {
                        System.out.println("Data ditemukan:");
                        hasil.data.tampil();
                    } else {
                        System.out.println("Data dengan NIM " + nim + " tidak ditemukan.");
                    }
                    break;
                }
                case 10: {
                    Mahasiswa m = dll.getFirst();
                    if (m != null) {
                        System.out.println("Data pertama:");
                        m.tampil();
                    }
                    break;
                }
                case 11: {
                    Mahasiswa m = dll.getLast();
                    if (m != null) {
                        System.out.println("Data terakhir:");
                        m.tampil();
                    }
                    break;
                }
                case 12: {
                    System.out.print("Masukkan indeks: ");
                    int idx = sc.nextInt();
                    sc.nextLine();
                    Mahasiswa m = dll.getIndex(idx);
                    if (m != null) {
                        System.out.println("Data pada indeks " + idx + ":");
                        m.tampil();
                    }
                    break;
                }
                case 13: {
                    System.out.println("===== ISI LINKED LIST =====");
                    dll.print();
                    break;
                }
                case 14: {
                    System.out.println("===== ISI LINKED LIST (TERBALIK) =====");
                    dll.printReverse();
                    break;
                }
                case 15: {
                    System.out.println("Jumlah data: " + dll.size());
                    break;
                }
                case 0: {
                    System.out.println("Program selesai.");
                    break;
                }
                default: {
                    System.out.println("Pilihan tidak valid.");
                }
            }
        } while (pilihan != 0);

        sc.close();
    }

    static Mahasiswa inputMahasiswa(Scanner sc) {
        System.out.print("NIM   : ");
        String nim = sc.nextLine();
        System.out.print("Nama  : ");
        String nama = sc.nextLine();
        System.out.print("Kelas : ");
        String kelas = sc.nextLine();
        System.out.print("IPK   : ");
        Double ipk = sc.nextDouble();
        sc.nextLine();
        return new Mahasiswa(nim, nama, kelas, ipk);
    }
}