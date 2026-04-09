package net.coreprotect.event;

import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CoreProtectChatPreLogEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled = false;

    private final String user;
    private final String message;  // raw chat message or command string
    private final Location location;
    private final boolean isCommand;

    public CoreProtectChatPreLogEvent(String user, String message, Location location, boolean isCommand) {
        super(true); // async-safe — CP logs chat from an async context
        this.user = user;
        this.message = message;
        this.location = location;
        this.isCommand = isCommand;
    }

    public String getUser()         { return user; }
    public String getMessage()      { return message; }
    public Location getLocation()   { return location; }
    public boolean isCommand()      { return isCommand; }

    @Override public boolean isCancelled()            { return cancelled; }
    @Override public void setCancelled(boolean cancel) { this.cancelled = cancel; }
    @Override public HandlerList getHandlers()        { return handlers; }
    public static HandlerList getHandlerList()        { return handlers; }
}