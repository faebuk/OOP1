package view;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class TableScreen extends VBox {
    public TableScreen() {
	this.setId("tableScreen");
	ImageView img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("res/img.jpg")));
	img.setFitWidth(550);
	img.setFitHeight(200);

	setAlignment(Pos.CENTER);

	GridPane grid = new GridPane();

	ColumnConstraints col1 = new ColumnConstraints();
	ColumnConstraints col2 = new ColumnConstraints();
	grid.getColumnConstraints().addAll(col1, col2);

	Label l1 = new Label("Buch1|Titel1|Schreiber1|100");
	Label l2 = new Label("Buch2|Titel2|Schreiber2|200");
	Label l3 = new Label("Buch3|Titel3|Schreiber3|300");
	Label l4 = new Label("Buch4|Titel3|Schreiber4|400");
	Label l5 = new Label("Film10|Titel5|Spieler11|110");
	Label l6 = new Label("Film20|Titel6|Spieler12|129");

	CheckBox c1 = new CheckBox();
	CheckBox c2 = new CheckBox();
	CheckBox c3 = new CheckBox();
	CheckBox c4 = new CheckBox();
	CheckBox c5 = new CheckBox();
	CheckBox c6 = new CheckBox();

	grid.add(l1, 0, 1);
	grid.add(c1, 1, 1);
	grid.add(l2, 0, 2);
	grid.add(c2, 1, 2);
	grid.add(l3, 0, 3);
	grid.add(c3, 1, 3);
	grid.add(l4, 0, 4);
	grid.add(c4, 1, 4);
	grid.add(l5, 0, 5);
	grid.add(c5, 1, 5);
	grid.add(l6, 0, 6);
	grid.add(c6, 1, 6);

	getChildren().addAll(img, grid);
    }

    public TableView getTable() {
	// TODO Auto-generated method stub
	return null;
    }
}
