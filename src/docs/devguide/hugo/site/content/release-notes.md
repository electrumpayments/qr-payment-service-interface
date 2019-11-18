This page describes changes to the QR Payment Service Interface implemented across different releases of the interface.

## v1.1.0
Released 18 November 2019

* All documentation was reviewed and updated for correctness.
* `equals`, `toString` and `hashcode` methods where altered to refer to `super` methods rather than directly re-using inherited fields.
* The maximum length of the `errorMessage` field in the `ErrorDetail` model was increased to 40 characters.

## v1.0.0
Released 9 October 2019

* Initial release
