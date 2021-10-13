package bacit.web.bacit_web;

//import java.io.InputStream;

import java.io.InputStream;

public class ToolModel {
    private String toolName;
    private String toolInfo;
    private int price;


    public ToolModel(String toolName, String toolInfo, int price, InputStream picture) {
        this.toolName = toolName;
        this.toolInfo = toolInfo;
        this.price = price;

    }

    public String getToolName(String toolName) {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getToolInfo(String toolInfo) {
        return toolInfo;
    }

    public void setToolInfo(String toolInfo) {
        this.toolInfo= toolInfo;
    }

    public int getPrice(int price){
        return price;
    }

    public void setPrice(int price){
        this.price=price;
    }
}
