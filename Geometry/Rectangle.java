public class Rectangle {

  private int x;
  private int y;
  private int w;
  private int h;

  /**
   * Creates a new rectangle at (x, y).
   * @param   x x-coordinate of the Rectangle.
   * @param   y y-coordinate of the Rectangle.
   * @param   w width of the Rectangle.
   * @param   h height of the Rectangle.
   */
  public Rectangle(int x, int y, int w, int h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }

  /**
   * 	The Highest point of the rectangle, measured from the X position.
   */
  public int getTop() {
    return this.x;
  }

  /**
   * The left-most point of the rectangle.
   */
  public int getLeft() {
    return this.y;
  }

  /**
   * The right-most point of the rectangle, measured from the X position.
   */
  public int getRight() {
    return (this.x + this.w);
  }

  /**
   * 	The lowest point of the rectangle, measured from the Y position.
   */
  public int getBottom() {
    return (this.y + this.h);
  }

  /**
   * [getWidth description]
   */
  public int getWidth() {
    return this.w;
  }

  /**
   * [getHeight description]
   */
  public int getHeight() {
    return this.h;
  }

  /**
   * Returns true if the other rectangle intersects this one.
   */
  public boolean intersects(Rectangle other) {
    return(
			(this.getTop() < other.getRight() && other.getTop() < this.getRight()) &&
			(this.getLeft() < other.getBottom() && other.getLeft() < this.getBottom())
		);
  }

  /**
   * Returns true if (x, y) is a point inside this rectangle.
   */
  public boolean contains(int x, int y) {
    return (
			(this.getTop() <= x && x <= this.getRight()) &&
			(this.getLeft() <= y && y <= this.getBottom())
		);
  }
}
