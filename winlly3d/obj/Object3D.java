package winlly3d.obj;

import winlly3d.ui.VisibleObj;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by winlly on 2015/1/24.
 */
public abstract class Object3D {

    private World3D world = null;
    protected Color color = Color.black;
    protected ArrayList<Point3D> points = new ArrayList<Point3D>();

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

    public void setColor(Color c) {
        color = c;
    }

    public void move(Point3D location) {
        for(Point3D p : points) {
            p.move(location);
        }
    }

    public void rotationX(double a, Point location) {
        for(Point3D p : points) {
            p.rotationX(a, location);
        }
    }

    public void rotationY(double a, Point location) {
        for(Point3D p : points) {
            p.rotationY(a, location);
        }
    }

    public void rotationZ(double a, Point location) {
        for(Point3D p : points) {
            p.rotationZ(a, location);
        }
    }
}
