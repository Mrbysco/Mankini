package matgm50.mankini.entity;

import matgm50.mankini.init.ModItems;
import matgm50.mankini.util.MankiniHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * Created by MasterAbdoTGM50 on 7/2/2014.
 */

public class EntityMankiniCapsule extends EntityThrowable {

    ItemStack foundMankini;

    ItemStack kini = new ItemStack(ModItems.itemDyeableMankini);
    public EntityMankiniCapsule(World par1World) {

        super(par1World);

    }

    public EntityMankiniCapsule(World par1World, EntityLivingBase par2EntityLivingBase, ItemStack foundMankini) {

        super(par1World, par2EntityLivingBase);
        this.foundMankini = foundMankini;

    }

    public EntityMankiniCapsule(World par1World, double x, double y, double z) {

        super(par1World, x, y, z);

    }

   @Override
    protected void onImpact(RayTraceResult mop) {
	   
        if(mop.typeOfHit != null && mop.typeOfHit == RayTraceResult.Type.ENTITY) {

            Entity hit = mop.entityHit;
           
            if(hit instanceof EntityPlayer) {
            	setDead();
                EntityPlayer hitPlayer = (EntityPlayer)hit;
                Boolean full = true;
      
                if(!this.worldObj.isRemote) {
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
            
            if (hit instanceof EntityCreeper)
            {
            	setDead();
            	EntityCreeper hitCreeper = (EntityCreeper)hit;

                hitCreeper.setDead();
                                
                EntityMankiniCreeper mankinicreeper = new EntityMankiniCreeper(worldObj); 
                mankinicreeper.setLocationAndAngles(hitCreeper.posX, hitCreeper.posY, hitCreeper.posZ, 0,0); 
        		worldObj.spawnEntityInWorld(mankinicreeper);
            }
            
            if (hit instanceof EntityZombie)
            {
            	setDead();
            	EntityZombie hitZombie = (EntityZombie)hit;
            	ItemStack creeperKini = new ItemStack(ModItems.itemDyeableMankini);
            	
            	hitZombie.setItemStackToSlot(EntityEquipmentSlot.CHEST, creeperKini);
            }
            
            if (hit instanceof EntitySkeleton)
            {
            	setDead();
            	EntitySkeleton hitSkeleton = (EntitySkeleton)hit;
            	ItemStack creeperKini = new ItemStack(ModItems.itemDyeableMankini);
            	
            	hitSkeleton.setItemStackToSlot(EntityEquipmentSlot.CHEST, creeperKini);
            }
            setDead();
        }
        if(!this.worldObj.isRemote) {
      	  if (mop.typeOfHit != null && mop.typeOfHit == RayTraceResult.Type.BLOCK)
      {
         setDead();
         int kiniDrop = Item.getIdFromItem(ModItems.itemDyeableMankini);
         this.dropItem(Item.getItemById(kiniDrop), 1);
      }
      }
        else setDead();
   }
}
