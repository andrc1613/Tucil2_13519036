package src;

// Pengimpor sejati
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class EzLulus4Tahun {
    public static void main(String[] args) {

        /*--- Kamus dengan Kearifan Lokal ---*/
        Scanner input = new Scanner(System.in); // instansiasi tukang baca input user
        GraphAndrew andrew = new GraphAndrew(); // instansiasi object graf
        int i; // index iterasi

        /*--- Algoritma tapi di OOP ---*/
        System.out.println("(input \"#\" untuk keluar)");
        System.out.print("Another test subject!: ");
        String namaFile = input.nextLine();

        // Looping program
        while (!namaFile.equals("#")) {
            try {
                namaFile = String.format("./test/%s", namaFile);
                File anotherTestSubject = new File(namaFile);

                // Mengecek apakah file kosong
                if (anotherTestSubject.length() == 0) {
                    throw new FileNotFoundException();
                }

                Scanner testSubject = new Scanner(anotherTestSubject);

                // Memasukkan isi file ke dalam graf
                while (testSubject.hasNextLine()) {
                    String verticeName;
                    List<String> verticeIn = new ArrayList<>();
                    String[] ele = (testSubject.nextLine()).split("[,. ]+");
                    verticeName = ele[0];

                    for (i = 1; i < ele.length; i++) {
                        verticeIn.add(ele[i]);
                    }
                    VerticeAndrew verticex = new VerticeAndrew(verticeName, verticeIn);
                    andrew.addVertice(verticex);
                }
                testSubject.close();

                // Topological sort
                andrew.printGraph();
                System.out.println();
                TopoSortAndrew topoSort = new TopoSortAndrew(andrew);

                // Mengecek 'seandainya' graf memiliki siklus atau graf tidak lengkap
                if (topoSort.invalid) {
                    System.out.println("Graf bukan DAG (Directed Acyclic Graph) atau graf tidak lengkap.\n");
                } else {
                    topoSort.printRencanaKuliah();
                    System.out.println();
                }

                andrew.cleanGraph(); // Reset graf menjadi semula
            } catch (FileNotFoundException e) {
                // File tidak ada di folder test atau file kosong
                System.out.println("Picked... the wrong test subject...\n");
            }

            System.out.print("Another test subject!: ");
            namaFile = input.nextLine();
        }

        // Terminasi program
        input.close();
        System.out.println("Terima kasih telah menggunakan penyortir ini ^_^");
    }
}