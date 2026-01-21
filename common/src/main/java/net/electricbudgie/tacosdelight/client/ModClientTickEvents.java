package net.electricbudgie.tacosdelight.client;

import dev.architectury.event.events.client.ClientTickEvent;
import net.electricbudgie.tacosdelight.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;

public class ModClientTickEvents {
    private static RegistryEntry<StatusEffect> disappointedEntry = null;

    private static void registerDisappointmentClientEvents(){
        ClientTickEvent.CLIENT_POST.register(client -> {
            if (client.player == null) return;
            PlayerEntity player = client.player;

            if (disappointedEntry == null) {
                disappointedEntry = player.getWorld()
                        .getRegistryManager()
                        .get(RegistryKeys.STATUS_EFFECT)
                        .getEntry(ModEffects.DISAPPOINTED.get());
            }

            if (player.hasStatusEffect(disappointedEntry)) {
                var velocity = player.getVelocity();
                double horizontalVelocity = Math.sqrt(velocity.x * velocity.x + velocity.z * velocity.z);
                if (horizontalVelocity > 0.01 ) return;
                float currentPitch = player.getPitch();
                float targetPitch = (currentPitch + 0.7f); // tune: 0.05–0.3 works nicely
                targetPitch = Math.min(targetPitch, 59f);
                player.setPitch(targetPitch);
            }
        });
    }

    public static void registerClientTickEvents(){
        registerDisappointmentClientEvents();
    }
}
