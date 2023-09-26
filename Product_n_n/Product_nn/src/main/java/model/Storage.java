package model;

import java.util.List;
import java.util.stream.Collectors;

public class Storage {
    private int id;

    private String nameStorage;

    public Storage() {
    }

    public Storage(int id, String nameStorage) {
        this.id = id;
        this.nameStorage = nameStorage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameStorage() {
        return nameStorage;
    }

    public void setNameStorage(String nameStorage) {
        this.nameStorage = nameStorage;
    }

    public String getStringStorage(List<Storage> storageList) {
        String strStorage = "";
        for (Storage s : storageList) {
            strStorage += s.toString() + ",";
        }
        return strStorage;
    }
}
