package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class IntroScreen extends VBox {
	public IntroScreen() {
		this.setId("introScreen");
		Label label1 = new Label("Willkommen beim");
		label1.setId("intro1");
		Label label2 = new Label("OOP1 Library System");
		label2.setId("intro2");
		ImageView img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("res/img.jpg")));
		setAlignment(Pos.CENTER);
		getChildren().addAll(img, label1, label2);
	}
}
