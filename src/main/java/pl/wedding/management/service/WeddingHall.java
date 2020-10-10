package pl.wedding.management.service;

public class WeddingHall {
    private String address;
    private String owner;
    private int max_guests;
    private boolean CarnivalHall;
    private boolean valentinesHall;
    private boolean communionHall;
    private boolean weddingHall;
    private boolean birthdayHall;
    private boolean funeralHall;
    private boolean newYearHall;
    private boolean lightsInTheHall;
    private boolean musicInTheHall;
    private boolean djInTheHall;
    private boolean orchestraInTheHall;
    private boolean dinnerInTheHall;
    private boolean danceInTheHall;
    private boolean alcoholInTheHall;

    public WeddingHall(String address, String owner, int max_guests, boolean carnivalHall, boolean valentinesHall, boolean communionHall, boolean weddingHall, boolean birthdayHall, boolean funeralHall, boolean newYearHall, boolean lightsInTheHall, boolean musicInTheHall, boolean djInTheHall, boolean orchestraInTheHall, boolean dinnerInTheHall, boolean danceInTheHall, boolean alcoholInTheHall) {
        this.address = address;
        this.owner = owner;
        this.max_guests = max_guests;
        CarnivalHall = carnivalHall;
        this.valentinesHall = valentinesHall;
        this.communionHall = communionHall;
        this.weddingHall = weddingHall;
        this.birthdayHall = birthdayHall;
        this.funeralHall = funeralHall;
        this.newYearHall = newYearHall;
        this.lightsInTheHall = lightsInTheHall;
        this.musicInTheHall = musicInTheHall;
        this.djInTheHall = djInTheHall;
        this.orchestraInTheHall = orchestraInTheHall;
        this.dinnerInTheHall = dinnerInTheHall;
        this.danceInTheHall = danceInTheHall;
        this.alcoholInTheHall = alcoholInTheHall;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getMax_guests() {
        return max_guests;
    }

    public void setMax_guests(int max_guests) {
        this.max_guests = max_guests;
    }

    public boolean isCarnivalHall() {
        return CarnivalHall;
    }

    public void setCarnivalHall(boolean carnivalHall) {
        CarnivalHall = carnivalHall;
    }

    public boolean isValentinesHall() {
        return valentinesHall;
    }

    public void setValentinesHall(boolean valentinesHall) {
        this.valentinesHall = valentinesHall;
    }

    public boolean isCommunionHall() {
        return communionHall;
    }

    public void setCommunionHall(boolean communionHall) {
        this.communionHall = communionHall;
    }

    public boolean isWeddingHall() {
        return weddingHall;
    }

    public void setWeddingHall(boolean weddingHall) {
        this.weddingHall = weddingHall;
    }

    public boolean isBirthdayHall() {
        return birthdayHall;
    }

    public void setBirthdayHall(boolean birthdayHall) {
        this.birthdayHall = birthdayHall;
    }

    public boolean isFuneralHall() {
        return funeralHall;
    }

    public void setFuneralHall(boolean funeralHall) {
        this.funeralHall = funeralHall;
    }

    public boolean isNewYearHall() {
        return newYearHall;
    }

    public void setNewYearHall(boolean newYearHall) {
        this.newYearHall = newYearHall;
    }

    public boolean isLightsInTheHall() {
        return lightsInTheHall;
    }

    public void setLightsInTheHall(boolean lightsInTheHall) {
        this.lightsInTheHall = lightsInTheHall;
    }

    public boolean isMusicInTheHall() {
        return musicInTheHall;
    }

    public void setMusicInTheHall(boolean musicInTheHall) {
        this.musicInTheHall = musicInTheHall;
    }

    public boolean isDjInTheHall() {
        return djInTheHall;
    }

    public void setDjInTheHall(boolean djInTheHall) {
        this.djInTheHall = djInTheHall;
    }

    public boolean isOrchestraInTheHall() {
        return orchestraInTheHall;
    }

    public void setOrchestraInTheHall(boolean orchestraInTheHall) {
        this.orchestraInTheHall = orchestraInTheHall;
    }

    public boolean isDinnerInTheHall() {
        return dinnerInTheHall;
    }

    public void setDinnerInTheHall(boolean dinnerInTheHall) {
        this.dinnerInTheHall = dinnerInTheHall;
    }

    public boolean isDanceInTheHall() {
        return danceInTheHall;
    }

    public void setDanceInTheHall(boolean danceInTheHall) {
        this.danceInTheHall = danceInTheHall;
    }

    public boolean isAlcoholInTheHall() {
        return alcoholInTheHall;
    }

    public void setAlcoholInTheHall(boolean alcoholInTheHall) {
        this.alcoholInTheHall = alcoholInTheHall;
    }

    @Override
    public String toString() {
        return "WeddingHall{" +
                "address='" + address + '\'' +
                ", owner='" + owner + '\'' +
                ", max_guests=" + max_guests +
                ", CarnivalHall=" + CarnivalHall +
                ", valentinesHall=" + valentinesHall +
                ", communionHall=" + communionHall +
                ", weddingHall=" + weddingHall +
                ", birthdayHall=" + birthdayHall +
                ", funeralHall=" + funeralHall +
                ", newYearHall=" + newYearHall +
                ", lightsInTheHall=" + lightsInTheHall +
                ", musicInTheHall=" + musicInTheHall +
                ", djInTheHall=" + djInTheHall +
                ", orchestraInTheHall=" + orchestraInTheHall +
                ", dinnerInTheHall=" + dinnerInTheHall +
                ", danceInTheHall=" + danceInTheHall +
                ", alcoholInTheHall=" + alcoholInTheHall +
                '}';
    }
}
