package com.company.ceul.service;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.ViewBuilder;
import de.diedavids.cuba.loggable.entity.LogEntry;
import de.diedavids.cuba.loggable.entity.LogEntryCategory;
import de.diedavids.cuba.loggable.entity.LogLevel;
import de.diedavids.cuba.loggable.service.LogEntryService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;

@Service(LogEntryGenerationService.NAME)
public class LogEntryGenerationServiceBean implements LogEntryGenerationService {

    @Inject
    protected DataManager dataManager;

    @Override
    public void generate(Entity loggable, int amount) {

        IntStream.range(0, amount)
                .forEach(value -> {
                    final List<LogLevel> allLevels = list(LogLevel.class);
                    final List<LogEntryCategory> allCategories = list(LogEntryCategory.class);

                    createLogEntry(
                            loggable,
                            "hello " + value,
                            "hello world " + value,
                            randomOfList(allLevels),
                            randomOfList(allCategories)
                    );
                });

    }

    private void createLogEntry(Entity loggable, String message, String detailedMessage, LogLevel level, LogEntryCategory category) {
        LogEntry logEntry = dataManager.create(LogEntry.class);

        logEntry.setLoggable(loggable);
        logEntry.setMessage(message);
        logEntry.setDetailedMessage(detailedMessage);
        logEntry.setLevel(level);
        logEntry.setCategory(category);

        dataManager.commit(logEntry);
    }


    private <T> T randomOfList(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(random().nextInt(list.size()));
    }

    private Random random() {
        return new Random();
    }

    private <T extends Entity> List<T> list(Class<T> entityClass) {
        return dataManager.load(entityClass).list();
    }

    private <T extends Entity> List<T> list(Class<T> entityClass, Consumer<ViewBuilder> viewBuilderConfigurer) {
        return dataManager.load(entityClass).view(viewBuilderConfigurer).list();
    }
}