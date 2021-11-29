package me.guillaume.recruitment.tournament.equipment;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public final class EquipmentFactory {
    public static Equipment getEquipment(final String equipment) {
        final Map<? super String, Supplier<? extends Equipment>> equipmentsSuppliers = new HashMap<>();

        equipmentsSuppliers.put("buckler", Buckler::new);
        equipmentsSuppliers.put("armor", Armor::new);

        return Optional.ofNullable(equipmentsSuppliers.get(equipment))
                .orElseThrow(IllegalArgumentException::new)
                .get();
    }
}
