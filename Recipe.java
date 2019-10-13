/*
 *Program that allows for the creation of a Recipe Box which a user can create recipes and ingredients. 
@version 2.0
 */
package Milestones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author hugobucci
 */
public class Recipe {

    //private initializers
    private String recipeName; //initializes recipeName
    private int servings; //initializes servings
    private ArrayList<Ingredient> recipeIngredients; //initializes the arraylist that holds the recipe ingredients objects
    private double totalRecipeCalories; //initiates the total calories to be printed
    private ArrayList<String> recipeInstructions;//private initializer for cusom method

    /**
     *
     * @param recipeName
     */
    public void setRecipeName(String recipeName) { //mutator for Recipe Name
        this.recipeName = recipeName; //this keyword allows us to use same variable names as initializers
    }                                   //maybe change it?

    /**
     *
     * @return recipeName
     */
    public String getRecipeName() { //accessors are not void and have returns
        return recipeName;
    }

    /**
     *
     * @param servings
     */
    public void setServings(int servings) { //mutator for servings
        this.servings = servings;
    }

    /**
     *
     * @return the servings
     */
    public int getServings() { //accessor for servings
        return servings;
    }

    /**
     *
     * @param recipeIngredients
     */
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) { //mutator for the Array
        this.recipeIngredients = recipeIngredients;
    }

    /**
     *
     * @return the recipe ingredients object
     */
    public ArrayList<Ingredient> getRecipeIngredients() { //accessor for the array
        return recipeIngredients;
    }

    /**
     *
     * @param totalRecipeCalories
     */
    public void setTotalRecipeCalories(double totalRecipeCalories) { //mutator for total calories
        this.totalRecipeCalories = totalRecipeCalories;
    }

    /**
     *
     * @return the total recipe calories
     */
    public double getTotalRecipeCalories() { //accessor for total calories 
        return totalRecipeCalories;
    }

    /**
     *
     * @param recipeInstructions
     */
    public  void setRecipeInstructions(ArrayList<String> recipeInstructions) {//mutator
        this.recipeInstructions = recipeInstructions;
    }

    /**
     *
     * @return array of instructions
     */
    public  ArrayList<String> getRecipeInstructions() {
        return recipeInstructions; //maybe return this.recipeInstructions
    }
 
    /**
     *
     * @return arraylist of instructions after it was created by the user.
     * method asks the user for info and then stores it in a string list 
     */
    public  ArrayList<String> addInstructions() { //this is based off the add recipe method with a do/while
        String instruction; //initalizes instruction string
       ArrayList<String> recipeInstructions = new ArrayList<String>(); //arraylist can be of type string; we are entering multiple strings of instructions into the recipe, not objects
        boolean addMoreInstructions = true; //boolean for do loop
        Scanner scnr = new Scanner(System.in);

        do { //do/while loop for the user to enter instructions. Runs until the user breaks out of it with a "n"
            
            System.out.println("Would you like to add an instruction to the recipe? y or n");
            
            String reply = scnr.nextLine().toLowerCase(); //scanner takes the reply and converts it to lower case
            
            //Using switches instead of If's 
            
            switch (reply) {
                
                case "y": //if user entered yes
                    
                    System.out.println("Please enter the instruction:");
                      instruction = scnr.nextLine();
                        recipeInstructions.add(instruction);//adds the user reply to the instructions array
         
                        break; //goes back to question 
                        
                        
                case "n":
                    
                    addMoreInstructions = false;//exits the do while loop
                    break;
                default: //default case if user answer is not y or n
                    
                    System.out.println("Please enter a y or n\n");
                    break;
            }
          
        } while (addMoreInstructions == true);
        return recipeInstructions; //returns arraylist of instructions

    }


    /**
     * Blank Constructor --initialize instance variables. Allows createNewRecipe to get scanner info from user
     */
    public Recipe() {
        this.recipeName = "";
        this.servings = 0;
        this.recipeIngredients = new ArrayList();
        this.totalRecipeCalories = 0;
        this.recipeInstructions = new ArrayList<String>();

    }

    //Overlaoded constructor for when the user adds parameters when creating the object
    public Recipe(String recipeName, int servings, ArrayList<Ingredient> recipeIngredients, double totalRecipeCalories, ArrayList<String> recipeInstructions) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
        this.recipeInstructions = recipeInstructions;
    }

    /**
     *Print recipe method. This method prints the recipe name, the amount of servings, and the list of ingredients. 
     * Prints out the single servings calories, which is an equation that takes the total recipe calories and divides it by the amount of servings
     * 
     * Finally, it prints out the instructions using the print instructions method
     * 
     */
    public void printRecipe() {//prints out the recipe with a nice list of units per measurement
        int singleServingCalories = (int) (this.totalRecipeCalories / this.servings);
        System.out.println("Recipe: " + this.getRecipeName());
        System.out.println("Serves: " + this.getServings());
        System.out.println("Ingredients: ");

        for (Ingredient ingredients : recipeIngredients) {
            System.out.println(ingredients.getNumberUnits() + " " + ingredients.getUnitMeasurement() + " of " + ingredients.getNameOfIngredient());
            //System.out.println("Ingredient name: " + ingredients.getNameOfIngredient());
            //System.out.println("Ingredient Amount: " + ingredients.getNumberUnits()); 
        }
        System.out.println("Each serving has " + singleServingCalories + " calories.");
        
        //Print recipe instructions method
         printInstructions();

    }
    
    /**
     *Method that iterates through the entire list of recipe instructions for a particular recipe object
     */
    public void printInstructions(){ 
       System.out.println("\nInstructions: ");
        for(int i = 0;i < recipeInstructions.size(); i++) {
            String temp = recipeInstructions.get(i);
            System.out.println("Step " + (i + 1) + ": " +temp); //prints instructions out with "Step N", n being the position in the array plus 1 to get the step number
        }

    }

    /**
     *Allows the user to enter a recipe. 
     * Receives recipe name, servings, and then creates an ingredient object in order to call the addIngredient method from the ingredient class. 
     * @return new recipe object
     */
    public Recipe addNewRecipe() {//returns object
        // double totalRecipeCalories = 0.0;
       // ArrayList<Ingredient> recipeIngredients = new ArrayList<Ingredient>(); //not needed
        boolean addMoreIngredients = true;
        double ingredientCalories = 0;
        int servings = 0;
        Scanner scnr = new Scanner(System.in);
        String reply = "";
        String recipeName = "";
        //ArrayList<String> recipeInstructions = new ArrayList<String>();
        boolean addInstructions = true; //boolean variable for do/while for the add instructions section 

        System.out.println("Please enter the recipe name: ");
        recipeName = scnr.nextLine(); //gets the recipe name form the user

        System.out.println("Please enter the number of servings: ");
        while (!scnr.hasNextInt()) {//ensure the user enters an integer
            System.out.println("Please enter a number for servings");
            scnr.nextLine();//stops an infinite loop
        }
        servings = scnr.nextInt(); //gets the servings from the user

        do { //starts do while that allows the user to keep entering ingredients 

            System.out.println("Would you like to add a new ingredient to your recipe? y or n");
            scnr.nextLine();//clears the enter key
            reply = scnr.next().toLowerCase();

            if (reply.equals("y")) {

                Ingredient newIngredient = new Ingredient().addIngredient(); //creates ingredient object to enter into recipe, calling the addIngredient method to get user input
                recipeIngredients.add(newIngredient);//adds the ingredient object to the recipeIngredients array with the user input
                totalRecipeCalories = totalRecipeCalories + newIngredient.getTotalCalories(); //do during loop 

            } else if ((!"y".equals(reply)) && (!"n".equals(reply))) {
                System.out.println("Please enter y or n"); //asks the user to enter y or n if they enter any other string
            } else {
                addMoreIngredients = false; //causes the while loop to break if user enters "n"
            }

        } while (addMoreIngredients == true); //as long as user doesnt type "end" which would cause addmoreingredients to be false and end while
        //creates object recipe1 with each parameter filled in
        //calls second constructor
        
        recipeInstructions = addInstructions();   //is this just not addign the instructions?
        
       //recipe instructions included, but dont seem to be adding adding to the object
        Recipe newRecipe = new Recipe(recipeName, servings, recipeIngredients, totalRecipeCalories, recipeInstructions);

        return newRecipe;
    }

     

    

}


