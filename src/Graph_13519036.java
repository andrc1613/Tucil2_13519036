package src;

/* 
  Disclaimer : 
  Beberapa constructor, getter, setter, dan metode tidak didefinisikan karena tidak dipakai
*/

// Pengimpor sejati
import java.util.*;

public class Graph_13519036 {

    /*--- Kelas Butuh Atribut ---*/
    private List<Vertice_13519036> graf; // Menyimpan simpul
    private int verticeCount; // Menyimpan jumlah simpul dalam graf

    /*--- Kelas Butuh Ctor ---*/
    Graph_13519036() {
        this.graf = new ArrayList<>();
        verticeCount = 0;
    }

    /*--- Kelas Butuh Getter ---*/
    public List<Vertice_13519036> getGraf() {
        return graf;
    }

    public int getVerticeCount() {
        return verticeCount;
    }

    /*--- Kelas Butuh Metode ---*/
    // Print graf
    /*
     * Menuliskan graf dalam format <Nama simpul x>: <Nama simpul yang berarah ke simpul x>.
     * "-" mengindikasikan bahwa simpul tidak memiliki derajat masuk. 
     * Contoh: 
     *  C1: C2 C3 
     *  C2: - 
     *  C3: C2
     */
    public void printGraph() {
        for (Vertice_13519036 i : this.graf) {
            System.out.printf("%s: ", i.getVerticeName());
            List<String> listIn = i.getInDegreeFrom();
            if (listIn.size() != 0) {
                for (int j = 0; j < listIn.size(); j++) {
                    System.out.format("%s ", listIn.get(j));
                }
            } else {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    // Menambahkan simpul ke dalam graf
    public void addVertice(Vertice_13519036 werdna) {
        this.graf.add(werdna);
        verticeCount++;
    }

    // Menghapus simpul x dari graf dan menghapus simpul x di dalam list simpul
    // berarah masuk pada simpul lain
    public void removeVertice(String vName) {
        int i = 0;

        while (i < verticeCount && !this.graf.get(i).getVerticeName().equals(vName)) {
            i++;
        }

        String deleted = this.graf.get(i).getVerticeName();
        this.graf.remove(i);
        verticeCount--;

        for (int j = 0; j < verticeCount; j++) {
            for (int k = 0; k < this.graf.get(j).getInDegreeCount(); k++) {
                if (this.graf.get(j).getInDegreeFrom().get(k).equals(deleted)) {
                    this.graf.get(j).deleteInDegreeFrom(k);
                    break;
                }
            }
        }
    }

    // Membersihkan graf menjadi object baru
    public void cleanGraph() {
        this.graf.clear();
        this.verticeCount = 0;
    }
}