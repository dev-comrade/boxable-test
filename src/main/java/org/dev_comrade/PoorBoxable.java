package org.dev_comrade;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.datatable.DataTable;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

@Slf4j
@Getter
public class PoorBoxable extends AbstractSomeBoxable {

    protected String fileName = "poor_boxable.pdf";

    public PoorBoxable() {
        try {
            log.info("Create poor data table");
            document = new PDDocument();
            page = new PDPage();
            float margin = 5;
            // starting y position is whole page height subtracted by top and bottom margin
            float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
            // we want table across whole page width (subtracted by left and right margin ofcourse)
            float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
            boolean drawContent = true;
            float bottomMargin = 10;
            // y position is your coordinate of top left corner of the table
            float yPosition = 10;
            BaseTable table = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, document, page, true, drawContent);
            dataTable = new DataTable(table, page);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
