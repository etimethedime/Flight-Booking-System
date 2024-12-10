package org.example.flightbooking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ForgotPasswordScene {

    @FXML
    private TextField usernameField;
    @FXML
    private TextField securityAnswerField;
    @FXML
    private ComboBox<String> securityQuestionCombo;
    @FXML
    private TextField newPasswordField;

    @FXML
    public void initialize(){
        securityQuestionCombo.getItems().addAll(
                "What is your favorite team?",
                "What was your first pet?",
                "What was the name of your High school?"
        );
    }

    public void handleChangePassword(ActionEvent event)throws Exception {
        String username = usernameField.getText();
        String securityQuestion = securityQuestionCombo.getValue();
        String securityAnswer = securityAnswerField.getText();
        String newPassword = newPasswordField.getText();



    }
}
