package elliajah.ro.readtogo;

public class BookListComponent {
    private String mNume;
    private String mAutor;
    private int imgId;

    public BookListComponent(String mNume, String mAutor, int imgId) {
        this.mNume = mNume;
        this.mAutor = mAutor;
        this.imgId = imgId;
    }

    public String getmNume() {
        return mNume;
    }

    public void setmNume(String mNume) {
        this.mNume = mNume;
    }

    public String getmAutor() {
        return mAutor;
    }

    public void setmAutor(String mAutor) {
        this.mAutor = mAutor;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
