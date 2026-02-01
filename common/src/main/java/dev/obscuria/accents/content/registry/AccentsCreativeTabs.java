package dev.obscuria.accents.content.registry;

import dev.obscuria.accents.Accents;
import dev.obscuria.accents.content.item.VanityItem;
import dev.obscuria.fragmentum.registry.DeferredItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;

import java.util.List;
import java.util.function.Supplier;

public enum AccentsCreativeTabs {

    GENERAL("general", Icons::general, Contents::general);

    AccentsCreativeTabs(String key, Supplier<ItemStack> icon, CreativeModeTab.DisplayItemsGenerator contents) {
        AccentsRegistries.REGISTRAR.register(Registries.CREATIVE_MODE_TAB, Accents.key(key), () -> CreativeModeTab
                .builder(CreativeModeTab.Row.TOP, 1)
                .title(Component.translatable("itemGroup.%s.%s".formatted(Accents.MODID, key)))
                .displayItems(contents)
                .icon(icon)
                .build());
    }

    interface Icons {

        static ItemStack general() {
            var stack = AccentsItems.CAKEMAN_PLUSHIE.instantiate();
            if (stack.getItem() instanceof DyeableLeatherItem item)
                item.setColor(stack, 16733525);
            return stack;
        }
    }

    interface Contents {

        List<DyeItem> BLACK = List.of((DyeItem) Items.BLACK_DYE, (DyeItem) Items.GRAY_DYE);
        List<DyeItem> WHITE = List.of((DyeItem) Items.WHITE_DYE);
        List<DyeItem> RED = List.of((DyeItem) Items.RED_DYE);
        List<DyeItem> PURPLE = List.of((DyeItem) Items.PURPLE_DYE);
        List<DyeItem> LIME = List.of((DyeItem) Items.LIME_DYE);
        List<DyeItem> YELLOW = List.of((DyeItem) Items.YELLOW_DYE);
        List<DyeItem> LIGHT_BLUE = List.of((DyeItem) Items.LIGHT_BLUE_DYE);
        List<DyeItem> BLUE = List.of((DyeItem) Items.BLUE_DYE);

        static void general(CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output output) {

            output.accept(AccentsItems.SEWING_STATION);
            output.accept(AccentsItems.SEWING_KIT);
            output.accept(AccentsItems.KASA_HAT);

            acceptDyed(output, AccentsItems.CAKEMAN_PLUSHIE, RED, LIGHT_BLUE);
            acceptDyed(output, AccentsItems.CAPTAIN_HAT, WHITE, BLACK);
            acceptDyed(output, AccentsItems.PIRATE_HAT, RED, LIME);
            acceptDyed(output, AccentsItems.CHRISTMAS_HAT, RED, PURPLE);
            acceptDyed(output, AccentsItems.COWBOY_HAT, WHITE, BLACK);
            acceptDyed(output, AccentsItems.TOP_HAT, WHITE, BLACK);
            acceptDyed(output, AccentsItems.OVERTOP_HAT, WHITE, BLACK);
            acceptDyed(output, AccentsItems.PICKELHAUBE, BLACK, LIGHT_BLUE);
            acceptDyed(output, AccentsItems.STRAW_HAT, RED, LIME);
            acceptDyed(output, AccentsItems.SOMBRERO, RED, BLUE);
            acceptDyed(output, AccentsItems.WIZARD_HAT, BLUE, BLACK);
            acceptDyed(output, AccentsItems.CROWN, RED, LIME);
            acceptDyed(output, AccentsItems.PUMPKIN_HAT, YELLOW, LIME);
            acceptDyed(output, AccentsItems.HORNS, BLACK, RED);
            acceptDyed(output, AccentsItems.SKULL, WHITE, BLACK);
            acceptDyed(output, AccentsItems.DRAGON_SKULL, WHITE, BLACK);
            acceptDyed(output, AccentsItems.QUIVER, BLACK, LIME);
            acceptDyed(output, AccentsItems.BANDOLIER, BLACK, LIGHT_BLUE);
            acceptDyed(output, AccentsItems.SHEATHED_KATANA, RED, PURPLE);
            acceptDyed(output, AccentsItems.WINGS, WHITE, BLACK);
            acceptDyed(output, AccentsItems.HOLSTERED_BELT, LIGHT_BLUE, BLACK);
            acceptDyed(output, AccentsItems.HERMES_BOOTS, LIGHT_BLUE, LIME);
        }

        private static void acceptDyed(
                CreativeModeTab.Output output, DeferredItem<VanityItem> item,
                List<DyeItem> primary, List<DyeItem> secondary) {
            output.accept(item);
            output.accept(DyeableLeatherItem.dyeArmor(item.instantiate(), primary));
            output.accept(DyeableLeatherItem.dyeArmor(item.instantiate(), secondary));
        }
    }

    static void init() {}
}
