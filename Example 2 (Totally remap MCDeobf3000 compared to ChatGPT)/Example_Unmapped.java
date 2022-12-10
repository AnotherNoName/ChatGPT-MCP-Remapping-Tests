// This code was extracted from a Minecraft Hacked Client totally unmapped

     @Override
    public void onTick() {
        if (this.otherPlayer != null) {
            Random random = new Random();
            this.otherPlayer.field_191988_bg = FakePlayer.mc.field_71439_g.field_191988_bg + (float)random.nextInt(5) / 10.0f;
            this.otherPlayer.field_70702_br = FakePlayer.mc.field_71439_g.field_70702_br + (float)random.nextInt(5) / 10.0f;
            if (this.hollow.getValue().booleanValue()) {
                this.travel(this.otherPlayer.field_70702_br, this.otherPlayer.field_70701_bs, this.otherPlayer.field_191988_bg);
            }
        }
    }

    public void travel(float strafe, float vertical, float forward) {
        double d0 = this.otherPlayer.field_70163_u;
        float f1 = 0.8f;
        float f2 = 0.02f;
        float f3 = EnchantmentHelper.func_185294_d(this.otherPlayer);
        if (f3 > 3.0f) {
            f3 = 3.0f;
        }
        if (!this.otherPlayer.field_70122_E) {
            f3 *= 0.5f;
        }
        if (f3 > 0.0f) {
            f1 += (0.54600006f - f1) * f3 / 3.0f;
            f2 += (this.otherPlayer.func_70689_ay() - f2) * f3 / 4.0f;
        }
        this.otherPlayer.func_191958_b(strafe, vertical, forward, f2);
        this.otherPlayer.func_70091_d(MoverType.SELF, this.otherPlayer.field_70159_w, this.otherPlayer.field_70181_x, this.otherPlayer.field_70179_y);
        this.otherPlayer.field_70159_w *= (double)f1;
        this.otherPlayer.field_70181_x *= (double)0.8f;
        this.otherPlayer.field_70179_y *= (double)f1;
        if (!this.otherPlayer.func_189652_ae()) {
            this.otherPlayer.field_70181_x -= 0.02;
        }
        if (this.otherPlayer.field_70123_F && this.otherPlayer.func_70038_c(this.otherPlayer.field_70159_w, this.otherPlayer.field_70181_x + (double)0.6f - this.otherPlayer.field_70163_u + d0, this.otherPlayer.field_70179_y)) {
            this.otherPlayer.field_70181_x = 0.3f;
        }
    }