---
title: "Retailer Message Flows"
menu:
  main:
    weight: 50
---
## Overview
From a retailer perspective the flow for a QR payment is comprised of the following operations:

1. Requesting and displaying a QR code
2. Making a payment authorisation request based on this QR code
3. Finalising or reversing this payment

![QR Payment Message Flow](/images/full_qr_flow.png "QR Payment Flow")

## Request a QR Code
The message flow to request a QR code works in the following manner:

- The retailer requests a QR code to be generated using the getQrCode operation.
- The QR server returns a QR code containing a unique transaction ID (`tranId`). For the the structure of this
QR code please see the [Advanced Topics](/advanced-topics/) section.
- The retailer displays the above QR code to the customer allowing the customer to begin the
payment journey by scanning this QR code with their mobile device.

![Request QR Code Flow](/images/r2_retailer_get_qr_code_flow.png "Request QR Code Flow")

## Request a payment
The payment flow is dual message and comprised of two messages:

- A payment authorisation request (`PaymentRequest`) which will request the funds to be reserved for tender by the Partner. This
request contains the unique ID encoded in the QR code and will be used to match this `PaymentRequest` to the QR scan.
- One of the following two advice messages which will be sent "offline" and subject to store-and-forward (SAF; see [Advanced Topics](/advanced-topics/)):
    - A finalisation advice (`ConfirmationAdvice`) which signifies to the Partner that the tender was successful and the funds should be withdrawn.
    - A reversal (`ReversalAdvice`) which signifies that the tender was not completed and that the reservation on the funds should be removed.

![Payment Flow](/images/r1_retailer_payment_flow.png "Payment Flow")


It is important to note that the `PaymentRequest` should always be sent upstream before the QR code has been displayed to the customer for scanning. This is to prevent
creating a window in which it is possible for the customer to scan the QR code before the `PaymentRequest` is sent. In this case it would not be possible to match the `PaymentRequest` to the QR scan and hence the tender will fail.

Below is a flow depicting the scenario where a `PaymentRequest` arrives after the QR code has been scanned.

![Scan Precedes Payment Authorisation Flow](/images/s3_scan_notification_arrives_before_payment_request.png "Payment Flow")

## Tender Voids and Timeout Reversals
As mentioned above, a payment authorisation (`PaymentRequest`) may be reversed or "cancelled" by a `ReversalAdvice`.
A ReversalAdvice should be sent in either of the two below scenarios:

- To void an otherwise successfully processed payment authorisation. This may be required for a number of scenarios, for example the customer has
opted to not continue with the tender, the POS malfunctioned or the basket has been voided by the cashier.
- No response to a `PaymentRequest` was received and the state of the transaction upstream is unknown. In this scenario
a `ReversalAdvice`, as a "Timeout Reversal", should be sent to ensure that it is safe to proceed as if the transaction has not gone through.
As as `ReversalAdvice` will be subject to SAF it is guaranteed that this transaction will eventually be reversed.
- In both the above cases, reversals are only effective if received within the processing window agreed for the settlement process between
the affected parties (typically one to three days), and thus cannot be used as a general purpose refund mechanism. Reversals that take place either
after a payment was already confirmed or too long after the initial transaction falls out of scope of this document, as does customer refunds and return of goods.


![Timeout Reversal Flow](/images/r3_retailer_timeout_reversal_flow.png "Timeout Reversal Flow")


The full flow for a TimeoutReversal is as per the below diagram.


![Timeout Reversal Flow](/images/s5_timeout_reversal.png "Timeout Reversal Flow")
