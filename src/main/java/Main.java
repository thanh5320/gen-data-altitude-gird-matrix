import java.io.FileWriter;
import java.io.IOException;


public class Main {

  public static void main(String[] args) {
    try {
      FileWriter writer = new FileWriter(Constant.FILE_NAME);
      writer.write("latitude,longitude"+"\n");
      Double latitude = GeoUtils.moveLatitude(Constant.START_POINT, Constant.DISTANCE *(Constant.ROW
          -1)).getLatitude();
      Double longitude = Constant.START_POINT.getLongitude();
      Point currentPoint = new Point(latitude, longitude);
      for (int i = Constant.ROW; i > 0; i--) {
        for (int j = 1; j <= Constant.COLUMN; j++) {
          writer.write(currentPoint.toString()+"\n");
          currentPoint = GeoUtils.moveLongitude(currentPoint, Constant.DISTANCE);
        }
        currentPoint.setLongitude(Constant.START_POINT.getLongitude());
        currentPoint = GeoUtils.moveLatitude(currentPoint, -Constant.DISTANCE);
      }
      writer.close();
    } catch (IOException e) {
      System.out.println("An error occurred while writing to the file.");
      e.printStackTrace();
    }
  }
}