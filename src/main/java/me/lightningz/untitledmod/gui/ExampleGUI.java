package me.lightningz.untitledmod.gui;


import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;;

public class ExampleGUI extends Screen {

    private static final ResourceLocation gui_bg = new ResourceLocation("untitledmod:bg2.png");
    private String menutitle;

    public ExampleGUI(String title) {
        super(Component.literal(""));
        this.menutitle = title;
    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        // Background is typically rendered first
        this.renderBackground(graphics);

        // Render things here before widgets (background textures)
        int relX = (this.width - 256) / 2;
        int relY = (this.height - 119) / 2;
        graphics.blit(gui_bg, relX, relY, 0, 69, 256, 159);
        graphics.drawCenteredString(this.font, this.menutitle, this.width/2, 8, 16777215);

        // Then the widgets if this is a direct child of the Screen
        super.render(graphics, mouseX, mouseY, partialTick);

        // Render things after widgets (tooltips)
    }

    @Override
    public void tick() {
        super.tick();

    }
    @Override
    public void onClose() {
        // Stop any handlers here

        // Call last in case it interferes with the override
        super.onClose();
    }

    @Override
    public void removed() {
        // Reset initial states here

        // Call last in case it interferes with the override
        super.removed()
        ;}
}
