import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener {

	private JPanel panel;
	private JButton start;
	private JButton[][] array;
	private boolean[][] ar;

	@SuppressWarnings("deprecation")
	private Main(int x, int y) {
		super("Game of life!");
		JTextField username = new JTextField();
		Object[] message = { "Write reguly:", username, };

		int option = JOptionPane.showConfirmDialog(null, message, "Options", JOptionPane.OK_CANCEL_OPTION);
		String reguly = username.getText();

		byte[] life = reguly.split("/")[1].getBytes();
		byte[] death = reguly.split("/")[0].getBytes();
		
		for (int i = 0; i < life.length; i++)
			life[i] -= 48;
		for (int i = 0; i < death.length; i++)
			death[i] -= 48;

		panel = new JPanel();
		panel.setLayout(new GridLayout(x, y));
		array = new JButton[x][y];
		ar = new boolean[x][y];
		
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++) {
				array[i][j] = new JButton();
				array[i][j].setPreferredSize(new Dimension(10, 10));
				array[i][j].addActionListener(this);
				array[i][j].setBackground(Color.darkGray);
				ar[i][j] = false;
				panel.add(array[i][j]);
			}
		setLayout(new BorderLayout());
		add(panel, BorderLayout.PAGE_START);

		start = new JButton("GO");
		start.setPreferredSize(new Dimension(x * 20, 50));
		start.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			int count;
			boolean[] keys = new boolean[death.length];
			boolean key;
			boolean[] keys1 = new boolean[life.length];
			for (int i = 0; i < x; i++)
				for (int j = 0; j < y; j++)
					if (array[i][j].getBackground().equals(Color.red))
						ar[i][j] = true;
					else
						ar[i][j] = false;
			for (int i = 0; i < x; i++)
				for (int j = 0; j < y; j++) {
					count = 0;
					if (ar[(i - 1 + x) % x][j])
						count++;
					if (ar[(i + 1 + x) % x][j])
						count++;
					if (ar[i][(j + 1 + y) % y])
						count++;
					if (ar[i][(j - 1 + y) % y])
						count++;
					if (ar[(i - 1 + x) % x][(j + 1 + y) % y])
						count++;
					if (ar[(i - 1 + x) % x][(j - 1 + y) % y])
						count++;
					if (ar[(i + 1 + x) % x][(j + 1 + y) % y])
						count++;
					if (ar[(i + 1 + x) % x][(j - 1 + y) % y])
						count++;
					key = true;
					for (int k = 0; k < life.length; k++) {
						if (count == life[k] && !ar[i][j])
							keys1[k] = false;
						else
							keys1[k] = true;
						key = key && keys1[k];

					}
					if (!key)
						array[i][j].setBackground(Color.red);
					if (ar[i][j]) {
						key = true;
						for (int k = 0; k < death.length; k++) {

							if (ar[i][j] && count == death[k])
								keys[k] = false;
							else
								keys[k] = true;
							key = key && keys[k];

						}
						if (key)
							array[i][j].setBackground(Color.darkGray);
					}
				}
			}

		});

		add(start, BorderLayout.PAGE_END);

		pack();
		show();
	}

	public static void main(String[] args) {
		try {
			new Main(30, 30);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((JButton) e.getSource()).setBackground(Color.red);

	}
}