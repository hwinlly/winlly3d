package winlly3d.obj;

import java.awt.*;

/**
 * Created by winlly on 2015/1/24.
 */
public class Line2D {

    public int x1;
    public int y1;
    public int x2;
    public int y2;

    public Line2D(Point a, Point b) {
        x1 = a.x;
        y1 = a.y;
        x2 = b.x;
        y2 = b.y;
    }

    public Line2D(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
