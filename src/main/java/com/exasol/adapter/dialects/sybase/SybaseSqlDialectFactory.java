package com.exasol.adapter.dialects.sybase;

import com.exasol.adapter.AdapterProperties;
import com.exasol.adapter.dialects.SqlDialect;
import com.exasol.adapter.dialects.SqlDialectFactory;
import com.exasol.adapter.jdbc.ConnectionFactory;
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
    public SqlDialect createSqlDialect(final ConnectionFactory connectionFactory, final AdapterProperties properties) {
        return new SybaseSqlDialect(connectionFactory, properties);
    }

    @Override
    public String getSqlDialectVersion() {
        final VersionCollector versionCollector = new VersionCollector(
                "META-INF/maven/com.exasol/sybase-virtual-schema/pom.properties");
        return versionCollector.getVersionNumber();
    }
}