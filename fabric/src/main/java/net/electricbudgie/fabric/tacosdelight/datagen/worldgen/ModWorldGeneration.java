package net.electricbudgie.fabric.tacosdelight.datagen.worldgen;

public class ModWorldGeneration {
    public static void generateModWorldGeneration() {
        ModGeodeGeneration.generateGeodes();
        ModOreGeneration.generateOres();
        ModVegetalGeneration.generateVegetation();
    }
}