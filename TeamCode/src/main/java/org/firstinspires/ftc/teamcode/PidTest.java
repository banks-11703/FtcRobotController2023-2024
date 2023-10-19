package org.firstinspires.ftc.teamcode;


import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp
@Config
public class PidTest extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    public static double rKp = 10;
    public static double rKi = 3;
    public static double rKd = 0;
    public static double rKf = 0;

    public static double lKp = 10;
    public static double lKi = 3;
    public static double lKd = 0;
    public static double lKf = 0;

    public static int liftHeight0 = 0;
    public static int liftHeight1 = 100;
    public static int liftHeight2 = 200;
    public static int liftHeight3 = 300;
    int[] targets = {liftHeight0,liftHeight1,liftHeight2,liftHeight3};

    DcMotorEx rightLift, leftLift;



    GamepadEx rb2 = new GamepadEx(4,true);
    GamepadEx lb2 = new GamepadEx(4,false);
    @Override
    public void runOpMode() {
        leftLift = hardwareMap.get(DcMotorEx.class,"ll");
        rightLift = hardwareMap.get(DcMotorEx.class,"rl");
//        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        FtcDashboard dashboard = FtcDashboard.getInstance();
        Telemetry dashboardTelemetry = dashboard.getTelemetry();
        dashboardTelemetry.addData("leftLift pos", leftLift.getCurrentPosition());
        dashboardTelemetry.addData("RightLift pos", rightLift.getCurrentPosition());
        dashboardTelemetry.addData("Target", 0);
        dashboardTelemetry.update();
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();


        while (opModeIsActive() && !isStopRequested()) {
            rb2.updateButton(gamepad2.right_bumper);
            if(rb2.isPressed()){
                lb2.setToggle(rb2.getCycle());
            }
            lb2.updateButton(gamepad2.left_bumper);
            if(lb2.isPressed()){
                rb2.setToggle(lb2.getCycle());
            }

            targets[0] = liftHeight0;
            targets[1] = liftHeight1;
            targets[2] = liftHeight2;
            targets[3] = liftHeight3;

            rightLift.setPIDCoefficients(DcMotorEx.RunMode.RUN_TO_POSITION, new PIDCoefficients(rKp, rKi, rKd));
            rightLift.setTargetPosition(targets[rb2.getCycle()]);
            rightLift.setPIDCoefficients(DcMotorEx.RunMode.RUN_TO_POSITION, new PIDCoefficients(rKp, rKi, rKd));
            rightLift.setTargetPosition(targets[rb2.getCycle()]);


            telemetry.addData("leftLift pos", leftLift.getCurrentPosition());
            telemetry.addData("RightLift pos", rightLift.getCurrentPosition());
            telemetry.addData("Target", 0);
            telemetry.update();

            dashboardTelemetry.addData("leftLift pos", leftLift.getCurrentPosition());
            dashboardTelemetry.addData("RightLift pos", rightLift.getCurrentPosition());
            dashboardTelemetry.addData("Target", 0);
            dashboardTelemetry.update();
        }
    }
}
