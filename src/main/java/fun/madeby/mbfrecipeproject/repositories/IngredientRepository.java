package fun.madeby.mbfrecipeproject.repositories;

import fun.madeby.mbfrecipeproject.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Gra_m on 2022 04 20
 */
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    Optional<Ingredient> findById(String id);
    Optional<Ingredient> findIngredientByDescription(String description);
}
