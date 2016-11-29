
/**
 * Data wrapper for pixel color values.
 */
public class Pixel {

  private int red;
  private int green;
  private int blue;

  /**
   * Pixel Contructor
   * @param  red red value of pixel.
   * @param  green green value of pixel.
   * @param  blue blue value of pixel.
   */
  public Pixel(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Pixel Contructor
   * @param  intensity value of pixel intensity.
   */
  public Pixel(int intensity) {
    if((intensity < 0) || (intensity > 255)) {
      throw new IllegalArgumentException();
    }

    this.red = intensity;
    this.green = intensity;
    this.blue = intensity;
  }

  /**
   * Red pixel value.
   * @return Red pixel value
   */
  public int getRed() {
    return this.red;
  }

  /**
   * Green pixel value.
   * @return Green pixel value
   */
  public int getGreen() {
    return this.green;
  }

  /**
   * Blue pixel value.
   * @return Blue pixel value
   */
  public int getBlue() {
    return this.blue;
  }

  /**
   * Grey scale pixel value.
   * @return Grey scale pixel value
   */
  public int grey(){
    return ((red + green + blue) / 3);
  }
}
