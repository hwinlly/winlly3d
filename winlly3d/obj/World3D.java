package winlly3d.obj;

import winlly3d.ui.VisibleObj;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by winlly on 2015/1/24.
 */
public class World3D {

    private Camera viewCamera = null;
    private ArrayList<Object3D> objects = new ArrayList<Object3D>();
    private ArrayList<VisibleObj> viewObjs = new ArrayList<VisibleObj>();

    public World3D(Camera ca) {
        viewCamera = ca;
    }

    public boolean addObj(Object3D obj) {
        if(null == obj) {
            return false;
        }
        obj.setWorld(this);
        VisibleObj viewObj = obj.getViewObj();
        viewObjs.add(viewObj);
        objects.add(obj);
        return true;
    }

    public void updateViews() {
        viewObjs.clear();
        Iterator<Object3D> iter = objects.iterator();
        while(iter.hasNext()) {
            Object3D obj = iter.next();
            VisibleObj viewObj = obj.getViewObj();
            viewObjs.add(viewObj);
        }
    }

    public Point perspectiveProjection(Point3D p) {
        return viewCamera.perspectiveProjection(p);
    }

    public void paintWorld(Graphics g, int w, int h) {
        Iterator<VisibleObj> iter = viewObjs.iterator();
        while(iter.hasNext()) {
            VisibleObj obj = iter.next();
            obj.paintObject(g, w, h);
        }
    }
}
