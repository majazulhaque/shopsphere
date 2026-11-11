# ADR-033: 8 GB development strategy

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §17

## Context

The development machine is a MacBook Air M2 with 8 GB of memory.

## Decision

Compose profiles, standalone mode (file config + SimpleDiscoveryClient), small-heap dev JVMs, `kafka-native` for dev and tests, Docker memory modes, and CI as the reference environment.

## Alternatives considered

- **A cloud development box:** costs money and needs approval.
- **Weakening tests:** rejected.

## Consequences

Discipline is required; +1–3 days of friction risk, reported rather than absorbed.
