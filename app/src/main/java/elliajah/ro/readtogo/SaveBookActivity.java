package elliajah.ro.readtogo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import elliajah.ro.readtogo.elliajah.ro.readtogo.sqlite.BookModel;
import elliajah.ro.readtogo.elliajah.ro.readtogo.sqlite.SqliteBookHelper;

public class SaveBookActivity extends AppCompatActivity {
private Button saveBttn,showBttn;
private EditText numeText, autorText, edituraText;
    private SqliteBookHelper sqliteBookTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_book);

        showBttn=findViewById(R.id.showBttn);
        numeText=findViewById(R.id.numeTxt);
        autorText=findViewById(R.id.autorTxt);
        edituraText=findViewById(R.id.edituraTxt);
        saveBttn=findViewById(R.id.saveBttn);
        sqliteBookTable=new SqliteBookHelper(this);
        saveBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edituraText.getText().toString().isEmpty()) {
                    sqliteBookTable.saveBookSimple(numeText.getText().toString(), autorText.getText().toString(), null);
                }else {
                    sqliteBookTable.saveBookSimple(numeText.getText().toString(), autorText.getText().toString(), edituraText.getText().toString());
                }
            }
        });

    showBttn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            List<BookModel> books= sqliteBookTable.getBooks();
            for(BookModel book : books) {
                Toast.makeText(SaveBookActivity.this, book.toString(), Toast.LENGTH_LONG).show();
            }
        }
    });

    }
}
