package matgm50.mankini.item;

import matgm50.mankini.lib.ModLib;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by MasterAbdoTGM50 on 4/23/2014.
 */

public class ModItems {

    public static Item itemDyeableMankini;
    public static Item itemKawaiiMankini;
    public static Item itemAethericMankini;
    public static Item itemMankiniCannon;
    public static Item itemMankiniCapsule;
    public static Item itemBatMankini;

    public static void init() {

        itemDyeableMankini = new ItemDyeableMankini();
        itemKawaiiMankini = new ItemKawaiiMankini();
        itemAethericMankini = new ItemAAMT();
        itemMankiniCannon  = new ItemMankiniCannon();
        itemMankiniCapsule = new ItemMankiniCapsule();
        itemBatMankini = new ItemBatMankini();
    

    
       // GameRegistry.registerItem(itemDyeableMankini, ItemLib.DYEABLE_MAKNINI_NAME);
       // GameRegistry.registerItem(itemKawaiiMankini, ItemLib.KAWAII_MAKNINI_NAME);
       // GameRegistry.registerItem(itemAethericMankini, ItemLib.AETHERIC_MAKNINI_NAME);
       // GameRegistry.registerItem(itemMankiniCannon, ItemLib.MANKINI_CANNON_NAME);
       //  GameRegistry.registerItem(itemMankiniCapsule, ItemLib.MANKINI_CAPSULE_NAME);
      //  GameRegistry.registerItem(itemBatMankini, ItemLib.MANKINI_BAT_NAME);

    }
}



