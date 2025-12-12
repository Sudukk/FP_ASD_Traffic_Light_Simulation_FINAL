package simulation;

import graph.Graph;
import java.util.List;

public class TrafficLightSimulator {
    private Graph graph;
    private int numEdges;
    private int[] vehicles;
    private int[] durations;

    public TrafficLightSimulator(int numNodes, int[] vehicles) {
        this.graph = new Graph(numNodes);
        this.numEdges = vehicles.length;
        this.vehicles = vehicles;
        this.durations = new int[numEdges];

        for (int i = 0; i < numEdges; i++) {
            durations[i] = vehicles[i] / 2;
        }
    }

    public void buildGraph(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            graph.addEdge(edges[i][0], edges[i][1], durations[i]);
        }
    }

    public List<Integer> shortestPath(int start, int end) {
        int[] parent = new int[this.numEdges];
        graph.dijkstra(start, parent);
        return graph.buildPath(start, end, parent);
    }

    public int totalDuration(int start, int end) {
        int[] parent = new int[this.numEdges];
        int[] dist = graph.dijkstra(start, parent);
        return dist[end];
    }

    public int[] getDurations() {
        return durations;
    }

    public int[] getSortedVehiclesDescending() {
        return MergeSort.sortDescending(vehicles);
    }
    public int[] getSortedDurationsDescending() {
        return MergeSort.sortDescending(durations);
    }
}