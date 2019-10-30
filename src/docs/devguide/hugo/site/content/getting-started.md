---
title: "Getting Started"
menu:
  main:
    weight: 10
---

The Electrum QR Payment Service Interface is a RESTful HTTP based messaging protocol, intended to provide retailers and partners with a framework to facilitate QR code payments.

The Electrum QR Payment Service Interface is licensed under an Apache 2.0 license.

## Language Support

### Java

The Electrum implementation of the Electrum QR Payment Service Interface is written in Java. It is highly recommended that if you are planning a Java implementation of the Electrum QR Payment Service Interface you include the Electrum Payment QR Service Interface as a dependency in your project to save you from having to re-implement the interface. This can be done using the following Maven dependency:

```xml
<dependency>
    <groupId>io.electrum</groupId>
    <artifactId>qr-payment-service-interface</artifactId>
    <version>1.1.0</version>
</dependency>
```

### Other languages

The Electrum QR Payment Service Interface is described as a [Swagger (OpenApi) document](/swagger). It is highly recommended that widely available swagger tooling is used to generate a project in your preferred language as a starting point to a new integration project.
