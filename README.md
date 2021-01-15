# Sybase Virtual Schema

[![Build Status](https://api.travis-ci.com/exasol/sybase-virtual-schema.svg?branch=main)](https://travis-ci.com/exasol/sybase-virtual-schema)

SonarCloud results:

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Asybase-virtual-schema&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.exasol%3Asybase-virtual-schema)

[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Asybase-virtual-schema&metric=security_rating)](https://sonarcloud.io/dashboard?id=com.exasol%3Asybase-virtual-schema)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Asybase-virtual-schema&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=com.exasol%3Asybase-virtual-schema)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Asybase-virtual-schema&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=com.exasol%3Asybase-virtual-schema)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Asybase-virtual-schema&metric=sqale_index)](https://sonarcloud.io/dashboard?id=com.exasol%3Asybase-virtual-schema)

[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Asybase-virtual-schema&metric=code_smells)](https://sonarcloud.io/dashboard?id=com.exasol%3Asybase-virtual-schema)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Asybase-virtual-schema&metric=coverage)](https://sonarcloud.io/dashboard?id=com.exasol%3Asybase-virtual-schema)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Asybase-virtual-schema&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=com.exasol%3Asybase-virtual-schema)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Asybase-virtual-schema&metric=ncloc)](https://sonarcloud.io/dashboard?id=com.exasol%3Asybase-virtual-schema)

# Overview

The **Sybase Virtual Schema** provides an abstraction layer that makes an external [Sybase](https://www.sap.com/products/sybase-ase.html) database accessible from an Exasol database through regular SQL commands. The contents of the external Sybase database are mapped to virtual tables which look like and can be queried as any regular Exasol table.

If you want to set up a Virtual Schema for a different database system, please head over to the [Virtual Schemas Repository][virtual-schemas].

## Features

* Access a Sybase database in read only mode from an Exasol database, using a Virtual Schema.

## Table of Contents

### Information for Users

* [Virtual Schemas User Guide][virtual-schemas-user-guide]
* [Sybase Dialect User Guide][sybase-user-guide]
* [Changelog](doc/changes/changelog.md)

Find all the documentation in the [Virtual Schemas project][vs-doc].

## Information for Developers 

* [Virtual Schema API Documentation][vs-api]

### Run Time Dependencies

Running the Virtual Schema requires a Java Runtime version 11 or later.

| Dependency                                                         | Purpose                                                | License                                            |
|--------------------------------------------------------------------|--------------------------------------------------------|----------------------------------------------------|
| [Exasol Virtual Schema JDBC][virtual-schema-common-jdbc]           | Common JDBC functions for Virtual Schemas adapters     | MIT License                                        |
| [Sybase JDBC Driver]                                               | JDBC driver for Sybase database                        | See [Sybase Dialect User Guide][sybase-user-guide] |
| [Exasol Error Reporting][exasol-error-reporting]                   | Creating unified error messages                        | MIT License                                        |
| [Exasol Database Fundamentals for Java][exasol-db-funtamentals]    | Base objects and ground rules for the Exasol database  | MIT License                                        |

### Test Dependencies

| Dependency                                                         | Purpose                                                | License                       |
|--------------------------------------------------------------------|--------------------------------------------------------|-------------------------------|
| [Java Hamcrest](http://hamcrest.org/JavaHamcrest/)                 | Checking for conditions in code via matchers           | BSD License                   |
| [JUnit](https://junit.org/junit5)                                  | Unit testing framework                                 | Eclipse Public License 1.0    |
| [Mockito](http://site.mockito.org/)                                | Mocking framework                                      | MIT License                   |
| [Exasol Hamcrest Result Set Matcher][exasol-hamcrest]              | Hamcrest result set matcher for testing                | MIT License                   |
| [EqualsVerifier][jqno-equals-verifier]                             | Testing `hashCode` and `equals` Java contract        | Apache-2.0 License            |

### Maven Plug-ins

| Plug-in                                                            | Purpose                                                | License                       |
|--------------------------------------------------------------------|--------------------------------------------------------|-------------------------------|
| [Maven Jacoco Plugin][maven-jacoco-plugin]                         | Code coverage metering                                 | Eclipse Public License 2.0    |
| [Maven Surefire Plugin][maven-surefire-plugin]                     | Unit testing                                           | Apache License 2.0            |
| [Maven Compiler Plugin][maven-compiler-plugin]                     | Setting required Java version                          | Apache License 2.0            |
| [Maven Assembly Plugin][maven-assembly-plugin]                     | Creating JAR                                           | Apache License 2.0            |
| [Versions Maven Plugin][versions-maven-plugin]                     | Checking if dependencies updates are available         | Apache License 2.0            |
| [Maven Enforcer Plugin][maven-enforcer-plugin]                     | Controlling environment constants                      | Apache License 2.0            |
| [Maven Dependency Plugin][maven-dependency-plugin]                 | Accessing to test dependencies                         | Apache License 2.0            |
| [Artifact Reference Checker Plugin][artifact-ref-checker-plugin]   | Check if artifact is referenced with correct version   | MIT License                   |
| [Project Keeper Maven Plugin][project-keeper-maven-plugin]         | Checking project structure                             | MIT License                   |
| [Sonatype OSS Index Maven Plugin][sonatype-oss-index-maven-plugin] | Checking dependencies vulnerability                    | ASL2                          |

[virtual-schema-common-jdbc]: https://github.com/exasol/virtual-schema-common-jdbc
[exasol-error-reporting]: https://github.com/exasol/error-reporting-java/
[exasol-db-funtamentals]: https://github.com/exasol/db-fundamentals-java/

[exasol-hamcrest]: https://github.com/exasol/hamcrest-resultset-matcher
[jqno-equals-verifier]: https://github.com/jqno/equalsverifier

[maven-jacoco-plugin]: https://www.eclemma.org/jacoco/trunk/doc/maven.html
[maven-surefire-plugin]: https://maven.apache.org/surefire/maven-surefire-plugin/
[maven-compiler-plugin]: https://maven.apache.org/plugins/maven-compiler-plugin/
[maven-assembly-plugin]: https://maven.apache.org/plugins/maven-assembly-plugin/
[versions-maven-plugin]: https://www.mojohaus.org/versions-maven-plugin/
[maven-enforcer-plugin]: http://maven.apache.org/enforcer/maven-enforcer-plugin/
[artifact-ref-checker-plugin]: https://github.com/exasol/artifact-reference-checker-maven-plugin
[maven-dependency-plugin]: https://maven.apache.org/plugins/maven-dependency-plugin/
[project-keeper-maven-plugin]: https://github.com/exasol/project-keeper-maven-plugin
[sonatype-oss-index-maven-plugin]: https://sonatype.github.io/ossindex-maven/maven-plugin/

[virtual-schemas-user-guide]: https://docs.exasol.com/database_concepts/virtual_schemas.htm
[sybase-user-guide]: doc/user_guide/sybase_user_guide.md
[virtual-schemas]: https://github.com/exasol/virtual-schemas
[vs-api]: https://github.com/exasol/virtual-schema-common-java/blob/master/doc/development/api/virtual_schema_api.md
[vs-doc]: https://github.com/exasol/virtual-schemas/tree/master/doc
