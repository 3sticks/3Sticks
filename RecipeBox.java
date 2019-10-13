/*
 *Program that allows for the creation of a Recipe Box which a user can create recipes and ingredients. 
@author Hugo Bucci
@version 2.0
 */
package Milestones;

/**
 *
 * @author hugobucci
 */

import java.util.ArrayList;
import java.util.Scanner;

public class RecipeBox {
	private ArrayList<Recipe> listOfRecipes;//my stepping stone 5 class is named Recipe, not SteppingStone5_recipe
                   private String recipeName;
    

                public void setListOfRecipes(ArrayList<Recipe> listOfRecipes){ //setter for list of recipes arrayList
                    this.listOfRecipes = listOfRecipes;
                }
                
                public ArrayList<Recipe> getListOfRecipes(){ //getter for list of recipes arrayList
                    return listOfRecipes; //Returns the array of recipe objects  //iterate through with get(i).getNameOfRecipe
                }
                    
                
                public  RecipeBox(){ //blank constructor. Will refactor to just be called RecipeBox
                      this.listOfRecipes = new ArrayList();
                  
                   }
                  public RecipeBox(ArrayList<Recipe> listOfRecipes){ //full constructor for creating a loaded object
                      this.listOfRecipes = listOfRecipes;
                  }
                  
                  public void printAllRecipeNames(){ //can be called to loop through the array to print all the recipe names. 
                      
                    
                           for (int i = 0; i < listOfRecipes.size(); i++) {
                            Recipe recipes = listOfRecipes.get(i);//retrieves all ingredients
                            System.out.println("Recipe #" + (i + 1) + ": " + recipes.getRecipeName());//iterates through the list of recipes
                           }
                  }
                  
                  public void printAllRecipesDetails(Recipe enteredRecipe){ //takes the string recipeName from the scanner
                      
                      for(Recipe r : listOfRecipes){ 
                          if(r.equals(enteredRecipe)){ //searches throgh all the recipes in listOfRecipes, and finds the one that the user wanted
                              r.printRecipe();//calls the recipe printRecipe method with the recipe object r
                          
                          return;
                          }
                          }
                
                      }
                  public void printRecipeInstructions(Recipe eneteredRecipe){ //added method so user can print instructions for a certain recipe using a recipe box object. Calls the print instructions method from the recipe class. 
                      
                      //fundamentally the same process as for printAllRecipeDetails except prints instructions instead of the recipe
                      for(Recipe r : listOfRecipes){ 
                          if(r.equals(eneteredRecipe)){//searches throgh all the recipes in listOfRecipes, and finds the one that the user wanted with the recipe object
                              r.printInstructions(); //calls the print instruction method
                          }
                      }
                  }
                      
                public void addNewRecipe(){
                    Recipe newRecipe = new Recipe().addNewRecipe(); 
                    listOfRecipes.add(newRecipe); //adds the new recipe to the list of recipes
                    
                }
	
         //i have both a menu and a main. i like the menu better. 
         public void menu(){ //Create a recipe box
          RecipeBox newR = new RecipeBox();
          Scanner menuScnr = new Scanner(System.in);
                 boolean runMenu = true; //sets up the runMenu boolean variable for the menu do/while
       do{
         //print a menu to give the user options
        System.out.println("\nRecipe Box Menu\n" + "1. Add Recipe\n" + "2. Print All Details of Recipe\n" + "3. Print All Recipe Names in the Recipe Box");
        System.out.println("4. Print Instructions for a Recipe\n" + "5. Edit a Recipe\n" + "6. Delete a Recipe\n" + "7. Exit the menu\n" + "\nPlease select a menu item.");
        if(menuScnr.hasNextInt()){//checks whether the menu selection is an int IF LOOP #1
            int input = menuScnr.nextInt(); //could possibly make this into a string
            
                    switch (input) { //i used a switch instead of the If. i thought it looked simpler. 
                        
                        
                        case 1://Add Recipe
                            newR.addNewRecipe();//calls addRecipe method
                            break;
                            
                            
                            
                        case 2: //Print All Details of Recipe
                            int r = -1;
                                       System.out.println("Which recipe? Enter the number that corresponds with the recipe you want to view.\n"); //gets a number from the user INSTEAD of a name. Better than typing a recipe.
                           newR.printAllRecipeNames(); //this prints out all the recipe names so the user knows which ones they can select from
                           
                           
                            //while loop to ensure the user enters a number (integer)
                           menuScnr.nextLine();// stops the while loop from running twice, clears the enter key from the scanner
                          while(!menuScnr.hasNextInt()){
                              System.out.println("Please enter a number for your selction: ");
                              menuScnr.nextLine(); //stops an infinite loop
                          }
                          
                          
                           r = menuScnr.nextInt();//gets recipe number from user after they enter in
                            newR.printAllRecipesDetails(newR.listOfRecipes.get(r-1));
                            break;
                            
                            
                            
                        case 3: //Print All Recipe Names in the Recipe Box
                            newR.printAllRecipeNames(); //can access this outside static void
                            break;
                         
                        case 4: //Print instructions for a Recipe (fundamentally the same as printing details for the recipe
                            System.out.println("Which recipe? Enter the number that corresponds with the recipe you want to view.\n"); //gets a number from the user INSTEAD of a name. Better than typing a recipe.
                           newR.printAllRecipeNames(); //this prints out all the recipe names so the user knows which ones they can select from
                           
                            //while loop to ensure the user enters a number (integer)
                          menuScnr.nextLine();// stops the while loop from running twice, clears the enter key from the scanner
                          while(!menuScnr.hasNextInt()){
                              System.out.println("Please enter a number for your selction: ");
                              menuScnr.nextLine(); //stops an infinite loop  
                          }
                           r = menuScnr.nextInt();//gets recipe number from user
                            newR.printRecipeInstructions(newR.listOfRecipes.get(r-1));
                          
                            break;
                            
                        case 5: //Edit a Recipe
                           System.out.println("Which recipe? Enter the number that corresponds with the recipe you want to edit.\n"); //gets a number from the user INSTEAD of a name. Better than typing a recipe.
                           newR.printAllRecipeNames(); //this prints out all the recipe names so the user knows which ones they can select from
                          menuScnr.nextLine();// stops the while loop from running twice, clears the enter key from the scanner
                          while(!menuScnr.hasNextInt()){
                              System.out.println("Please enter a number for your selction: ");
                              menuScnr.nextLine(); //stops an infinite loop  
                          }
                           r = menuScnr.nextInt();//recieves recipe selection from user
                           
                           boolean editMenu = true; //need this for the do/while
                           
                           do{ //start of do/while loop
                               
                               System.out.println("What aspect of " + newR.listOfRecipes.get(r-1).getRecipeName() + " would you like to edit? Please enter number from below list:"); //tales the user's entry and asks what aspect they want to edit
                               System.out.println("1. Name");
                               System.out.println("2. Servings");
                               System.out.println("3. Exit Editor and Return to Main Menu");
                           
                            //while loop to ensure the user enters a number (integer)   
                           menuScnr.nextLine();// stops the while loop from running twice, clears the enter key from the scanner
                          while(!menuScnr.hasNextInt()){
                              System.out.println("Please enter a number for your selction: ");
                              menuScnr.nextLine(); //stops an infinite loop  
                          }
                          
                          
                               int edit = menuScnr.nextInt();//recieves number from user
                               
                               switch(edit) {//starts a switch branch
                                   
                                   case 1: //user wants to edit name
                                       System.out.print("Please enter new name: ");
                                       menuScnr.nextLine(); //clears the previous enter from the scanner
                                       String name = menuScnr.nextLine();
                                       
                                       //this is the fun part..takes the new name and sets it to the recipe that was originall selected
                                       newR.listOfRecipes.get(r-1).setRecipeName(name);
                                       
                                       break; //breaks out of case 1
                                       
                                   case 2: //user wants to edit servings
                                       //need to make sure scanenr is an into with an if branch......... if(menuscnr.hasnextInt)
                                       System.out.print("Please enter new number of servings: ");
                                       int newServings = menuScnr.nextInt();
                                       newR.listOfRecipes.get(r-1).setServings(newServings);//sets the new servings for the selected recipe
                                       break;
                                   
                                   case 3:
                                   editMenu = false; //stops the do/while loop
                                   
                                   default: //stops user from entering number outside list
                                       System.out.println("Please make a selection from the given list.");
                               }
                               //The while loop returns the user back to the menu to allow them to edit more than one thing. if they edit the name, they can then edit servings or press exit
                               
                           } while (editMenu == true);
                           break;
                        case 6: //delete a recipe
                             System.out.println("Which recipe? Enter the number that corresponds with the recipe you want to delete.\n");
                               newR.printAllRecipeNames();//print list of recipes for user to see
                               
                              
                                   //while loop to ensure the user enters a number (integer)   
                           menuScnr.nextLine();// stops the while loop from running twice, clears the enter key from the scanner
                          while(!menuScnr.hasNextInt()){
                              System.out.println("Please enter a number for your selction: ");
                              menuScnr.nextLine(); //stops an infinite loop  
                          }
                          
                          
                          
                               r = menuScnr.nextInt();
                              newR.listOfRecipes.remove(r-1); //removes the recipe specificed by the user
                              //this next section confirms to the user that the recipe was deleted by showing them the list of recipes
                              System.out.println("Recipe deleted. Your recipe box now contains the following recipes: ");
                              newR.printAllRecipeNames();

                            break;
                            
                        case 7: //exit
                            runMenu = false; //exits out of hte menu
                            break;
                            
                            
                        default://default occurs if the user does not enter 1 2 or 3
                            System.out.println("Selection not valid. Please select an option from the menu."); 
                            //System.out.println("\nMenu\n" + "1. Add Recipe\n" + "2. Print Recipe\n" + "3. Adjust Recipe Servings\n" + "\nPlease select a menu item:");
                            break;
                            
                            
                         }
                   } else { //ELSE NUMBER 1 - if the user did not enter an int for the menu selection
            System.out.println("Your entry was not a number. Please try again.");
            menuScnr.next(); //stops an infinite loop
        }
                }while (runMenu == true);
       
       } 
}


/**
 * 
 * Final Project Details:
 * 
 * For your final project submission, you should add a menu item and a method 
 *		to access the custom method you developed for the Recipe class 
 * 		based on the Stepping Stone 5 Lab.
 *
 */