package guaidaodl.github.io.quicksettingtitle;

import android.content.Intent;
import android.os.IBinder;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.util.Log;

public class TestTileService extends TileService {
    public TestTileService() {
    }

    @Override
    public void onTileAdded() {
        Log.d("TEST", "tile added");
    }

    @Override
    public void onStartListening() {
        Log.d("TEST", "start listening");
        Tile tile = getQsTile();
        if (tile.getState() == Tile.STATE_ACTIVE) {
            tile.setLabel(getApplicationContext().getString(R.string.disable_tile));
        } {
            tile.setLabel(getApplicationContext().getString(R.string.enable_tile));
        }

        tile.updateTile();
    }

    @Override
    public void onStopListening() {
        Log.d("TEST", "stop listening");
    }

    @Override
    public void onTileRemoved() {
        Log.d("TEST", "tile removed");
    }

    @Override
    public void onClick() {
        Log.d("TEST", "click");

        Tile tile = getQsTile();
        if (tile.getState() == Tile.STATE_ACTIVE) {
            tile.setState(Tile.STATE_INACTIVE);
            tile.setLabel(getApplicationContext().getString(R.string.enable_tile));
        } else {
            tile.setState(Tile.STATE_ACTIVE);
            tile.setLabel(getApplicationContext().getString(R.string.disable_tile));
        }

        tile.updateTile();
    }
}
