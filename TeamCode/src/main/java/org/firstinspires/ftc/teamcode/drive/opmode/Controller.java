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

/**
 * This is a simple teleop routine for testing localization. Drive the robot around like a normal
 * teleop routine and make sure the robot's estimated pose matches the robot's actual pose (slight
 * errors are not out of the ordinary, especially with sudden drive motions). The goal of this
 * exercise is to ascertain whether the localizer has been configured properly (note: the pure
 * encoder localizer heading may be significantly off if the track width has not been tuned).
 */
@TeleOp(group = "drive")
public class Controller extends LinearOpMode {

    private SampleMecanumDrive drive;
    private RobotHardware robot;

    private TurretControl TC = null;

    @Override

    public void runOpMode() {
        telemetry.addData("Status", "Initializing...");
        telemetry.update();

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        robot = new RobotHardware(hardwareMap, true);

        drive.setPoseEstimate(new Pose2d(10, 10, Math.toRadians(90)));

        // Init turret control
        TC = new TurretControl();
        TC.robot = robot;
        TC.speed = 0.4;
        TC.errorMargin = 1;
        // init terminate key

        telemetry.addData("Status", "Initialized");

        telemetry.update();
        waitForStart();

        telemetry.addData("Status", "Running");
        telemetry.update();

        while (opModeIsActive()) {
            driveControl();
//            poseTelemetry();
            telemetry.update();
        }
    }


    private void driveControl() {
        if (gamepad1.y) {
            // Lift up

            TC.lift_move_to(2000);
        } else if (gamepad1.a) {
            // Lift down

            TC.lift_move_to(0);
        } else if (gamepad1.x) {
            // Turret left
            // robot.motorTurret.setPower(-0.01);

            TC.overide = true;
        }
        else if (gamepad1.b) {
            // Turret right
        } else {
            robot.motorLiftL.setPower(0);
            robot.motorLiftR.setPower(0);
            robot.motorTurret.setPower(0);
        }

        telemetry.addData("motorLiftL position", robot.motorLiftL.getCurrentPosition());
        telemetry.addData("motorLiftR position", robot.motorLiftR.getCurrentPosition());

        telemetry.addData("motorTurret position", robot.motorTurret.getCurrentPosition());

    }

}



