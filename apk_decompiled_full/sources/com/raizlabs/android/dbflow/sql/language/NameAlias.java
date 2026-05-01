package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.StringUtils;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;

/* loaded from: classes3.dex */
public class NameAlias implements Query {
    private final String aliasName;
    private final String keyword;
    private final String name;
    private final boolean shouldAddIdentifierToAliasName;
    private final boolean shouldAddIdentifierToQuery;
    private final boolean shouldStripAliasName;
    private final boolean shouldStripIdentifier;
    private final String tableName;

    public static class Builder {
        private String aliasName;
        private String keyword;
        private final String name;
        private String tableName;
        private boolean shouldStripIdentifier = true;
        private boolean shouldStripAliasName = true;
        private boolean shouldAddIdentifierToQuery = true;
        private boolean shouldAddIdentifierToAliasName = true;

        public Builder(String str) {
            this.name = str;
        }

        public Builder as(String str) {
            this.aliasName = str;
            return this;
        }

        public NameAlias build() {
            return new NameAlias(this);
        }

        public Builder distinct() {
            return keyword("DISTINCT");
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder shouldAddIdentifierToAliasName(boolean z10) {
            this.shouldAddIdentifierToAliasName = z10;
            return this;
        }

        public Builder shouldAddIdentifierToName(boolean z10) {
            this.shouldAddIdentifierToQuery = z10;
            return this;
        }

        public Builder shouldStripAliasName(boolean z10) {
            this.shouldStripAliasName = z10;
            return this;
        }

        public Builder shouldStripIdentifier(boolean z10) {
            this.shouldStripIdentifier = z10;
            return this;
        }

        public Builder withTable(String str) {
            this.tableName = str;
            return this;
        }
    }

    public static Builder builder(String str) {
        return new Builder(str);
    }

    public static NameAlias joinNames(String str, String... strArr) {
        String str2 = "";
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (i10 > 0) {
                str2 = str2 + " " + str + " ";
            }
            str2 = str2 + strArr[i10];
        }
        return rawBuilder(str2).build();
    }

    public static NameAlias of(String str) {
        return builder(str).build();
    }

    public static NameAlias ofTable(String str, String str2) {
        return builder(str2).withTable(str).build();
    }

    public static Builder rawBuilder(String str) {
        return new Builder(str).shouldStripIdentifier(false).shouldAddIdentifierToName(false);
    }

    public String aliasName() {
        return (StringUtils.isNotNullOrEmpty(this.aliasName) && this.shouldAddIdentifierToAliasName) ? QueryBuilder.quoteIfNeeded(this.aliasName) : this.aliasName;
    }

    public String aliasNameRaw() {
        return this.shouldStripAliasName ? this.aliasName : QueryBuilder.stripQuotes(this.aliasName);
    }

    public String fullName() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotNullOrEmpty(this.tableName)) {
            str = tableName() + ".";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(name());
        return sb.toString();
    }

    public String getFullQuery() {
        String fullName = fullName();
        if (StringUtils.isNotNullOrEmpty(this.aliasName)) {
            fullName = fullName + " AS " + aliasName();
        }
        if (!StringUtils.isNotNullOrEmpty(this.keyword)) {
            return fullName;
        }
        return this.keyword + " " + fullName;
    }

    public String getNameAsKey() {
        return StringUtils.isNotNullOrEmpty(this.aliasName) ? aliasNameRaw() : nameRaw();
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        return StringUtils.isNotNullOrEmpty(this.aliasName) ? aliasName() : StringUtils.isNotNullOrEmpty(this.name) ? fullName() : "";
    }

    public String keyword() {
        return this.keyword;
    }

    public String name() {
        return (StringUtils.isNotNullOrEmpty(this.name) && this.shouldAddIdentifierToQuery) ? QueryBuilder.quoteIfNeeded(this.name) : this.name;
    }

    public String nameRaw() {
        return this.shouldStripIdentifier ? this.name : QueryBuilder.stripQuotes(this.name);
    }

    public Builder newBuilder() {
        return new Builder(this.name).keyword(this.keyword).as(this.aliasName).shouldStripAliasName(this.shouldStripAliasName).shouldStripIdentifier(this.shouldStripIdentifier).shouldAddIdentifierToName(this.shouldAddIdentifierToQuery).shouldAddIdentifierToAliasName(this.shouldAddIdentifierToAliasName).withTable(this.tableName);
    }

    public boolean shouldStripAliasName() {
        return this.shouldStripAliasName;
    }

    public boolean shouldStripIdentifier() {
        return this.shouldStripIdentifier;
    }

    public String tableName() {
        return this.tableName;
    }

    public String toString() {
        return getFullQuery();
    }

    private NameAlias(Builder builder) {
        if (builder.shouldStripIdentifier) {
            this.name = QueryBuilder.stripQuotes(builder.name);
        } else {
            this.name = builder.name;
        }
        this.keyword = builder.keyword;
        if (builder.shouldStripAliasName) {
            this.aliasName = QueryBuilder.stripQuotes(builder.aliasName);
        } else {
            this.aliasName = builder.aliasName;
        }
        if (StringUtils.isNotNullOrEmpty(builder.tableName)) {
            this.tableName = QueryBuilder.quoteIfNeeded(builder.tableName);
        } else {
            this.tableName = null;
        }
        this.shouldStripIdentifier = builder.shouldStripIdentifier;
        this.shouldStripAliasName = builder.shouldStripAliasName;
        this.shouldAddIdentifierToQuery = builder.shouldAddIdentifierToQuery;
        this.shouldAddIdentifierToAliasName = builder.shouldAddIdentifierToAliasName;
    }

    public static NameAlias of(String str, String str2) {
        return builder(str).as(str2).build();
    }
}
