package exmaple.wanqu;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {

    private GridView gridView;
    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridView = (GridView) getActivity().findViewById(R.id.grid_view);
        gridView.setAdapter(new MyGridViewAdapter());
    }

    private class MyGridViewAdapter extends BaseAdapter {
        String [] text = {"周边户外","少儿兴趣","diy","健身活动","节日/市集","沙龙讲座"
                ,"多人聚会","品茶/美食","展会","演出"};
        int [] images = {R.drawable.book,R.drawable.book
                ,R.drawable.book,R.drawable.book
                ,R.drawable.book,R.drawable.book,
                R.drawable.book,R.drawable.book,
                R.drawable.book,R.drawable.book};
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return text[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder;
            if (view==null){
                view = getActivity().getLayoutInflater()
                        .inflate(R.layout.grid_item,null);
                holder = new ViewHolder();
                holder.imgHold = (ImageView) view.findViewById(R.id.grid_img);
                holder.txtHold = (TextView) view.findViewById(R.id.grid_txt);
                view.setTag(holder);
            }else {
                holder = (ViewHolder) view.getTag();
            }
            holder.imgHold.setImageResource(images[i]);
            holder.txtHold.setText(text[i]);
            return view;
        }
        class ViewHolder{
            private ImageView imgHold;
            private TextView txtHold;
        }
    }
}
