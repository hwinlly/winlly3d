package winlly3d.obj;

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
}
