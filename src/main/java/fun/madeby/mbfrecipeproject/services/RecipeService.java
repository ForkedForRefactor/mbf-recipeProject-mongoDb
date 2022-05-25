package fun.madeby.mbfrecipeproject.services;

import fun.madeby.mbfrecipeproject.commands.RecipeCommand;
import fun.madeby.mbfrecipeproject.domain.Recipe;

import java.util.Set;

/**
 * Created by Gra_m on 2022 04 16
 */

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe getRecipeById(String aString);
    RecipeCommand getRecipeCommandById(String aString);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
    void deleteRecipeById(String aString);

}
