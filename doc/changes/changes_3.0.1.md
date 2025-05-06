# Virtual Schema for Sybase 3.0.1, released 2025-05-06

Code name: Dependency Updates on top of 3.0.0

## Summary

We updated the dependencies on top of version 3.0.0 and added an OSSIndex reporting exception for CVE-2024-55551 which was fixed in the Exasol JDBC driver 24.2.1 but still has no fix version set in the OSSIndex.

Updated Runner OS on GitHub to Ubuntu 24.04, matrix test Exasol versions to 8.34.0 and 7.1.30.

## Features

* #23: Updated dependencies, added reporting exception for CVE-2024-55551

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:virtual-schema-common-jdbc:12.0.0` to `12.0.1`

### Test Dependency Updates

* Updated `com.exasol:virtual-schema-common-jdbc:12.0.0` to `12.0.1`
* Updated `nl.jqno.equalsverifier:equalsverifier:3.15.8` to `3.19.4`
* Updated `org.hamcrest:hamcrest:2.2` to `3.0`
* Added `org.junit.jupiter:junit-jupiter-api:5.12.2`
* Added `org.junit.jupiter:junit-jupiter-params:5.12.2`
* Removed `org.junit.jupiter:junit-jupiter:5.10.2`
* Updated `org.mockito:mockito-junit-jupiter:5.11.0` to `5.17.0`

### Plugin Dependency Updates

* Updated `com.exasol:artifact-reference-checker-maven-plugin:0.4.2` to `0.4.3`
* Updated `com.exasol:error-code-crawler-maven-plugin:2.0.1` to `2.0.3`
* Updated `com.exasol:project-keeper-maven-plugin:4.2.0` to `5.0.1`
* Added `com.exasol:quality-summarizer-maven-plugin:0.2.0`
* Added `io.github.git-commit-id:git-commit-id-maven-plugin:9.0.1`
* Removed `io.github.zlika:reproducible-build-maven-plugin:0.16`
* Added `org.apache.maven.plugins:maven-artifact-plugin:3.6.0`
* Updated `org.apache.maven.plugins:maven-assembly-plugin:3.6.0` to `3.7.1`
* Updated `org.apache.maven.plugins:maven-clean-plugin:3.2.0` to `3.4.1`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.12.1` to `3.14.0`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.4.1` to `3.5.0`
* Updated `org.apache.maven.plugins:maven-install-plugin:3.1.2` to `3.1.4`
* Updated `org.apache.maven.plugins:maven-jar-plugin:3.3.0` to `3.4.2`
* Updated `org.apache.maven.plugins:maven-site-plugin:3.12.1` to `3.21.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.2.5` to `3.5.2`
* Updated `org.apache.maven.plugins:maven-toolchains-plugin:3.1.0` to `3.2.0`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.6.0` to `1.7.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.16.2` to `2.18.0`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.11` to `0.8.12`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:3.10.0.2594` to `5.0.0.4389`
