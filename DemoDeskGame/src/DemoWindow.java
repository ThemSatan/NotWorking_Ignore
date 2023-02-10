public class DemoWindow {
    private String name;
    private boolean jeZakoupeno;
    private int oblibenost;

    public DemoWindow(String name, boolean jeZakoupeno, int oblibenost){
        this.name = name;
        this.jeZakoupeno = jeZakoupeno;
        this.oblibenost = oblibenost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isJeZakoupeno() {
        return jeZakoupeno;
    }

    public void setJeZakoupeno(boolean jeZakoupeno) {
        this.jeZakoupeno = jeZakoupeno;
    }

    public int getOblibenost() {
        return oblibenost;
    }

    public void setOblibenost(int oblibenost) {
        this.oblibenost = oblibenost;
    }
}
