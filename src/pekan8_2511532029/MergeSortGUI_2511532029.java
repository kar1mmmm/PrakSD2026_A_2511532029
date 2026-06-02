package pekan8_2511532029;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import java.util.LinkedList;
import java.util.Queue;

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

public class MergeSortGUI_2511532029 extends JFrame {

    private static final long serialVersionUID_2029 = 1L;

    private int[] array_2029;
    private JLabel[] labelArray_2029;
    private JButton stepButton_2029, resetButton_2029, setButton_2029;
    private JTextField inputField_2029;
    private JPanel panelArray_2029;
    private JTextArea stepArea_2029;

    private int i_2029, j_2029, k_2029;
    private int left_2029, mid_2029, right_2029;
    private int[] temp_2029;

    private boolean isMerging_2029 = false;
    private boolean copying_2029 = false;
    private int stepCount_2029 = 1;

    private Queue<int[]> mergeQueue_2029 = new LinkedList<>();

    public MergeSortGUI_2511532029() {
        setTitle("Merge Sort Langkah per Langkah");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel input
        JPanel inputPanel_2029 = new JPanel(new FlowLayout());
        inputField_2029 = new JTextField(30);
        setButton_2029 = new JButton("Set Array");
        inputPanel_2029.add(new JLabel("Masukkan angka (pisahkan dengan koma):"));
        inputPanel_2029.add(inputField_2029);
        inputPanel_2029.add(setButton_2029);

        // Panel array visual
        panelArray_2029 = new JPanel();
        panelArray_2029.setLayout(new FlowLayout());

        // Panel kontrol
        JPanel controlPanel_2029 = new JPanel();
        stepButton_2029 = new JButton("Langkah Selanjutnya");
        resetButton_2029 = new JButton("Reset");
        stepButton_2029.setEnabled(false);
        controlPanel_2029.add(stepButton_2029);
        controlPanel_2029.add(resetButton_2029);

        // Area teks untuk log langkah-langkah
        stepArea_2029 = new JTextArea(8, 60);
        stepArea_2029.setEditable(false);
        stepArea_2029.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane_2029 = new JScrollPane(stepArea_2029);

        // Tambahkan panel ke frame
        add(inputPanel_2029, BorderLayout.NORTH);
        add(panelArray_2029, BorderLayout.CENTER);
        add(controlPanel_2029, BorderLayout.SOUTH);
        add(scrollPane_2029, BorderLayout.EAST);

        // Event Set Array
        setButton_2029.addActionListener(e_2029 -> setArrayFromInput_2029());

        // Event Langkah Selanjutnya
        stepButton_2029.addActionListener(e_2029 -> performStep_2029());

        // Event Reset
        resetButton_2029.addActionListener(e_2029 -> reset_2029());
    }

    private void setArrayFromInput_2029() {
        String text_2029 = inputField_2029.getText().trim();
        if (text_2029.isEmpty()) return;

        String[] parts_2029 = text_2029.split(",");
        array_2029 = new int[parts_2029.length];

        try {
            for (int i_2029 = 0; i_2029 < parts_2029.length; i_2029++) {
                array_2029[i_2029] = Integer.parseInt(parts_2029[i_2029].trim());
            }
        } catch (NumberFormatException e_2029) {
            JOptionPane.showMessageDialog(this, "Masukkan hanya angka!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        labelArray_2029 = new JLabel[array_2029.length];
        panelArray_2029.removeAll();

        for (int i_2029 = 0; i_2029 < array_2029.length; i_2029++) {
            labelArray_2029[i_2029] = new JLabel(String.valueOf(array_2029[i_2029]));
            labelArray_2029[i_2029].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray_2029[i_2029].setOpaque(true);
            labelArray_2029[i_2029].setBackground(Color.WHITE);
            labelArray_2029[i_2029].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_2029[i_2029].setPreferredSize(new Dimension(50, 50));
            labelArray_2029[i_2029].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_2029.add(labelArray_2029[i_2029]);
        }

        mergeQueue_2029.clear();
        generateMergeSteps_2029(0, array_2029.length - 1);

        stepButton_2029.setEnabled(true);
        stepArea_2029.setText("");
        stepCount_2029 = 1;
        isMerging_2029 = false;
        copying_2029 = false;

        panelArray_2029.revalidate();
        panelArray_2029.repaint();
    }

    private void generateMergeSteps_2029(int left_2029, int right_2029) {
        if (left_2029 < right_2029) {
            int mid_2029 = left_2029 + (right_2029 - left_2029) / 2;

            generateMergeSteps_2029(left_2029, mid_2029);
            generateMergeSteps_2029(mid_2029 + 1, right_2029);

            mergeQueue_2029.add(new int[] { left_2029, mid_2029, right_2029 });
        }
    }

    private void performStep_2029() {
        resetHighlights_2029();

        if (!isMerging_2029 && !mergeQueue_2029.isEmpty()) {
            int[] range_2029 = mergeQueue_2029.poll();

            left_2029 = range_2029[0];
            mid_2029 = range_2029[1];
            right_2029 = range_2029[2];

            temp_2029 = new int[right_2029 - left_2029 + 1];

            i_2029 = left_2029;
            j_2029 = mid_2029 + 1;
            k_2029 = 0;

            copying_2029 = false;
            isMerging_2029 = true;

            stepArea_2029.append(
                    "Langkah " + stepCount_2029++
                            + ": Mulai merge dari "
                            + left_2029 + " ke "
                            + right_2029 + "\n"
            );

            return;
        }

        if (isMerging_2029 && !copying_2029) {
            if (i_2029 <= mid_2029 && j_2029 <= right_2029) {
                labelArray_2029[i_2029].setBackground(Color.CYAN);
                labelArray_2029[j_2029].setBackground(Color.CYAN);

                if (array_2029[i_2029] <= array_2029[j_2029]) {
                    temp_2029[k_2029++] = array_2029[i_2029++];
                } else {
                    temp_2029[k_2029++] = array_2029[j_2029++];
                }

                stepArea_2029.append(
                        "Langkah " + stepCount_2029++
                                + ": Bandingkan dan salin elemen\n"
                );

                return;

            } else if (i_2029 <= mid_2029) {
                temp_2029[k_2029++] = array_2029[i_2029++];

                stepArea_2029.append(
                        "Langkah " + stepCount_2029++
                                + ": Salin sisa kiri\n"
                );

                return;

            } else if (j_2029 <= right_2029) {
                temp_2029[k_2029++] = array_2029[j_2029++];

                stepArea_2029.append(
                        "Langkah " + stepCount_2029++
                                + ": Salin sisa kanan\n"
                );

                return;

            } else {
                copying_2029 = true;
                k_2029 = 0;
                return;
            }
        }

        if (copying_2029 && k_2029 < temp_2029.length) {
            array_2029[left_2029 + k_2029] = temp_2029[k_2029];
            labelArray_2029[left_2029 + k_2029].setText(String.valueOf(temp_2029[k_2029]));
            labelArray_2029[left_2029 + k_2029].setBackground(Color.GREEN);
            k_2029++;

            stepArea_2029.append("Langkah " + stepCount_2029++ + ": Tempelkan ke array utama\n");
            return;
        }

        if (copying_2029 && k_2029 == temp_2029.length) {
            isMerging_2029 = false;
            copying_2029 = false;
        }

        if (mergeQueue_2029.isEmpty() && !isMerging_2029) {
            stepArea_2029.append("Selesai.\n");
            stepButton_2029.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Merge Sort selesai!");
        }
    }

    private void resetHighlights_2029() {
        if (labelArray_2029 == null) return;

        for (JLabel label_2029 : labelArray_2029) {
            label_2029.setBackground(Color.WHITE);
        }
    }

    private void reset_2029() {
        inputField_2029.setText("");
        panelArray_2029.removeAll();
        panelArray_2029.revalidate();
        panelArray_2029.repaint();
        stepArea_2029.setText("");
        stepButton_2029.setEnabled(false);
        mergeQueue_2029.clear();
        isMerging_2029 = false;
        copying_2029 = false;
        stepCount_2029 = 1;
    }

    public static void main(String[] args_2029) {
        SwingUtilities.invokeLater(() -> {
            MergeSortGUI_2511532029 frame_2029 = new MergeSortGUI_2511532029();
            frame_2029.setVisible(true);
        });
    }
}