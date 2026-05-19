package pekan7_2511532029;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class InsertionSortGUI_2511532029 extends JFrame {

    private static final long serialVersionUID = 1L;
    private int[] array_2029;
    private int[] originalArray_2029;   // salinan untuk reset
    private JLabel[] labelArray_2029;
    private JButton stepButton_2029, resetButton_2029, setButton_2029;
    private JTextField inputField_2029;
    private JPanel panelArray_2029;
    private JTextArea stepArea_2029;

    private int i_2029 = 1;          // indeks elemen yang sedang diproses
    private boolean sorting_2029 = false;
    private int stepCount_2029;

    public InsertionSortGUI_2511532029() {
        setTitle("Insertion Sort Langkah per Langkah");
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel input atas
        JPanel inputPanel_2029 = new JPanel(new FlowLayout());
        inputField_2029 = new JTextField(30);
        setButton_2029 = new JButton("Set Array");
        inputPanel_2029.add(new JLabel("Masukkan angka (pisahkan dengan koma):"));
        inputPanel_2029.add(inputField_2029);
        inputPanel_2029.add(setButton_2029);

        // Panel tengah untuk menampilkan array
        panelArray_2029 = new JPanel();
        panelArray_2029.setLayout(new FlowLayout());

        // Panel kontrol bawah (step, reset)
        JPanel controlPanel_2029 = new JPanel();
        stepButton_2029 = new JButton("Langkah Selanjutnya");
        resetButton_2029 = new JButton("Reset");
        stepButton_2029.setEnabled(false);
        controlPanel_2029.add(stepButton_2029);
        controlPanel_2029.add(resetButton_2029);

        // Area teks untuk log langkah
        stepArea_2029 = new JTextArea(10, 60);
        stepArea_2029.setEditable(false);
        stepArea_2029.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane_2029 = new JScrollPane(stepArea_2029);

        add(inputPanel_2029, BorderLayout.NORTH);
        add(panelArray_2029, BorderLayout.CENTER);
        add(controlPanel_2029, BorderLayout.SOUTH);
        add(scrollPane_2029, BorderLayout.EAST);

        // Event listeners
        setButton_2029.addActionListener(e -> setArrayFromInput_2029());
        stepButton_2029.addActionListener(e -> performStep_2029());
        resetButton_2029.addActionListener(e -> reset_2029());
    }

    // Membaca input dari field, memisahkan dengan koma
    private void setArrayFromInput_2029() {
        String text_2029 = inputField_2029.getText().trim();
        if (text_2029.isEmpty()) return;

        // Pisahkan dengan koma, hilangkan spasi di sekitarnya
        String[] parts_2029 = text_2029.split(",");
        int[] tempArray_2029 = new int[parts_2029.length];
        try {
            for (int k_2029 = 0; k_2029 < parts_2029.length; k_2029++) {
                tempArray_2029[k_2029] = Integer.parseInt(parts_2029[k_2029].trim());
            }
        } catch (NumberFormatException e_2029) {
            JOptionPane.showMessageDialog(this,
                    "Masukkan hanya angka yang dipisahkan dengan koma!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Simpan array asli dan array kerja
        array_2029 = tempArray_2029.clone();
        originalArray_2029 = tempArray_2029.clone();

        // Reset state sorting
        i_2029 = 1;
        stepCount_2029 = 1;
        sorting_2029 = true;
        stepButton_2029.setEnabled(true);
        stepArea_2029.setText("");

        // Tampilkan array di GUI
        updateLabels_2029();

        // Fokus ke tombol step
        stepButton_2029.requestFocus();
    }

    // Melakukan satu langkah Insertion Sort
    private void performStep_2029() {
        if (!sorting_2029 || i_2029 >= array_2029.length) {
            if (i_2029 >= array_2029.length) {
                stepButton_2029.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Sorting Selesai!");
            }
            return;
        }

        int key_2029 = array_2029[i_2029];
        int j_2029 = i_2029 - 1;

        StringBuilder stepLog_2029 = new StringBuilder();
        stepLog_2029.append("Langkah ").append(stepCount_2029)
               .append(" - Menyisipkan ").append(key_2029).append(":\n");

        // Geser elemen yang lebih besar dari key ke kanan
        while (j_2029 >= 0 && array_2029[j_2029] > key_2029) {
            array_2029[j_2029 + 1] = array_2029[j_2029];
            j_2029--;
        }
        array_2029[j_2029 + 1] = key_2029;

        // Perbarui tampilan array
        updateLabels_2029();

        stepLog_2029.append("Hasil  : ").append(arrayToString(array_2029)).append("\n\n");
        stepArea_2029.append(stepLog_2029.toString());

        i_2029++;
        stepCount_2029++;

        // Jika semua elemen sudah terurut
        if (i_2029 == array_2029.length) {
            sorting_2029 = false;
            stepButton_2029.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Sorting Selesai!");
        }
    }

    // Mereset ke array awal (belum terurut)
    private void reset_2029() {
        if (originalArray_2029 == null) return;

        // Kembalikan array ke keadaan awal
        array_2029 = originalArray_2029.clone();

        // Reset variabel sorting
        i_2029 = 1;
        stepCount_2029 = 1;
        sorting_2029 = true;
        stepButton_2029.setEnabled(true);
        stepArea_2029.setText("");

        // Tampilkan ulang array
        updateLabels_2029();
    }

    // Memperbarui tampilan JLabel berdasarkan array_2029 saat ini
    private void updateLabels_2029() {
        panelArray_2029.removeAll();
        if (array_2029 == null) {
            panelArray_2029.revalidate();
            panelArray_2029.repaint();
            return;
        }

        labelArray_2029 = new JLabel[array_2029.length];
        for (int k = 0; k < array_2029.length; k++) {
            labelArray_2029[k] = new JLabel(String.valueOf(array_2029[k]));
            labelArray_2029[k].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray_2029[k].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_2029[k].setPreferredSize(new Dimension(50, 50));
            labelArray_2029[k].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_2029.add(labelArray_2029[k]);
        }

        panelArray_2029.revalidate();
        panelArray_2029.repaint();
    }

    // Mengubah array menjadi string untuk log
    private String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < arr.length; k++) {
            sb.append(arr[k]);
            if (k < arr.length - 1) sb.append(", ");
        }
        return sb.toString();
    }

    public static void main(String[] args_2029) {
        SwingUtilities.invokeLater(() -> {
            InsertionSortGUI_2511532029 gui_2029 = new InsertionSortGUI_2511532029();
            gui_2029.setVisible(true);
        });
    }
}