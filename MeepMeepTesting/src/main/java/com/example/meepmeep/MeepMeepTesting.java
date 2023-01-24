package com.example.meepmeep;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;

public class MeepMeepTesting {
    public static void main(String args[]) {
        MeepMeep nm = new MeepMeep(800);

        // declaring start pos
        Pose2d startPose = new Pose2d(-30,-60,Math.toRadians(90));

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(nm)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(300, 120, Math.toRadians(310), Math.toRadians(180), 16.88)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(startPose)
                                .strafeTo(new Vector2d(-45, -60))
                                .splineToConstantHeading(new Vector2d(-46,-18), Math.toRadians(-30))
                                .turn(Math.toRadians(76))
                                .forward(8)
                                .back(16)
                                .forward(16)
                                .back(16)
//                                .turn(Math.toRadians(45))
//                                .turn(Math.toRadians(-45))
//                                .splineToConstantHeading(new Vector2d(-40,0), Math.toRadians(-30))
//                                .turn(Math.toRadians(-90))
//                                .turn(Math.toRadians(90))
//                                .splineToConstantHeading(new Vector2d(-55,3), Math.toRadians(-30))
//                                .turn(Math.toRadians(45))
//                                .turn(Math.toRadians(-45))
//                                .splineToConstantHeading(new Vector2d(-40,0), Math.toRadians(-30))
//                                .turn(Math.toRadians(-90))
                                .turn(Math.toRadians(90))

//                                .splineToLinearHeading(new Vector2d(-52,3), Math.toRadians(30))
//                                .splineToLinearHeading(new Pose2d(-52, 2), Math.toRadians(0))

                                .build()
                );

        nm.setBackground(MeepMeep.Background.FIELD_POWERPLAY_KAI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
