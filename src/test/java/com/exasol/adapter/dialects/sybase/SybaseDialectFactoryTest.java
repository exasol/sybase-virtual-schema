package com.exasol.adapter.dialects.sybase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exasol.adapter.AdapterProperties;
import com.exasol.adapter.dialects.JDBCAdapterContext;

class SybaseDialectFactoryTest {
    private SybaseSqlDialectFactory factory;

    @BeforeEach
    void beforeEach() {
        this.factory = new SybaseSqlDialectFactory();
    }

    @Test
    void testGetName() {
        assertThat(this.factory.getSqlDialectName(), equalTo("SYBASE"));
    }

    @Test
    void testCreateDialect() {
        final JDBCAdapterContext context = JDBCAdapterContext.builder().properties(AdapterProperties.emptyProperties())
                .build();
        assertThat(this.factory.createSqlDialect(context), instanceOf(SybaseSqlDialect.class));
    }

    @Test
    void testGetSqlDialectVersion() {
        // Version only availble in built artifact
        assertThat(this.factory.getSqlDialectVersion(), equalTo("UNKNOWN"));
    }

    @Test
    void testGetAdapterProjectShortTag() {
        assertThat(this.factory.getAdapterProjectShortTag(), equalTo("VSSY"));
    }
}
