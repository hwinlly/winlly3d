package winlly3d.ui;

import winlly3d.obj.World3D;

import javax.swing.*;
import java.awt.*;

/**
 * Created by winlly on 2015/1/24.
 */
public class ViewFrame extends JFrame {

    public ViewPanel mainPanel;

    public ViewFrame() {
        mainPanel = new ViewPanel();
        setPreferredSize(new Dimension(800,600));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(mainPanel);
        addMouseListener(mainPanel);
        addMouseMotionListener(mainPanel);
    }

    public void setWorld(World3D world) {
        mainPanel.setWorld(world);
    }
}
