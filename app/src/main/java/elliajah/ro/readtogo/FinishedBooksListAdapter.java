package elliajah.ro.readtogo;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FinishedBooksListAdapter extends ArrayAdapter<BookListComponent> {
    private Context mContext;
    private List<BookListComponent> moviesList = new ArrayList<>();

    public FinishedBooksListAdapter( Context context, int resource, List<BookListComponent> objects) {
        super(context, resource, objects);
        mContext=context;
        moviesList=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_component,parent,false);

        BookListComponent currentBook = moviesList.get(position);

        ImageView image = (ImageView)listItem.findViewById(R.id.addImg);
        image.setImageResource(currentBook.getImgId());

        TextView titlu = (TextView) listItem.findViewById(R.id.titluTxt);
        titlu.setText(currentBook.getmNume());

        TextView autor = (TextView) listItem.findViewById(R.id.autorTxt);
        autor.setText(currentBook.getmAutor());



        return listItem;
    }
}
