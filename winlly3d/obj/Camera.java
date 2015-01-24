package winlly3d.obj;

import winlly3d.obj.Point3D;

import java.awt.*;

/**
 * Created by winlly on 2015/1/24.
 */
public class Camera {
    private float nearFace = 1000.0f;
    private float farFace  = 50000.0f;

    public Camera() {

    }

    public Camera(float n, float f) {
        if(f <= n) {
            throw new IllegalArgumentException("farFace " + f + " can not smaller than nearFace " + n);
        }
        nearFace = n;
        farFace = f;
    }

    public float getNearFace() {
        return nearFace;
    }

    public float getFarFace() {
        return farFace;
    }

    public void setNearFace(float n) {
        nearFace = n;
    }

    public void setFarFace(float f) {
        farFace = f;
    }

    public Point perspectiveProjection(float x, float y, float z) {
        if(z < 0 || z > farFace) {
            return null;
        }
        Point location = new Point();
        location.x = Math.round(x*nearFace/(z + nearFace));
        location.y = Math.round(y*nearFace/(z + nearFace));
        return location;
    }

    public Point perspectiveProjection(Point3D p) {
        return perspectiveProjection(p.x, p.y, p.z);
    }
}
