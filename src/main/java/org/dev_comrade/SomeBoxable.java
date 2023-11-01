package org.dev_comrade;

import be.quodlibet.boxable.datatable.DataTable;

import java.io.Closeable;
import java.io.IOException;

public interface SomeBoxable extends Closeable {
    DataTable getDataTable() throws IOException;
}
