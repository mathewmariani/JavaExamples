import java.io.IOException;

/*
 *  Processes an image based of the given arguements.
 *
 *  args[0]   Input file name.
 *  args[1]   Output file name.
 *  args[2]   Format for the output file.
 *  args[3]   Operation (-fh, -fv, -cr).
 *  args[4]   (if -cr) x-coordinate for crop.
 *  args[5]   (if -cr) y-coordinate for crop.
 *  args[6]   (if -cr) width for crop.
 *  args[7]   (if -cr) height for crop.
 */
public class ImageProcessing {
  public static void main(String[] args) {
    if(args.length < 4) {
      System.out.println("This program requires 4 inputs");
      return;
    }

    String inputFile = args[0];
    String outputFile = args[1];
    String formatOutputFile = args[2];
    String operationOnImage = args[3];

    //
    // INPUT
    //

    Image img = null;
    try {
      img = ImageFileUtilities.read(inputFile);
    } catch (IOException e) {
      System.out.println("File ("+inputFile+") not found.");
      return;
    }

    //
    // OPERATIONS
    //

    switch (operationOnImage) {
      case "-fh":
        img.flipHorizontal();
        break;
      case "-fv":
        img.flipVertical();
        break;
      case "-gs":
        img.toGrey();
        break;
      case "-cr":
        if(args.length < 8) {
          System.out.println("Cropping requires (x, y, w, h).");
          return;
        }

        int x = Integer.parseInt(args[4]);
        int y = Integer.parseInt(args[5]);
        int w = Integer.parseInt(args[6]);
        int h= Integer.parseInt(args[7]);

        img.crop(x, y, w, h);
        break;
      default:
        break;
    }

    //
    // OUTPUT
    //

    switch (formatOutputFile) {
      case "pgm":
        try {
          ImageFileUtilities.writePgm(img, outputFile);
        } catch (IOException e) {
          System.out.println("Unable to write PGM.");
          return;
        }
        break;
      case "pnm":
        try {
          ImageFileUtilities.writePnm(img, outputFile);
        } catch (IOException e) {
          System.out.println("Unable to write PNM.");
          return;
        }
        break;
      default:
        System.out.println("Unknown output file extension ("+outputFile+")");
        return;
    }
  }
}
