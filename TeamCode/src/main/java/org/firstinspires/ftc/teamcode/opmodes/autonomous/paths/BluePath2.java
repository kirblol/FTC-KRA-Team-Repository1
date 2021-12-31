package org.firstinspires.ftc.teamcode.opmodes.autonomous.paths;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitUntilCommand;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.drive.roadrunner.TrajectoryFollowerCommand;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.opmodes.createmechanism.CreateCarousel;
import org.firstinspires.ftc.teamcode.subsystems.drive.roadrunner.MecanumDriveSubsystem;

public class BluePath2 {

    private MecanumDriveSubsystem drive;
    private TrajectoryFollowerCommand blue2Follower1;
    private TrajectoryFollowerCommand blue2Follower2;
    private TrajectoryFollowerCommand blue2Follower3;
    private TrajectoryFollowerCommand blue2Follower4;
    private TrajectoryFollowerCommand blue2Follower5;
    private TrajectoryFollowerCommand blue2Follower6;

    SequentialCommandGroup carouselGroup;

    private Pose2d startPose;
    private final HardwareMap hwMap;
    private final Telemetry telemetry;

    public BluePath2(HardwareMap hwMap, Telemetry telemetry){
        this.hwMap = hwMap;
        this.telemetry = telemetry;
        drive = new MecanumDriveSubsystem(new SampleMecanumDrive(hwMap), false);
        startPose = new Pose2d(-36, 60, Math.toRadians(270));
        drive.setPoseEstimate(startPose);
    }

    public void createPath(){
        CreateCarousel createCarousel = new CreateCarousel(hwMap,"carousel",telemetry);
        createCarousel.createAuto();
        carouselGroup = new SequentialCommandGroup(createCarousel.getMoveCarouselToPosition(),
                new WaitUntilCommand(createCarousel.hasMaxEncoderCountSupplier()).andThen(createCarousel.getStopCarousel()));

        Trajectory traj1 = drive.trajectoryBuilder(startPose)
                .strafeTo(new Vector2d(-60, 60))
                .build();

        Trajectory traj2 = drive.trajectoryBuilder(traj1.end())
                .strafeTo(new Vector2d(-60, 24))
                .addDisplacementMarker(()->{
                    telemetry.addData("Path 2", "performing path 2 action");
                }) //step 6
                .build();


        /*Trajectory traj3 = drive.trajectoryBuilder(traj2.end())
                .splineToLinearHeading(new Pose2d(-32, 24, Math.toRadians(0)),Math.toRadians(270))
                .splineToLinearHeading(new Pose2d(-60, 36, Math.toRadians(270)),Math.toRadians(270))
                .build();


        Trajectory traj4 = drive.trajectoryBuilder(new Pose2d())
                .addDisplacementMarker(()->{
                    telemetry.addData("Path 4", "performing path 4 action");
                    allianceColor.schedule();
                }) //step 10
                .build();

        Trajectory traj5 = drive.trajectoryBuilder(new Pose2d())
                .splineToSplineHeading(new Pose2d(8,64,Math.toRadians(270)),Math.toRadians(180))
                .splineToConstantHeading(new Vector2d(-15,40),Math.toRadians(57))
                .build();


        Trajectory traj6 = drive.trajectoryBuilder(new Pose2d())
                .back(45)
                .build();*/

        blue2Follower1 = new TrajectoryFollowerCommand(drive,traj1);
        blue2Follower2 = new TrajectoryFollowerCommand(drive,traj2);
        //blue2Follower3 = new TrajectoryFollowerCommand(drive,traj3);
        //blue2Follower4 = new TrajectoryFollowerCommand(drive,traj4);
        //blue2Follower5 = new TrajectoryFollowerCommand(drive,traj5);
        //blue2Follower6 = new TrajectoryFollowerCommand(drive,traj6);
    }

    public void execute(CommandOpMode commandOpMode){
        commandOpMode.schedule(new WaitUntilCommand(commandOpMode::isStarted).andThen(
                blue2Follower1.andThen(carouselGroup,
                        blue2Follower2)
        ));
    }
}
