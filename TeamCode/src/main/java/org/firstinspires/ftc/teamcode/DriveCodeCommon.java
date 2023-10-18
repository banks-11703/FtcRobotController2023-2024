package org.firstinspires.ftc.teamcode;


import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.List;

@TeleOp(name = "DriveCodeCommon", group = "Linear Opmode")
@Config
@Disabled
public class DriveCodeCommon extends LinearOpMode {
    double[] latch = {0,0.5,1};
    GamepadEx a1 = new GamepadEx();
    GamepadEx b1 = new GamepadEx(3,true);
    GamepadEx x1 = new GamepadEx();
    GamepadEx y1 = new GamepadEx();
    GamepadEx lb1 = new GamepadEx();
    GamepadEx rb2 = new GamepadEx(4,true);
    GamepadEx lb2 = new GamepadEx(4,false);

    int[] liftTargetPos = {0,100,200,300};

    @Override
    public void runOpMode() throws InterruptedException {

    }

    public void Initialization() {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        telemetry.update();
        drive.leftLift.setTargetPosition(liftTargetPos[0]);
        drive.rightLift.setTargetPosition(liftTargetPos[0]);
        drive.leftLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drive.rightLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();
    }
    public void updateButtons(){
        a1.updateButton(gamepad1.a);
        b1.updateButton(gamepad1.b);
        x1.updateButton(gamepad1.x);
        y1.updateButton(gamepad1.y);
        lb1.updateButton(gamepad1.left_bumper);
        rb2.updateButton(gamepad2.right_bumper);
        if(rb2.isPressed()){
            lb2.setToggle(rb2.getCycle());
        }
        lb2.updateButton(gamepad2.left_bumper);
        if(lb2.isPressed()){
            rb2.setToggle(lb2.getCycle());
        }
    }
    public void rawDriving() {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        drive.frontLeft.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x + (gamepad1.right_stick_x * 0.5));
        drive.frontRight.setPower(-gamepad1.left_stick_y - gamepad1.left_stick_x - (gamepad1.right_stick_x * 0.5));
        drive.backRight.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x - (gamepad1.right_stick_x * 0.5));
        drive.backLeft.setPower(-gamepad1.left_stick_y - gamepad1.left_stick_x + (gamepad1.right_stick_x * 0.5));

    }
    public void intake(){
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        if (a1.isToggled()){
           drive.intake.setPower(-1);
        }else if (lb1.isPressed()){
            drive.intake.setPower(1);
        } else{
            drive.intake.setPower(0);
        }
    }
    public void lift(){
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        drive.leftLift.setTargetPosition(liftTargetPos[rb2.getCycle()]);
        drive.rightLift.setTargetPosition(liftTargetPos[rb2.getCycle()]);
        drive.leftLift.setPower(1);
        drive.rightLift.setPower(1);

    }
    public void outake(){
        MecanumDrive drive = new MecanumDrive(hardwareMap,new Pose2d(0,0,0));

    }
    public void moveLatch(){
        MecanumDrive drive = new MecanumDrive(hardwareMap,new Pose2d(0,0,0));
        drive.outakeLatch.setPosition(latch[b1.getCycle()]);
    }

}
