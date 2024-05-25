package pri.bashok.hangmanfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import pri.bashok.hangmanfx.command.Command;
import pri.bashok.hangmanfx.command.DisableButtonCommand;
import pri.bashok.hangmanfx.service.Hangman;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    // private static final Logger logger = LoggerFactory.getLogger(ButtonEventHandlerController.class);

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
    private Label lblLost;

    @FXML
    private Button buttonAgain;

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

    private int strikeCounter = 0;

    private ArrayList<Shape> deadman;

    private StringBuilder nextWord;

    private char[] displayWord;

    private Hangman hangman;

    @FXML
    void initialize () {
        // Load the wordslist file, and start with a word
        try {
            hangman = Hangman.build("en_list.txt");
            fetchNextWord();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            lblStatus.setText(e.getLocalizedMessage());
        }
        // Initialise the deadman attempts array
        deadman = new ArrayList<>(); deadman.add(attempt1);
        deadman.add(attempt2); deadman.add(attempt3); deadman.add(attempt4);
        deadman.add(attempt5); deadman.add(attempt6); deadman.add(attempt7);
        // Configure all alphabet buttons' onClick disable event
        clickCommand(buttonQ, new DisableButtonCommand(buttonQ));
        clickCommand(buttonW, new DisableButtonCommand(buttonW));
        clickCommand(buttonE, new DisableButtonCommand(buttonE));
        clickCommand(buttonR, new DisableButtonCommand(buttonR));
        clickCommand(buttonT, new DisableButtonCommand(buttonT));
        clickCommand(buttonY, new DisableButtonCommand(buttonY));
        clickCommand(buttonU, new DisableButtonCommand(buttonU));
        clickCommand(buttonI, new DisableButtonCommand(buttonI));
        clickCommand(buttonO, new DisableButtonCommand(buttonO));
        clickCommand(buttonP, new DisableButtonCommand(buttonP));
        clickCommand(buttonA, new DisableButtonCommand(buttonA));
        clickCommand(buttonS, new DisableButtonCommand(buttonS));
        clickCommand(buttonD, new DisableButtonCommand(buttonD));
        clickCommand(buttonF, new DisableButtonCommand(buttonF));
        clickCommand(buttonG, new DisableButtonCommand(buttonG));
        clickCommand(buttonH, new DisableButtonCommand(buttonH));
        clickCommand(buttonJ, new DisableButtonCommand(buttonJ));
        clickCommand(buttonK, new DisableButtonCommand(buttonK));
        clickCommand(buttonL, new DisableButtonCommand(buttonL));
        clickCommand(buttonZ, new DisableButtonCommand(buttonZ));
        clickCommand(buttonX, new DisableButtonCommand(buttonX));
        clickCommand(buttonC, new DisableButtonCommand(buttonC));
        clickCommand(buttonV, new DisableButtonCommand(buttonV));
        clickCommand(buttonB, new DisableButtonCommand(buttonB));
        clickCommand(buttonN, new DisableButtonCommand(buttonN));
        clickCommand(buttonM, new DisableButtonCommand(buttonM));
    }

    private void clickCommand(Button button, Command command) {
        button.setOnAction(_ -> {
                    handleGuess(button.getText().toLowerCase().charAt(0));
                    command.execute();
                }
        );
    }

    private void handleGuess(char c) {
        int indexRef = nextWord.toString().indexOf(c);
        if (-1 == indexRef) {
            strikeCounter ++;
            lblStatus.setText("Oh! Oh! Only " + (deadman.size() - strikeCounter) + " strikes remain!");
            deadman.get(strikeCounter - 1).setVisible(true);
        } else {
            lblStatus.setText("Yes! You guessed it right - " + c);
            while (indexRef >= 0) {
                displayWord[indexRef] = c;
                indexRef = nextWord.toString().indexOf(c, indexRef + 1);
            }
            textPlay.setText(new String(displayWord).replaceAll("_", "_  "));
        }
        checkStrikes();
    }

    private void checkStrikes() {
        if (strikeCounter >= deadman.size()) {
            lblStatus.setText("You lose!!");
            lblLost.setVisible(true);
            lblLost.setText(nextWord.toString());
            buttonAgain.setVisible(true);
        } else if (hangman.isAMatch(nextWord.toString(), new String(displayWord))) {
            lblStatus.setText("Yes! You won!! The hidden word is - " + nextWord.toString());
            buttonAgain.setVisible(true);
        }
    }

    private void fetchNextWord() {
        nextWord = new StringBuilder(hangman.selectNext());
        // System.out.println(nextWord);
        if (null == nextWord) {
            lblStatus.setText("You've reached the end of the game. Restart game again.");
        } else {
            displayWord = new char[nextWord.length()];
            Arrays.fill(displayWord, '_');
            textPlay.setText(new String(displayWord).replaceAll("_", "_  "));
            lblStatus.setText(nextWord.length() + " characters long.");
        }
    }

    @FXML
    public void restart() {
        strikeCounter = 0;
        fetchNextWord();
        lblLost.setVisible(false);
        buttonAgain.setVisible(false);
        buttonQ.setDisable(false);
        buttonW.setDisable(false);
        buttonE.setDisable(false);
        buttonR.setDisable(false);
        buttonT.setDisable(false);
        buttonY.setDisable(false);
        buttonU.setDisable(false);
        buttonI.setDisable(false);
        buttonO.setDisable(false);
        buttonP.setDisable(false);
        buttonA.setDisable(false);
        buttonS.setDisable(false);
        buttonD.setDisable(false);
        buttonF.setDisable(false);
        buttonG.setDisable(false);
        buttonH.setDisable(false);
        buttonJ.setDisable(false);
        buttonK.setDisable(false);
        buttonL.setDisable(false);
        buttonZ.setDisable(false);
        buttonX.setDisable(false);
        buttonC.setDisable(false);
        buttonV.setDisable(false);
        buttonB.setDisable(false);
        buttonN.setDisable(false);
        buttonM.setDisable(false);
        for (Shape shape : deadman) {
            shape.setVisible(false);
        }
    }
}
