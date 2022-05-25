package fun.madeby.mbfrecipeproject.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gra_m on 2022 04 04
 */
@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipes"})
@Document
public class Category {

    private String id;
    private String description;
    private Set<Recipe> recipes = new HashSet<>();
}
