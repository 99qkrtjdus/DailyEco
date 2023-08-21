package com.example.sample;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class CalendarAdapter extends RecyclerView.Adapter {

    private SimpleDateFormat onlyDate=new SimpleDateFormat("yyyy-MM-dd");

    private final int HEADER_TYPE = 0;
    private final int EMPTY_TYPE = 1;
    private final int DAY_TYPE = 2;
    public boolean isTime = true;

    public List<String> holoday = new ArrayList<>();
    public List<DayModel> mCalendarList;

    private Context mContext;

    private NumberFormat numformat = NumberFormat.getIntegerInstance();
    String today;

    String from = "2022-11-26";

    public CalendarAdapter(Context context) {
        numformat.setMinimumIntegerDigits(2);
        mContext = context;

        Date currentTime = Calendar.getInstance().getTime();
        today = onlyDate.format(currentTime);
    }

    @Override
    public int getItemViewType(int position) { //뷰타입 나누기
        DayModel item = mCalendarList.get(position);

        if (item.getType() == 102031) {
            return EMPTY_TYPE; // 비어있는 일자 타입
        } else {
            return DAY_TYPE; // 일자 타입

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new com.example.sample.DayViewHolder(inflater.inflate(R.layout.viewholder_day, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        int viewType = getItemViewType(position);
        com.example.sample.DayViewHolder holder = (com.example.sample.DayViewHolder) viewHolder;

        if (viewType == EMPTY_TYPE)
        {
            if(position%7 == 0)
            {
                if(today.equals(onlyDate.format(mCalendarList.get(position).getCalendarModel().getTime())))
                {
                    holder.mainLL.setBackgroundResource(R.drawable.maincolor);
                }
                else {

                    holder.mainLL.setBackgroundResource(R.drawable.background_border_top);
                }
            }
            else
            {
                if(today.equals(onlyDate.format(mCalendarList.get(position).getCalendarModel().getTime())))
                {
                    holder.mainLL.setBackgroundResource(R.drawable.background_border_top_blue);
                }
                else {

                    holder.mainLL.setBackgroundResource(R.drawable.background_border_left_top);
                }
            }


            holder.timeText.setBackground(null);
            holder.timeText.setTextColor(mContext.getResources().getColor(R.color.disable_color));



            try {
                SimpleDateFormat formatter = new SimpleDateFormat("d");
                Date d = new Date(mCalendarList.get(position).getCalendarModel().getTimeInMillis());
                holder.dayText.setText(formatter.format(d).toUpperCase());


                Calendar cal = Calendar.getInstance();
                cal.setTime(d);

                int dayNum = cal.get(Calendar.DAY_OF_WEEK);

                if(holoday.contains(onlyDate.format(d)) || dayNum == 1)
                {
                    holder.dayText.setTextColor(Color.RED);
                }
                else
                {
                    holder.dayText.setTextColor(mContext.getResources().getColor(R.color.disable_color));
                }
            } catch (Exception e) {
                holder.dayText.setText("");
            }
        }
        else if (viewType == DAY_TYPE) {

            if(position%7 == 0)
            {

                if(today.equals(onlyDate.format(mCalendarList.get(position).getCalendarModel().getTime())))
                {
                    holder.mainLL.setBackgroundResource(R.drawable.blackline);
                }
                else {

                    holder.mainLL.setBackgroundResource(R.drawable.background_border_top);
                }
            }
            else
            {
                if(from.equals(onlyDate.format(mCalendarList.get(position).getCalendarModel().getTime())))
                {
                    holder.mainLL.setBackgroundResource(R.drawable.background_border_abc); //투데이
                }
                else {

                    holder.mainLL.setBackgroundResource(R.drawable.background_border_left_top);
                }
            }


            holder.timeText.setBackground(null);
            holder.timeText.setTextColor(mContext.getResources().getColor(R.color.time_color));



            try {
                SimpleDateFormat formatter = new SimpleDateFormat("d");
                Date d = new Date(mCalendarList.get(position).getCalendarModel().getTimeInMillis());
                holder.dayText.setText(formatter.format(d).toUpperCase());


                Calendar cal = Calendar.getInstance();
                cal.setTime(d);

                int dayNum = cal.get(Calendar.DAY_OF_WEEK);

                if(holoday.contains(onlyDate.format(d)) || dayNum == 1)
                {
                    holder.dayText.setTextColor(Color.RED);
                }
                else
                {
                    holder.dayText.setTextColor(mContext.getResources().getColor(R.color.color_text));
                }
            } catch (Exception e) {
                holder.dayText.setText("");
            }

        }

    }

    @Override
    public int getItemCount() {
        if (mCalendarList != null) {
            return mCalendarList.size();
        }
        return 0;
    }

}
