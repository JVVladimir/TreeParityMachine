package utils;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.StringJoiner;

public class FileManager {

    public static void saveToFile(short[] key1, short[] key2, Path path) {
        try (var randomAccessFile = new RandomAccessFile(path.toFile(), "rw");
             FileChannel fileChannel = randomAccessFile.getChannel()) {

            String joiner = getFormattedString(key1, key2);
            fileChannel.write(ByteBuffer.wrap(joiner.getBytes()));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static String getFormattedString(short[] key1, short[] key2) {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("KEY1: " + Arrays.toString(key1));
        joiner.add("KEY2: " + Arrays.toString(key2));
        return joiner.toString();
    }

}
