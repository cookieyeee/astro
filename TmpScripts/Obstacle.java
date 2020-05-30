package jp.jaxa.iss.kibo.rpc.defaultapk;

import gov.nasa.arc.astrobee.types.Point;

class Obstacle
{
    Point Start;
    Point End;
    Obstacle(Point s,Point e)
    {
        Start = s;
        End = e;
    }

    public double getStartX()
    {
        return Start.getX()-0.22f;
    }
    public double getStartY()
    {
        return Start.getY()-0.22f;
    }
    public double getStartZ()
    {
        return Start.getZ()-0.22f;
    }
    public double getEndX()
    {
        return End.getX()+0.22f;
    }
    public double getEndY()
    {
        return End.getY()+0.22f;
    }
    public double getEndZ()
    {
        return End.getZ()+0.22f;
    }
}
