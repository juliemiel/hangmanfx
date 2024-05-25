package pri.bashok.hangmanfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import pri.bashok.hangmanfx.command.Command;
import pri.bashok.hangmanfx.command.DisableButtonCommand;
import pri.bashok.hangmanfx.service.Hangman;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    @FXML
    private Button buttonA;

    @FXML
    private Button buttonB;

    @FXML
    private Button buttonC;

    @FXML
    private Button buttonD;

    @FXML
    private Button buttonE;

    @FXML
    private Button buttonF;

    @FXML
    private Button buttonG;

    @FXML
    private Button buttonH;

    @FXML
    private Button buttonI;

    @FXML
    private Button buttonJ;

    @FXML
    private Button buttonK;

    @FXML
    private Button buttonL;

    @FXML
    private Button buttonM;

    @FXML
    private Button buttonN;

    @FXML
    private Button buttonO;

    @FXML
    private Button buttonP;

    @FXML
    private Button buttonQ;

    @FXML
    private Button buttonR;

    @FXML
    private Button buttonS;

    @FXML
    private Button buttonT;

    @FXML
    private Button buttonU;

    @FXML
    private Button buttonV;

    @FXML
    private Button buttonW;

    @FXML
    private Button buttonX;

    @FXML
    private Button buttonY;

    @FXML
    private Button buttonZ;

    @FXML
    private Label lblStatus;

    @FXML
    private TextField textPlay;

    @FXML
    private Rectangle attempt1;

    @FXML
    private Circle attempt2;

    @FXML
    private Rectangle attempt3;

    @FXML
    private Rectangle attempt4;

    @FXML
    private Rectangle attempt5;

    @FXML
    private Rectangle attempt6;

    @FXML
    private Rectangle attempt7;

    private ArrayList<Object> deadman;

    private String nextWord;

    private Hangman hangman;

    @FXML
    void initialize () {
        // Load the wordslist file
        try {
            hangman = Hangman.build("en_list.txt");
            fetchNextWord();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            lblStatus.setText(e.getLocalizedMessage());
        }
        // Initialise the deadman attempts array
        deadman = new ArrayList<>();
        // Configure all alphabet buttons' onClick
        assignCommand(buttonQ, new DisableButtonCommand(buttonQ));
        assignCommand(buttonW, new DisableButtonCommand(buttonW));
        assignCommand(buttonE, new DisableButtonCommand(buttonE));
        assignCommand(buttonR, new DisableButtonCommand(buttonR));
        assignCommand(buttonT, new DisableButtonCommand(buttonT));
        assignCommand(buttonY, new DisableButtonCommand(buttonY));
        assignCommand(buttonU, new DisableButtonCommand(buttonU));
        assignCommand(buttonI, new DisableButtonCommand(buttonI));
        assignCommand(buttonO, new DisableButtonCommand(buttonO));
        assignCommand(buttonP, new DisableButtonCommand(buttonP));
        assignCommand(buttonA, new DisableButtonCommand(buttonA));
        assignCommand(buttonS, new DisableButtonCommand(buttonS));
        assignCommand(buttonD, new DisableButtonCommand(buttonD));
        assignCommand(buttonF, new DisableButtonCommand(buttonF));
        assignCommand(buttonG, new DisableButtonCommand(buttonG));
        assignCommand(buttonH, new DisableButtonCommand(buttonH));
        assignCommand(buttonJ, new DisableButtonCommand(buttonJ));
        assignCommand(buttonK, new DisableButtonCommand(buttonK));
        assignCommand(buttonL, new DisableButtonCommand(buttonL));
        assignCommand(buttonZ, new DisableButtonCommand(buttonZ));
        assignCommand(buttonX, new DisableButtonCommand(buttonX));
        assignCommand(buttonC, new DisableButtonCommand(buttonC));
        assignCommand(buttonV, new DisableButtonCommand(buttonV));
        assignCommand(buttonB, new DisableButtonCommand(buttonB));
        assignCommand(buttonN, new DisableButtonCommand(buttonN));
        assignCommand(buttonM, new DisableButtonCommand(buttonM));
    }

    private void assignCommand(Button button, Command command) {
        button.setOnAction(event -> command.execute());
    }

    private void fetchNextWord() {
        nextWord = hangman.selectNext();
        System.out.println(nextWord);
        if (null == nextWord) {
            lblStatus.setText("You've reached the end of the game. Restart again.");
        } else {
            String display = new String(nextWord);
            textPlay.setText(display.replaceAll("[a-zA-Z]", "_  "));
            lblStatus.setText(display.length() + " characters long.");
        }
    }
    @FXML
    void getA(ActionEvent event) {

    }

    @FXML
    void getB(ActionEvent event) {

    }

    @FXML
    void getC(ActionEvent event) {

    }

    @FXML
    void getD(ActionEvent event) {

    }

    @FXML
    void getE(ActionEvent event) {

    }

    @FXML
    void getF(ActionEvent event) {

    }

    @FXML
    void getG(ActionEvent event) {

    }

    @FXML
    void getH(ActionEvent event) {

    }

    @FXML
    void getI(ActionEvent event) {

    }

    @FXML
    void getJ(ActionEvent event) {

    }

    @FXML
    void getK(ActionEvent event) {

    }

    @FXML
    void getL(ActionEvent event) {

    }

    @FXML
    void getM(ActionEvent event) {

    }

    @FXML
    void getN(ActionEvent event) {

    }

    @FXML
    void getO(ActionEvent event) {

    }

    @FXML
    void getP(ActionEvent event) {

    }

    @FXML
    void getQ(ActionEvent event) {

    }

    @FXML
    void getR(ActionEvent event) {

    }

    @FXML
    void getS(ActionEvent event) {

    }

    @FXML
    void getT(ActionEvent event) {

    }

    @FXML
    void getU(ActionEvent event) {

    }

    @FXML
    void getV(ActionEvent event) {

    }

    @FXML
    void getW(ActionEvent event) {

    }

    @FXML
    void getX(ActionEvent event) {

    }

    @FXML
    void getY(ActionEvent event) {

    }

    @FXML
    void getZ(ActionEvent event) {

    }

}
