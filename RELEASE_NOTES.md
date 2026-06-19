E-Comm v1.0
GitHub Release Notes
E-Comm v1.0
Release date: 2026-06-10

Overview
This release introduces the first E-Comm EJB-based application structure, with the main focus on Stateless Session Beans and remote access from a web module. The project is organized as a two-module Maven application:

user-module: an EJB module that contains the business components
ecomm-web: a web module that invokes the EJBs through JNDI lookup
The current implementation is a foundation for enterprise Java development and demonstrates how a web layer can interact with application-scoped stateless services.

Highlights
Added UserSessionBean as a @Stateless EJB implementing the UserRemote contract.
Added TestSessionBean as a @Stateless EJB implementing the TestRemote contract.
Included lifecycle annotations with @PostConstruct and @PreDestroy in the test bean to demonstrate bean initialization and cleanup.
Added a UserDTO transfer object for user data exchange between tiers.
Added a Test servlet in the web module to verify remote EJB lookup and invocation.
Configured the project for Java 17 and Jakarta EE 10 APIs.
Technical Notes
The EJB module is packaged as ejb and generates a client artifact for remote use.
The web module is packaged as war and depends on the EJB client artifact.
The servlet performs a JNDI lookup against the deployed EJB and invokes TestRemote.test().
TestSessionBean.test() currently includes a short delay to make bean invocation behavior visible during testing.
Current Behavior
UserSessionBean exposes the remote user service contract and currently returns placeholder data.
TestSessionBean is used to confirm stateless bean lifecycle and invocation flow.
The web endpoint at /test writes a simple response and then calls the remote EJB.
Build Stack
Java 17
Maven
Jakarta EE 10
Jakarta EJB API 4.0.1
Jakarta Servlet API via the Jakarta EE web platform dependency
Verification
This release can be validated by building both Maven modules and deploying them into a Jakarta EE-compatible application server. After deployment, the /test servlet should confirm that the remote stateless bean is reachable.

Summary
E-Comm v1.0 establishes the base architecture for a Jakarta EE application centered on stateless session beans, remote interfaces, DTO-based data transfer, and servlet-to-EJB integration.

Full Changelog: https://github.com/Yohan3128/E-Comm/commits/v1.0.0

E-Comm v2.0
GitHub Release Notes
E-Comm v2.0
Release date: 2026-06-11

Stateful Session Bean
Added TestSessionBean as a @Stateful Session Bean.
Added lifecycle callbacks: @PostConstruct, @PreDestroy, @PostActivate, and @PrePassivate to demonstrate bean lifecycle behavior.
TestSessionBean.test() increments an instance counter per client, preserving conversational state across calls.
The /test servlet performs a JNDI lookup to java:global/user-module-1.0/TestSessionBean and invokes TestRemote.test(), returning an incrementing response string.


E-Comm v2.1.0
GitHub Release Notes
E-Comm v2.1.0
Release date: 2026-06-17

Overview
This release extends the E-Comm Jakarta EE application with remote project integration for session beans. It demonstrates how remote clients and the web module can look up and invoke session beans across module boundaries using Jakarta EJB remote interfaces and JNDI.

Highlights
Added remote access guidance for TestSessionBean and UserSessionBean.
Demonstrated servlet-based remote invocation in ecomm-web using TestRemote and JNDI lookup.
Included remote client usage examples in ecomm-client-app and ecomm-client-app-demo.
Documented the user-module remote contracts (TestRemote, UserRemote) for use by remote projects.
Showed how the web servlet caches the looked-up stateful bean in HttpSession for conversational reuse.
Technical Notes
TestSessionBean is a @Stateful EJB accessible via TestRemote.
UserSessionBean is a @Stateless EJB accessible via UserRemote.
Remote lookup examples use java:global/user-module-1.0/TestSessionBean in ecomm-web/src/main/java/com/hnys/bcd/web/servlet/Test.java.
Client-side examples are present in ecomm-client-app and ecomm-client-app-demo, showing the IIOP-based remote lookup pattern.
Verification
Deploy user-module and ecomm-web, then request /test to confirm remote stateful bean invocation.
Build and run the example client apps to verify remote project access patterns when the lookup code is enabled.
Summary
E-Comm v2.1.0 documents and demonstrates how to use session beans in remote projects, bridging the user-module EJB layer with remote web and Java client consumers.

E-Comm v3.0 Latest
GitHub Release Notes
E-Comm v3.0
Release date: 2026-06-18

Update
This release documents singleton-style session bean access patterns and the use of a single remote interface across multiple session beans.

Key Changes
Added TestNewSessionBean alongside TestSessionBean, both implementing TestRemote.
Updated TestRemote to expose remove() for stateful bean lifecycle control.
Changed TestSessionBean to use mappedName and include an explicit @Remove method.
Updated the ecomm-web servlet to inject the remote bean with @EJB(lookup=...) and simplify remote access.
Identified shared remote interface usage with one remote contract across two beans.