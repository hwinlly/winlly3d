package winlly3d.obj;

import winlly3d.ui.LinesObj;
import winlly3d.ui.VisibleObj;

import java.awt.*;

/**
 * Created by winlly on 2015/1/24.
 */
public class Box3D extends Object3D {

    public Box3D(Point3D p, int width) {
        points.add(p);
        points.add(new Point3D(points.get(0).x + width, points.get(0).y,         points.get(0).z));
        points.add(new Point3D(points.get(0).x + width, points.get(0).y,         points.get(0).z + width));
        points.add(new Point3D(points.get(0).x,         points.get(0).y,         points.get(0).z + width));
        points.add(new Point3D(points.get(0).x,         points.get(0).y - width, points.get(0).z));
        points.add(new Point3D(points.get(0).x + width, points.get(0).y - width, points.get(0).z));
        points.add(new Point3D(points.get(0).x + width, points.get(0).y - width, points.get(0).z + width));
        points.add(new Point3D(points.get(0).x,         points.get(0).y - width, points.get(0).z + width));
    }

    @Override
    public VisibleObj getViewObj() {
        try {
            LinesObj view = new LinesObj();
            Point p1 = perspectiveProjection(points.get(0));
            Point p2 = perspectiveProjection(points.get(1));
            Point p3 = perspectiveProjection(points.get(2));
            Point p4 = perspectiveProjection(points.get(3));
            view.addLine(new Line2D(p1, p2));
            view.addLine(new Line2D(p2, p3));
            view.addLine(new Line2D(p3, p4));
            view.addLine(new Line2D(p4, p1));

            Point p5 = perspectiveProjection(points.get(4));
            Point p6 = perspectiveProjection(points.get(5));
            Point p7 = perspectiveProjection(points.get(6));
            Point p8 = perspectiveProjection(points.get(7));
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
