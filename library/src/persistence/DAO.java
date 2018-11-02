package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import library.data.DataObject;

public abstract class DAO {
	private File file;
	private String delimiter;
	protected Logger logger = Logger.getLogger(getClass().getName());
	
	public DAO(File file, String delimiter) {
		this.file = file;
		this.delimiter = delimiter;
	}
		
	public List<Object> loadCsv(Mapper mapper) {
		List<Object> objects = new ArrayList<>();
		
		try (Scanner scanner = new Scanner(new FileReader(file))) {
			while (scanner.hasNextLine()) {
				String[] tokens = scanner.nextLine().split(delimiter);
				
				objects.add(mapper.map(tokens));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden");
		} catch (NumberFormatException e) {
			System.out.println("Datei ist korrput");
		}
		
		return objects;
	}
}
