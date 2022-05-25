package fun.madeby.mbfrecipeproject.domain;

import lombok.*;


/**
 * Created by Gra_m on 2022 04 04
 */
//@EqualsAndHashCode(exclude = {"recipe"})

    @Getter
    @Setter
public class Note {
    private String id;
    private String recipeNote;

    public Note() {
    }

    public Note(String recipeNote, Recipe recipe) {
        this.recipeNote = recipeNote;
    }
}
