import java.util.ArrayList;

class Pizza2 {

    private String pizzaSize;
    private ArrayList<String> toppings;
    private String pizzaChain;

    public Pizza2(String pizzaSize) {
        this.toppings = new ArrayList<String>();
        this.pizzaChain = null;
        this.pizzaSize = pizzaSize;
    }

    public String getPizzaChain() {
        return pizzaChain;
    }

    public void setPizzaChain(String pizzaChain) {
        this.pizzaChain = pizzaChain;
    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public void eat() {
        System.out.println("\n" + pizzaChain);
        System.out.println(pizzaSize + " Pizza" + " - " + "Toppings are:");
        for (String topping : toppings) {
            System.out.println("-> " + topping);
        }
    }
}

class PizzaBuilder2 {
    private Pizza2 pizza;

    public PizzaBuilder2(String pizzaSize) {
        pizza = new Pizza2(pizzaSize);
    }

    public PizzaBuilder2 setPizzaHut() {
        pizza.setPizzaChain("Pizza Hut");
        return this;
    }

    public PizzaBuilder2 setLittleCaesars() {
        pizza.setPizzaChain("Little Caesars");
        return this;
    }

    public PizzaBuilder2 setDominos() {
        pizza.setPizzaChain("Dominos");
        return this;
    }

    public PizzaBuilder2 addPepperoni() {
        pizza.addTopping("Pepperoni");
        return this;
    }

    public PizzaBuilder2 addSausage() {
        pizza.addTopping("Sausage");
        return this;
    }

    public PizzaBuilder2 addMushrooms() {
        pizza.addTopping("Mushrooms");
        return this;
    }

    public PizzaBuilder2 addBacon() {
        pizza.addTopping("Bacon");
        return this;
    }

    public PizzaBuilder2 addOnions() {
        pizza.addTopping("Onions");
        return this;
    }

    public PizzaBuilder2 addExtraCheese() {
        pizza.addTopping("Extra Cheese");
        return this;
    }

    public PizzaBuilder2 addPeppers() {
        pizza.addTopping("Peppers");
        return this;
    }

    public PizzaBuilder2 addChicken() {
        pizza.addTopping("Chicken");
        return this;
    }

    public PizzaBuilder2 addOlives() {
        pizza.addTopping("Olives");
        return this;
    }

    public PizzaBuilder2 addSpinach() {
        pizza.addTopping("Spinach");
        return this;
    }

    public PizzaBuilder2 addTomatoAndBasil() {
        pizza.addTopping("Tomato and Basil");
        return this;
    }

    public PizzaBuilder2 addBeef() {
        pizza.addTopping("Beef");
        return this;
    }

    public PizzaBuilder2 addHam() {
        pizza.addTopping("Ham");
        return this;
    }

    public PizzaBuilder2 addPesto() {
        pizza.addTopping("Pesto");
        return this;
    }

    public PizzaBuilder2 addSpicyPork() {
        pizza.addTopping("Spicy Pork");
        return this;
    }

    public PizzaBuilder2 addHamAndPineapple() {
        pizza.addTopping("Ham and Pineapple");
        return this;
    }

    public Pizza2 build() {
        if (pizza.getPizzaChain() == null) {
            System.out.println("Order Cancelled: pizza chain was not set");
        }
        return pizza;
    }
}

public class AllPizzaChains {
    public static void main(String[] args) {

        Pizza2 largePizzaHutPizza3topping = new PizzaBuilder2("Large")
                .setPizzaHut()
                .addMushrooms()
                .addOnions()
                .addSpinach()
                .build();

        Pizza2 smallPizzaHutPizza2topping = new PizzaBuilder2("Small")
                .setPizzaHut()
                .addTomatoAndBasil()
                .addSpinach()
                .build();

        Pizza2 mediumLittleCaesarsPizza8topping = new PizzaBuilder2("Medium")
                .setLittleCaesars()
                .addSpinach()
                .addBacon()
                .addSausage()
                .addExtraCheese()
                .addChicken()
                .addOnions()
                .addTomatoAndBasil()
                .addPeppers()
                .build();

        Pizza2 smallLittleCaesarsPizza6topping = new PizzaBuilder2("Small")
                .setLittleCaesars()
                .addExtraCheese()
                .addChicken()
                .addHamAndPineapple()
                .addPeppers()
                .addSpinach()
                .addMushrooms()
                .build();

        Pizza2 smallDominosPizza1topping = new PizzaBuilder2("Small")
                .setDominos()
                .addExtraCheese()
                .build();

        Pizza2 largeDominosPizza3topping = new PizzaBuilder2("Large")
                .setDominos()
                .addMushrooms()
                .addOnions()
                .addSpinach()
                .build();

        largePizzaHutPizza3topping.eat();
        smallPizzaHutPizza2topping.eat();

        mediumLittleCaesarsPizza8topping.eat();
        smallLittleCaesarsPizza6topping.eat();

        smallDominosPizza1topping.eat();
        largeDominosPizza3topping.eat();
    }
}
