package settingsClass;

public class SnakeSettingsSaveClass {

   private boolean showPatch;
   private boolean isAi;
   private int mapSizeX;
   private int mapSizeY;



    public SnakeSettingsSaveClass() {
        this.showPatch = false;
        this.isAi = false;
        this.mapSizeX = 50;
        this.mapSizeY = 50;
    }

    public SnakeSettingsSaveClass(boolean showPatch, boolean isAi, int mapSizeX, int mapSizeY) {
        this.showPatch = showPatch;
        this.isAi = isAi;
        this.mapSizeX = mapSizeX;
        this.mapSizeY = mapSizeY;
    }

    public SnakeSettingsSaveClass giveCopy(){

        return new SnakeSettingsSaveClass(showPatch,isAi,mapSizeX,mapSizeY);
    }


    public boolean isShowPatch() {
        return showPatch;
    }

    public void setShowPatch(boolean showPatch) {
        this.showPatch = showPatch;
    }

    public boolean isAi() {
        return isAi;
    }

    public void setAi(boolean ai) {
        isAi = ai;
    }

    public int getMapSizeX() {
        return mapSizeX;
    }

    public void setMapSizeX(int mapSizeX) {
        this.mapSizeX = mapSizeX;
    }

    public int getMapSizeY() {
        return mapSizeY;
    }

    public void setMapSizeY(int mapSizeY) {
        this.mapSizeY = mapSizeY;
    }

    public void SetDefaults() {
        isAi=false;
        showPatch=false;
        mapSizeX=50;
        mapSizeY=50;
    }
}
