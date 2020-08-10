package com.company.ceul.web.screens.importentry;

import com.haulmont.cuba.gui.screen.*;
import com.company.ceul.entity.ImportEntry;

@UiController("ceul_ImportEntry.edit")
@UiDescriptor("import-entry-edit.xml")
@EditedEntityContainer("importEntryDc")
@LoadDataBeforeShow
public class ImportEntryEdit extends StandardEditor<ImportEntry> {
}