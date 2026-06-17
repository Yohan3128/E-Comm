# GitHub Release Notes

## E-Comm v3.0

Release date: 2026-06-17

### Overview

This release extends the E-Comm Jakarta EE application with remote project integration for session beans. It demonstrates how remote clients and the web module can look up and invoke session beans across module boundaries using Jakarta EJB remote interfaces and JNDI.

### Highlights

- Added remote access guidance for `TestSessionBean` and `UserSessionBean`.
- Demonstrated servlet-based remote invocation in `ecomm-web` using `TestRemote` and JNDI lookup.
- Included remote client usage examples in `ecomm-client-app` and `ecomm-client-app-demo`.
- Documented the `user-module` remote contracts (`TestRemote`, `UserRemote`) for use by remote projects.
- Showed how the web servlet caches the looked-up stateful bean in `HttpSession` for conversational reuse.

### Technical Notes

- `TestSessionBean` is a `@Stateful` EJB accessible via `TestRemote`.
- `UserSessionBean` is a `@Stateless` EJB accessible via `UserRemote`.
- Remote lookup examples use `java:global/user-module-1.0/TestSessionBean` in `ecomm-web/src/main/java/com/hnys/bcd/web/servlet/Test.java`.
- Client-side examples are present in `ecomm-client-app` and `ecomm-client-app-demo`, showing the IIOP-based remote lookup pattern.

### Verification

- Deploy `user-module` and `ecomm-web`, then request `/test` to confirm remote stateful bean invocation.
- Build and run the example client apps to verify remote project access patterns when the lookup code is enabled.

### Summary

E-Comm v3.0 documents and demonstrates how to use session beans in remote projects, bridging the `user-module` EJB layer with remote web and Java client consumers.

## E-Comm v1.0

Release date: 2026-06-11

### Overview

This release establishes the first version of the E-Comm Jakarta EE application as a two-module Maven project:

- `user-module`: an EJB module that contains the remote business components
- `ecomm-web`: a WAR module that looks up and invokes the EJBs from a servlet

The current codebase demonstrates servlet-to-EJB integration, remote contracts, and DTO-based data exchange in a Java 17 and Jakarta EE 10 setup.

### Highlights

- Added `TestSessionBean` as a `@Stateful` Session Bean.
- Added lifecycle callbacks with `@PostConstruct`, `@PreDestroy`, `@PostActivate`, and `@PrePassivate` to show bean lifecycle behavior.
- Added a serializable `UserDTO` for transferring user data between tiers.
- Added a `/test` servlet that performs a JNDI lookup and invokes `TestRemote.test()`.
- Configured both modules for Java 17 and Jakarta EE 10 APIs.

### Technical Notes

- `user-module` is packaged as `ejb` and configured to generate an EJB client artifact.
- `ecomm-web` is packaged as `war` and depends on the generated EJB client.
- The servlet currently looks up `java:global/user-module-1.0/TestSessionBean` directly.
- `TestSessionBean.test()` increments an instance counter and pauses briefly so invocation flow is visible during testing.

### Current Behavior

- `UserSessionBean` returns placeholder `UserDTO` instances and an empty user list.
- `TestSessionBean` preserves conversational state per client and returns a counter-based response string.
- The `/test` endpoint writes a simple web response and then includes the remote bean result.

### Build Stack

- Java 17
- Maven
- Jakarta EE 10
- Jakarta EJB API 4.0.1
- Jakarta Servlet API via the Jakarta EE web platform dependency

### Verification

Build both Maven modules and deploy them to a Jakarta EE-compatible application server. After deployment, requesting `/test` should confirm that the remote EJB is reachable and that the stateful bean responds with an incrementing result.

### Summary

E-Comm v1.0 provides the base Jakarta EE architecture for remote EJB access from a web layer, with one stateless business bean, one stateful test bean, a shared DTO, and a servlet entry point.