#!/bin/bash

# Start the nginx and app containers
docker-compose up -d


# Check Application Availability
http_status=$(curl --write-out %{http_code} --silent --output /dev/null http://localhost:80/)
if [[ $http_status -eq 200 ]]; then
    echo "Application is available"
else
    echo "Application is unavailable"
fi



# Cleanup Docker Compose Environment
docker-compose down
