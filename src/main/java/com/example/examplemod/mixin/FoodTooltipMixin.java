package com.example.examplemod.mixin;

import com.example.examplemod.TFCRealTimeFood;
import net.dries007.tfc.util.calendar.Calendars;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(TranslatableContents.class)
public class FoodTooltipMixin {

    @Shadow
    @Final
    @Mutable
    private Object[] args;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(String key, String fallback, Object[] initArgs, CallbackInfo ci) {
        if (!TFCRealTimeFood.showRealTime) return;

        if (key != null && key.startsWith("tfc.tooltip.food_expiry_date") && this.args != null && this.args.length >= 2) {
            List<Object> argList = new ArrayList<>(Arrays.asList(this.args));
            if (argList.get(1) instanceof Component bracketComp) {
                long ticks = extractTicksFromComponent(bracketComp);
                if (ticks > 0) {
                    String realTime = TFCRealTimeFood.ForgeBusEvents.formatRealTime(ticks);
                    argList.set(1, Component.literal(realTime));
                    this.args = argList.toArray();
                }
            }
        }
    }

    private long extractTicksFromComponent(Component comp) {
        long[] timeParts = new long[4]; // [0]=years, [1]=months, [2]=days, [3]=hours
        collectTfcTimeParts(comp, timeParts);

        long daysInMonth = Calendars.CLIENT.getCalendarDaysInMonth();
        if (daysInMonth <= 0) daysInMonth = 8;

        long totalDays = timeParts[0] * (daysInMonth * 12) + timeParts[1] * daysInMonth + timeParts[2];
        return totalDays * 24000L + timeParts[3] * 1000L;
    }

    private void collectTfcTimeParts(Component comp, long[] timeParts) {
        if (comp.getContents() instanceof TranslatableContents tc) {
            String k = tc.getKey();
            List<Object> subArgs = Arrays.asList(tc.getArgs());

            if (k != null && !subArgs.isEmpty()) {
                long val = parseLongSafe(subArgs.get(0));
                if (k.startsWith("tfc.time.year")) timeParts[0] += val;
                else if (k.startsWith("tfc.time.month")) timeParts[1] += val;
                else if (k.startsWith("tfc.time.day")) timeParts[2] += val;
                else if (k.startsWith("tfc.time.hour")) timeParts[3] += val;
            }

            for (Object arg : subArgs) {
                if (arg instanceof Component subComp) {
                    collectTfcTimeParts(subComp, timeParts);
                }
            }
        }
        for (Component sibling : comp.getSiblings()) {
            collectTfcTimeParts(sibling, timeParts);
        }
    }

    private long parseLongSafe(Object obj) {
        if (obj instanceof Number num) return num.longValue();
        try {
            return Long.parseLong(String.valueOf(obj).trim());
        } catch (Exception e) {
            return 0;
        }
    }
}
