package Jobsheet14;

public class Mahasiswa09 {
    String nim;
    String nama;
    String kelas;
    double ipk;

    public Mahasiswa09() { }

    public Mahasiswa09(String nim, String nama, String kelas, double ipk) {
        this.nim   = nim;
        this.nama  = nama;
        this.kelas = kelas;
        this.ipk   = ipk;
    }

    public void tampilInformasi() {
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("Kelas : " + kelas);
        System.out.println("IPK   : " + ipk);
        System.out.println("-------------------------");
    }
}

