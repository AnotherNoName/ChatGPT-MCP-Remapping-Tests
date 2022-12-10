// Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\PC\Downloads\mcp940"!

    @Override
    public void onTick() {
        if (this.otherPlayer != null) {
            Random random = new Random();
            this.otherPlayer.moveForward = FakePlayer.mc.player.moveForward + (float)random.nextInt(5) / 10.0f;
            this.otherPlayer.moveStrafing = FakePlayer.mc.player.moveStrafing + (float)random.nextInt(5) / 10.0f;
            if (this.hollow.getValue().booleanValue()) {
                this.travel(this.otherPlayer.moveStrafing, this.otherPlayer.moveVertical, this.otherPlayer.moveForward);
            }
        }
    }

    public void travel(float strafe, float vertical, float forward) {
        double d0 = this.otherPlayer.posY;
        float f1 = 0.8f;
        float f2 = 0.02f;
        float f3 = EnchantmentHelper.getDepthStriderModifier((EntityLivingBase)this.otherPlayer);
        if (f3 > 3.0f) {
            f3 = 3.0f;
        }
        if (!this.otherPlayer.onGround) {
            f3 *= 0.5f;
        }
        if (f3 > 0.0f) {
            f1 += (0.54600006f - f1) * f3 / 3.0f;
            f2 += (this.otherPlayer.getAIMoveSpeed() - f2) * f3 / 4.0f;
        }
        this.otherPlayer.moveRelative(strafe, vertical, forward, f2);
        this.otherPlayer.move(MoverType.SELF, this.otherPlayer.motionX, this.otherPlayer.motionY, this.otherPlayer.motionZ);
        this.otherPlayer.motionX *= (double)f1;
        this.otherPlayer.motionY *= (double)0.8f;
        this.otherPlayer.motionZ *= (double)f1;
        if (!this.otherPlayer.hasNoGravity()) {
            this.otherPlayer.motionY -= 0.02;
        }
        if (this.otherPlayer.collidedHorizontally && this.otherPlayer.isOffsetPositionInLiquid(this.otherPlayer.motionX, this.otherPlayer.motionY + (double)0.6f - this.otherPlayer.posY + d0, this.otherPlayer.motionZ)) {
            this.otherPlayer.motionY = 0.3f;
        }
    }