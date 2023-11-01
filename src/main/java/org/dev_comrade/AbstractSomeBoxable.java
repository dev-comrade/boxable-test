package org.dev_comrade;

import be.quodlibet.boxable.datatable.DataTable;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

@Slf4j
@Getter
abstract class AbstractSomeBoxable implements SomeBoxable {
    protected PDDocument document;
    protected PDPage page;
    protected DataTable dataTable;

    protected String fileName = "boxable.pdf";

    public void writeFile() throws IOException {
        document.addPage(page);
        document.save(getFileName());
    }

    @Override
    public void close() throws IOException {
        document.close();
    }
}
