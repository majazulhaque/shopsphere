# ADR-018: Keycloak 26.8 as the identity provider

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** D1
- **Blueprint:** v1.1.1 §9

## Context

The brief needs customers and admins but no custom identity service.

## Decision

Keycloak 26.8 with realm `shopsphere`, roles `CUSTOMER` and `ADMIN`.

## Alternatives considered

- **A Spring Authorization Server service:** a custom service outside the brief.
- **SaaS identity providers:** external dependency and accounts.

## Consequences

About 0.5–0.6 GB RAM when running. Only the latest minor is supported, so patch bumps are expected.
