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
public class ViewPanel extends JPanel {

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
    protected void paintComponent(Graphics g)  {
        super.paintComponent(g);
        int viewWidth = getWidth();
        int viewHeight = getHeight();

        if(null != world) {
            world.paintWorld(g, viewWidth, viewHeight);
        }

    }

}
