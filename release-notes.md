# Service Interface Base Release Notes

<!-- README:
  * Add new entries to the top of this file (under this comment), making sure to specify the correct version number and release date.
  * Make sure you include a concise description of all changes since the previous release. Check the git history to be sure.
  * Group the descriptions under the relevant headings (but don’t include a heading if there are no changes under it):
    - Breaking Changes -> Changes that break backwards compatability. These will correspond to a major version release.
    - New Features -> Changes that would, in the absence of any breaking changes, constitute a minor version release.
    - Fixed -> Bugfixes that would, in the absence of any new features or breaking changes, constitute a patch version release.
    - Deprecated -> Any classes or methods that have been deprecated.
  * Make use of Markdown formatting:
    - Run ‘$curl cheat.sh/markdown’ from your command line to get a quick overview of markdown.
    - Use the convention of enclosing class, variable and method names in backticks so that they render as monospace.
    - Try and avoid special characters as far as possible
-->

## Version 1.5.0 - 07 April 2021
### New Features
* Added a new model object called `QrProperties`.
* Added the following member variables to the `CreateQrCodeRequest` and `CreateQrCodeResponse` model objects:
    * `customer`
    * `qrProperties`
* Removed the following dependencies which are brought in by `service-interface-base`:
    * `joda-time`
    * `swagger-jersey2-jaxrs`
    * `swagger-hibernate-validations`
    * `jersey-server`
    * `jersey-common`
    * `jersey-container-servlet`
    * `jersey-client`
    * `jersey-media-json-jackson`
    * `hibernate-validator`
* Added minimum requirement for `service-interface-base` v3.30.0 and up.
