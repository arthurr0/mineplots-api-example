package pl.minecodes.mineplots.example.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import pl.minecodes.mineplots.api.event.entry.PrePlotEntryEvent;
import pl.minecodes.mineplots.api.plot.ApiPlot;

public class PrePlotEntryListener implements Listener {

    @EventHandler
    public void onPreEntry(PrePlotEntryEvent event) {
        Player player = event.getPlayer();
        ApiPlot plot = event.getPlot();

        if (!plot.hasAccess(player)) {
            event.setCancelled(true);
            player.sendMessage("You are not added to this plot!");
        }
    }
}
