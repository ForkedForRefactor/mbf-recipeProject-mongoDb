package fun.madeby.mbfrecipeproject.domain;



import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by Gra_m on 2022 04 04
 */
@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
public class Ingredient {
    private String id;
    private Recipe recipe;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasure uom;

    public Ingredient() {
    }

    public Ingredient(
            String description,
            BigDecimal amount,
            UnitOfMeasure uom,
            Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
        this.recipe = recipe;
    }

}
