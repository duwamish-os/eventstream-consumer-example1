event processor example
--

logs

```json
{"@timestamp":"2019-05-05T17:48:32.580Z","source_host":"MACC02V82BPHTD7","file":"Worker.java","method":"info","level":"INFO","line_number":"1035","thread_name":"Thread-1","@version":1,"logger_name":"com.amazonaws.services.kinesis.clientlibrary.lib.worker.Worker","message":"Current stream shard assignments: shardId-000000000000","class":"com.amazonaws.services.kinesis.clientlibrary.lib.worker.Worker$WorkerLog","mdc":{}}
{"@timestamp":"2019-05-05T17:48:32.583Z","source_host":"MACC02V82BPHTD7","file":"Worker.java","method":"info","level":"INFO","line_number":"1035","thread_name":"Thread-1","@version":1,"logger_name":"com.amazonaws.services.kinesis.clientlibrary.lib.worker.Worker","message":"Sleeping ...","class":"com.amazonaws.services.kinesis.clientlibrary.lib.worker.Worker$WorkerLog","mdc":{}}
=======================
{"eventType":"PageViewedEvent","createdTime":null,"eventUuid":2,"pageId":"00e39e26-0728-4407-92c4-7f24fb70ff08","userId":"43271343-2742-4fde-91cb-04c7be364b6a","pageViewedDate":{"offset":{"totalSeconds":0,"id":"Z","rules":{"fixedOffset":true,"transitions":[],"transitionRules":[]}},"zone":{"id":"UTC","rules":{"fixedOffset":true,"transitions":[],"transitionRules":[]}},"year":2019,"monthValue":5,"dayOfMonth":4,"hour":22,"minute":53,"second":10,"nano":250479000,"month":"MAY","dayOfWeek":"SATURDAY","dayOfYear":124,"chronology":{"id":"ISO","calendarType":"iso8601"}}}
=======================
{"@timestamp":"2019-05-05T17:49:04.775Z","source_host":"MACC02V82BPHTD7","file":"SequenceNumberValidator.java","method":"validateSequenceNumber","level":"INFO","line_number":"82","thread_name":"RecordProcessor-0000","@version":1,"logger_name":"com.amazonaws.services.kinesis.clientlibrary.lib.worker.SequenceNumberValidator","message":"Validated sequence number 49595429706323119035109752130269124899856804079644704770 with shard id shardId-000000000000","class":"com.amazonaws.services.kinesis.clientlibrary.lib.worker.SequenceNumberValidator","mdc":{}}
```

consumer offset
-----------------

![](eventconsumer_position.png)

State
---

```sql
root@09b67ab0d27d:/# psql analytics -U postgres
psql (11.2 (Debian 11.2-1.pgdg90+1))
Type "help" for help.

select * from page_views;

```

Also see eventstream ingestion example - https://github.com/duwamish-os/eventstream-pipeline-example1

```bash
λ ls -l /tmp/zookeeper/version-2/log.1 
-rw-r--r--  1 a1353612  wheel  67108880 May  7 21:38 /tmp/zookeeper/version-2/log.1

ls -l /tmp/kafka-logs/
total 24
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:24 Pipeline1Stream-0
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-0
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-1
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-10
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-11
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-12
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-13
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-14
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-15
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-16
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-17
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-18
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-19
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-2
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-20
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-21
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-22
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-23
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-24
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-25
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-26
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-27
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-28
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-29
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-3
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-30
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-31
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-32
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-33
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-34
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-35
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-36
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-37
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-38
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-39
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-4
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-40
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-41
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-42
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-43
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-44
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-45
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-46
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-47
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-48
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-49
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-5
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-6
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-7
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-8
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 __consumer_offsets-9
-rw-r--r--  1 prayagupd  wheel     0 May  7 15:23 cleaner-offset-checkpoint
drwxr-xr-x  5 prayagupd  wheel   160 May  7 15:23 es1-0
-rw-r--r--  1 prayagupd  wheel    54 May  7 15:23 meta.properties
-rw-r--r--  1 prayagupd  wheel  1228 May  7 21:38 recovery-point-offset-checkpoint
-rw-r--r--  1 prayagupd  wheel  1228 May  7 21:38 replication-offset-checkpoint

./gradlew run

```

TODO
----

- update db state