import java.util.Scanner;

public class SuratDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StackSurat stackSurat = new StackSurat(10);
        int pilih;

        System.out.println("============================================");
        System.out.println("   SISTEM MANAJEMEN SURAT IZIN MAHASISWA   ");
        System.out.println("============================================");

        do {
            System.out.println("\n========== MENU UTAMA ==========");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat");
            System.out.println("5. Tampilkan Semua Surat");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilih = scan.nextInt();
            scan.nextLine(); // Membersihkan buffer

            switch (pilih) {
                case 1:
                    // ======= TERIMA SURAT IZIN =======
                    System.out.println("\n--- TERIMA SURAT IZIN ---");
                    if (stackSurat.isFull()) {
                        System.out.println("Stack penuh! Tidak dapat menerima surat baru.");
                        break;
                    }
                    System.out.print("ID Surat        : ");
                    String idSurat = scan.nextLine();

                    System.out.print("Nama Mahasiswa  : ");
                    String nama = scan.nextLine();

                    System.out.print("Kelas           : ");
                    String kelas = scan.nextLine();

                    char jenisIzin = ' ';
                    while (jenisIzin != 'S' && jenisIzin != 's' && jenisIzin != 'I' && jenisIzin != 'i') {
                        System.out.print("Jenis Izin (S=Sakit / I=Izin Keperluan Lain): ");
                        jenisIzin = scan.nextLine().charAt(0);
                        if (jenisIzin != 'S' && jenisIzin != 's' && jenisIzin != 'I' && jenisIzin != 'i') {
                            System.out.println("Input tidak valid! Masukkan S atau I.");
                        }
                    }

                    System.out.print("Durasi (hari)   : ");
                    int durasi = scan.nextInt();
                    scan.nextLine();

                    Surat suratBaru = new Surat(idSurat, nama, kelas, Character.toUpperCase(jenisIzin), durasi);
                    stackSurat.push(suratBaru);
                    System.out.println("Jumlah surat saat ini: " + stackSurat.jumlahSurat());
                    break;

                case 2:
                    // ======= PROSES SURAT IZIN =======
                    System.out.println("\n--- PROSES SURAT IZIN ---");
                    Surat suratDiproses = stackSurat.pop();
                    if (suratDiproses != null) {
                        System.out.println("Surat berikut sedang diproses/divalidasi:");
                        System.out.println("==========================================");
                        System.out.println(suratDiproses);
                        System.out.println("==========================================");
                        System.out.println("Surat berhasil diproses!");
                        System.out.println("Sisa surat dalam stack: " + stackSurat.jumlahSurat());
                    }
                    break;

                case 3:
                    // ======= LIHAT SURAT IZIN TERAKHIR =======
                    System.out.println("\n--- LIHAT SURAT IZIN TERAKHIR ---");
                    Surat suratTeratas = stackSurat.peek();
                    if (suratTeratas != null) {
                        System.out.println("Surat paling atas (akan diproses berikutnya):");
                        System.out.println("==========================================");
                        System.out.println(suratTeratas);
                        System.out.println("==========================================");
                    }
                    break;

                case 4:
                    // ======= CARI SURAT =======
                    System.out.println("\n--- CARI SURAT IZIN ---");
                    System.out.print("Masukkan nama mahasiswa yang dicari: ");
                    String namaCari = scan.nextLine();
                    stackSurat.cariSurat(namaCari);
                    break;

                case 5:
                    // ======= TAMPILKAN SEMUA SURAT =======
                    stackSurat.print();
                    break;

                case 0:
                    System.out.println("\nTerima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 0-5.");
            }

        } while (pilih != 0);

        scan.close();
    }
}