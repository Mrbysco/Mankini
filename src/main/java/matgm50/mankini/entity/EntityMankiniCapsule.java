package matgm50.mankini.entity;

import matgm50.mankini.init.ModItems;
import matgm50.mankini.util.MankiniHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * Created by MasterAbdoTGM50 on 7/2/2014.
 */

public class EntityMankiniCapsule extends EntityThrowable {

    ItemStack foundMankini;

    ItemStack kini = new ItemStack(ModItems.dyeable_mankini);
    public EntityMankiniCapsule(World worldIn) {

        super(worldIn);

    }

    public EntityMankiniCapsule(World worldIn, EntityLivingBase throwerIn, ItemStack foundMankini) {

        super(worldIn, throwerIn);
        this.foundMankini = foundMankini;

    }

    public EntityMankiniCapsule(World worldIn, double x, double y, double z) {

        super(worldIn, x, y, z);

    }

    public static void registerFixesMankiniCapsule(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "MankiniCapsule");
    }

   @Override
    protected void onImpact(RayTraceResult result) {
	   
        if(result.typeOfHit != null && result.typeOfHit == RayTraceResult.Type.ENTITY) {

            Entity hit = result.entityHit;
           
            if(hit instanceof EntityPlayer) {
            	this.world.setEntityState(this, (byte)3);
                this.setDead();
                EntityPlayer hitPlayer = (EntityPlayer)hit;
                Boolean full = true;
        
                
                    
                           
                if(!this.world.isRemote) {
                	
                	for (int i=0; i<=3; i++) {
                    	
                        if (hitPlayer.inventory.getStackInSlot(i) == null) {
                            full = false;
                        }
                   } 
                	
                    if(hitPlayer.inventory.armorItemInSlot(2) == null){
                    	hitPlayer.inventory.setInventorySlotContents(38, MankiniHelper.getFirstFoundMankini(hitPlayer));
                    }
                    
                    else if(hitPlayer.inventory.armorItemInSlot(2) != null && full == false){
                    	hitPlayer.inventory.setInventorySlotContents(hitPlayer.inventory.getFirstEmptyStack(), MankiniHelper.getFirstFoundMankini(hitPlayer));
                    		//hitPlayer.inventory.addItemStackToInventory(MankiniHelper.getFirstFoundMankini(hitPlayer));
                    	
                    }
                    
                    
                }
        
            }
            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
        if(!this.world.isRemote) {
      	  if (result.typeOfHit != null && result.typeOfHit == RayTraceResult.Type.BLOCK)
      {
  		this.world.setEntityState(this, (byte)3);
		this.setDead();
		int kiniDrop = Item.getIdFromItem(ModItems.dyeable_mankini);
        this.dropItem(Item.getItemById(kiniDrop), 1);
      }
      }
        else 
        this.world.setEntityState(this, (byte)3);
        this.setDead();
   }
}
