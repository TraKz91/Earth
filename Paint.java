//1905670
package assignment;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;


public class Paint extends Plot {

    Earth earth = new Earth();
    int blocksize = 1;
    List<double[]> sea = new ArrayList<>();
    List<double[]> land = new ArrayList<>();

    public void Warming(double up) {
        Earth earth = new Earth();
        try {
            earth.readDataArray("/Users/kevintrang/Documents/src/assignment/earth.xyz");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        land = earth.coordinatesAbove(0);
        for (double[] hh : land) {
            hh[2] -= up;
        }


    }

    @Override
    public void paintComponent(Graphics g) {
        Earth earth = new Earth();
        try {
            earth.readDataArray("/Users/kevintrang/Documents/src/assignment/earth.xyz");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Graphics2D g2d = (Graphics2D) g;

        this.width = getWidth();
        this.height = getHeight();
        sea = earth.coordinatesBelow(0);
        for (double[] i : sea) {
            int x = this.scaleX(shift(i[0]));
            int y = this.scaleY(i[1]);
            int z = this.scaleX(i[2]);

            if (z < 0 && z >= (-750)) {
                g2d.setColor(new Color(89, 186, 200));
            } else if (z < (-750) && z > (-1500)) {
                g2d.setColor(new Color(83, 159, 172));
            } else if (z < (-1500) && z >= (-3000)) {
                g2d.setColor(new Color(68, 136, 191));

            } else if (z < (-3000) && z >= (-10000)) {
                g2d.setColor(new Color(23, 92, 145));
            } else {
                g2d.setColor(new Color(0, 14, 85));
            }
            g.fillRect(x, y, blocksize, blocksize);//x,y,width of the pixel,height of the pixel
        }
        for (double[] i : land) {
            int x = this.scaleX(shift(i[0]));
            int y = this.scaleY(i[1]);
            int z = this.scaleX(i[2]);

            if (z < 0 && z > (-5000)) {
                g2d.setColor(new Color(71, 160, 191));//set color
            } else if (z > 0 && z < 500) {
                g2d.setColor(new Color(20, 202, 0));
            } else if (1000 > z && z > 500) {
                g2d.setColor(new Color(18, 152, 0));
            } else if (5000 > z && z > 1000) {
                g2d.setColor(new Color(17, 113, 0));
            } else {
                g2d.setColor(new Color(184, 211, 211));

            }
            g.fillRect(x, y, blocksize, blocksize);
        }
    }
}