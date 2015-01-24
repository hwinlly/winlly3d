package winlly3d.test;

import winlly3d.obj.Box3D;
import winlly3d.obj.Camera;
import winlly3d.obj.Point3D;
import winlly3d.obj.World3D;
import winlly3d.ui.ViewFrame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by winlly on 2015/1/24.
 */
public final class BoxTest implements MouseListener, MouseMotionListener {

    private static ViewFrame mainFrame = new ViewFrame();
    private static Camera ca = new Camera();
    private World3D world = null;
    private Point oldPoint = null;

    public BoxTest() {
        world = new World3D(ca);
        for(int i = 0; i < 10; i++) {
            world.add(new Box3D(new Point3D(-50.0f,  50.0f, 850.0f + i*150), 100));
            world.add(new Box3D(new Point3D(-50.0f,  50.0f + i*150, 850.0f + i*150), 100));
            world.add(new Box3D(new Point3D(-50.0f,  50.0f - i*150,850.0f + i*150), 100));
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
        int moveSpeed = 3;
        if(null != oldPoint) {
            Point3D moveP = new Point3D(moveSpeed * (currentPoint.x - oldPoint.x),
                                        moveSpeed * (oldPoint.y - currentPoint.y), 0);
            world.moveWorld(moveP);
        }
        mainFrame.repaint();
        oldPoint = currentPoint;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
