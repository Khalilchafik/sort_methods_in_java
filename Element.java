/* 
    *Auteur khalil CHAFIK
*/
public class Element {
    private String contenu;
    private int cle;

    public Element() {
        cle = 0;
        contenu = null;   
    }
    public Element(int a, String b) {
        this.cle = a;
        this.contenu = b;   
    }

    public String getContenu() {
        return contenu;
    }
    public int getCle() {
        return cle;
    }
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    public void setCle(int cle) {
        this.cle = cle;
    }
    public String toString() {
        String result = "[cle: " + getCle() + " ,contenu: " + getContenu() + " ]\n";
        return result;
    }
}
