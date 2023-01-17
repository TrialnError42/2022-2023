package org.firstinspires.ftc.teamcode.Turret;

import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.apache.commons.math3.stat.regression.MultipleLinearRegression;
import org.firstinspires.ftc.teamcode.drive.opmode.RobotHardware;

public class TurretControl {

    public RobotHardware robot = null;
    public boolean overide = false;
    public double speed = 0.2;
    public double errorMargin = 100;
    // Add terminate button here

//    private DcMotor MLL = robot.motorLiftL;
//    private DcMotor MLR = robot.motorLiftR;
//    private  DcMotor MT = robot.motorTurret;

    public void lift_move_to(int pos) {
        // Move lift specified number
        while (robot.motorLiftR.getCurrentPosition() > pos+errorMargin || robot.motorLiftR.getCurrentPosition() < pos-errorMargin) {
            // Replace overide with termination key
            if (!overide) {
                if (robot.motorLiftR.getCurrentPosition() < pos) {
                    robot.motorLiftR.setPower(speed);
                } else if (robot.motorLiftR.getCurrentPosition() > pos) {
                    robot.motorLiftR.setPower(-speed);
                }
            } else {
                break;
            }
        }


        return;
    }
    public void turret_move_to() {
        // Move turret specified number

        return;
    }
    public void lift_move() {
        // move lift specified amount

        return;
    }
    public void turret_move() {
        // move turret specified amount

        return;
    }

}
