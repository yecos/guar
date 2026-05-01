package com.raizlabs.android.dbflow.sql.language;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class Insert<TModel> extends BaseQueriable<TModel> implements Query {
    private IProperty[] columns;
    private ConflictAction conflictAction;
    private From<?> selectFrom;
    private List<Collection<Object>> valuesList;

    public Insert(Class<TModel> cls) {
        super(cls);
        this.conflictAction = ConflictAction.NONE;
    }

    public Insert<TModel> asColumnValues() {
        asColumns();
        if (this.columns != null) {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < this.columns.length; i10++) {
                arrayList.add(Operator.Operation.EMPTY_PARAM);
            }
            this.valuesList.add(arrayList);
        }
        return this;
    }

    public Insert<TModel> asColumns() {
        columns(FlowManager.getModelAdapter(getTable()).getAllColumnProperties());
        return this;
    }

    public Insert<TModel> columnValues(SQLOperator... sQLOperatorArr) {
        String[] strArr = new String[sQLOperatorArr.length];
        Object[] objArr = new Object[sQLOperatorArr.length];
        for (int i10 = 0; i10 < sQLOperatorArr.length; i10++) {
            SQLOperator sQLOperator = sQLOperatorArr[i10];
            strArr[i10] = sQLOperator.columnName();
            objArr[i10] = sQLOperator.value();
        }
        return columns(strArr).values(objArr);
    }

    public Insert<TModel> columns(String... strArr) {
        this.columns = new IProperty[strArr.length];
        ModelAdapter modelAdapter = FlowManager.getModelAdapter(getTable());
        for (int i10 = 0; i10 < strArr.length; i10++) {
            this.columns[i10] = modelAdapter.getProperty(strArr[i10]);
        }
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public long executeUpdateDelete(DatabaseWrapper databaseWrapper) {
        throw new IllegalStateException("Cannot call executeUpdateDelete() from an Insert");
    }

    @Override // com.raizlabs.android.dbflow.sql.language.BaseQueriable, com.raizlabs.android.dbflow.sql.queriable.Queriable, com.raizlabs.android.dbflow.sql.language.Actionable
    public BaseModel.Action getPrimaryAction() {
        return BaseModel.Action.INSERT;
    }

    @Override // com.raizlabs.android.dbflow.sql.Query
    public String getQuery() {
        QueryBuilder queryBuilder = new QueryBuilder("INSERT ");
        ConflictAction conflictAction = this.conflictAction;
        if (conflictAction != null && !conflictAction.equals(ConflictAction.NONE)) {
            queryBuilder.append(Operator.Operation.OR).appendSpaceSeparated(this.conflictAction);
        }
        queryBuilder.append("INTO").appendSpace().append(FlowManager.getTableName(getTable()));
        if (this.columns != null) {
            queryBuilder.append("(").appendArray(this.columns).append(")");
        }
        if (this.selectFrom != null) {
            queryBuilder.appendSpace().append(this.selectFrom.getQuery());
        } else {
            List<Collection<Object>> list = this.valuesList;
            if (list == null || list.size() < 1) {
                throw new IllegalStateException("The insert of " + FlowManager.getTableName(getTable()) + " should haveat least one value specified for the insert");
            }
            if (this.columns != null) {
                Iterator<Collection<Object>> it = this.valuesList.iterator();
                while (it.hasNext()) {
                    if (it.next().size() != this.columns.length) {
                        throw new IllegalStateException("The Insert of " + FlowManager.getTableName(getTable()) + " when specifyingcolumns needs to have the same amount of values and columns");
                    }
                }
            }
            queryBuilder.append(" VALUES(");
            for (int i10 = 0; i10 < this.valuesList.size(); i10++) {
                if (i10 > 0) {
                    queryBuilder.append(",(");
                }
                queryBuilder.append(BaseOperator.joinArguments(", ", this.valuesList.get(i10))).append(")");
            }
        }
        return queryBuilder.getQuery();
    }

    public Insert<TModel> or(ConflictAction conflictAction) {
        this.conflictAction = conflictAction;
        return this;
    }

    public Insert<TModel> orAbort() {
        return or(ConflictAction.ABORT);
    }

    public Insert<TModel> orFail() {
        return or(ConflictAction.FAIL);
    }

    public Insert<TModel> orIgnore() {
        return or(ConflictAction.IGNORE);
    }

    public Insert<TModel> orReplace() {
        return or(ConflictAction.REPLACE);
    }

    public Insert<TModel> orRollback() {
        return or(ConflictAction.ROLLBACK);
    }

    public Insert<TModel> select(From<?> from) {
        this.selectFrom = from;
        return this;
    }

    public Insert<TModel> values(Object... objArr) {
        if (this.valuesList == null) {
            this.valuesList = new ArrayList();
        }
        this.valuesList.add(Arrays.asList(objArr));
        return this;
    }

    @Override // com.raizlabs.android.dbflow.sql.queriable.Queriable
    public long executeUpdateDelete() {
        throw new IllegalStateException("Cannot call executeUpdateDelete() from an Insert");
    }

    public Insert<TModel> values(Collection<Object> collection) {
        if (this.valuesList == null) {
            this.valuesList = new ArrayList();
        }
        this.valuesList.add(collection);
        return this;
    }

    public Insert<TModel> columns(IProperty... iPropertyArr) {
        this.columns = new IProperty[iPropertyArr.length];
        for (int i10 = 0; i10 < iPropertyArr.length; i10++) {
            this.columns[i10] = iPropertyArr[i10];
        }
        return this;
    }

    public Insert<TModel> columnValues(OperatorGroup operatorGroup) {
        int size = operatorGroup.size();
        String[] strArr = new String[size];
        Object[] objArr = new Object[size];
        for (int i10 = 0; i10 < size; i10++) {
            SQLOperator sQLOperator = operatorGroup.getConditions().get(i10);
            strArr[i10] = sQLOperator.columnName();
            objArr[i10] = sQLOperator.value();
        }
        return columns(strArr).values(objArr);
    }

    public Insert<TModel> columns(List<IProperty> list) {
        return columns((IProperty[]) list.toArray(new IProperty[list.size()]));
    }

    public Insert<TModel> columnValues(ContentValues contentValues) {
        java.util.Set<Map.Entry<String, Object>> valueSet = contentValues.valueSet();
        String[] strArr = new String[contentValues.size()];
        Object[] objArr = new Object[contentValues.size()];
        Iterator<Map.Entry<String, Object>> it = valueSet.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            String key = it.next().getKey();
            strArr[i10] = key;
            objArr[i10] = contentValues.get(key);
            i10++;
        }
        return columns(strArr).values(objArr);
    }
}
