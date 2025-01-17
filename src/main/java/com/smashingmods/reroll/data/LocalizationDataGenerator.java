package com.smashingmods.reroll.data;

import com.smashingmods.reroll.Reroll;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LocalizationDataGenerator extends LanguageProvider {

    public LocalizationDataGenerator(DataGenerator gen, String locale) {
        super(gen, Reroll.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("item.reroll.dice", "Reroll Dice");
        add("reroll.dice.tooltip.description", "Use this item to reroll.");
        add("reroll.dice.tooltip.warning", "This can't be undone!");
        add("reroll.dice.cooldown", "Dice are on cooldown.");
        add("commands.reroll.item_required", "You need dice to reroll.");
        add("commands.reroll.self", "Well, here we go again ... But hey, if you don't like it, you can always reroll!");
        add("commands.reroll.self.lock", "Reroll locked.");
        add("commands.reroll.self.unlock", "Reroll unlocked. Be careful!");
        add("commands.reroll.self.locked", "Reroll locked. Use '/reroll unlock' to unlock yourself.");
        add("commands.reroll.player", "Rerolling for player %s");
        add("commands.reroll.player.rerolled", "You have been rerolled! Good luck.");
        add("commands.reroll.player.lock", "Reroll locked for %s.");
        add("commands.reroll.player.unlock", "Reroll unlocked for %s.");
        add("commands.reroll.player.locked", "%s has reroll locked. Use '/reroll unlock <player>' to unlock.");
        add("commands.reroll.all", "All online players have been rerolled.");
    }
}
