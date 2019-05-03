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
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import elliajah.ro.readtogo.elliajah.ro.readtogo.sqlite.BookModel;
import elliajah.ro.readtogo.elliajah.ro.readtogo.sqlite.SqliteBookHelper;

public class FinishedBooksFragment extends Fragment {
    private OnFragmentInteractionListener listener;
    private FrameLayout root;
    private static FinishedBooksFragment fragment;
    private Activity mActivity;
    private ListView listView;
    private FinishedBooksListAdapter booksListAdapter;


    public static FinishedBooksFragment newInstance() {

        if (fragment == null) {
            fragment = new FinishedBooksFragment();
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
        final View view = inflater.inflate(R.layout.fragment_finished_books, container, false);
        root = view.findViewById(R.id.frameLayout);
        listView = view.findViewById(R.id.listView);
        SqliteBookHelper dbBook = new SqliteBookHelper(mActivity.getApplicationContext());

        List<BookListComponent> bookList = new ArrayList<>();
        List<BookModel> listOfBookModel = dbBook.getBooks();
        for (BookModel book : listOfBookModel) {
            bookList.add(new BookListComponent(book.getmName(), book.getmAuthor(), R.drawable.add_img));
        }

        booksListAdapter = new FinishedBooksListAdapter(mActivity.getApplicationContext(), 0, bookList);
        listView.setAdapter(booksListAdapter);

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFinishedBooksFragmentInteraction("home");
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
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
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
        void onFinishedBooksFragmentInteraction(String sendBackText);
    }
}
