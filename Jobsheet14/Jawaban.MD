Jawaban Pertanyaan Praktikum 1
Pertanyaan 1: Mengapa dalam Binary Search Tree pencarian data lebih efektif dibanding binary tree biasa?
Pada Binary Search Tree (BST), setiap node mengikuti aturan: semua node di subtree kiri memiliki nilai lebih kecil dari node induk, dan semua node di subtree kanan memiliki nilai lebih besar. Aturan ini memungkinkan proses pencarian bekerja seperti binary search:

  - Setiap langkah perbandingan langsung memutuskan arah pencarian (kiri atau kanan), sehingga setengah dari sisa tree dapat langsung diabaikan.
  - Kompleksitas pencarian pada BST seimbang adalah O(log n), jauh lebih efisien dibanding binary tree biasa yang harus mengunjungi semua node O(n).
  - Pada binary tree biasa tidak ada jaminan urutan, sehingga pencarian harus dilakukan secara menyeluruh (brute-force).
Pertanyaan 2: Untuk apakah atribut left dan right di class Node?
Atribut left dan right bertipe Node adalah referensi (pointer) ke node anak kiri dan anak kanan dari suatu node. Keduanya membentuk struktur linked/hubungan antar node sehingga tercipta struktur pohon:

  - left: menunjuk ke subtree kiri, yaitu node-node dengan nilai IPK lebih kecil.
  - right: menunjuk ke subtree kanan, yaitu node-node dengan nilai IPK lebih besar.
  - Jika tidak ada anak, nilainya null.
Pertanyaan 3a: Untuk apakah atribut root di class BinaryTree? 3b: Nilai root saat tree pertama dibuat?
a. Atribut root adalah referensi ke node pertama/teratas dari tree. Ia menjadi titik awal semua operasi (traversal, pencarian, penghapusan). Tanpa root, tree tidak dapat diakses sama sekali.

b. Saat objek BinaryTree00 pertama kali dibuat melalui konstruktor, nilai root diinisialisasi menjadi null, yang berarti tree masih kosong (belum ada satu pun node).
Pertanyaan 4: Ketika tree masih kosong dan akan ditambahkan sebuah node baru, proses apa yang terjadi?
Ketika method add() dipanggil dan tree masih kosong (root == null), maka:
  1. Node baru dibuat dari objek Mahasiswa yang diberikan.
  2. isEmpty() mengembalikan true.
  3. Node baru tersebut langsung dijadikan root dari tree.
  4. Tidak ada perbandingan IPK yang dilakukan karena belum ada node lain.
  5. Tree sekarang memiliki satu node yang sekaligus menjadi root, leaf, dan satu-satunya node.
Pertanyaan 5: Jelaskan baris program di dalam method add() berikut ini:
Baris kode yang dimaksud adalah blok perulangan while(true) dengan pengecekan current == null:

  parent = current;
  if (mahasiswa.ipk < current.mahasiswa.ipk) {
      current = current.left;
      if (current == null) { parent.left = newNode; return; }
  } else {
      current = current.right;
      if (current == null) { parent.right = newNode; return; }
  }

Penjelasan:
  - parent = current : menyimpan posisi node sebelum berpindah, agar bisa menyambungkan node baru.
  - Perbandingan IPK menentukan arah: jika IPK lebih kecil, bergerak ke kiri; jika lebih besar/sama, ke kanan.
  - current = current.left/right : berpindah ke anak kiri atau kanan.
  - if (current == null) : berarti posisi kosong sudah ditemukan, sehingga parent.left atau parent.right diisi dengan newNode, lalu method keluar (return).
  - Proses ini terus berulang sampai posisi kosong yang tepat ditemukan.
Pertanyaan 6: Langkah-langkah delete() saat menghapus node dengan dua anak. Bagaimana getSuccessor() membantu?
Langkah-langkah delete node dengan dua anak:
  1. Cari node yang akan dihapus (current) beserta parent-nya.
  2. Karena current memiliki dua anak, tidak bisa langsung dihapus begitu saja.
  3. Panggil getSuccessor(current) untuk mencari In-Order Successor, yaitu node terkecil di subtree kanan (paling kiri dari subtree kanan).
  4. Cabut successor dari posisi aslinya di tree.
  5. Gantikan node current dengan successor.
  6. Sambungkan left child dari current ke left child successor.

Peran getSuccessor():
  - Mencari node paling kiri (nilai terkecil) dari subtree kanan node yang dihapus.
  - Nilai ini menjaga properti BST tetap valid setelah penghapusan: successor lebih besar dari semua node di subtree kiri, dan lebih kecil dari semua node di subtree kanan.
  - getSuccessor() juga memperbaiki hubungan parent dari successor sebelum ia dipindahkan


Jawaban Pertanyaan Praktikum 2
Pertanyaan 1: Apakah kegunaan atribut data dan idxLast di class BinaryTreeArray?
data adalah array integer yang menjadi media penyimpanan semua node tree. Posisi dalam array mewakili posisi node dalam struktur pohon. Sedangkan idxLast menyimpan indeks terakhir yang terisi dalam array, berfungsi sebagai penanda batas data yang valid sehingga traversal tahu kapan harus berhenti (tidak melewati batas data).
Pertanyaan 2: Apakah kegunaan method populateData()?
Method populateData() digunakan untuk mengisi array data sekaligus dengan data awal yang sudah ditentukan. Method ini menyalin semua elemen dari array input ke dalam array data, kemudian menyetel nilai idxLast ke indeks terakhir dari data yang dimasukkan. Tanpa method ini, kita harus mengisi elemen satu per satu secara manual.
Pertanyaan 3: Apakah kegunaan method traverseInOrder()?
Method traverseInOrder() digunakan untuk mengunjungi dan menampilkan semua node tree secara berurutan dari nilai terkecil ke terbesar (urutan terurut). Ini bekerja dengan pola: kunjungi left child terlebih dahulu, cetak node saat ini, lalu kunjungi right child. Pada BST hasil traverseInOrder selalu menghasilkan data yang terurut ascending.
Pertanyaan 4: Jika suatu node disimpan di indeks 2, di indeks berapakah left child dan right child-nya?
Menggunakan rumus: left child = 2*i+1  dan  right child = 2*i+2

  - Node di indeks 2 → Left child  = 2*2+1 = 5
  - Node di indeks 2 → Right child = 2*2+2 = 6

Contoh pada tree {50(0), 30(1), 70(2), 20(3), 40(4), 60(5), 80(6)}:
  - Node 70 ada di indeks 2, left child-nya (60) ada di indeks 5, right child-nya (80) ada di indeks 6. ✓
Pertanyaan 5: Apa kegunaan statement 'int idxLast = 6' pada praktikum 2?
Statement int idxLast = 6 menyatakan bahwa data tree yang valid ada dari indeks 0 sampai indeks 6 (total 7 elemen). Nilai ini digunakan sebagai batas atas dalam proses traversal: jika indeks yang dikunjungi lebih besar dari idxLast, rekursi berhenti. Tanpa batasan ini, traversal akan mengakses indeks di luar data yang bermakna dan menghasilkan output yang salah.
Pertanyaan 6: Mengapa indeks 2*idxStart+1 dan 2*idxStart+2 digunakan dalam pemanggilan rekursif?
Rumus 2*i+1 (left child) dan 2*i+2 (right child) berasal dari sifat matematis penyimpanan pohon biner dalam array:

  - Pada pohon biner yang disimpan dalam array, jika sebuah node berada di indeks i, maka secara definisi anaknya selalu berada di posisi yang dapat dihitung secara deterministik.
  - Rumus ini memastikan tidak ada gap atau tumpang tindih antara posisi node induk dan anak.
  - Sebaliknya, indeks parent dari suatu node di indeks i adalah floor((i-1)/2).

Kaitan dengan struktur pohon biner:
  - Level 0 (root): indeks 0
  - Level 1: indeks 1, 2
  - Level 2: indeks 3, 4, 5, 6
  - Setiap level ke-k memiliki 2^k node, dimulai dari indeks 2^k - 1.
  - Traversal rekursif dengan rumus ini secara otomatis menelusuri pohon sesuai hierarki tanpa memerlukan pointer eksplisit (left/right).
