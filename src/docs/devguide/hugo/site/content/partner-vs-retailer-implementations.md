---
title: "Partner And Retailer Implementations"
menu:
  main:
    weight: 40
---

## Retailer And Partner Roles

The Electrum QR Payment Service Interface describes an interface for QR code based transactions. It defines operations between retailers and partners necessary for effecting QR based transactions. However, QR based transactions deviate from conventional request/response based transaction APIs by allowing the partner (who sits in an upstream position with respect to a retailer) to initiate communications with the retailer. In a conventional card-based transaction this would be similar to an acquiring bank initiating a request to a retailer ahead of a transaction which is not a typical pattern within card-based payment APIs.

Furthermore, the Electrum QR Payment Service Interface aims to make QR based transactions an accessible mechanism for POS systems within a retailer's estate. However, this complicates the task of partner institutions whose role is to notify a POS system which partner a transaction should be routed to. A partner cannot be assumed to communicate directly with each retailer POS which processes a QR transaction. Indeed, an Electrum-generated QR code scanned by a partner's application carries a single indication of which retailer the partner should notify of the scan; the partner may not be able to identify the specific POS where the QR code was displayed.

Thus, an intermediate system may be used to:

- Generate QR codes when requested by a POS.
- Receive notifications from partners of QR codes which have been scanned.
- Link payment requests from POS systems with the associated scan notification in order to direct the payment request to the correct partner.

With this intermediate system in place, the operations of the Electrum QR Payment Service Interface differ slightly from the perspective of the retailer and partner respectively:

- A partner need not implement an operation to create QR codes. This operation is particularly challenging for partners as, at the time a QR code is generated, it's not known which partner the customer intends to use with the QR code thus partners would need to ensure inter-operability.
- A retailer POS system need not be able to accept a notification from the partner that the QR code was scanned. Furthermore, retailers need not provide partners with access to their internal systems to receive such notifications at the POS.

While an intermediate system is required to fully implement all operations defined in the Electrum QR Payment Service Interface, retailers and partners need only implement operations as required by their roles. These different implementations are further discussed in more detail in the following sections.

## Retailer Operations

As mentioned above, retailer POS systems should implement operations to:

- Request a QR code for display to a customer (`createQrCode`).
- Request a transaction be processed against an associated QR code *without concern of the partner selected by the customer* (`pay`).
- A retailer should also implement confirmation and reversal operations as required to ensure the final state of transactions are communicated (`confirmPayment` and `reversePayment` respectively).

Once a retailer submits a payment request to the intermediate system, the intermediate system will associate the payment request with a scan notification from a partner. The intermediate may then inform the POS system in the response message which partner processed the payment. Thus a POS system may be informed of the partner after the request has been processed by need not be aware of the partner ahead of the transaction.

Since a retailer's POS system does not need to receive a notification of a QR code scan, the retailer's POS system is also unable to receive the `partnerPaymentToken` which a partner may submit in a scan notification. This may be conveniently ignored since the intermediate system which does receive the scan notification should populate it in the payment request to the partner.

## Partner Operations

Partners need not implement operations to provide QR codes to retailers. Rather, partners should implement the `notifyScan` operation which notifies retailers when one of their QR codes has been scanned.

At the time of the payment request the role of the partner is similar to any other conventional request/response transactional API. The partner should implement the operations to accept payment requests as well as confirmations or reversals of prior payment requests (`pay`, `confirmPayment` and `reversePayment`). A partner may also be confident that, should a `partnerPaymentToken` be provided in the scan notification to the intermediate system, it will be present in the payment request received from the intermediate system.
