// This is the original code of the example

    public void onWorldRender(RenderEvent event) {
        count += rainbowSpeed.getValue();
        long start = count;
        if (mc.player == null || mc.world == null || mc.gameSettings.thirdPersonView != 0)
            return;
        if (!((mc.player.getHeldItemMainhand() != ItemStack.EMPTY && mc.player.getHeldItemMainhand().getItem() instanceof ItemBow) || (mc.player.getHeldItemMainhand() != ItemStack.EMPTY && isThrowable(mc.player.getHeldItemMainhand().getItem())) || (mc.player.getHeldItemOffhand() != ItemStack.EMPTY && isThrowable(mc.player.getHeldItemOffhand().getItem()))))
            return;
        final double renderPosX = mc.player.lastTickPosX + (mc.player.posX - mc.player.lastTickPosX) * event.getPartialTicks();
        final double renderPosY = mc.player.lastTickPosY + (mc.player.posY - mc.player.lastTickPosY) * event.getPartialTicks();
        final double renderPosZ = mc.player.lastTickPosZ + (mc.player.posZ - mc.player.lastTickPosZ) * event.getPartialTicks();
        mc.player.getHeldItem(EnumHand.MAIN_HAND);        
        Item item = null;
        if (mc.player.getHeldItemMainhand() != ItemStack.EMPTY && (mc.player.getHeldItemMainhand().getItem() instanceof ItemBow || isThrowable(mc.player.getHeldItemMainhand().getItem()))) {
            item = mc.player.getHeldItemMainhand().getItem();
        } else if (mc.player.getHeldItemOffhand() != ItemStack.EMPTY && isThrowable(mc.player.getHeldItemOffhand().getItem())) {
            item = mc.player.getHeldItemOffhand().getItem();
        }
        if (item == null) return;
        double posX = renderPosX - Math.cos(mc.player.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        double posY = renderPosY + mc.player.getEyeHeight() - 0.1000000014901161;
        double posZ = renderPosZ - Math.sin(mc.player.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        final float maxDist = getDistance(item);
        double motionX = -Math.sin(mc.player.rotationYaw / 180.0f * 3.1415927f) * Math.cos(mc.player.rotationPitch / 180.0f * 3.1415927f) * maxDist;
        double motionY = -Math.sin((mc.player.rotationPitch - getThrowPitch(item)) / 180.0f * 3.141593f) * maxDist;
        double motionZ = Math.cos(mc.player.rotationYaw / 180.0f * 3.1415927f) * Math.cos(mc.player.rotationPitch / 180.0f * 3.1415927f) * maxDist;
        int var6 = 72000 - mc.player.getItemInUseCount();
        float power = var6 / 20.0f;
        power = (power * power + power * 2.0f) / 3.0f;
        if (power > 1.0f) {
            power = 1.0f;
        }