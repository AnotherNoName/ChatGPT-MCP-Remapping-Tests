/* 
 *  This code was remapped by ChatGPT with the following arguments: 
 *
 * "Apply Minecraft Mod Coder Pack (MCP) 1.12.2 mappings in this code and put the code into a box" (Attempt 2)
 */

@Override
public void onTick() {
    if (this.otherPlayer != null) {
        Random random = new Random();
        this.otherPlayer.movementInput.moveStrafe = FakePlayer.mc.player.movementInput.moveStrafe + (float)random.nextInt(5) / 10.0f;
        this.otherPlayer.movementInput.moveForward = FakePlayer.mc.player.movementInput.moveForward + (float)random.nextInt(5) / 10.0f;
        if (this.hollow.getValue().booleanValue()) {
            this.travel(this.otherPlayer.movementInput.moveForward, this.otherPlayer.movementInput.jumpMovementFactor, this.otherPlayer.movementInput.moveStrafe);
        }
    }
}

public void travel(float strafe, float vertical, float forward) {
    double d0 = this.otherPlayer.posY;
    float f1 = 0.8f;
    float f2 = 0.02f;
    float f3 = EnchantmentHelper.getEfficiencyModifier(this.otherPlayer);
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
    this.otherPlayer.setAIMoveSpeed(strafe, vertical, forward, f2);
    this.otherPlayer.move(MoverType.SELF, this.otherPlayer.motionX, this.otherPlayer.motionY, this.otherPlayer.motionZ);
    this.otherPlayer.motionX *= (double)f1;
    this.otherPlayer.motionY *= (double)0.8f;
    this.otherPlayer.motionZ *= (double)f1;
    if (!this.otherPlayer.isInWater()) {
        this.otherPlayer.motionY -= 0.02;
    }
    if (this.otherPlayer.onGround && this.otherPlayer.collidedHorizontally && this.otherPlayer.isOnLadder()) {
        this.otherPlayer.motionY = 0.3f;
    }
}
