import simulation.*;
import java.util.*;


public class Main {


    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {


        System.out.println(
                "  _____           __  __ _        _     _       _     _     ____  _                 _       _             \n" +
                        " |_   _| __ __ _ / _|/ _(_) ___  | |   (_) __ _| |__ | |_  / ___|(_)_ __ ___  _   _| | __ _| |_ ___  _ __ \n" +
                        "   | || '__/ _` | |_| |_| |/ __| | |   | |/ _` | '_ \\| __| \\___ \\| | '_ ` _ \\| | | | |/ _` | __/ _ \\| '__|\n" +
                        "   | || | | (_| |  _|  _| | (__  | |___| | (_| | | | | |_   ___) | | | | | | | |_| | | (_| | || (_) | |   \n" +
                        "   |_||_|  \\__,_|_| |_| |_|\\___| |_____|_|\\__, |_| |_|\\__| |____/|_|_| |_| |_|\\__,_|_|\\__,_|\\__\\___/|_|   \n" +
                        "                                          |___/                                                           "
        );


        String[] Nodes = {
                "Perumdos", "Kertajaya1", "Kertajaya2", "Kertajaya3",
                "Sulawesi", "Dinoyo", "Diponegoro", "Indragiri",
                "Mayjen_Sungkono1", "Mayjen_Sungkono2", "Mayjen_Sungkono3",
                "Pandegiling", "Dukuh_Kupang", "Manyar", "Semolowaru1",
                "Semolowaru2", "Nginden_Semolo", "Manyar_Rejo",
                "Ngagel_Jaya_Selatan", "Bung_Tomo", "Bengawan",
                "Kutai1", "Kutai2", "Voza_Tower", "Galaxy_Mall3",
                "Harris_Hotel", "IKEA_Ciputra_World", "Soto_Ayam_Lamongan_Cak_Har"
        };


        String[] AvailableLocations = {
                "Perumdos",
                "Voza_Tower",
                "Galaxy_Mall3",
                "Harris_Hotel",
                "IKEA_Ciputra_World",
                "Soto_Ayam_Lamongan_Cak_Har"
        };


        String[][] Edges = {
                {"Perumdos", "Kertajaya1"},
                {"Kertajaya1", "Perumdos"},
                {"Kertajaya1", "Kertajaya2"},
                {"Kertajaya2", "Kertajaya1"},
                {"Kertajaya2", "Kertajaya3"},
                {"Kertajaya3", "Kertajaya2"},
                {"Kertajaya3", "Sulawesi"},
                {"Sulawesi", "Kertajaya3"},
                {"Sulawesi", "Dinoyo"},
                {"Dinoyo", "Sulawesi"},
                {"Dinoyo", "Diponegoro"},
                {"Diponegoro", "Dinoyo"},
                {"Diponegoro", "Indragiri"},
                {"Indragiri", "Diponegoro"},
                {"Indragiri", "Mayjen_Sungkono1"},
                {"Mayjen_Sungkono1", "Indragiri"},
                {"Mayjen_Sungkono1", "Mayjen_Sungkono2"},
                {"Mayjen_Sungkono2", "Mayjen_Sungkono1"},
                {"Mayjen_Sungkono2", "Mayjen_Sungkono3"},
                {"Mayjen_Sungkono3", "Mayjen_Sungkono2"},
                {"Mayjen_Sungkono3", "Voza_Tower"},
                {"Voza_Tower", "Mayjen_Sungkono3"},
                {"Perumdos", "Manyar"},
                {"Manyar", "Perumdos"},
                {"Kertajaya1", "Manyar"},
                {"Manyar", "Kertajaya1"},
                {"Manyar", "Semolowaru1"},
                {"Semolowaru1", "Manyar"},
                {"Semolowaru1", "Semolowaru2"},
                {"Semolowaru2", "Semolowaru1"},
                {"Semolowaru2", "Nginden_Semolo"},
                {"Nginden_Semolo", "Semolowaru2"},
                {"Nginden_Semolo", "Manyar_Rejo"},
                {"Manyar_Rejo", "Nginden_Semolo"},
                {"Manyar_Rejo", "Ngagel_Jaya_Selatan"},
                {"Ngagel_Jaya_Selatan", "Manyar_Rejo"},
                {"Ngagel_Jaya_Selatan", "Bung_Tomo"},
                {"Bung_Tomo", "Ngagel_Jaya_Selatan"},
                {"Bung_Tomo", "Bengawan"},
                {"Bengawan", "Bung_Tomo"},
                {"Bengawan", "Kutai1"},
                {"Kutai1", "Bengawan"},
                {"Kutai1", "Kutai2"},
                {"Kutai2", "Kutai1"},
                {"Kutai2", "Indragiri"},
                {"Indragiri", "Kutai2"},
                {"Sulawesi", "Pandegiling"},
                {"Pandegiling", "Sulawesi"},
                {"Pandegiling", "Dukuh_Kupang"},
                {"Dukuh_Kupang", "Pandegiling"},
                {"Dukuh_Kupang", "Mayjen_Sungkono2"},
                {"Mayjen_Sungkono2", "Dukuh_Kupang"},
                {"Galaxy_Mall3", "Kertajaya1"},
                {"Kertajaya1", "Galaxy_Mall3"},
                {"Harris_Hotel", "Sulawesi"},
                {"Sulawesi", "Harris_Hotel"},
                {"IKEA_Ciputra_World", "Indragiri"},
                {"Indragiri", "IKEA_Ciputra_World"},
                {"Soto_Ayam_Lamongan_Cak_Har", "Semolowaru1"},
                {"Semolowaru1", "Soto_Ayam_Lamongan_Cak_Har"},
        };


        NodeNameManager nm = new NodeNameManager();
        for (String name : Nodes){
            nm.add(name);
        }
        int numNodes = Nodes.length;
        int numEdges = Edges.length;


        int[][] edges = new int[numEdges][2];
        int[] vehicles = new int[numEdges];
        String[] edgeNames = new String[numEdges];


        Random rand = new Random();


        //Convert nama node ke index + randomisasi jumlah kendaraan
        for (int i = 0; i < numEdges; i++) {
            String u = Edges[i][0];
            String v = Edges[i][1];


            int uIndex = nm.indexOf(u);
            int vIndex = nm.indexOf(v);


            edges[i][0] = uIndex;
            edges[i][1] = vIndex;


            edgeNames[i] = "Road " + u + " ---- " + v;


            //randomisasi kendaraan min 3, maks 25
            vehicles[i] = rand.nextInt(23) + 3;
        }


        showAvailableLocations(AvailableLocations);


        //tanya user start location dan destination locaationnya
        int source = readValidNode("Enter starting location: ", nm);
        int dest = readValidNode("Enter destination location: ", nm);


        //simulator
        TrafficLightSimulator sim = new TrafficLightSimulator(numNodes, vehicles);
        sim.buildGraph(edges);


        //print details
        AsciiGraphRenderer.printGraph(nm, edges, edgeNames, vehicles);
        AsciiGraphRenderer.printVehicleTable(edgeNames, vehicles, sim.getSortedVehiclesDescending());
        AsciiGraphRenderer.printDurationTable(nm, edges, vehicles, sim.getDurations(), sim.getSortedDurationsDescending());


        //output path
        var path = sim.shortestPath(source, dest);
        System.out.print("Path: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(nm.nameOf(path.get(i)));
            if (i < path.size() - 1) {
                System.out.print(" ------> ");
            }
        }
        System.out.println();


        int totalDuration = sim.totalDuration(source, dest);
        System.out.println("Total Duration: " + totalDuration + " secs");


        //show effectiveness
        double AVG = 120.0;
        double ideal = AVG * path.size();
        double eff;


        if (totalDuration <= ideal)
            eff = ((ideal-totalDuration)/ideal)*100.0;
        else
            eff = -((totalDuration-ideal)/ideal)*100.0;


        System.out.println("\n=== TRAFFIC LIGHT EFFECTIVENESS ===");
        System.out.printf("Route With Average Traffic Light Duration: %.2f secs\n", ideal);
        System.out.printf("Route With Optimized Traffic Light Duration: %d secs\n", totalDuration);
        System.out.println();
        System.out.printf("Effectiveness: %.2f%%\n", eff);


        if (eff == 0) System.out.println("Performance: AVERAGE");
        else if (eff > 0 && eff < 40) System.out.println("Performance: GOOD");
        else if (eff >= 40 && eff < 80) System.out.println("Performance: GREAT");
        else if (eff >= 80) System.out.println("Performance: EXCELLENT");
        else if (eff > -40) System.out.println("Performance: BELOW AVERAGE");
        else if (eff > -100) System.out.println("Performance: POOR");
        else System.out.println("Performance: VERY POOR");
    }


    private static void showAvailableLocations(String[] nodes) {
        System.out.println("\n=== AVAILABLE LOCATIONS ===");


        int cols = 3; // number of columns
        for (int i = 0; i <nodes.length; i++) {
            System.out.printf("%-35s", nodes[i]);


            if ((i+1)%cols == 0 || i == nodes.length-1) {
                System.out.println();
            }
        }
        System.out.println();
    }


    // mengecek apakah node yg ditulis valid atau tidak
    private static int readValidNode(String msg, NodeNameManager nm) {
        while (true) {
            System.out.print(msg);
            String name = sc.nextLine().trim();


            int idx = nm.indexOf(name);
            if (idx == -1) System.out.println("Junction not found.");
            else return idx;
        }
    }
}



