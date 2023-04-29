public class GeoUtils {

  public static Point moveLongitude(Point startPoint, double distance) {
    // Chuyển đổi giá trị phương kinh độ thành đơn vị radian
    double radian = Math.toRadians(Constant.AZIMUTH);

    // Tính toán vị trí mới của điểm theo công thức Haversine
    double lat1 = Math.toRadians(startPoint.getLatitude());
    double lon1 = Math.toRadians(startPoint.getLongitude());

    double lat2 = Math.asin(Math.sin(lat1) * Math.cos(distance / Constant.RADIUS_OF_EARTH) + Math.cos(lat1) * Math.sin(distance / Constant.RADIUS_OF_EARTH) * Math.cos(radian));
    double lon2 = lon1 + Math.atan2(Math.sin(radian) * Math.sin(distance / Constant.RADIUS_OF_EARTH) * Math.cos(lat1), Math.cos(distance / Constant.RADIUS_OF_EARTH) - Math.sin(lat1) * Math.sin(lat2));

    // Chuyển đổi giá trị kinh độ và vĩ độ về đơn vị độ
    double newLatitude = Math.toDegrees(lat2);
    double newLongitude = Math.toDegrees(lon2);

    return new Point(newLatitude, newLongitude);
  }

  public static Point moveLatitude(Point startPoint, double distance) {
    // Chuyển đổi giá trị phương vĩ độ thành đơn vị radian
    double radian = Math.toRadians(Constant.BEARING);

    // Tính toán vị trí mới của điểm theo công thức Haversine
    double lat1 = Math.toRadians(startPoint.getLatitude());
    double lon1 = Math.toRadians(startPoint.getLongitude());

    double lat2 = Math.asin(Math.sin(lat1) * Math.cos(distance / Constant.RADIUS_OF_EARTH) + Math.cos(lat1) * Math.sin(distance / Constant.RADIUS_OF_EARTH) * Math.cos(radian));
    double lon2 = lon1 + Math.atan2(Math.sin(radian) * Math.sin(distance / Constant.RADIUS_OF_EARTH) * Math.cos(lat1), Math.cos(distance / Constant.RADIUS_OF_EARTH) - Math.sin(lat1) * Math.sin(lat2));

    // Chuyển đổi giá trị kinh độ và vĩ độ về đơn vị độ
    double newLatitude = Math.toDegrees(lat2);
    double newLongitude = Math.toDegrees(lon2);

    return new Point(newLatitude, newLongitude);
  }
}
