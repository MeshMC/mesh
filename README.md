# Mesh
Mesh is a cross-version minecraft mod development platform for Forge and Fabric.

## Supported Versions
Mesh will eventually be able to run on most forge and fabric versions, but development is currently on the API, forge 1.12.2, and fabric 1.18.1.

## How it works
Mesh works as an API over minecraft's version specific code. It runs as a forge and fabric mod, translating Mesh API calls into version specific code. This means that Mesh mods only have to compile for once for all versions of minecraft. The Mesh API is provided as a mod for each platform it supports.

## Building
- Install and configure JDK 17
- Clone this repo
- Build with gradle: run `./gradlew build` for building on Linux or `gradlew build` for Windows
- The Mesh API will be built for each supported version and copied to the `build` folder
- The Example Mod will also be built into this folder

## Example Mod
A minimal example/test is shown in the `example` folder. This works on all platforms currently supported.

### Using the Example Mod
To use the example mod, copy it and the Mesh API jars into `.minecraft/mods` then run Minecraft Forge or Fabric!

## Contributing
Contributions will be vital for this project because it deals with many versions of Minecraft. PRs are greatly appreciated and will be merged if sufficient.
