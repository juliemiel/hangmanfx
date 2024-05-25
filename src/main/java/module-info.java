module hangmanfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens pri.bashok.hangmanfx to javafx.fxml;
    exports pri.bashok.hangmanfx;
}