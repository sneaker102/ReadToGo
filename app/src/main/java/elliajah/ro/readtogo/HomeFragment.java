package elliajah.ro.readtogo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HomeFragment extends Fragment {
    private HomeFragment.OnFragmentInteractionListener listener;
    private ImageView finishedBooksImg;
    private static HomeFragment fragment;
    private Activity mActivity;



    public static HomeFragment newInstance() {

        if (fragment == null) {
            fragment = new HomeFragment();
        }
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        finishedBooksImg = view.findViewById(R.id.finishedBooksImg);


        finishedBooksImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onHomeFragmentInteraction("finished_books");

            }
        });
        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            mActivity = (Activity) context;
        }
        if (context instanceof HomeFragment.OnFragmentInteractionListener) {
            listener = (HomeFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
        mActivity = null;
    }

    public interface OnFragmentInteractionListener {
        void onHomeFragmentInteraction(String sendBackText);
    }
}
