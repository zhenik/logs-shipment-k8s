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
cat logs/simple_2.log | vector -c config/simple_2.yaml | jq
```

Test
```shell
vector test --config-yaml config/simple_2.yaml
```

## Vector deployment to k8s
- Our deployment case is [Vector as distributed agent](https://vector.dev/docs/setup/deployment/topologies/) across nodes in kubernetes cluster.
We are going to deploy Vector in Agent mode to k8s cluster(s).
There are [several k8s resources that we need to handle](../setup/vector/internal/as_agent).

### Helm
To avoid making boilerplates we will use [HELM official](https://helm.sh/).

`Helm` - is the package manager for Kubernetes resources bound to one context.

Additional cool things:
- Abstract complexity
- Helm registries
- [Official vector helm chart](https://github.com/vectordotdev/helm-charts/blob/develop/charts/vector/README.md)
- Managing deployments, upgrades/rollbacks

You can install `vector` on k8s cluster using `helm install -f values.yaml ...` command.
For simplification:
```shell
cd helm/ && make install
```

### Missing resources
[Official vector helm chart](https://github.com/vectordotdev/helm-charts/tree/develop/charts/vector/templates) does not handle Azure Key Vault credentials for us,
means that this part we should prepare ourselves.

- [Example of secret SecretProviderClass in yaml](https://github.com/bring/iac-customerfront/blob/master/test/kubernetes-deployments/assets/vector/debug/secret-provider-class.yaml)
- [Example of secret SecretProviderClass handled in terraform](https://github.com/bring/iac-customerfront/blob/master/test/kubernetes-deployments/vector.tf#L13-L57)

### Terraform

- [Helm deployment of `vector` to k8s cluster is handled by terraform](https://github.com/bring/iac-customerfront/blob/master/test/kubernetes-deployments/vector.tf#L59-L69)


## Configuration
Vector supports several formats for the config:
- yaml
- toml
- json

We use `yaml` due to we deploy thing through the `helm` which use `yaml` also

## Deep dive in current setup
- todo//

## What do I need to build proper
- file logs from kubernetes
- different types of logs (json, apache, tomcat, ...)
