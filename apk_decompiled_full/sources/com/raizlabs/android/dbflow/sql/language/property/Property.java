package com.raizlabs.android.dbflow.sql.language.property;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.BaseModelQueriable;
import com.raizlabs.android.dbflow.sql.language.IConditional;
import com.raizlabs.android.dbflow.sql.language.IOperator;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.language.OrderBy;
import java.util.Collection;

/* loaded from: classes3.dex */
public class Property<T> implements IProperty<Property<T>>, IConditional, IOperator<T> {
    public static final Property<String> ALL_PROPERTY = new Property<>((Class<?>) null, NameAlias.rawBuilder(Operator.Operation.MULTIPLY).build());
    public static final Property<?> WILDCARD = new Property<>((Class<?>) null, NameAlias.rawBuilder(Operator.Operation.EMPTY_PARAM).build());
    protected NameAlias nameAlias;
    final Class<?> table;

    public Property(Class<?> cls, NameAlias nameAlias) {
        this.table = cls;
        this.nameAlias = nameAlias;
    }

    public static Property<String> allProperty(Class<?> cls) {
        return new Property(cls, NameAlias.rawBuilder(Operator.Operation.MULTIPLY).build()).withTable();
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.IProperty
    public OrderBy asc() {
        return OrderBy.fromProperty(this).ascending();
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator.Between between(IConditional iConditional) {
        return getCondition().between(iConditional);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.IProperty
    public OrderBy desc() {
        return OrderBy.fromProperty(this).descending();
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator eq(IConditional iConditional) {
        return getCondition().eq(iConditional);
    }

    public Operator<T> getCondition() {
        return Operator.op(getNameAlias());
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.IProperty
    public String getCursorKey() {
        return getNameAlias().getQuery();
    }

    public String getDefinition() {
        return getNameAlias().getFullQuery();
    }

    public NameAlias getDistinctAliasName() {
        return getNameAlias().newBuilder().distinct().build();
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.IProperty
    public NameAlias getNameAlias() {
        return this.nameAlias;
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        return getNameAlias().getQuery();
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.IProperty
    public Class<?> getTable() {
        return this.table;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator glob(IConditional iConditional) {
        return getCondition().glob(iConditional);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator greaterThan(IConditional iConditional) {
        return getCondition().greaterThan(iConditional);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator greaterThanOrEq(IConditional iConditional) {
        return getCondition().greaterThanOrEq(iConditional);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator.In in(IConditional iConditional, IConditional... iConditionalArr) {
        return getCondition().in(iConditional, iConditionalArr);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator is(IConditional iConditional) {
        return getCondition().is(iConditional);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator isNot(IConditional iConditional) {
        return getCondition().isNot(iConditional);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator isNotNull() {
        return getCondition().isNotNull();
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator isNull() {
        return getCondition().isNull();
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator lessThan(IConditional iConditional) {
        return getCondition().lessThan(iConditional);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator lessThanOrEq(IConditional iConditional) {
        return getCondition().lessThanOrEq(iConditional);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator like(IConditional iConditional) {
        return getCondition().like(iConditional);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator notEq(IConditional iConditional) {
        return getCondition().notEq(iConditional);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator.In notIn(IConditional iConditional, IConditional... iConditionalArr) {
        return getCondition().notIn(iConditional, iConditionalArr);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator<T> notLike(String str) {
        return getCondition().notLike(str);
    }

    public String toString() {
        return getNameAlias().toString();
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.IProperty
    public Property<T> as(String str) {
        return new Property<>(this.table, getNameAlias().newBuilder().as(str).build());
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator.Between between(BaseModelQueriable baseModelQueriable) {
        return getCondition().between(baseModelQueriable);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator concatenate(IConditional iConditional) {
        return getCondition().concatenate(iConditional);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.IProperty
    public Property<T> distinct() {
        return new Property<>(this.table, getDistinctAliasName());
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator div(BaseModelQueriable baseModelQueriable) {
        return getCondition().div(baseModelQueriable);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator eq(BaseModelQueriable baseModelQueriable) {
        return getCondition().eq(baseModelQueriable);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator<T> glob(String str) {
        return getCondition().glob(str);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator greaterThan(BaseModelQueriable baseModelQueriable) {
        return getCondition().greaterThan(baseModelQueriable);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator greaterThanOrEq(BaseModelQueriable baseModelQueriable) {
        return getCondition().greaterThanOrEq(baseModelQueriable);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator.In in(BaseModelQueriable baseModelQueriable, BaseModelQueriable... baseModelQueriableArr) {
        return getCondition().in(baseModelQueriable, baseModelQueriableArr);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator is(BaseModelQueriable baseModelQueriable) {
        return getCondition().is(baseModelQueriable);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator isNot(BaseModelQueriable baseModelQueriable) {
        return getCondition().isNot(baseModelQueriable);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator lessThan(BaseModelQueriable baseModelQueriable) {
        return getCondition().lessThan(baseModelQueriable);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator lessThanOrEq(BaseModelQueriable baseModelQueriable) {
        return getCondition().lessThanOrEq(baseModelQueriable);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator<T> like(String str) {
        return getCondition().like(str);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator minus(BaseModelQueriable baseModelQueriable) {
        return getCondition().minus(baseModelQueriable);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator notEq(BaseModelQueriable baseModelQueriable) {
        return getCondition().notEq(baseModelQueriable);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator.In notIn(BaseModelQueriable baseModelQueriable, BaseModelQueriable... baseModelQueriableArr) {
        return getCondition().notIn(baseModelQueriable, baseModelQueriableArr);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator notLike(IConditional iConditional) {
        return getCondition().notLike(iConditional);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator plus(BaseModelQueriable baseModelQueriable) {
        return getCondition().plus(baseModelQueriable);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator rem(BaseModelQueriable baseModelQueriable) {
        return getCondition().rem(baseModelQueriable);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator times(BaseModelQueriable baseModelQueriable) {
        return getCondition().times(baseModelQueriable);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator.Between<T> between(T t10) {
        return getCondition().between((Operator<T>) t10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.IProperty
    public Property<T> concatenate(IProperty iProperty) {
        return new Property<>(this.table, NameAlias.joinNames(Operator.Operation.CONCATENATE, this.nameAlias.fullName(), iProperty.toString()));
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.IProperty
    public Property<T> div(IProperty iProperty) {
        return new Property<>(this.table, NameAlias.joinNames(Operator.Operation.DIVISION, this.nameAlias.fullName(), iProperty.toString()));
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator<T> eq(T t10) {
        return getCondition().eq((Operator<T>) t10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator glob(BaseModelQueriable baseModelQueriable) {
        return getCondition().glob(baseModelQueriable);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator<T> greaterThan(T t10) {
        return getCondition().greaterThan((Operator<T>) t10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator<T> greaterThanOrEq(T t10) {
        return getCondition().greaterThanOrEq((Operator<T>) t10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator.In<T> in(T t10, T... tArr) {
        return getCondition().in((Operator<T>) t10, (Operator<T>[]) tArr);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator<T> is(T t10) {
        return getCondition().is((Operator<T>) t10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator<T> isNot(T t10) {
        return getCondition().isNot((Operator<T>) t10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator<T> lessThan(T t10) {
        return getCondition().lessThan((Operator<T>) t10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator<T> lessThanOrEq(T t10) {
        return getCondition().lessThanOrEq((Operator<T>) t10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator like(BaseModelQueriable baseModelQueriable) {
        return getCondition().like(baseModelQueriable);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.IProperty
    public Property<T> minus(IProperty iProperty) {
        return new Property<>(this.table, NameAlias.joinNames(Operator.Operation.MINUS, this.nameAlias.fullName(), iProperty.toString()));
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator<T> notEq(T t10) {
        return getCondition().notEq((Operator<T>) t10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator.In<T> notIn(T t10, T... tArr) {
        return getCondition().notIn((Operator<T>) t10, (Operator<T>[]) tArr);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IConditional
    public Operator notLike(BaseModelQueriable baseModelQueriable) {
        return getCondition().notLike(baseModelQueriable);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.IProperty
    public Property<T> plus(IProperty iProperty) {
        return new Property<>(this.table, NameAlias.joinNames(Operator.Operation.PLUS, this.nameAlias.fullName(), iProperty.toString()));
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.IProperty
    public Property<T> rem(IProperty iProperty) {
        return new Property<>(this.table, NameAlias.joinNames(Operator.Operation.MOD, this.nameAlias.fullName(), iProperty.toString()));
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.IProperty
    public Property<T> times(IProperty iProperty) {
        return new Property<>(this.table, NameAlias.joinNames(Operator.Operation.MULTIPLY, this.nameAlias.fullName(), iProperty.toString()));
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.IProperty
    public Property<T> withTable() {
        return withTable(new NameAlias.Builder(FlowManager.getTableName(this.table)).build());
    }

    public Property(Class<?> cls, String str) {
        this.table = cls;
        if (str != null) {
            this.nameAlias = new NameAlias.Builder(str).build();
        }
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator.In<T> in(Collection<T> collection) {
        return getCondition().in(collection);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator.In<T> notIn(Collection<T> collection) {
        return getCondition().notIn(collection);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.IProperty
    public Property<T> withTable(NameAlias nameAlias) {
        return new Property<>(this.table, getNameAlias().newBuilder().withTable(nameAlias.getQuery()).build());
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator<T> concatenate(T t10) {
        return getCondition().concatenate(t10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator<T> div(T t10) {
        return getCondition().div((Operator<T>) t10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator<T> minus(T t10) {
        return getCondition().minus((Operator<T>) t10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator<T> plus(T t10) {
        return getCondition().plus((Operator<T>) t10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator<T> rem(T t10) {
        return getCondition().rem((Operator<T>) t10);
    }

    @Override // com.raizlabs.android.dbflow.sql.language.IOperator
    public Operator<T> times(T t10) {
        return getCondition().times((Operator<T>) t10);
    }

    public Property(Class<?> cls, String str, String str2) {
        this(cls, NameAlias.builder(str).as(str2).build());
    }
}
