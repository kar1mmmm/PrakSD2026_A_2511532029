package pekan9_2511532029;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

/**
 * 
 * 
 * 
 * 
 */
public class BFSDFSMap_2511532029 extends JFrame {
    // Data graph
    private List<String> vertices_2029;
    private Map<String, List<String>> adjList_2029;
    private Map<String, Point> nodePositions_2029;
    
    // GUI components
    private GraphPanel_2029 graphPanel_2029;
    private JComboBox<String> startCombo_2029;
    private JComboBox<String> goalCombo_2029;
    private JTextArea resultArea_2029;
    
    public BFSDFSMap_2511532029() {
        initGraph_2029();
        initGUI_2029();
        setTitle("Pencarian Jalur - BFS & DFS (Labirin Bawah Laut + Stasiun Luar Angkasa)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /**
     * Graph unik & out of the box:
     * Menggabungkan stasiun luar angkasa dengan kota bawah laut.
     * Minimal 10 vertex, 15 edge.
     */
    private void initGraph_2029() {
        vertices_2029 = Arrays.asList(
            "Neptunus Gateway",      // stasiun luar angkasa
            "Mars Colony",           // koloni Mars
            "Europa Drill Station",  // stasiun pengeboran bulan Europa
            "Titan Floating City",   // kota di Titan
            "Atlantis Deep Sea",     // kota bawah laut
            "Leviathan Trench",      // palung laut dalam
            "Coral Highway",         // jalan bawah laut
            "Abyss Lab",             // laboratorium kegelapan laut
            "Space Elevator",        // penghubung darat-luar angkasa
            "Quantum Portal"         // portal fiksi antar-dimensi
        );
        
        adjList_2029 = new HashMap<>();
        for (String v : vertices_2029) {
            adjList_2029.put(v, new ArrayList<>());
        }
        
        // 15 edge (undirected) yang menghubungkan dunia luar angkasa & bawah laut
        addEdge_2029("Neptunus Gateway", "Mars Colony");
        addEdge_2029("Neptunus Gateway", "Space Elevator");
        addEdge_2029("Neptunus Gateway", "Quantum Portal");
        addEdge_2029("Mars Colony", "Europa Drill Station");
        addEdge_2029("Mars Colony", "Titan Floating City");
        addEdge_2029("Europa Drill Station", "Titan Floating City");
        addEdge_2029("Europa Drill Station", "Space Elevator");
        addEdge_2029("Titan Floating City", "Atlantis Deep Sea");
        addEdge_2029("Space Elevator", "Coral Highway");
        addEdge_2029("Atlantis Deep Sea", "Leviathan Trench");
        addEdge_2029("Atlantis Deep Sea", "Coral Highway");
        addEdge_2029("Leviathan Trench", "Abyss Lab");
        addEdge_2029("Coral Highway", "Abyss Lab");
        addEdge_2029("Coral Highway", "Quantum Portal");
        addEdge_2029("Abyss Lab", "Quantum Portal");
        
        // Posisi untuk visualisasi di panel 900x600
        nodePositions_2029 = new HashMap<>();
        nodePositions_2029.put("Neptunus Gateway", new Point(700, 80));
        nodePositions_2029.put("Mars Colony", new Point(550, 150));
        nodePositions_2029.put("Europa Drill Station", new Point(400, 220));
        nodePositions_2029.put("Titan Floating City", new Point(250, 200));
        nodePositions_2029.put("Atlantis Deep Sea", new Point(150, 350));
        nodePositions_2029.put("Leviathan Trench", new Point(80, 480));
        nodePositions_2029.put("Coral Highway", new Point(300, 450));
        nodePositions_2029.put("Abyss Lab", new Point(200, 550));
        nodePositions_2029.put("Space Elevator", new Point(500, 400));
        nodePositions_2029.put("Quantum Portal", new Point(650, 500));
    }
    
    private void addEdge_2029(String u, String v) {
        adjList_2029.get(u).add(v);
        adjList_2029.get(v).add(u);
    }
    
    private void initGUI_2029() {
        setLayout(new BorderLayout());
        
        // Panel kontrol atas
        JPanel controlPanel_2029 = new JPanel(new FlowLayout());
        controlPanel_2029.add(new JLabel("Start:"));
        startCombo_2029 = new JComboBox<>(vertices_2029.toArray(new String[0]));
        controlPanel_2029.add(startCombo_2029);
        controlPanel_2029.add(new JLabel("Goal:"));
        goalCombo_2029 = new JComboBox<>(vertices_2029.toArray(new String[0]));
        controlPanel_2029.add(goalCombo_2029);
        
        JButton bfsBtn_2029 = new JButton("BFS");
        JButton dfsBtn_2029 = new JButton("DFS");
        JButton resetBtn_2029 = new JButton("Reset");
        controlPanel_2029.add(bfsBtn_2029);
        controlPanel_2029.add(dfsBtn_2029);
        controlPanel_2029.add(resetBtn_2029);
        add(controlPanel_2029, BorderLayout.NORTH);
        
        // Area visualisasi graph dengan background putih
        graphPanel_2029 = new GraphPanel_2029();
        graphPanel_2029.setPreferredSize(new Dimension(900, 650));
        graphPanel_2029.setBackground(Color.WHITE);
        add(graphPanel_2029, BorderLayout.CENTER);
        
        // Area hasil pencarian dengan background putih
        resultArea_2029 = new JTextArea(10, 45);
        resultArea_2029.setEditable(false);
        resultArea_2029.setBackground(Color.WHITE);
        resultArea_2029.setForeground(Color.BLACK);
        resultArea_2029.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane_2029 = new JScrollPane(resultArea_2029);
        add(scrollPane_2029, BorderLayout.SOUTH);
        
        // Event handlers
        bfsBtn_2029.addActionListener(e -> runBFS_2029());
        dfsBtn_2029.addActionListener(e -> runDFS_2029());
        resetBtn_2029.addActionListener(e -> resetGraph_2029());
    }
    
    private void runBFS_2029() {
        String start_2029 = (String) startCombo_2029.getSelectedItem();
        String goal_2029 = (String) goalCombo_2029.getSelectedItem();
        if (start_2029 == null || goal_2029 == null) return;
        
        Queue<String> queue_2029 = new LinkedList<>();
        Set<String> visited_2029 = new HashSet<>();
        Map<String, String> parent_2029 = new HashMap<>();
        List<String> order_2029 = new ArrayList<>();
        
        queue_2029.add(start_2029);
        visited_2029.add(start_2029);
        parent_2029.put(start_2029, null);
        
        boolean found_2029 = false;
        while (!queue_2029.isEmpty()) {
            String cur = queue_2029.poll();
            order_2029.add(cur);
            if (cur.equals(goal_2029)) {
                found_2029 = true;
                break;
            }
            for (String neighbor : adjList_2029.get(cur)) {
                if (!visited_2029.contains(neighbor)) {
                    visited_2029.add(neighbor);
                    parent_2029.put(neighbor, cur);
                    queue_2029.add(neighbor);
                }
            }
        }
        
        List<String> path_2029 = buildPath_2029(parent_2029, start_2029, goal_2029, found_2029);
        displayResult_2029("BFS", order_2029, path_2029, visited_2029.size());
        graphPanel_2029.setVisitedAndPath_2029(visited_2029, path_2029, start_2029, goal_2029);
    }
    
    // Class pembantu untuk DFS agar parent tersimpan akurat
    class NodeInfo_2029 {
        String nodeId;
        String parentId;
        NodeInfo_2029(String nodeId, String parentId) {
            this.nodeId = nodeId;
            this.parentId = parentId;
        }
    }

    private void runDFS_2029() {
        String start_2029 = (String) startCombo_2029.getSelectedItem();
        String goal_2029 = (String) goalCombo_2029.getSelectedItem();
        if (start_2029 == null || goal_2029 == null) return;
        
        Stack<NodeInfo_2029> stack_2029 = new Stack<>();
        Set<String> visited_2029 = new HashSet<>();
        Map<String, String> parent_2029 = new HashMap<>();
        List<String> order_2029 = new ArrayList<>();
        
        // Push node pertama dengan parent null
        stack_2029.push(new NodeInfo_2029(start_2029, null));
        
        boolean found_2029 = false;
        while (!stack_2029.isEmpty()) {
            NodeInfo_2029 curInfo = stack_2029.pop();
            String cur = curInfo.nodeId;
            
            if (visited_2029.contains(cur)) continue;
            
            // Catat visited, urutan, dan parent yang benar saat di-pop
            visited_2029.add(cur);
            order_2029.add(cur);
            parent_2029.put(cur, curInfo.parentId);
            
            if (cur.equals(goal_2029)) {
                found_2029 = true;
                break;
            }
            
            // Masukkan tetangga ke dalam stack
            for (String neighbor : adjList_2029.get(cur)) {
                if (!visited_2029.contains(neighbor)) {
                    stack_2029.push(new NodeInfo_2029(neighbor, cur));
                }
            }
        }
        
        List<String> path_2029 = buildPath_2029(parent_2029, start_2029, goal_2029, found_2029);
        displayResult_2029("DFS", order_2029, path_2029, visited_2029.size());
        graphPanel_2029.setVisitedAndPath_2029(visited_2029, path_2029, start_2029, goal_2029);
    }
    
    private List<String> buildPath_2029(Map<String, String> parent, String start, String goal, boolean found) {
        List<String> path = new ArrayList<>();
        if (!found) return path;
        String node = goal;
        while (node != null) {
            path.add(0, node);
            node = parent.get(node);
        }
        return path;
    }
    
    private void displayResult_2029(String algo, List<String> order, List<String> path, int explored) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ").append(algo).append(" pada Peta Luar Angkasa & Bawah Laut ===\n");
        sb.append("Urutan node dikunjungi: ").append(order).append("\n");
        sb.append("Jumlah node dieksplorasi: ").append(explored).append("\n");
        if (!path.isEmpty()) {
            sb.append("✨ Jalur ditemukan: ").append(String.join(" -> ", path)).append("\n");
        } else {
            sb.append("Peringatan: Tidak ada jalur dari start ke goal.\n");
        }
        resultArea_2029.setText(sb.toString());
    }
    
    public void resetGraph_2029() {
        graphPanel_2029.reset_2029();
        resultArea_2029.setText("");
    }
    
    // Inner class untuk visualisasi graph dengan background putih
    class GraphPanel_2029 extends JPanel {
        private Set<String> visited_2029;
        private List<String> path_2029;
        private String start_2029, goal_2029;
        
        GraphPanel_2029() {
            visited_2029 = new HashSet<>();
            path_2029 = new ArrayList<>();
        }
        
        void setVisitedAndPath_2029(Set<String> vis, List<String> p, String s, String g) {
            visited_2029 = new HashSet<>(vis);
            path_2029 = new ArrayList<>(p);
            start_2029 = s;
            goal_2029 = g;
            repaint();
        }
        
        void reset_2029() {
            visited_2029.clear();
            path_2029.clear();
            start_2029 = null;
            goal_2029 = null;
            repaint();
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // Gambar edge (jalan antar lokasi)
            g2d.setColor(Color.DARK_GRAY);
            g2d.setStroke(new BasicStroke(2));
            for (String u : adjList_2029.keySet()) {
                Point p1 = nodePositions_2029.get(u);
                for (String v : adjList_2029.get(u)) {
                    Point p2 = nodePositions_2029.get(v);
                    g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
                }
            }
            
            // Gambar vertex
            for (String v : vertices_2029) {
                Point pos = nodePositions_2029.get(v);
                int d = 45;
                int x = pos.x - d/2;
                int y = pos.y - d/2;
                
                // Warna berdasarkan status
                if (path_2029.contains(v) && !v.equals(start_2029) && !v.equals(goal_2029)) {
                    g2d.setColor(new Color(0, 180, 0)); // hijau terang untuk jalur
                } else if (v.equals(start_2029)) {
                    g2d.setColor(Color.RED);
                } else if (v.equals(goal_2029)) {
                    g2d.setColor(Color.ORANGE);
                } else if (visited_2029.contains(v)) {
                    g2d.setColor(new Color(173, 216, 230)); // biru muda untuk dikunjungi
                } else {
                    g2d.setColor(new Color(255, 255, 150)); // kuning muda untuk belum dikunjungi
                }
                g2d.fillOval(x, y, d, d);
                g2d.setColor(Color.BLACK);
                g2d.drawOval(x, y, d, d);
                g2d.setFont(new Font("SansSerif", Font.BOLD, 10));
                FontMetrics fm = g2d.getFontMetrics();
                int tw = fm.stringWidth(v);
                g2d.drawString(v, pos.x - tw/2, pos.y + 5);
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BFSDFSMap_2511532029());
    }
}