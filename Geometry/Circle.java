import java.lang.Math;

public class Circle {

  public int x;
  public int y;
  public float r;

  /**
   * Creates a new Circle.
   */
  public Circle(int x, int y, float r) {
    this.x = x;
    this.y = y;
    this.r = r;
  }

  /**
   * Returns true if the other circle intersects this one.
   */
  public boolean intersects(Circle other) {
    float dx = this.x - other.x;
    float dy = this.y - other.y;
    float rs = this.r + other.r;

    return ((dx*dx) + (dy*dy) <= (rs*rs));
  }

  /**
   * Returns true if (x, y) is a point inside this circle.
   */
  public boolean contains(int x, int y) {
    float dx = x - this.x;
    float dy = y - this.y;

    return ((dx*dx) + (dy*dy) <= (float)Math.pow(this.r, 2));
  }
}
