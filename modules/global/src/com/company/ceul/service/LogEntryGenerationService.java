package com.company.ceul.service;

import com.haulmont.cuba.core.entity.Entity;

public interface LogEntryGenerationService {
    String NAME = "ceul_LogEntryGenerationService";

    public void generate(Entity loggable, int amount);
}