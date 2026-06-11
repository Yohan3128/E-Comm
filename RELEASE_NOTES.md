# GitHub Release Notes

## E-Comm v1.0

Release date: 2026-06-10

### Overview

This release introduces the first E-Comm EJB-based application structure, with the main focus on **Stateless Session Beans** and remote access from a web module. The project is organized as a two-module Maven application:

- `user-module`: an EJB module that contains the business components
- `ecomm-web`: a web module that invokes the EJBs through JNDI lookup

The current implementation is a foundation for enterprise Java development and demonstrates how a web layer can interact with application-scoped stateless services.

### Highlights

- Added `UserSessionBean` as a `@Stateless` EJB implementing the `UserRemote` contract.
- Added `TestSessionBean` as a `@Stateless` EJB implementing the `TestRemote` contract.
- Included lifecycle annotations with `@PostConstruct` and `@PreDestroy` in the test bean to demonstrate bean initialization and cleanup.
- Added a `UserDTO` transfer object for user data exchange between tiers.
- Added a `Test` servlet in the web module to verify remote EJB lookup and invocation.
- Configured the project for Java 17 and Jakarta EE 10 APIs.

### Technical Notes

- The EJB module is packaged as `ejb` and generates a client artifact for remote use.
- The web module is packaged as `war` and depends on the EJB client artifact.
- The servlet performs a JNDI lookup against the deployed EJB and invokes `TestRemote.test()`.
- `TestSessionBean.test()` currently includes a short delay to make bean invocation behavior visible during testing.

### Current Behavior

- `UserSessionBean` exposes the remote user service contract and currently returns placeholder data.
- `TestSessionBean` is used to confirm stateless bean lifecycle and invocation flow.
- The web endpoint at `/test` writes a simple response and then calls the remote EJB.

### Build Stack

- Java 17
- Maven
- Jakarta EE 10
- Jakarta EJB API 4.0.1
- Jakarta Servlet API via the Jakarta EE web platform dependency

### Verification

This release can be validated by building both Maven modules and deploying them into a Jakarta EE-compatible application server. After deployment, the `/test` servlet should confirm that the remote stateless bean is reachable.

### Summary

E-Comm v1.0 establishes the base architecture for a Jakarta EE application centered on stateless session beans, remote interfaces, DTO-based data transfer, and servlet-to-EJB integration.