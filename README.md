# Comparisons

Before we start.
Take a look at [common issues with Fluentd from official documentation](https://docs.fluentd.org/troubleshooting-guide#my-logs-have-stopped-sending-data-to-my-backend)

## Quick

| ------         | Fluentd                                                                                         | Fluent-bit                                                                                            | Vector                                                                                                                 |
|----------------|-------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------|
| Language       | Ruby & C                                                                                        | C                                                                                                     | Rust                                                                                                                   |
| Memory         | ~40MB                                                                                           | ~650KB                                                                                                | Says less than fluent-bit. [source](https://medium.com/ibm-cloud/log-collectors-performance-benchmarking-8c5218a08fea) |
| Dependencies   | Built as a Ruby Gem, it requires a certain number of gems.                                      | Zero dependencies, unless some special plugin requires them.                                          | [all dependencies](https://github.com/vectordotdev/vector/blob/master/Cargo.toml#L100)                                 |
| Plugins        | 1000+ available                                                                                 | 70+ available                                                                                         | [100+ available: Sources, Transform, Sinks](https://github.com/vectordotdev/vector#reference)                          |
| License        | Apache License v2.0                                                                             | Apache License v2.0                                                                                   | Mozilla Public License 2.0                                                                                             |
| syntax         | XML'ish in .conf                                                                                | Common .conf                                                                                          | .yaml,json,toml                                                                                                        |
| additional     | [Aggregator/Forwarder](https://docs.fluentbit.io/manual/v/1.0/about/fluentd_and_fluentbit)      | [Forwarder](https://docs.fluentbit.io/manual/v/1.0/about/fluentd_and_fluentbit), limited aggregations | [Aggregator/Forwarder](); Simple topology principle of components (Source, Transform, Sink)                            |
| Tests          | [Supports unit tests: ruby RSpec](https://docs.fluentd.org/plugin-development/plugin-test-code) | [Supports unit tests](https://docs.fluentbit.io/manual/v/1.0/installation/unit_tests)                 | Unit Tests for Transforms                                                                                              |
| Observability  | Logs                                                                                            | Logs, Metrics                                                                                         | Logs, Metrics. ([Traces soon](https://github.com/vectordotdev/vector#principles))                                      |
| Latest release | 1.14.5                                                                                          | 1.8.12                                                                                                | 0.20.0                                                                                                                 |



- :warning: [Additional comparison; Vector affiliated](https://github.com/vectordotdev/vector#comparisons)
- [Who is the winner — Comparing Vector, Fluent Bit, Fluentd performance](https://medium.com/ibm-cloud/log-collectors-performance-benchmarking-8c5218a08fea)

## Syntax definitions

| Field                                                                        | Fluentd               | Fluent-bit | Vector    |
|------------------------------------------------------------------------------|-----------------------|------------|-----------|
| system setup                                                                 | \<system\>\</system\> | [SERVICE]  |           |
| gather information from different sources                                    | \<source>\</source\>  | [INPUT]    | SOURCE    |
| structure or format  data                                                    | \<format\>\</format\> | [PARSER]   | TRANSFORM |
| filtering (modify, enrich, drop)                                             | \<filter\>\</filter\> | [FILTER]   |           |
| buffering data                                                               | \<buffer\>\</buffer\> | [BUFFER]   |           |
| route your data through Filters and finally to one or multiple destinations. | \<match\>\</match\>   | [OUTPUT]   | SINK      |

## Additional
### FluentBit annotations
Directly on `yaml` file. Which parser to use.

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  labels:
    app: any-app
  name: any-app
spec:
  replicas: 1
  selector:
    matchLabels:
      app: any-app
  strategy: { }
  template:
    metadata:
      annotations:
        fluentbit.io/parser: application
      labels:
        app: any-app
```

## Links
- [Youtube - Fluent Bit explained | Fluent Bit vs Fluentd](https://youtu.be/B2IS-XS-cc0?t=510)
- [Medium - Who is the winner — Comparing Vector, Fluent Bit, Fluentd performance](https://medium.com/ibm-cloud/log-collectors-performance-benchmarking-8c5218a08fea)
- [Visualization tool for Fluentbit - Calyptia](https://calyptia.com/)
- [First-class Kubernetes integration for Vector](https://vector.dev/blog/kubernetes-integration/)
