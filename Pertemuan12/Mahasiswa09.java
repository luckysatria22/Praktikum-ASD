package Pertemuan12;

public class Mahasiswa09 {
    String nim;
    String nama;
    String kelas;
    double ipk;

    public Mahasiswa09() {}

    public Mahasiswa09(String nm, String name, String kls, double ip) {
        this.nim = nm;
        this.nama = name;
        this.kelas = kls;
        this.ipk = ip;
    }

    public void tampilInformasi() {
        System.out.printf("%-15s %-12s %-5s %.1f%n", nama, nim, kelas, ipk);
    }
}