# Setup

## Fluent-bit on k8s
- [Installation](https://docs.fluentbit.io/manual/installation/kubernetes#installation)

## Specific
Docker-desktop k8s cluster uses `containerd` as CRI


## Cmds

```shell
# show config maps
kubectl get configmap -n logging

```

## Pod-to-pod connection

- [https://stackoverflow.com/a/52275246](https://stackoverflow.com/a/52275246)

## Todos

Might need change in `fluent-bit-configmap.yaml` -> `docker` to `cri` according to doc

> The default configmap assumes that dockershim is utilized for the cluster. If a CRI runtime, such as containerd or CRI-O, is being utilized,
> the CRI parser should be utilized. More specifically, change the Parser described in input-kubernetes.conf from docker to cri.
