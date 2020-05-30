package jp.jaxa.iss.kibo.rpc.defaultapk;

import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;

public class Target
{
    Point point;
    Quaternion quaternion;

    Target(Point p,Quaternion q)
    {
        point = p;
        quaternion = q;
    }
}
