# Project
> Kotlin with Quarkus and Hexagon architecture

# Technologies

- Gradle
- Kotlin (Java 11)
- Quarkus
- PostgreSQL
- Flyway

# Sources to study

- https://jmgarridopaz.github.io/content/hexagonalarchitecture.html
- https://herbertograca.com/2017/09/14/ports-adapters-architecture
- https://herbertograca.com/2017/09/07/domain-driven-design

# Explanation

Here is an image of the Hexagon architectural pattern.

![Hexagon architectural pattern](resources/hexagon.png)

* The module `project-application` is the *driver* that uses the ports to `project-core`
  > Here is the framework, CDI, Rest controllers

- The module `project-core` is the *domain* that publish ports to `project-application` to use 
and uses `project-infrastructure`
  > Here is just the language (Kotlin for example)

- The module `project-infrastructure` is the *driven* that implements the ports from `project-core`
  > Here is all technologies to help like PostgreSQL