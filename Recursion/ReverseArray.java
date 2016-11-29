import java.util.Arrays;

public class ReverseArray {
  public static void main (String[] args) {
    int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    // expected : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    System.out.println("Normal Array");
    System.out.println(Arrays.toString(array));

    // expected : [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
    System.out.println("Reversed Array (Loop)");
    loopReverseArray(array);
    System.out.println(Arrays.toString(array));

    // expected : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    // since we're reversing an already reversed array, it should be normal.
    System.out.println("Reversed Array (Recursive)");
    recursiveReverseArray(array);
    System.out.println(Arrays.toString(array));
  }

  public static void loopReverseArray(int[] arr) {
    for (int i = 0; i < arr.length / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[(arr.length - 1) - i];
      arr[(arr.length - 1) - i] = temp;
    }
  }

  //just a simple wrapper
  public static void recursiveReverseArray(int[] x){
   reverse(x, 0, x.length -1);
  }

  // implementation
  public static void reverse(int[] x, int i, int j){
    if (i < j) {
     int tmp = x[i];
     x[i] = x[j];
     x[j] = tmp;
     reverse(x, ++i, --j);
    }
  }
}
