package jp.jaxa.iss.kibo.rpc.defaultapk;

import java.util.ArrayList;

import gov.nasa.arc.astrobee.types.Point;

class ObstacleList
{
    ArrayList<Obstacle> oblist = new ArrayList<>();

    ObstacleList()
    {
        oblist.add(new Obstacle(new Point(10.75,-4.9,4.8),new Point(10.95,-4.7,5.0)));
        oblist.add(new Obstacle(new Point(10.75,-6.5,3.9),new Point(11.95,-6.4,5.9)));
        oblist.add(new Obstacle(new Point(9.95,-7.2,3.9),new Point(10.85,-7.1,5.9)));
        oblist.add(new Obstacle(new Point(10.10,-8.6,5.4),new Point(11.1,-8.3,5.9)));
        oblist.add(new Obstacle(new Point(11.45,-9.0,4.1),new Point(11.95,-8.5,5.1)));
        oblist.add(new Obstacle(new Point(9.95,-9.1,4.6),new Point(10.45,-8.6,5.6)));
        oblist.add(new Obstacle(new Point(10.95,-8.4,4.9),new Point(11.15,-8.2,5.1)));
        oblist.add(new Obstacle(new Point(11.05,-8.9,4.2),new Point(11.25,-8.7,4.4)));
        oblist.add(new Obstacle(new Point(10.45,-9.1,4.6),new Point(10.65,-8.9,4.8)));
    }
}
