package jp.jaxa.iss.kibo.rpc.defaultapk;

import org.opencv.objdetect.QRCodeDetector;

import java.util.ArrayList;

import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;
import jp.jaxa.iss.kibo.rpc.api.KiboRpcService;
/**
 * Class meant to handle commands from the Ground Data System and execute them in Astrobee
 */

public class YourService extends KiboRpcService {
    @Override
    protected void runPlan1()
    {
        QRCodeDetector qrCodeDetector = new QRCodeDetector();
        PathFinding pf = new PathFinding();
        Grid grid = new Grid();
        TargetList targetList = new TargetList();

        double[] Data = new double[6];

        api.judgeSendStart();
        for(int i=0;i<7;i++)
        {
            ArrayList<Node> path = pf.Astar(targetList.targets[i].point,targetList.targets[i+1].point,grid);
            for(Node node:path)
            {
                Point pos = node.getPos();
                api.moveTo(pos,targetList.targets[i+1].quaternion,true);
                String qrCode = qrCodeDetector.detectAndDecode(api.getMatNavCam());
                api.judgeSendDiscoveredQR(i,qrCode);
                Data[i] = Double.parseDouble(qrCode);
            }
        }

        api.judgeSendDiscoveredAR("87");
        api.laserControl(true);

        api.judgeSendFinishSimulation();
    }

    @Override
    protected void runPlan2(){
        // write here your plan 2
    }

    @Override
    protected void runPlan3(){
        // write here your plan 3
    }

}

