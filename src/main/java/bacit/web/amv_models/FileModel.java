package bacit.web.amv_models;

public class FileModel {

    private int fileID;
    private String name;
    private byte[] contents;
    private String contentType;
    private int toolID;

    public FileModel(int fileID, String name, byte[] contents, String contentType, int toolID) {

        this.fileID = fileID;
        this.name = name;
        this.contents = contents;
        this.contentType = contentType;
        this.toolID = toolID;
    }

    public FileModel() {

    }

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

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