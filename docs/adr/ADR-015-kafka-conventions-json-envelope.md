# ADR-015: Kafka conventions + JSON envelope

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §7

## Context

Seven services exchange events and commands; contracts must be consistent and evolvable.

## Decision

Topics are named `<domain>.<aggregate|commands>.<kind>.v<N>`. Saga messages are keyed by `orderId`. 3 partitions per topic; `auto.create.topics.enable=false`. A JSON envelope carries event, correlation and causation IDs. Evolution is additive within a version.

## Alternatives considered

- **Avro + Schema Registry:** an extra server and code generation.

## Consequences

Compatibility is enforced by golden-file contract tests and discipline, not by the broker.
