package auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import autofunctions.Path;
import autofunctions.RobotFunctions;
import autofunctions.TerraCV;
import autofunctions.TerraCVHandler;
import global.TerraBot;
import globalfunctions.Constants;

public class AutoHandler {
    TerraBot bot = new TerraBot();
    Path path = new Path(Constants.AUTO_START[0],Constants.AUTO_START[1],Constants.AUTO_START[2]);
    RobotFunctions rf = new RobotFunctions();
    TerraCV.RingNum ringNum;
    TerraCVHandler terraCVHandler = new TerraCVHandler();
    LinearOpMode op;


    public AutoHandler(LinearOpMode op){
        this.op = op;
    }

    //TODO
    // MOVEMTENTS ARE WEIRD
    // SEMI UNRELIABLE SHOOTING
    // UNRELIABLE IN GENERAL




    public void auto4(){

        //Life wobble arm and shoot rings
        path.addWGRF(rf.moveWgTo(45), rf.controlWGE(0.3));
        path.addRF(rf.readyShooter(), rf.shootIntoGoal(3), rf.stopOuttake());
        path.addWaypoint(-30, 50, 0);
        path.addShoot(0,60,0);

        //drop 1st wobble goal
        path.addWGRF(rf.controlWGE(1), rf.moveWgTo(0));
        path.addWaypoint(0,100, 0);
        path.addSetpoint(-10,50,0);
        path.addWGRF(rf.claw(2, -0.2));
        path.addStop(0.3);

        //move to intake rings
        path.addWGRF(rf.moveWgTo(45));
        path.addRF(rf.controlWGE(0.1));
        path.addWaypoint(0, -150, 0);
        path.addSetpoint(0, -55, 0);
        path.addSetpoint(35,10, 0);


        //intake 3 rings
        path.addRF(rf.intake(1));
        path.addWGRF(rf.moveWgTo(170));
        path.addStop(0.3);
        path.addSetpoint(0,15,0);
        path.addStop(0.3);
        path.addSetpoint(0,15,0);
        path.addStop(0.3);
        path.addSetpoint(0,15,0);


        //move and pick up 2nd wobble
        path.addWaypoint(0,-20,0);
        path.addSetpoint(5, -25, 20);
        path.addWGRF(rf.claw(0), rf.pauseRfs(0.5), rf.moveWgTo(60));
        path.addStop(1);

        //shoot 3 rings
        path.addWaypoint(-5, 15, -20);
        path.addRF(rf.intake(0), rf.overrideShooter(true),  rf.readyShooter(), rf.pauseRfs(1.5),  rf.shootIntoGoal(3), rf.stopOuttake());
        path.addStop(1);
        path.addShoot(0, 35, 1);

        //drop 2nd wobble goal
        path.addWGRF(rf.controlWGE(1), rf.moveWgTo(0));
        path.addRF(rf.intake(1));
        path.addWaypoint(0,40,0);
        path.addSetpoint(-50, 80, 0);
        path.addWGRF(rf.claw(2, -0.2));
        path.addStop(0.5);


        //shoot last ring
//        path.addRF(rf.intake(0), rf.overrideShooter(true),  rf.readyShooter(), rf.pauseRfs(2.5),  rf.shootIntoGoal(1), rf.stopOuttake());
//        path.addWaypoint(30, -60, 0);
//        path.addShoot(20, -60, 0);

        //park
        path.addSetpoint(50, -90, 0);
//
//        //park
//        path.addSetpoint(0,30,0);

        path.start(bot, op);
        path.saveData();

        bot.stopOdoThread();
    }

    public void auto1(){

        //Life wobble arm and shoot rings
        path.addWGRF(rf.moveWgTo(45), rf.controlWGE(0.3));
        path.addRF(rf.readyShooter(), rf.shootIntoGoal(3), rf.stopOuttake());
        path.addWaypoint(-30, 50, 0);
        path.addShoot(0,60,0);

        //drop 1st wobble goal
        path.addWGRF(rf.controlWGE(1), rf.moveWgTo(0));
        path.addWaypoint(0,100, 0);
        path.addSetpoint(-10,50,0);
        path.addWGRF(rf.claw(2, -0.2));
        path.addStop(0.3);

        //move to intake rings
        path.addWGRF(rf.moveWgTo(45));
        path.addRF(rf.controlWGE(0.1));
        path.addWaypoint(0, -150, 0);
        path.addSetpoint(0, -55, 0);
        path.addSetpoint(35,10, 0);


        //intake 1 rings
        path.addRF(rf.intake(1));
        path.addWGRF(rf.moveWgTo(170));
        path.addStop(0.3);
        path.addSetpoint(0,15,0);
        path.addWaypoint(0, 30, 0);


        //move and pick up 2nd wobble
        path.addWaypoint(0,-20,0);
        path.addSetpoint(5, -25, 20);
        path.addWGRF(rf.claw(0), rf.pauseRfs(0.5), rf.moveWgTo(60));
        path.addStop(1);

        //shoot 1 rings
        path.addWaypoint(-5, 15, -20);
        path.addRF(rf.intake(0), rf.overrideShooter(true),  rf.readyShooter(), rf.pauseRfs(1.5),  rf.shootIntoGoal(1), rf.stopOuttake());
        path.addStop(1);
        path.addShoot(0, 35, 1);

        //drop 2nd wobble goal
        path.addWGRF(rf.controlWGE(1), rf.moveWgTo(0));
        path.addRF(rf.intake(1));
        path.addWaypoint(0,40,0);
        path.addSetpoint(-50, 90, 0);
        path.addWGRF(rf.claw(2, -0.2));
        path.addStop(0.5);


        //park
        path.addSetpoint(50, -90, 0);

        path.start(bot, op);
        path.saveData();

        bot.stopOdoThread();
    }

    public void auto0(){



        //Life wobble arm and shoot rings
        path.addWGRF(rf.moveWgTo(80), rf.controlWGE(0.3));
        path.addRF(rf.readyShooter(), rf.shootIntoGoal(3), rf.stopOuttake());
        path.addWaypoint(0, 50, 0);
        path.addShoot(0,60,0);

        //drop 1st wobble goal
        path.addWGRF(rf.controlWGE(1), rf.moveWgTo(-20));
        path.addWaypoint(-20,100, 0);
        path.addSetpoint(-35,50,0);
        path.addWGRF(rf.claw(2, -0.2));
        path.addStop(1);

        path.addWaypoint(25, -100, 0);
        path.addSetpoint(50, -60, 175);
        path.addSetpoint(0, -60, 0);
        path.addWGRF(rf.claw(0), rf.pauseRfs(0.5), rf.moveWgTo(45));
        path.addStop(1);
        path.addWaypoint(0, 60, 0);
        path.addSetpoint(-50, 60, -175);
        path.addWGRF(rf.moveWgTo(0));
        path.addSetpoint(-10, 100, 0);
        path.addWGRF(rf.claw(2, -0.2));
        path.addStop(1);

        path.addSetpoint(50, -90, 0);

        path.start(bot, op);
        path.saveData();

        bot.stopOdoThread();
    }

    public void autoAll(){
        switch(ringNum){
            case ZERO:
                auto0();
            case ONE:
                auto1();
            case FOUR:
                auto4();
        }
    }




    public void initialize(boolean scan) {
        bot.angularPosition.dontUseCompassSensor = true;
        bot.init(op.hardwareMap);
        rf.init(bot);
        bot.startOdoThreadAuto(op);
        path.startRFThread(op);
        if(scan) {
            //Uncomment this if u want to see the vid
            if(terraCVHandler.terraCV.show) {
                terraCVHandler.init(op.hardwareMap);
            }else{
                terraCVHandler.init();
            }
//           //Comment this out if u want to see vid
//            terraCVHandler.init();
            while (!op.isStarted()) {
                ringNum = terraCVHandler.getRingNum();
                if(terraCVHandler.terraCV.show) {
                    op.telemetry.addData("Ready:", ringNum);
                    op.telemetry.addData("Avgh", terraCVHandler.terraCV.avgH);
                    op.telemetry.addData("Avgs", terraCVHandler.terraCV.avgS);
                    op.telemetry.addData("Avgv", terraCVHandler.terraCV.avgV);
                    op.telemetry.update();
                }else{
                    op.telemetry.addData("Ready:", ringNum);
                    op.telemetry.update();
                }
            }
            terraCVHandler.stop();
        }else{
            op.telemetry.addData("Ready:", "Yes?s");
            op.telemetry.update();
        }
        op.waitForStart();

    }
}
