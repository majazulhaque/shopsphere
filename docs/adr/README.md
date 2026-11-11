# Architecture Decision Records

Seeded in Phase 0 (Task 0.11) from Blueprint v1.1.1, Appendix A. Format and rules: [ADR-001](ADR-001-record-architecture-decisions.md).

An accepted ADR is never edited to change its decision. A new ADR supersedes it, and the old one's status is updated to "Superseded by ADR-NNN".

| ADR | Title | Status |
|---|---|---|
| [ADR-001](ADR-001-record-architecture-decisions.md) | Record architecture decisions | Accepted |
| [ADR-002](ADR-002-monorepo-with-module-boundaries.md) | Monorepo with module boundaries | Accepted |
| [ADR-003](ADR-003-java-21-lts.md) | Java 21 LTS | Accepted |
| [ADR-004](ADR-004-spring-boot-4-1-spring-cloud-2025-1-gateway-5.md) | Spring Boot 4.1.x + Spring Cloud 2025.1.x + Gateway 5 | Accepted |
| [ADR-005](ADR-005-maven-multi-module.md) | Maven multi-module build | Accepted |
| [ADR-006](ADR-006-database-per-service-shared-postgresql-server.md) | Database per service on a shared PostgreSQL 18 server | Accepted |
| [ADR-007](ADR-007-event-sourcing-order-aggregate.md) | Event Sourcing for the Order aggregate only, with a custom PostgreSQL event store | Accepted |
| [ADR-008](ADR-008-cqrs-order-and-catalog.md) | CQRS in order-service and catalog-service | Accepted |
| [ADR-009](ADR-009-transactional-outbox-idempotent-inbox.md) | Transactional outbox + idempotent inbox (`common-messaging`) | Accepted |
| [ADR-010](ADR-010-orchestrated-saga.md) | Orchestrated saga for checkout and cancellation; choreography for side effects | Accepted |
| [ADR-011](ADR-011-payment-first-compensation.md) | Payment-first compensation; reservation TTL longer than payment timeout | Accepted |
| [ADR-012](ADR-012-inventory-allocation-state-machine-ledger.md) | Inventory allocation state machine + append-only stock ledger | Accepted |
| [ADR-013](ADR-013-cancelling-and-requires-attention-states.md) | `CANCELLING` and `REQUIRES_ATTENTION` order states + operational recovery endpoints | Accepted |
| [ADR-014](ADR-014-checkout-idempotency-in-postgresql.md) | Checkout idempotency in PostgreSQL; open-checkout guard; price-change 409 | Accepted |
| [ADR-015](ADR-015-kafka-conventions-json-envelope.md) | Kafka conventions + JSON envelope | Accepted |
| [ADR-016](ADR-016-kafka-error-handling.md) | Kafka error handling: classification, blocking retry, DLT + re-drive | Accepted |
| [ADR-017](ADR-017-uri-versioning-problem-details.md) | URI versioning + RFC 9457 Problem Details, no success envelope | Accepted |
| [ADR-018](ADR-018-keycloak-identity-provider.md) | Keycloak 26.8 as the identity provider | Accepted |
| [ADR-019](ADR-019-jwt-validation-issuer-audience-roles.md) | JWT validation: issuer, audience, roles; token lifetimes | Accepted |
| [ADR-020](ADR-020-client-credentials-internal-apis.md) | OAuth2 client credentials for internal APIs (+ HTTP Interface clients) | Accepted |
| [ADR-021](ADR-021-nextjs-16-react-19-node-24.md) | Next.js 16 + React 19.2 + Node 24 (replacing Next.js 14) | Accepted |
| [ADR-022](ADR-022-openid-client-server-session.md) | openid-client + encrypted server-side session | Accepted |
| [ADR-023](ADR-023-bff-lite-token-relay.md) | BFF-lite token relay in Next.js | Accepted |
| [ADR-024](ADR-024-frontend-libraries.md) | Frontend libraries: Tailwind 4, TanStack Query 5, Motion, Stripe Payment Element | Accepted |
| [ADR-025](ADR-025-redis-usage-boundaries.md) | Redis usage boundaries | Accepted |
| [ADR-026](ADR-026-elasticsearch-catalog-search.md) | Elasticsearch 9.4 for catalog search | Accepted |
| [ADR-027](ADR-027-stripe-integration-policy.md) | Stripe integration policy | Accepted — **access BLOCKED (D5)** |
| [ADR-028](ADR-028-resilience4j-placement.md) | Resilience4j placement | Accepted |
| [ADR-029](ADR-029-tracing-brave-zipkin.md) | Tracing with Brave + Zipkin, propagated through the outbox | Accepted |
| [ADR-030](ADR-030-container-images.md) | Container images: host/CI-built jars, layered runtime images, non-root | Accepted |
| [ADR-031](ADR-031-kubernetes-kind-kustomize-nodeport.md) | Kubernetes: kind + Kustomize + NodePort; no Ingress NGINX; Eureka retained | Accepted |
| [ADR-032](ADR-032-testing-strategy-ci-only-gates.md) | Testing strategy & CI-only gates | Accepted |
| [ADR-033](ADR-033-8gb-development-strategy.md) | 8 GB development strategy | Accepted |
| [ADR-034](ADR-034-nfr-targets-k6-reference-environment.md) | NFR targets measured with k6 in the reference environment | Accepted |
| [ADR-035](ADR-035-async-by-default.md) | Inter-service communication: asynchronous by default | Accepted |
| [ADR-036](ADR-036-ci-pipeline-topology-storage-budget.md) | CI pipeline topology & storage budget | Accepted (v1.1.1) |
| [ADR-037](ADR-037-ci-image-distribution-ghcr.md) | CI image distribution via GHCR public packages | Accepted (v1.1.1) |
| [ADR-038](ADR-038-public-repository-security-baseline.md) | Public repository security baseline | Accepted (v1.1.1) |

## Template

```markdown
# ADR-NNN: Title

- **Status:** Proposed | Accepted | Superseded by ADR-NNN
- **Date:** YYYY-MM-DD
- **Decision register:** Dn or —
- **Blueprint:** v1.1.1 §x

## Context

## Decision

## Alternatives considered

## Consequences
```
