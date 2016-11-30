public class GeometryExamples {
  public static void main(String[] args) {
    testRectangle();
    testCircle();
  }

  public static void testRectangle() {
    System.out.println("\nTest Rectangles");
    Rectangle r1 = new Rectangle(0,0,5,5);
    Rectangle r2 = new Rectangle(2,2,5,5);
    Rectangle r3 = new Rectangle(6,6,5,5);

    System.out.println("r1.overlaps(r2) : true : " + r1.intersects(r2));
    System.out.println("r1.overlaps(r3) : false : " + r1.intersects(r3));
    System.out.println("r2.overlaps(r3) : true : " + r2.intersects(r3));

    // check all four corners
    System.out.println("r1.contains(0,0) : true : " + r1.contains(0,0));
    System.out.println("r1.contains(0,5) : true : " + r1.contains(0,5));
    System.out.println("r1.contains(5,5) : true : " + r1.contains(5,5));
    System.out.println("r1.contains(5,0) : true : " + r1.contains(5,0));

    // check all four sides
    System.out.println("r1.contains(2,-1) : false : " + r1.contains(2,-1));  // top
    System.out.println("r1.contains(0,5) : false : " + r1.contains(-1,2));  // left
    System.out.println("r1.contains(5,5) : false : " + r1.contains(6,2));  // right
    System.out.println("r1.contains(5,0) : false : " + r1.contains(2,6));  // bottom

    // check inside
    System.out.println("r1.contains(2,2) : true : " + r1.contains(2,2));
    System.out.println("r1.contains(6,6) : false : " + r1.contains(6,6));
  }

  public static void testCircle() {
    System.out.println("\nTest Circles");
    Circle c1 = new Circle(0,0,1);
    Circle c2 = new Circle(1,1,3);
    Circle c3 = new Circle(6,6,1);

    System.out.println("c1.overlaps(c2) : true : " + c1.intersects(c2));
    System.out.println("c1.overlaps(c3) : false : " + c1.intersects(c3));
    System.out.println("c2.overlaps(c2) : true : " + c2.intersects(c2));
    System.out.println("c2.overlaps(c3) : false : " + c2.intersects(c3));

    // check all edges
    System.out.println("c1.contains(0,-1) : true : " + c1.contains(0,-1));
    System.out.println("c1.contains(-1,0) : true : " + c1.contains(-1,0));
    System.out.println("c1.contains(1,0) : true : " + c1.contains(1,0));
    System.out.println("c1.contains(0,1) : true : " + c1.contains(0,1));

    // check all four sides
    System.out.println("c1.contains(0,-2) : false : " + c1.contains(0,-2));  // top
    System.out.println("c1.contains(-2,0) : false : " + c1.contains(-2,0));  // left
    System.out.println("c1.contains(2,0) : false : " + c1.contains(2,0));  // right
    System.out.println("c1.contains(0,2) : false : " + c1.contains(0,2));  // bottom

    // check inside
    System.out.println("c1.contains(0,0) : true : " + c1.contains(0,0));
    System.out.println("c1.contains(6,6) : false : " + c1.contains(6,6));
  }
}
