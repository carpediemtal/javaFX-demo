package sample;

public class Hero {
    private String name;
    private String voiceLine;
    private int hp;

    public Hero() {
    }

    public Hero(String name, String voiceLine, int hp) {
        this.name = name;
        this.voiceLine = voiceLine;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoiceLine() {
        return voiceLine;
    }

    public void setVoiceLine(String voiceLine) {
        this.voiceLine = voiceLine;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
