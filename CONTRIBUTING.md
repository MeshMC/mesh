# Contributing to MeshMC
Thanks for considering contributing to MeshMC! In this document you will find useful information and guidelines for your contributions.

## Coding Guidelines and Principles
### How does the API work?
Each interface in the API acts as a wrapper around a specific class or function in minecraft's codebase.
In every mesh implementation, each interface must be implemented and filled with that version's specific 
method calls. Usually that implementation is a mixin, allowing access and modification to private and final
fields and methods. See `mesh-*version*/src/main/net/meshmc/mesh/impl/mixin` for examples.
#### How do statics and constructors work?
All static methods and constructors are held in the MeshStatics class of each implementation, however this is class is not present
in the API. Constructors are exposed to the API through a static method in their wrapper class, usually using the name `create`, which
calls their corresponding method in MeshStatics.
### Package structure
- mesh-core
  - api - contains the interfaces for mesh wrapper classes (implemented in mixin or wrapper folders)
  - event - contains the standard mesh events
  - util - contains utility classes for mesh
- mesh-*version*
  - mixin
    - accessors - contains mixin accessors needed for the implementation
    - events - contains the mixins that provide events for mesh
    - ... - all other sub-folders are mixins that provide an implementation for the corresponding mesh api
  - wrapper - contains implementations for the mesh api that are not mixins and may not correspond to a minecraft class
  - util - contains helper classes for the implementation, usually used in MeshStatics
### Contributing to the API
Some API classes have not been completed or are only present as markers for what is needed to be done.
To complete that API class, please attempt to create an API method for each of the remaining methods and fields. For fields, use a getter and setter
with the standard naming conventions.
### Events
Events are a way for mods to listen for an action and do something when that action happens. Each event is called in
a mixin or from forge's events (ForgeEvents.java) using `Mesh.getMesh().getEventManager().post(new ExampleEvent());`.
Some events have phases or types, so be careful to specify these when posting.

## Issues and Pull Requests
For issues and pull requests, please use the template provided on creation. More information will help us
fix your bug or add your feature sooner.
### What to Include:
- `latest.log` (if applicable)
- Screenshot (if applicable)
- Mesh version (latest?)
- Minecraft version

## Licensing
All MeshMC code is licensed under LGPLv3. This allows use in proprietary applications, while still giving attribution and credit where it is deserved.