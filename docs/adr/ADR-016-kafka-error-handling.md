# ADR-016: Kafka error handling: classification, blocking retry, DLT + re-drive

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** D3
- **Blueprint:** v1.1.1 §7.4

## Context

Poison messages and transient failures need different handling, and saga ordering must hold.

## Decision

Non-retryable failures go straight to `<topic>.dlt`. Transient failures get blocking exponential back-off (1 s to 30 s, max 5). No non-blocking retry topics on saga topics. Each service exposes admin DLT listing and re-drive.

## Alternatives considered

- **Uniform 3 retries, then DLT:** stalls sagas silently.

## Consequences

Head-of-line blocking during long outages; acceptable because saga deadlines cover it.
