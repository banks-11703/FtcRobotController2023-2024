package org.firstinspires.ftc.teamcode;

public class GamepadEx {
    private boolean wasPressed;
    private boolean toggled;


    public GamepadEx() {
        wasPressed = false;
        toggled = false;
    }
    public void updateButton(boolean gamepadInput) {
        if(gamepadInput && !wasPressed) {
            toggled = !toggled;
            wasPressed = true;
        } else if(!gamepadInput && wasPressed){
            wasPressed = false;

        }
    }

    public boolean isPressed() {
        return wasPressed;
    }

    public boolean isToggled() {
        return toggled;
    }
}
