This page describes changes to the QR Payment Service Interface implemented across different releases of the interface.

## v1.3.1
Released TBC January 2020

* Removed the length limitation on the `id` field of the `ErrorDetail` model.

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
