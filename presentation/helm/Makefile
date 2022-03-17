RELEASE_NAME := vector-applogs
NAMESPACE := management
CHART_VERSION := --version 0.6.0

install:
	helm install -f values.yaml $(RELEASE_NAME) vector/vector $(CHART_VERSION) -n $(NAMESPACE)
uninstall:
	helm uninstall $(RELEASE_NAME) -n $(NAMESPACE)
