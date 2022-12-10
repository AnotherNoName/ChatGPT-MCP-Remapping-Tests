// This is the original code of the example (Does not contain mapping errors)

            if (!this.shouldTotem()) {
                if (Offhand.mc.player.getHeldItemOffhand() == ItemStack.EMPTY || !this.isItemInOffhand()) {
                    int slot;
                    int n = slot = this.getSlot(this.mode) < 9 ? this.getSlot(this.mode) + 36 : this.getSlot(this.mode);
                    if (this.getSlot(this.mode) != -1) {
                        if (this.oldSlot != -1) {
                            Offhand.mc.playerController.windowClick(0, 45, 0, ClickType.PICKUP, Offhand.mc.player);
                            Offhand.mc.playerController.windowClick(0, this.oldSlot, 0, ClickType.PICKUP, Offhand.mc.player);
                        }
                        this.oldSlot = slot;
                        Offhand.mc.playerController.windowClick(0, slot, 0, ClickType.PICKUP, Offhand.mc.player);
                        Offhand.mc.playerController.windowClick(0, 45, 0, ClickType.PICKUP, Offhand.mc.player);
                        Offhand.mc.playerController.windowClick(0, slot, 0, ClickType.PICKUP, Offhand.mc.player);
                    }
                }
            } else if (!(this.eatingApple || Offhand.mc.player.getHeldItemOffhand() != ItemStack.EMPTY && Offhand.mc.player.getHeldItemOffhand().getItem() == Items.TOTEM_OF_UNDYING)) {
                int slot;
                int n = slot = this.getTotemSlot() < 9 ? this.getTotemSlot() + 36 : this.getTotemSlot();
                if (this.getTotemSlot() != -1) {
                    Offhand.mc.playerController.windowClick(0, slot, 0, ClickType.PICKUP, Offhand.mc.player);
                    Offhand.mc.playerController.windowClick(0, 45, 0, ClickType.PICKUP, Offhand.mc.player);
                    Offhand.mc.playerController.windowClick(0, this.oldSlot, 0, ClickType.PICKUP, Offhand.mc.player);
                    this.oldSlot = -1;
                }
            }
        } else {
            if (!this.unDrawTotem.getValue().booleanValue()) {
                this.manageDrawn();
            }
            this.didSwitchThisTick = false;
            this.holdingCrystal = Offhand.mc.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL;
            this.holdingTotem = Offhand.mc.player.getHeldItemOffhand().getItem() == Items.TOTEM_OF_UNDYING;
            this.holdingGapple = Offhand.mc.player.getHeldItemOffhand().getItem() == Items.GOLDEN_APPLE;
            this.holdingObby = InventoryUtil.isBlock(Offhand.mc.player.getHeldItemOffhand().getItem(), BlockObsidian.class);