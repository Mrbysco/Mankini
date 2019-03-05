package matgm50.mankini.init;

import matgm50.mankini.item.ItemAAMT;
import matgm50.mankini.item.ItemBatMankini;
import matgm50.mankini.item.ItemDyeableMankini;
import matgm50.mankini.item.ItemKawaiiMankini;
import matgm50.mankini.item.ItemMankiniCannon;
import matgm50.mankini.item.ItemMankiniCapsule;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

/**
 * Created by MasterAbdoTGM50 on 4/23/2014.
 */

@EventBusSubscriber
public class ModItems {

    public static Item dyeable_mankini;
    public static Item kawaii_mankini;
    public static Item aetheric_mankini;
    public static Item mankini_cannon;
    public static Item mankini_capsule;
    public static Item bat_mankini;

	public static ArrayList<Item> ITEMS = new ArrayList<>();

	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();
        
        dyeable_mankini = registerItem(new ItemDyeableMankini());
        kawaii_mankini = registerItem(new ItemKawaiiMankini());
        aetheric_mankini = registerItem(new ItemAAMT());
        mankini_cannon  = registerItem(new ItemMankiniCannon());
        mankini_capsule = registerItem(new ItemMankiniCapsule());
        bat_mankini = registerItem(new ItemBatMankini());
        
        registry.registerAll(ITEMS.toArray(new Item[0]));
    }
    
    public static <T extends Item> T registerItem(T item)
    {
        ITEMS.add(item);
        return item;
    }
}