package winlly3d.ui;

import winlly3d.obj.World3D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by winlly on 2015/1/24.
 */
public class ViewPanel extends JPanel implements MouseListener, MouseMotionListener {

    private World3D world = null;

    public ViewPanel() {

    }

    public ViewPanel(World3D w) {
        world = w;
    }

    public World3D getWorld() {
        return world;
    }

    public void setWorld(World3D w) {
        world = w;
    }

    @Override
    protected  void paintComponent(Graphics g)  {
        super.paintComponent(g);
        int viewWidth = getWidth();
        int viewHeight = getHeight();

        if(null != world) {
            world.paintWorld(g, viewWidth, viewHeight);
        }

        // draw mark lines
        g.setColor(Color.red);
        g.drawLine(0, viewHeight >> 1, viewWidth, viewHeight >> 1);
        g.drawLine(viewWidth >> 1, 0, viewWidth >> 1, viewHeight);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
