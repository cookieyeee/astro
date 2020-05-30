package jp.jaxa.iss.kibo.rpc.defaultapk;

import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;

public class TargetList
{
    Target[] targets = new Target[7];

    TargetList()
    {
        targets[0] = new Target(new Point(10.95,-3.75,4.85),new Quaternion(0,0,0.707f,-0.707f));
        targets[1] = new Target(new Point(11.5,-5.7,4.5),new Quaternion(0,0,0,1));
        targets[2] = new Target(new Point(11,-6,5.55),new Quaternion(0,-0.7071068f,0,0.7071068f));
        targets[3] = new Target(new Point(11,-5.5,4.33),new Quaternion(0,0.7071068f,0,0.7071068f));
        targets[4] = new Target(new Point(10.30,-7.5,4.7),new Quaternion(0,0,1,0));
        targets[5] = new Target(new Point(11.5,-8,5),new Quaternion(0,0,0,1));
        targets[6] = new Target(new Point(11,-7.7,5.55),new Quaternion(0,-0.7071068f,0,0.7071068f));
    }
}
