package jp.jaxa.iss.kibo.rpc.defaultapk;

import java.util.ArrayList;

import gov.nasa.arc.astrobee.types.Point;

class Grid
{
    private static Point gridStart = new Point(10.25,-9.75,4.2);
    private static Point gridEnd = new Point(11.65,3,5.6);
    private static int xCount=50;
    private static int yCount=50;
    private static int zCount=50;
    private double x,y,z;
    private Node[][][] grid;
    private boolean[][][] surround;

    ObstacleList oblist = new ObstacleList();
    Grid()
    {
        x=gridEnd.getX()-gridStart.getX();
        y=gridEnd.getY()-gridStart.getY();
        z=gridEnd.getZ()-gridStart.getZ();

        CreatSurround(oblist.oblist);
        CreateGrid();
    }

    private void CreatSurround(ArrayList<Obstacle> oblist)
    {
        surround = new boolean[xCount][yCount][zCount];
        for(int i=0;i<xCount;i++)
            for(int j=0;j<yCount;j++)
                for(int k=0;k<zCount;k++)
                    surround[i][j][k]=false;
        for(Obstacle ob:oblist)
        {
            int xs = (int)((ob.getStartX())*xCount/x);
            int ys = (int)((ob.getStartY())*yCount/y);
            int zs = (int)((ob.getStartZ())*xCount/z);
            int xe = (int)((ob.getEndX())*xCount/x);
            int ye = (int)((ob.getEndY())*yCount/y);
            int ze = (int)((ob.getEndZ())*yCount/z);
            for(int i=xs;i<=xe;i++)
                for(int j=ys;j<=ye;j++)
                    for(int k=zs;k<=ze;k++)
                        surround[i][j][k]=true;
        }
    }

    private void CreateGrid()
    {
        grid = new Node[xCount][yCount][zCount];
        for(int i=0;i<xCount;i++)
        {
            for(int j=0;j<yCount;j++)
            {
                for(int k=0;k<zCount;k++)
                {
                    Point p = new Point(gridStart.getX()+x*i/xCount,gridStart.getY()+y*j/yCount,gridStart.getZ()+z*k/zCount);
                    grid[i][j][k]=new Node(i,j,k,p,!surround[i][j][k]);
                }
            }
        }

    }

    ArrayList<Node> GetNeighbor(Node node)
    {
        ArrayList<Node> neighbor = new ArrayList<>();
        int x=node.xNum,y=node.yNum,z=node.zNum;
        for(int i=x-1;i<=x+1;i++)
        {
            for(int j=y-1;j<=y+1;j++)
            {
                for(int k=z-1;k<=z+1;k++)
                {
                    if(i<0||i>=xCount||j<0||j>=yCount||k<0||k>=zCount) continue;
                    if(x==node.xNum&&y==node.yNum&&z==node.zNum) continue;
                    neighbor.add(grid[i][j][k]);
                }
            }
        }
        return neighbor;
    }

    Node GetNodeFromPos(Point pos)
    {
        if(pos.getX()>x||pos.getX()<0
                ||pos.getY()>y||pos.getY()<0
                ||pos.getZ()>z||pos.getZ()<0) return null;
        int xx = (int)(pos.getX()*xCount/x);
        int yy = (int)(pos.getY()*yCount/y);
        int zz = (int)(pos.getZ()*zCount/z);
        return grid[xx][yy][zz];
    }
}
