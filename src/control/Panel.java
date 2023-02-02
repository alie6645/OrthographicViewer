package control;

import display.blob.ColorModifier;
import display.blob.Blob3D;
import display.blob.Polygon3D;
import display.shape.Line3D;
import display.shape.Shape3D;
import projection.ProjectionCamera;
import projection.VectorMath;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JComponent {

    ArrayList<Shape3D> shapes = new ArrayList<Shape3D>();
    ArrayList<Blob3D> polygons = new ArrayList<>();
    ProjectionCamera projection = new ProjectionCamera();

    public void add(Shape3D shape){
        shapes.add(shape);
    }

    public void add(Blob3D blob){
        polygons.add(blob);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.GRAY);
        g2.fillRect(0,0,1000,1000);
        for (Shape3D shape:shapes){
            List<Line3D> lines = shape.getLines();
            g2.setColor(shape.getColor());
            for (Line3D line:lines){
                line.draw(g2, projection);
            }
        }
        for (Blob3D blob:polygons){
            blob.depthSort(projection.camera);
            Color main = blob.getColor();
            g2.setColor(blob.getColor());
            List<Polygon3D> surfaces = blob.getPolygons();
            for (Polygon3D poly:surfaces){
                double modifier = Math.abs(VectorMath.dot(VectorMath.norm(poly.getNormal()),VectorMath.norm(projection.normal)));
                g2.setColor(ColorModifier.multiply(main,0.5*modifier + 0.5));
                poly.draw(g2, projection);
            }
        }
    }
}
