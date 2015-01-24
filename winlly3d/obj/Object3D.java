package winlly3d.obj;

import winlly3d.ui.VisibleObj;

/**
 * Created by winlly on 2015/1/24.
 */
public abstract class Object3D {

    private World3D world = null;
    private Point3D center = null;

    public void setWorld(World3D w) {
        world = w;
    }

    public abstract VisibleObj getViewObj();
}
