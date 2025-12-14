package simulation;


public class AsciiGraphRenderer {
    //Menampilkan hubungan node dan edge dalam bentuk ASCII
    public static void printGraph(NodeNameManager nm, int[][] edges, String[] edgeNames, int[] vehicles) {
        System.out.println("\n=== ASCII TRAFFIC JUNCTION ===");
        //print smeua nama node
        nm.printNodes();
        System.out.println("\nConnections:");


        //loop seluruh edge dan tampilkan koneksinya
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];//node asal
            int v = edges[i][1];//node tujuan


            System.out.println(" "+nm.nameOf(u) + " ---- " + edgeNames[i] +" (" + vehicles[i] + " cars) ----> " + nm.nameOf(v));
        }
    }


    //Buat tabel vehicle sorting dilakukan dengan mencocokkan urutan sortedVehiclesDesc
    public static void printVehicleTable(String[] edgeNames, int[] vehicles, int[] sortedVehiclesDesc
    ){
        System.out.println("\n=== VEHICLE TABLE (SORTED DESCENDING) ===");


        //mendapatkan urutan indeks hasil sorting
        Integer[] order = getSortOrder(vehicles, sortedVehiclesDesc);


        //cari panjang kolom maksimal untuk format tabel
        int maxLen = "Edge".length();
        for (String s : edgeNames) maxLen = Math.max(maxLen, s.length());


        String fmt = "%-" + maxLen + "s";
        String border = "+" + "-".repeat(maxLen + 2) + "+----------------+";


        System.out.println(border);
        System.out.printf("| " + fmt + " | %-14s |\n", "Road", "Num Vehicles");
        System.out.println(border);


        //print berdasarkan urutan sorted
        for (int idx : order) {
            System.out.printf("| " + fmt + " | %-14d |\n", edgeNames[idx], vehicles[idx]);
        }
        System.out.println(border);
    }


    //tabel menampilkan Node -> Edge -> Kendaraan -> Durasi secara descending
    public static void printDurationTable(
            NodeNameManager nm,
            int[][] edges,
            int[] vehicles,
            int[] durations,
            int[] sortedDurationsDesc
    ) {
        System.out.println("\n=== JUNCTION DURATION TABLE (SORTED DESCENDING) ===");


        Integer[] order = getSortOrder(durations, sortedDurationsDesc);


        int maxNodeLen = "Junction".length();
        int maxEdgeLen = "Road".length();


        for (int i = 0; i < edges.length; i++) {
            String from = nm.nameOf(edges[i][0]);
            String to   = nm.nameOf(edges[i][1]);


            if (from.compareTo(to) > 0) continue;


            maxNodeLen = Math.max(maxNodeLen, to.length());
            String road = from + " ---- " + to;
            maxEdgeLen = Math.max(maxEdgeLen, road.length());
        }


        String nodeFormat = "%-" + maxNodeLen + "s";
        String edgeFormat = "%-" + maxEdgeLen + "s";


        String border =
                "+" + "-".repeat(maxNodeLen + 2) +
                        "+" + "-".repeat(maxEdgeLen + 2) +
                        "+----------------+" +
                        "-----------------------------------+" +
                        "------------------------------------------+";


        System.out.println(border);
        System.out.printf(
                "| " + nodeFormat + " | " + edgeFormat +
                        " | %-14s | %-33s | %-40s |\n",
                "Junction",
                "Road",
                "Num Vehicles",
                "Average Red Light Duration (sec)",
                "Effective Red Light Duration (sec)"
        );
        System.out.println(border);


        final int AVERAGE_RED_LIGHT = 120;


        for (int idx : order) {
            String from = nm.nameOf(edges[idx][0]);
            String to   = nm.nameOf(edges[idx][1]);


            if (from.compareTo(to) > 0) continue;


            String road = from + " ---- " + to;


            System.out.printf(
                    "| " + nodeFormat + " | " + edgeFormat +
                            " | %-14d | %-33d | %-40d |\n",
                    to,
                    road,
                    vehicles[idx],
                    AVERAGE_RED_LIGHT,
                    durations[idx]
            );
        }


        System.out.println(border);
    }


    //menghasilkan urutan indeks hasil sorting merge sort
    private static Integer[] getSortOrder(int[] original, int[] sortedDesc) {


        Integer[] order = new Integer[sortedDesc.length];
        boolean[] used = new boolean[original.length]; //untuk menghindari duplikasi index


        //loop nilai sorted, cari index aslinya
        for (int i = 0; i < sortedDesc.length; i++) {
            int target = sortedDesc[i];
            for (int j = 0; j < original.length; j++) {
                //kalau nilai cocok dan belum dipakai -> simpan index-nya
                if (!used[j] && original[j] == target) {
                    order[i] = j;
                    used[j] = true;
                    break;
                }
            }
        }
        return order;
    }
}

