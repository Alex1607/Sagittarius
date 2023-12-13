package de.spacepotato.sagittarius.entity;

import de.spacepotato.sagittarius.mojang.SkinProperty;

import java.util.Optional;
import java.util.UUID;

public interface Player extends Entity {

	/**
	 * Returns the player's name.
	 * @return The name of the player.
	 */
	String getName();
	
	/**
	 * Returns the player's UUID.
	 * @return The UUID of the player.
	 */
	UUID getUUID();
	
	/**
	 * Returns an optional containing the skin.
	 * The optional will be empty on servers that do not have supported forwarding mechanisms enabled.
	 * @return An optional containing the player's skin.
	 */
	Optional<SkinProperty[]> getSkin();
	
	/**
	 * Sends a message to the player.
	 * This method will not work if the player is still connecting.
	 * @param message The message to send.
	 */
	void sendMessage(String message);
	
	/**
	 * Disconnects the player with the given message.
	 * @param message The message that the player will see on their kick screen.
	 */
	void kick(String message);
	
	/**
	 * Returns whether the player is currently in the process of connecting to the server.
	 * The result will become false as soon as the player enters the PLAY state.
	 * @return true if the player is still connecting to the server.
	 */
	boolean isConnecting();
	
	/**
	 * Returns whether the connection has been fully established. 
	 * If this method returns true, the player is in the PLAY state.
	 * @return Whether the connection has been fully established and is ready to receive and send PLAY packets.
	 */
	boolean isConnected();
	
	
}
