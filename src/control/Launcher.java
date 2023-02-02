package control;

import display.blob.Cube;
import display.shape.Box3D;
import projection.Vector3;

import javax.swing.*;
import java.awt.*;

public class Launcher {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400,400));
        Panel panel = new Panel();
        KeyController controller = new KeyController(panel);
        frame.addKeyListener(controller);
        Cube box1 = getCube(0,10,4,100,100,100);
        box1.setColor(Color.GREEN);
        panel.add(box1);
        Cube box2 = getCube(100,10,4,200,200,200);
        box2.setColor(Color.GREEN);
        panel.add(box2);
        Cube cube = new Cube(new Vector3(0,10,4),10);
        panel.add(cube);
        frame.add(panel);

        frame.setVisible(true);
    }

    public static Box3D getBox(double x, double y, double z, double height, double width, double depth){
        return new Box3D(new Vector3(x,y,z),height,width,depth);
    }

    public static Cube getCube(double x, double y, double z, double width, double height, double depth){
        return new Cube(new Vector3(x,y,z),width);
    }
}
