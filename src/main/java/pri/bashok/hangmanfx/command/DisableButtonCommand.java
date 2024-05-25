package pri.bashok.hangmanfx.command;

import javafx.scene.control.Button;

public class DisableButtonCommand implements Command {
    private final Button button;

    public DisableButtonCommand(Button button) {
        this.button = button;
    }

    @Override
    public void execute() {
        if (!button.isDisabled()) {
            button.setDisable(true);
        }
    }
}
