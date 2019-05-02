package ru.billing.stocklist;

import ru.billing.stocklist.Category;
import ru.billing.stocklist.GenericItem;

import java.util.Date;

public class FoodItem extends GenericItem {
    public Date dateOfIncome;
    public short expires;

    public FoodItem(String name, float price, Category category, Date date, short expires){
        super(name, price, category);
        this.dateOfIncome = date;
        this.expires = expires;
    }

    public FoodItem(String name, float price, short expires){
        this.setName(name);
        this.setPrice(price);
        this.expires = expires;
    }


    public FoodItem(String name){
        this.setName(name);
    }

    @Override
    public String toString(GenericItem caller){
        if ((this.getEquivalent() != null) & (this.getEquivalent() != caller)) {
            String eqDescription = this.getEquivalent().toString(this);
            return "ID: "+this.getID()+", Name: "+this.getName()+", Price: "+this.getPrice()+", ru.billing.stocklist.Category: "+this.getCategory()+", Date of income: "+dateOfIncome+", Expires in "+expires+" days"+"\n     Equivalent: "+eqDescription;
        } else {
            return "ID: "+this.getID()+", Name: "+this.getName()+", Price: "+this.getPrice()+", ru.billing.stocklist.Category: "+this.getCategory()+", Date of income: "+dateOfIncome+", Expires in "+expires+" days";
        }
    }
}
