package fpoly.ph53095.assignment.models;

public class phongban {
    private int imgavata;
    private String tvname;

    public phongban(int imgavata, String tvname) {
        this.imgavata = imgavata;
        this.tvname = tvname;
    }

    public int getImgavata() {
        return imgavata;
    }

    public void setImgavata(int imgavata) {
        this.imgavata = imgavata;
    }

    public String getTvname() {
        return tvname;
    }

    public void setTvname(String tvname) {
        this.tvname = tvname;
    }
}
