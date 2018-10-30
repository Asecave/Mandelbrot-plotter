package mandelbrot;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class ChooseDir {

	JFileChooser dir;
	JButton open;
	JButton close;
	
	public String getDir() {
		dir = new JFileChooser();
		open = new JButton();
		close = new JButton();
		dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (dir.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
			return dir.getSelectedFile().getAbsolutePath();
		}
		return "";
	}
}
