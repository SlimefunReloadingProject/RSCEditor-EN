package com.balugaq.rsceditor.api.objects.types;

import lombok.Getter;

import java.util.List;

@Getter
public class Register {
    private final String idAlias;
    private final boolean lateInit;
    private final boolean warn;
    private final boolean unfinished;
    private final List<String> conditions;
    public Register(String id_alias, boolean lateInit, boolean warn, boolean unfinished, List<String> conditions) {
        this.idAlias = id_alias;
        this.lateInit = lateInit;
        this.warn = warn;
        this.unfinished = unfinished;
        this.conditions = conditions;
    }
}
