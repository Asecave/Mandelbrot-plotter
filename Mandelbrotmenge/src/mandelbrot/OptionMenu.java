package mandelbrot;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class OptionMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	JCheckBox box1;
	JButton button1;
	JButton button2;
	JButton button3;
	JLabel label;
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;
	JSlider slider;

	ChooseDir dir = new ChooseDir();

	boolean tick1 = false;

	public OptionMenu() {
		setFocusTraversalKeysEnabled(false);
	}

	public void openOptionMenu() {
		setTitle("Options");
		setVisible(false);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(OptionMenu.EXIT_ON_CLOSE);
		setSize(400, 360);
		setResizable(false);
		Handler handler = new Handler();

		int pos1 = -20;
		int pos2 = -20;

		label = new JLabel("  -------------------------------------------");
		label.setBounds(0, pos1 += 20, 199, 20);
		add(label);

		label = new JLabel("  Controls:");
		label.setBounds(0, pos1 += 20, 199, 20);
		add(label);

		label = new JLabel("  Arrow keys: move");
		label.setBounds(0, pos1 += 20, 199, 20);
		add(label);

		label = new JLabel("  H: toggle crosshair");
		label.setBounds(0, pos1 += 20, 199, 20);
		add(label);

		label = new JLabel("  +/-: Colour offset");
		label.setBounds(0, pos1 += 20, 199, 20);
		add(label);

		label = new JLabel("  Space/shift: zoom");
		label.setBounds(0, pos1 += 20, 199, 20);
		add(label);
		
		label = new JLabel("  Q/E: interations");
		label.setBounds(0, pos1 += 20, 199, 20);
		add(label);

		label = new JLabel("  -------------------------------------------");
		label.setBounds(0, pos1 += 20, 199, 20);
		add(label);

		label = new JLabel("  Current interations: " + Mandelbrot.INTERATIONS);
		label.setBounds(0, pos1 += 20, 199, 20);
		add(label);

		label = new JLabel("  Current zoom: " + Mandelbrot.SCALE);
		label.setBounds(0, pos1 += 20, 199, 20);
		add(label);

		label = new JLabel("  Zoom addition:");
		label.setBounds(0, pos1 += 20, 199, 20);
		add(label);

		tf1 = new JTextField();
		tf1.setBounds(0, pos1 += 20, 199, 20);
		add(tf1);

		label = new JLabel("  New interation number (optional):");
		label.setBounds(0, pos1 += 20, 199, 20);
		add(label);

		tf2 = new JTextField();
		tf2.setBounds(0, pos1 += 20, 199, 20);
		add(tf2);

		label = new JLabel("  Current width of image: " + Mandelbrot.WIDTH);
		label.setBounds(201, pos2 += 20, 199, 20);
		add(label);

		label = new JLabel("  Current height of image: " + Mandelbrot.HEIGHT);
		label.setBounds(201, pos2 += 20, 199, 20);
		add(label);

		label = new JLabel("  New width of image (optional):");
		label.setBounds(201, pos2 += 40, 199, 20);
		add(label);

		tf3 = new JTextField();
		tf3.setBounds(201, pos2 += 20, 199, 20);
		add(tf3);

		label = new JLabel("  New height of image (optional):");
		label.setBounds(201, pos2 += 20, 199, 20);
		add(label);

		tf4 = new JTextField();
		tf4.setBounds(201, pos2 += 20, 199, 20);
		add(tf4);

		label = new JLabel("Current colour offset: " + Mandelbrot.hueOffset);
		label.setBounds(201, pos2 += 20, 199, 20);
		add(label);

		label = new JLabel("New colour offset (optional):");
		label.setBounds(201, pos2 += 40, 199, 20);
		add(label);

		slider = new JSlider(0, 100);
		slider.setBounds(201, pos2 += 20, 199, 20);
		slider.setValue((int) (Mandelbrot.hueOffset * 100));
		add(slider);

		box1 = new JCheckBox("Render animation");
		box1.setBounds(201, pos2 += 20, 199, 20);
		add(box1);

		label = new JLabel("     (If not selected: single image)");
		label.setBounds(201, pos2 += 20, 199, 20);
		add(label);

		button3 = new JButton("Folder...");
		button3.setBounds(205, pos2 += 20, 90, 20);
		button3.addActionListener(handler);
		add(button3);

		button2 = new JButton("Render!");
		button2.setBounds(305, pos2, 90, 20);
		button2.addActionListener(handler);
		add(button2);

		label = new JLabel(
				"   ----------------------------------------------------------------------------------------------");
		label.setBounds(0, 280, 400, 20);
		add(label);

		button1 = new JButton("Back");
		button1.setBounds(160, 300, 80, 20);
		button1.addActionListener(handler);
		add(button1);
	}

	private class Handler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1 || e.getSource() == button2) {
				setVisible(false);
				if (isAlphabet(tf1.getText()))
					tf1.setText(Long.toString(0));
				if (isAlphabet(tf2.getText()))
					tf2.setText(Integer.toString(Mandelbrot.INTERATIONS));
				if (isAlphabet(tf3.getText()))
					tf3.setText(Integer.toString(Mandelbrot.WIDTH));
				if (isAlphabet(tf4.getText()))
					tf4.setText(Integer.toString(Mandelbrot.HEIGHT));
				Mandelbrot.animation = box1.isSelected();
				Mandelbrot.SCALE += Integer.parseInt(tf1.getText());
				Mandelbrot.INTERATIONS = Integer.parseInt(tf2.getText());
				if (Integer.parseInt(tf3.getText()) < Toolkit.getDefaultToolkit().getScreenSize().width)
					Mandelbrot.WIDTH = Integer.parseInt(tf3.getText());
				if (Integer.parseInt(tf3.getText()) < Toolkit.getDefaultToolkit().getScreenSize().width)
					Mandelbrot.HEIGHT = Integer.parseInt(tf4.getText());
				Mandelbrot.hueOffset = slider.getValue() / 100f;
				Mandelbrot.animation = box1.isSelected();
				Mandelbrot.frame.setSize(Mandelbrot.WIDTH, Mandelbrot.HEIGHT);
				if (e.getSource() == button2) {
					Mandelbrot.WIDTH = Integer.parseInt(tf3.getText());
					Mandelbrot.HEIGHT = Integer.parseInt(tf4.getText());
					Mandelbrot.frame.dispose();
					Mandelbrot.render = true;
				}
			}
			if (e.getSource() == button3) {
				Mandelbrot.folder = dir.getDir();
				if (!Mandelbrot.folder.equals("")) {
					button3.setText("Choosen!");
				}
			}
		}
	}

	public boolean isAlphabet(String text) {
		for (char c : text.toCharArray()) {
			// a - z
			if (c >= 'a' && c <= 'z')
				continue;
			// A - Z
			if (c >= 'A' && c <= 'Z')
				continue;
			// ö, ü, ä, ß
			if (c == 'ö' || c == 'ß' || c == 'ä' || c == 'ü')
				continue;
			return false;
		}
		return true;
	}
}
