This page describes changes to the QR Payment Service Interface implemented across different releases of the interface.

## v1.8.0
Released 28 June 2021

* Removed the `scheme`, `overPaymentAllowed` and `singleUse` fields from the `QrProperties` class.
* Replaced the `uuid` field with the `guid` field  in the `QrProperties` class.
* Added `description` field to the `QrProperties` class.
* Added `destinationAccountId` to the `CreateQrCodeMessage` class.
* Updated `service-interface-base` from `3.30.1` to `3.31.0`.
* Added `message-masking-sdk` dependency so that API fields can be masked.

## v1.7.0 (Deprecated - see v1.8.0)
Released 3 May 2021

* Updated `CreateQrCodeMessage` model to implement `VasMessage` interface.
* Removed `hibernate-validation` dependency as it is already supplied by `service-interface-base`.
* Added a new model object called `QrProperties`.
* Added the following member variables to the `CreateQrCodeRequest` and `CreateQrCodeResponse` model objects:
    * `customer`
    * `qrProperties`
* The `service-interface-base` provides a lot of dependencies that it previously didn't. For this reason the following
  dependencies were removed from this project's pom file:
    * `joda-time`
    * `swagger-jersey2-jaxrs`
    * `swagger-hibernate-validations`
    * `jersey-server`
    * `jersey-common`
    * `jersey-container-servlet`
    * `jersey-client`
    * `jersey-media-json-jackson`
    * `hibernate-validator`
* Added minimum requirement for `service-interface-base` v3.30.1 and up.

## v1.6.0
Released 19 April 2021

* Updated `ErrorDetail` model to implement `TranidField` interface.

## v1.5.0
Released 16 April 2021

* Updated `service-interface-base` from `3.23.0` to `3.26.0`.
* Updated the following payloads to implement the `HasAmounts` interface:
    * `CreateQrCodeMessage`
    * `PaymentRequest`
    * `PaymentResponse`
    * `ScanNotification`


## v1.4.0
Released 12 March 2020

* Dropped a trailing forward slash from operation paths. The trailing forward slash implied operations were performed against groups of resources when they were intended to act on a single resource within the group.
  * Note, this change is a breaking change for the Java implementation of the API provided by Electrum:
    * The `RELATIVE_PATH` and `FULL_PATH` constants for the following operations have changed and no longer end with a trailing forward slash:
      * `createQrCode`
      * `pay`
      * `notifyScan`
* The Jetty Server dependency was deemed unnecessary and removed. The Javax Servlet API (v3.1.0) is instead required to be available in the runtime environment.

## v1.3.0
Released 10 January 2020

* Updates to the Java implementation of the QR Payment Service Interface:
    * The `equals` method of the following classes has been corrected to not call the super method from the `Object` class:
        * `ScanNotification`
        * `CreateQrCodeMessage`
        * `PaymentRequest`
        * `PaymentResponse`
    * Added the `equals` and `hashCode` method to the `PaymentConfirmation` class.

## v1.2.0
Released 10 January 2020

* Updates to the Java implementation of the QR Payment Service Interface:
    * The Java implementation is now built against OpenJDK 11.
    * The `hashCode` method of the following classes has been corrected to not use the method from the `Object` class:
        * `ScanNotification`
        * `CreateQrCodeMessage`
* The QR Payment Service Interface is now built against v3.23.0 of the base API. This includes the following changes:
    * Added utility methods to JsonUtil class to assist in reading the contents of a file as a string and deserialising JSON objects from files.
    * Added new field `region` to `BankAccount` model for scenarios where the `routingCode` is not sufficient to uniquely identify a bank account.

## v1.1.0
Released 18 November 2019

* All documentation was reviewed and updated for correctness.
* `equals`, `toString` and `hashcode` methods where altered to refer to `super` methods rather than directly re-using inherited fields.
* The maximum length of the `errorMessage` field in the `ErrorDetail` model was increased to 40 characters.

## v1.0.0
Released 9 October 2019

* Initial release
