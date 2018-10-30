package mandelbrot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bild {
	File file;
	public Bild(BufferedImage image, String path) {
		file = new File(path);
		try {
			ImageIO.write(image, "png", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
