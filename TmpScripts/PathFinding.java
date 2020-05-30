package jp.jaxa.iss.kibo.rpc.defaultapk;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Collections;

import gov.nasa.arc.astrobee.types.Point;

public class PathFinding
{
    ArrayList<Node> Astar(Point s,Point t, Grid grid)
    {
        /*Replace by Lambda
        Comparator<Node> c= new Comparator<Node>()
        {
            public int compare(Node n1, Node n2)
            {
                if(n1.fCost()==n2.fCost()) if(n1.gCost>n2.gCost) return 1;
                if(n1.fCost()>n2.fCost())return 1;
                return -1;
            }
        };
        */
        Comparator<Node> c= (n1, n2) -> {
            if(n1.fCost()==n2.fCost()) if(n1.gCost>n2.gCost) return 1;
            if(n1.fCost()>n2.fCost())return 1;
            return -1;
        };

        PriorityQueue<Node> OpenSet = new PriorityQueue<>(c);
        HashSet<Node> CloseSet = new HashSet<>();


        Node start = grid.GetNodeFromPos(s);
        Node target = grid.GetNodeFromPos(t);

        OpenSet.add(start);

        while(true)
        {
            Node currentNode = OpenSet.poll();

            OpenSet.remove(currentNode);
            CloseSet.add(currentNode);

            if(currentNode.equals(target)) return GetPath(start,target);

            for(Node n:grid.GetNeighbor(currentNode))
            {
                if(!n.isWalkable||CloseSet.contains(n)) continue;
                int Dis = GetDistance(currentNode,n)+currentNode.gCost;
                if(!OpenSet.contains(n)||Dis<n.gCost)
                {
                    n.gCost=Dis;
                    n.hCost=GetDistance(n,target);
                    n.parent=currentNode;
                    if(!OpenSet.contains(n)) OpenSet.add(n);
                }
            }
        }
    }

    ArrayList<Node> GetPath(Node start, Node target)
    {
        ArrayList<Node> path = new ArrayList<>();
        path.add(target);
        Node curr=target;
        while(!curr.equals(start))
        {
            curr = curr.parent;
            path.add(curr);
        }
        Collections.reverse(path);
        return path;
    }

    int GetDistance(Node s,Node e)
    {
        int x = Math.abs(e.xNum - s.xNum);
        int y = Math.abs(e.yNum - s.yNum);
        int z = Math.abs(e.zNum - s.zNum);
        if(x>y)
        {
            if(y>z) return GetDis(x,y,z);
            else return GetDis(x,z,y);
        }
        else if(y>x)
        {
            if(x>z) return GetDis(y,x,z);
            else return GetDis(y,z,x);
        }
        else
        {
            if(y>x) return GetDis(z,y,x);
            else return GetDis(z,x,y);
        }
    }

    int GetDis(int l,int m,int s)
    {
        return(l-m)*1732+(m-s)*1414+s*1000;
    }
}