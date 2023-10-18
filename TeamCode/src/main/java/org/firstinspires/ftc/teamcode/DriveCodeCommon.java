package org.firstinspires.ftc.teamcode;


import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "DriveCodeCommon", group = "Linear Opmode")
@Config
@Disabled
public class DriveCodeCommon extends LinearOpMode {
    GamepadEx a1 = new GamepadEx();
    GamepadEx b1 = new GamepadEx();
    GamepadEx x1 = new GamepadEx();
    GamepadEx y1 = new GamepadEx();
    GamepadEx lb1 = new GamepadEx();
    GamepadEx rb2 = new GamepadEx(4,true);
    @Override

    public void runOpMode() throws InterruptedException {

    }

    public void Initialization() {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        telemetry.update();

        waitForStart();
    }
    public void updateButtons(){
        a1.updateButton(gamepad1.a);
        b1.updateButton(gamepad1.b);
        x1.updateButton(gamepad1.x);
        y1.updateButton(gamepad1.y);
        lb1.updateButton(gamepad1.left_bumper);
        rb2.updateButton(gamepad2.right_bumper);


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
           drive.intake.setPower(1);
        }else if (lb1.isPressed()){
            drive.intake.setPower(-1);
        } else{
            drive.intake.setPower(0);
        }
    }
    public void lift(){
//        if (b1.isPressed()){
//
//        }
    }
    public void outake(){
        MecanumDrive drive = new MecanumDrive(hardwareMap,new Pose2d(0,0,0));
        if (gamepad1.a){
            drive.outake.setPosition(1);
        }else if (gamepad1.b){
            drive.outake.setPosition(0.5);
        }else{
            drive.outake.setPosition(0);
        }
    }
}
