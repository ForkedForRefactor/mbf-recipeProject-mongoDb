package fun.madeby.mbfrecipeproject.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by Gra_m on 2022 04 16
 */

@Setter
@Getter
@NoArgsConstructor
public class IngredientCommand {
    private String id;
    private RecipeCommand recipe;
    private String recipe_id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand uom;
}
