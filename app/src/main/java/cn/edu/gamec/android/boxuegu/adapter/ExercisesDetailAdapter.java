package cn.edu.gamec.android.boxuegu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.gamec.android.boxuegu.R;
import cn.edu.gamec.android.boxuegu.bean.ExercisesBean;
import cn.edu.gamec.android.boxuegu.utils.AnalysisUtils;

/**
 * Created by student on 17/12/26.
 */

public class ExercisesDetailAdapter extends BaseAdapter{
    public Context mContext;
    public List<ExercisesBean> ebl;
    public OnSelectListener onSelectListener;
    public ExercisesDetailAdapter(Context context,OnSelectListener onSelectListener){
        this.mContext = context;
        this.onSelectListener = onSelectListener;
    }
    public void setData(List<ExercisesBean> ebl){
        this.ebl = ebl;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return ebl == null ? 0 : ebl.size();
    }

    @Override
    public ExercisesBean getItem(int position) {
        return ebl == null ? null : ebl.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    private ArrayList<String> selectedPosition = new ArrayList<String>();

    @Override
    public View getView(final int position, View convertview, ViewGroup parent) {
        final ViewHolder vh;
        if (convertview == null){
            vh = new ViewHolder();
            convertview = LayoutInflater.from(mContext).inflate(
                   R.layout.exercises_detail_list_item, null);
            vh.subject = (TextView) convertview.findViewById(R.id.tv_subject);
            vh.tv_a = (TextView) convertview.findViewById(R.id.tv_a);
            vh.tv_b = (TextView) convertview.findViewById(R.id.tv_b);
            vh.tv_c = (TextView) convertview.findViewById(R.id.tv_c);
            vh.tv_d = (TextView) convertview.findViewById(R.id.tv_d);
            vh.iv_a = (ImageView) convertview.findViewById(R.id.iv_a);
            vh.iv_b = (ImageView) convertview.findViewById(R.id.iv_b);
            vh.iv_c = (ImageView) convertview.findViewById(R.id.iv_c);
            vh.iv_d = (ImageView) convertview.findViewById(R.id.iv_d);
            convertview.setTag(vh);
        }else{
            vh = (ViewHolder) convertview.getTag();
        }
        final ExercisesBean bean = getItem(position);
        if (bean != null){
            vh.subject.setText(bean.subject);
            vh.tv_a.setText(bean.a);
            vh.tv_b.setText(bean.b);
            vh.tv_c.setText(bean.c);
            vh.tv_d.setText(bean.d);
        }
        if (!selectedPosition.contains(""+ position)){
            vh.iv_a.setImageResource(R.drawable.exercises_a);
            vh.iv_b.setImageResource(R.drawable.exercises_b);
            vh.iv_c.setImageResource(R.drawable.exercises_c);
            vh.iv_d.setImageResource(R.drawable.exercises_d);
            AnalysisUtils.setABCDEnable(true,vh.iv_a,vh.iv_b,vh.iv_c,vh.iv_d);
        }else {
            AnalysisUtils.setABCDEnable(false,vh.iv_a,vh.iv_b,vh.iv_c,vh.iv_d);
            switch (bean.select){
                case 0:
                    if (bean.answer == 1){
                        vh.iv_a.setImageResource(R.drawable.exercises_right_icon);
                        vh.iv_b.setImageResource(R.drawable.exercises_b);
                        vh.iv_c.setImageResource(R.drawable.exercises_c);
                        vh.iv_d.setImageResource(R.drawable.exercises_d);
                    }else if (bean.answer == 2){
                        vh.iv_a.setImageResource(R.drawable.exercises_a);
                        vh.iv_b.setImageResource(R.drawable.exercises_right_icon);
                        vh.iv_c.setImageResource(R.drawable.exercises_c);
                        vh.iv_d.setImageResource(R.drawable.exercises_d);
                    }else if (bean.answer == 3){
                        vh.iv_a.setImageResource(R.drawable.exercises_a);
                        vh.iv_b.setImageResource(R.drawable.exercises_b);
                        vh.iv_c.setImageResource(R.drawable.exercises_right_icon);
                        vh.iv_d.setImageResource(R.drawable.exercises_d);
                    }else if (bean.answer == 4){
                        vh.iv_a.setImageResource(R.drawable.exercises_a);
                        vh.iv_b.setImageResource(R.drawable.exercises_b);
                        vh.iv_c.setImageResource(R.drawable.exercises_c);
                        vh.iv_d.setImageResource(R.drawable.exercises_right_icon);
                    }
                    break;
                case 1:
                    vh.iv_a.setImageResource(R.drawable.exercises_error_icon);
                    if (bean.answer == 2){
                        vh.iv_b.setImageResource(R.drawable.exercises_right_icon);
                        vh.iv_c.setImageResource(R.drawable.exercises_c);
                        vh.iv_d.setImageResource(R.drawable.exercises_d);
                    }else if (bean.answer == 3){
                        vh.iv_b.setImageResource(R.drawable.exercises_b);
                        vh.iv_c.setImageResource(R.drawable.exercises_right_icon);
                        vh.iv_d.setImageResource(R.drawable.exercises_d);
                    }else if (bean.answer == 4){
                        vh.iv_b.setImageResource(R.drawable.exercises_b);
                        vh.iv_c.setImageResource(R.drawable.exercises_c);
                        vh.iv_d.setImageResource(R.drawable.exercises_right_icon);
                    }
                    break;
                case 2:
                    vh.iv_b.setImageResource(R.drawable.exercises_error_icon);
                    if (bean.answer == 1){
                        vh.iv_a.setImageResource(R.drawable.exercises_right_icon);
                        vh.iv_c.setImageResource(R.drawable.exercises_c);
                        vh.iv_d.setImageResource(R.drawable.exercises_d);
                    }else if (bean.answer == 3){
                        vh.iv_a.setImageResource(R.drawable.exercises_b);
                        vh.iv_c.setImageResource(R.drawable.exercises_right_icon);
                        vh.iv_d.setImageResource(R.drawable.exercises_d);
                    }else if (bean.answer == 4){
                        vh.iv_a.setImageResource(R.drawable.exercises_b);
                        vh.iv_c.setImageResource(R.drawable.exercises_c);
                        vh.iv_d.setImageResource(R.drawable.exercises_right_icon);
                    }
                    break;
                case 3:
                    vh.iv_b.setImageResource(R.drawable.exercises_error_icon);
                    if (bean.answer == 1){
                        vh.iv_a.setImageResource(R.drawable.exercises_right_icon);
                        vh.iv_b.setImageResource(R.drawable.exercises_c);
                        vh.iv_d.setImageResource(R.drawable.exercises_d);
                    }else if (bean.answer == 2){
                        vh.iv_a.setImageResource(R.drawable.exercises_b);
                        vh.iv_b.setImageResource(R.drawable.exercises_right_icon);
                        vh.iv_d.setImageResource(R.drawable.exercises_d);
                    }else if (bean.answer == 4){
                        vh.iv_a.setImageResource(R.drawable.exercises_b);
                        vh.iv_b.setImageResource(R.drawable.exercises_c);
                        vh.iv_d.setImageResource(R.drawable.exercises_right_icon);
                    }
                    break;
                case 4:
                    vh.iv_d.setImageResource(R.drawable.exercises_error_icon);
                    if (bean.answer == 1){
                        vh.iv_a.setImageResource(R.drawable.exercises_right_icon);
                        vh.iv_b.setImageResource(R.drawable.exercises_c);
                        vh.iv_c.setImageResource(R.drawable.exercises_d);
                    }else if (bean.answer == 2){
                        vh.iv_a.setImageResource(R.drawable.exercises_b);
                        vh.iv_b.setImageResource(R.drawable.exercises_right_icon);
                        vh.iv_c.setImageResource(R.drawable.exercises_d);
                    }else if (bean.answer == 3){
                        vh.iv_a.setImageResource(R.drawable.exercises_b);
                        vh.iv_b.setImageResource(R.drawable.exercises_c);
                        vh.iv_c.setImageResource(R.drawable.exercises_right_icon);
                    }
                    break;
                default:
                    break;

            }

        }
        vh.iv_a.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (selectedPosition.contains("" + position)){
                    selectedPosition.remove("" + position);
                }else {
                    selectedPosition.add(position + "");
                }
                onSelectListener.onSelectA(position, vh.iv_a,vh.iv_b,vh.iv_c,vh.iv_d);
            }
        });
        vh.iv_b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (selectedPosition.contains("" + position)){
                    selectedPosition.remove("" + position);
                }else {
                    selectedPosition.add(position + "");
                }
                onSelectListener.onSelectB(position, vh.iv_a,vh.iv_b,vh.iv_c,vh.iv_d);
            }
        });
        vh.iv_c.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (selectedPosition.contains("" + position)){
                    selectedPosition.remove("" + position);
                }else {
                    selectedPosition.add(position + "");
                }
                onSelectListener.onSelectC(position, vh.iv_a,vh.iv_b,vh.iv_c,vh.iv_d);
            }
        });
        vh.iv_d.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (selectedPosition.contains("" + position)){
                    selectedPosition.remove("" + position);
                }else {
                    selectedPosition.add(position + "");
                }
                onSelectListener.onSelectD(position, vh.iv_a,vh.iv_b,vh.iv_c,vh.iv_d);
            }
        });
        return convertview;
    }

    public interface OnSelectListener {
        public void onSelectA(int position,
                              ImageView iv_a,
                              ImageView iv_b,
                              ImageView iv_c,
                              ImageView iv_d);

        public void onSelectB(int position,
                              ImageView iv_a,
                              ImageView iv_b,
                              ImageView iv_c,
                              ImageView iv_d);

        public void onSelectC(int position,
                              ImageView iv_a,
                              ImageView iv_b,
                              ImageView iv_c,
                              ImageView iv_d);

        public void onSelectD(int position,
                              ImageView iv_a,
                              ImageView iv_b,
                              ImageView iv_c,
                              ImageView iv_d);
    }

    public class ViewHolder {
        public TextView subject,tv_a,tv_b,tv_c,tv_d;
        public ImageView iv_a,iv_b,iv_c,iv_d;
    }


}
