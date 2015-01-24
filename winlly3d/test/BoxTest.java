package winlly3d.test;

import winlly3d.obj.Camera;
import winlly3d.obj.World3D;
import winlly3d.ui.ViewFrame;

/**
 * Created by winlly on 2015/1/24.
 */
public final class BoxTest {

    private static ViewFrame mainFrame = new ViewFrame();
    private static Camera ca = new Camera();


    public static void main(String[] args) {
        World3D world = new World3D(ca);
        mainFrame.setWorld(world);
    }
}
