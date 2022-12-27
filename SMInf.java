class SMInf{
  private String name;
  private int hp;
  private int x;
  private int y;

  SMInf(String name, int hp, int x, int y){
    this.name = name;
    this.hp = hp;
    this.x = x;
    this.y = y;
  }

  public void setName(String s){
    name = s;
  }
  public void setHP(int n){
    hp = n;
  }
  public void setX(int n){
    x = n;
  }
  public void setY(int n){
    y = n;
  }

  public String getName(){
    return name;
  }
  public int getHP(){
    return hp;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }

  @Override
  public String toString(){
    return "Name: " + name + ", HP: " + hp + ", place = (" + x + ", " + y + ")\n";
  }
}
