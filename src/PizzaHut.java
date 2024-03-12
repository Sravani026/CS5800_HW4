import java.util.ArrayList;

class Pizza {
    private String pizzaSize;
    private ArrayList<String> pizzaToppings;

    public Pizza(String pizzaSize) {
        this.pizzaSize = pizzaSize;
        this.pizzaToppings = new ArrayList<>();
    }

    public void addTopping(String topping) {
        pizzaToppings.add(topping);
    }

    public void eat() {
        System.out.println("\n" + "Pizza Hut");
        System.out.println(pizzaSize + " Pizza" + " - " + "Toppings are:");
        for (String topping : pizzaToppings) {
            System.out.println("-> " + topping);
        }
    }
}

class PizzaBuilder {
    private Pizza pizza;

    public PizzaBuilder(String pizzaSize) {
        pizza = new Pizza(pizzaSize);
    }

    public PizzaBuilder addPepperoni() {
        pizza.addTopping("Pepperoni");
        return this;
    }

    public PizzaBuilder addSausage() {
        pizza.addTopping("Sausage");
        return this;
    }

    public PizzaBuilder addMushrooms() {
        pizza.addTopping("Mushrooms");
        return this;
    }

    public PizzaBuilder addBacon() {
        pizza.addTopping("Bacon");
        return this;
    }

    public PizzaBuilder addOnions() {
        pizza.addTopping("Onions");
        return this;
    }

    public PizzaBuilder addExtraCheese() {
        pizza.addTopping("Extra Cheese");
        return this;
    }

    public PizzaBuilder addPeppers() {
        pizza.addTopping("Peppers");
        return this;
    }

    public PizzaBuilder addChicken() {
        pizza.addTopping("Chicken");
        return this;
    }

    public PizzaBuilder addOlives() {
        pizza.addTopping("Olives");
        return this;
    }

    public PizzaBuilder addSpinach() {
        pizza.addTopping("Spinach");
        return this;
    }

    public PizzaBuilder addTomatoAndBasil() {
        pizza.addTopping("Tomato and Basil");
        return this;
    }

    public PizzaBuilder addBeef() {
        pizza.addTopping("Beef");
        return this;
    }

    public PizzaBuilder addHam() {
        pizza.addTopping("Ham");
        return this;
    }

    public PizzaBuilder addPesto() {
        pizza.addTopping("Pesto");
        return this;
    }

    public PizzaBuilder addSpicyPork() {
        pizza.addTopping("Spicy Pork");
        return this;
    }

    public PizzaBuilder addHamAndPineapple() {
        pizza.addTopping("Ham and Pineapple");
        return this;
    }

    public Pizza build() {
        return pizza;
    }
}

public class PizzaHut{
    public static void main(String[] args) {

        Pizza smallPizza3toppings = new PizzaBuilder("Small")
                .addMushrooms()
                .addOnions()
                .addSpinach()
                .build();
        smallPizza3toppings.eat();

        Pizza mediumPizza6toppings = new PizzaBuilder("Medium")
                .addExtraCheese()
                .addChicken()
                .addHamAndPineapple()
                .addPeppers()
                .addSpinach()
                .addMushrooms()
                .build();
        mediumPizza6toppings.eat();

        Pizza largePizza9toppings = new PizzaBuilder("Large")
                .addSpinach()
                .addBacon()
                .addSausage()
                .addExtraCheese()
                .addChicken()
                .addOnions()
                .addTomatoAndBasil()
                .addMushrooms()
                .addPeppers()
                .build();
        largePizza9toppings.eat();
    }
}
