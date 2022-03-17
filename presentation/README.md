# What is `vector`
[Vector Official definition](https://vector.dev/docs/about/what-is-vector/)

`Vector` - is a tool to process/aggregate observability data, such as Logs and Metrics.

Works in two modes: 
- Agent(Data collector) - we use this mode
- Aggregator(aggregate data from different sources)

Vector is binary application that you can set up on local machine and run.

```shell
~> vector
2022-03-17T12:22:32.357872Z  INFO vector::app: Log level is enabled. level="vector=info,codec=info,vrl=info,file_source=info,tower_limit=trace,rdkafka=info,buffers=info"
2022-03-17T12:22:32.359487Z ERROR vector::config::loading: Config file not found in path. path="/etc/vector/vector.toml"
```

- Go through [Concepts](https://vector.dev/docs/about/concepts/)
- [Simple config presentation](./config/simple_1.yaml)

Run
```shell
cat logs/simple_1.json | vector -c config/simple_1.yaml | jq
```

- Our deployment case is [Vector as distributed agent](https://vector.dev/docs/setup/deployment/topologies/) across nodes in kubernetes cluster
