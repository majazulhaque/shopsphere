# ADR-023: BFF-lite token relay in Next.js

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** D9
- **Blueprint:** v1.1.1 §6.10

## Context

Client components need authenticated calls without holding tokens.

## Decision

A same-origin `/api/bff/**` route forwards an allow-list of `/api/v1/**` paths and attaches the bearer token. Mutating calls require a matching Origin and the `X-ShopSphere-CSRF` header. It contains no business logic.

## Alternatives considered

- **Tokens in the browser:** exposed to XSS.
- **A full BFF with logic:** duplicates the backend.

## Consequences

One extra hop; the gateway's CORS configuration is almost unused.
