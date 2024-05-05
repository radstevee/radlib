# radlib
A collection of small utilities and helper functions which I use in my plugins.

Requires Paper and is mainly kotlin DSLs/helper functions for some boilerplate :)

## Usage

build.gradle.kts
```kotlin
repositories {
    maven { url = "https://jitpack.io" }
}

dependencies {
    implementation("com.github.radstevee:radlib:1.0.1")
}
```

```kotlin
class Plugin : JavaPlugin() {
    override fun onEnable() {
        RadLib.initialize(this)
    }
}
```