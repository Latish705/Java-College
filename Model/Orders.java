package Model;
import java.util.Calendar;
public class Orders {
    private Calendar order_date;
    Customer ObjCust;
    Food_item Objfood_item;

    public void orders_customer_food_item(Customer tempCust, Food_item tempfood_item, Calendar
            temp_order_date) {
        ObjCust = tempCust;
        Objfood_item = tempfood_item;
        order_date = temp_order_date;
    }

    public void display_customer_orders() {
        System.out.println(this.ObjCust.getName());
        System.out.println("\t ordered\t");
        System.out.println(this.Objfood_item.getFood_item_name());
    }
}
