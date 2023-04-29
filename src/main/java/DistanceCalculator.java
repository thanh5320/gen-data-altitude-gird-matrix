public class DistanceCalculator {
  public static final double EARTH_RADIUS = 6371; // In kilometers

  public static double distance(double startLat, double startLon,
      double endLat, double endLon) {

    double dLat = Math.toRadians(endLat - startLat);
    double dLon = Math.toRadians(endLon - startLon);

    startLat = Math.toRadians(startLat);
    endLat = Math.toRadians(endLat);

    double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLon);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    return EARTH_RADIUS * c;
  }

  public static double haversin(double val) {
    return Math.pow(Math.sin(val / 2), 2);
  }
}