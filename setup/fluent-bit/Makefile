LOGGING_NAMESPACE:=logging
APPLICATION_NAMESPACE:=apps

# start
start-all: install config-map fluent-bit-es-minikube app
delete-all:
	kubectl delete -f ./internal/fluent-bit-ds-minikube.yaml
	kubectl delete -f ./internal/fluent-bit-configmap.yaml
	kubectl delete -f ./internal/fluent-bit-role-binding-1.22.yaml
	kubectl delete -f ./internal/fluent-bit-role-1.22.yaml
	kubectl delete -f ./internal/fluent-bit-service-account.yaml
	kubectl delete -f ./internal/elasticsearch.yaml
	kubectl delete -f ../simpleapp/simpleapp.yaml








# actions
namespace:
	kubectl create namespace ${LOGGING_NAMESPACE}
	kubectl create namespace ${APPLICATION_NAMESPACE}
install:
	kubectl create -f ./internal/elasticsearch.yaml
	kubectl create -f ./internal/fluent-bit-service-account.yaml
	kubectl create -f ./internal/fluent-bit-role-1.22.yaml
	kubectl create -f ./internal/fluent-bit-role-binding-1.22.yaml
config-map:
	kubectl create -f ./internal/fluent-bit-configmap.yaml
	kubectl get configmap -n ${LOGGING_NAMESPACE}
fluent-bit-es-minikube:
	kubectl create -f ./internal/fluent-bit-ds-minikube.yaml

# debug
n:
	kubectl get namespace
fp:
	kubectl -n logging port-forward elasticsearch-0 9200:9200
geta:
	kubectl get all -n logging
curl:
	curl http://localhost:9200/_cat/indices
describe-service:
	kubectl describe service elasticsearch -n logging


# application
app:
	kubectl create -f ../simpleapp/simpleapp.yaml
app-rm:
	kubectl delete -f ../simpleapp/simpleapp.yaml
