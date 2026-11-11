# ADR-036: CI pipeline topology & storage budget

- **Status:** Accepted (v1.1.1)
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §22

## Context

Standard runners guarantee only 14 GB of SSD; a single monolithic job would need about 20–24 GB.

## Decision

One `pipeline.yml` whose jobs run on fresh runners (per-module matrix, build-images, system-backend, e2e-frontend, k8s-e2e, report). Each job is budgeted to ≤ 10 GB disk and ≤ 13 GB RAM. Our own pinned free-disk-space script; a disk guard that fails fast; no Docker layer cache in the Actions cache.

## Alternatives considered

- **A monolithic job:** exceeds the disk.
- **Paid larger runners:** not needed.

## Consequences

More jobs and some image transfer time; capacity is measured and recorded per phase in `docs/runbooks/ci-capacity.md`.
