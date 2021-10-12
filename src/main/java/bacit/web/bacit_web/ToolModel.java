package bacit.web.bacit_web;

public class ToolModel {
    private String toolName;
    private String toolInfo;
    private int toolPrice;

    public ToolModel(String toolName, String toolInfo, int price) {
        this.toolName = toolName;
        this.toolInfo = toolInfo;
        this.toolPrice = toolPrice;
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
}
