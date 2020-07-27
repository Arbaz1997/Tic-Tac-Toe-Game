package com.blogspot.arbazcode;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Button buttonOne;

    @FXML
    Button buttonTwo;

    @FXML
    Button buttonThree;

    @FXML
    Button buttonFour;

    @FXML
    Button buttonFive;

    @FXML
    Button buttonSix;

    @FXML
    Button buttonSeven;

    @FXML
    Button buttonEight;

    @FXML
    Button buttonNine;

    String value = "X";
    boolean playerTurn = true;
    String winner;
    String[] getChar = new String[10];
    int count = 0;

    public void setInitialValue()
    {
        for ( int i = 0; i < 10; i++)
        {
            getChar[i] = Integer.toString(i);
        }
    }
    public void setXO()
    {
        buttonOne.setOnAction(event -> {
            count++;
            buttonOne.setText(value);
            getChar[0] = buttonOne.getText();
            checkWinner();
            if (playerTurn == true)
            {
                value = "0";
                playerTurn = false;
            }
            else
            {
                value = "X";
                playerTurn = true;
            }

        });
        buttonTwo.setOnAction(event -> {
            buttonTwo.setText(value);
            count++;
            getChar[1] = buttonTwo.getText();
            checkWinner();
            if (playerTurn == true)
            {
                value = "0";
                playerTurn = false;
            }
            else
            {
                value = "X";
                playerTurn = true;
            }
        });
        buttonThree.setOnAction(event -> {
            buttonThree.setText(value);
            count++;
            getChar[2] = buttonThree.getText();
            checkWinner();
            if (playerTurn == true)
            {
                value = "0";
                playerTurn = false;
            }
            else
            {
                value = "X";
                playerTurn = true;
            }
        });
        buttonFour.setOnAction(event -> {
            buttonFour.setText(value);
            count++;
            getChar[3] = buttonFour.getText();
            checkWinner();
            if (playerTurn == true)
            {
                value = "0";
                playerTurn = false;
            }
            else
            {
                value = "X";
                playerTurn = true;
            }
        });
        buttonFive.setOnAction(event -> {
            buttonFive.setText(value);
            count++;
            getChar[4] = buttonFive.getText();
            checkWinner();
            if (playerTurn == true)
            {
                value = "0";
                playerTurn = false;
            }
            else
            {
                value = "X";
                playerTurn = true;
            }
        });
        buttonSix.setOnAction(event -> {
            buttonSix.setText(value);
            count++;
            getChar[5] = buttonSix.getText();
            checkWinner();
            if (playerTurn == true)
            {
                value = "0";
                playerTurn = false;
            }
            else
            {
                value = "X";
                playerTurn = true;
            }
        });
        buttonSeven.setOnAction(event -> {
            count++;
            buttonSeven.setText(value);
            getChar[6] = buttonSeven.getText();
            checkWinner();
            if (playerTurn == true)
            {
                value = "0";
                playerTurn = false;
            }
            else
            {
                value = "X";
                playerTurn = true;
            }
        });
        buttonEight.setOnAction(event -> {
            count++;
            buttonEight.setText(value);
            getChar[7] = buttonEight.getText();
            checkWinner();
            if (playerTurn == true)
            {
                value = "0";
                playerTurn = false;
            }
            else
            {
                value = "X";
                playerTurn = true;
            }
        });
        buttonNine.setOnAction(event -> {
            count++;
            buttonNine.setText(value);
            getChar[8] = buttonNine.getText();
            checkWinner();
            if (playerTurn == true)
            {
                value = "0";
                playerTurn = false;
            }
            else
            {
                value = "X";
                playerTurn = true;
            }
        });
        count9();
    }

    private void checkWinner()
    {
        count9();
        if( (getChar[0] == getChar[1]) && (getChar[1] == getChar[2]))
        {
            winner = getChar[2];
            endGame();
        }
        else  if( (getChar[3] == getChar[4]) && (getChar[4] == getChar[5]))
        {
            winner = getChar[3];
            endGame();
        }
        else  if( (getChar[6] == getChar[7]) && (getChar[7] == getChar[8]))
        {
            winner = getChar[6];
            endGame();
        }
        else  if( (getChar[0] == getChar[3]) && (getChar[3] == getChar[6]))
        {
            winner = getChar[0];
            endGame();
        }
        else  if( (getChar[1] == getChar[4]) && (getChar[4] == getChar[7]))
        {
            winner = getChar[1];
            endGame();
        }
        else  if( (getChar[2] == getChar[5]) && (getChar[5] == getChar[8]))
        {
            winner = getChar[2];
            endGame();
        }
        else  if( (getChar[0] == getChar[4]) && (getChar[4] == getChar[8]))
        {
            winner = getChar[4];
            endGame();
        }
        else  if( (getChar[2] == getChar[4]) && (getChar[4] == getChar[6]))
        {
            winner = getChar[2];
            endGame();
        }

    }

    public void count9()
    {
        if(count == 9)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Up");
            alert.setHeaderText("DRAW");
            alert.setContentText("Want to Play Again");
            ButtonType playAgain = new ButtonType("Play Again");
            ButtonType noExit = new ButtonType("Exit");
            alert.getButtonTypes().addAll(playAgain,noExit);
            Button buttonType = (Button)alert.getDialogPane().lookupButton(ButtonType.OK);
            buttonType.setVisible(false);
            Platform.runLater(()->
            {
                Optional<ButtonType> buttonClick = alert.showAndWait();

                if (buttonClick.isPresent() && buttonClick.get() == playAgain)
                {
                    resetGame();
                }
                else
                {
                    Platform.exit();
                    System.exit(0);
                }
            });
            count = 0;
        }
    }
    private void endGame()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Up");
        alert.setHeaderText("Winnner is " + winner);
        alert.setContentText("Want to Play Again");
        ButtonType playAgain = new ButtonType("Play Again");
        ButtonType noExit = new ButtonType("Exit");
        alert.getButtonTypes().addAll(playAgain,noExit);
        Button buttonType = (Button)alert.getDialogPane().lookupButton(ButtonType.OK);
        buttonType.setVisible(false);
        Platform.runLater(()->
        {
            Optional<ButtonType> buttonClick = alert.showAndWait();

            if (buttonClick.isPresent() && buttonClick.get() == playAgain)
            {
                resetGame();
            }
            else
            {
                Platform.exit();
                System.exit(0);
            }
        });
        count = 0;
    }
    public void resetGame()
    {
        winner = "0";
        setInitialValue();
        buttonOne.setText("");
        buttonTwo.setText("");
        buttonThree.setText("");
        buttonFour.setText("");
        buttonFive.setText("");
        buttonSix.setText("");
        buttonSeven.setText("");
        buttonEight.setText("");
        buttonNine.setText("");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
