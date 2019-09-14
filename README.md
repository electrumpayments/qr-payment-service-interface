# QR Payment Service Interface

The QR Payment Service Interface documents the messaging interface used by Electrum to connect acquirers, processors, and mobile network operators together for performing payments using the EMVCo QR specification.

You can find documentation for this project [here](https://electrumpayments.github.io/qr-payment-service-interface-docs/).

## Java projects

To include the service interface into your maven project, include the below dependency.

```xml
<dependency>
    <groupId>io.electrum</groupId>
    <artifactId>qr-payment-service-interface</artifactId>
    <version>1.0.0</version>
</dependency>
<dependency>
      <groupId>io.electrum</groupId>
      <artifactId>service-interface-base</artifactId>
      <version>3.21.0</version>
</dependency>
```

Alternatively, you can download the jars from Bintray:
- [qr-payment-service-interface](https://bintray.com/electrumpayments/java-open-source/qr-payment-service-interface)
- [service-interface-base](https://bintray.com/electrumpayments/java-open-source/service-interface-base)

## Other languages

The interface is also available as a swagger (OpenApi) definition, which can be used to generate starter projects in many languages. See more info [here](https://electrumpayments.github.io/qr-payment-service-interface-docs/specification/swagger).
