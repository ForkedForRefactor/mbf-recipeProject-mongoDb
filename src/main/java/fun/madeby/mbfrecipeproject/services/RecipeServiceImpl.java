package fun.madeby.mbfrecipeproject.services;

import fun.madeby.mbfrecipeproject.commands.RecipeCommand;
import fun.madeby.mbfrecipeproject.converters.RecipeCommandToRecipe;
import fun.madeby.mbfrecipeproject.converters.RecipeToRecipeCommand;
import fun.madeby.mbfrecipeproject.domain.Recipe;
import fun.madeby.mbfrecipeproject.exceptions.NotFoundException;
import fun.madeby.mbfrecipeproject.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.*;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

/**
 * Created by Gra_m on 2022 04 05
 */

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository RECIPE_REPOSITORY;
    private final RecipeCommandToRecipe RECIPE_COMMAND_TO_RECIPE;
    private final RecipeToRecipeCommand RECIPE_TO_RECIPE_COMMAND;

    public RecipeServiceImpl(RecipeRepository recipe_repository,
                             RecipeCommandToRecipe recipe_command_to_recipe,
                             RecipeToRecipeCommand recipe_to_recipe_command) {
        RECIPE_REPOSITORY = recipe_repository;
        RECIPE_COMMAND_TO_RECIPE = recipe_command_to_recipe;
        RECIPE_TO_RECIPE_COMMAND = recipe_to_recipe_command;
    }

    @Override
    public Recipe getRecipeById(String aString) {

        Optional<Recipe> recipeOptional = RECIPE_REPOSITORY.findById(aString);
        if (recipeOptional.isEmpty())
            throw new NotFoundException("Recipe ID " + aString + " not found.");
        return recipeOptional.get();
    }

    @Override
    @Transactional
    public RecipeCommand getRecipeCommandById(String aString) {
        return RECIPE_TO_RECIPE_COMMAND.convert(getRecipeById(aString));
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
        Recipe detatchedRecipe = RECIPE_COMMAND_TO_RECIPE.convert(recipeCommand);

        Recipe savedRecipe = RECIPE_REPOSITORY.save(detatchedRecipe);
        log.debug("Saved Recipe id: " + savedRecipe.getId());
        return RECIPE_TO_RECIPE_COMMAND.convert(savedRecipe);
    }

    @Override
    public Set<Recipe> getRecipes() {
        try {
            return new HashSet<>((Collection<? extends Recipe>) RECIPE_REPOSITORY.findAll());
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }



    public Recipe saveRecipe(Recipe recipe) {
        return RECIPE_REPOSITORY.save(recipe);
    }

    public void saveAll(List<Recipe> recipeList) {
        RECIPE_REPOSITORY.saveAll(recipeList);
    }

    public Optional<Recipe> findRecipeByTitle(String title) {
        return RECIPE_REPOSITORY.findRecipeByTitle(title);
    }

    public ArrayList<Recipe> findAll() {
        try {
            return (ArrayList<Recipe>) RECIPE_REPOSITORY.findAll();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void deleteRecipeById(String id) {
        RECIPE_REPOSITORY.deleteById(id);
    }
}

