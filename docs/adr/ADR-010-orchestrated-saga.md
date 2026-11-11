# ADR-010: Orchestrated saga for checkout and cancellation; choreography for side effects

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §3.5–3.7, §4.1

## Context

Checkout and cancellation need strict ordering and compensations, which need a single owner.

## Decision

order-service orchestrates the checkout and cancellation sagas through command and reply topics; participants (inventory, payment, shipping) only handle commands. Peripheral reactions (reviews, recommendations, search) use choreography.

## Alternatives considered

- **Two-phase commit:** blocking and unsupported across these resources.
- **Pure choreography:** flow logic scattered across services.

## Consequences

order-service is the coordination hub; its saga state is persisted in `checkout_saga`.
