# ADR-038: Public repository security baseline

- **Status:** Accepted (v1.1.1)
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §23

## Context

The repository is public for the résumé and for the free 16 GB runners.

## Decision

The only stored secret is the Stripe test key (Environment `ci-e2e`, branch-restricted); every other credential is generated per run and masked. Workflows use `pull_request` only (no `pull_request_target` or `workflow_run`). Outside contributors need approval to run workflows. Actions are pinned to SHAs. Rulesets require the checks, including the CI-only gates. Secret scanning + push protection, gitleaks (including on artifacts), Dependabot, dependency review, CodeQL and Trivy. All free on public repositories.

## Alternatives considered

- **A private repository:** loses the free 16 GB runners and the free security features (§23.7).

## Consequences

Fork PRs reach the mandatory gates only through a maintainer re-run on a same-repository branch.
