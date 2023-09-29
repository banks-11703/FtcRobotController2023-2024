package org.firstinspires.ftc.teamcode;


import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.concurrent.TimeUnit;

@TeleOp(name = "DriveCodeCommon", group = "Linear Opmode")
@Config
@Disabled
public class DriveCodeCommon extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

    }

    public void Initialization() {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        telemetry.update();
        waitForStart();
    }

    public void ServoGoBrr() {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        if (gamepad1.a) {
            //            drive.droneShooter.setPosition(0);
        } else {
            //            drive.droneShooter.setPosition(1);
        }
    }
}
