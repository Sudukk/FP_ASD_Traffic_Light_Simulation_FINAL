package graph;

import java.util.*;

// Edge Class
class Edge {
    int from, to, weight;

    Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

// Graph Class
public class Graph {
    private final int n; //jumlah node
    private final List<List<Edge>> adj; //adjacency list untuk Dijkstra
    private final List<Edge> edges; //list semua edge

    public Graph(int n) {
        this.n = n; //simpan jumlah node
        adj = new ArrayList<>(); //inisialisasi adjacency list
        edges = new ArrayList<>(); //inisialisasi edge list
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>()); //buat list kosong per node
        }
    }

    // Add directed edge u -> v
    public void addEdge(int u, int v, int weight) {
        adj.get(u).add(new Edge(u, v, weight)); //tambahkan ke adjacency list
        edges.add(new Edge(u, v, weight)); //tambahkan ke edge list
    }

    // Dijkstra's Algorithm
    public int[] dijkstra(int start, int[] parent) {
        int[] dist = new int[n]; //array jarak terpendek
        boolean[] visited = new boolean[n]; //array visited
        Arrays.fill(dist, Integer.MAX_VALUE); //inisialisasi jarak tak terhingga
        Arrays.fill(parent, -1); //inisialisasi parent
        dist[start] = 0; //jarak start ke start = 0

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); //priority queue based on distance
        pq.add(new int[]{start, 0}); //masukkan start node ke PQ

        while (!pq.isEmpty()) {
            int[] cur = pq.poll(); //ambil node dengan jarak terkecil
            int u = cur[0]; //node saat ini

            if (visited[u]) continue; //skip jika sudah visited
            visited[u] = true; //tandai node sebagai visited

            for (Edge e : adj.get(u)) { //cek semua tetangga u
                int v = e.to; //node tujuan
                int w = e.weight; //bobot edge

                //relaxasi edge jika ditemukan jarak lebih kecil, intinya cek apakah lewat u lebih cepat ke v
                if (!visited[v] && dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w; //update jarak
                    parent[v] = u; //update parent
                    pq.add(new int[]{v, dist[v]}); //masukkan node tujuan ke PQ
                }
            }
        }
        return dist; //return jarak terpendek dari start ke semua node
    }

    // Path reconstruction
    public List<Integer> buildPath(int start, int end, int[] parent) {
        List<Integer> path = new ArrayList<>(); //list untuk menyimpan path

        if (parent[end] == -1 && start != end)
            return path; //tidak ada path jika parent[end]=-1 dan start!=end

        for (int at = end; at != -1; at = parent[at])
            path.add(at); //masukkan node dari end ke start

        Collections.reverse(path); //balik path supaya start -> end
        return path; //return path
    }
}
