LOGGING_NAMESPACE:=vector
APPLICATION_NAMESPACE:=apps

# start
start-all:
	cd internal/as_agent && \
		kubectl apply -k .
delete-all:
	cd ./internal/as_agent/ && \
		kubectl delete -k .
tail:
	kubectl logs -n vector daemonset/vector
