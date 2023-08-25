package net.meshmc.mesh.api.block;

import net.meshmc.mesh.statics.StaticMapColors;

/**
 * @author Makrennel 04/21/2022
 * 
 * All static fields here point to methods in a class which is not present in mesh-core builds
 */
public interface MapColor {
    MapColor
            CLEAR = StaticMapColors.CLEAR(),
            PALE_GREEN = StaticMapColors.PALE_GREEN(),
            PALE_YELLOW = StaticMapColors.PALE_YELLOW(),
            WHITE_GRAY = StaticMapColors.WHITE_GRAY(),
            BRIGHT_RED = StaticMapColors.BRIGHT_RED(),
            PALE_PURPLE = StaticMapColors.PALE_PURPLE(),
            IRON_GRAY = StaticMapColors.IRON_GRAY(),
            DARK_GREEN = StaticMapColors.DARK_GREEN(),
            WHITE = StaticMapColors.WHITE(),
            LIGHT_BLUE_GRAY = StaticMapColors.LIGHT_BLUE_GRAY(),
            DIRT_BROWN = StaticMapColors.DIRT_BROWN(),
            STONE_GRAY = StaticMapColors.STONE_GRAY(),
            WATER_BLUE = StaticMapColors.WATER_BLUE(),
            OAK_TAN = StaticMapColors.OAK_TAN(),
            OFF_WHITE = StaticMapColors.OFF_WHITE(),
            ORANGE = StaticMapColors.ORANGE(),
            MAGENTA = StaticMapColors.MAGENTA(),
            LIGHT_BLUE = StaticMapColors.LIGHT_BLUE(),
            YELLOW = StaticMapColors.YELLOW(),
            LIME = StaticMapColors.LIME(),
            PINK = StaticMapColors.PINK(),
            GRAY = StaticMapColors.GRAY(),
            LIGHT_GRAY = StaticMapColors.LIGHT_GRAY(),
            CYAN = StaticMapColors.CYAN(),
            PURPLE = StaticMapColors.PURPLE(),
            BLUE = StaticMapColors.BLUE(),
            BROWN = StaticMapColors.BROWN(),
            GREEN = StaticMapColors.GREEN(),
            RED = StaticMapColors.RED(),
            BLACK = StaticMapColors.BLACK(),
            GOLD = StaticMapColors.GOLD(),
            DIAMOND_BLUE = StaticMapColors.DIAMOND_BLUE(),
            LAPIS_BLUE = StaticMapColors.LAPIS_BLUE(),
            EMERALD_GREEN = StaticMapColors.EMERALD_GREEN(),
            OBSIDIAN = StaticMapColors.OBSIDIAN(),
            DARK_RED = StaticMapColors.DARK_RED(),
            TERRACOTTA_WHITE = StaticMapColors.TERRACOTTA_WHITE(),
            TERRACOTTA_ORANGE = StaticMapColors.TERRACOTTA_ORANGE(),
            TERRACOTTA_MAGENTA = StaticMapColors.TERRACOTTA_MAGENTA(),
            TERRACOTTA_LIGHT_BLUE = StaticMapColors.TERRACOTTA_LIGHT_BLUE(),
            TERRACOTTA_YELLOW = StaticMapColors.TERRACOTTA_YELLOW(),
            TERRACOTTA_LIME = StaticMapColors.TERRACOTTA_LIME(),
            TERRACOTTA_PINK = StaticMapColors.TERRACOTTA_PINK(),
            TERRACOTTA_GRAY = StaticMapColors.TERRACOTTA_GRAY(),
            TERRACOTTA_LIGHT_GRAY = StaticMapColors.TERRACOTTA_LIGHT_GRAY(),
            TERRACOTTA_CYAN = StaticMapColors.TERRACOTTA_CYAN(),
            TERRACOTTA_PURPLE = StaticMapColors.TERRACOTTA_PURPLE(),
            TERRACOTTA_BLUE = StaticMapColors.TERRACOTTA_BLUE(),
            TERRACOTTA_BROWN = StaticMapColors.TERRACOTTA_BROWN(),
            TERRACOTTA_GREEN = StaticMapColors.TERRACOTTA_GREEN(),
            TERRACOTTA_RED = StaticMapColors.TERRACOTTA_RED(),
            TERRACOTTA_BLACK = StaticMapColors.TERRACOTTA_BLACK(),
            DULL_RED = StaticMapColors.DULL_RED(),
            DULL_PINK = StaticMapColors.DULL_PINK(),
            DARK_CRIMSON = StaticMapColors.DARK_CRIMSON(),
            TEAL = StaticMapColors.TEAL(),
            DARK_AQUA = StaticMapColors.DARK_AQUA(),
            DARK_DULL_PINK = StaticMapColors.DARK_DULL_PINK(),
            BRIGHT_TEAL = StaticMapColors.BRIGHT_TEAL(),
            DEEPSLATE_GRAY = StaticMapColors.DEEPSLATE_GRAY(),
            RAW_IRON_PINK = StaticMapColors.RAW_IRON_PINK(),
            LICHEN_GREEN = StaticMapColors.LICHEN_GREEN();

    int getColor();

    int getId();
}
