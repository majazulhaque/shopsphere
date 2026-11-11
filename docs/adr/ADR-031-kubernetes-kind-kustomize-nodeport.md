# ADR-031: Kubernetes: kind + Kustomize + NodePort; no Ingress NGINX; Eureka retained

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** D14
- **Blueprint:** v1.1.1 §17.9

## Context

Ingress NGINX was retired in March 2026.

## Decision

kind with `extraPortMappings` to NodePort services; Kustomize overlays `local-slim` and `ci-full`; liveness probes check the JVM only.

## Alternatives considered

- **A Gateway API controller:** an extra component (V2).
- **Helm:** templating overhead.

## Consequences

Eureka duplicates Kubernetes Services (documented; Spring Cloud Kubernetes is a V2 option).
