package com.coderscampus.Assignment9.service;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coderscampus.Assignment9.domain.Recipe;
import com.coderscampus.Assignment9.repository.RecipeReposity;

@Service
public class FileService {
	
	@Autowired
	private RecipeReposity recipeRepo;
	
	
	private List<Recipe> collectMyRecipes(){
		
		CSVFormat CSVForm = CSVFormat.DEFAULT.withDelimiter(',')
						                 	 .withEscape('\\')
						                 	 .withHeader("Cooking Minutes", "Dairy Free", "Gluten Free", "Instructions", "Preparation Minutes", "Price Per Serving", "Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan", "Vegetarian")
						                 	 .withSkipHeaderRecord()
						                 	 .withIgnoreSurroundingSpaces();
						                 	  
						                

	try (Reader in = new FileReader("recipes.txt"))
	{
	  Iterable<CSVRecord> records = CSVForm.parse(in);	
	  for (CSVRecord record : records) {
		Integer cooking = Integer.parseInt(record.get("Cooking Minutes"));
 	    Boolean dairy = Boolean.parseBoolean(record.get("Dairy Free"));
 	    Boolean gluten = Boolean.parseBoolean(record.get("Gluten Free"));
	    String instruct = record.get("Instructions");
	    Double prepM = Double.parseDouble(record.get("Preparation Minutes"));
 	    Double price = Double.parseDouble(record.get("Price Per Serving"));
 	    Integer readyInMin = Integer.parseInt(record.get("Ready In Minutes"));
 	    Integer serves = Integer.parseInt(record.get("Servings"));
 	    Double score = Double.parseDouble(record.get("Spoonacular Score"));
 	    String title = record.get("Title");
 	    Boolean vegan = Boolean.parseBoolean(record.get("Vegan"));
 	    Boolean vegetarian = Boolean.parseBoolean(record.get("Vegetarian"));
 	    
 	    Recipe recipe = new Recipe();
 	    
 	    recipe.setCookingMinutes(cooking);
 	    recipe.setDairyFree(dairy);
 	    recipe.setGlutenFree(gluten);
 	    recipe.setInstructions(instruct);
 	    recipe.setPreparationMinutes(prepM);
 	    recipe.setPricePerServing(price);
 	    recipe.setReadyInMinutes(readyInMin);
 	    recipe.setServings(serves);
 	    recipe.setSpoonacularScore(score);
 	    recipe.setTitle(title);
 	    recipe.setVegan(vegan);
 	    recipe.setVegetarian(vegetarian);
 	   
 	    recipeRepo.getRecipes().add(recipe);
		
	  }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return recipeRepo.getRecipes();
	}
	public List<Recipe> getEveryRecipe(){
		if(recipeRepo.getRecipes().size()== 0) {
			return collectMyRecipes();
		}
		return recipeRepo.getRecipes();
	}
	
}					             				                 	
	


