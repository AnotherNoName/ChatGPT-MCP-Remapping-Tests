// This code was extracted from a Minecraft Hacked Client totally unmapped   
	
	public void onWorldRender(RenderEvent event) {
        this.count += (long)((Integer)this.rainbowSpeed.getValue()).intValue();
        long start = this.count;
        if (Trajectories.mc.field_71439_g == null || Trajectories.mc.field_71441_e == null || Trajectories.mc.field_71474_y.field_74320_O != 0) {
            return;
        }
        if (!(Trajectories.mc.field_71439_g.func_184614_ca() != ItemStack.field_190927_a && Trajectories.mc.field_71439_g.func_184614_ca().func_77973_b() instanceof ItemBow || Trajectories.mc.field_71439_g.func_184614_ca() != ItemStack.field_190927_a && this.isThrowable(Trajectories.mc.field_71439_g.func_184614_ca().func_77973_b()) || Trajectories.mc.field_71439_g.func_184592_cb() != ItemStack.field_190927_a && this.isThrowable(Trajectories.mc.field_71439_g.func_184592_cb().func_77973_b()))) {
            return;
        }
        double renderPosX = Trajectories.mc.field_71439_g.field_70142_S + (Trajectories.mc.field_71439_g.field_70165_t - Trajectories.mc.field_71439_g.field_70142_S) * (double)event.getPartialTicks();
        double renderPosY = Trajectories.mc.field_71439_g.field_70137_T + (Trajectories.mc.field_71439_g.field_70163_u - Trajectories.mc.field_71439_g.field_70137_T) * (double)event.getPartialTicks();
        double renderPosZ = Trajectories.mc.field_71439_g.field_70136_U + (Trajectories.mc.field_71439_g.field_70161_v - Trajectories.mc.field_71439_g.field_70136_U) * (double)event.getPartialTicks();
        Trajectories.mc.field_71439_g.func_184586_b(EnumHand.MAIN_HAND);
        Item item = null;
        if (Trajectories.mc.field_71439_g.func_184614_ca() != ItemStack.field_190927_a && (Trajectories.mc.field_71439_g.func_184614_ca().func_77973_b() instanceof ItemBow || this.isThrowable(Trajectories.mc.field_71439_g.func_184614_ca().func_77973_b()))) {
            item = Trajectories.mc.field_71439_g.func_184614_ca().func_77973_b();
        } else if (Trajectories.mc.field_71439_g.func_184592_cb() != ItemStack.field_190927_a && this.isThrowable(Trajectories.mc.field_71439_g.func_184592_cb().func_77973_b())) {
            item = Trajectories.mc.field_71439_g.func_184592_cb().func_77973_b();
        }
        if (item == null) {
            return;
        }
        double posX = renderPosX - Math.cos(Trajectories.mc.field_71439_g.field_70177_z / 180.0f * (float)Math.PI) * (double)0.16f;
        double posY = renderPosY + (double)Trajectories.mc.field_71439_g.func_70047_e() - 0.1000000014901161;
        double posZ = renderPosZ - Math.sin(Trajectories.mc.field_71439_g.field_70177_z / 180.0f * (float)Math.PI) * (double)0.16f;
        float maxDist = this.getDistance(item);
        double motionX = -Math.sin(Trajectories.mc.field_71439_g.field_70177_z / 180.0f * (float)Math.PI) * Math.cos(Trajectories.mc.field_71439_g.field_70125_A / 180.0f * (float)Math.PI) * (double)maxDist;
        double motionY = -Math.sin((Trajectories.mc.field_71439_g.field_70125_A - (float)this.getThrowPitch(item)) / 180.0f * 3.141593f) * (double)maxDist;
        double motionZ = Math.cos(Trajectories.mc.field_71439_g.field_70177_z / 180.0f * (float)Math.PI) * Math.cos(Trajectories.mc.field_71439_g.field_70125_A / 180.0f * (float)Math.PI) * (double)maxDist;
        int var6 = 72000 - Trajectories.mc.field_71439_g.func_184605_cv();
        float power = (float)var6 / 20.0f;
        if ((power = (power * power + power * 2.0f) / 3.0f) > 1.0f) {
            power = 1.0f;
        }