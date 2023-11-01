package org.dev_comrade;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.datatable.DataTable;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;
import java.util.List;

@Slf4j
@Getter
public class FastBoxable extends AbstractSomeBoxable {

    protected String fileName = "fast_boxable.pdf";

    public FastBoxable() {
        try {
            log.info("Create fast data table");
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
            dataTable = new DataTable(table, page) {
                @Override
                public void addListToTable(List<List> data, Boolean hasHeader) throws IOException {
                    if (data == null || data.isEmpty()) {
                        return;
                    }
                    StringBuilder output = new StringBuilder();
                    char separator = ';';

                    // Convert Map of arbitrary objects to a csv String
                    for (List<? extends Object> inputList : data) {
                        StringBuilder row = new StringBuilder();
                        for (Object v : inputList) {
                            String value = v.toString();
                            if (value.contains("" + separator)) {
                                // surround value with quotes if it contains the escape
                                // character
                                value = "\"" + value + "\"";
                            }
                            value = value.replaceAll("\n", "<br>");
                            row.append(value).append(separator);
                        }
                        // remove the last separator
                        row = new StringBuilder(row.substring(0, row.length() - 1));
                        output.append(row).append("\n");
                    }

                    addCsvToTable(output.toString(), hasHeader, separator);
                }
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
