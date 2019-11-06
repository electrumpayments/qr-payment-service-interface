---
title: "Advanced Topics"
menu:
  main:
    weight: 70
---

## Linking QR code scans and Payment Requests
Successful QR code payment processing requires a link between the customer's scan of a QR code and the retailer's request to tender. This linking is performed by Electrum, which facilitates the aggregation of multiple QR payment partners and hence simplifies the point-of-sale interface by obviating the need for knowing which partner will process the payment when initiating the transaction. If a partner's mobile application is used to scan a QR code and the partner recognises the Merchant Account Information Template [defined by Electrum] (#the-electrum-merchant-account-information-template) within the QR code, then the partner may interact with retailers in a consistent manner via Electrum.

To enable linking, it is necessary for all `paymentRequest` and `scanNotification` operations to contain the same transaction identifier (`tranId`). This allows for them to be matched and the payment processed correctly. The transaction ID serves as a golden thread throughout the transaction flow and allows related transactions between retailers and partners to be associated correctly. It is thus imperative that the transaction ID is set correctly throughout the flow.

Below is a diagram with the transaction ID highlighted to better illustrate its use.

![QR Payment Flow](/images/full_qr_flow_showing_tranid.png "QR Payment Flow Highlighting the Transaction ID.")

## QR Code Structure
### Organization of data
The structure of the QR code is based on a subset of the [EMV QR specification (Merchant Presented Mode)] (https://www.emvco.com/wp-content/plugins/pmpro-customizations/oy-getfile.php?u=/wp-content/uploads/documents/EMVCo-Merchant-Presented-QR-Specification-v1-1.pdf) as set out by EMVco.

The QR code is a string of data comprised of a number of data objects; each containing three fields:

1. A Tag, which identifies the data element within the QR code.
2. A Length field, which specifies exactly how many characters comprise the third field.
3. A Value field in which the data is contained.

The format of the above fields is as follows:

1. The Tag is a two-digit numeric value ranging from '00' to '99'
2. The Length field is a two-digit numeric value ranging from '01' to '99'
3. The Value field is an alpha-numeric string with a minimum length of 1 character and a maximum length of 99 characters.

Value fields themselves contain either primitive data values or other complex data objects that also follow the same Tag-Length-Value layout described above.

### Implementation
The QR data will always begin with Tag '00'. In the context of EMVCo QR data this is reserved for the EMVCo specification version being used. Currently only the first version of the EMVCo specification is supported, hence this Tag will have a Value of '01'. The specification version Value of '01' itself has a Length of '02'. Therefore, the first data element within the QR code data will be '000201':

- Tag = '00'
- Length = '02'
- Value = '01'

The EMVCo specification reserves Tags 26 to 51 for Merchant Account Information Templates. Aside from the EMVCo specification version in Tag '00' as described above, only Tags 26 to 51 are currently supported by the Electrum QR Payment Service Interface.

The format of Values in Tags 26 to 51 is the same Tag-Length-Value format described earlier. It is possible for a QR code to contain the information for a number of distinct entities, in which case a data object for each will be present in Tags 26 to 51.

Within each data object in Tags 26 to 51, the EMVCo specification requires that the first sub-tag (Tag '00') contain a globally unique identifier (GUID), which provides context regarding the remainder of the sub-tags. Any application which parses the QR data may then, with the context provided by sub-Tag '00', interpret the remaining sub-tags.

### The Electrum Merchant Account Information Template

Electrum defines the following format of the Merchant Account Information Template set by Electrum within a QR code.

- Sub-Tag '00' will contain a unique provider identifier. This is a globally unique value through which the provider of the QR code may be identified.
- Sub-Tag '01' will contain the unique transaction reference to be associated with all transactions linked to the QR code.
- No further sub-tags are defined at this time.

#### Examples
Below is an example of when an Electrum QR Payment is the only payment instrument provided:

Payload: `00020126500010za.co.elec0132f82d7f64feea4f2ab24da94aaf5c2941`

Breakdown:

`00 02 `
> `01 `

`26 50`
> `00 10`
>> `za.co.elec`

> `01 32`
>> `f82d7f64feea4f2ab24da94aaf5c2941`

Below is an example of where both Electrum QR Payment and Masterpass are provided:

Payload: `00020126500010za.co.elec0132f82d7f64feea4f2ab24da94aaf5c294127260008za.co.mp01105169175130`

Breakdown:

`00 02 `
> `01 `

`26 50`
> `00 10`
>> `za.co.elec`

> `01 32`
>> `f82d7f64feea4f2ab24da94aaf5c2941`

`27 26`
> `00 08`
>> `za.co.mp`

> `01 10`
>> `5169175130`

## Request ID Construction And Handling

Generation of UUIDs for payment authorisation request messages is an important step in the request process.
The `id` field of messages such as `PaymentRequest` and `PaymentReversal` uniquely identifies an instance of
such a message. For linked messages, such as a `PaymentReversal` which reverses a prior `PaymentRequest`,
the `id` of the `PaymentRequest` is referenced in the `PaymentReversal` to make it clear which `PaymentRequest`
message is referenced in the `PaymentReversal`. It is therefore important that the ID value generated by a
client is unique for that client. If you are developing a client implementation, please take note to generate
IDs as either random UUID's, as defined for a variant 4 UUID by [RFC 4122](https://tools.ietf.org/html/rfc4122)
or variant 3 UUIDs derived from values unique to the message.

These request identifiers must uniquely identify a request within your own client implementation. If possible, the client
should check that the UUID generated for a message has not been previously generated. If the UUID has been used previously,
then the client should generate a new UUID. This process should be repeated as necessary until a unique UUID has been generated.

This specification acknowledges that since clients produce random UUIDs, there is a possibility that a client might repeat an
ID for two independent messages of the same type if the client is unable to perform the above checks. Furthermore, independent
clients may submit two distinct requests with the same UUIDs. Therefore, if you are developing a server implementation,
take care to verify that a request to create a resource does not contain an ID that already exists in the system.
All such requests must be declined with a status code of 400 and an [ErrorType](/definitions/#ErrorDetail) of
DUPLICATE_RECORD.

Finally, if a client receives an HTTP 400 response with an [ErrorType](/definitions/#ErrorDetail)
of DUPLICATE_RECORD, it is suggested that the client simply generate a new UUID for the request and resubmit the
request with the new UUID.

## Store-and-forward

To ensure that loss of transactional data is minimised, the Electrum QR Payment Service Interface requires clients to
store advice messages in persistent storage and keep them queued until a final status type is received.
A final response is one of either the _successful_ or _failed_ status types. If the
service is not responding, or responding with an _unknown_ status type, advice messages shall be queued
and the message at the head of the queue repeated regularly until a final status type is received.
For high throughput systems, it is acceptable to send several messages in parallel.
Client and server systems in high throughput environments should therefore be prepared to process advice and
advice response messages in any order.

The above applies to the following operations:

* Confirmation
* Reversal
