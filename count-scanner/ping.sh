#!/bin/bash

set -e

curl http://localhost:8080/scan-count/ping | jq

