package matgm50.mankini.item;

import matgm50.mankini.Mankini;
import matgm50.mankini.lib.ItemLib;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by MasterAbdoTGM50 on 7/2/2014.
 */

public class ItemMankiniCapsule extends Item {

    public ItemMankiniCapsule() {

        super();
        setUnlocalizedName(ItemLib.ModItems.MANKINI_CAPSULE_NAME.getUnlocalisedName());
		setRegistryName(ItemLib.ModItems.MANKINI_CAPSULE_NAME.getRegistryName());
        setCreativeTab(Mankini.tabMankini);
        setMaxStackSize(1);

    }

    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        return new ActionResult(EnumActionResult.PASS, itemStackIn);
    }
}