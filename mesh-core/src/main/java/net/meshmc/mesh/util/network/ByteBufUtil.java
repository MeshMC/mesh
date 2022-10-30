package net.meshmc.mesh.util.network;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.EncoderException;

import java.nio.charset.StandardCharsets;
import java.time.Instant;

public class ByteBufUtil {
    public static int getVarIntSize(int input)
    {
        for (int i = 1; i < 5; ++i)
        {
            if ((input & -1 << i * 7) == 0)
            {
                return i;
            }
        }

        return 5;
    }

    public static byte[] readByteArray(ByteBuf buf) {
        return readByteArray(buf, buf.readableBytes());
    }

    public static byte[] readByteArray(ByteBuf buf, int maxSize) {
        int i = readVarInt(buf);
        if (i > maxSize) {
            throw new DecoderException("ByteArray with size " + i + " is bigger than allowed " + maxSize);
        } else {
            byte[] bs = new byte[i];
            buf.readBytes(bs);
            return bs;
        }
    }

    public static void writeByteArray(ByteBuf buf, byte[] array) {
        writeVarInt(buf, array.length);
        buf.writeBytes(array);
    }

    public static Instant readInstant(ByteBuf buf) {
        return Instant.ofEpochMilli(buf.readLong());
    }

    public static void writeInstant(ByteBuf buf, Instant instant) {
        buf.writeLong(instant.toEpochMilli());
    }

    public static String readString(ByteBuf buf, int maxLength) {
        int i = readVarInt(buf);

        if(i > maxLength * 4) throw new DecoderException("The received encoded string buffer length is longer than maximum allowed (" + i + " > " + maxLength * 4 + ")");
        else if (i < 0) throw new DecoderException("The received encoded string buffer length is less than zero! Weird string!");
        else {
            String s = buf.toString(buf.readerIndex(), i, StandardCharsets.UTF_8);
            buf.readerIndex(buf.readerIndex() + i);

            if(s.length() > maxLength) throw new DecoderException("The received string length is longer than maximum allowed (" + i + " > " + maxLength + ")");
            else return s;
        }
    }

    public static void writeString(ByteBuf buf, String string) {
        byte[] abyte = string.getBytes(StandardCharsets.UTF_8);

        if(abyte.length > 32767) {
            throw new EncoderException("String too big (was " + abyte.length + " bytes encoded, max " + 32767 + ")");
        } else {
            writeVarInt(buf, abyte.length);
            buf.writeBytes(abyte);
        }
    }

    public static int readVarInt(ByteBuf buf) {
        int i = 0;
        int j = 0;

        while (true) {
            byte b0 = buf.readByte();
            i |= (b0 & 127) << j++ * 7;

            if(j > 5) throw new RuntimeException("VarInt too big");

            if((b0 & 128) != 128) break;
        }

        return i;
    }

    public static void writeVarInt(ByteBuf buf, int input) {
        while((input & -128) != 0) {
            buf.writeByte(input & 127 | 128);
            input >>>= 7;
        }

        buf.writeByte(input);
    }
}
