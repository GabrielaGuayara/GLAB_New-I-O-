import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioExample {
    public static void main(String[] args) throws IOException {
        String[] inputFiles = {"C://Users//gabriela.guayara//Downloads//file1.txt/",
                "C:/Users/gabriela.guayara/Downloads/file2.txt"};

        String outputFile = "C://Users//gabriela.guayara//Downloads//nioOutput.txt/";

        FileOutputStream fos = new FileOutputStream(outputFile);
        FileChannel targetChannel = fos.getChannel();

        for(int i = 0; i < inputFiles.length; i++){
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            FileChannel inputchannel = fis.getChannel();
            long size = inputchannel.size();
            ByteBuffer buf = ByteBuffer.allocate((int)size);
            System.out.println((char) buf.get());
            while(inputchannel.read(buf) > 0){
                buf.flip();
                while(buf.hasRemaining()){
                 targetChannel.write(buf);
                }
            }
        }

    }
}
