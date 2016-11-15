package exmaple.wanqu;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TextView txt1,txt2;
    private ListView listView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txt1 = (TextView) getActivity().findViewById(R.id.register);
        txt2 = (TextView) getActivity().findViewById(R.id.login);
        listView = (ListView) getActivity().findViewById(R.id.home_listview);

        final AlertDialog.Builder regbuilder = new AlertDialog.Builder(getActivity());
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                regbuilder.setTitle("注册");
                view = getActivity().getLayoutInflater().inflate(R.layout.register_box,null);
                regbuilder.setView(view);
//                regbuilder.setPositiveButton("注册", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(getActivity(), "eeeeee", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                regbuilder.setNegativeButton("重置", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(getActivity(), "cccccc", Toast.LENGTH_SHORT).show();
//                    }
//                });
                regbuilder.create().show();
            }
        });

        final AlertDialog.Builder logbuilder = new AlertDialog.Builder(getActivity());
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                logbuilder.setTitle("登录");
                view = getActivity().getLayoutInflater().inflate(R.layout.login_box,null);
                logbuilder.setView(view);
//                logbuilder.setPositiveButton("登录", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//                logbuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
                logbuilder.create().show();
            }
        });

//        listView.setAdapter(new MyL);
    }
}
