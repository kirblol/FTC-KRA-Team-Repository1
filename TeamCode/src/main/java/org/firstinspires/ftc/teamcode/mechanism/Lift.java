package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Lift implements Mechanism {
    DcMotor liftMotor;
    @Override
    public void init(HardwareMap hardwareMap) {
        liftMotor = hardwareMap.dcMotor.get("lift");
    }

    @Override
    public void run(Gamepad gamepad) {
        liftMotor.setPower(gamepad.left_stick_y);
    }
}
