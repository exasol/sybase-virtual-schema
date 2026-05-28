# Sybase SQL Dialect User Guide

[SAP ASE](https://www.sap.com/products/sybase-ase.html), originally known as Sybase SQL Server is a relational model database server developed by Sybase Corporation, which later became part of SAP AG.

**Please note that this Virtual Schema works only for the Sybase ASE database and not Sybase IQ.**

## Telemetry

This virtual schema uses `telemetry-java` to send anonymous feature-usage events.

For details on what is collected and how to disable telemetry, see the [documentation](https://github.com/exasol/telemetry-java/blob/main/doc/app-user-guide.md).

## Uploading the JDBC Driver to Exasol BucketFS

1. Download the [Sybase JDBC driver](https://sourceforge.net/projects/jtds/).
2. Upload the driver to BucketFS, see [BucketFS documentation](https://docs.exasol.com/db/latest/administration/on-premise/bucketfs/accessfiles.htm).

    Hint: Put the driver into folder `default/drivers/jdbc/` to register it for [ExaLoader](#registering-the-jdbc-driver-for-exaloader), too.

## Registering the JDBC driver for ExaLoader

In order to enable the ExaLoader to fetch data from the external database you must register the driver for ExaLoader as described in the [Installation procedure for JDBC drivers](https://github.com/exasol/docker-db/#installing-custom-jdbc-drivers).
1. ExaLoader expects the driver in BucketFS folder `default/drivers/jdbc`.

   If you uploaded the driver for UDF to a different folder, then you need to [upload](#uploading-the-jdbc-driver-to-exasol-bucketfs) the driver again.
2. Additionally  you need to create file `settings.cfg` and [upload](#uploading-the-jdbc-driver-to-exasol-bucketfs) it to the same folder in BucketFS:

   ```properties
   DRIVERNAME=SYBASE
   JAR=jtds-<version>.jar
   DRIVERMAIN=net.sourceforge.jtds.jdbc.Driver
   PREFIX=jdbc:jtds:sybase:
   NOSECURITY=YES
   FETCHSIZE=100000
   INSERTSIZE=-1
   
   ```
   Ensure that the file ends with a trailing newline.

## Installing the Adapter Script

Upload the latest available release of [Sybase Virtual Schema](https://github.com/exasol/sybase-virtual-schema/releases) to Bucket FS.

Then create a schema to hold the adapter script.

```sql
CREATE SCHEMA ADAPTER;
```

The SQL statement below creates the adapter script, defines the Java class that serves as entry point and tells the UDF framework where to find the libraries (JAR files) for Virtual Schema and database driver.

```sql
CREATE OR REPLACE JAVA ADAPTER SCRIPT ADAPTER.JDBC_ADAPTER AS
  %scriptclass com.exasol.adapter.RequestDispatcher;
  %jar /buckets/<BFS service>/<bucket>/virtual-schema-dist-14.0.2-sybase-4.0.0.jar;
  %jar /buckets/<BFS service>/<bucket>/jtds-<version>.jar;
/
```

## Defining a Named Connection

Define the connection to Sybase as shown below.

```sql
CREATE OR REPLACE CONNECTION SYBASE_CONNECTION
TO 'jdbc:jtds:sybase://<host>:<port>/<database name>'
USER '<user>'
IDENTIFIED BY '<password>';
```

## Creating a Virtual Schema

Below you see how a Sybase Virtual Schema is created.

```sql
CREATE VIRTUAL SCHEMA <virtual schema name>
    USING ADAPTER.JDBC_ADAPTER
    WITH
	CONNECTION_NAME = 'SYBASE_CONNECTION'
	CATALOG_NAME = '<catalog name>'
	SCHEMA_NAME = '<schema name>';
```

## Data Types Conversion

Sybase Data Type   | Supported | Converted Exasol Data Type| Known limitations
-------------------|-----------|---------------------------|-------------------
BIGINT             |  ✓        | DECIMAL                   |
BIT                |  ✓        | BOOLEAN                   |
DECIMAL            |  ✓        | DECIMAL, VARCHAR*         |
BINARY             |  ×        |                           |
CHAR               |  ✓        | CHAR, VARCHAR             | The Sybase data type `CHAR(n > 2000)` is mapped to Exasol's `VARCHAR(n)`. Exasol only supports `n <= 2000` for data type `CHAR`.
DATE               |  ✓        | DATE                      |
DATETIME           |  ✓        | TIMESTAMP                 |
DOUBLE PRECISION   |  ✓        | DOUBLE PRECISION          |
FLOAT              |  ✓        | DOUBLE PRECISION          |
IMAGE              |  ×        |                           |
INT                |  ✓        | DECIMAL                   |
NUMERIC            |  ✓        | DECIMAL, VARCHAR*         |
SMALLINT           |  ✓        | DECIMAL                   |
TEXT               |  ✓        | VARCHAR(2000000) UTF8     | If a value exceeds column size, an error is shown.
TINYINT            |  ✓        | DECIMAL                   |
UNITEXT            |  ✓        | VARCHAR(2000000) UTF8     | If a value exceeds column size, an error is shown.
VARBINARY          |  ×        |                           |
VARCHAR            |  ✓        | VARCHAR                   |


* `NUMERIC/DECIMAL(precision, scale)`: Sybase supports precision values up to 38, Exasol only up to 36 decimals. `NUMERIC/DECIMAL` with precision <= 36 are mapped to Exasol's `DECIMAL` type; greater precision values are mapped to a `VARCHAR` column.

Datatypes that require testing:

Sybase Data Type   | Supported | Converted Exasol Data Type| Known limitations
-------------------|-----------|---------------------------|-------------------
BIGDATETIME        |  ?        |                           |
BIGTIME            |  ?        |                           |
BIT                |  ?        |                           |
MONEY              |  ?        |                           |
NCHAR              |  ?        |                           |
NVARCHAR           |  ?        |                           |
REAL               |  ?        |                           |
SMALLDATETIME      |  ?        |                           |
SMALLMONEY         |  ?        |                           |
TIME               |  ?        |                           | 
UNICHAR            |  ?        |                           |

## Testing information

The Sybase dialect was tested with the [jTDS 1.3.1 JDBC driver](https://sourceforge.net/projects/jtds/files/jtds/1.3.1/) and Sybase 16.0.
