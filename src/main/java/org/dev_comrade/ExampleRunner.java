package org.dev_comrade;

import be.quodlibet.boxable.datatable.DataTable;
import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ExampleRunner implements Runnable {
    private final long totalRows;

    public ExampleRunner(long totalRows) {
        this.totalRows = totalRows;
    }

    @Override
    public void run() {
        var fastBoxable = new FastBoxable();
        var poorBoxable = new PoorBoxable();
        var data = generateData();
        try {
            List.of(fastBoxable, poorBoxable).forEach(boxable -> {
                var timer = Stopwatch.createStarted();
                try {
                    log.info("{} - Start call addListToTable()", boxable.getClass().getSimpleName());
                    boxable.getDataTable().addListToTable(data, DataTable.HASHEADER);
                    log.info("{} - Done addListToTable()", boxable.getClass().getSimpleName());
                    timer.stop();
                    timer.start();
                    log.info("{} - Start draw table", boxable.getClass().getSimpleName());
                    boxable.getDataTable().getTable().draw();
                    log.info("{} - Done draw table", boxable.getClass().getSimpleName());
                    timer.stop();
                    timer.start();
                    log.info("{} - Start write file {}", boxable.getClass().getSimpleName(), boxable.getFileName());
                    boxable.writeFile();
                    log.info("{} - Done write file {}", boxable.getClass().getSimpleName(), boxable.getFileName());
                    timer.stop();
                } catch (IOException e) {
                    log.error("Something went wrong ", e);
                    throw new RuntimeException(e);
                } finally {
                    printElapsedTime(boxable, timer);
                }
            });
        } finally {
            try {
                fastBoxable.close();
                poorBoxable.close();
            } catch (IOException e) {
                log.error("Something went wrong ", e);
                Thread.currentThread().interrupt();
            }
        }
    }

    private void printElapsedTime(final SomeBoxable boxable, final Stopwatch stopwatch) {
        if (stopwatch.isRunning()) {
            log.info("WARNING! Your stopwatch is still running!");
        } else {
            log.info("{} - {} milliseconds", boxable.getClass().getSimpleName(), stopwatch.elapsed(TimeUnit.MILLISECONDS));
            log.info("{} - {} seconds", boxable.getClass().getSimpleName(), stopwatch.elapsed(TimeUnit.SECONDS));
            log.info("{} - {} minutes", boxable.getClass().getSimpleName(), stopwatch.elapsed(TimeUnit.MINUTES));
        }
    }

    private List<List> generateData() {
        log.info("Start generate data from {} rows", totalRows);
        var data = new ArrayList<List>();
        data.add(new ArrayList<>(
                Arrays.asList("Column One", "Column Two", "Column Three", "Column Four", "Column Five")));
        for (int i = 1; i <= totalRows; i++) {
            data.add(new ArrayList<>(
                    Arrays.asList("Row " + i + " col One", "Row " + i + " Col Two", "Row " + i + " Col Three", "Row " + i + " Col Four", "Row " + i + " Col Five")));
        }
        log.info("Data generated!");
        return data;
    }

}
