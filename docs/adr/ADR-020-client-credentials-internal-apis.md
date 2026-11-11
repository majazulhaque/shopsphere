# ADR-020: OAuth2 client credentials for internal APIs (+ HTTP Interface clients)

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** D10
- **Blueprint:** v1.1.1 §6.2, §3.3

## Context

Authorization must express "order-service may read prices", not "a user is logged in".

## Decision

order-service uses a confidential client with authority `catalog.pricing.read`. Calls use `@HttpExchange` clients with `lb://` and Resilience4j.

## Alternatives considered

- **Relaying the user's token:** wrong authorization semantics.
- **OpenFeign:** in maintenance mode.

## Consequences

One extra Keycloak client; service tokens are cached until expiry.
