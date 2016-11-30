import java.lang.Math;

public class Vector2 {

  public float x;
  public float y;

  /**
   * Creates a new two dimensional Vector.
   * @param   x x-coordinate of the Vector.
   * @param   y y-coordinate of the Vector.
   */
  public Vector2(float x, float y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Shorthand for writting "new Vector2(0.0f, 0.0f)".
   */
  public static Vector2 zero() {
    return new Vector2(0.0f, 0.0f);
  }

  /**
   * Shorthand for writting "new Vector2(0.0f, 1.0f)".
   */
  public static Vector2 up() {
    return new Vector2(0.0f, 1.0f);
  }

  /**
   * Shorthand for writting "new Vector2(0.0f, 1.0f)".
   */
  public static Vector2 down() {
    return new Vector2(0.0f, -1.0f);
  }

  /**
   * Shorthand for writting "new Vector2(-1.0f, 0.0f)".
   */
  public static Vector2 left() {
    return new Vector2(-1.0f, 0.0f);
  }

  /**
   * Shorthand for writting "new Vector2(1.0f, 0.0f)".
   */
  public static Vector2 right() {
    return new Vector2(1.0f, 0.0f);
  }

  /**
   * Returns the length of this vector.
   */
  public float magnitude() {
    return (float)Math.sqrt(this.x*this.x + this.y*this.y);
  }

  /**
   * Normalizes the vector.
   */
  public void normalize() {
    float m = magnitude();
    if (m > 0) {
      divide(m);
    }
  }

  /**
   * Clamps the magnitude of this vector.
   */
  public void clamp(float max) {
    if (magnitude() > max) {
      normalize();
      multiply(max);
    }
  }

  /**
   * Adds two vectors.
   */
  public void add(Vector2 other) {
    this.x += other.x;
    this.y += other.y;
  }

  /**
   * Subtracts two vectors.
   */
  public void subtract(Vector2 other) {
    this.x -= other.x;
    this.y -= other.y;
  }

  /**
   * Multiplies this vector by a constant.
   */
  public void multiply(float c) {
    this.x *= c;
    this.y *= c;
  }

  /**
   * Divides this vector by a constant.
   */
  public void divide(float c) {
    this.x /= c;
    this.y /= c;
  }

  /**
   * Scale this vector by another vector.
   */
  public void scale(Vector2 other) {
    this.x *= other.x;
    this.y *= other.y;
  }

  /**
   * Returns the between this vector and another.
   */
  public float distance(Vector2 other) {
    float dx = Math.abs(this.x - other.x);
    float dy = Math.abs(this.y - other.y);

    return (float)Math.sqrt(dx*dx + dy*dy);
  }

  /**
   *  Returns the distance between a and b.
   */
   public static float distance(Vector2 a, Vector2 b) {
     float dx = Math.abs(a.x - b.x);
     float dy = Math.abs(a.y - b.y);

     return (float)Math.sqrt(dx*dx + dy*dy);
   }
}
