/*
 *Program that allows for the creation of a Recipe Box which a user can create recipes and ingredients. 
@author Hugo Bucci
@version 2.0
 */
package Milestones;

import java.util.Scanner;

/**
 *
 * @author hugobucci
 */
public class Ingredient { //blank constructor

    private String nameOfIngredient; //intitialize private variables only used in this class
    private double ingredientAmount = 0.0;
    private int numberCaloriesPerUnit = 0;
    private double totalCalories = 0.0;
    private String unitMeasurement = "";

    //need constructor to give values to each variable
    //when an igredient is created, a name must be provided for it
    //an amount, and calories must be provided
    
    //constructor method this takes all of the  ingredient information from add ingredient and puts it into an ingredient object that calls this constructor with these parameters
    public Ingredient(String nameOfIngredient, double ingredientAmount, int numberCaloriesPerUnit, double totalCalories, String unitMeasurment) {

        this.nameOfIngredient = nameOfIngredient;
        this.ingredientAmount = ingredientAmount;
        this.numberCaloriesPerUnit = numberCaloriesPerUnit;
        this.totalCalories = totalCalories;
        this.unitMeasurement = unitMeasurment;
    }
    
    public Ingredient() { //blank constuctor. Allows the user to call "Ingredient newIngredient = new Ingredient()", and then newIngredient.addIngredient() which starts the below add ingredient method of scanner entries
        //which THEN uses the above constructor to create an ingredient?
        this.nameOfIngredient = "";
        this.ingredientAmount = 0;
        this.numberCaloriesPerUnit = 0;
        this.totalCalories = 0.0;
        this.unitMeasurement = "";
    }

    //need a set and a get for each variable
    //set is a method that can be called if you want to change quantity inside object
    public void setNumberCaloriesPerUnit(int numberCaloriesPerUnit) { //can change this to use "this" so it would be int numCaloriesPerUnit and this.numCaloriesPerUnit = numCaloriesPerUnit
        this.numberCaloriesPerUnit = numberCaloriesPerUnit;
    }

    //this method just returns quantity inside object (access quantity stored)
    //takes no parameters as no info needs to be provided when this method is called
    public int getNumberCaloriesPerUnit() { 
        return numberCaloriesPerUnit; //gets, or RETURNS whats stored for that object in numberCaloriesPerUnit
    }

    public void setNameOfIngredient(String nameOfIngredient) { //name setter
        this.nameOfIngredient = nameOfIngredient;
    }

    public String getNameOfIngredient() { //name getter
        return nameOfIngredient; //returns name of ingredient 
    }

    public void setNumberUnits(double ingredientAmount) {
        this.ingredientAmount = ingredientAmount; //sets the ingredient amount
    }

    public double getNumberUnits() {
        return ingredientAmount; //returns the ingredient amount
    }

    public void setTotalCalories(double totalCalories) {
    this.totalCalories = totalCalories;    

    }

    public double getTotalCalories() {
        return totalCalories; //return total calories 
    }
    
    
    public void setUnitMeasurement(String unitMeasurement) {
       this.unitMeasurement = unitMeasurement; //sets unit measurement 
    }
    public String getUnitMeasurement(){
        return unitMeasurement; //gets unit measurement
      
    }

    /**
     *
     * @return
     */
    public  Ingredient addIngredient() {
        String name; //intitialize local variables
        double amount;
        int calories;
        double total;
        String units;

        Scanner scnr = new Scanner(System.in);
        //ask user for inputs
        System.out.println("Please enter the name of the ingredient: ");
        name = scnr.nextLine();
        System.out.println("Please enter the measurement unit:");
        units = scnr.next(); //dont need a validation on string
        System.out.println("Please enter the number of " + units + " of "
                + name + " we'll need: ");
        scnr.nextLine();//stops the while loop from repeating twice, clears the enter key from the scanner
        while (!scnr.hasNextDouble()) { //this ensures the user enters a double. The while loop continues until a double is entered
            System.out.println("Please enter a number for the amount");
            scnr.nextLine(); //stops an infinite loop
            }
        amount = scnr.nextFloat(); //if amount entered is a float, then amount becomes that float value
        scnr.nextLine();//clears the enter key from the scanner
        System.out.println("Please enter the number of calories per " +  units + ": ");
        while (!scnr.hasNextInt()) { //check whether user entered integer, continies while loop until the user does
                System.out.println("Please enter a number for calories");
                scnr.nextLine();//stops an infinite loop
            }
        calories = scnr.nextInt();
        total = amount * calories; //creates total calories 
        Ingredient addIngredient = new Ingredient(name, amount, calories, total, units);//constructor that adds parameters to ingredient object
        return  addIngredient;
          

    }
    
    
    

}
