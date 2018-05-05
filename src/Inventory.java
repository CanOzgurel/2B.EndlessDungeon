import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> inventory;

    public Inventory()
    {
       inventory = new ArrayList<>();
    }

    public void addItem(int type)
    {
        Item item = new Item(type);
        inventory.add(item);
    }

    public boolean containsItem(int type)
    {
        boolean contains = false;

        for(Item item : inventory )
        {
            if(item.getItem() == type)
                contains = true;
        }

        return contains;
    }


}
