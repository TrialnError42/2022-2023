package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.Turret.TurretControl;

import java.util.HashMap;

/** * This is a simple teleop routine for testing localization. Drive the robot around like a normal
 * teleop routine and make sure the robot's estimated pose matches the robot's actual pose (slight
 * errors are not out of the ordinary, especially with sudden drive motions). The goal of this
 * exercise is to ascertain whether the localizer has been configured properly (note: the pure
 * encoder localizer heading may be significantly off if the track width has not been tuned).
 */
@TeleOp(group = "drive")
public class robotTeleOp extends LinearOpMode {
    DcMotor frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
    DcMotor backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
    DcMotor frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
    DcMotor backRightMotor = hardwareMap.dcMotor.get("backRightMotor");
    DcMotor leftSlides = hardwareMap.dcMotor.get("leftSlides");
    DcMotor rightSlides = hardwareMap.dcMotor.get("rightSlides");
    DcMotor intake = hardwareMap.dcMotor.get("intake");



    float maxDistanceInTicks = 1000; //TODO: find value in ticks(for now it's going to be 1000 ticks)
    public void runOpMode() {
        telemetry.addData("Status", "Initializing...");
        telemetry.update();

        leftSlides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftSlides.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        rightSlides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightSlides.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftSlides.setDirection(DcMotorSimple.Direction.REVERSE);

        // Reverse the right side motors. This may be wrong for your setup.
        // If your robot moves backwards when commanded to go forwards,
        // reverse the left side instead.
        // See the note about this earlier on this page.
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);


        while (opModeIsActive()) {
            liftControl();
            driveControl();
            intakeControl();
            telemetry.addData("Left Slides Current Position(in ticks): ",leftSlides.getCurrentPosition());
            telemetry.addData("Left Slides Current Position(in ticks): ",rightSlides.getCurrentPosition());
        }
    }
    private void driveControl() {
        double scale = 0.6;
        if (gamepad1.left_bumper) {
            scale = 1.0;
        } else if (gamepad1.left_trigger > 0.3) {
            scale = 0.3;
        }
        double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
        double x = gamepad1.left_stick_x; // Counteract imperfect strafing
        double rx = gamepad1.right_stick_x;

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);

    }
    private void intakeControl(){
        if(gamepad1.right_trigger >= 0.3){
            intake.setPower(0.8);
        }
        if(gamepad1.left_bumper){
            intake.setPower(-0.8);
        }
    }
    private void liftControl() {
       //code allows for the lift of the thing
        // presets

        //granular control
        if(gamepad1.left_trigger >= 0.3){
            leftSlides.setPower(0.1);
            rightSlides.setPower(0.1);
        } else{
            leftSlides.setPower(0);
            rightSlides.setPower(0);
        }
    }
}
