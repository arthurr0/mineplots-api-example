package pl.minecodes.mineplots.example.listener;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import pl.minecodes.plots.api.plot.PlotApi;
import pl.minecodes.plots.api.plot.PlotServiceApi;

public class BlockPlaceListener implements Listener {

    private final PlotServiceApi apiPlotService;

    public BlockPlaceListener(PlotServiceApi apiPlotService) {
        this.apiPlotService = apiPlotService;
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block blockPlaced = event.getBlockPlaced();
        PlotApi plot = this.apiPlotService.getPlot(blockPlaced.getLocation());

        if (plot == null) {
            player.sendMessage("There is no plot at this location.");
        } else {
            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(plot.getOwner());
            player.sendMessage(String.format("There is a plot named %s owned by %s", plot.getName(), offlinePlayer.getName()));
        }
    }
}
