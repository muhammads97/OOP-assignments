package eg.edu.alexu.csd.oop.calculator.cs41;

import java.io.IOException;

import eg.edu.alexu.csd.oop.calculator.Calculator;
import eg.edu.alexu.csd.oop.calculator.cs41.controls.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GuiLauncher extends Application {
    private BorderPane calculator;
    private Stage stage;
    private Calculator calc;
	@Override
	public void start(Stage primaryStage) {
		this.stage = primaryStage;
		this.stage.initStyle(StageStyle.TRANSPARENT);
		calc = new SalahCalculator();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(GuiLauncher.class.getResource("views/Calculator.fxml"));
		Controller c = new Controller(calc);
		loader.setController(c);
		try {
            calculator = (BorderPane)loader.load();
            Scene scene = new Scene(calculator);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static void main(String[] args) {
		launch(args);
	}
}
