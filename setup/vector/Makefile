LOGGING_NAMESPACE := vector
APPLICATION_NAMESPACE := apps
.DEFAULT_GOAL := start-all

# start
start-all: app
	cd internal/as_agent && \
		kubectl apply -k .
delete-all: app-rm
	cd ./internal/as_agent/ && \
		kubectl delete -k .
tail:
	kubectl logs -n vector daemonset/vector

# application
app:
	kubectl create namespace ${APPLICATION_NAMESPACE}
	kubectl create -f ../simpleapp/simpleapp.yaml
app-rm:
	kubectl delete namespace ${APPLICATION_NAMESPACE}
