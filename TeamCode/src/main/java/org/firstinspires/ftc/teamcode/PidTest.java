package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.MotorControlAlgorithm;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.concurrent.TimeUnit;

@TeleOp
@Config
public class PidTest extends LinearOpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotorEx spinner = null;
    private boolean buttonAWasPressed = false;
    public static double Kp = 0;
    public static double Ki = 0;
    public static double Kd = 0;
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        spinner = hardwareMap.get(DcMotorEx.class, "spinnyThing");
        FtcDashboard dashboard = FtcDashboard.getInstance();
        Telemetry dashboardTelemetry = dashboard.getTelemetry();
        dashboardTelemetry.addData("Velocity", spinner.getVelocity());
        dashboardTelemetry.addData("Target",0);
        dashboardTelemetry.update();
        spinner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



//        long integralSumLimit = Math.round(0.25 / Ki);
//
        double reference = 0;
//        double lastReference = reference;
//
//        double integralSum = 0;
//
//        double error = 0;
//        double lastError = 0;
//        double encoderPosition = 0;
//        double derivative = 0;
//        double out = 0;

        waitForStart();
        runtime.reset();


        while (opModeIsActive() && !isStopRequested()) {

            if (gamepad1.a && !buttonAWasPressed) {
                if (reference == 0) {
                    reference = 2000;
                } else {
                    reference = 0;
                }
                buttonAWasPressed = true;
            } else if (!gamepad1.a && buttonAWasPressed) {
                buttonAWasPressed = false;
            }
            spinner.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, new PIDFCoefficients(Kp,Ki,Kd,0, MotorControlAlgorithm.LegacyPID));
            spinner.setVelocity(reference);
            spinner.setPower(1);
            telemetry.addData("Velocity: ",spinner.getVelocity());
            telemetry.addData("Target",reference);
            telemetry.update();


            dashboardTelemetry.addData("Velocity", spinner.getVelocity());
            dashboardTelemetry.addData("Target",reference);
            dashboardTelemetry.update();
//            // Elapsed timer class from SDK, please use it, it's epic
//            ElapsedTime timer = new ElapsedTime();
//
//            while (spinner.getVelocity() != reference && !isStopRequested()) {
//
//                if (gamepad1.a && !buttonAWasPressed) {
//                    if (reference == 0) {
//                        reference = 2000;
//                    } else {
//                        reference = 0;
//                    }
//                    buttonAWasPressed = true;
//                } else if (!gamepad1.a && buttonAWasPressed) {
//                    buttonAWasPressed = false;
//                }
//
//
//                // obtain the encoder position
//                encoderPosition = spinner.getVelocity();
//                // calculate the error
//                error = reference - encoderPosition;
//
//                // rate of change of the error
//                derivative = (error - lastError) / timer.time();
//
//                // sum our integral
//                integralSum = integralSum + (error * timer.time(TimeUnit.SECONDS));
//
////                // set a limit on our integral sum
////                if (integralSum > integralSumLimit) {
////                    integralSum = integralSumLimit;
////                }
////                if (integralSum < -integralSumLimit) {
////                    integralSum = -integralSumLimit;
////                }
//
//                out = (Kp * error) + (Ki * integralSum) + (Kd * derivative);
//
//                spinner.setPower(out);
//
//                lastError = error;
//
//                // reset the timer for next time
//                timer.reset();
//
//                lastReference = reference;
//                // reset the integral if the reference is changed.
//                if (reference != lastReference) {
//                    integralSum = 0;
//                }
//                telemetry.addData("Velocity: ",spinner.getVelocity());
//                telemetry.addData("Reference: ",reference);
//                telemetry.addData("Error:",error);
//                telemetry.addData("Power: ",out);
//                telemetry.addData("InLoop: ",true);
//                telemetry.update();
//            }
//            telemetry.addData("Velocity: ",spinner.getVelocity());
//            telemetry.addData("Error: ",error);
//            telemetry.addData("Power: ",out);
//            telemetry.update();
        }
    }
}
