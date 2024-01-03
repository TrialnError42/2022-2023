package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.oldCode.AutoCommon;

/*
 * This is an example of a more complex path to really test the tuning.
 */
@Autonomous(group = "drive")
public class SplineTest extends AutoCommon {
    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        waitForStart();

        if (isStopRequested()) return;

<<<<<<< HEAD
        Trajectory traj = drive.trajectoryBuilder(new Pose2d())
                .splineTo(new Vector2d(60, 30), 0)
=======
        Pose2d startPose = new Pose2d(34.5,-61.5,Math.toRadians(-90));

        Trajectory traj = drive.trajectoryBuilder(startPose)
                .lineToConstantHeading(new Vector2d(34.5,-13))
>>>>>>> 88475051b27b3a36e3fa87bb8a704ea60c44ad6c
                .build();



        drive.followTrajectory(traj);

//        sleep(1000);
//
//        Trajectory traj = drive.trajectorySequenceBuilder(new Pose2d())
//                .splineTo(new Vector2d(10,60), 0)
//                .build();
//
//        drive.followTrajectory(traj);

        sleep(1000);

        drive.followTrajectory(
                drive.trajectoryBuilder(traj.end(), true)
                        .splineTo(new Vector2d(0, 0), Math.toRadians(180))
                        .build()
        );
    }
}
