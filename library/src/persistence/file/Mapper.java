package persistence.file;

import library.admin.ItemNotAvailableException;
import library.admin.NoItemsFoundException;

public interface Mapper {
    public Object map(String[] tokens) throws NumberFormatException, NoItemsFoundException, ItemNotAvailableException;
}
