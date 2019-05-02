package ru.billing.stocklist;

import ru.billing.stocklist.GenericItem;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog {
    private HashMap<Integer, GenericItem> catalog = new HashMap<Integer, GenericItem>();

    private HashMap<Integer, GenericItem> getCatalog() {
        return catalog;
    }

    public void setCatalog(HashMap<Integer, GenericItem> catalog) {
        this.catalog = catalog;
    }

    public ArrayList<GenericItem> getALCatalog() {
        return ALCatalog;
    }

    public void setALCatalog(ArrayList<GenericItem> ALCatalog) {
        this.ALCatalog = ALCatalog;
    }

    private ArrayList <GenericItem> ALCatalog = new ArrayList<GenericItem>();

    public void addItem(GenericItem item){
        catalog.put(item.getID(), item);
        ALCatalog.add(item);
    }
    public  void printItems(){
        for (GenericItem i:
             ALCatalog) {
            System.out.println(i);
        }
    }

    public GenericItem findItemByID(int id){
        if(!catalog.containsKey(id)){
            return null;
        } else {
            return catalog.get(id);
        }
    }

    public GenericItem findItemByIDAL(int id){
        for (GenericItem i :
                ALCatalog) {
            if (i.getID() == id) return i;
        }
        return null;
    }
}
