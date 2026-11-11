# ADR-008: CQRS in order-service and catalog-service

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §3.9, §3.10

## Context

Customers need read-your-writes on their orders; product search needs facets and relevance.

## Decision

**order-service:** a pure projector updates the views in the same transaction as the event append; the views can be rebuilt from the event store into shadow tables and swapped atomically. **catalog-service:** PostgreSQL is the write model; Elasticsearch is the read model, fed by outbox events and re-indexed through an alias. CQRS is not applied to inventory, payment, shipping or review.

## Alternatives considered

- **Asynchronous order projections:** stale reads for the customer.
- **A separate search service:** not in the brief.

## Consequences

Two operations to build and test: the shadow-table rebuild and the alias re-index.
