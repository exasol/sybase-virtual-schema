package com.exasol.adapter.dialects.sybase;

import com.exasol.adapter.dialects.*;
import com.exasol.logging.VersionCollector;

/**
 * Factory for the Sybase dialect.
 */
public class SybaseSqlDialectFactory implements SqlDialectFactory {
    @Override
    public String getSqlDialectName() {
        return SybaseSqlDialect.NAME;
    }

    @Override
    public SqlDialect createSqlDialect(final JDBCAdapterContext context) {
        return new SybaseSqlDialect(context);
    }

    @Override
    public String getSqlDialectVersion() {
        final VersionCollector versionCollector = new VersionCollector(
                "META-INF/maven/com.exasol/sybase-virtual-schema/pom.properties");
        return versionCollector.getVersionNumber();
    }

    @Override
    public String getAdapterProjectShortTag() {
        return "VSSY";
    }
}
