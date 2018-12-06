package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import library.admin.Administration;
import library.admin.ItemNotAvailableException;
import library.admin.NoItemsFoundException;
import persistence.file.TestSetUp;
import view.Controller;
import view.DetailsScreen;
import view.IntroScreen;
import view.LoginScreen;
import view.SearchScreen;
import view.TableScreen;

public class OOP1Library extends Application {
    private HBox mainPane;
    private Pane[] panes;
    private Button button1;
    private Button button2;
    private Controller controller;

    @Override
    public void init() {
	Administration admin;
	try {
	    admin = TestSetUp.testSetUp();
	    controller = admin.getController();
	    controller.setMain(this);
	    panes = new Pane[controller.getNumberOfScreens()];
	    panes[0] = new IntroScreen();
	    panes[1] = new LoginScreen();
	    panes[2] = new SearchScreen();
	    panes[3] = new TableScreen();
	    panes[4] = new DetailsScreen();
	} catch (NoItemsFoundException | ItemNotAvailableException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void start(Stage stage) {
	stage.setTitle("OOP1 Library System");
	stage.setWidth(750);
	stage.setHeight(530);

	BorderPane root = new BorderPane();
	mainPane = new HBox();
	mainPane.setMaxWidth(750);
	mainPane.getChildren().add(panes[0]);
	button1 = new Button("Next");
	button1.setDefaultButton(true);

	button1.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent e) {
		controller.nextScreen();
	    }
	});
	button2 = new Button("");
	button2.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent e) {
		controller.lendItem();
	    }
	});
	root.setCenter(mainPane);
	BorderPane.setAlignment(mainPane, Pos.CENTER);
	HBox hbox2 = new HBox(5);
	hbox2.getChildren().addAll(button2, button1);
	button2.setVisible(false);
	root.setBottom(hbox2);
	hbox2.setAlignment(Pos.CENTER_LEFT);
	hbox2.setMaxWidth(400);
	BorderPane.setAlignment(hbox2, Pos.BASELINE_CENTER);

	Scene scene = new Scene(root);
	scene.getStylesheets().add("res/style.css");
	stage.setScene(scene);
	stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	    @Override
	    public void handle(WindowEvent e) {
		Platform.exit();
		System.exit(0);
	    }
	});
	stage.show();
    }

    public static void main(String[] args) {
	launch(args);
    }

    /**
     * clear actual screen from mainPane
     */
    public void clearScreen() {
	mainPane.getChildren().clear();
    }

    /**
     * add screen with number nr to mainPane
     */
    public void addScreen(int nr) {
	mainPane.getChildren().add(panes[nr]);
    }

    /**
     * set state of button number n
     */
    public void setButtonState(int n, String text, boolean visible, boolean disabled) {
	if (n == 1) {
	    button1.setText(text);
	    button1.setVisible(visible);
	    button1.setDisable(disabled);
	}
	if (n == 2) {
	    button2.setText(text);
	    button2.setVisible(visible);
	    button2.setDisable(disabled);
	}
    }

    public Pane[] getPanes() {
	return panes;
    }
}
