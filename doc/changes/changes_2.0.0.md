# Sybase Virtual Schemas 2.0.0, released 2021-11-22

Code name: Removed `SQL_DIALECT` property

## Summary

The `SQL_DIALECT` property used when executing a `CREATE VIRTUAL SCHEMA` from the Exasol database is obsolete from this version. Please, do not provide this property anymore.

## Refactoring

* #7: Updated to the `com.exasol:virtual-schema-common-jdbc:9.0.1` (https://github.com/exasol/virtual-schema-common-jdbc/releases/tag/9.0.1)

## Documentation

* #6: Fixed outdated user guide.

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:db-fundamentals-java:0.1.1` to `0.1.2`
* Updated `com.exasol:error-reporting-java:0.2.0` to `0.4.1`
* Updated `com.exasol:virtual-schema-common-jdbc:8.0.0` to `9.0.4`

### Test Dependency Updates

* Updated `com.exasol:virtual-schema-common-jdbc:8.0.0` to `9.0.4`
* Updated `nl.jqno.equalsverifier:equalsverifier:3.5` to `3.7.2`
* Updated `org.junit.jupiter:junit-jupiter:5.7.0` to `5.8.1`
* Updated `org.mockito:mockito-junit-jupiter:3.6.28` to `4.1.0`

### Plugin Dependency Updates

* Added `com.exasol:error-code-crawler-maven-plugin:0.6.0`
* Updated `com.exasol:project-keeper-maven-plugin:0.4.2` to `1.3.2`
* Added `io.github.zlika:reproducible-build-maven-plugin:0.13`
* Updated `org.apache.maven.plugins:maven-jar-plugin:2.4` to `3.2.0`
