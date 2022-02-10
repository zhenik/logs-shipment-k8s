LOGGING_NAMESPACE:=logging

# setup
namespace:
	kubectl create namespace ${LOGGING_NAMESPACE}
install:
	kubectl create -f ./internal/fluent-bit-service-account.yaml
	kubectl create -f ./internal/fluent-bit-role-1.22.yaml
	kubectl create -f ./internal/fluent-bit-role-binding-1.22.yaml
config-map:
	kubectl create -f ./internal/fluent-bit-configmap.yaml
	kubectl get configmap -n ${LOGGING_NAMESPACE}
fluent-bit-es-minikube:
	kubectl create -f ./internal/fluent-bit-ds-minikube.yaml

# cleanup
delete:
	kubectl delete -f ./internal/fluent-bit-ds-minikube.yaml
	kubectl delete -f ./internal/fluent-bit-configmap.yaml
	kubectl delete -f ./internal/fluent-bit-role-binding-1.22.yaml
	kubectl delete -f ./internal/fluent-bit-role-1.22.yaml
	kubectl delete -f ./internal/fluent-bit-service-account.yaml
