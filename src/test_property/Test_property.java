package test_property;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;

public class Test_property {

	public static void main(String[] s) {
            Test_property r = new Test_property();          
            r.createProperties();        
            String filepath = r.readProperties();
            System.out.println(filepath);
            r.runBatFile(filepath);
        }
        public String readProperties(){
            Properties prop = new Properties();
            try (InputStream in = new FileInputStream("baaaaat.properties")) 
            {
		prop.load(in);
            }
	    catch (IOException e) {
		e.printStackTrace();
	    }
            catch (Exception e) {
		e.printStackTrace();
	    }
            String path = prop.getProperty("text.bat");
            return path;
        }

        public void createProperties(){
            try (OutputStream out = new FileOutputStream("baaaaat.properties")) {
		Properties properties = new Properties();
		properties.setProperty("text.bat", "C:\\Users\\stagiaire\\Documents\\NetBeansProjects\\test_property\\src\\test_property\\text.bat");
		properties.setProperty("article", "JavaProperties");
		properties.setProperty("version", "1.0");
		properties.setProperty("ide", "eclipse");
		properties.store(out, "This is a sample for java properties");
            } catch (IOException e) {
		e.printStackTrace();
            }
        }
        
        public void runBatFile(String filepath){
            try {
                String line;
                Process p = Runtime.getRuntime().exec(filepath);
                BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((line = bri.readLine()) != null) {
                System.out.println(line);
            }
            bri.close();
            //System.out.println("end of getInputStream.");
            //System.out.println();
            p.waitFor();
            System.out.println("Exited with error code : (01 means before midi , 02 means after midi) "+p.exitValue());
            }
            catch (Exception err) {
                err.printStackTrace();
            }
        }
}