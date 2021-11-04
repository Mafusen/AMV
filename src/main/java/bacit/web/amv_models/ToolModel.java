package bacit.web.amv_models;

public class ToolModel {

    private int toolID;
    private String toolName;
    private String toolInfo;
    private int price;
    private boolean isActive;

    public ToolModel(int toolID, String toolName, String toolInfo, int price, boolean isActive){

        this.toolID = toolID;
        this.toolName = toolName;
        this.toolInfo = toolInfo;
        this.price = price;
        this.isActive = isActive;
    }

    public ToolModel(){}

    public int getToolID() {
        return toolID;
    }

    public void setToolID(int toolID) {
        this.toolID = toolID;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getToolInfo() {
        return toolInfo;
    }

    public void setToolInfo(String toolInfo) {
        this.toolInfo = toolInfo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
