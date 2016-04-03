/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import java.net.*;
import java.io.*;

/**
 *
 * @author pawel
 */
public class URLGet {

    public String getSite(String url) {
        
        StringBuilder sb = new StringBuilder();
        
        try {
            URLConnection connection = (new URL(url)).openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            while (reader.ready()) {
                sb.append(reader.readLine() + "\n");
            }
            
            reader.close();
            
        }
        catch (MalformedURLException me) {
            sb.append("malformed url");
        }
        catch (IOException ioe) {
            sb.append("I/O error");
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        
        URLGet test = new URLGet();
        BufferedWriter writer = 
            new BufferedWriter(
                new OutputStreamWriter(
                    new FileOutputStream("labcast.xml")
                )
            );
        writer.write(test.getSite("http://feeds.media.mit.edu/labcast?format=xml"));
        writer.close();
        
    }
}
