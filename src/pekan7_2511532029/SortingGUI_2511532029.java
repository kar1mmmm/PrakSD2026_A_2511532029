package pekan7_2511532029;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class SortingGUI_2511532029 extends JFrame {
    private static final long serialVersionUID = 1L;

    // Data
    private ArrayList<Mahasiswa_2511532029> daftar_2029;
    private ArrayList<Mahasiswa_2511532029> originalList_2029;

    // State sorting
    private String currentAlgo_2029 = "Insertion Sort";
    private boolean sortingActive_2029 = false;
    private boolean sortingDone_2029 = false;

    // State Insertion Sort
    private int insertI_2029;
    // State Selection Sort
    private int selectI_2029, selectMinIdx_2029, selectJ_2029;
    // State Bubble Sort
    private int bubbleI_2029, bubbleJ_2029;
    private boolean bubbleSwapped_2029;

    // Komponen GUI
    private JTextField tfNama_2029, tfNim_2029, tfProdi_2029;
    private JButton btnTambah_2029, btnHapus_2029, btnStep_2029, btnReset_2029;
    private JComboBox<String> comboAlgo_2029;
    private JPanel panelData_2029;
    private JTextArea stepArea_2029;
    private int stepCount_2029;

    public SortingGUI_2511532029() {
        daftar_2029 = new ArrayList<>();
        originalList_2029 = new ArrayList<>();
        setTitle("Sorting Mahasiswa Step by Step - NIM 2511532029");
        setSize(950, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel input
        JPanel inputPanel_2029 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        inputPanel_2029.setBorder(BorderFactory.createTitledBorder("Input Mahasiswa"));
        tfNama_2029 = new JTextField(10);
        tfNim_2029 = new JTextField(10);
        tfProdi_2029 = new JTextField(10);
        btnTambah_2029 = new JButton("Tambah");
        btnHapus_2029 = new JButton("Hapus Pilih");
        inputPanel_2029.add(new JLabel("Nama:"));
        inputPanel_2029.add(tfNama_2029);
        inputPanel_2029.add(new JLabel("NIM:"));
        inputPanel_2029.add(tfNim_2029);
        inputPanel_2029.add(new JLabel("Prodi:"));
        inputPanel_2029.add(tfProdi_2029);
        inputPanel_2029.add(btnTambah_2029);
        inputPanel_2029.add(btnHapus_2029);

        // Panel data mahasiswa
        panelData_2029 = new JPanel();
        panelData_2029.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panelData_2029.setBorder(BorderFactory.createTitledBorder("Daftar Mahasiswa (klik nama untuk detail)"));

        // Panel kontrol sorting
        JPanel controlPanel_2029 = new JPanel(new FlowLayout());
        comboAlgo_2029 = new JComboBox<>(new String[]{"Insertion Sort", "Selection Sort", "Bubble Sort"});
        btnStep_2029 = new JButton("Langkah Selanjutnya");
        btnReset_2029 = new JButton("Reset ke Data Awal");
        controlPanel_2029.add(new JLabel("Pilih Algoritma:"));
        controlPanel_2029.add(comboAlgo_2029);
        controlPanel_2029.add(btnStep_2029);
        controlPanel_2029.add(btnReset_2029);

        // Area log
        stepArea_2029 = new JTextArea(15, 40);
        stepArea_2029.setEditable(false);
        stepArea_2029.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollPane_2029 = new JScrollPane(stepArea_2029);
        scrollPane_2029.setBorder(BorderFactory.createTitledBorder("Log Proses Sorting"));

        add(inputPanel_2029, BorderLayout.NORTH);
        add(new JScrollPane(panelData_2029), BorderLayout.CENTER);
        add(controlPanel_2029, BorderLayout.SOUTH);
        add(scrollPane_2029, BorderLayout.EAST);

        // Event listeners
        btnTambah_2029.addActionListener(e -> tambahData_2029());
        btnHapus_2029.addActionListener(e -> hapusData_2029());
        btnStep_2029.addActionListener(e -> stepSorting_2029());
        btnReset_2029.addActionListener(e -> resetSorting_2029());
        comboAlgo_2029.addActionListener(e -> gantiAlgoritma_2029());

        updatePanelData_2029();
    }

    private void tambahData_2029() {
        String nama = tfNama_2029.getText().trim();
        String nim = tfNim_2029.getText().trim();
        String prodi = tfProdi_2029.getText().trim();
        if (nama.isEmpty() || nim.isEmpty() || prodi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Mahasiswa_2511532029 m = new Mahasiswa_2511532029(nama, nim, prodi);
        daftar_2029.add(m);
        originalList_2029 = new ArrayList<>(daftar_2029);
        resetStateSorting_2029();
        updatePanelData_2029();
        clearInput_2029();
    }

    private void hapusData_2029() {
        if (daftar_2029.isEmpty()) return;
        String[] namaArray = new String[daftar_2029.size()];
        for (int i = 0; i < daftar_2029.size(); i++) {
            namaArray[i] = daftar_2029.get(i).getNama_2029();
        }
        String pilih = (String) JOptionPane.showInputDialog(this, "Pilih mahasiswa yang akan dihapus:",
                "Hapus Data", JOptionPane.QUESTION_MESSAGE, null, namaArray, namaArray[0]);
        if (pilih != null) {
            for (int i = 0; i < daftar_2029.size(); i++) {
                if (daftar_2029.get(i).getNama_2029().equals(pilih)) {
                    daftar_2029.remove(i);
                    break;
                }
            }
            originalList_2029 = new ArrayList<>(daftar_2029);
            resetStateSorting_2029();
            updatePanelData_2029();
        }
    }

    private void resetStateSorting_2029() {
        sortingActive_2029 = true;
        sortingDone_2029 = false;
        stepCount_2029 = 1;
        stepArea_2029.setText("");
        btnStep_2029.setEnabled(true);

        String algo = (String) comboAlgo_2029.getSelectedItem();
        currentAlgo_2029 = algo;
        if (algo.equals("Insertion Sort")) {
            insertI_2029 = 1;
        } else if (algo.equals("Selection Sort")) {
            selectI_2029 = 0;
            selectMinIdx_2029 = 0;
            selectJ_2029 = 1;
        } else if (algo.equals("Bubble Sort")) {
            bubbleI_2029 = 0;
            bubbleJ_2029 = 0;
            bubbleSwapped_2029 = false;
        }
    }

    private void resetSorting_2029() {
        if (originalList_2029.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Belum ada data!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        daftar_2029 = new ArrayList<>(originalList_2029);
        resetStateSorting_2029();
        updatePanelData_2029();
        log_2029("--- Reset ke data awal ---");
        log_2029("Urutan saat ini: " + formatNamaList_2029(daftar_2029));
    }

    private void gantiAlgoritma_2029() {
        if (originalList_2029.isEmpty()) return;
        daftar_2029 = new ArrayList<>(originalList_2029);
        resetStateSorting_2029();
        updatePanelData_2029();
        log_2029("=== Ganti algoritma menjadi " + comboAlgo_2029.getSelectedItem() + " ===");
        log_2029("Data direset ke urutan awal: " + formatNamaList_2029(daftar_2029));
    }

    private void stepSorting_2029() {
        if (!sortingActive_2029 || sortingDone_2029) {
            if (sortingDone_2029) {
                JOptionPane.showMessageDialog(this, "Sorting sudah selesai! Tekan Reset untuk mengulang.", "Info", JOptionPane.INFORMATION_MESSAGE);
                btnStep_2029.setEnabled(false);
            }
            return;
        }

        String algo = (String) comboAlgo_2029.getSelectedItem();
        boolean finished = false;

        if (algo.equals("Insertion Sort")) {
            finished = stepInsertionSort_2029();
        } else if (algo.equals("Selection Sort")) {
            finished = stepSelectionSort_2029();
        } else if (algo.equals("Bubble Sort")) {
            finished = stepBubbleSort_2029();
        }

        if (finished) {
            sortingDone_2029 = true;
            sortingActive_2029 = false;
            btnStep_2029.setEnabled(false);
            log_2029("\n*** SORTING SELESAI ***");
            log_2029("Hasil akhir terurut ascending: " + formatNamaList_2029(daftar_2029));
            JOptionPane.showMessageDialog(this, "Sorting selesai!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            updatePanelData_2029();
        }
    }

    private boolean stepInsertionSort_2029() {
        int n = daftar_2029.size();
        if (insertI_2029 >= n) return true;

        Mahasiswa_2511532029 key = daftar_2029.get(insertI_2029);
        int j = insertI_2029 - 1;
        while (j >= 0 && daftar_2029.get(j).getNama_2029().compareToIgnoreCase(key.getNama_2029()) > 0) {
            daftar_2029.set(j + 1, daftar_2029.get(j));
            j--;
        }
        daftar_2029.set(j + 1, key);

        log_2029("Langkah " + stepCount_2029 + " (Insertion) - menyisipkan '" + key.getNama_2029() + "'");
        log_2029("Hasil: " + formatNamaList_2029(daftar_2029));
        stepCount_2029++;
        insertI_2029++;
        return insertI_2029 >= n;
    }

    private boolean stepSelectionSort_2029() {
        int n = daftar_2029.size();
        if (selectI_2029 >= n - 1) return true;

        if (selectJ_2029 < n) {
            if (daftar_2029.get(selectJ_2029).getNama_2029().compareToIgnoreCase(daftar_2029.get(selectMinIdx_2029).getNama_2029()) < 0) {
                selectMinIdx_2029 = selectJ_2029;
            }
            selectJ_2029++;
            log_2029("Langkah " + stepCount_2029 + " (Selection) - membandingkan index " + (selectJ_2029-1) + " dengan min=" + selectMinIdx_2029);
            return false;
        } else {
            if (selectMinIdx_2029 != selectI_2029) {
                Mahasiswa_2511532029 temp = daftar_2029.get(selectI_2029);
                daftar_2029.set(selectI_2029, daftar_2029.get(selectMinIdx_2029));
                daftar_2029.set(selectMinIdx_2029, temp);
                log_2029("Langkah " + stepCount_2029 + " (Selection) - tukar posisi " + selectI_2029 + " dengan " + selectMinIdx_2029);
            } else {
                log_2029("Langkah " + stepCount_2029 + " (Selection) - tidak ada tukar untuk posisi " + selectI_2029);
            }
            log_2029("Hasil sementara: " + formatNamaList_2029(daftar_2029));
            stepCount_2029++;
            selectI_2029++;
            selectMinIdx_2029 = selectI_2029;
            selectJ_2029 = selectI_2029 + 1;
            return selectI_2029 >= n - 1;
        }
    }

    private boolean stepBubbleSort_2029() {
        int n = daftar_2029.size();
        if (bubbleI_2029 >= n - 1) return true;

        if (bubbleJ_2029 < n - bubbleI_2029 - 1) {
            if (daftar_2029.get(bubbleJ_2029).getNama_2029().compareToIgnoreCase(daftar_2029.get(bubbleJ_2029 + 1).getNama_2029()) > 0) {
                Mahasiswa_2511532029 temp = daftar_2029.get(bubbleJ_2029);
                daftar_2029.set(bubbleJ_2029, daftar_2029.get(bubbleJ_2029 + 1));
                daftar_2029.set(bubbleJ_2029 + 1, temp);
                bubbleSwapped_2029 = true;
                log_2029("Langkah " + stepCount_2029 + " (Bubble) - tukar " + daftar_2029.get(bubbleJ_2029 + 1).getNama_2029() +
                        " dengan " + daftar_2029.get(bubbleJ_2029).getNama_2029());
            } else {
                log_2029("Langkah " + stepCount_2029 + " (Bubble) - tidak tukar (" + daftar_2029.get(bubbleJ_2029).getNama_2029() +
                        " <= " + daftar_2029.get(bubbleJ_2029+1).getNama_2029() + ")");
            }
            bubbleJ_2029++;
            stepCount_2029++;
            return false;
        } else {
            log_2029("Pass " + (bubbleI_2029+1) + " selesai. Hasil: " + formatNamaList_2029(daftar_2029));
            if (!bubbleSwapped_2029) return true;
            bubbleI_2029++;
            bubbleJ_2029 = 0;
            bubbleSwapped_2029 = false;
            stepCount_2029++;
            return bubbleI_2029 >= n - 1;
        }
    }

    private void updatePanelData_2029() {
        panelData_2029.removeAll();
        if (daftar_2029.isEmpty()) {
            JLabel kosong_2029 = new JLabel("(Belum ada data)");
            kosong_2029.setFont(new Font("Arial", Font.ITALIC, 16));
            panelData_2029.add(kosong_2029);
        } else {
            for (Mahasiswa_2511532029 m : daftar_2029) {
                JLabel label_2029 = new JLabel(m.getNama_2029());
                label_2029.setFont(new Font("Arial", Font.BOLD, 18));
                label_2029.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                label_2029.setPreferredSize(new Dimension(120, 40));
                label_2029.setHorizontalAlignment(SwingConstants.CENTER);
                label_2029.setBackground(new Color(220, 240, 255));
                label_2029.setOpaque(true);
                label_2029.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        JOptionPane.showMessageDialog(panelData_2029,
                                "Nama: " + m.getNama_2029() + "\nNIM: " + m.getNim_2029() + "\nProdi: " + m.getProdi_2029(),
                                "Detail Mahasiswa", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
                panelData_2029.add(label_2029);
            }
        }
        panelData_2029.revalidate();
        panelData_2029.repaint();
    }

    private void log_2029(String msg) {
        stepArea_2029.append(msg + "\n");
        stepArea_2029.setCaretPosition(stepArea_2029.getDocument().getLength());
        System.out.println(msg);
    }

    private String formatNamaList_2029(ArrayList<Mahasiswa_2511532029> list) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).getNama_2029());
            if (i < list.size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    private void clearInput_2029() {
        tfNama_2029.setText("");
        tfNim_2029.setText("");
        tfProdi_2029.setText("");
        tfNama_2029.requestFocus();
    }

    public static void main(String[] args_2029) {
        SwingUtilities.invokeLater(() -> {
            new SortingGUI_2511532029().setVisible(true);
        });
    }
}