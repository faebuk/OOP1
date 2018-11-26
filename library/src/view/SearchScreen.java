package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SearchScreen extends VBox {

    public SearchScreen() {
	this.setId("searchScreen");

	ImageView img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("res/img.jpg")));
	setAlignment(Pos.CENTER);

	Label catLabel = new Label("Kategorie");
	ChoiceBox<String> catCb = new ChoiceBox<String>();
	catCb.getItems().addAll("Filme", "Bücher", "Zeitschriften", "Musik");

	Label searchLabel = new Label("Suchtext");
	TextField searchTf = new TextField();

	Label actorLabel = new Label("Schauspieler/in");
	TextField actorSurnameTf = new TextField();
	TextField actorPrenameTf = new TextField();

	final ToggleGroup stateG = new ToggleGroup();
	stateG.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
	    public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) {
		if (new_toggle != null)
		    System.out.println(stateG.getSelectedToggle().getUserData());
	    }
	});

	RadioButton availableRb = new RadioButton("Nur verfügbare");
	availableRb.setToggleGroup(stateG);
	availableRb.setSelected(true);
	availableRb.setUserData("available");

	RadioButton allRb = new RadioButton("Alle");
	allRb.setToggleGroup(stateG);
	allRb.setUserData("all");

	HBox additionalSearchBox = new HBox(actorPrenameTf, actorSurnameTf);

	VBox labels = new VBox();
	labels.getChildren().addAll(catLabel, searchLabel, actorLabel);

	VBox inputs = new VBox();
	inputs.getChildren().addAll(catCb, searchTf, additionalSearchBox, new HBox(availableRb, allRb));

	HBox all = new HBox();
	all.getChildren().addAll(labels, inputs);

	catCb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
	    @Override
	    public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
		System.out.println(catCb.getItems().get((Integer) number2));
		switch ((Integer) number2) {
		case 3:
		    additionalSearchBox.getChildren().setAll(new TextField());
		}
	    }
	});

	getChildren().addAll(img, all);

    }

}
