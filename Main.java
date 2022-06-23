//1905670
package assignment;


import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) throws NumberFormatException, FileNotFoundException {
        Earth earth = new Earth();
        earth.readDataArray("/Users/kevintrang/Documents/src/assignment/earth.xyz");
        earth.readDataMap("/Users/kevintrang/Documents/src/assignment/earth.xyz");
        //System.out.println(earth.getAltitude(94,1));
        // System.out.println(Arrays.deepToString(earth.arrayOfEarth));
        while (true) {
            Scanner scan = new Scanner(System.in);
            String one, two, three, four;
            System.out.println("Please enter 1 for percentage above, 2 for percentage below, 3 for altitude or quit.");
            one = scan.nextLine();
            if (one.equals("quit")) {
                System.out.println("end");
                break;
            } else {
                boolean num = true;
                try {
                    Double first = Double.parseDouble(one);
                } catch (NumberFormatException e) {
                    num = false;
                }
                if (num) {
                    double first = Double.parseDouble(one);
                    if (first == 1) {
                        System.out.println("Please enter an altitude between -8000 - 5000");
                        two = scan.nextLine();
                        boolean abov = true;
                        try {
                            Double second = Double.parseDouble(two);
                        } catch (NumberFormatException e) {
                            abov = false;
                        }
                        if (abov) {
                            Double altitude = Double.parseDouble(two);
                            if (altitude >= -8000 && altitude <= 5000) {
                                System.out.println("Proportion of coordinates above " + two + " meters :");
                                earth.percentageAbove(altitude);
                            } else {
                                System.out.println("Invalid altitude. Back to Main Menu.");
                            }
                        } else {
                            System.out.println("Invalid altitude. Back to Main Menu.");
                        }
                    } else if (first == 2) {
                        System.out.println("Please enter an altitude between -8000 - 5000");
                        two = scan.nextLine();
                        boolean under = true;
                        try {
                            Double second = Double.parseDouble(two);
                        } catch (NumberFormatException e) {
                            under = false;
                        }
                        if (under) {
                            double altitude = Double.parseDouble(two);
                            if (altitude >= -8000 && altitude <= 5000) {
                                System.out.println("Proportion of coordinates below " + two + " meters :");
                                earth.percentageBelow(altitude);
                            } else {
                                System.out.println("Invalid altitude. Back to Main Menu.");
                            }
                        } else {
                            System.out.println("Invalid altitude. Back to Main Menu.");
                        }

                    } else if (first == 3) {
                        System.out.println("Please enter a longitude (0-360):");
                        three = scan.nextLine();
                        System.out.println("Please enter a latitude (-90 - 90):");
                        four = scan.nextLine();
                        boolean al = true;
                        try {
                            Double third = Double.parseDouble(three);
                            Double fourth = Double.parseDouble(four);
                        } catch (NumberFormatException e) {
                            al = false;
                        }
                        if (al) {
                            double longi = Double.parseDouble(three);
                            double lalti = Double.parseDouble(four);
                            if (longi <= 360 && longi >= 0 && lalti <= 90 && lalti >= -90) {

                                System.out.println("The altitude at longitude " + three + " and latitude " + four + " is :");
                                earth.getAltitude(longi, lalti);

                            } else {
                                System.out.println("Invalid longitude and latitude. Back to Main Menu.");
                            }
                        } else {
                            System.out.println("Invalid longitude and latitude. Back to Main Menu.");
                        }

                    } else {
                        System.out.println("Invalid value. Please enter an altitude or \"quit\" to end program.");


                    }

                } else {
                    System.out.println("Invalid value. Please enter an altitude or \"quit\" to end program.");


                }
            }

        }
    }
}