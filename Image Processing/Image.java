import java.util.Arrays;

/**
 * Wrapper for PNM and PGM image formats.
 */
public class Image {

  private String metadata;
  private int maxRange;
  private Pixel[][] data;

  /**
   * Image Constructor.
   * @param   metadata metadata for the image.
   * @param   maxRange max range of pixel values.
   * @param   data multidimentional array of pixel data.
   */
  public Image(String metadata, int maxRange, Pixel[][] data) {
    if (maxRange < 0) {
      throw new IllegalArgumentException();
    }

    this.metadata = metadata;
    this.maxRange = maxRange;
    this.data = data;
  }

  /**
   * Returns the metadata found in the image.
   * @return String of the metadata found in the image.
   */
  public String getMetadata() {
    return this.metadata;
  }

  /*
   *
   */
  public int getMaxRange() {
    return this.maxRange;
  }

  /**
   * Returns the width of the image in pixels.
   * @return Width of the image in pixels.
   */
  public int getWidth() {
    return data[0].length;
  }

  /**
   * Returns the height of the image in pixels.
   * @return Height of the image in pixels.
   */
  public int getHeight() {
    return data.length;
  }

  /**
   * Returns the pixel at the given coordinate
   * @param   x x-coordinate
   * @param   y y-coordinate
   * @return  Pixel at (x,y)
   */
  public Pixel getPixel(int x, int y) {
    return this.data[y][x];
  }

  /**
   * Set the image to a grey scale.
   */
  public void toGrey() {
    for(int i = 0; i < this.getHeight(); i++) {
      for(int j = 0; j < this.getWidth(); j++) {
        data[i][j] = new Pixel(data[i][j].grey());
      }
    }
  }

  /**
   * Flips the image horizontally
   */
  public void flipHorizontal() {
    for (int i = 0; i < this.getHeight(); i++) {
      for (int j = 0; j < this.getWidth() / 2; j++) {
        Pixel temp = data[i][j];
        data[i][j] = data[i][this.getWidth() - j - 1];
        data[i][this.getWidth() - j - 1] = temp;
      }
    }
  }

  /**
   * Flips the image vertically.
   */
  public void flipVertical() {
    for (int i = 0; i < this.getHeight() / 2; i++) {
      for (int j = 0; j < this.getWidth(); j++) {
        Pixel temp = data[i][j];
        data[i][j] = data[this.getHeight() - i - 1][j];
        data[this.getHeight() - i - 1][j] = temp;
      }
    }
  }

  /**
   * Crops an image within the rectangle (x, y, w, h).
   * @param  x x-coordinate of crop bounds.
   * @param  y y-coordinate of crop bounds.
   * @param  w width of crop bounds.
   * @param  h height of crop bounds.
   */
  public void crop(int x, int y, int w, int h) {
    if((x < 0) || (y < 0) || (x > w) || (y > h)) {
      throw new IllegalArgumentException();
    }

    Pixel[][] temp = new Pixel[h-y][w-x];
    for (int i = 0; i < h; i++) {
      _data[i] = Arrays.copyOfRange(data[y+i], x, x+w);
    }

    data = temp;
  }
}
