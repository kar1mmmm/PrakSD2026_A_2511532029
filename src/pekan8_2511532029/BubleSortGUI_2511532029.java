package pekan8_2511532029;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
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

public class BubleSortGUI_2511532029 extends JFrame {

	private static final long serialVersionUID = 1L;
	private int[] array_2029;
	private JLabel[] labelArray_2029;
	JButton stepButton_2029;
	private JButton resetButton_2029;
	JButton setButton_2029;
	private JTextField inputField_2029;
	private JPanel panelArray_2029;
	private JTextArea stepArea_2029;

	private int i_2029 = 0, j_2029;
	private boolean sorting_2029 = false;
	private int stepCount_2029 = 1;

	public BubleSortGUI_2511532029() {
		setTitle("Bubble Sort Langkah per Langkah");
		setSize(750, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		JPanel inputPanel_2029 = new JPanel(new FlowLayout());
		inputField_2029 = new JTextField(30);
		setButton_2029 = new JButton("Set Array");

		inputPanel_2029.add(new JLabel("Masukkan angka (pisahkan dengan koma):"));
		inputPanel_2029.add(inputField_2029);
		inputPanel_2029.add(setButton_2029);

		panelArray_2029 = new JPanel();
		panelArray_2029.setLayout(new FlowLayout());

		JPanel controlPanel_2029 = new JPanel();
		stepButton_2029 = new JButton("Langkah Selanjutnya");
		resetButton_2029 = new JButton("Reset");
		stepButton_2029.setEnabled(false);
		controlPanel_2029.add(stepButton_2029);
		controlPanel_2029.add(resetButton_2029);

		stepArea_2029 = new JTextArea(8, 60);
		stepArea_2029.setEditable(false);
		stepArea_2029.setFont(new Font("Monospaced", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(stepArea_2029);

		getContentPane().add(inputPanel_2029, BorderLayout.NORTH);
		getContentPane().add(panelArray_2029, BorderLayout.CENTER);
		getContentPane().add(controlPanel_2029, BorderLayout.SOUTH);
		getContentPane().add(scrollPane, BorderLayout.EAST);

		setButton_2029.addActionListener(e -> setArrayFromInput_2029());
		stepButton_2029.addActionListener(e -> performStep_2029());
		resetButton_2029.addActionListener(e -> reset_2029());
	}

	private void setArrayFromInput_2029() {
		String text_2029 = inputField_2029.getText().trim();
		if (text_2029.isEmpty()) return;
		String[] parts_2029 = text_2029.split(",");
		array_2029 = new int[parts_2029.length];
		try {
			for (int k_2029 = 0; k_2029 < parts_2029.length; k_2029++) {
				array_2029[k_2029] = Integer.parseInt(parts_2029[k_2029].trim());
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Masukan hanya angka dipisahkan dengan koma!", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		i_2029 = 0;
		j_2029 = 0;
		stepCount_2029 = 1;
		sorting_2029 = true;
		stepButton_2029.setEnabled(true);
		stepArea_2029.setText("");
		panelArray_2029.removeAll();
		labelArray_2029 = new JLabel[array_2029.length];
		for (int k_2029 = 0; k_2029 < array_2029.length; k_2029++) {
			labelArray_2029[k_2029] = new JLabel(String.valueOf(array_2029[k_2029]));
			labelArray_2029[k_2029].setFont(new Font("Arial", Font.BOLD, 24));
			labelArray_2029[k_2029].setOpaque(true);
			labelArray_2029[k_2029].setBackground(Color.WHITE);
			labelArray_2029[k_2029].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			labelArray_2029[k_2029].setPreferredSize(new Dimension(50, 50));
			labelArray_2029[k_2029].setHorizontalAlignment(SwingConstants.CENTER);
			panelArray_2029.add(labelArray_2029[k_2029]);
		}
		panelArray_2029.revalidate();
		panelArray_2029.repaint();
	}

	private void performStep_2029() {
		if (!sorting_2029 || i_2029 >= array_2029.length - 1) {
			sorting_2029 = false;
			stepButton_2029.setEnabled(false);
			JOptionPane.showMessageDialog(this, "Sorting selesai!");
			return;
		}

		resetHighlights_2029();
		StringBuilder stepLog_2029 = new StringBuilder();

		labelArray_2029[j_2029].setBackground(Color.CYAN);
		labelArray_2029[j_2029 + 1].setBackground(Color.CYAN);

		if (array_2029[j_2029] > array_2029[j_2029 + 1]) {
			// swap
			int temp_2029 = array_2029[j_2029];
			array_2029[j_2029] = array_2029[j_2029 + 1];
			array_2029[j_2029 + 1] = temp_2029;

			labelArray_2029[j_2029].setBackground(Color.RED);
			labelArray_2029[j_2029 + 1].setBackground(Color.RED);

			stepLog_2029.append("Langkah ")
					.append(stepCount_2029)
					.append(": Menukar elemen ke-")
					.append(j_2029)
					.append(" (")
					.append(array_2029[j_2029 + 1])
					.append(") dengan ke-")
					.append(j_2029 + 1)
					.append(" (")
					.append(array_2029[j_2029])
					.append(")\n");
		} else {
			stepLog_2029.append("Langkah ")
					.append(stepCount_2029)
					.append(": Tidak ada pertukaran elemen ke-")
					.append(j_2029)
					.append(" dan ke-")
					.append(j_2029 + 1)
					.append("\n");
		}

		stepLog_2029.append("Hasil : ")
				.append(arrayToString_2029(array_2029))
				.append("\n\n");

		stepArea_2029.append(stepLog_2029.toString());

		updateLabels_2029();

		j_2029++;

		if (j_2029 >= array_2029.length - i_2029 - 1) {
			j_2029 = 0;
			i_2029++;
		}

		stepCount_2029++;

		if (i_2029 >= array_2029.length - 1) {
			sorting_2029 = false;
			stepButton_2029.setEnabled(false);
			JOptionPane.showMessageDialog(this, "Sorting selesai!");
		}
	}

	private void updateLabels_2029() {
		for (int k_2029 = 0; k_2029 < array_2029.length; k_2029++) {
			labelArray_2029[k_2029].setText(String.valueOf(array_2029[k_2029]));
		}
	}

	private void resetHighlights_2029() {
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
		sorting_2029 = false;
		i_2029 = 0;
		j_2029 = 0;
		stepCount_2029 = 1;
	}

	private String arrayToString_2029(int[] arr_2029) {
		StringBuilder sb_2029 = new StringBuilder();

		for (int k_2029 = 0; k_2029 < arr_2029.length; k_2029++) {
			sb_2029.append(arr_2029[k_2029]);

			if (k_2029 < arr_2029.length - 1)
				sb_2029.append(", ");
		}

		return sb_2029.toString();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BubleSortGUI_2511532029 frame = new BubleSortGUI_2511532029();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}