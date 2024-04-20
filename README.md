# backend-challenge 🏁

Here is my approach to solving [the backend challenge](https://github.com/digitalservicebund/backend-challenge).

Due to the [`organization_list` API endpoint](https://demo.ckan.org/api/3/action/organization_list) serving an empty result set I've instead created a demo use case using the `license_list` endpoint.

Many aspects of the implementation carry out conscious decisions that can be discussed extensively. I'm happy to do so with you :-)

## 📦 Software stack

I've choosen the Quarkus Framework to solve the challenge due to a personal preference. It's build on the Jakarte EE and Eclipse Microprofile, and thus almost completely readable by users not used to Quarkus.

## ⛓ Requirements

Server side:

- JDK 17

Client side:

- `curl`
- `jq` (optional)

## 🚀 Usage

Use these commands in an empty folder:

    # download and extract the project in the current folder
    curl -sLo - "https://codeberg.org/thomas-mc-work/backend-challenge/archive/main.tar.gz" | tar zxf - --strip 1

    # compile and run in dev mode for local usage
    ./mvnw compile quarkus:dev

    # in a second terminal: query the API endpoint
    curl -s "http://localhost:8080/license" | jq
