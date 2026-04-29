public class Surat {
    private String idSurat;
    private String namaMahasiswa;
    private String kelas;
    private char jenisIzin;
    private int durasi;

    // Konstruktor default
    public Surat() {}

    // Konstruktor berparameter
    public Surat(String idSurat, String namaMahasiswa, String kelas, char jenisIzin, int durasi) {
        this.idSurat = idSurat;
        this.namaMahasiswa = namaMahasiswa;
        this.kelas = kelas;
        this.jenisIzin = jenisIzin;
        this.durasi = durasi;
    }

    // Getter
    public String getIdSurat() { return idSurat; }
    public String getNamaMahasiswa() { return namaMahasiswa; }
    public String getKelas() { return kelas; }
    public char getJenisIzin() { return jenisIzin; }
    public int getDurasi() { return durasi; }

    // Menampilkan keterangan jenis izin secara lengkap
    public String getKeteranganJenisIzin() {
        return (jenisIzin == 'S' || jenisIzin == 's') ? "Sakit" : "Izin Keperluan Lain";
    }

    @Override
    public String toString() {
        return "ID Surat      : " + idSurat +
               "\nNama Mahasiswa: " + namaMahasiswa +
               "\nKelas         : " + kelas +
               "\nJenis Izin    : " + getKeteranganJenisIzin() +
               "\nDurasi        : " + durasi + " hari";
    }
}