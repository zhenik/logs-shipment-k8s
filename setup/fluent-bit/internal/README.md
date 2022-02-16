## Filter kubernetes
```shell
# add prefix
    [FILTER]
        Name                nest
        Match               kube.*
        Operation           lift
        Nested_under        kubernetes
        Add_prefix          kubernetes_
# renaming, removing, adding (just an example)
    [FILTER]
        Name modify
        Match kube.*
        Rename log content
        Rename kubernetes_pod_name k8s.pod.name
        Remove kubernetes_docker_id
        Add k8s.cluster.name Onlineboutique
```


## Filter fluent-bit
```shell
# exclude fluent-bit logs
    [FILTER]
        Name                grep
        Match               kube.*
        Exclude             $kubernetes['container_name'] fluent-bit
```


## Links
- [Tune fluent-bit](https://youtu.be/KJlWV5-o8v0)
