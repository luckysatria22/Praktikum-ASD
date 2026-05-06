import java.util.Scanner;

public class LayananAkademikSIAKAD {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AntrianLayanan antrian = new AntrianLayanan(5);

        int pilihan;

        do {
            System.out.println("\n==============================");
            System.out.println("  Layanan Akademik SIAKAD");
            System.out.println("==============================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Panggil Antrian");
            System.out.println("3. Cek Antrian Paling Depan");
            System.out.println("4. Tampilkan Semua Antrian");
            System.out.println("5. Hapus Semua Antrian");
            System.out.println("6. Cek Antrian Paling Belakang");
            System.out.println("0. Keluar");
            System.out.print("Pilihan : ");
            pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.println("\n-- Tambah Antrian --");
                    System.out.print("NIM   : ");
                    String nim   = sc.nextLine();
                    System.out.print("Nama  : ");
                    String nama  = sc.nextLine();
                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();
                    Mahasiswa mhs = new Mahasiswa(nim, nama, prodi, kelas);
                    antrian.enqueue(mhs);
                    System.out.println("Jumlah antrian saat ini : " + antrian.getJumlahAntrian());
                    break;

                case 2:
                    System.out.println("\n-- Panggil Antrian --");
                    Mahasiswa dipanggil = antrian.dequeue();
                    if (dipanggil != null) {
                        System.out.println("Mahasiswa berikut dipanggil untuk layanan:");
                        dipanggil.tampilkanData();
                        System.out.println("Jumlah antrian tersisa : " + antrian.getJumlahAntrian());
                    }
                    break;

                case 3:
                    System.out.println();
                    antrian.peek();
                    break;

                case 4:
                    System.out.println();
                    antrian.print();
                    break;

                case 5:
                    System.out.println();
                    antrian.clear();
                    break;

                case 6:
                    System.out.println();
                    antrian.lihatAkhir();
                    break;

                case 0:
                    System.out.println("Terima kasih. Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 0);

        sc.close();
    }
}