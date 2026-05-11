package LinkedList;

public class Mahasiswa {
    String nim;
    String nama;
    String kelas;
    double ipk;

    public Mahasiswa() {}

    public Mahasiswa(String nm, String name, String kls, double ip) {
        this.nim   = nm;
        this.nama  = name;
        this.kelas = kls;
        this.ipk   = ip;
    }

    public void tampilInformasi() {
        System.out.printf("%-12s %-12s %-6s %.1f%n", nama, nim, kelas, ipk);
    }
}