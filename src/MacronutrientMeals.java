import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Abstract Factory
interface MealFactory {
    Carbs createCarbs();
    Protein createProtein();
    Fats createFats();
}

// Concrete Factories
class RandomMealFactory implements MealFactory {
    private static RandomMealFactory instance;

    private RandomMealFactory() {}

    public static synchronized RandomMealFactory getInstance() {
        if (instance == null) {
            instance = new RandomMealFactory();
        }
        return instance;
    }

    @Override
    public Carbs createCarbs() {
        return new CarbsItem(getRandomFood("Cheese", "Bread", "Lentils", "Pistachio"));
    }

    @Override
    public Protein createProtein() {
        return new ProteinItem(getRandomFood("Fish", "Chicken", "Beef", "Tofu"));
    }

    @Override
    public Fats createFats() {
        return new FatsItem(getRandomFood("Avocado", "Sour cream", "Tuna", "Peanuts"));
    }

    private String getRandomFood(String... options) {
        return options[new Random().nextInt(options.length)];
    }
}

// Abstract Products
interface Carbs {
    String getName();
}

interface Protein {
    String getName();
}

interface Fats {
    String getName();
}

// Concrete Products
class CarbsItem implements Carbs {
    private String name;

    CarbsItem(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class ProteinItem implements Protein {
    private String name;

    ProteinItem(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class FatsItem implements Fats {
    private String name;

    FatsItem(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

// Client
public class MacronutrientMeals {
    public static void main(String[] args) {
        MealFactory factory = RandomMealFactory.getInstance();

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("1A", "No Restriction"));
        customers.add(new Customer("2B", "Paleo"));
        customers.add(new Customer("3C", "Vegan"));
        customers.add(new Customer("4D", "Nut Allergy"));
        customers.add(new Customer("5E", "No Restriction"));
        customers.add(new Customer("6F", "Vegan"));

        for (Customer customer : customers) {
            Meal meal = new Meal(factory, customer.getDietPlan());
            System.out.println(customer.getName() + "'s Diet plan- " + customer.getDietPlan());
            System.out.println("Meal- " + meal);
            System.out.println();
        }
    }
}

class Meal {
    private Carbs carbs;
    private Protein protein;
    private Fats fats;

    Meal(MealFactory factory, String dietPlan) {
        carbs = factory.createCarbs();
        protein = factory.createProtein();
        fats = factory.createFats();

        if (dietPlan.equals("Paleo")) {
            while (!carbs.getName().equals("Pistachio")
                    || protein.getName().equals("Tofu")
                    || fats.getName().equals("Sour cream")) {
                carbs = factory.createCarbs();
                protein = factory.createProtein();
                fats = factory.createFats();
            }
        } else if (dietPlan.equals("Vegan")) {
            while (carbs.getName().equals("Cheese")
                    || protein.getName().equals("Fish")
                    || protein.getName().equals("Chicken")
                    || fats.getName().equals("Tuna")
                    || fats.getName().equals("Sour cream")) {
                carbs = factory.createCarbs();
                protein = factory.createProtein();
                fats = factory.createFats();
            }
        } else if (dietPlan.equals("Nut Allergy")) {
            while (carbs.getName().equals("Pistachio")
                    || fats.getName().equals("Peanuts")) {
                carbs = factory.createCarbs();
                protein = factory.createProtein();
                fats = factory.createFats();
            }
        }
    }

    @Override
    public String toString() {
        return "{ Carbs: " + carbs.getName() + ", Protein: " + protein.getName() + ", Fats: " + fats.getName() + " }";
    }
}

class Customer {
    private String name;
    private String dietPlan;

    Customer(String name, String dietPlan) {
        this.name = name;
        this.dietPlan = dietPlan;
    }

    public String getName() {
        return name;
    }

    public String getDietPlan() {
        return dietPlan;
    }
}
