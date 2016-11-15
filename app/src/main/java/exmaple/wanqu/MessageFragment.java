package exmaple.wanqu;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {
    private TextView textView1,textView2;

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView1 = (TextView) getActivity().findViewById(R.id.msg_register);
        textView2 = (TextView) getActivity().findViewById(R.id.msg_login);
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view = getActivity().getLayoutInflater().inflate(R.layout.register_box,null);
                builder1.setView(view);
                builder1.create().show();
            }
        });

        final AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity());
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view = getActivity().getLayoutInflater().inflate(R.layout.login_box,null);
                builder2.setView(view);
                builder2.create().show();
            }
        });
    }
}
