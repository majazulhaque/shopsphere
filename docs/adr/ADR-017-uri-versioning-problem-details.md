# ADR-017: URI versioning + RFC 9457 Problem Details, no success envelope

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §6, §13.2

## Context

The API must be explicit, routable at the gateway and friendly to generated typed clients.

## Decision

Base path `/api/v1`. Errors use RFC 9457 Problem Details plus `code`, `traceId`, `timestamp` and `errors[]`. Successful responses return the resource with no wrapper.

## Alternatives considered

- **Header or media-type versioning:** harder to route and test.
- **`{success, data}` wrappers:** redundant with HTTP status codes.

## Consequences

`/api/v2` is introduced only for breaking changes.
