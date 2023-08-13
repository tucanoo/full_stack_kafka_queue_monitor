# Build stage
FROM node:16 AS build
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

# Serve using an HTTP server
FROM nginx:alpine
COPY --from=build /app/dist /usr/share/nginx/html