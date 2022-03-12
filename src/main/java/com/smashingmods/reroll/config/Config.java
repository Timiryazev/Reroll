package com.smashingmods.reroll.config;

import com.smashingmods.reroll.Reroll;
import net.minecraftforge.common.config.Configuration;

public class Config {
    private static final String CATEGORY_REROLL = "reroll";
    private static final String CATEGORY_COMPAT = "compat";

    public static String[] rerollItems;
    public static int rerollRange;
    public static int minDistance;
    public static boolean useCurrentDim;
    public static int overrideDim;
    public static boolean initialInventory;

    public static int timeisupTimer;

    public static void readConfig() {
        Configuration config = Reroll.CONFIG;
        try {
            config.load();
            initRerollConfig(config);
        } catch (Exception e) {
            com.smashingmods.reroll.Reroll.LOGGER.error("Problem loading config file:\n", e);
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }

    private static void initRerollConfig(Configuration config) {
        config.addCustomCategoryComment(CATEGORY_REROLL, "Reroll Command Configuration");
        rerollItems = config.getStringList("Reroll Inventory", CATEGORY_REROLL, new String[]{"minecraft:wooden_sword;1", "minecraft:wooden_pickaxe;1", "minecraft:wooden_axe;1", "minecraft:wooden_shovel;1", "minecraft:cooked_beef;8", "minecraft:torch;16"}, "A list of items that will be added to a player's inventory after using the reroll command.");
        rerollRange = config.getInt("Reroll range", CATEGORY_REROLL, 5000, 1000, 100000, "Determines a random range of values when attempting to find a reroll location. Bigger values means you might be teleported further but could still be close to where you currently are located.");
        minDistance = config.getInt("Minimum Distance", CATEGORY_REROLL, 500, 100, 100000, "Determines the minimum distance within the range.");
        useCurrentDim = config.getBoolean("Reroll Dimension", CATEGORY_REROLL, false, "Should reroll spawn location be set in the player's current dimension? If set to false, the override value will be used.");
        overrideDim = config.getInt("Override Dimension", CATEGORY_REROLL, 0, -1, 1, "Override the dimension used for the reroll spawn location");
        initialInventory = config.getBoolean("Initial Inventory", CATEGORY_REROLL, false, "Should players get an initial inventory when they first join a world?");

        config.addCustomCategoryComment(CATEGORY_COMPAT, "Mod Compatibility Configuration");
        timeisupTimer = config.getInt("Time is up Timer", CATEGORY_COMPAT, 12000, 1200, Integer.MAX_VALUE, "Set the Timer value after a reroll.");
    }
}