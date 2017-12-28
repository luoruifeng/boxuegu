package cn.edu.gamec.android.boxuegu.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.BreakIterator;
import java.util.List;

import cn.edu.gamec.android.boxuegu.R;
import cn.edu.gamec.android.boxuegu.activity.VideoPlayActivity;
import cn.edu.gamec.android.boxuegu.bean.CourseBean;

/**
 * Created by student on 17/12/27.
 */

public class CourseAdapter extends BaseAdapter{
    private Context mContext;
    private List<List<CourseBean>> cbl;
    public CourseAdapter(Context context){
        this.mContext=context;
    }
    public void setData(List<List<CourseBean>> cbl){
        this.cbl = cbl;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return cbl == null ? 0 : cbl.size();
    }

    @Override
    public List<CourseBean> getItem(int position) {
        return cbl == null ? null : cbl.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            vh = new ViewHolder();
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.course_list_item, null);
            vh.iv_left_img = (ImageView) convertView.findViewById(R.id.iv_left_img);
            vh.iv_right_img = (ImageView) convertView.findViewById(R.id.iv_right_img);
            vh.tv_left_img_title = (TextView) convertView.findViewById(R.id.tv_left_img_title);
            vh.tv_left_title = (TextView) convertView.findViewById(R.id.tv_left_title);
            vh.tv_right_img_title = (TextView) convertView.findViewById(R.id.tv_right_img_title);
            vh.tv_right_title = (TextView) convertView.findViewById(R.id.tv_right_title);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        final List<CourseBean> list = getItem(position);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                final CourseBean bean = list.get(i);
                switch (i) {
                    case 0:
                        vh.tv_left_img_title.setText(bean.imgTitle);
                        vh.tv_left_title.setText(bean.title);
                        setLeftImg(bean.id, vh.iv_left_img);
                        vh.iv_left_img.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(mContext,
                                        VideoPlayActivity.class);
                                intent.putExtra("id", bean.id);
                                intent.putExtra("intro", bean.intro);
                                mContext.startActivity(intent);
                            }
                        });
                        break;
                    case 1:
                        vh.tv_right_img_title.setText(bean.imgTitle);
                        vh.tv_right_title.setText(bean.title);
                        setRightImg(bean.id, vh.iv_right_img);
                        vh.iv_right_img.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(mContext,
                                        VideoPlayActivity.class);
                                intent.putExtra("id", bean.id);
                                intent.putExtra("intro", bean.intro);
                                mContext.startActivity(intent);
                            }
                        });
                        break;
                    default:
                        break;
                }
            }
        }
        return convertView;
    }



    private void setLeftImg(int id, ImageView iv_left_img) {
        switch (id){
            case 1:
                iv_left_img.setImageResource(R.drawable.chapter_1_icon);
                break;
            case 3:
                iv_left_img.setImageResource(R.drawable.chapter_3_icon);
                break;
            case 5:
                iv_left_img.setImageResource(R.drawable.chapter_5_icon);
                break;
            case 7:
                iv_left_img.setImageResource(R.drawable.chapter_7_icon);
                break;
            case 9:
                iv_left_img.setImageResource(R.drawable.chapter_9_icon);
                break;
        }

    }
    private void setRightImg(int id, ImageView iv_right_img) {
        switch (id){
            case 2:
                iv_right_img.setImageResource(R.drawable.chapter_2_icon);
                break;
            case 4:
                iv_right_img.setImageResource(R.drawable.chapter_4_icon);
                break;
            case 6:
                iv_right_img.setImageResource(R.drawable.chapter_6_icon);
                break;
            case 8:
                iv_right_img.setImageResource(R.drawable.chapter_8_icon);
                break;
            case 10:
                iv_right_img.setImageResource(R.drawable.chapter_10_icon);
                break;
        }
    }
    class ViewHolder{

        public ImageView iv_left_img;
        public ImageView iv_right_img;
        public TextView tv_left_img_title;
        public TextView tv_left_title;
        public TextView tv_right_img_title;
        public TextView tv_right_title;

    }
}
