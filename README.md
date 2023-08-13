# Kafka queue message monitoring application 
## Developed with React + Spring Boot + Apache Kafka + Docker

This application demonstrates, with the use of Docker, a running application that monitors a message queue in 'almost' real-time.

This is by no means a realistic example of production system.  This simply gives a starting point for anyone looking wire together a Spring Boot API with Kafka, and it provides a rudimentary method to monitor the queue with a very simple React component.  

What this covers:

- Using Docker to launch a running Kafka instance
- Using Spring Boot to produce a new message every 10 seconds and add it to the Kafka queue
- Using Spring Boot as a consumer of Kafka messages and provide an endpoint to retrieve un-read messages
- Using React 18 to poll and retrieve new messages, displaying them to the user.


## Running instructions

DockerFile's exist for both the backend and frontend that will perform the necessary build tasks.

- Clone the repository
- CD to the top level folder containing docker-compose.yml
- Run with docker-compose up -d
- Point your browser to http://localhost:3000/
- Watch the queue messages change every 10 seconds. As they retrieved, they are removed from the queue.  

Developed by [Tucanoo Solutions LTD](https://tucanoo.com) 

