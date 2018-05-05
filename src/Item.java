public class Item {

    public static final int  HEALINGPOTION = 1;
    public static final int   PLATEMAIL = 2;
    public static final int  DRAGONSWORD = 3;
    public static final int   SCROLLOFKNOWLEDGE = 4;



    public int type;

    public Item( int item)
    {
        type = item;
    }

    public int getItem()
    {
        return type;
    }
}
