import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Utility function for Image Objects
 */
public class ImageFileUtilities {
  public static void main(String args[]) throws IOException {

    //
    // TEST PNM
    //

    Image pnmImg = read("image.pnm");
    writePnm(pnmImg,"test_image_read.pnm");

    Pixel[][] pnmPixels = new Pixel[][]{
      {new Pixel(255,0,0),new Pixel(0,255,0),new Pixel(0,0,255)},
      {new Pixel(255,255,0),new Pixel(255,255,255),new Pixel(0,0,0)}
    };

    Image imagePnm = new Image("#anything",255,pnmPixels);
    writePnm(imagePnm,"test_image_data.pnm");

    //
    // TEST PGM
    //

    Image pgmImg = read("image.pgm");
    writePgm(pgmImg,"test_image_read.pgm");

    Pixel[][] pgmPixels = new Pixel[][]{
      {new Pixel(85,85,85),new Pixel(85,85,85),new Pixel(85,85,85)},
      {new Pixel(170,170,170),new Pixel(255,255,255),new Pixel(0,0,0)}
    };

    Image imagePgm = new Image("#anything",255,pgmPixels);
    writePgm(imagePgm,"test_image_data.pgm");

  }

  /**
   * Reads a PNM or PGM image file.
   * @param  fileName name of image file.
   * @return          image data wrapper.
   */
  public static Image read(String fileName) throws IOException {
    Scanner sc = new Scanner(new File(fileName));
    String rawData = "";
    String metaData = "";
    String pixelData = "";
    String formatCode = "";

    //
    // COLLECT META DATA
    //

    formatCode = sc.nextLine();

    while(sc.hasNextLine()) {
      rawData = sc.nextLine();
      if(rawData.charAt(0) == '#') {
        metaData += rawData +"\n";
      } else {
        pixelData += rawData + " ";
      }
    }

    //
    // COLLECT IMAGE DATA
    //

    Scanner scanner = new Scanner(pixelData);

    int width = scanner.nextInt();
    int height = scanner.nextInt();
    int maxRange = scanner.nextInt();

    //
    // COLLECT PIXEL DATA
    //

    Pixel[][] pixels = new Pixel[height][width];

    if (formatCode.equals("P3")) {
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          int red = scanner.nextInt();
          int green = scanner.nextInt();
          int blue = scanner.nextInt();

          pixels[i][j] = new Pixel(red,green,blue);
        }
      }
    } else if (formatCode.equals("P2")) {
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          int grey = scanner.nextInt();

          pixels[i][j] = new Pixel(grey);
        }
      }
    } else {
      System.out.println("!!! not a valid extension.");
    }

    return new Image(metaData,maxRange,pixels);
  }

  /**
   * Writes a new PNM image file.
   * @param  img Image data wrapper.
   * @param  fileName output file name (without extension).
   */
  public static void writePnm(Image img, String fileName) throws IOException {
    File file = new File(fileName + ".pnm");
    FileWriter fw = new FileWriter(file.getAbsoluteFile());
    BufferedWriter bw = new BufferedWriter(fw);

    bw.write("P3");
    bw.newLine();
    bw.write(img.getMetadata());
    bw.newLine();
    bw.write(Integer.toString(img.getWidth()));
    bw.write(" ");
    bw.write(Integer.toString(img.getHeight()));
    bw.newLine();
    bw.write(Integer.toString(img.getMaxRange()));
    bw.newLine();

    for(int i = 0; i < img.getHeight(); i++) {
      for(int j = 0; j < img.getWidth(); j++) {
        bw.write(Integer.toString(img.getPixel(i,j).getRed()));
        bw.write(" ");
        bw.write(Integer.toString(img.getPixel(i,j).getGreen()));
        bw.write(" ");
        bw.write(Integer.toString(img.getPixel(i,j).getBlue()));
        bw.write(" ");
      }
      bw.newLine();
    }
    bw.close();
  }

  /**
   * Writes a new PNM image file.
   * @param  img Image data wrapper.
   * @param  fileName output file name (without extension).
   */
  public static void writePgm(Image img, String fileName) throws IOException {
    File file = new File(fileName + ".pgm");
    FileWriter fw = new FileWriter(file.getAbsoluteFile());
    BufferedWriter bw = new BufferedWriter(fw);

    bw.write("P2");
    bw.newLine();
    bw.write(img.getMetadata());
    bw.newLine();
    bw.write(Integer.toString(img.getWidth()));
    bw.write(" ");
    bw.write(Integer.toString(img.getHeight()));
    bw.newLine();
    bw.write(Integer.toString(img.getMaxRange()));
    bw.newLine();

    for(int i = 0; i < img.getHeight(); i++) {
      for(int j = 0; j < img.getWidth(); j++) {
        bw.write(Integer.toString(img.getPixel(i,j).grey()));
        bw.write(" ");
      }
    }
    bw.close();
  }
}
