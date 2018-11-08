import java.awt.Color;
public class SeamCarver {
	private Picture picture;
	// create a seam carver object based on the given picture
	public SeamCarver(Picture pic) {
		this.picture = pic;
		if (picture == null) {
			System.out.println("picture is null");
		}
	}
	// current picture
	public Picture picture() {
		return picture;
	}
	// width of current picture
	public int width() {
		return picture.width();
	}

	// height of current picture
	public int height() {
		return picture.height();
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		if (x == 0 || x == width() - 1 || y == 0 || y == height() - 1) {
			return 1000;
		}
		return Math.sqrt(calculatesquare(picture.get(x - 1, y), picture.get(x + 1, y))
		+ calculatesquare(picture.get(x, y - 1), picture.get(x, y + 1)));
	}
	private double calculatesquare(Color c1, Color c2) {
		double red = c1.getRed() - c2.getRed();
		double green = c1.getGreen() - c2.getGreen();
		double blue = c1.getBlue() - c2.getBlue();
		return red * red + green * green + blue * blue;
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current pictureture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}