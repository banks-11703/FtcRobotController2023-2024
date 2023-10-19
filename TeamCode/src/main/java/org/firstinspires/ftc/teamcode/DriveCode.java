package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp
@Config
public class DriveCode extends DriveCodeCommon {
//    Servo outakeLatch,flipper;
//    public static double pos0 = 0.74;
//    public static double pos1 = 0.79;
//    public static double pos2 = 0.9;
//    public static double flipperscore = 0.52;
//    public static double flipperintake = 1;


    @Override
    public void runOpMode() {
//        outakeLatch = hardwareMap.get(Servo.class,"o");
//        flipper = hardwareMap.get(Servo.class,"f");
        FtcDashboard dashboard = FtcDashboard.getInstance();
        Telemetry dashboardTelemetry = dashboard.getTelemetry();
        Initialization();
        waitForStart();
        if (isStopRequested()) return;
        while (opModeIsActive() && !isStopRequested()) {
            updateButtons();
            rawDriving();
            intake();
            outake();
            lift();

//            switch(b1.getCycle()) {
//                case 0:
//                    outakeLatch.setPosition(pos0);
//                    break;
//                case 1:
//                    outakeLatch.setPosition(pos1);
//                    break;
//                case 2:
//                    outakeLatch.setPosition(pos2);
//            }
//            if (y1.isToggled()){
//                flipper.setPosition(flipperscore);
//            }else{
//                flipper.setPosition(flipperintake);
//            }
//            dashboardTelemetry.addData("Latch Pos: ",outakeLatch.getPosition());
//            dashboardTelemetry.addData("Flipper Pos: ",flipper.getPosition());
//            dashboardTelemetry.update();
        }
    }
}
