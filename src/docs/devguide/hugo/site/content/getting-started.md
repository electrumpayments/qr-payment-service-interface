---
title: "Getting Started"
menu:
  main:
    weight: 0
---

The Airtime Service Interface is an [Apache-licensed](https://www.apache.org/licenses/LICENSE-2.0) RESTful HTTP based messaging protocol, intended to enable interoperability between airtime providers and retailers.

Using the Airtime Service Interface enables retailers to access an established and growing group of airtime providers who support the interface. At the same time, the Airtime Service Interface is made available to allow airtime providers a quick, well defined route towards integrating into retailers.

## Supported languages

### Java

The Electrum implementation of the Airtime Service Interface is written in Java. It is highly recommended that if you are planning a Java implementation of the Airtime Service Interface you include the [Airtime Service Interface](https://github.com/electrumpayments/airtime-service-interface) dependency in your project to save you from having to re-implement the interface. You can find instructions in the project [readme](https://github.com/electrumpayments/airtime-service-interface).

### Other languages

The Airtime Service Interface is described as a [swagger (OpenApi) document](/specification/swagger). It is highly recommended that widely available swagger tooling is used to generate a project in your preferred language as a starting point to a new integration project.
