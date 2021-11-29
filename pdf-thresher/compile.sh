#!/bin/bash

set -e

./gradlew clean cTG 

echo "TRACER result : $?"
