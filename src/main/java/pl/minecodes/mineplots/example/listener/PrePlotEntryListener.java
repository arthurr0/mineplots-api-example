package pl.minecodes.mineplots.example.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import pl.minecodes.plots.api.event.entry.PrePlotEntryEvent;
import pl.minecodes.plots.api.plot.PlotApi;

public class PrePlotEntryListener implements Listener {

    @EventHandler
    public void onPreEntry(PrePlotEntryEvent event) {
        Player player = event.getPlayer();
        PlotApi plot = event.getPlot();

        if (!plot.hasAccess(player)) {
            event.setCancelled(true);
            player.sendMessage("You are not added to this plot!");
        }
    }
}
