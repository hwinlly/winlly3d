package winlly3d.obj;

import winlly3d.ui.LinesObj;
import winlly3d.ui.VisibleObj;

import java.awt.*;

/**
 * Created by winlly on 2015/1/24.
 */
public class Box3D extends Object3D {

    Point3D a1, b1, c1, d1;
    Point3D a2, b2, c2, d2;

    public Box3D(Point3D p, int width) {
        this.a1 = p;
        b1 = new Point3D(a1.x + width, a1.y,         a1.z);
        c1 = new Point3D(a1.x + width, a1.y,         a1.z + width);
        d1 = new Point3D(a1.x,         a1.y,         a1.z + width);
        a2 = new Point3D(a1.x,         a1.y - width, a1.z);
        b2 = new Point3D(b1.x,         b1.y - width, b1.z);
        c2 = new Point3D(c1.x,         c1.y - width, c1.z);
        d2 = new Point3D(d1.x,         d1.y - width, d1.z);
    }

    public Box3D(Point3D a1, Point3D b1,Point3D c1, Point3D d1, Point3D a2, Point3D b2,Point3D c2, Point3D d2) {
        this.a1 = a1;
        this.a2 = a2;
        this.b1 = b1;
        this.b2 = b2;
        this.c1 = c1;
        this.c2 = c2;
        this.d1 = d1;
        this.d2 = d2;
    }

    @Override
    public void move(Point3D p) {
        a1.move(p);
        a2.move(p);
        b1.move(p);
        b2.move(p);
        c1.move(p);
        c2.move(p);
        d1.move(p);
        d2.move(p);
    }

    @Override
    public VisibleObj getViewObj() {
        try {
            LinesObj view = new LinesObj();
            Point p1 = perspectiveProjection(a1);
            Point p2 = perspectiveProjection(b1);
            Point p3 = perspectiveProjection(c1);
            Point p4 = perspectiveProjection(d1);
            view.addLine(new Line2D(p1, p2));
            view.addLine(new Line2D(p2, p3));
            view.addLine(new Line2D(p3, p4));
            view.addLine(new Line2D(p4, p1));

            Point p5 = perspectiveProjection(a2);
            Point p6 = perspectiveProjection(b2);
            Point p7 = perspectiveProjection(c2);
            Point p8 = perspectiveProjection(d2);
            view.addLine(new Line2D(p5, p6));
            view.addLine(new Line2D(p6, p7));
            view.addLine(new Line2D(p7, p8));
            view.addLine(new Line2D(p8, p5));

            view.addLine(new Line2D(p1, p5));
            view.addLine(new Line2D(p2, p6));
            view.addLine(new Line2D(p3, p7));
            view.addLine(new Line2D(p4, p8));
            return view;
        } catch(NullPointerException ex) {
            return null;
        }
    }
}
