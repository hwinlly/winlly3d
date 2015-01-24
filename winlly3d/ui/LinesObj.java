package winlly3d.ui;

import winlly3d.obj.Line2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by winlly on 2015/1/24.
 */
public class LinesObj implements VisibleObj {

    private final ArrayList<Line2D> lines = new ArrayList<Line2D>();

    @Override
    public void paintObject(Graphics g, int w, int h) {
        w = w >> 1;
        h = h >> 1;
        Iterator<Line2D> iter = lines.iterator();
        while(iter.hasNext()) {
            Line2D line = iter.next();
            g.drawLine(w + line.x1,  h - line.y1,  w + line.x2, h - line.y2);
        }
    }

    public boolean addLine(Line2D line) {
        return lines.add(line);
    }
}
