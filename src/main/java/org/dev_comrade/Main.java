package org.dev_comrade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        var runner = new ExampleRunner(100000);
        runner.run();
    }
}