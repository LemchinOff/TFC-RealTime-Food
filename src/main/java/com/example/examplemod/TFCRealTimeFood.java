package com.example.examplemod;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.resources.language.I18n;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod("tfcrealtimefood")
public class TFCRealTimeFood {

    public static boolean showRealTime = true;

    public static final KeyMapping TOGGLE_KEY = new KeyMapping(
            "key.tfcrealtimefood.toggle",
            KeyConflictContext.UNIVERSAL,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_H,
            "key.categories.tfcrealtimefood"
    );

    public TFCRealTimeFood() {
    }

    @Mod.EventBusSubscriber(modid = "tfcrealtimefood", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ModBusEvents {
        @SubscribeEvent
        public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
            event.register(TOGGLE_KEY);
        }
    }

    @Mod.EventBusSubscriber(modid = "tfcrealtimefood", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class ForgeBusEvents {

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            while (TOGGLE_KEY.consumeClick()) {
                showRealTime = !showRealTime;
            }
        }

        @SubscribeEvent
        public static void onScreenKeyPressed(ScreenEvent.KeyPressed.Pre event) {
            if (event.getScreen() instanceof AbstractContainerScreen<?>) {
                InputConstants.Key key = InputConstants.getKey(event.getKeyCode(), event.getScanCode());
                if (TOGGLE_KEY.isActiveAndMatches(key)) {
                    showRealTime = !showRealTime;
                    event.setCanceled(true);
                }
            }
        }

        public static String formatRealTime(long ticks) {
            long totalSeconds = ticks / 20;
            long days = totalSeconds / 86400;
            long hours = (totalSeconds % 86400) / 3600;
            long minutes = (totalSeconds % 3600) / 60;
            long seconds = totalSeconds % 60;

            StringBuilder sb = new StringBuilder();
            if (days > 0) sb.append(days).append(I18n.get("tooltip.tfcrealtimefood.days")).append(" ");
            if (hours > 0) sb.append(hours).append(I18n.get("tooltip.tfcrealtimefood.hours")).append(" ");
            if (minutes > 0) sb.append(minutes).append(I18n.get("tooltip.tfcrealtimefood.minutes")).append(" ");
            if (days == 0 && hours == 0) {
                sb.append(seconds).append(I18n.get("tooltip.tfcrealtimefood.seconds"));
            }
            return sb.toString().trim();
        }
    }
}
