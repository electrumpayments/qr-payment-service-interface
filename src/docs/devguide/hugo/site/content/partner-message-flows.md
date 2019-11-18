---
title: "Partner Message Flows"
menu:
  main:
    weight: 60
---
## Overview
From a partner perspective, a QR payment flow comprises the following operations:

1. Notifying Electrum of a QR Code scan.
2. Receiving a payment authorisation request associated with the above scan.
3. Finalising or reversing this payment based on the advice message received.

![QR Payment Message Flow](/images/full_qr_flow.png "QR Payment Flow")

## Scan Notifications
Once a scan is made by a mobile application it is necessary to notify the Electrum server of this action by sending a `ScanNotification`.
As it is not possible for the retailer to know at tender time which partner has been selected by the customer, the
`ScanNotification` plays the important role of alerting the Electrum system which partner has been selected for a given `PaymentRequest`.

The `ScanNotification` carries the unique transaction ID (`tranId`) encoded in the QR code and allows the Electrum system to match the scan
to the `PaymentRequest` sent upstream by the retailer.

![Request QR Code Flow](/images/p3_partner_scan_notification_flow.png "Scan Notification Flow")

### Unsuccessful scenarios
There are a number of scenarios in which it is possible for a `ScanNotification` to fail. In these scenarios it is necessary to notify the customer via the application that their request to tender has failed. Examples include the following:

#### No `PaymentRequest` from a retailer was received
![Payment Flow](/images/p4_partner_declined_scan.png "Payment Authorisation and Finalisation Flow")

#### The `ScanNotification` reached Electrum after the agreed upon timeout window had elapsed
![Payment Flow](/images/s2_late_scan_notification.png "Payment Authorisation and Finalisation Flow")

#### The `ScanNotification` arrived at Electrum before the `PaymentRequest` from the retailer.
![Payment Flow](/images/s3_scan_notification_arrives_before_payment_request.png "Payment Authorisation and Finalisation Flow")


## Payment Authorisations and Finalisations
Once a `ScanNotification` is received it is possible for the Electrum system to process the associated `PaymentRequest` received from the retailer.

The payment flow is dual message and comprises two messages:

- A payment authorisation request (`PaymentRequest`), which requests the funds to be reserved for tender by the partner.
- One of the following two advice messages, which will be sent "offline" and subject to SAF:
    - A finalisation advice (`ConfirmationAdvice`), which signifies that the tender was successfully completed by the retailer and the funds should be withdrawn.
    - A reversal (`ReversalAdvice`), which signifies that the tender was not completed and that the reservation on the funds should be removed.


![Payment Flow](/images/p1_partner_payment_flow.png "Payment Authorisation and Finalisation Flow")

## Tender Reversals and Timeout Reversals
Payment authorisations are required to be reversible.
These reversals may be sent in either of the scenarios below:

- By a retailer to void an otherwise successfully processed payment authorisation. This may be for any number of reasons: the customer has
opted to not go through with the tender, the POS malfunctioned, the basket has been voided, etc.
- By Electrum in cases where no response to a `PaymentRequest` was received and the state of the transaction upstream is unknown. In this scenario
a `PaymentReversal`, as a "Timeout Reversal", will be sent to ensure that it is safe for downstream entities to proceed as if the transaction has not gone through.
A `PaymentReversal` will be subject to SAF, thus it is guaranteed that this transaction will eventually be reversed.

In both case above, reversals are intended to correct a system issue or a cancelled transaction, and thus will not be used as a general-purpose refund mechanism. Customer refunds and return of goods are out of scope of this document.

The flow for a Timeout Reversal between a processor and Electrum is as per the diagram below:

![Timeout Reversal Flow](/images/p2_partner_timeout_reversal_flow.png "Timeout Reversal Flow Between Electrum and Partner")


The full flow for a retailer-triggered payment reversal is as per the diagram below.


![Payment Reversal Flow](/images/s6_payment_void.png "Payment Authorisation and Reversal Flow")


The full flow for a Timeout Reversal is as per the diagram below.


![Timeout Reversal Flow](/images/s5_timeout_reversal.png "Timeout Reversal Flow")
