<img src="https://meshmc.net/assets/logo.png" alt="MeshMC logo" height="80" align="left"/>

# Mesh

###
Mesh is a cross-version minecraft mod development platform for Forge and Fabric.

## Supported Versions
Mesh will eventually be able to run on most forge and fabric versions, but development is currently on the API, forge 1.12.2, and fabric 1.18.1.

## How it works
Mesh works as an API over minecraft's version specific code. It runs as a forge and fabric mod, translating Mesh API calls into version specific code.
This means that Mesh mods only have to compile for once for all versions of minecraft. The Mesh API is provided as a mod for each platform it supports.

## Building
- Install and configure JDK 17
- Clone this repo
- Build with gradle: run `./gradlew build` for building on Linux or `gradlew build` for Windows
- The Mesh API will be built for each supported version and copied to the `build` folder
- The Mesh Loader, which works as a mod on all supported versions is also built to this folder. You can choose to use this, or the standalone version explained above to run Mesh mods.
- The Example Mod will also be built into this folder

## Running a Mesh mod
To run a Mesh mod, place the Mesh Loader or the Mesh API for the minecraft version you are using in your mods folder.
Then place the Mesh mods you want to run in the mods folder too. When you run supported mod loaders and versions, the
Mesh mod will be loaded at start!

## Contributing
Contributions will be vital for this project because it deals with many versions of Minecraft.
Please read [contributing.md](CONTRIBUTING.md) if you plan on contributing.
