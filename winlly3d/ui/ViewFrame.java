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
        add(mainPanel);
        setExtendedState(MAXIMIZED_BOTH);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setWorld(World3D world) {
        mainPanel.setWorld(world);
    }
}
