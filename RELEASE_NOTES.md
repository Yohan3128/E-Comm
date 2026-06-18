# GitHub Release Notes

## E-Comm v3.0

Release date: 2026-06-18

### Update

This release documents singleton-style session bean access patterns and the use of a single remote interface across multiple session beans.

### Key Changes

- Added `TestNewSessionBean` alongside `TestSessionBean`, both implementing `TestRemote`.
- Updated `TestRemote` to expose `remove()` for stateful bean lifecycle control.
- Changed `TestSessionBean` to use `mappedName` and include an explicit `@Remove` method.
- Updated the `ecomm-web` servlet to inject the remote bean with `@EJB(lookup=...)` and simplify remote access.
- Identified shared remote interface usage with one remote contract across two beans.
