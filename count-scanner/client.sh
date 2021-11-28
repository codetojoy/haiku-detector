#!/bin/bash

set -e

curl http://localhost:8080/scan-count/find -H "Content-Type: application/json" -d @./resources/data.json | jq

