import java.util.Scanner;

public class MainKRS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKRS antrian = new AntrianKRS(10);
        int kuotaDPA = 30;
        int pilih;

        do {
            System.out.println("\n--- MENU ANTRIAN KRS ---");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Panggil Antrian (2 Mhs)");
            System.out.println("3. Tampilkan Semua Antrian");
            System.out.println("4. Cek 2 Terdepan & Terakhir");
            System.out.println("5. Cetak Statistik");
            System.out.println("6. Kosongkan Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("NIM: "); String nim = sc.nextLine();
                    System.out.print("Nama: "); String nama = sc.nextLine();
                    System.out.print("Prodi: "); String prodi = sc.nextLine();
                    System.out.print("Kelas: "); String kelas = sc.nextLine();
                    antrian.enqueue(new Mahasiswa(nim, nama, prodi, kelas));
                    break;
                case 2:
                    antrian.panggilKRS();
                    break;
                case 3:
                    antrian.printSemua();
                    break;
                case 4:
                    antrian.peekDuaTerdepan();
                    antrian.peekTerakhir();
                    break;
                case 5:
                    antrian.cetakStatistik(kuotaDPA);
                    break;
                case 6:
                    antrian.clear();
                    break;
            }
        } while (pilih != 0);
    }
}