package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import library.admin.Administration;

public class LoginScreen extends VBox {
    Controller controller;

    public LoginScreen() {
	this.setId("loginScreen");
	ImageView img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("res/img.jpg")));
	setAlignment(Pos.CENTER);

	Administration admin = Administration.getInstance();
	controller = admin.getController();

	Label vornameLabel = new Label("Vorname");
	TextField vornameTf = new TextField();
	vornameTf.textProperty().bindBidirectional(controller.getFirstName());

	Label nachnameLabel = new Label("Nachname");
	TextField nachnameTf = new TextField();
	nachnameTf.textProperty().bindBidirectional(controller.getLastName());

	Label mailLabel = new Label("Email");
	TextField mailTf = new TextField();
	mailTf.textProperty().bindBidirectional(controller.getEmail());

	Label pwLabel = new Label("Passwort");
	TextField pwTf = new TextField();
	pwTf.textProperty().bindBidirectional(controller.getPassword());

	Label message = new Label("");
	message.textProperty().bindBidirectional(controller.getMessage());

	VBox labels = new VBox();
	labels.getChildren().addAll(vornameLabel, nachnameLabel, mailLabel, pwLabel);

	VBox inputs = new VBox();
	inputs.getChildren().addAll(vornameTf, nachnameTf, mailTf, pwTf);

	HBox all = new HBox();
	all.getChildren().addAll(labels, inputs);

	getChildren().addAll(img, all, message);
    }
}
