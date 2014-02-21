package net.glowstone.net.codec.play.game;

import com.flowpowered.networking.Codec;
import com.flowpowered.networking.util.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import net.glowstone.net.message.play.game.PlaySoundMessage;

import java.io.IOException;

public final class PlaySoundCodec implements Codec<PlaySoundMessage> {
    public PlaySoundMessage decode(ByteBuf buf) throws IOException {
        throw new DecoderException("Cannot decode PlaySoundMessage");
    }

    public ByteBuf encode(ByteBuf buf, PlaySoundMessage message) throws IOException {
        ByteBufUtils.writeUTF8(buf, message.getSound());
        buf.writeInt(message.getX());
        buf.writeInt(message.getY());
        buf.writeInt(message.getZ());
        buf.writeFloat(message.getVolume());
        buf.writeByte((int)(message.getPitch() * 63));
        return buf;
    }
}
