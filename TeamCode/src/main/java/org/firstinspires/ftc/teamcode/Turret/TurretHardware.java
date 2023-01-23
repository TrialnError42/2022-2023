package org.firstinspires.ftc.teamcode.Turret;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class TurretHardware {
    public TurretHardware robot;

    public BNO055IMU imu;

    public DcMotor motorLiftL;
    public DcMotor motorLiftR;
//    public Servo servoExtend;

    public static final int liftPos = 0;
//    public static final double extenderPos = 0.8;


    private HardwareMap hardwareMap = null;

    public TurretHardware(HardwareMap aHardwareMap, boolean initIMU) {
        hardwareMap = aHardwareMap;

        if (initIMU) {
            initializeIMU();
        }

        motorLiftR = hardwareMap.get(DcMotor.class, "motorLiftL");
        motorLiftR.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLiftR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorLiftR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLiftR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorLiftR = hardwareMap.get(DcMotor.class, "motorLiftR");
        motorLiftR.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLiftR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorLiftR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLiftR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

//        servoExtend = hardwareMap.get(Servo.class, "servoExtend");
//        servoExtend.setPosition(extenderPos);
    }

    public void initializeIMU() {
        //------------------------------------------------------------
        // IMU - BNO055
        // Set up the parameters with which we will use our IMU.
        // + 9 degrees of freedom
        // + use of calibration file (see calibration program)
        //------------------------------------------------------------

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.mode = BNO055IMU.SensorMode.IMU;
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "AdafruitImuCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled = false;
        //parameters.loggingTag          = "IMU";
        //parameters.mode                = BNO055IMU.SensorMode.NDOF;

        parameters.accelerationIntegrationAlgorithm = null;

        // Retrieve and initialize the IMU. We expect the IMU to be attached to an I2C port
        // on a Core Device Interface Module, configured to be a sensor of type "AdaFruit IMU",
        // and named "imu".
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
    }

//    public void up () {
//        robot.motorLift.setTargetPosition(robot.liftPos);
//        robot.motorLift(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.motorLift.setPower(0.4);
//    }
}


