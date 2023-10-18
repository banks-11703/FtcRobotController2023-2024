package org.firstinspires.ftc.teamcode;


import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.Servo;
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
    int[] target = {liftHeight0,liftHeight1,liftHeight2,liftHeight3};

    GamepadEx rb2 = new GamepadEx(4,true);
    GamepadEx lb2 = new GamepadEx(4,false);
    @Override
    public void runOpMode() {

        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));        FtcDashboard dashboard = FtcDashboard.getInstance();
        Telemetry dashboardTelemetry = dashboard.getTelemetry();
        dashboardTelemetry.addData("leftLift pos", drive.leftLift.getCurrentPosition());
        dashboardTelemetry.addData("RightLift pos", drive.rightLift.getCurrentPosition());
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

            int[] target = {liftHeight0,liftHeight1,liftHeight2,liftHeight3};
            drive.rightLift.setPIDCoefficients(DcMotorEx.RunMode.RUN_TO_POSITION, new PIDCoefficients(rKp, rKi, rKd));
            drive.rightLift.setTargetPosition(target[rb2.getCycle()]);
            drive.rightLift.setPIDCoefficients(DcMotorEx.RunMode.RUN_TO_POSITION, new PIDCoefficients(rKp, rKi, rKd));
            drive.rightLift.setTargetPosition(target[rb2.getCycle()]);


            telemetry.addData("leftLift pos", drive.leftLift.getCurrentPosition());
            telemetry.addData("RightLift pos", drive.rightLift.getCurrentPosition());
            telemetry.addData("Target", 0);
            telemetry.update();

            dashboardTelemetry.addData("leftLift pos", drive.leftLift.getCurrentPosition());
            dashboardTelemetry.addData("RightLift pos", drive.rightLift.getCurrentPosition());
            dashboardTelemetry.addData("Target", 0);
            dashboardTelemetry.update();
        }
    }
}
