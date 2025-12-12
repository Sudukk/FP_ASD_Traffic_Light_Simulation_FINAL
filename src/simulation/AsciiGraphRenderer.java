package simulation;

public class AsciiGraphRenderer {
    //Menampilkan hubungan node dan edge dalam bentuk ASCII
    public static void printGraph(NodeNameManager nm, int[][] edges, String[] edgeNames, int[] vehicles) {
        System.out.println("\n=== ASCII TRAFFIC JUNCTION ===");
        // Print smeua nama node
        nm.printNodes();
        System.out.println("\nConnections:");

        // Loop seluruh edge dan tampilkan koneksinya
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];   // node asal
            int v = edges[i][1];   // node tujuan

            System.out.println(" "+nm.nameOf(u) + " ---- " + edgeNames[i] +" (" + vehicles[i] + " cars) ----> " + nm.nameOf(v));
        }
    }

    //Buat tabel vehicle sorting dilakukan dengan mencocokkan urutan sortedVehiclesDesc
    public static void printVehicleTable(
            String[] edgeNames,
            int[] vehicles,
            int[] sortedVehiclesDesc
    ) {
        System.out.println("\n=== VEHICLE TABLE (SORTED DESCENDING) ===");

        // Mendapatkan urutan indeks hasil sorting
        Integer[] order = getSortOrder(vehicles, sortedVehiclesDesc);

        // Cari panjang kolom maksimal untuk format tabel
        int maxLen = "Edge".length();
        for (String s : edgeNames) maxLen = Math.max(maxLen, s.length());

        String fmt = "%-" + maxLen + "s";
        String border = "+" + "-".repeat(maxLen + 2) + "+----------------+";

        System.out.println(border);
        System.out.printf("| " + fmt + " | %-14s |\n", "Road", "Num Vehicles");
        System.out.println(border);

        // Print berdasarkan urutan sorted
        for (int idx : order) {
            System.out.printf("| " + fmt + " | %-14d |\n", edgeNames[idx], vehicles[idx]);
        }
        System.out.println(border);
    }

    //Tabel menampilkan Node -> Edge -> Kendaraan -> Durasi secara descending
    public static void printDurationTable(
            NodeNameManager nm,
            int[][] edges,
            String[] edgeNames,
            int[] vehicles,
            int[] durations,
            int[] sortedDurationsDesc
    ) {
        System.out.println("\n=== JUNCTION DURATION TABLE (SORTED DESCENDING) ===");

        // Dapatkan urutan index hasil sorting durasi
        Integer[] order = getSortOrder(durations, sortedDurationsDesc);

        // Hitung panjang kolom "Node" dan "Edge"
        int maxNodeLen = "Node".length();
        int maxEdgeLen = "Edge".length();

        for (int i = 0; i < edges.length; i++) {
            maxNodeLen = Math.max(maxNodeLen, nm.nameOf(edges[i][1]).length());
            String text = nm.nameOf(edges[i][0]) + " ---- " + nm.nameOf(edges[i][1]);
            maxEdgeLen = Math.max(maxEdgeLen, text.length());
        }

        String nodeFmt = "%-"+maxNodeLen+"s";
        String edgeFmt = "%-"+maxEdgeLen+"s";

        String border = "+" + "-".repeat(maxNodeLen + 2) + "+" + "-".repeat(maxEdgeLen + 2) + "+----------------+----------------+";
        System.out.println(border);

        // Header tabel
        System.out.printf("| " + nodeFmt + " | " + edgeFmt +" | %-14s | %-14s |\n", "Junction", "Road", "Num Vehicles", "Duration (sec)");
        System.out.println(border);

        // Print isi tabel sesuai urutan sorting
        for (int idx : order) {
            String from = nm.nameOf(edges[idx][0]);
            String to   = nm.nameOf(edges[idx][1]);
            String edgeText = from + " ---- " + to;
            System.out.printf("| "+nodeFmt + " | " + edgeFmt+" | %-14d | %-14d |\n", to, edgeText, vehicles[idx], durations[idx]);
        }
        System.out.println(border);
    }
    // Menghasilkan urutan indeks hasil sorting merge sort
    private static Integer[] getSortOrder(int[] original, int[] sortedDesc) {

        Integer[] order = new Integer[sortedDesc.length];
        boolean[] used = new boolean[original.length]; // untuk menghindari duplikasi index

        // Loop nilai sorted, cari index aslinya
        for (int i = 0; i < sortedDesc.length; i++) {
            int target = sortedDesc[i];
            for (int j = 0; j < original.length; j++) {
                // Jika nilai cocok dan belum dipakai → simpan index-nya
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