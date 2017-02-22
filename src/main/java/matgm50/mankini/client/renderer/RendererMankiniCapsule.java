package matgm50.mankini.client.renderer;

import matgm50.mankini.entity.EntityMankiniCapsule;
import matgm50.mankini.init.ModItems;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;

/**
 * Created by MasterAbdoTGM50 on 7/2/2014.
 */

public class RendererMankiniCapsule extends RenderSnowball<EntityMankiniCapsule> {
	
    public RendererMankiniCapsule(RenderManager renderManagerIn, RenderItem itemRendererIn)
    {
        super(renderManagerIn, ModItems.mankini_capsule, itemRendererIn);
    }
}
