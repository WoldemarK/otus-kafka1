������ ����������
```shell
cd kafka
docker compose start
```

�������� ������ �������
```shell
docker exec -ti kafka-otuskafka /usr/bin/kafka-topics --list --bootstrap-server localhost:9091
```

��������� ���������
```shell
docker exec -ti kafka-otuskafka /usr/bin/kafka-console-producer --topic topic1 --bootstrap-server localhost:9091
```
������ ������ - ���� ���������. �������� - Ctrl+Z

�������� ���������
```shell
docker exec -ti kafka-otuskafka /usr/bin/kafka-console-consumer --from-beginning --topic topic1 --bootstrap-server localhost:9091 
```

�������� ��������� ��� consumer1
```shell
docker exec -ti kafka-otuskafka /usr/bin/kafka-console-consumer --group consumer1 --topic topic1 --bootstrap-server localhost:9091 
```

��������� ��������� c ������ ����� ��������� (key:value)
```shell
docker exec -ti kafka-otuskafka /usr/bin/kafka-console-producer --topic topic1 --property "parse.key=true" --property "key.separator=:" --bootstrap-server localhost:9091
```
