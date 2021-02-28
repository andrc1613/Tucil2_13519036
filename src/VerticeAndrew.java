package src;

/* 
  Disclaimer : 
  Beberapa constructor, getter, setter, dan metode tidak didefinisikan karena tidak dipakai
*/

// Pengimpor sejati
import java.util.*;

public class VerticeAndrew {

    /*--- Kelas Butuh Atribut ---*/
    private String verticeName; // Menyimpan nama simpul
    private List<String> inDegreeFrom; // Menyimpan list simpul yang berarah ke simpul tersebut
    private int inDegreeCount; // Menyimpan derajat simpul

    /*--- Kelas Butuh Ctor ---*/
    VerticeAndrew(String verticeName, List<String> inDegreeFrom) {
        this.verticeName = verticeName;
        this.inDegreeFrom = inDegreeFrom;
        this.inDegreeCount = inDegreeFrom.size();
    }

    /*--- Kelas Butuh Getter ---*/
    public String getVerticeName() {
        return this.verticeName;
    }

    public List<String> getInDegreeFrom() {
        return inDegreeFrom;
    }

    public int getInDegreeCount() {
        return inDegreeCount;
    }

    /*--- Kelas Butuh Metode ---*/
    // Menghapus simpul yang berarah ke simpul this
    public void deleteInDegreeFrom(int i) {
        this.inDegreeFrom.remove(i);
        inDegreeCount--;
    }
}