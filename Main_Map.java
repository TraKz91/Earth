//1905670
package assignment;

import javax.swing.*;
import java.awt.*;
//use from webminar

public class Main_Map {
    public static void main(String[] args) {
        JFrame f = new JFrame("Map");//initiate jframe
        f.getContentPane().setPreferredSize(new Dimension(1200, 800));//size of the window
        Paint peint = new Paint();
        double up = Double.parseDouble(args[0]);//use for parameters for sea level
        peint.Warming(up);
        f.add(peint);
        f.pack();//The Window fit the preferred size
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close everything
        f.setVisible(true);
    }
}