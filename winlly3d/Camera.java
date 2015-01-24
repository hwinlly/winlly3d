package winlly3d;

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

    Point PerspectiveProjection(float x, float y, float z) {
        if(z <= 0 || z >= farFace) {
            return null;
        }
        Point location = new Point();
        location.x = Math.round(x*nearFace/(z + nearFace));
        location.y = Math.round(y*nearFace/(z + nearFace));
        return location;
    }

    Point PerspectiveProjection(Point3D p) {
        return PerspectiveProjection(p.x, p.y, p.z);
    }
}
