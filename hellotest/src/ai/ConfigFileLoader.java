package ai;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ConfigFileLoader {

	/**
	 * Config File format: level:hiddenLayerSize:learningRate:numberOfhiddenLayers
	 * @param f
	 */
	public void loadConfigFile(String name) {
		System.out.println("hhhhhhhh");
		try {
			File f = new File(name) ;
			this.mapConfig = new HashMap<String, Config>();
			System.out.println(f.getPath());
			BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			String s1 = "";
			while( (s1 = br1.readLine()) != null ) {
				System.out.println(s1);
			}
			if(f.exists() && f.isFile()) {
				System.out.println("zzzzzzzzz");
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
				String s = "";
				while( (s = br.readLine()) != null ) {
					String[] t = s.split(":");
					if ( t.length == 4 ) {
						String level = t[0];
						int hiddenLayerSize = Integer.parseInt(t[1]);
						double learningRate = Double.parseDouble(t[2]);
						int numberOfhiddenLayers = Integer.parseInt(t[3]);
						//
						Config c = new Config(level, hiddenLayerSize, numberOfhiddenLayers, learningRate);
						mapConfig.put(level, c);
					}
				}
				br.close();
				System.out.println("le fichier recuperer");
			}
		}
		catch (Exception e) {
			System.out.println("Config.loadConfigFile()");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public Config get(String level) {
		try {
			if (mapConfig != null && mapConfig.containsKey(level) )
				return mapConfig.get(level);
		} 
		catch (Exception e) {
			System.out.println("ConfigFileLoader.get()");
			e.printStackTrace();
			System.exit(-1);
		}
		return null ;
	}
	
	@Override
	public String toString() {
		return "ConfigFileLoader [mapConfig=" + mapConfig + "]";
	}

	//FIELDS ...
	private HashMap<String, Config> mapConfig ;
	
	public HashMap<String, Config> getMapConfig() {
        return mapConfig;
    }
}
