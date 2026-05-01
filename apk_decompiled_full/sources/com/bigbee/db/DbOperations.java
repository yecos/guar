package com.bigbee.db;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.BaseModelQueriable;
import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.From;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Transformable;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.OpenHelper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;
import com.umeng.analytics.AnalyticsConfig;
import i2.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DbOperations {
    private final int MAX_COUNT = 10000;
    private final int LIMIT_COUNT = 1000;
    private final String TAG = DbOperations.class.getSimpleName();
    private boolean mFixDatabaseCode14 = false;

    /* JADX WARN: Multi-variable type inference failed */
    private void fixDatabaseCode14() {
        if (this.mFixDatabaseCode14) {
            return;
        }
        try {
            OpenHelper helper = FlowManager.getDatabase((Class<?>) BBDatabase.class).getHelper();
            String str = Build.MODEL;
            if (TextUtils.equals(str, "HTV BOX HTV3")) {
                if (helper instanceof SQLiteOpenHelper) {
                    ((SQLiteOpenHelper) helper).setWriteAheadLoggingEnabled(false);
                }
                this.mFixDatabaseCode14 = true;
                return;
            }
            if (!TextUtils.equals(str, "Htv-6H")) {
                this.mFixDatabaseCode14 = true;
                return;
            }
            if (helper instanceof SQLiteOpenHelper) {
                ((SQLiteOpenHelper) helper).setWriteAheadLoggingEnabled(false);
            }
            File databasePath = FlowManager.getContext().getDatabasePath("BBDatabase.db");
            if (!databasePath.exists()) {
                databasePath.getParentFile().mkdirs();
            }
            String str2 = databasePath.getParentFile().getAbsolutePath() + File.separator + "tmp";
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            helper.getDatabase().execSQL("PRAGMA temp_store_directory = '" + str2 + "'");
            this.mFixDatabaseCode14 = true;
        } catch (Exception e10) {
            this.mFixDatabaseCode14 = true;
            e10.printStackTrace();
        }
    }

    public void clearAll() {
        synchronized (this) {
            fixDatabaseCode14();
            SQLite.delete(EventDbModel.class).execute();
        }
    }

    public void deleteEvent(long j10, String str) {
        synchronized (this) {
            fixDatabaseCode14();
            SQLite.delete(EventDbModel.class).where(EventDbModel_Table.eventId.eq((Property<String>) str), EventDbModel_Table.startTime.eq((Property<Long>) Long.valueOf(j10))).execute();
        }
    }

    public void deleteLimitNum() {
        synchronized (this) {
            fixDatabaseCode14();
            b.a(this.TAG, "deleteLimitNum,start");
            FlowManager.getDatabase((Class<?>) BBDatabase.class).beginTransactionAsync(new ITransaction() { // from class: com.bigbee.db.DbOperations.3
                @Override // com.raizlabs.android.dbflow.structure.database.transaction.ITransaction
                public void execute(DatabaseWrapper databaseWrapper) {
                    From from = SQLite.delete().from(EventDbModel.class);
                    Property<Integer> property = EventDbModel_Table.id;
                    from.where(property.in(SQLite.select(property).from(EventDbModel.class).orderBy(EventDbModel_Table.startTime.asc()).limit(1000), new BaseModelQueriable[0])).execute(databaseWrapper);
                }
            }).success(new Transaction.Success() { // from class: com.bigbee.db.DbOperations.2
                @Override // com.raizlabs.android.dbflow.structure.database.transaction.Transaction.Success
                public void onSuccess(Transaction transaction) {
                }
            }).error(new Transaction.Error() { // from class: com.bigbee.db.DbOperations.1
                @Override // com.raizlabs.android.dbflow.structure.database.transaction.Transaction.Error
                public void onError(Transaction transaction, Throwable th) {
                }
            }).build().execute();
            b.a(this.TAG, "deleteLimitNum,end");
        }
    }

    public void deleteListEvent(List<EventDbModel> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        b.a(this.TAG, "deleteListEvent,start");
        synchronized (this) {
            try {
                fixDatabaseCode14();
                FlowManager.getDatabase((Class<?>) BBDatabase.class).executeTransaction(new ProcessModelTransaction.Builder(new ProcessModelTransaction.ProcessModel<EventDbModel>() { // from class: com.bigbee.db.DbOperations.5
                    @Override // com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.ProcessModel
                    public void processModel(EventDbModel eventDbModel, DatabaseWrapper databaseWrapper) {
                        if (eventDbModel != null) {
                            eventDbModel.delete();
                        }
                    }
                }).addAll(list).build());
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public void deleteNum() {
        long j10;
        synchronized (this) {
            fixDatabaseCode14();
            try {
                j10 = SQLite.selectCountOf(new IProperty[0]).from(EventDbModel.class).count();
            } catch (Exception e10) {
                e10.printStackTrace();
                j10 = 0;
            }
        }
        if (j10 >= NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) {
            deleteLimitNum();
        }
    }

    public void deleteTable() {
        synchronized (this) {
            fixDatabaseCode14();
            Delete.table(EventDbModel.class, new SQLOperator[0]);
        }
    }

    public void insertAll(List<EventDbModel> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        synchronized (this) {
            try {
                fixDatabaseCode14();
                FlowManager.getDatabase((Class<?>) BBDatabase.class).executeTransaction(new ProcessModelTransaction.Builder(new ProcessModelTransaction.ProcessModel<EventDbModel>() { // from class: com.bigbee.db.DbOperations.4
                    @Override // com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.ProcessModel
                    public void processModel(EventDbModel eventDbModel, DatabaseWrapper databaseWrapper) {
                        if (eventDbModel == null || eventDbModel.startTime <= 0) {
                            return;
                        }
                        try {
                            eventDbModel.save();
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                }).addAll(list).build());
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public void insertAppEvent(String str, long j10, long j11) {
        synchronized (this) {
            fixDatabaseCode14();
            SQLite.insert(EventDbModel.class).columns(EventDbModel_Table.eventId, EventDbModel_Table.startTime, EventDbModel_Table.endTime).values(str, Long.valueOf(j10), Long.valueOf(j11)).execute();
        }
    }

    public List<EventDbModel> queryAllList(boolean z10) {
        List<EventDbModel> queryList;
        synchronized (this) {
            try {
                try {
                    fixDatabaseCode14();
                    From from = SQLite.select(new IProperty[0]).from(EventDbModel.class);
                    Transformable transformable = from;
                    if (!z10) {
                        transformable = from.where(EventDbModel_Table.reporting.eq((Property<Boolean>) Boolean.FALSE));
                    }
                    queryList = transformable.orderBy(NameAlias.of(AnalyticsConfig.RTD_START_TIME), true).limit(1000).queryList();
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return new ArrayList();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return queryList;
    }

    public long queryAllSize() {
        long count;
        synchronized (this) {
            try {
                try {
                    fixDatabaseCode14();
                    count = SQLite.select(new IProperty[0]).from(EventDbModel.class).count();
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return 0L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return count;
    }

    public long queryAllSizeIntactEvent() {
        long count;
        synchronized (this) {
            try {
                try {
                    fixDatabaseCode14();
                    From from = SQLite.select(new IProperty[0]).from(EventDbModel.class);
                    Property<Boolean> property = EventDbModel_Table.notIntactEvent;
                    Boolean bool = Boolean.FALSE;
                    count = from.where(property.eq((Property<Boolean>) bool), EventDbModel_Table.reporting.eq((Property<Boolean>) bool)).count();
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return 0L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return count;
    }

    public List<EventDbModel> queryByEventId(String str) {
        List<EventDbModel> queryList;
        synchronized (this) {
            try {
                try {
                    fixDatabaseCode14();
                    queryList = SQLite.select(new IProperty[0]).from(EventDbModel.class).where(EventDbModel_Table.eventId.eq((Property<String>) str)).orderBy(NameAlias.of(AnalyticsConfig.RTD_START_TIME), true).queryList();
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return new ArrayList();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return queryList;
    }

    public EventDbModel queryByEventIdAndTime(String str, long j10) {
        EventDbModel eventDbModel;
        synchronized (this) {
            try {
                try {
                    fixDatabaseCode14();
                    eventDbModel = (EventDbModel) SQLite.select(new IProperty[0]).from(EventDbModel.class).where(EventDbModel_Table.eventId.eq((Property<String>) str), EventDbModel_Table.startTime.eq((Property<Long>) Long.valueOf(j10))).querySingle();
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return eventDbModel;
    }

    public List<EventDbModel> queryLimitNum(boolean z10) {
        List<EventDbModel> queryList;
        synchronized (this) {
            try {
                try {
                    fixDatabaseCode14();
                    From from = SQLite.select(new IProperty[0]).from(EventDbModel.class);
                    queryList = (z10 ? from.where(EventDbModel_Table.notIntactEvent.notEq((Property<Boolean>) Boolean.TRUE)) : from.where(EventDbModel_Table.notIntactEvent.notEq((Property<Boolean>) Boolean.TRUE), EventDbModel_Table.reporting.eq((Property<Boolean>) Boolean.FALSE))).limit(1000).orderBy(NameAlias.of(AnalyticsConfig.RTD_START_TIME), true).queryList();
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return new ArrayList();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return queryList;
    }

    public long queryListSize() {
        synchronized (this) {
            fixDatabaseCode14();
            try {
                From from = SQLite.select(new IProperty[0]).from(EventDbModel.class);
                Property<Boolean> property = EventDbModel_Table.notIntactEvent;
                Boolean bool = Boolean.FALSE;
                from.where(property.eq((Property<Boolean>) bool), EventDbModel_Table.reporting.eq((Property<Boolean>) bool)).queryList();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return 0L;
    }

    public boolean saveEvent(EventDbModel eventDbModel) {
        boolean z10;
        synchronized (this) {
            fixDatabaseCode14();
            try {
                z10 = eventDbModel.save();
            } catch (Exception e10) {
                e10.printStackTrace();
                z10 = false;
            }
        }
        return z10;
    }

    public void updateAllEvent(List<EventDbModel> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        synchronized (this) {
            try {
                fixDatabaseCode14();
                FlowManager.getDatabase((Class<?>) BBDatabase.class).executeTransaction(new ProcessModelTransaction.Builder(new ProcessModelTransaction.ProcessModel<EventDbModel>() { // from class: com.bigbee.db.DbOperations.7
                    @Override // com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.ProcessModel
                    public void processModel(EventDbModel eventDbModel, DatabaseWrapper databaseWrapper) {
                        EventDbModel eventDbModel2;
                        if (eventDbModel != null) {
                            long j10 = eventDbModel.startTime;
                            if (j10 > 0) {
                                long j11 = eventDbModel.endTime;
                                if (j11 != 0 && j10 > j11) {
                                    eventDbModel.endTime = 1 + j10;
                                }
                                try {
                                    eventDbModel2 = DbOperations.this.queryByEventIdAndTime(eventDbModel.eventId, j10);
                                } catch (Exception e10) {
                                    e10.printStackTrace();
                                    eventDbModel2 = null;
                                }
                                if (eventDbModel2 == null) {
                                    try {
                                        eventDbModel.save();
                                        return;
                                    } catch (Exception e11) {
                                        e11.printStackTrace();
                                        return;
                                    }
                                }
                                eventDbModel2.endTime = eventDbModel.endTime;
                                eventDbModel2.cipherStr = eventDbModel.cipherStr;
                                eventDbModel2.commonStr = eventDbModel.commonStr;
                                eventDbModel2.notIntactEvent = eventDbModel.notIntactEvent;
                                eventDbModel2.reserveA = eventDbModel.reserveA;
                                eventDbModel2.reserveB = eventDbModel.reserveB;
                                try {
                                    eventDbModel2.update();
                                } catch (Exception e12) {
                                    e12.printStackTrace();
                                }
                            }
                        }
                    }
                }).addAll(list).build());
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public void updateAllReportingStatus(boolean z10) {
        synchronized (this) {
            fixDatabaseCode14();
            try {
                SQLite.update(EventDbModel.class).set(EventDbModel_Table.reporting.is((Property<Boolean>) Boolean.valueOf(z10))).execute();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public void updateEvent(EventDbModel eventDbModel) {
        if (eventDbModel == null || eventDbModel.startTime <= 0) {
            return;
        }
        synchronized (this) {
            fixDatabaseCode14();
        }
        try {
            EventDbModel queryByEventIdAndTime = queryByEventIdAndTime(eventDbModel.eventId, eventDbModel.startTime);
            long j10 = eventDbModel.endTime;
            if (j10 != 0) {
                long j11 = eventDbModel.startTime;
                if (j11 > j10) {
                    eventDbModel.endTime = j11 + 1;
                }
            }
            if (queryByEventIdAndTime == null) {
                saveEvent(eventDbModel);
                return;
            }
            queryByEventIdAndTime.endTime = eventDbModel.endTime;
            queryByEventIdAndTime.cipherStr = eventDbModel.cipherStr;
            queryByEventIdAndTime.commonStr = eventDbModel.commonStr;
            queryByEventIdAndTime.notIntactEvent = eventDbModel.notIntactEvent;
            queryByEventIdAndTime.reserveA = eventDbModel.reserveA;
            queryByEventIdAndTime.reserveB = eventDbModel.reserveB;
            synchronized (this) {
                try {
                    queryByEventIdAndTime.update();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void updateReportingStatus(List<EventDbModel> list, final boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        synchronized (this) {
            try {
                fixDatabaseCode14();
                FlowManager.getDatabase((Class<?>) BBDatabase.class).executeTransaction(new ProcessModelTransaction.Builder(new ProcessModelTransaction.ProcessModel<EventDbModel>() { // from class: com.bigbee.db.DbOperations.6
                    @Override // com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction.ProcessModel
                    public void processModel(EventDbModel eventDbModel, DatabaseWrapper databaseWrapper) {
                        if (eventDbModel != null) {
                            eventDbModel.reporting = z10;
                            try {
                                eventDbModel.update();
                            } catch (Exception e10) {
                                e10.printStackTrace();
                            }
                        }
                    }
                }).addAll(list).build());
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public void deleteEvent(EventDbModel eventDbModel) {
        if (eventDbModel != null) {
            synchronized (this) {
                fixDatabaseCode14();
                eventDbModel.delete();
            }
        }
    }

    public void updateEvent(String str, long j10, long j11) {
        synchronized (this) {
            fixDatabaseCode14();
            SQLite.update(EventDbModel.class).set(EventDbModel_Table.endTime.is((Property<Long>) Long.valueOf(j10))).where(EventDbModel_Table.eventId.is((Property<String>) str), EventDbModel_Table.startTime.is((Property<Long>) Long.valueOf(j11))).execute();
        }
    }
}
