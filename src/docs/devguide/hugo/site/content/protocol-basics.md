---
title: "Protocol Basics"
menu:
  main:
    weight: 30
---

The Electrum QR Payment Service Interface is an HTTP RESTFul interface.


## Terminology

The Electrum QR Payment Service Interface documentation utilises several specific terms, which for clarity are defined below.

### Upstream And Downstream Entities

Upstream and downstream impart a convention for the direction for a request and its response. A request message (such as a payment request) typically originates at a retailer location and must be sent to the partner for processing. When a message is sent from a merchant to a partner it is said to be sent upstream. Conversely, when a message is sent from a partner vendor to Electrum it is said to be sent downstream. Thus, 'upstream entity' is a relative term and is any entity located between the entity under discussion and the partner (including the partner itself). Likewise, 'downstream entity' is also a relative term and is any entity located between the entity under discussion and the retailer (including the retailer itself).

### Server vs Client

Servers typically host an application and, in the context of the RESTful Electrum QR Payment Service Interface, a server would host the QR payments service application responsible for servicing requests received from downstream entities and providing a response. A server is the entity that receives requests and returns responses. A client therefore is the entity responsible for sending requests to a server and expects responses from the server.

The various request and response messages defined in the Electrum QR Payment Service Interface are always initiated from the downstream entities and sent to upstream entities for processing. This means that clients are therefore downstream of servers and that servers are upstream of clients. Consider an entity that receives a request from a downstream entity and forwards it to an upstream entity; this entity receives the request in the capacity of a server and passes it on in the capacity of a client.

### Partner

The Partner is the customer's chosen service provider, which should process the transaction from the merchant on the customer's behalf. For example, the provider of a virtual wallet service may provide its customers with an application capable of scanning QR codes. When a customer chooses to pay with the Partner's wallet using a QR code, the customer will use the Partner's mobile application to scan the QR code. The Partner will then contact the merchant to inform the merchant that the payment request from the point-of-sale should be directed to the Partner for processing.

A Partner is not responsible for generating QR codes. Rather, a Partner is responsible for:

- Notifying the merchant which transactions should be forwarded to the Partner for processing.
- Processing transactions linked to a QR code that a Partner's application has scanned.

### QR Code

Within the context of the Electrum QR Payment Service Interface, the term 'QR code' refers to the string of data that is encoded and displayed as a graphical image to a customer.

### Transaction ID/TranID

The transaction ID is a unique value created for the purposes of a single transaction. This unique value is common to the QR code, the scan notification from the partner and the transaction request from the merchant. Its primary purpose is to link the transaction request from the merchant with the QR code scanned by the customer.

## Security

All communication shall be secured by establishing an SSL-encrypted transport. SSL provides a manner for client and server systems to identify themselves to each other as well as to establish an encrypted channel over which they may securely communicate. SSL provides security at a network level and identifies entities who communicate to each other.

Since the Electrum QR Payment Service Interface is a RESTful service, server implementations are typically hosted on Web servers. Using the HTTP Basic Authentication headers over and above SSL allows the sender of a message to be identified at an application level and any appropriate processing to take place on a per-sender basis.

## Failures

The failure outcome of a request shall be determined in the first instance by examining the HTTP status code of the response. The HTTP status types and their associated meanings convey information about the possible reasons for a failure response. Where possible, a failure response will also contain further information about the nature of the failure in an [ErrorDetail](/specification/definitions/#ErrorDetail) object.

### Status type

Three basic types of outcomes are possible for transactions, namely: _successful_, _unknown_, and _failed_.

HTTP status types are mapped to one of the possible outcomes as indicated below.

HTTP Status Codes               | Status type
--------------------------------|---------------------------------------------------------------------------------------------
200, 201, 202, 404*             | successful
500, 504, timeout               | unknown
400, 404*, 501, 503, all others | failed

A timeout occurs when the client has not received a response to a request after an agreed-upon interval. Unless otherwise agreed, this interval shall be 60 seconds. Any response received after the timeout should be logged but ignored.

\*Note that an HTTP status type of 404 could indicate either a success or a failure; this is dependent on the context of the response.
