# Fullbright Plus

### Why is this mod better than other Fullbrights?

Other Fullbright mods will modify the `gamma` value, to make it very high.
This often can just be overrided by users, or can be manually done. These mods do not offer anything special.

Fullbright Plus comes and disable lightning in every part possible, to optimise the CPU and RAM usage.
Why doing light calculations every frame on everything visible on screen, for it to be the maximum value possible
anyway?

### What does the mod do and don't?

All actions performed by the mod are **visual only**. It will not modify any other value than the ones used in the
render classes. Some brightness methods are used for living conditions, and **those weren't modified**.

- ✅ Disable Block Lightning
- ✅ Disable Entity Lightning
- ✅ Disable Ambient Occlusion
- ✅ Disable Vignette
- ❌ Disable Entity Shadows
- ❌ Disable Optifine's Dynamic Lights *(modifies the vanilla game behavior, I won't revert these changes)*

### How does the mod work?

You can look at every modification made to the
game [in the mixin folder](https://github.com/Ghosty920/Fullbright-Plus/tree/main/src/main/java/im/ghosty/fullbrightplus/mixin),
all documented.

### What is the compatibility with other mods?

- ✅ Optifine
- ✅ (Poly)Patcher

If any are missing, or any issue is happening with a single mod,
please [open an issue](https://github.com/Ghosty920/Fullbright-Plus/issues/new).