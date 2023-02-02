package control;

import projection.ProjectionCamera;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter {
    Panel panel;
    ProjectionCamera cam;
    boolean rotate = false;
    final double speed = 1;
    public KeyController(Panel panel){
        this.panel = panel;
        this.cam = panel.projection;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'p'){
            rotate = !rotate;
        }
        if (rotate) {
            if (e.getKeyChar() == 'w') {
                cam.rotateScreen(0.01, 0, 0);
            }
            if (e.getKeyChar() == 'a') {
                cam.rotateScreen(0, -0.01, 0);
            }
            if (e.getKeyChar() == 's') {
                cam.rotateScreen(-0.01, 0, 0);
            }
            if (e.getKeyChar() == 'd') {
                cam.rotateScreen(0, 0.01, 0);
            }
            if (e.getKeyChar() == 'q') {
                cam.rotateScreen(0, 0, 0.01);
            }
            if (e.getKeyChar() == 'e'){
                cam.rotateScreen(0,0,-0.01);
            }
        } else {
            if (e.getKeyChar() == 'w') {
                cam.move(0, 0, speed);
            }
            if (e.getKeyChar() == 'a') {
                cam.move(-speed, 0, 0);
            }
            if (e.getKeyChar() == 's') {
                cam.move(0, 0, -speed);
            }
            if (e.getKeyChar() == 'd') {
                cam.move(speed, 0, 0);
            }
            if (e.getKeyChar() == 'q') {
                cam.move(0, speed, 0);
            }
            if (e.getKeyChar() == 'e'){
                cam.move(0,-speed,0);
            }
        }
        panel.repaint();
    }
}
