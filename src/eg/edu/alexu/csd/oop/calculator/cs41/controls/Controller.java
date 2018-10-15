package eg.edu.alexu.csd.oop.calculator.cs41.controls;

import eg.edu.alexu.csd.oop.calculator.Calculator;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Button exit;
    @FXML
    private Button prev;
    @FXML
    private Button next;
    @FXML
    private Button save;
    @FXML
    private Button load;
    @FXML
    private Button sum;
    @FXML
    private Button sub;
    @FXML
    private Button mul;
    @FXML
    private Button div;
    @FXML
    private Button dot;
    @FXML
    private Button eq;
    @FXML
    private Button i0;
    @FXML
    private Button i1;
    @FXML
    private Button i2;
    @FXML
    private Button i3;
    @FXML
    private Button i4;
    @FXML
    private Button i5;
    @FXML
    private Button i6;
    @FXML
    private Button i7;
    @FXML
    private Button i8;
    @FXML
    private Button i9;
    
    @FXML
    private Label res;
    
    @FXML
    private TextField input;
    
    private Calculator calc;
    
    public Controller(Calculator calc) {
        this.calc = calc;
    }
    
    @FXML
    private void initialize() {
        exit.setOnAction((event) -> {
            Stage stage = (Stage) exit.getScene().getWindow();
            stage.close();
        });
        eq.setOnAction((event) -> {
            calc.input(input.getText());
            String result = calc.getResult();
            if(result == null) {
                Alert x = new Alert(AlertType.ERROR);
                x.setContentText("invalid input");
                x.showAndWait();
            } else {
                res.setText(result);
            }
        });
        prev.setOnAction((event) -> {
            String p = calc.prev();
            if(p == null) {
                Alert x = new Alert(AlertType.ERROR);
                x.setContentText("No Previous Inputs");
                x.showAndWait();
            } else {
                input.setText(p);
                res.setText(calc.getResult());
            }
        });
        next.setOnAction((event) -> {
            String n = calc.next();
            if(n == null) {
                Alert x = new Alert(AlertType.ERROR);
                x.setContentText("No Next Inputs");
                x.showAndWait();
            } else {
                input.setText(n);
                res.setText(calc.getResult());
            }
        });
        save.setOnAction((event) -> {
            calc.save();
        });
        load.setOnAction((event) -> {
            calc.load();
        });
        sum.setOnAction((event) -> {
            input.appendText("+");
        });
        sub.setOnAction((event) -> {
            input.appendText("-");
        });
        mul.setOnAction((event) -> {
            input.appendText("*");
        });
        div.setOnAction((event) -> {
            input.appendText("/");
        });
        dot.setOnAction((event) -> {
            input.appendText(".");
        });
        i0.setOnAction((event) -> {
            input.appendText("0");
        });
        i1.setOnAction((event) -> {
            input.appendText("1");
        });
        i2.setOnAction((event) -> {
            input.appendText("2");
        });
        i3.setOnAction((event) -> {
            input.appendText("3");
        });
        i4.setOnAction((event) -> {
            input.appendText("4");
        });
        i5.setOnAction((event) -> {
            input.appendText("5");
        });
        i6.setOnAction((event) -> {
            input.appendText("6");
        });
        i7.setOnAction((event) -> {
            input.appendText("7");
        });
        i8.setOnAction((event) -> {
            input.appendText("8");
        });
        i9.setOnAction((event) -> {
            input.appendText("9");
        });
    }
}
