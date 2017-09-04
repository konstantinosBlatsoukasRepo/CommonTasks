package kon.blats.files.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by k.blatsoukas on 9/4/2017.
 */
public class FileUploader {
    public void uploadFile(String filename) throws IOException {
        Session session = createSessionObject();
        try {
            session.connect();
            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            channelSftp.disconnect();
            session.disconnect();
        } catch (JSchException e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            throw new RuntimeException("Error during SSH command execution. Command: ");
        }
    }

    private Session createSessionObject() throws IOException {
        JSch jsch = new JSch();
        Session session = null;
        try {
            Properties properties = loadApplicationProperties();
            String username = properties.getProperty("sftp.user");
            String host = properties.getProperty("sftp.host");
            //String key = properties.getProperty("sftp.key"); in case of public key authentication
            int port = Integer.parseInt(properties.getProperty("sftp.port"));
            session = jsch.getSession(username, host, port);
            session.setConfig("PreferredAuthentications", "publickey, keyboard-interactive, password");
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            String password = properties.getProperty("sftp.password");
            session.setPassword(password);
            session.setConfig(config);
            return session;
        } catch (JSchException e) {
            throw new RuntimeException("Failed to create Jsch Session object.", e);
        }
    }

    private Properties loadApplicationProperties() throws IOException {
        Properties properties = new Properties();
        try(FileInputStream propertiesFilesSteam = new FileInputStream("application.properties")) {
            properties.load(propertiesFilesSteam);
        }
        return properties;
    }
}
