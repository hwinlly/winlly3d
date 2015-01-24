package winlly3d.test;

import winlly3d.obj.Box3D;
import winlly3d.obj.Camera;
import winlly3d.obj.Point3D;
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
        for(int i = 0; i < 10; i++) {
            world.add(new Box3D(new Point3D(-50.0f,  50.0f, 850.0f + i*150), 100));
            world.add(new Box3D(new Point3D(-50.0f,  50.0f + i*150, 850.0f + i*150), 100));
            world.add(new Box3D(new Point3D(-50.0f,  50.0f - i*150,850.0f + i*150), 100));
        }
        mainFrame.setWorld(world);
        mainFrame.setVisible(true);
    }
}
