package org.firstinspires.ftc.teamcode.Turret;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp

public class TurretTesting extends LinearOpMode {

    private TurretHardware robot;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initializing...");
        telemetry.update();

        robot = new TurretHardware(hardwareMap, false);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        telemetry.addData("Status", "Running");
        telemetry.update();

        // run until the end of the match (driver presses STOP)
//        while (opModeIsActive()) {
//
//            if (gamepad1.dpad_up) {
//                robot.motorLift.setPower(1);
//            } else if (gamepad1.dpad_down) {
//                robot.motorLift.setPower(-0.01);
//            } else if (gamepad1.dpad_up){
//                robot.motorLift.setPower(0.01);
//            } else {
//                robot.motorLift.setPower(0);
//            }
//
////            double servoPos = robot.extenderPos;
////            if (gamepad1.y) {
////                servoPos +=0.05;
////                if (servoPos > 1) {
////                    servoPos = 1;
////                }
////
////            }
////            else if (gamepad1.b) {
////                servoPos -=0.05;
////                if (servoPos < 0) {
////                    servoPos = 0;
////                }
////            }
////            robot.servoExtend.setPosition(servoPos);
//
////            telemetry.addData( "servoPos", robot.servoExtend.getPosition());
////            telemetry.update();
//
//        }
    }
}

