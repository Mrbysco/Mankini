package matgm50.mankini.proxy;

import matgm50.mankini.client.renderer.mobs.RenderMankiniCreeper;
import matgm50.mankini.entity.hostile.EntityMankiniCreeper;
import matgm50.mankini.entity.projectiles.EntityMankiniCapsule;
import matgm50.mankini.init.ModConfigGen;
import matgm50.mankini.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by MasterAbdoTGM50 on 4/23/2014.
 */

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

	@Override
	public void RegisterRenders(){
	}
	
    @Override
    public void initMobRenderers() {
    	RenderingRegistry.registerEntityRenderingHandler(EntityMankiniCapsule.class, new IRenderFactory<EntityMankiniCapsule>() {
			@Override
			public Render<? super EntityMankiniCapsule> createRenderFor(RenderManager manager) {
				return new RenderSnowball<EntityMankiniCapsule>(manager, ModItems.mankini_capsule, Minecraft.getMinecraft().getRenderItem());
			}
    	});
    	
    	if(ModConfigGen.entities.MankiniCreeper)
    	{
    		RenderingRegistry.registerEntityRenderingHandler(EntityMankiniCreeper.class, RenderMankiniCreeper.FACTORY);
    	}
    	
        //RenderingRegistry.registerEntityRenderingHandler(EntityMankiniWither.class, new RendererMankiniWither(new ModelMankiniWither(), 0.5F));
    }

	@SubscribeEvent
	public static void registerBlockColors(ColorHandlerEvent.Item event) {
		ItemColors itemColors = event.getItemColors();

		itemColors.registerItemColorHandler(new IItemColor() {
			@Override
			public int colorMultiplier(ItemStack stack, int tintIndex) {
				NBTTagCompound tag = stack.getTagCompound();
				if(tag!=null){
					NBTTagCompound nbt = tag.getCompoundTag("display");
					return nbt == null ? 10511680 : (nbt.hasKey("color", 3) ? nbt.getInteger("color") : 10511680);
				}
				return 10511680;
			}
		}, ModItems.dyeable_mankini);
	}
}
