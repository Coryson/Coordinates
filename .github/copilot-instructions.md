## Vision for v1.0.0
- Players must be able to store up to **10 named coordinate slots** each (persist across restarts) and retrieve them via commands (e.g., `/coords save [name]`, `/coords).
- Provide tab completion and friendly feedback messages when slots are empty or full.
- Add a **configurable feature** (toggle in `config.yml`) that records the player's **last death location** and allows retrieving it via `/coords`.
- Keep the plugin Kotlin-first, Paper 1.20.x compatible, and ensure new logic is covered by unit tests where feasible.
- Plan to bump the version to **1.0.0** once these features are complete and verified.

