index:=logstash-`date +'%Y.%m.%d'`

# aggregate logs per pod
aggregate:
	curl --request POST \
		-H "Content-Type: application/json" \
		--data @./internal/aggregation-payload.json \
		http://localhost:9200/${index}/_search | jq
