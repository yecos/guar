package com.bigbee.db;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.saveable.AutoIncrementModelSaver;
import com.raizlabs.android.dbflow.sql.saveable.ModelSaver;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import com.umeng.analytics.AnalyticsConfig;

/* loaded from: classes.dex */
public final class EventDbModel_Table extends ModelAdapter<EventDbModel> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES;
    public static final Property<String> appVer;
    public static final Property<String> cipherStr;
    public static final Property<String> commonStr;
    public static final Property<Long> endTime;
    public static final Property<String> eventId;
    public static final Property<Integer> id;
    public static final Property<Boolean> notIntactEvent;
    public static final Property<Boolean> reporting;
    public static final Property<String> reserveA;
    public static final Property<String> reserveB;
    public static final Property<Long> startTime;
    public static final Property<String> sysVer;

    static {
        Property<Integer> property = new Property<>((Class<?>) EventDbModel.class, "id");
        id = property;
        Property<String> property2 = new Property<>((Class<?>) EventDbModel.class, "appVer");
        appVer = property2;
        Property<String> property3 = new Property<>((Class<?>) EventDbModel.class, "sysVer");
        sysVer = property3;
        Property<Long> property4 = new Property<>((Class<?>) EventDbModel.class, AnalyticsConfig.RTD_START_TIME);
        startTime = property4;
        Property<Long> property5 = new Property<>((Class<?>) EventDbModel.class, "endTime");
        endTime = property5;
        Property<String> property6 = new Property<>((Class<?>) EventDbModel.class, "eventId");
        eventId = property6;
        Property<Boolean> property7 = new Property<>((Class<?>) EventDbModel.class, "reporting");
        reporting = property7;
        Property<String> property8 = new Property<>((Class<?>) EventDbModel.class, "cipherStr");
        cipherStr = property8;
        Property<String> property9 = new Property<>((Class<?>) EventDbModel.class, "commonStr");
        commonStr = property9;
        Property<Boolean> property10 = new Property<>((Class<?>) EventDbModel.class, "notIntactEvent");
        notIntactEvent = property10;
        Property<String> property11 = new Property<>((Class<?>) EventDbModel.class, "reserveA");
        reserveA = property11;
        Property<String> property12 = new Property<>((Class<?>) EventDbModel.class, "reserveB");
        reserveB = property12;
        ALL_COLUMN_PROPERTIES = new IProperty[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11, property12};
    }

    public EventDbModel_Table(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    @Override // com.raizlabs.android.dbflow.structure.ModelAdapter
    public final ModelSaver<EventDbModel> createSingleModelSaver() {
        return new AutoIncrementModelSaver();
    }

    @Override // com.raizlabs.android.dbflow.structure.ModelAdapter
    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    @Override // com.raizlabs.android.dbflow.structure.ModelAdapter
    public final String getAutoIncrementingColumnName() {
        return "id";
    }

    @Override // com.raizlabs.android.dbflow.structure.ModelAdapter
    public final String getCompiledStatementQuery() {
        return "INSERT INTO `EventDbModel`(`id`,`appVer`,`sysVer`,`startTime`,`endTime`,`eventId`,`reporting`,`cipherStr`,`commonStr`,`notIntactEvent`,`reserveA`,`reserveB`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override // com.raizlabs.android.dbflow.structure.ModelAdapter
    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `EventDbModel`(`id` INTEGER PRIMARY KEY AUTOINCREMENT, `appVer` TEXT, `sysVer` TEXT, `startTime` INTEGER, `endTime` INTEGER, `eventId` TEXT, `reporting` INTEGER, `cipherStr` TEXT, `commonStr` TEXT, `notIntactEvent` INTEGER, `reserveA` TEXT, `reserveB` TEXT)";
    }

    @Override // com.raizlabs.android.dbflow.structure.ModelAdapter
    public final String getDeleteStatementQuery() {
        return "DELETE FROM `EventDbModel` WHERE `id`=?";
    }

    @Override // com.raizlabs.android.dbflow.structure.ModelAdapter
    public final String getInsertStatementQuery() {
        return "INSERT INTO `EventDbModel`(`appVer`,`sysVer`,`startTime`,`endTime`,`eventId`,`reporting`,`cipherStr`,`commonStr`,`notIntactEvent`,`reserveA`,`reserveB`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override // com.raizlabs.android.dbflow.structure.RetrievalAdapter
    public final Class<EventDbModel> getModelClass() {
        return EventDbModel.class;
    }

    @Override // com.raizlabs.android.dbflow.structure.ModelAdapter
    public final Property getProperty(String str) {
        String quoteIfNeeded = QueryBuilder.quoteIfNeeded(str);
        quoteIfNeeded.hashCode();
        switch (quoteIfNeeded) {
            case "`sysVer`":
                return sysVer;
            case "`eventId`":
                return eventId;
            case "`cipherStr`":
                return cipherStr;
            case "`appVer`":
                return appVer;
            case "`notIntactEvent`":
                return notIntactEvent;
            case "`endTime`":
                return endTime;
            case "`id`":
                return id;
            case "`reserveA`":
                return reserveA;
            case "`reserveB`":
                return reserveB;
            case "`commonStr`":
                return commonStr;
            case "`reporting`":
                return reporting;
            case "`startTime`":
                return startTime;
            default:
                throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
        }
    }

    @Override // com.raizlabs.android.dbflow.structure.InternalAdapter
    public final String getTableName() {
        return "`EventDbModel`";
    }

    @Override // com.raizlabs.android.dbflow.structure.ModelAdapter
    public final String getUpdateStatementQuery() {
        return "UPDATE `EventDbModel` SET `id`=?,`appVer`=?,`sysVer`=?,`startTime`=?,`endTime`=?,`eventId`=?,`reporting`=?,`cipherStr`=?,`commonStr`=?,`notIntactEvent`=?,`reserveA`=?,`reserveB`=? WHERE `id`=?";
    }

    @Override // com.raizlabs.android.dbflow.structure.ModelAdapter, com.raizlabs.android.dbflow.structure.InternalAdapter
    public final void bindToContentValues(ContentValues contentValues, EventDbModel eventDbModel) {
        contentValues.put("`id`", Integer.valueOf(eventDbModel.id));
        bindToInsertValues(contentValues, eventDbModel);
    }

    @Override // com.raizlabs.android.dbflow.structure.InternalAdapter
    public final void bindToDeleteStatement(DatabaseStatement databaseStatement, EventDbModel eventDbModel) {
        databaseStatement.bindLong(1, eventDbModel.id);
    }

    @Override // com.raizlabs.android.dbflow.structure.InternalAdapter
    public final void bindToInsertStatement(DatabaseStatement databaseStatement, EventDbModel eventDbModel, int i10) {
        databaseStatement.bindStringOrNull(i10 + 1, eventDbModel.appVer);
        databaseStatement.bindStringOrNull(i10 + 2, eventDbModel.sysVer);
        databaseStatement.bindLong(i10 + 3, eventDbModel.startTime);
        databaseStatement.bindLong(i10 + 4, eventDbModel.endTime);
        databaseStatement.bindStringOrNull(i10 + 5, eventDbModel.eventId);
        databaseStatement.bindLong(i10 + 6, eventDbModel.reporting ? 1L : 0L);
        databaseStatement.bindStringOrNull(i10 + 7, eventDbModel.cipherStr);
        databaseStatement.bindStringOrNull(i10 + 8, eventDbModel.commonStr);
        databaseStatement.bindLong(i10 + 9, eventDbModel.notIntactEvent ? 1L : 0L);
        databaseStatement.bindStringOrNull(i10 + 10, eventDbModel.reserveA);
        databaseStatement.bindStringOrNull(i10 + 11, eventDbModel.reserveB);
    }

    @Override // com.raizlabs.android.dbflow.structure.InternalAdapter
    public final void bindToInsertValues(ContentValues contentValues, EventDbModel eventDbModel) {
        contentValues.put("`appVer`", eventDbModel.appVer);
        contentValues.put("`sysVer`", eventDbModel.sysVer);
        contentValues.put("`startTime`", Long.valueOf(eventDbModel.startTime));
        contentValues.put("`endTime`", Long.valueOf(eventDbModel.endTime));
        contentValues.put("`eventId`", eventDbModel.eventId);
        contentValues.put("`reporting`", Integer.valueOf(eventDbModel.reporting ? 1 : 0));
        contentValues.put("`cipherStr`", eventDbModel.cipherStr);
        contentValues.put("`commonStr`", eventDbModel.commonStr);
        contentValues.put("`notIntactEvent`", Integer.valueOf(eventDbModel.notIntactEvent ? 1 : 0));
        contentValues.put("`reserveA`", eventDbModel.reserveA);
        contentValues.put("`reserveB`", eventDbModel.reserveB);
    }

    @Override // com.raizlabs.android.dbflow.structure.ModelAdapter, com.raizlabs.android.dbflow.structure.InternalAdapter
    public final void bindToStatement(DatabaseStatement databaseStatement, EventDbModel eventDbModel) {
        databaseStatement.bindLong(1, eventDbModel.id);
        bindToInsertStatement(databaseStatement, eventDbModel, 1);
    }

    @Override // com.raizlabs.android.dbflow.structure.InternalAdapter
    public final void bindToUpdateStatement(DatabaseStatement databaseStatement, EventDbModel eventDbModel) {
        databaseStatement.bindLong(1, eventDbModel.id);
        databaseStatement.bindStringOrNull(2, eventDbModel.appVer);
        databaseStatement.bindStringOrNull(3, eventDbModel.sysVer);
        databaseStatement.bindLong(4, eventDbModel.startTime);
        databaseStatement.bindLong(5, eventDbModel.endTime);
        databaseStatement.bindStringOrNull(6, eventDbModel.eventId);
        databaseStatement.bindLong(7, eventDbModel.reporting ? 1L : 0L);
        databaseStatement.bindStringOrNull(8, eventDbModel.cipherStr);
        databaseStatement.bindStringOrNull(9, eventDbModel.commonStr);
        databaseStatement.bindLong(10, eventDbModel.notIntactEvent ? 1L : 0L);
        databaseStatement.bindStringOrNull(11, eventDbModel.reserveA);
        databaseStatement.bindStringOrNull(12, eventDbModel.reserveB);
        databaseStatement.bindLong(13, eventDbModel.id);
    }

    @Override // com.raizlabs.android.dbflow.structure.RetrievalAdapter
    public final boolean exists(EventDbModel eventDbModel, DatabaseWrapper databaseWrapper) {
        return eventDbModel.id > 0 && SQLite.selectCountOf(new IProperty[0]).from(EventDbModel.class).where(getPrimaryConditionClause(eventDbModel)).hasData(databaseWrapper);
    }

    @Override // com.raizlabs.android.dbflow.structure.ModelAdapter, com.raizlabs.android.dbflow.structure.InternalAdapter
    public final Number getAutoIncrementingId(EventDbModel eventDbModel) {
        return Integer.valueOf(eventDbModel.id);
    }

    @Override // com.raizlabs.android.dbflow.structure.RetrievalAdapter
    public final OperatorGroup getPrimaryConditionClause(EventDbModel eventDbModel) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(id.eq((Property<Integer>) Integer.valueOf(eventDbModel.id)));
        return clause;
    }

    @Override // com.raizlabs.android.dbflow.structure.RetrievalAdapter
    public final void loadFromCursor(FlowCursor flowCursor, EventDbModel eventDbModel) {
        eventDbModel.id = flowCursor.getIntOrDefault("id");
        eventDbModel.appVer = flowCursor.getStringOrDefault("appVer");
        eventDbModel.sysVer = flowCursor.getStringOrDefault("sysVer");
        eventDbModel.startTime = flowCursor.getLongOrDefault(AnalyticsConfig.RTD_START_TIME);
        eventDbModel.endTime = flowCursor.getLongOrDefault("endTime");
        eventDbModel.eventId = flowCursor.getStringOrDefault("eventId");
        int columnIndex = flowCursor.getColumnIndex("reporting");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            eventDbModel.reporting = false;
        } else {
            eventDbModel.reporting = flowCursor.getBoolean(columnIndex);
        }
        eventDbModel.cipherStr = flowCursor.getStringOrDefault("cipherStr");
        eventDbModel.commonStr = flowCursor.getStringOrDefault("commonStr");
        int columnIndex2 = flowCursor.getColumnIndex("notIntactEvent");
        if (columnIndex2 == -1 || flowCursor.isNull(columnIndex2)) {
            eventDbModel.notIntactEvent = false;
        } else {
            eventDbModel.notIntactEvent = flowCursor.getBoolean(columnIndex2);
        }
        eventDbModel.reserveA = flowCursor.getStringOrDefault("reserveA");
        eventDbModel.reserveB = flowCursor.getStringOrDefault("reserveB");
    }

    @Override // com.raizlabs.android.dbflow.structure.InstanceAdapter
    public final EventDbModel newInstance() {
        return new EventDbModel();
    }

    @Override // com.raizlabs.android.dbflow.structure.ModelAdapter, com.raizlabs.android.dbflow.structure.InternalAdapter
    public final void updateAutoIncrement(EventDbModel eventDbModel, Number number) {
        eventDbModel.id = number.intValue();
    }
}
