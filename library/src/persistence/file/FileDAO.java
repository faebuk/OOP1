package persistence.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import library.admin.ItemNotAvailableException;
import library.admin.NoItemsFoundException;

public abstract class FileDAO {
    private File file;
    private String delimiter;
    protected Logger logger = Logger.getLogger(getClass().getName());

    public FileDAO(File file, String delimiter) {
	this.file = file;
	this.delimiter = delimiter;
    }

    public List<Object> loadCsv(Mapper mapper) {
	List<Object> objects = new ArrayList<>();

	try (Scanner scanner = new Scanner(new FileReader(file))) {
	    while (scanner.hasNextLine()) {
		String[] tokens = scanner.nextLine().split(delimiter);

		try {
		    objects.add(mapper.map(tokens));
		} catch (NoItemsFoundException | ItemNotAvailableException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	} catch (FileNotFoundException e) {
	    System.out.println("Datei nicht gefunden");
	} catch (NumberFormatException e) {
	    System.out.println("Datei ist korrput");
	}

	return objects;
    }
}
