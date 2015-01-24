package winlly3d.obj;

import winlly3d.ui.LinesObj;
import winlly3d.ui.VisibleObj;

import java.awt.*;

public class Line3D extends Object3D {

    public Line3D(Point3D start, Point3D stop) {
        points.add(start);
        points.add(stop);
    }

    @Override
    public VisibleObj getViewObj() {
        try {
            LinesObj view = new LinesObj();
            Point p1 = perspectiveProjection(points.get(0));
            Point p2 = perspectiveProjection(points.get(1));
            view.addLine(new Line2D(p1, p2));
            return view;
        } catch(NullPointerException ex) {
            return null;
        }
    }
}
