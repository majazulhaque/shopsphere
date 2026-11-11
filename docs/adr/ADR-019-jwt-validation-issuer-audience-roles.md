# ADR-019: JWT validation: issuer, audience, roles; token lifetimes

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §9, §3.13

## Context

Tokens must not be accepted across clients, and the issuer differs between the host and Docker networks.

## Decision

A stable `KC_HOSTNAME`, JWKS fetched from the internal host with an explicit issuer check, audience `shopsphere-api`, and realm-role mapping in `common-security`. Access tokens last 5 minutes; refresh tokens rotate.

## Alternatives considered

- **`issuer-uri` only:** fails inside Docker.
- **No audience check:** over-broad acceptance.

## Consequences

Issuer configuration is per environment.
