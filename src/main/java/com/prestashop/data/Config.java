/**
 * 
 */
package  com.prestashop.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/** */
@JsonIgnoreProperties
public class Config {

	/** */
	private  Long timeout;
	
	/** */
	private boolean grid;
	
	/** */
	private  String gridServer;
	
	/** */
	private  String browser;
	
	/** */
	private boolean privateBrowsing;
	
	/** available values: NONE|ALL|FAIL */
	private String screenshot;



	/**
	 * 
	 * @return
	 */
	public Long getTimeout() {
		return timeout;
	}


	/**
	 * 
	 * @param timeout
	 */
	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}


	/**
	 * 
	 * @return
	 */
	public String getGridServer() {
		return gridServer;
	}


	/**
	 * 
	 * @param gridServer
	 */
	public void setGridServer(String gridServer) {
		this.gridServer = gridServer;
	}


	/**
	 * 
	 * @return
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * 
	 * @param browser
	 */
	public void setBrowser(String browser) {
		this.browser = browser.toUpperCase();
	}


	/**
	 * 
	 * @return
	 */
	public String getScreenshot() {
		return screenshot;
	}


	/**
	 * 
	 * @param screenshot
	 */
	public void setScreenshot(String screenshot) {
		this.screenshot = screenshot;
	}


	public boolean isGrid() {
		return grid;
	}


	public void setGrid(boolean grid) {
		this.grid = grid;
	}


	public boolean isPrivateBrowsing() {
		return privateBrowsing;
	}


	public void setPrivateBrowsing(boolean privateBrowsing) {
		this.privateBrowsing = privateBrowsing;
	}
}
