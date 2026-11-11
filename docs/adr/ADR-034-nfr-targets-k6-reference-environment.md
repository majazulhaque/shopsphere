# ADR-034: NFR targets measured with k6 in the reference environment

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** D12
- **Blueprint:** v1.1.1 §16

## Context

Laptop performance numbers aren't representative.

## Decision

The §16 targets are measured with k6 in the GitHub Actions reference environment (public repository, 4 vCPU / 16 GB).

## Alternatives considered

- **Measuring on the laptop:** not representative (§17.10 L2).

## Consequences

An NFR report is produced in Phase 8.
