# Phase 0 — Environment & Repository Bootstrap (Day 1)

Source of truth: Blueprint v1.1.1, §10 (Phase 0), §14 (task gates), §17 (8 GB Mac), §22–23 (CI, security).
Execution mode: **Option B**. Commands run by the developer on the MacBook; outputs verified by the assistant before a task is closed.

## Pinned versions (Phase 0)

| Component | Version | Verified by |
|---|---|---|
| Spring Boot | 4.1.2 | latest 4.1.x final on Maven Central at Phase 0 start; `./mvnw validate` |
| Spring Cloud | 2025.1.4 | latest 2025.1.x final; BOM resolved (config-server 5.0.6, eureka-server 5.0.3, gateway-server-webflux 5.0.4) |
| Maven / Maven Wrapper | 3.9.16 / 3.3.4 (only-script) | Maven zip: Apache SHA-512 → `distributionSha256Sum`; wrapper zip: Maven Central SHA-1 |
| JDK | Temurin 21.0.13 | `./mvnw -v`, Enforcer `[21,22)` |
| Node | 24.22.2 (`.nvmrc` = 24) | `node -v` |

## Task log

| Task | Description | Status | Evidence | Commit |
|---|---|---|---|---|
| 0.1 | Verify prerequisites (§21.5) | ✅ done (disk deviation, see D-P0-1) | macOS 26.6.2, Apple M2, 8 GB, admin user, GitHub 2FA confirmed, user `majazulhaque` | — |
| 0.2 | Verify MacBook environment & disk | ✅ done with deviations | 34 GiB free (< 40 GB); swap 12.4 GB used, developer to resolve before memory baseline | — |
| 0.3 | Install toolchain | ✅ done | Temurin 21.0.13 · Node 24.22.2 · gh 2.103.3 · gitleaks 8.30.1 · kind 0.33.0 · kubectl 1.37.2 · Stripe CLI 1.55.10 · Docker engine 28.1.1 · VS Code · IntelliJ CE · Bruno | — |
| 0.4 | Create public GitHub repository | ✅ done | `majazulhaque/shopsphere` PUBLIC, `main`, no-reply author; gitleaks: 2 commits scanned, no leaks | `bb6d7d5`, `a96c1bb` |
| 0.5 | Monorepo directory structure (§12) | ✅ done | 38 directories, structure SHA-256 verified; progress log started | `0b0100d` |
| 0.6 | Maven parent POM (Boot 4.1, Spring Cloud BOM, Enforcer) | ✅ done (see D-P0-6) | Enforcer: Java, Maven, duplicate versions, banned app-to-app dependencies, all passed | `3cf51ec` |
| 0.7 | Java 21, Maven Wrapper, Node 24 pinning | ✅ done | `./mvnw -v` → Maven 3.9.16 on Temurin 21.0.13; `validate` BUILD SUCCESS; `mvnw` mode 100755 | `b581c04` |
| 0.8 | Config Server skeleton | ✅ done | `./mvnw verify` green (ConfigServerIT: health UP, native backend serves config-repo); `spring-boot:run` → `/actuator/health` UP | this task's commit |
| 0.9 | Docker Desktop resource limits (§17.2) | ⏳ | | |
| 0.10 | Git hooks + gitleaks | ⏳ | | |
| 0.11 | Seed ADRs (ADR-001…038) | ⏳ | | |
| 0.12 | CI pipeline with disk guard (§22) | ⏳ | | |
| 0.13 | Public-repo security baseline (§23) | ⏳ | | |
| 0.14 | README + runbooks | ⏳ | | |
| 0.15 | Phase 0 verification commands | ⏳ | | |
| 0.16 | First CI run green | ⏳ | | |
| 0.17 | Memory baseline recorded | ⏳ | | |

## Deviations

| ID | Deviation | Impact | Resolution / gate |
|---|---|---|---|
| D-P0-1 | Free disk 31–34 GB, below the 40 GB minimum (§21.5) | Enough for Phase 0; not enough for Phase 1 infrastructure images | **Hard gate:** ≥ 40 GB free before Phase 1, Day 2 |
| D-P0-2 | Swap heavily used at first check (12.4 GB) | Would distort the memory baseline | Developer resolving; re-checked in Task 0.17 |
| D-P0-3 | kubectl client 1.37 vs approved cluster 1.35 (outside ±1 skew) | None until Phase 9 | Phase 9 uses a project-local kubectl 1.35 binary; approved K8s version unchanged |
| D-P0-4 | Docker Desktop memory ≈ 4.1 GB; Homebrew `docker` CLI 27.3.1 shadows Docker Desktop's CLI | Exceeds §17.2 budget | Fixed in Task 0.9 |
| D-P0-5 | First commit captured heredoc wrapper lines inside the three hygiene files | `.gitattributes` invalid; gitleaks scan did not run | Fixed in `a96c1bb` (SHA-256 verified); scan re-run: 2 commits, no leaks |
| D-P0-6 | Parent POM (`3cf51ec`) was committed and pushed before Maven validated it (wrapper download had failed in a zsh paste) | Brief window where an unvalidated POM was on `main` | Validated after commit: `./mvnw validate` BUILD SUCCESS, all Enforcer rules passed; no fix needed. Process fix: no comment lines in paste blocks; `setopt interactivecomments` enabled |
| D-P0-7 | Maven Wrapper zip verified with SHA-1 only (Maven Central publishes no SHA-512 for it) | Low: the wrapper scripts are small, reviewed and committed; Maven itself is verified with SHA-256 on every run | Accepted |
