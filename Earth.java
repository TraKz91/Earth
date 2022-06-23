//1905670
package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Earth {

    private double[][] arrayOfEarth;
    private Map<List<Double>, Double> mapOfEarth;


    public void readDataArray(String filename) throws FileNotFoundException {     //with the help of webminar
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        int count = 0;
        while (scan.hasNextLine()) {
            count++;
            scan.nextLine();
        }
        //System.out.println(count);

        arrayOfEarth = new double[count][3];
        scan.close();
        scan = new Scanner(new File(filename));
        String d1;
        double x, y, z;
        count = 0;
        while (scan.hasNextLine()) {
            d1 = scan.nextLine();
            String[] d2 = d1.split("\t");
            x = Double.parseDouble(d2[0]);
            y = Double.parseDouble(d2[1]);
            z = Double.parseDouble(d2[2]);

            arrayOfEarth[count][0] = x;
            arrayOfEarth[count][1] = y;
            arrayOfEarth[count][2] = z;

            count++;

        }
        //System.out.println(Arrays.deepToString(arrayOfEarth));

    }

    public List<double[]> coordinatesAbove(double altitude) {
        List<double[]> abv = new ArrayList<>();
        for (int i = 0; i < arrayOfEarth.length; i++) {
            if (arrayOfEarth[i][2] > altitude) {
                abv.add(arrayOfEarth[i]);
            }
        }
        return abv;
    }

    public List<double[]> coordinatesBelow(double altitude) {
        List<double[]> und = new ArrayList<>();
        for (int i = 0; i < arrayOfEarth.length; i++) {
            if (arrayOfEarth[i][2] < altitude) {
                und.add(arrayOfEarth[i]);
            }
        }
        return und;
    }

    public void percentageAbove(double altitude) {
        double cdabv = coordinatesAbove(altitude).size();
        double percent = (cdabv / arrayOfEarth.length) * 100;
        System.out.println(Math.round(percent * 10d) / 10d);//round to decimal
    }

    public void percentageBelow(double altitude) {
        double cdblw = coordinatesBelow(altitude).size();
        double percent = (cdblw/ arrayOfEarth.length) * 100;
        System.out.println(Math.round(percent * 10d) / 10d);
    }

    public void readDataMap(String filename) throws FileNotFoundException {       //with the help of webminar
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        String b1;
        double x, y, z;
        mapOfEarth = new HashMap<>();
        while (scan.hasNextLine()) {
            List<Double> mp = new ArrayList<>();

            b1 = scan.nextLine();
            String[] b2 = b1.split("\t");

            x = Double.parseDouble(b2[0]);
            y = Double.parseDouble(b2[1]);
            z = Double.parseDouble(b2[2]);

            mp.add(x);
            mp.add(y);

            mapOfEarth.put(mp, z);


        }
        // System.out.println(mapOfEarth);

    }

    public void generateMap(double resolution) {
        mapOfEarth = new HashMap<>();
        Random rand = new Random();
        double longit = 360 / resolution;
        double lati = 180 / resolution;
        for (int i = 0; i < longit; i++) {
            for (int j = 0; j < lati; j++) {
                List<Double> ray = new ArrayList<>();
                double longitude = (rand.nextInt(360 + 0) - 0);//Highest value - smallest value
                double latitude = (rand.nextInt(90 + 90) - 90);
                double altitude = (rand.nextInt(5000 + 5000) - 5000);
                ray.add(longitude);
                ray.add(latitude);
                mapOfEarth.put(ray, altitude);

            }
        }
        //System.out.println(mapOfEarth);
    }

    public double getAltitude(double longitude, double latitude) {
        List<Double> ret = new ArrayList<>();
        ret.add(longitude);
        ret.add(latitude);
        double zbi = mapOfEarth.get(ret);
        System.out.println(zbi);
        return zbi;


    }

}


