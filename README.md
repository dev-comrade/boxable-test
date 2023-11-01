How to run
----

1) Choose number of rows in [Main.java](src%2Fmain%2Fjava%2Forg%2Fdev_comrade%2FMain.java) default 10000
2) start app from [Main.java](src%2Fmain%2Fjava%2Forg%2Fdev_comrade%2FMain.java)
3) Look at console

My results:

- with 10000 rows:
```
21:20:30.929 [main] INFO  org.dev_comrade.FastBoxable - Create fast data table
21:20:31.089 [main] INFO  org.dev_comrade.PoorBoxable - Create poor data table
21:20:31.089 [main] INFO  org.dev_comrade.ExampleRunner - Start generate data from 10000 rows
21:20:31.101 [main] INFO  org.dev_comrade.ExampleRunner - Data generated!
21:20:31.102 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - Start call addListToTable()
21:20:31.196 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - Done addListToTable()
21:20:31.196 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - Start draw table
21:20:31.592 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - Done draw table
21:20:31.592 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - Start write file fast_boxable.pdf
21:20:31.612 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - Done write file fast_boxable.pdf
21:20:31.612 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - 509 milliseconds
21:20:31.612 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - 0 seconds
21:20:31.612 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - 0 minutes
21:20:31.612 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - Start call addListToTable()
21:20:38.920 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - Done addListToTable()
21:20:38.920 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - Start draw table
21:20:39.186 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - Done draw table
21:20:39.186 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - Start write file poor_boxable.pdf
21:20:39.194 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - Done write file poor_boxable.pdf
21:20:39.194 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - 7581 milliseconds
21:20:39.194 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - 7 seconds
21:20:39.194 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - 0 minutes
```

- with 100000 rows:
```
21:28:51.664 [main] INFO  org.dev_comrade.FastBoxable - Create fast data table
21:28:51.814 [main] INFO  org.dev_comrade.PoorBoxable - Create poor data table
21:28:51.815 [main] INFO  org.dev_comrade.ExampleRunner - Start generate data from 100000 rows
21:28:51.866 [main] INFO  org.dev_comrade.ExampleRunner - Data generated!
21:28:51.867 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - Start call addListToTable()
21:28:52.244 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - Done addListToTable()
21:28:52.244 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - Start draw table
21:28:55.322 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - Done draw table
21:28:55.322 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - Start write file fast_boxable.pdf
21:28:55.400 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - Done write file fast_boxable.pdf
21:28:55.400 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - 3533 milliseconds
21:28:55.400 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - 3 seconds
21:28:55.400 [main] INFO  org.dev_comrade.ExampleRunner - FastBoxable - 0 minutes
21:28:55.400 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - Start call addListToTable()
21:34:38.319 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - Done addListToTable()
21:34:38.319 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - Start draw table
21:34:40.991 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - Done draw table
21:34:40.991 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - Start write file poor_boxable.pdf
21:34:41.039 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - Done write file poor_boxable.pdf
21:34:41.039 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - 345638 milliseconds
21:34:41.039 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - 345 seconds
21:34:41.039 [main] INFO  org.dev_comrade.ExampleRunner - PoorBoxable - 5 minutes
```