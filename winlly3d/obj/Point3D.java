package winlly3d.obj;

import java.awt.*;

/**
 * Created by winlly on 2015/1/24.
 */
public class Point3D {

    public float x;
    public float y;
    public float z;

    public Point3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void move(Point3D p) {
        x += p.x;
        y += p.y;
        z += p.z;
    }

    public void rotationX(double a, Point location) {
        double cosa = Math.cos(a);
        double sina = Math.sin(a);
        float orgy = y - location.x;
        float orgz = z - location.y;
        y = (float)(cosa*orgy - sina*orgz) + location.x;
        z = (float)(sina*orgy + cosa*orgz) + location.y;
    }

    public void rotationY(double a, Point location) {
        double cosa = Math.cos(a);
        double sina = Math.sin(a);
        float orgx = x - location.x;
        float orgz = z - location.y;
        x = (float)(cosa*orgx + sina*orgz) + location.x;
        z = (float)(cosa*orgz - sina*orgx) + location.y;
    }

    public void rotationZ(double a, Point location) {
        double cosa = Math.cos(a);
        double sina = Math.sin(a);
        float orgx = x - location.x;
        float orgy = y - location.y;
        x = (float)(cosa*orgx - sina*orgy) + location.x;
        y = (float)(sina*orgx + cosa*orgy) + location.y;
    }
}
