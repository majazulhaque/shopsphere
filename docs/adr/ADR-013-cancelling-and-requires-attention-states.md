# ADR-013: `CANCELLING` and `REQUIRES_ATTENTION` order states + operational recovery endpoints

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** D3
- **Blueprint:** v1.1.1 §4.1, §6.4

## Context

An order must not claim to be cancelled while money hasn't been returned.

## Decision

`CANCELLING` is an explicit compensating state. `REQUIRES_ATTENTION` is terminal for automation. A deadline scanner moves stuck orders there; admins can list them and retry pending compensations.

## Alternatives considered

- **Immediate `CANCELLED`:** inconsistent with the money and stock state.

## Consequences

An operational API surface to document and secure.
