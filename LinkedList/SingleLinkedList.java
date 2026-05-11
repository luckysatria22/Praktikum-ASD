package LinkedList;

public class SingleLinkedList {

    NodeMahasiswa head;
    NodeMahasiswa tail;

    // ─────────────────────────────────────────────
    // 2.1  isEmpty
    // ─────────────────────────────────────────────
    boolean isEmpty() {
        return (head == null);
    }

    // ─────────────────────────────────────────────
    // 2.1  print (traverse)
    // ─────────────────────────────────────────────
    public void print() {
        if (!isEmpty()) {
            NodeMahasiswa tmp = head;
            System.out.println("Isi Linked List:");
            while (tmp != null) {
                tmp.data.tampilInformasi();
                tmp = tmp.next;
            }
            System.out.println();
        } else {
            System.out.println("Linked list kosong");
        }
    }

    // ─────────────────────────────────────────────
    // 2.1  addFirst
    // ─────────────────────────────────────────────
    public void addFirst(Mahasiswa input) {
        NodeMahasiswa ndInput = new NodeMahasiswa(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    // ─────────────────────────────────────────────
    // 2.1  addLast
    // ─────────────────────────────────────────────
    public void addLast(Mahasiswa input) {
        NodeMahasiswa ndInput = new NodeMahasiswa(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    // ─────────────────────────────────────────────
    // 2.1  insertAfter (setelah node dengan nama key)
    // ─────────────────────────────────────────────
    public void insertAfter(String key, Mahasiswa input) {
        NodeMahasiswa ndInput = new NodeMahasiswa(input, null);
        NodeMahasiswa temp = head;
        do {
            if (temp.data.nama.equalsIgnoreCase(key)) {
                ndInput.next = temp.next;
                temp.next    = ndInput;
                if (ndInput.next == null) {
                    tail = ndInput;
                }
                break;
            }
            temp = temp.next;
        } while (temp != null);
    }

    // ─────────────────────────────────────────────
    // 2.1  insertAt (pada indeks tertentu)
    // ─────────────────────────────────────────────
    public void insertAt(int index, Mahasiswa input) {
        if (index < 0) {
            System.out.println("indeks salah");
        } else if (index == 0) {
            addFirst(input);
        } else {
            NodeMahasiswa temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = new NodeMahasiswa(input, temp.next);
            if (temp.next.next == null) {
                tail = temp.next;
            }
        }
    }

    // ─────────────────────────────────────────────
    // 2.2  getData (pada indeks tertentu)
    // ─────────────────────────────────────────────
    public void getData(int index) {
        NodeMahasiswa tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.data.tampilInformasi();
    }

    // ─────────────────────────────────────────────
    // 2.2  indexOf (cari index berdasarkan nama)
    // ─────────────────────────────────────────────
    public int indexOf(String key) {
        NodeMahasiswa tmp = head;
        int index = 0;
        while (tmp != null && !tmp.data.nama.equalsIgnoreCase(key)) {
            tmp = tmp.next;
            index++;
        }
        if (tmp == null) {
            return -1;
        } else {
            return index;
        }
    }

    // ─────────────────────────────────────────────
    // 2.2  removeFirst
    // ─────────────────────────────────────────────
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    // ─────────────────────────────────────────────
    // 2.2  removeLast
    // ─────────────────────────────────────────────
    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            NodeMahasiswa temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    // ─────────────────────────────────────────────
    // 2.2  remove (berdasarkan nama / key)
    // ─────────────────────────────────────────────
    public void remove(String key) {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else {
            NodeMahasiswa temp = head;
            while (temp != null) {
                if ((temp.data.nama.equalsIgnoreCase(key)) && (temp == head)) {
                    this.removeFirst();
                    break;
                } else if (temp.data.nama.equalsIgnoreCase(key)) {
                    // temp di sini adalah node SEBELUM yang akan dihapus
                    // (lihat alur: kita maju satu langkah di bawah lalu cek next)
                    temp.next = temp.next.next;
                    if (temp.next == null) {
                        tail = temp;
                    }
                    break;
                }
                temp = temp.next;
            }
        }
    }

    // ─────────────────────────────────────────────
    // 2.2  removeAt (berdasarkan index)
    // ─────────────────────────────────────────────
    public void removeAt(int index) {
        if (index == 0) {
            removeFirst();
        } else {
            NodeMahasiswa temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (temp.next == null) {
                tail = temp;
            }
        }
    }
}