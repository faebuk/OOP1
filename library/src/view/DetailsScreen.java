package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import library.data.Item;

public class DetailsScreen extends VBox {
    public DetailsScreen() {
	this.setId("detailsScreen");

	ImageView img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("res/img.jpg")));

	getChildren().addAll(img);
    }

    public void setContent(Item selectedItem) {
	// TODO Auto-generated method stub

    }
}
