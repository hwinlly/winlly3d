package winlly3d.test;

import winlly3d.obj.*;
import winlly3d.ui.ViewFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public final class BoxTest implements MouseListener, MouseMotionListener, MouseWheelListener {

    private static ViewFrame mainFrame = new ViewFrame();
    private static Camera camera = new Camera();
    private World3D world = null;
    private Point oldPoint = null;
    private ArrayList<Box3D> boxes = new ArrayList<Box3D>();

    public BoxTest() {
        world = new World3D(camera);
        float distance = 1000.0f;
        for(int i = 0; i < 100; i++) {
            boxes.add(new Box3D(new Point3D(-50.0f,                     50.0f,              distance + i*150), 100, i%2 == 0 ? Color.red : Color.black));
            boxes.add(new Box3D(new Point3D(-50.0f,                     50.0f + (i%10)*150, distance + i*150), 100, i%2 == 0 ? Color.red : Color.black));
            boxes.add(new Box3D(new Point3D(-50.0f,                     50.0f - (i%10)*150, distance + i*150), 100, i%2 == 0 ? Color.red : Color.black));
            if(i <= 5) {
                continue;
            }
            boxes.add(new Box3D(new Point3D(-50.0f + ((i + 5)%10)*150,  50.0f,              distance + i*150), 100, i%2 == 0 ? Color.red : Color.black));
            boxes.add(new Box3D(new Point3D(-50.0f - ((i + 5)%10)*150,  50.0f,              distance + i*150), 100, i%2 == 0 ? Color.red : Color.black));
        }

        for(Box3D box : boxes) {
            world.add(box);
        }

        int gridSpace = 200;
        for(int i = 0; i <= 50; i++) {
            world.add(new Line3D(new Point3D(i*gridSpace, 0, 0), new Point3D(i*gridSpace, 0, 10000), Color.blue));
            world.add(new Line3D(new Point3D(0, 0, i*gridSpace), new Point3D(10000, 0, i*gridSpace), Color.blue));
        }

    }

    public World3D getWorld() {
        return world;
    }

    public static void main(String[] args) {
        BoxTest tester = new BoxTest();
        mainFrame.setWorld(tester.getWorld());
        mainFrame.addMouseListener(tester);
        mainFrame.addMouseMotionListener(tester);
        mainFrame.addMouseWheelListener(tester);
        mainFrame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        oldPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        oldPoint = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point currentPoint = e.getPoint();
        if(SwingUtilities.isLeftMouseButton(e)) {
            int moveSpeed = 3;
            if(null != oldPoint) {
                Point3D moveP = new Point3D(moveSpeed * (currentPoint.x - oldPoint.x),
                        moveSpeed * (oldPoint.y - currentPoint.y), 0);
                world.moveWorld(moveP);
            }
        } else if(SwingUtilities.isRightMouseButton(e)) {
            float rotatRate = 400.f;
            float angleY = (currentPoint.x - oldPoint.x)/rotatRate;
            float angleX = (currentPoint.y - oldPoint.y)/rotatRate;
            for(Box3D box : boxes) {
                box.rotationX(angleX, new Point(0, 5000));
                box.rotationY(angleY, new Point(0, 5000));
            }
            world.updateView();
        } else {
            float rotatRate = 400.f;
            float angleZ = (currentPoint.x - oldPoint.x)/rotatRate;
            for(Box3D box : boxes) {
                box.rotationZ(angleZ, new Point(0, 0));
            }
            world.updateView();
        }

        mainFrame.repaint();
        oldPoint = currentPoint;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int moveSpeed = 30;
        int distance = e.getWheelRotation();
        if(distance != 0) {
            Point3D moveP = new Point3D(0, 0, moveSpeed * distance);
            world.moveWorld(moveP);
        }
        mainFrame.repaint();
    }
}
