import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main2 {
  public static void main(String[] args) {

    try {
      FileWriter writer = new FileWriter(Constant.FILE_NAME_W);
      writer.write("ncols " + Constant.COLUMN +"\n");
      writer.write("nrows " + Constant.ROW +"\n");
      writer.write("xllcorner " + Constant.START_POINT.getLongitude() +"\n");
      writer.write("yllcorner " + Constant.START_POINT.getLatitude() +"\n");
      writer.write("cellsize " + Constant.DISTANCE +"\n");
      writer.write("NODATA_value -9999" + "\n");

      try (BufferedReader br = new BufferedReader(new FileReader(Constant.FILE_NAME_R))) {
        int k = 0;

        String line = br.readLine();
        while ((line = br.readLine()) != null) {
          String[] split = line.split("\t");
          if(k< Constant.COLUMN-1){
            writer.write(split[3] + " ");
            k++;
          }else {
            writer.write(split[3] + "\n");
            k=0;
          }
        }

      } catch (IOException e) {
        System.err.format("IOException: %s%n", e);
      }
      writer.close();
    } catch (IOException e) {
      System.out.println("An error occurred while writing to the file.");
      e.printStackTrace();
    }
  }
}