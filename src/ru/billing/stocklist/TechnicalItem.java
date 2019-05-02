package ru.billing.stocklist;

import ru.billing.stocklist.Category;
import ru.billing.stocklist.GenericItem;

public class TechnicalItem extends GenericItem {
    public short warrantyTime;

    public TechnicalItem(String name, float price, Category category, short warrantyTime){
        super(name, price, category);
        this.warrantyTime = warrantyTime;
    }

    @Override
    public String toString(GenericItem caller){
        if ((this.getEquivalent() != null) & (this.getEquivalent() != caller)) {
            String eqDescription = this.getEquivalent().toString(this);
            return "ID: "+this.getID()+", Name: "+this.getName()+", Price: "+this.getPrice()+", ru.billing.stocklist.Category: "+this.getCategory()+", Warranty expires in "+warrantyTime+" days"+"\n     Equivalent: "+eqDescription;
        } else {
            return "ID: "+this.getID()+", Name: "+this.getName()+", Price: "+this.getPrice()+", ru.billing.stocklist.Category: "+this.getCategory()+", Warranty expires in "+warrantyTime+" years";
        }
    }
}
