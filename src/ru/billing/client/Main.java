package ru.billing.client;

import com.sun.tools.javah.Gen;
import ru.billing.stocklist.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws ParseException {
        GenericItem hope = new GenericItem("Hope", 10, Category.FOOD);
        GenericItem faith = new GenericItem("Faith", 15, Category.DRESS);
        GenericItem love = new GenericItem("Love", 8, Category.GENERAL);
        hope.setEquivalent(faith);
        love.printAll();
        hope.printAll();
        String string = "January 1, 2019";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date date = format.parse(string);
        FoodItem potato = new FoodItem("Potato", 10, Category.FOOD, date, (short)4);
        TechnicalItem laptop = new TechnicalItem("Macbook", 10, Category.GENERAL, (short)4);
        GenericItem[] items = {potato, laptop};
        for(GenericItem item: items){
            item.printAll();
        }

        /**
         * Practice Lection 3
         */

        Integer[] intArr = {10, 20, 15};
        Float[] floatArr = new Float[10];
        Random r = new Random();
        for (int i = 0; i < floatArr.length; i++) {
            floatArr[i] = r.nextFloat();
        }
        WorkArray<Integer> insWorkArrayInt = new WorkArray<>(intArr);
        WorkArray<Float> insWorkArrayFloat = new WorkArray<>(floatArr);
        System.out.println(insWorkArrayInt.sum()+" - Integer sum");
        System.out.println(insWorkArrayFloat.sum()+" - Float sum");

        String line = "Конфеты 'Маска';45;120";
        String[] item_fld = line.split(";");

        FoodItem candy = new FoodItem(item_fld[0], Float.parseFloat(item_fld[1]), Short.parseShort(item_fld[2]));
        candy.printAll();

        /**
         *Practice Lection 4
         */

        TechnicalItem phone = new TechnicalItem("iphone", 999, Category.GENERAL, (short)4);
        TechnicalItem other_phone = new TechnicalItem("xiaomi", 1, Category.GENERAL, (short)4);


        ItemCatalog itemCatalog = new ItemCatalog();
        itemCatalog.addItem(love);
        itemCatalog.addItem(faith);
        itemCatalog.addItem(hope);
        itemCatalog.addItem(candy);
        itemCatalog.addItem(potato);
        itemCatalog.addItem(laptop);
        itemCatalog.addItem(phone);
        itemCatalog.addItem(other_phone);
        itemCatalog.addItem(new TechnicalItem("headset", 15, Category.GENERAL, (short)2));

        long begin = new Date().getTime();
        for(int i=0; i<100000;i++)
            itemCatalog.findItemByID(8);
        long end = new Date().getTime();
        System.out.println("In HashMap: "+(end-begin));

        begin = new Date().getTime();
        for(int i=0; i<100000;i++)
            itemCatalog.findItemByIDAL(9);
        end = new Date().getTime();
        System.out.println("In ArrayList: "+(end-begin));

        CatalogLoader loader = new CatalogStubLoader();
        loader.load(itemCatalog);
        itemCatalog.findItemByID(9).printAll();
        itemCatalog.findItemByID(10).printAll();


        TechnicalItem i  = null;
        GenericItem gi = i;

        // GenericItem interface;
        // package-private AbstractItem impls GenericItem
        // OtherItem ext AbstractItem
        // FoodItem ext AbstractItem
    }
}
