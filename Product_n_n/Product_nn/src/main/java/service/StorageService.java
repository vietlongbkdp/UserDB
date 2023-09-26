package service;

import DAO.StorageDAO;
import model.ProductStorage;
import model.Storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StorageService {
    StorageDAO storageDAO = new StorageDAO();
    private List<Storage> storageList = new ArrayList<>();
    public Storage getStorageById(int id){
        storageList =  storageDAO.getAllStorage();
        return storageList.stream().filter(storage -> storage.getId() == id).findFirst().orElse(null);
    }

    public Storage findStorageByName(String name){
        storageList =  storageDAO.getAllStorage();
        return storageList.stream().filter(storage -> storage.getNameStorage() == name).findFirst().orElse(null);
    }
    public List<Storage> getStorageList(String storages){
        String[] storagesListStr = storages.split(",");
        for (String s:storagesListStr) {
            if(findStorageByName(s).getNameStorage().equals(s)){
                storageList.add(findStorageByName(s));
            }
        }
        return storageList;
    }
    public List<Storage> getStorageListByPSList(List<ProductStorage> productStorages){
        List<Storage> storageList = new ArrayList<>();
        for (ProductStorage ps: productStorages) {
            storageList.add(ps.getStorage());
        }
        return storageList;
    }
}
