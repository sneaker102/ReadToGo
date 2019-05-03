package elliajah.ro.readtogo.elliajah.ro.readtogo.sqlite;

public class BookModel {
    public static final String TABLE_NAME = "books";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AUTHOR = "author";
    public static final String COLUMN_GENRE = "genre";
    public static final String COLUMN_GRADE = "grade";
    public static final String COLUMN_PERSONAL_NOTES = "personal_notes";
    public static final String COLUMN_EDITURA="editura";
    public static final String COLUMN_IS_FINISHED="is_finished";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String SELECT_ALL_QUERY = "SELECT * FROM "+TABLE_NAME;

    private int id,mIsFinished;
    private String mName,mAuthor,mGenre,mGrade,mPersonalNotes,mEditura,mTimesStamp;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + " TEXT NOT NULL,"
                    +COLUMN_AUTHOR + " TEXT NOT NULL,"
                    +COLUMN_GENRE + " TEXT,"
                    +COLUMN_GRADE + " INTEGER,"
                    +COLUMN_PERSONAL_NOTES + " TEXT,"
                    +COLUMN_EDITURA + " TEXT,"
                    +COLUMN_IS_FINISHED +  " INTEGER,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public BookModel(int id, String mName, String mAuthor, String mGenre, String mGrade, String mPersonalNotes,int mIsFinished,String mEditura ,String mTimesStamp){
        this.id=id;
        this.mName=mName;
        this.mAuthor=mAuthor;
        this.mGenre=mGenre;
        this.mGrade=mGrade;
        this.mPersonalNotes=mPersonalNotes;
        this.mEditura=mEditura;
        this.mIsFinished=mIsFinished;
        this.mTimesStamp=mTimesStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmEditura() {
        return mEditura;
    }

    public void setmEditura(String mEditura) {
        this.mEditura = mEditura;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;

    }

    public String getmGenre() {
        return mGenre;
    }

    public void setmGenre(String mGenre) {
        this.mGenre = mGenre;
    }

    public String getmGrade() {
        return mGrade;
    }

    public int getmIsFinished() {
        return mIsFinished;
    }

    public void setmIsFinished(int mIsFinished) {
        this.mIsFinished = mIsFinished;
    }

    public void setmGrade(String mGrade) {
        this.mGrade = mGrade;
    }

    public String getmPersonalNotes() {
        return mPersonalNotes;
    }

    public void setmPersonalNotes(String mPersonalNotes) {
        this.mPersonalNotes = mPersonalNotes;
    }

    public String getmTimesStamp() {
        return mTimesStamp;
    }

    public void setmTimesStamp(String mTimesStamp) {
        this.mTimesStamp = mTimesStamp;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "id=" + id +
                ", mIsFinished=" + mIsFinished +
                ", mName='" + mName + '\'' +
                ", mAuthor='" + mAuthor + '\'' +
                ", mGenre='" + mGenre + '\'' +
                ", mGrade='" + mGrade + '\'' +
                ", mPersonalNotes='" + mPersonalNotes + '\'' +
                ", mEditura='" + mEditura + '\'' +
                ", mTimesStamp='" + mTimesStamp + '\'' +
                '}';
    }
}
