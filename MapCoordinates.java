//1905670
package assignment;

import java.util.ArrayList;
import java.util.List;

public class MapCoordinates {
    double longitude;
    double latitude;
    double altitude;

    public MapCoordinates(double longitude, double latitude, double altitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
    }

    //From here, this part below is not done
    double distanceTo(MapCoordinates mp) {
        MapCoordinates coord = new MapCoordinates(123, 67, 1000);
        MapCoordinates coord1 = new MapCoordinates(123, 67, 1000);
        List<MapCoordinates> coordonnee = new ArrayList<>();
        coordonnee.add(coord);
        coordonnee.add(coord1);
        double distearth = 6371e3; // metres
        var lat1 = coordonnee.get(1);
        var lat2 = coordonnee.get(4);
        var longi1 = coordonnee.get(0);
        var longi2 = coordonnee.indexOf(3);

      /*  int longi3 = longi1 - longi2;
        var lat3=lat1-lat2;
//formula below took from : https://www.igismap.com/haversine-formula-calculate-geographic-distance-earth/


        double φ1 = Math.toRadians(longi3);
        double φ2 = Math.toRadians(lat3);


        var a = Math.sin(lat3/2) * Math.sin(lat3/2) + Math.cos(lat1) * Math.cos(longi2) * Math.sin(longi3/2) * Math.sin(longi3/2);
        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        var d = distearth * c;


        System.out.println(d);*/
        return 0;
    }
}
