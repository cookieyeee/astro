package jp.jaxa.iss.kibo.rpc.defaultapk;

import gov.nasa.arc.astrobee.types.Point;

public class Node
{
    int xNum,yNum,zNum;
    private Point Pos;
    int gCost,hCost;
    boolean isWalkable;
    Node parent;
    
    //87

    Node(int x, int y, int z,Point p, boolean iswalkable)
    {
        xNum=x;
        yNum=y;
        zNum=z;
        Pos = p;
        isWalkable=iswalkable;
    }

    int fCost()
    {
        return gCost+hCost;
    }

    public String toString()
    {
        return "["+xNum+","+yNum+"]";
    }

    public Point getPos()
    {
        return Pos;
    }
}
