package bacit.web.amv_models;

public class ToolFileModel {

    private int toolID;
    private String toolName;
    private String toolInfo;
    private int price;
    private boolean isActive;

    private int fileID;
    private String name;
    private byte[] contents;
    private String contentType;


    public ToolFileModel(int toolID, String toolName, String toolInfo, int price, boolean isActive, int fileID, String name, byte[] contents, String contentType) {
        this.toolID = toolID;
        this.toolName = toolName;
        this.toolInfo = toolInfo;
        this.price = price;
        this.isActive = isActive;

        this.fileID = fileID;
        this.name = name;
        this.contents = contents;
        this.contentType = contentType;

    }

    public ToolFileModel() {

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

    public int getFileID() {return fileID;}

    public void setFileID(int fileID) {this.fileID = fileID;}

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContents() {
        return contents;
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }

    public int getToolID(){return toolID; }

    public void setToolID(int toolID){this.toolID = toolID; }

}
