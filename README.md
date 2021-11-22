# Sybase Virtual Schema

[![Build Status](https://github.com/exasol/sybase-virtual-schema/actions/workflows/ci-build.yml/badge.svg)](https://github.com/exasol/sybase-virtual-schema/actions/workflows/ci-build.yml)

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
* [Dependencies](dependencies.md)

Find all the documentation in the [Virtual Schemas project][vs-doc].

## Information for Developers 

* [Virtual Schema API Documentation][vs-api]


[virtual-schemas-user-guide]: https://docs.exasol.com/database_concepts/virtual_schemas.htm
[sybase-user-guide]: doc/user_guide/sybase_user_guide.md
[virtual-schemas]: https://github.com/exasol/virtual-schemas
[vs-api]: https://github.com/exasol/virtual-schema-common-java/blob/master/doc/development/api/virtual_schema_api.md
[vs-doc]: https://github.com/exasol/virtual-schemas/tree/master/doc
