// This code was extracted from a Minecraft Hacked Client with some mappings errors

            if (!this.shouldTotem()) {
                if (Offhand.mc.player.getHeldItemOffhand() == ItemStack.field_190927_a || !this.isItemInOffhand()) {
                    int slot = this.getSlot(this.mode) < 9 ? this.getSlot(this.mode) + 36 : this.getSlot(this.mode);
                    int n = slot;
                    if (this.getSlot(this.mode) != -1) {
                        if (this.oldSlot != -1) {
                            Offhand.mc.playerController.windowClick(0, 45, 0, ClickType.PICKUP, (EntityPlayer)Offhand.mc.player);
                            Offhand.mc.playerController.windowClick(0, this.oldSlot, 0, ClickType.PICKUP, (EntityPlayer)Offhand.mc.player);
                        }
                        this.oldSlot = slot;
                        Offhand.mc.playerController.windowClick(0, slot, 0, ClickType.PICKUP, (EntityPlayer)Offhand.mc.player);
                        Offhand.mc.playerController.windowClick(0, 45, 0, ClickType.PICKUP, (EntityPlayer)Offhand.mc.player);
                        Offhand.mc.playerController.windowClick(0, slot, 0, ClickType.PICKUP, (EntityPlayer)Offhand.mc.player);
                    }
                }
            } else if (!(this.eatingApple || Offhand.mc.player.getHeldItemOffhand() != ItemStack.field_190927_a && Offhand.mc.player.getHeldItemOffhand().getItem() == Items.field_190929_cY)) {
                int slot = this.getTotemSlot() < 9 ? this.getTotemSlot() + 36 : this.getTotemSlot();
                int n = slot;
                if (this.getTotemSlot() != -1) {
                    Offhand.mc.playerController.windowClick(0, slot, 0, ClickType.PICKUP, (EntityPlayer)Offhand.mc.player);
                    Offhand.mc.playerController.windowClick(0, 45, 0, ClickType.PICKUP, (EntityPlayer)Offhand.mc.player);
                    Offhand.mc.playerController.windowClick(0, this.oldSlot, 0, ClickType.PICKUP, (EntityPlayer)Offhand.mc.player);
                    this.oldSlot = -1;
                }
            }
        } else {
            if (!this.unDrawTotem.getValue().booleanValue()) {
                this.manageDrawn();
            }
            this.didSwitchThisTick = false;
            this.holdingCrystal = Offhand.mc.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL;
            this.holdingTotem = Offhand.mc.player.getHeldItemOffhand().getItem() == Items.field_190929_cY;
            this.holdingGapple = Offhand.mc.player.getHeldItemOffhand().getItem() == Items.GOLDEN_APPLE;
            this.holdingObby = InventoryUtil.isBlock(Offhand.mc.player.getHeldItemOffhand().getItem(), BlockObsidian.class);