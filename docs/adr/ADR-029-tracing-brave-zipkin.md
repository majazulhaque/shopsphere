# ADR-029: Tracing with Brave + Zipkin, propagated through the outbox

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §3.12

## Context

Boot 4.1 has a dedicated Brave/Zipkin starter; the OpenTelemetry → Zipkin path is removed in Boot 4.2.

## Decision

Brave + `spring-boot-starter-zipkin`; Kafka observation on for template and listener; `traceparent` stored in outbox rows and restored as headers by the relay.

## Alternatives considered

- **OpenTelemetry + OTLP:** needs a different backend.

## Consequences

One checkout appears as one trace across HTTP and Kafka.
