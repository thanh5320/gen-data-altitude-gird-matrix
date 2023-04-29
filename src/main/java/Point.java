// Lớp Point đại diện cho một điểm trên mặt phẳng
public class Point {
  private double latitude; // Vĩ độ của điểm
  private double longitude; // Kinh độ của điểm

  public Point(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public String toString(){
    return latitude +","+ longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }
}