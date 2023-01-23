package org.firstinspires.ftc.teamcode.drive.opmode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


public class RobotHardware {

    public BNO055IMU imu;

    public DcMotor motorFL;
    public DcMotor motorFR;
    public DcMotor motorBL;
    public DcMotor motorBR;

    public DcMotor motorTurret;
    public DcMotor motorLiftL;
    public DcMotor motorLiftR;



    // public DcMotor motorLift;

    private HardwareMap hardwareMap = null;

    public RobotHardware(HardwareMap aHardwareMap, boolean initIMU) {
        hardwareMap = aHardwareMap;

        if (initIMU) {
            initializeIMU();
        }

        motorFL = hardwareMap.get(DcMotor.class, "motorFL");
        motorFR = hardwareMap.get(DcMotor.class, "motorFR");
        motorBL = hardwareMap.get(DcMotor.class, "motorBL");
        motorBR = hardwareMap.get(DcMotor.class, "motorBR");
        motorFL.setDirection(DcMotorSimple.Direction.FORWARD);
        motorFR.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBL.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBR.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorFR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorLiftL = hardwareMap.get(DcMotor.class, "motorLiftL");
        motorLiftL.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLiftL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorLiftL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLiftL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        motorLiftR = hardwareMap.get(DcMotor.class, "motorLiftR");
        motorLiftR.setDirection(DcMotorSimple.Direction.FORWARD);
        motorLiftR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLiftR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorTurret = hardwareMap.get(DcMotor.class, "motorTurret");
        motorTurret.setDirection(DcMotorSimple.Direction.REVERSE);
        motorTurret.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorTurret.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void initializeIMU() {
        //------------------------------------------------------------
        // IMU - BNO055
        // Set up the parameters with which we will use our IMU.
        // + 9 degrees of freedom
        // + use of calibration file (see calibration program)
        //------------------------------------------------------------

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.mode                = BNO055IMU.SensorMode.IMU;
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "AdafruitImuCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled      = false;
        //parameters.loggingTag          = "IMU";
        //parameters.mode                = BNO055IMU.SensorMode.NDOF;

        parameters.accelerationIntegrationAlgorithm = null;

        // Retrieve and initialize the IMU. We expect the IMU to be attached to an I2C port
        // on a Core Device Interface Module, configured to be a sensor of type "AdaFruit IMU",
        // and named "imu".
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
    }

    public void startMove(double drive, double strafe, double turn, double scale) {
        double powerFL = (drive + strafe + turn) * scale;
        double powerFR = (drive - strafe - turn) * scale;
        double powerBL = (drive - strafe + turn) * scale;
        double powerBR = (drive + strafe - turn) * scale;

        double maxPower = Math.max(Math.max(Math.abs(powerFL), Math.abs(powerFR)), Math.max(Math.abs(powerBL), Math.abs(powerBR))); //
        double max = (maxPower < 1) ? 1 : maxPower;

        motorFL.setPower(Range.clip(powerFL / max, -1, 1));
        motorFR.setPower(Range.clip(powerFR / max, -1, 1));
        motorBL.setPower(Range.clip(powerBL / max, -1, 1));
        motorBR.setPower(Range.clip(powerBR / max, -1, 1));
    }

    public void startMove(double drive, double strafe, double turn) {
        startMove(drive, strafe, turn, 1);
    }

    public void stopMove() {
        motorFL.setPower(0);
        motorFR.setPower(0);
        motorBL.setPower(0);
        motorBR.setPower(0);
    }

//    public void setFlaps(boolean isDown) {
//        if (isDown) {
//            servoRClamp.setPosition(RIGHT_FLAP_DOWN_POS);
//            servoLClamp.setPosition(LEFT_FLAP_DOWN_POS);
//        } else {
//            servoRClamp.setPosition(RIGHT_FLAP_UP_POS);
//            servoLClamp.setPosition(LEFT_FLAP_UP_POS);
//        }
//    }

    public void resetDriveEncoders() {
        motorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}