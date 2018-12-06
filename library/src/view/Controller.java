package view;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import library.admin.Administration;
import library.admin.InvalidLoginException;
import library.admin.NoItemsFoundException;
import library.data.BookItem;
import library.data.Customer;
import library.data.Item;
import main.OOP1Library;

public class Controller {
    private SimpleStringProperty message = new SimpleStringProperty("");
    private SimpleStringProperty firstName = new SimpleStringProperty("");
    private SimpleStringProperty lastName = new SimpleStringProperty("");
    private SimpleStringProperty email = new SimpleStringProperty("");
    private SimpleStringProperty password = new SimpleStringProperty("");
    private Customer customer;

    ObservableList<String> categories = FXCollections.observableArrayList("Buch", "Film", "Zeitschrift", "Musik");
    private SimpleStringProperty category = new SimpleStringProperty("");
    private SimpleStringProperty title = new SimpleStringProperty("");
    private SimpleStringProperty writerFirstName = new SimpleStringProperty("");
    private SimpleStringProperty writerLastName = new SimpleStringProperty("");
    private SimpleStringProperty actorFirstName = new SimpleStringProperty("");
    private SimpleStringProperty actorLastName = new SimpleStringProperty("");
    private SimpleBooleanProperty filter = new SimpleBooleanProperty(false);
    private ObservableList<Item> tableData = FXCollections.observableArrayList();

    private Item selectedItem;
    private OOP1Library main;
    private int nr = 0;
    private int numberOfScreens = 5;

    public void searchAction() throws NoItemsFoundException {
	long[] res = null;
	tableData.clear();
	Administration admin = Administration.getInstance();
	if (!category.get().isEmpty() && !title.get().isEmpty()) {
	    // Todo

	}

	// Todo

	if (res != null) {
	    for (long id : res) {
		Item item = admin.findItem(id);
		if (item instanceof BookItem) {
		    BookItem b = (BookItem) item;
		    if (b.isAvailable())
			tableData.add(b);
		}
		// Todo
	    }
	}
    }

    public void checkPassword() throws InvalidLoginException {
	Administration admin = Administration.getInstance();
	Customer[] customers = admin.getCustomers();

	for (Customer customer : customers) {
	    if (customer.getEmail().equals(email.getValue()) && customer.getEmail().equals(password.getValue())) {
		return;
	    }
	}

	message.setValue("Wrong Password");
	throw new InvalidLoginException("Wrong Password");
    }

    public void lendItem() {
	// Todo
    }

    // Navigation: Event Handling und Exception Handling sind nicht vollständig!!
    public void nextScreen() {
	main.clearScreen();
	nr = ++nr % numberOfScreens;
	if (nr == 0) {
	    this.resetAllProperties();
	    main.setButtonState(1, "Weiter", true, false);
	    main.setButtonState(2, "", false, false);
	}
	if (nr == 1) {
	    main.setButtonState(1, "Login", true, false);
	}
	if (nr == 2) {
	    try {
		this.checkPassword();
		main.setButtonState(1, "Suche", true, false);
	    } catch (InvalidLoginException e) {
		nr--;
	    }
	}
	if (nr == 3)
	    try {
		this.searchAction();
		((TableScreen) main.getPanes()[3]).getTable().setItems(getData());
	    } catch (NoItemsFoundException e) {
		nr--;
	    }
	if (nr == 4) {
	    DetailsScreen ds = ((DetailsScreen) main.getPanes()[4]);
	    ds.setContent(this.getSelectedItem());
	    main.setButtonState(1, "Neue Suche", true, false);
	    main.setButtonState(2, "Ausleihen", true, false);
	}
	main.addScreen(nr);
    }

    public void resetAllProperties() {
	this.getPassword().set("");
	this.getCategory().set("");
	this.getActorFirstName().set("");
	this.getActorLastName().set("");
	this.getWriterFirstName().set("");
	this.getWriterLastName().set("");
	this.getTitle().set("");
	this.message.set("");
    }

    public SimpleStringProperty getFirstName() {
	return firstName;
    }

    public void setFirstName(SimpleStringProperty firstName) {
	this.firstName = firstName;
    }

    public SimpleStringProperty getLastName() {
	return lastName;
    }

    public void setLastName(SimpleStringProperty lastName) {
	this.lastName = lastName;
    }

    public SimpleStringProperty getEmail() {
	return email;
    }

    public void setEmail(SimpleStringProperty email) {
	this.email = email;
    }

    public SimpleStringProperty getPassword() {
	return password;
    }

    public void setPassword(SimpleStringProperty password) {
	this.password = password;
    }

    public SimpleStringProperty getCategory() {
	return category;
    }

    public void setCategory(SimpleStringProperty category) {
	this.category = category;
    }

    public void setCategory(String value) {
	category.setValue(value);
    }

    public SimpleStringProperty getTitle() {
	return title;
    }

    public void setTitle(SimpleStringProperty title) {
	this.title = title;
    }

    public ObservableList<String> getCategories() {
	return categories;
    }

    public SimpleStringProperty getWriterFirstName() {
	return writerFirstName;
    }

    public void setWriterFirstName(SimpleStringProperty writerFirstName) {
	this.writerFirstName = writerFirstName;
    }

    public SimpleStringProperty getWriterLastName() {
	return writerLastName;
    }

    public void setWriterLastName(SimpleStringProperty writerLastName) {
	this.writerLastName = writerLastName;
    }

    public String getWriter() {
	return writerFirstName.get() + writerLastName.get();
    }

    public SimpleStringProperty getActorFirstName() {
	return actorFirstName;
    }

    public void setActorFirstName(SimpleStringProperty actorFirstName) {
	this.actorFirstName = actorFirstName;
    }

    public SimpleStringProperty getActorLastName() {
	return actorLastName;
    }

    public void setActorLastName(SimpleStringProperty actorLastName) {
	this.actorLastName = actorLastName;
    }

    public String getActor() {
	return actorFirstName.get() + actorLastName.get();
    }

    public ObservableList<Item> getData() {
	return tableData;
    }

    public void setData(ObservableList<Item> data) {
	this.tableData = data;
    }

    public Item getSelectedItem() {
	return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
	this.selectedItem = selectedItem;
    }

    public Customer getCustomer() {
	return customer;
    }

    public SimpleStringProperty getMessage() {
	return message;
    }

    public void setMessage(String errorMessage) {
	this.message.setValue(errorMessage);
    }

    public void setMain(OOP1Library main) {
	this.main = main;
    }

    public int getNumberOfScreens() {
	return numberOfScreens;
    }

    public SimpleBooleanProperty getFilter() {
	return filter;
    }

    public void setFilter(SimpleBooleanProperty filter) {
	this.filter = filter;
    }
}
