# ADR-030: Container images: host/CI-built jars, layered runtime images, non-root

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §10 Phase 9

## Context

Building inside Docker would exceed the 8 GB Mac's Docker memory.

## Decision

Maven builds on the host or in CI. The Dockerfile copies the jar, extracts layers (`jarmode=tools`) and runs on `eclipse-temurin:21-jre` as a non-root user, with pinned tags.

## Alternatives considered

- **Multi-stage Maven-in-Docker:** memory-heavy locally.
- **Buildpacks / Jib:** hide the image anatomy.

## Consequences

`make images` requires a prior `./mvnw package`.
