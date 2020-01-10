---
title: Qr Payment Service Interface
type: index
---

[Electrum Payments](http://electrum.co.za) connects businesses together to transact with each other easily and robustly.

This Electrum [QR Payment Service Interface](https://github.com/electrumpayments/qr-payment-service-interface) documents the messaging interface used by Electrum to connect retailers and merchants together for performing QR code based payments.

The lifecycle of a QR code based payment can be encapsulated into four major phases - namely:

1. A request from the retailer for a QR code to be scanned by a customer.
2. The scan of the QR code by the customer.
3. A notification from the partner to the merchant that the code has been scanned.
4. The request for tender by the retailer to the partner.

Payments can subsequently be either confirmed or reversed.

The Electrum [QR Payment Service Interface](https://github.com/electrumpayments/qr-payment-service-interface) defines operations and models for each of the above steps in the lifecycle in order to effect payments via QR codes.

The Electrum [QR Payment Service Interface](https://github.com/electrumpayments/qr-payment-service-interface) allows a customer to seamlessly select which service provider should process their request from the merchant without requiring complex customer interactions. A merchant's customer-facing channel (such as a point-of-sale or website) simply provides information to the customer during a transaction in the form of a QR code. A customer may then scan the QR code using a mobile application offered by a customer's chosen service provider. This in turn allows the service provider to contact the merchant for the purposes of processing the transaction request submitted by the point-of-sale system.

For more detail on the message flows please consult the page about message flows.

**Note**: A partner's mobile application, its use by the customer and its communications with the partner's systems is entirely out of scope of the Electrum [QR Payment Service Interface](https://github.com/electrumpayments/qr-payment-service-interface).
