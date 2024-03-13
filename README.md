# Jenkins Task Automation Project

## Overview

This project automates Jenkins tasks using a Groovy script. It includes a Jenkins pipeline for building and deploying a Python Flask application, which interacts with Docker to list running containers. Additionally, it modifies and deploys an Nginx container to act as a proxy to the Flask application.

## Prerequisites

- Docker
- Jenkins with Job DSL plugin

## Flask Application

The Flask app, contained within this repo, interfaces with the Docker engine to display running containers.

## Nginx Proxy

The Nginx container is configured to proxy requests to the Flask application, injecting the source IP into request headers.

## Jenkins Pipeline

The Groovy script sets up three Jenkins jobs:
1. Build and push the Flask Docker container.
2. Build and push the modified Nginx container.
3. Deploy these containers and ensure they are running correctly.
