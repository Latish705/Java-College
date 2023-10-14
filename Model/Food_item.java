package Model;

import java.util.ArrayList;

public class Food_item extends item {
    /* food item attributes */
    private int id;
    private String food_item_name;
    private String food_item_ingredients;
    private double food_item_cost;
    private float food_item_discount;

    ArrayList<String> specifications = new ArrayList<>();

    //constructor with specified ingredients:-
    public Food_item(int id, String name, String ingredients, double cost, float discount) {
        setId(id);
        setFood_item_name(name);
        setFood_item_ingredients(ingredients);
        setFood_item_cost(cost);
        setFood_item_discount(discount);
    }

    //constructor without specified ingredients:-
    public Food_item(int id, String name, double cost, float discount) {
        setId(id);
        setFood_item_name(name);
        setFood_item_ingredients("not specified");
        setFood_item_cost(cost);
        setFood_item_discount(discount);
    }

    public Food_item() {
        super();
    }

    public void setId(int food) {
        this.id = food;
    }

    public void setFood_item_name(String food_item_name) {
        this.food_item_name = food_item_name;
    }

    public void setFood_item_ingredients(String food_item_ingredients) {
        this.food_item_ingredients = food_item_ingredients;
    }

    public void setFood_item_cost(double food_item_cost) {
        this.food_item_cost = food_item_cost;
    }

    public void setFood_item_discount(float food_item_discount) {
        this.food_item_discount = food_item_discount;
    }

    public int getId() {
        return this.id;
    }

    public String getFood_item_name() {
        return this.food_item_name;
    }

    public String getFood_item_ingredients() {
        return this.food_item_ingredients;
    }

    public double getFood_item_cost() {
        return this.food_item_cost;
    }


    public float getFood_item_discount() {
        return this.food_item_discount;
    }

    //overriden functions:-
    @Override
    public void add_specifications(String sp) {
        this.specifications.add(sp);
    }

    @Override
    public void remove_specification(int specificaton_no) {
        this.specifications.remove(specificaton_no);
    }

    @Override
    public void display_specificatons() {
        for (int i = 0; i < specifications.size(); i++) {
            System.out.println("specifications " + i + " : " + this.specifications.get(i));
        }
    }


    public void copy(Food_item tempo) {
    }

    public final String display_food() {
        return ("id: " + getId() + " \tName: " + getFood_item_name() + " \tIngriedients : " + getFood_item_ingredients() + "  \tCost: " + getFood_item_cost() + " \tDiscount: " + getFood_item_discount());
    }
}