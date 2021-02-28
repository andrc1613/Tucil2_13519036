package src;

// Pengimpor sejati
import java.util.*;

public class TopoSortAndrew {
    /*--- Bahkan Tempat Sorting Butuh Atribut ---*/
    private List<List<String>> hasilSorting; // Menyimpan hasil sorting
    public boolean invalid; // Mengecek apakah graf memiliki siklus atau graf tidak lengkap

    /*--- Bahkan Tempat Sorting Butuh Ctor ---*/
    TopoSortAndrew(GraphAndrew werdna) {
        hasilSorting = new ArrayList<>();
        TopologicalSorting(werdna);
    }

    /*--- Tempat Sorting Butuh Metode ---*/
    // Topological Sorting
    /*
     * Melakukan topological sorting. 
     * Langkah:
     * 1. Ambil semua simpul yang tidak memiliki derajat masuk, simpan ke dalam sebuah list
     * 2. Tambahkan list simpul ke dalam hasil sorting.
     * 3. Hapus semua simpul tersebut dari graf.
     * 4. Ulangi langkah 1-3 sampai graf tidak memiliki simpul atau sebuah siklus ditemukan
     */
    public void TopologicalSorting(GraphAndrew werdna) {
        invalid = false;
        while (werdna.getVerticeCount() > 0 && !invalid) {
            List<String> listSorting = new ArrayList<>();
            int i;
            for (i = 0; i < werdna.getVerticeCount(); i++) {
                if (werdna.getGraf().get(i).getInDegreeCount() == 0) {
                    listSorting.add(werdna.getGraf().get(i).getVerticeName());
                }
            }
            if (listSorting.size() > 0) {
                hasilSorting.add(listSorting);

                for (i = 0; i < listSorting.size(); i++) {
                    werdna.removeVertice(listSorting.get(i));
                }
            } else {
                invalid = true;
            }
        }
    }

    // Menampilkan output
    public void printRencanaKuliah() {
        int i, j;
        int jumlahSem = hasilSorting.size();
        
        // Tambahan output
        if (jumlahSem > 8 && jumlahSem <= 14) {
            System.out.println("Peringatan: Anda hanya perlu berkuliah selama 4 tahun.");
        }
        if (jumlahSem > 14) {
            System.out.println("Peringatan: Jangan menghabiskan hidup anda dengan berkuliah saja.");
            jumlahSem = 14;
        }

        System.out.println("Berikut rencana kuliah Anda terurut berdasarkan prerequisites-nya.");
        for (i = 0; i < jumlahSem; i++) {
            System.out.printf("%s", semester[i]);
            for (j = 0; j < hasilSorting.get(i).size(); j++) {
                System.out.print(hasilSorting.get(i).get(j));
                if (j != hasilSorting.get(i).size() - 1) {
                    System.out.print(", ");
                } else {
                    System.out.println();
                }
            }
        }
    }

    // ITB lulus paling lambat 7 tahun (14 semester)
    public String[] semester = new String[] { 
        "Semester I    : ", 
        "Semester II   : ", 
        "Semester III  : ", 
        "Semester IV   : ", 
        "Semester V    : ", 
        "Semester VI   : ",
        "Semester VII  : ", 
        "Semester VIII : ", 
        "Semester IX   : ", 
        "Semester X    : ", 
        "Semester XI   : ", 
        "Semester XII  : ", 
        "Semester XIII : ", 
        "Semester XIV  : " };
}