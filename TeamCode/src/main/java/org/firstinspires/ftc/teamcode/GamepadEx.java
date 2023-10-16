package org.firstinspires.ftc.teamcode;

public class GamepadEx {
    private boolean wasPressed;
    private int toggle;
    private int cycleLength;
    private boolean cycleUp;//true if you want to cycle upwards. False otherwise


    public GamepadEx() {
        wasPressed = false;
        toggle = 0;
        cycleLength = 2;
        cycleUp = true;
    }

    public GamepadEx(int cycleLength,boolean cycleUp) {
        wasPressed = false;
        toggle = 0;
        this.cycleLength = cycleLength;
        this.cycleUp = cycleUp;
    }

    public void updateButton(boolean gamepadInput) {
        if(gamepadInput && !wasPressed) {
            if(cycleUp) {
                toggle++;
            } else {
                if(toggle == 0) {
                    toggle = cycleLength-1;
                } else {
                    toggle--;
                }
            }
            toggle%=cycleLength;
            wasPressed = true;
        } else if(!gamepadInput && wasPressed){
            wasPressed = false;
        }
    }

    public boolean isPressed() {
        return wasPressed;
    }

    public boolean getToggle() {
        if(toggle%2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public int getCycle() {
        return toggle;
    }

    public void updateToggle(int toggleModifier) {
        toggle += toggleModifier;
    }
}
