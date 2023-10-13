package org.firstinspires.ftc.teamcode;


import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp
@Config
public class PidTest extends LinearOpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotorEx spinner = null;
    private Servo outake;
    private boolean buttonAWasPressed = false;
//    public static double Kp = 10;
//    public static double Ki = 3;
//    public static double Kd = 0;
//    public static double Kf = 0;
//    public static int target = 0;
    public static double closedServo = 0;
    public static double openServo = 0;
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        spinner = hardwareMap.get(DcMotorEx.class, "spinnyThing");
        outake = hardwareMap.get(Servo.class,"o");
//        FtcDashboard dashboard = FtcDashboard.getInstance();
//        Telemetry dashboardTelemetry = dashboard.getTelemetry();
//        dashboardTelemetry.addData("Reality", spinner.getCurrentPosition());
//        dashboardTelemetry.addData("Target", 0);
//        dashboardTelemetry.update();
//        spinner.setTargetPosition(target);
//        spinner.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        spinner.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        GamepadEx b1 = new GamepadEx();
        GamepadEx a1 = new GamepadEx();


        waitForStart();
        runtime.reset();


        while (opModeIsActive() && !isStopRequested()) {
            a1.updateButton(gamepad1.a);
            if (a1.isPressed()){
                outake.setPosition(openServo);
            }else{
                outake.setPosition(closedServo);
            }
//            if (gamepad1.a && !buttonAWasPressed) {
//                if (target == 0) {
//                    target = 2000;
//                    spinner.setPower(1);
//                } else {
//                    target = 0;
//                    spinner.setPower(0);
//                }
//                buttonAWasPressed = true;
//            } else if (!gamepad1.a && buttonAWasPressed) {
//                buttonAWasPressed = false;
//            }
//            spinner.setPIDCoefficients(DcMotorEx.RunMode.RUN_TO_POSITION, new PIDCoefficients(Kp, Ki, Kd));
//            spinner.setTargetPosition(target);

//            telemetry.addData("Reality: ", spinner.getCurrentPosition());
//            telemetry.addData("Target", target);
            b1.updateButton(gamepad1.b);
//            telemetry.addData("Pressed",b1.isPressed());
//            telemetry.addData("Toggled",b1.isToggled());
//            telemetry.update();


//            dashboardTelemetry.addData("Reality", spinner.getCurrentPosition());
//            dashboardTelemetry.addData("Target", target);
//            dashboardTelemetry.addData("Power", spinner.getPower());
//            dashboardTelemetry.addData("Pid: ",spinner.getPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER));
//            dashboardTelemetry.update();
        }
    }
}
