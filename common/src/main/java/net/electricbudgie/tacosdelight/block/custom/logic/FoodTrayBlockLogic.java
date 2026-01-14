package net.electricbudgie.tacosdelight.block.custom.logic;

public class FoodTrayBlockLogic {

    public static int getRemainingServings(int servings) {
        if (servings == 0) return 0;
        return servings -1;
    }

    public static boolean canServe(int servings){
        return servings != 0;
    }


}
