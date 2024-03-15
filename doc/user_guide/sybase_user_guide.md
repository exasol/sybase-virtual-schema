# Sybase SQL Dialect User Guide

[SAP ASE](https://www.sap.com/products/sybase-ase.html), originally known as Sybase SQL Server is a relational model database server developed by Sybase Corporation, which later became part of SAP AG.

**Please note that this Virtual Schema works only for the Sybase ASE database and not Sybase IQ.**

## Registering the JDBC Driver in EXAOperation

First download the [Sybase JDBC driver](https://sourceforge.net/projects/jtds/). Open the archive and find `jtds-<version>.jar` file.

**Attention!** If you use Exasol 7.0.0 and up, you need to register the driver in EXAOperation. If you use Exasol below 7.0.0, you can skip this step and go to [Uploading the JDBC Driver to Bucket](#uploading-the-jdbc-driver-to-bucket).

Register the driver in EXAOperation:

1. Click "Software"
1. Switch to tab "JDBC Drivers"
1. Click "Browse..."
1. Select JDBC driver file
1. Click "Upload"
1. Click "Add"
1. In a dialog "Add EXACluster JDBC driver" configure the JDBC driver (see below)

You need to specify the following settings when adding the JDBC driver via EXAOperation.

| Parameter | Value                              |
|-----------|------------------------------------|
| Name      | `SYBASE`                           |
| Main      | `net.sourceforge.jtds.jdbc.Driver` |
| Prefix    | `jdbc:jtds:sybase:`                |
| Files     | `jtds-<version>.jar`               |

## Uploading the JDBC Driver to Bucket

1. [Create a bucket in BucketFS](https://docs.exasol.com/administration/on-premise/bucketfs/create_new_bucket_in_bucketfs_service.htm)
1. Upload the driver (`jtds-<version>.jar`) to BucketFS

This step is necessary since the UDF container the adapter runs in has no access to the JDBC drivers installed via EXAOperation but it can access BucketFS.

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
  %jar /buckets/<BFS service>/<bucket>/virtual-schema-dist-12.0.0-sybase-2.0.1.jar;
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
