package ru.billing.stocklist;

public class GenericItem {
    private int ID;
    private String name;
    private float price;
    private Category category;
    static int currentID;

    public GenericItem getEquivalent() {
        return equivalent;
    }

    public void setEquivalent(GenericItem equivalent) {
        this.equivalent = equivalent;
        if(equivalent.getEquivalent() == null){
            equivalent.setEquivalent(this);
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private GenericItem equivalent;

    public GenericItem(String name, float price, Category category){
        this.ID=GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public GenericItem(String name, float price, GenericItem equivalent){
        this.ID=GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.equivalent = equivalent;
    }

    public GenericItem(){
        this.ID=GenericItem.currentID++;
    }

    public void printAll(){
        System.out.println(this.toString(this));
    }

    public String toString(GenericItem caller){
        if ((equivalent != null) & (equivalent != caller)) {
            String eqDescription = equivalent.toString(this);
            return "ID: "+ID+", Name: "+name+", Price: "+price+", ru.billing.stocklist.Category: "+category+"\n     Equivalent: "+eqDescription;
        } else {
            return "ID: "+ID+", Name: "+name+", Price: "+price+", ru.billing.stocklist.Category: "+category;
        }
    }
}
