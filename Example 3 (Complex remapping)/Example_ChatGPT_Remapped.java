/* 
 *  This code was remapped by ChatGPT with the following arguments: 
 *
 * "Apply Minecraft Mod Coder Pack (MCP) 1.12.2 mappings in this code and put the code into a box" (Attempt 4)
 * "Apply Minecraft Mod Coder Pack (MCP) 1.12.2 mappings in this code" (Attempt 3)
 * "Put the previous code into a box" (Attempt 1)
 */

public void onWorldRender(RenderEvent event) {
    this.count += (long)((Integer)this.rainbowSpeed.getValue()).intValue();
    long start = this.count;
    if (Trajectories.mc.player == null || Trajectories.mc.world == null || Trajectories.mc.gameSettings.thirdPersonView != 0) {
        return;
    }
    if (!(Trajectories.mc.player.getHeldItemMainhand() != ItemStack.EMPTY && Trajectories.mc.player.getHeldItemMainhand().getItem() instanceof ItemBow || Trajectories.mc.player.getHeldItemMainhand() != ItemStack.EMPTY && this.isThrowable(Trajectories.mc.player.getHeldItemMainhand().getItem()) || Trajectories.mc.player.getHeldItemOffhand() != ItemStack.EMPTY && this.isThrowable(Trajectories.mc.player.getHeldItemOffhand().getItem()))) {
        return;
    }
    double renderPosX = Trajectories.mc.player.lastTickPosX + (Trajectories.mc.player.posX - Trajectories.mc.player.lastTickPosX) * (double)event.getPartialTicks();
    double renderPosY = Trajectories.mc.player.lastTickPosY + (Trajectories.mc.player.posY - Trajectories.mc.player.lastTickPosY) * (double)event.getPartialTicks();
    double renderPosZ = Trajectories.mc.player.lastTickPosZ + (Trajectories.mc.player.posZ - Trajectories.mc.player.lastTickPosZ) * (double)event.getPartialTicks();
    Trajectories.mc.player.swingArm(EnumHand.MAIN_HAND);
    Item item = null;
    if (Trajectories.mc.player.getHeldItemMainhand() != ItemStack.EMPTY && (Trajectories.mc.player.getHeldItemMainhand().getItem() instanceof ItemBow || this.isThrowable(Trajectories.mc.player.getHeldItemMainhand().getItem()))) {
        item = Trajectories.mc.player.getHeldItemMainhand().getItem();
    } else if (Trajectories.mc.player.getHeldItemOffhand() != ItemStack.EMPTY && this.isThrowable(Trajectories.mc.player.getHeldItemOffhand().getItem())) {
        item = Trajectories.mc.player.getHeldItemOffhand().getItem();
    }
    if (item == null) {
        return;
    }
	double posX = renderPosX - Math.cos(Minecraft.getMinecraft().player.rotationYaw / 180.0f * (float)Math.PI) * (double)0.16f;
	double posY = renderPosY + (double)Minecraft.getMinecraft().player.getEyeHeight() - 0.1000000014901161;
	double posZ = renderPosZ - Math.sin(Minecraft.getMinecraft().player.rotationYaw / 180.0f * (float)Math.PI) * (double)0.16f;
	float maxDist = this.getDistance(item);
	double motionX = -Math.sin(Minecraft.getMinecraft().player.rotationYaw / 180.0f * (float)Math.PI) * Math.cos(Minecraft.getMinecraft().player.rotationPitch / 180.0f * (float)Math.PI) * (double)maxDist;
	double motionY = -Math.sin((Minecraft.getMinecraft().player.rotationPitch - (float)this.getThrowPitch(item)) / 180.0f * 3.141593f) * (double)maxDist;
	double motionZ = Math.cos(Minecraft.getMinecraft().player.rotationYaw / 180.0f * (float)Math.PI) * Math.cos(Minecraft.getMinecraft().player.rotationPitch / 180.0f * (float)Math.PI) * (double)maxDist;
	int var6 = 72000 - Minecraft.getMinecraft().player.getItemInUseCount();
	float power = (float)var6 / 20.0f;
	if ((power = (power * power + power * 2.0f) / 3.0f) > 1.0f) {
 	   power = 1.0f;
	}
