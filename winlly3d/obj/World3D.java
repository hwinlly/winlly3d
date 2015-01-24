package winlly3d.obj;

import winlly3d.Camera;

import java.util.ArrayList;

/**
 * Created by winlly on 2015/1/24.
 */
public class World3D {

    private Camera viewCamera = null;
    ArrayList<Object3D> objects = new ArrayList<Object3D>();

    public World3D(Camera ca) {
        viewCamera = ca;
    }

    public boolean addObj(Object3D obj) {
        if(null == obj) {
            return false;
        }
        obj.setWorld(this);
        return objects.add(obj);
    }
}
