package org.firstinspires.ftc.teamcode;


import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

import java.util.concurrent.TimeUnit;
@TeleOp(name = "DriveCodeCommon", group = "Linear Opmode")
@Config
@Disabled
public class DriveCodeCommon extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

    }
public void Initialization(){
    SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
    telemetry.update();
    waitForStart();
}
public void ServoGoBrr(){
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        if (gamepad1.a) {
            drive.droneShooter.setPosition(0);
        }else{
            drive.droneShooter.setPosition(1);
        }
}
}
