package mandelbrot;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ProgressBar extends JPanel {
	private static final long serialVersionUID = 1L;
	
	static JFrame frame;
	
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	
	private JProgressBar bar;
	
	public ProgressBar() {
		frame = new JFrame();
		frame.setLayout(null);
		frame.setTitle("Render progress");
		frame.setSize(400, 140);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(this);
		bar = new JProgressBar(0, 100);
		bar.setStringPainted(true);
		bar.setBounds(5, 85, 380, 20);
		frame.add(bar);
		
		label1.setText("Rendering...   (This could take a while.)");
		label1.setBounds(5, 0, 400, 20);
		frame.add(label1);
		
		label2.setText("Path:                                               "+Mandelbrot.folder);
		label2.setBounds(5, 20, 400, 20);
		frame.add(label2);
		
		label3.setBounds(5, 40, 400, 20);
		frame.add(label3);
		
		label4.setText("Progress:");
		label4.setBounds(5, 66, 400, 20);
		frame.add(label4);
	}
	
	public void refresh() {
		if (Mandelbrot.imageNum < 10) {
			label3.setText("Currently processing: "+"               mbm000"+Mandelbrot.imageNum+".png");
		}else if (Mandelbrot.imageNum < 100) {
			label3.setText("Currently processing: "+"               mbm00"+Mandelbrot.imageNum+".png");
		}else if (Mandelbrot.imageNum < 1000) {
			label3.setText("Currently processing: "+"mbm0"+Mandelbrot.imageNum+".png");
		}else if (Mandelbrot.imageNum < 10000) {
			label3.setText("Currently processing: "+"mbm"+Mandelbrot.imageNum+".png");
		}
	}

	public void setValue(int value) {
		bar.setValue(value);
	}
	
	public int getValue() {
		return bar.getValue();
	}
}