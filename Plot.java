//1905670
package assignment;
//file took from webminar

import javax.swing.*;

// transformation of user coordinates to screen coordinates
public class Plot extends JComponent {

    // dimensions of plotting area with default values
    int width = 600, height = 600;
    // dimensions of user-space coordinates with default values
    double xmin = 0, xmax = 360, ymin = -90, ymax = 90;
    // transformation of coordinates

    public double shift(double x) {
        x += 180;//center it
        if (x > 360) {
            x -= 360;//if outside the window
        }
        return x;
    }

    public int scaleX(double x) {
        return (int) (width * (x - xmin) / (xmax - xmin));
    }

    public int scaleY(double y) {
        return (int) (height * (ymin - y) / (ymax - ymin) + height);
    }

    public void setScaleX(double min, double max) {
        xmin = min;
        xmax = max;
    }

    public void setScaleY(double min, double max) {
        ymin = min;
        ymax = max;
    }

}


