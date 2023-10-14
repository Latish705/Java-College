package Model;

public abstract class item {
    private int gst;
    public void set_gst(int gst)
    {
        this.gst=gst;
    }

    public int get_gst()
    {
        return gst;
    }
    public abstract void add_specifications(String s );
    public abstract void remove_specification(int specificaton_no);
    public abstract void display_specificatons();

}
