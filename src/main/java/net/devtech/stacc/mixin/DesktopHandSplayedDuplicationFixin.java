package net.devtech.stacc.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Set;

@Mixin (ScreenHandler.class)
public class DesktopHandSplayedDuplicationFixin {
	/**
	 * @author DomamaN202
	 * @reason Meow
	 */
	@Overwrite
	public static int calculateStackSize(Set<Slot> slots, int mode, ItemStack stack) {
		return switch (mode) {
			case 0 -> MathHelper.floor((double) stack.getCount() / (double) slots.size());
			case 1 -> 1;
			case 2 -> stack.getItem().getMaxCount();
			default -> stack.getCount();
		};
	}
}
