package pekan9_2511532029;

import java.util.*;

public class GraphTraversal_2511532029 {
    private Map<String, List<String>> graph_2029 = new HashMap<>();

    // Menambahkan edge (graf tak berarah)
    public void addEdge_2029(String node1_2029, String node2_2029) {
        graph_2029.putIfAbsent(node1_2029, new ArrayList<>());
        graph_2029.putIfAbsent(node2_2029, new ArrayList<>());
        graph_2029.get(node1_2029).add(node2_2029);
        graph_2029.get(node2_2029).add(node1_2029);
    }

    // Menampilkan graf awal
    public void printGraph_2029() {
        System.out.println("Graf Awal (Adjacency List):");
        for (String node_2029 : graph_2029.keySet()) {
            System.out.print(node_2029 + " -> ");
            List<String> neighbors_2029 = graph_2029.get(node_2029);
            System.out.println(String.join(", ", neighbors_2029));
        }
        System.out.println();
    }

    // DFS rekursif
    public void dfs_2029(String start_2029) {
        Set<String> visited_2029 = new HashSet<>();
        System.out.println("Penelusuran DFS:");
        dfsHelper_2029(start_2029, visited_2029);
        System.out.println();
    }

    private void dfsHelper_2029(String current_2029, Set<String> visited_2029) {
        if (visited_2029.contains(current_2029)) return;

        visited_2029.add(current_2029);
        System.out.print(current_2029 + " ");

        for (String neighbor_2029 : graph_2029.getOrDefault(current_2029, new ArrayList<>())) {
            dfsHelper_2029(neighbor_2029, visited_2029);
        }
    }

    // BFS iteratif
    public void bfs_2029(String start_2029) {
        Set<String> visited_2029 = new HashSet<>();
        Queue<String> queue_2029 = new LinkedList<>();

        queue_2029.add(start_2029);
        visited_2029.add(start_2029);

        System.out.println("Penelusuran BFS:");
        while (!queue_2029.isEmpty()) {
            String current_2029 = queue_2029.poll();
            System.out.print(current_2029 + " ");

            for (String neighbor_2029 : graph_2029.getOrDefault(current_2029, new ArrayList<>())) {
                if (!visited_2029.contains(neighbor_2029)) {
                    queue_2029.add(neighbor_2029);
                    visited_2029.add(neighbor_2029);
                }
            }
        }
        System.out.println();
    }

    // Main
    public static void main(String[] args_2029) {
        GraphTraversal_2511532029 graph_2029 = new GraphTraversal_2511532029();

        // Contoh graf: A-B, A-C, B-D, B-E
        graph_2029.addEdge_2029("A", "B");
        graph_2029.addEdge_2029("A", "C");
        graph_2029.addEdge_2029("B", "D");
        graph_2029.addEdge_2029("B", "E");

        // Cetak graf awal
        System.out.println("Graf Awal adalah: ");
        graph_2029.printGraph_2029();

        // Lakukan penelusuran
        graph_2029.dfs_2029("A");
        graph_2029.bfs_2029("A");
    }
}