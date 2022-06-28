package com.coderscampus.Assignment9.repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderscampus.Assignment9.domain.Recipe;

@Repository
public class RecipeReposity {
	private List<Recipe> recipes = new LinkedList<Recipe>();
      //private List<Recipe> recipes = new ArrayList<>(100);
	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	

}
