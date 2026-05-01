package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R;
import java.util.Iterator;

/* loaded from: classes2.dex */
class MonthAdapter extends BaseAdapter {
    static final int MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
    final CalendarConstraints calendarConstraints;
    CalendarStyle calendarStyle;
    final DateSelector<?> dateSelector;
    final Month month;

    public MonthAdapter(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.month = month;
        this.dateSelector = dateSelector;
        this.calendarConstraints = calendarConstraints;
    }

    private void initializeStyles(Context context) {
        if (this.calendarStyle == null) {
            this.calendarStyle = new CalendarStyle(context);
        }
    }

    public int dayToPosition(int i10) {
        return firstPositionInMonth() + (i10 - 1);
    }

    public int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.month.daysInMonth + firstPositionInMonth();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10 / this.month.daysInWeek;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public boolean isFirstInRow(int i10) {
        return i10 % this.month.daysInWeek == 0;
    }

    public boolean isLastInRow(int i10) {
        return (i10 + 1) % this.month.daysInWeek == 0;
    }

    public int lastPositionInMonth() {
        return (this.month.daysFromStartOfWeekToFirstOfMonth() + this.month.daysInMonth) - 1;
    }

    public int positionToDay(int i10) {
        return (i10 - this.month.daysFromStartOfWeekToFirstOfMonth()) + 1;
    }

    public boolean withinMonth(int i10) {
        return i10 >= firstPositionInMonth() && i10 <= lastPositionInMonth();
    }

    @Override // android.widget.Adapter
    public Long getItem(int i10) {
        if (i10 < this.month.daysFromStartOfWeekToFirstOfMonth() || i10 > lastPositionInMonth()) {
            return null;
        }
        return Long.valueOf(this.month.getDay(positionToDay(i10)));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextView getView(int i10, View view, ViewGroup viewGroup) {
        Long item;
        initializeStyles(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day, viewGroup, false);
        }
        int firstPositionInMonth = i10 - firstPositionInMonth();
        if (firstPositionInMonth >= 0) {
            Month month = this.month;
            if (firstPositionInMonth < month.daysInMonth) {
                int i11 = firstPositionInMonth + 1;
                textView.setTag(month);
                textView.setText(String.valueOf(i11));
                long day = this.month.getDay(i11);
                if (this.month.year == Month.today().year) {
                    textView.setContentDescription(DateStrings.getMonthDayOfWeekDay(day));
                } else {
                    textView.setContentDescription(DateStrings.getYearMonthDayOfWeekDay(day));
                }
                textView.setVisibility(0);
                textView.setEnabled(true);
                item = getItem(i10);
                if (item != null) {
                    return textView;
                }
                if (!this.calendarConstraints.getDateValidator().isValid(item.longValue())) {
                    textView.setEnabled(false);
                    this.calendarStyle.invalidDay.styleItem(textView);
                    return textView;
                }
                textView.setEnabled(true);
                Iterator<Long> it = this.dateSelector.getSelectedDays().iterator();
                while (it.hasNext()) {
                    if (UtcDates.canonicalYearMonthDay(item.longValue()) == UtcDates.canonicalYearMonthDay(it.next().longValue())) {
                        this.calendarStyle.selectedDay.styleItem(textView);
                        return textView;
                    }
                }
                if (UtcDates.getTodayCalendar().getTimeInMillis() == item.longValue()) {
                    this.calendarStyle.todayDay.styleItem(textView);
                    return textView;
                }
                this.calendarStyle.day.styleItem(textView);
                return textView;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        item = getItem(i10);
        if (item != null) {
        }
    }
}
