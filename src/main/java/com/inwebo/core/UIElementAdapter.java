package com.inwebo.core;

import java.text.MessageFormat;
import java.time.Duration;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inwebo.core.field.UIField;
import com.inwebo.core.setup.ConfigManager;

/** */
public class UIElementAdapter {

	/** */
    protected Logger log;

    /** */
    public UIElementAdapter() {
        log = LogManager.getLogger(this.getClass().getName());
    }
    
    
    /**
     * 
     * @param url
     * @return
     */
    public boolean loadURL(String url) {
        try {
            ConfigManager.getDriver().get(url);
            ConfigManager.getDriver().manage().window().maximize();
            debug("url loaded");
            return true;
        } catch(Exception e) {
            error("Unable to connect to " + url);
            error(e.toString());
            return false;
        }
    }
     
    /**
     * 
     * @param b
     * @param args
     * @return
     */
    public boolean click(Binding b, String... args) {
        Elt e = getXR(b, args);

        try {
            debug("click on button : Waiting on visibility of button ");
            waitElementPresent(e);
            WebElement el = findElement(e.getBy());
            debug("click on button : Clicking on button ");
            
           el.click();
            
            
            return true;
        } catch(StaleElementReferenceException stale) {
            error("error while clicking on button");
            return false;
        }

    }
    
    /**
     * 
     * @param b
     * @param args
     * @return
     */
    public boolean switchToIFrame(Bindings b, String... args) {

        boolean result;
        Elt elt = getXR(b, args);
        try {
            waitElementPresent(elt);
            ConfigManager.getDriver().switchTo().frame(findElement(elt.getBy()));
            result = true;
        } catch(Exception ex) {
            result = false;
        }
        return result;
    }
    
    /**
     * 
     * @return
     */
    public boolean switchToDefaultFrame() {
        boolean result;
        waitForJStoLoad();
        WebDriver wd = ConfigManager.getDriver();
        try {
            wd.switchTo().defaultContent();
            result = true;
        } catch(Exception ex) {
            result = false;
        }
        waitForJStoLoad();
        return result;
    }
    
    /**
     * 
     * @param value
     * @param b
     * @param args
     * @return
     */
    public boolean input(String value, Bindings b, String... args) {
        try {
            Elt e = getXR(b, args);
            waitElementPresent(e);

            UIField f = e.getUiField();
            return f.addValue(e, value);
        } catch(Exception ex) {
            error("Error during input");
            return false;
        }
    }
    
    /**
     * 
     * @param b
     * @param args
     * @return
     */
    public boolean isPresent(Bindings b, String... args) {
        try {
            Elt e = getXR(b, args);
            waitForJStoLoad();
            getWebDriverWait(ConfigManager.getDriver(), 2L).until(ExpectedConditions.presenceOfElementLocated(e.getBy()));
            return true;
        } catch(Exception ex) {
            return false;
        }
    }    
    
    
    /**
     * 
     * @param b
     * @param args
     * @return
     */
    public String getText(Bindings b, String... args) {
            Elt e = getXR(b, args);
            WebElement el = findElement(e.getBy());
            return el.getText().trim();
    }
    
    /**
     * 
     * @param by
     * @return
     */
    public WebElement findElement(By by) {
        return ConfigManager.getDriver().findElement(by);
    }
    
    /**
     * 
     * @param delay
     */
    public void sleep(Long delay) {
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofMillis(delay));
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * 
     * @return
     */
    private Logger getLogger() {
		return log;
	}
    
    /**
     * 
     * @param message
     */
	private void debug(String message) {
		getLogger().debug(message);
	}
	
	/**
	 * 
	 * @param message
	 */
    public void error(String message) {
        log.error(message);
    }
    
    
    public  synchronized Elt getXR(Binding e, String... args) {
        return new Elt(e.getQueryType(), e.getFieldType(), MessageFormat.format(e.getQuery().trim().replace("'", "''"), args));
    }
    
    public void waitElementPresent(Elt e) {
        waitForJStoLoad();
        getWebDriverWait(ConfigManager.getDriver(), 2L).until(ExpectedConditions.presenceOfElementLocated(e.getBy()));
        sleepTight();
    }
    
    public WebDriverWait getWebDriverWait(WebDriver wd, Long timeout) {
        return new WebDriverWait(wd, timeout);
    }
    
    public void sleepTight() {
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofMillis(1000));
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public boolean waitForJStoLoad() {
        WebDriverWait wait = new WebDriverWait(ConfigManager.getDriver(), ConfigManager.getConfig().getTimeout());
        ExpectedCondition<Boolean> jsLoad = driver -> isJSandJQueryLoaded();

        Boolean result = null;
        try {
            result = wait.until(jsLoad);
        } catch(Exception e) {
            debug(e.toString());
        }

        return result == null ? false : result;
    }
    
    private boolean isJSandJQueryLoaded() {
        boolean return1;
        try {
            return1 = ((Long) ((JavascriptExecutor) ConfigManager.getDriver()).executeScript("return jQuery.active") == 0);
        } catch(Exception e) {
            return1 = true;
        }

        // wait for Javascript to load
        boolean return2 = executeJavaScript("return document.readyState").equals("complete");

        return return1 && return2;

    }
    
    
    public String executeJavaScript(String command) {
        WebDriver wd = ConfigManager.getDriver();
        Object result = null;
        JavascriptExecutor js = (JavascriptExecutor) wd;
        try {
            result = js.executeScript(command);
        } catch(Exception e) {
            debug(e.toString());
        }

        String jqueryResultat = "null";
        if (result != null) {
            jqueryResultat = result.toString();
        }
        debug("JQuery request result : " + jqueryResultat);

        return result == null ? null : result.toString();
    }
}
