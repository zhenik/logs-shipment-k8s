# Comparisons

## Quick

| text         | Fluentd                                                    | Fluent-bit                                                   | Vector |
|--------------|------------------------------------------------------------|--------------------------------------------------------------|--------|
| Language     | Ruby & C                                                   | C                                                            |        |
| Memory       | ~40MB                                                      | ~650KB                                                       |        |
| Dependencies | Built as a Ruby Gem, it requires a certain number of gems. | Zero dependencies, unless some special plugin requires them. |        |
| Plugins      | 1000+ available                                            | 70+ available                                                |        |
| License      | Apache License v2.0                                        | Apache License v2.0                                          |        |
| syntax       | XML'ish in .conf                                           | Common .conf                                                 |        |
| additional   | can work as Aggregators or Forwarders                      | can work as Aggregators or Forwarders                        |        |

## Syntax definitions

| Field                                                                        | Fluentd           | Fluent-bit | Vector |
|------------------------------------------------------------------------------|-------------------|------------|--------|
| system setup                                                                 | <system></system> | [SERVICE]  |        |
| gather information from different sources                                    | <source></source> | [INPUT]    |        |
| structure or format  data                                                    | <format></format> | [PARSER]   |        |
| filtering (modify, enrich, drop)                                             | <filter></filter> | [FILTER]   |        |
| buffering data                                                               | <buffer></buffer> | [BUFFER]   |        |
| route your data through Filters and finally to one or multiple destinations. | <match></match>   | [OUTPUT]   |        |

## FluentBit annotations
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
