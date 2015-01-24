package winlly3d.obj;

import winlly3d.ui.VisibleObj;

import java.awt.*;

/**
 * Created by winlly on 2015/1/24.
 */
public abstract class Object3D {

    private World3D world = null;
    private Point3D center = null;

    public void setWorld(World3D w) {
        world = w;
    }

    public Point perspectiveProjection(Point3D p) {
        if(null == world) {
            return null;
        }
        return world.perspectiveProjection(p);
    }

    public abstract VisibleObj getViewObj();
}
