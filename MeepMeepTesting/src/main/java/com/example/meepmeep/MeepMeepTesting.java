package com.example.meepmeep;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;

import java.lang.invoke.VolatileCallSite;

public class MeepMeepTesting {

    private static RoadRunnerBotEntity myBot;

    public static void red_left(MeepMeep nm) {
        Pose2d startPose = new Pose2d(-35,-60);

        myBot = new DefaultBotBuilder(nm)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(300, 120, Math.toRadians(310), Math.toRadians(180), 16.88)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(startPose)
                                        .turn(Math.toRadians(90))
                                        .lineTo(new Vector2d(-35, -12))
                                        .turn(Math.toRadians(90))
                                        .lineTo(new Vector2d(-53, -12))
                                        .turn(Math.toRadians(180))
                                        .lineTo(new Vector2d(-30, -12))
                                        .turn(Math.toRadians(180))
                                        .lineTo(new Vector2d(-53, -12))
                                        .turn(Math.toRadians(180))
                                        .lineTo(new Vector2d(-30, -12))
                                        .turn(Math.toRadians(180))
                                        .lineTo(new Vector2d(-53, -12))



//                                .splineToLinearHeading(new Vector2d(-52,3), Math.toRadians(30))
//                                .splineToLinearHeading(new Pose2d(-52, 2), Math.toRadians(0))
                                        .build()

                );
    }

    public static void red_right(MeepMeep nm) {
        Pose2d startPose = new Pose2d(35,-60);

        myBot = new DefaultBotBuilder(nm)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(300, 120, Math.toRadians(310), Math.toRadians(180), 16.88)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(startPose)
                                        .turn(Math.toRadians(90))
                                        .lineTo(new Vector2d(35, -12))
                                        .turn(Math.toRadians(-90))
                                        .lineTo(new Vector2d(53, -12))
                                        .turn(Math.toRadians(180))
                                        .lineTo(new Vector2d(30, -12))
                                        .turn(Math.toRadians(180))
                                        .lineTo(new Vector2d(53, -12))
                                        .turn(Math.toRadians(180))
                                        .lineTo(new Vector2d(30, -12))
                                        .turn(Math.toRadians(180))
                                        .lineTo(new Vector2d(53, -12))



//                                .splineToLinearHeading(new Vector2d(-52,3), Math.toRadians(30))
//                                .splineToLinearHeading(new Pose2d(-52, 2), Math.toRadians(0))
                                        .build()

                );
    }

    public static void blue_left(MeepMeep nm) {
        Pose2d startPose = new Pose2d(-35,60);

        myBot = new DefaultBotBuilder(nm)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(300, 120, Math.toRadians(310), Math.toRadians(180), 16.88)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(startPose)
                                        .turn(Math.toRadians(-90))
                                        .lineTo(new Vector2d(-35, 12))
                                        .turn(Math.toRadians(-90))
                                        .lineTo(new Vector2d(-53, 12))
                                        .turn(Math.toRadians(180))
                                        .lineTo(new Vector2d(-30, 12))
                                        .turn(Math.toRadians(180))
                                        .lineTo(new Vector2d(-53, 12))
                                        .turn(Math.toRadians(180))
                                        .lineTo(new Vector2d(-30, 12))
                                        .turn(Math.toRadians(180))
                                        .lineTo(new Vector2d(-53, 12))
                                        .build()

                );
    }

    public static void blue_right(MeepMeep nm) {
        Pose2d startPose = new Pose2d(35,60);

        myBot = new DefaultBotBuilder(nm)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(300, 120, Math.toRadians(310), Math.toRadians(180), 16.88)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(startPose)
                                        .turn(Math.toRadians(-90))
                                        .lineTo(new Vector2d(35, 12))
                                        .turn(Math.toRadians(90))
                                        .lineTo(new Vector2d(53, 12))
                                        .turn(Math.toRadians(180))
                                        .lineTo(new Vector2d(30, 12))
                                        .turn(Math.toRadians(180))
                                        .lineTo(new Vector2d(53, 12))
                                        .turn(Math.toRadians(180))
                                        .lineTo(new Vector2d(30, 12))
                                        .turn(Math.toRadians(180))
                                        .lineTo(new Vector2d(53, 12))



//                                .splineToLinearHeading(new Vector2d(-52,3), Math.toRadians(30))
//                                .splineToLinearHeading(new Pose2d(-52, 2), Math.toRadians(0))
                                        .build()

                );
    }

    public static void main(String args[]) {
        MeepMeep nm = new MeepMeep(800);

        blue_right(nm);

        nm.setBackground(MeepMeep.Background.FIELD_POWERPLAY_KAI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
