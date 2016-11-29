import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Fibonacci {
  public static void main (String[] args) {
    try {
      File file = new File("output.txt");
      if (!file.exists()) {
        file.createNewFile();
      }

      FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

      // It could take an entire day to calculate to 100
      // its even pretty annoying waiting for 50 (5 mins on MacBook 2012)
      for (int i = 5; i <= 45; i += 5) {
        long startTimeBinary = System.currentTimeMillis();
        long b = BinaryFibonacci(i);
        long endTimeBinary = System.currentTimeMillis();

        // Time the linear recursion
        long startTimeLinear = System.currentTimeMillis();
        long l = LinearFibonacci(i)[0];
        long endTimeLinear = System.currentTimeMillis();

        // Time the tail recursion
        long startTimeTail = System.currentTimeMillis();
        long t = TailFibonacci(i, 1, 0);
        long endTimeTail = System.currentTimeMillis();

        // Output results to text file (output.txt)
        bufferedWriter.write("-FIBONACCI NUMBER (" + i + ")------------------------------\n");
        bufferedWriter.write("Binary: "+b+"\n");
        bufferedWriter.write("Linear: "+l+"\n");
        bufferedWriter.write("Tail: "+t+"\n");
        bufferedWriter.write("Total execution time (Binary): " + (endTimeBinary - startTimeBinary) + "ms\n");
        bufferedWriter.write("Total execution time (Linear): " + (endTimeLinear - startTimeLinear) + "ms\n");
        bufferedWriter.write("Total execution time (Tail): " + (endTimeTail - startTimeTail) + "ms\n");
        bufferedWriter.newLine();

        // Just because staring at a blank console is mind-numbing
        System.out.println("Finished Fibonacci number: " + i);
      }


      // close the writing stream
      bufferedWriter.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println ("Program Ended.");
  }

  public static long BinaryFibonacci(int k) {
    return k <= 1 ? k : (BinaryFibonacci(k - 1) + BinaryFibonacci(k - 2));
  }

  public static long[] LinearFibonacci(int k) {
    if (k <= 1) {
      return new long[] {k, 0};
    } else {
      long[] temp = LinearFibonacci(k-1);
      return new long[] {temp[0] + temp[1], temp[0]};
    }
  }

  public static long TailFibonacci(int k, long f1, long f2) {
    return k == 0 ? f2 : TailFibonacci(k-1, f1+f2, f1);
  }
}
