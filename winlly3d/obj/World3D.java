package winlly3d.obj;

import winlly3d.ui.VisibleObj;

import java.awt.*;
import java.util.ArrayList;

public class World3D {

    private Camera viewCamera = null;
    private ArrayList<Object3D> objects = new ArrayList<Object3D>();
    private ArrayList<VisibleObj> viewObjs = new ArrayList<VisibleObj>();

    public World3D(Camera ca) {
        viewCamera = ca;
    }

    public boolean add(Object3D obj) {
        if(null == obj) {
            return false;
        }
        obj.setWorld(this);
        VisibleObj viewObj = obj.getViewObj();
        viewObjs.add(viewObj);
        objects.add(obj);
        return true;
    }

    public void updateView() {
        viewObjs.clear();
        for(Object3D obj : objects) {
            viewObjs.add(obj.getViewObj());
        }
    }

    public Point perspectiveProjection(Point3D p) {
        return viewCamera.perspectiveProjection(p);
    }

    public void moveWorld(Point3D p) {
        viewObjs.clear();
        for (Object3D obj : objects) {
            obj.move(p);
            VisibleObj viewObj = obj.getViewObj();
            viewObjs.add(viewObj);
        }
    }

    public void paintWorld(Graphics g, int w, int h) {
        for (VisibleObj obj : viewObjs) {
            if (null != obj) {
                obj.paintObject(g, w, h);
            }
        }
    }
}
