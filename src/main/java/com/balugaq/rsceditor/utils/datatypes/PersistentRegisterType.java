package com.balugaq.rsceditor.utils.datatypes;

import com.balugaq.rsceditor.api.objects.types.Register;
import com.balugaq.rsceditor.utils.KeyUtil;
import com.jeff_media.morepersistentdatatypes.DataType;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import java.util.List;

public class PersistentRegisterType implements PersistentDataType<PersistentDataContainer, Register> {

    public static final PersistentDataType<PersistentDataContainer, Register> TYPE = new PersistentRegisterType();
    private static final NamespacedKey ID_ALIAS = KeyUtil.newKey("id_alias");
    private static final NamespacedKey LATE_INIT = KeyUtil.newKey("late_init");
    private static final NamespacedKey WARN = KeyUtil.newKey("warn");
    private static final NamespacedKey UNFINISHED = KeyUtil.newKey("unfinished");
    private static final NamespacedKey CONDITIONS = KeyUtil.newKey("conditions");

    @Override
    @Nonnull
    public Class<PersistentDataContainer> getPrimitiveType() {
        return PersistentDataContainer.class;
    }

    @Override
    @Nonnull
    public Class<Register> getComplexType() {
        return Register.class;
    }

    @Override
    @Nonnull
    public PersistentDataContainer toPrimitive(@Nonnull Register complex, @Nonnull PersistentDataAdapterContext context) {
        final PersistentDataContainer container = context.newPersistentDataContainer();
        final String id_alias = complex.getIdAlias();
        if (id_alias != null) {
            container.set(ID_ALIAS, PersistentDataType.STRING, id_alias);
        }
        final boolean late_init = complex.isLateInit();
        container.set(LATE_INIT, DataType.BOOLEAN, late_init);

        final boolean warn = complex.isWarn();
        container.set(WARN, DataType.BOOLEAN, warn);

        final boolean unfinished = complex.isUnfinished();
        container.set(UNFINISHED, DataType.BOOLEAN, unfinished);


        final List<String> conditions = complex.getConditions();
        if (conditions != null && !conditions.isEmpty()) {
            final String[] conditionArray = conditions.toArray(new String[0]);
            container.set(CONDITIONS, DataType.STRING_ARRAY, conditionArray);
        }

        return container;
    }

    @Override
    @Nonnull
    public Register fromPrimitive(@Nonnull PersistentDataContainer primitive, @Nonnull PersistentDataAdapterContext context) {
        final String id_alias = primitive.get(ID_ALIAS, PersistentDataType.STRING);
        final boolean late_init = primitive.getOrDefault(LATE_INIT, DataType.BOOLEAN, false);
        final boolean warn = primitive.getOrDefault(WARN, DataType.BOOLEAN, false);
        final boolean unfinished = primitive.getOrDefault(UNFINISHED, DataType.BOOLEAN, false);
        final String[] conditions = primitive.get(CONDITIONS, DataType.STRING_ARRAY);
        final List<String> conditionList = conditions != null ? List.of(conditions) : null;
        return new Register(id_alias, late_init, warn, unfinished, conditionList);
    }
}
