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
| filtering                                                                    | <filter></filter> | [FILTER]   |        |
| buffering data                                                               | <buffer></buffer> | [BUFFER]   |        |
| route your data through Filters and finally to one or multiple destinations. | <match></match>   | [OUTPUT]   |        |
