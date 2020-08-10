package com.company.ceul.web.screens.importentry;

import com.company.ceul.service.LogEntryGenerationService;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.ButtonsPanel;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.ListComponent;
import com.haulmont.cuba.gui.screen.*;
import com.company.ceul.entity.ImportEntry;
import de.diedavids.cuba.loggable.web.WithLogEntriesSupport;

import javax.inject.Inject;

@UiController("ceul_ImportEntry.browse")
@UiDescriptor("import-entry-browse.xml")
@LookupComponent("importEntriesTable")
@LoadDataBeforeShow
public class ImportEntryBrowse extends StandardLookup<ImportEntry> implements WithLogEntriesSupport {

    @Inject
    protected GroupTable<ImportEntry> importEntriesTable;

    @Inject
    protected ButtonsPanel buttonsPanel;
    @Inject
    protected LogEntryGenerationService logEntryGenerationService;

    @Override
    public ListComponent getListComponentForLogEntries() {
        return importEntriesTable;
    }

    @Override
    public ButtonsPanel getButtonsPanelForLogEntries() {
        return buttonsPanel;
    }

    @Subscribe("importEntriesTable.generateLogs")
    protected void onImportEntriesTableGenerateLogs(Action.ActionPerformedEvent event) {

        logEntryGenerationService.generate(importEntriesTable.getSingleSelected(), 10);

    }
}