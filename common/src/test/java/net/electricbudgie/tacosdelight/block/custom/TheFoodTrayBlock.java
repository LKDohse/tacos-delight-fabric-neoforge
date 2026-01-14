package net.electricbudgie.tacosdelight.block.custom;

import net.electricbudgie.tacosdelight.block.custom.logic.FoodTrayBlockLogic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("The Food Tray block")
public class TheFoodTrayBlock {

    @ParameterizedTest(name = "Given it has servings {0} remaining, when taking a serving, {1} servings remain")
    @CsvSource({
            "6, 5",
            "5, 4",
            "1, 0"
    })
    @DisplayName("Taking a serving reduces serving amount by 1")
    void givenServingsRemaining(int servings, int servingsRemaining){
        assertEquals(FoodTrayBlockLogic.getRemainingServings(servings), servingsRemaining);
    }

    @Test
    @DisplayName("Given it has no servings remaining, no more servings can be taken")
    void givenNoServingsRemaining(){
        assertEquals(FoodTrayBlockLogic.getRemainingServings(0), 0);
    }


}
