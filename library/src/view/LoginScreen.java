package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginScreen extends VBox {

    public LoginScreen() {
	this.setId("loginScreen");
	ImageView img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("res/img.jpg")));
	setAlignment(Pos.CENTER);

	Label vornameLabel = new Label("Vorname");
	TextField vornameTf = new TextField();

	Label nachnameLabel = new Label("Nachname");
	TextField nachnameTf = new TextField();

	Label mailLabel = new Label("Email");
	TextField mailTf = new TextField();

	Label pwLabel = new Label("Nachname");
	TextField pwTf = new TextField();

	VBox labels = new VBox();
	labels.getChildren().addAll(vornameLabel, nachnameLabel, mailLabel, pwLabel);

	VBox inputs = new VBox();
	inputs.getChildren().addAll(vornameTf, nachnameTf, mailTf, pwTf);

	HBox all = new HBox();
	all.getChildren().addAll(labels, inputs);

	getChildren().addAll(img, all);
    }
}
